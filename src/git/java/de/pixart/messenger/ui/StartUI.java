package de.pixart.messenger.ui;

import static android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import com.google.common.base.Stopwatch;


import java.util.concurrent.Executor;

import eu.siacs.conversations.Config;
import eu.siacs.conversations.R;
import eu.siacs.conversations.persistance.DatabaseBackend;
import eu.siacs.conversations.services.XmppConnectionService;
import eu.siacs.conversations.ui.ConversationsActivity;
import eu.siacs.conversations.utils.Compatibility;
import eu.siacs.conversations.utils.ThemeHelper;

public class StartUI extends PermissionsActivity
        implements PermissionsActivity.OnPermissionGranted {

    private Handler handler = new Handler();
    private Executor executor = new Executor() {
        @Override
        public void execute(Runnable command) {
            handler.post(command);
        }
    };

    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // fingerprint
        try {
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("FINGERPRINT")
                .setSubtitle("Log in")
                .setNegativeButtonText("EXIT")
                .setAllowedAuthenticators(BIOMETRIC_STRONG)
                .build();

        } catch (Exception e) {
            e.printStackTrace();
        }

        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                Log.d("MY_APP_TAG", "App can authenticate using biometrics.");
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Log.e("MY_APP_TAG", "No biometric features available on this device.");
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Log.e("MY_APP_TAG", "Biometric features are currently unavailable.");
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                // Prompts the user to create credentials that your app accepts.
                final Intent enrollIntent = new Intent(Settings.ACTION_BIOMETRIC_ENROLL);
                enrollIntent.putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                        BIOMETRIC_STRONG);
                startActivityForResult(enrollIntent, 0);
                break;
        }

        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(StartUI.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                                "Authentication error: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                setContentView(R.layout.activity_start_ui);
                Toast.makeText(getApplicationContext(),
                        "Authentication succeeded!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Authentication failed",
                                Toast.LENGTH_SHORT).show();
            }
        });

        biometricPrompt.authenticate(promptInfo);


        setTheme(ThemeHelper.findDialog(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!isRunning(XmppConnectionService.class)) {
            new optimizeDB(this).execute();
        } else {
            requestNeededPermissions();
        }
        // IntroHelper.showIntro(this, false);
    }

    private void requestNeededPermissions() {
        if (Compatibility.runsTwentyThree()) {
            if (!checkStoragePermission()) {
                requestStoragePermission(this);
            }
            if (Compatibility.runsAndTargetsThirty(this)) {
                requestAllFilesAccess(this);
            }
            if (checkStoragePermission() && !Compatibility.runsAndTargetsThirty(this)) {
                next(this);
            }
        } else {
            next(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPermissionGranted() {
        next(this);
    }

    public static void next(final Activity activity) {
        String PREF_FIRST_START = "FirstStart";
        SharedPreferences FirstStart = activity.getSharedPreferences(PREF_FIRST_START, Context.MODE_PRIVATE);
        long FirstStartTime = FirstStart.getLong(PREF_FIRST_START, 0);
        Intent intent = new Intent(activity, ConversationsActivity.class);
        intent.putExtra(PREF_FIRST_START, FirstStartTime);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.animator.fade_in, R.animator.fade_out);
        activity.finish();
            
        }

    private boolean isRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public class optimizeDB extends AsyncTask<Void, Void, Void> {

        StartUI activity;
        AlertDialog.Builder dialog;

        public optimizeDB(StartUI startUI) {
            activity = startUI;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new AlertDialog.Builder(activity);
            dialog.setTitle(getString(R.string.app_name));
            dialog.setMessage(R.string.optimize_database);
            dialog.setCancelable(false);
            dialog.create().show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try (DatabaseBackend mDatabaseBackend = DatabaseBackend.getInstance(getBaseContext())) {
                Log.d(Config.LOGTAG, "Optimizing database");
                final Stopwatch stopwatch = Stopwatch.createStarted();
                final SQLiteDatabase db = mDatabaseBackend.getWritableDatabase();
                db.execSQL("ANALYZE");
                //db.execSQL("VACUUM"); // todo should we do it?
                db.execSQL("PRAGMA optimize");
                Log.d(Config.LOGTAG, String.format("Optimized database in %s", stopwatch.stop()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            requestNeededPermissions();
        }
    }
}