/*
 * Copyright (c) 2018, Daniel Gultsch All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package eu.siacs.conversations.ui.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.Base64;
import android.util.Log;
import android.webkit.URLUtil;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eu.siacs.conversations.Config;
import eu.siacs.conversations.R;
import eu.siacs.conversations.ui.SettingsActivity;
import eu.siacs.conversations.ui.text.FixedURLSpan;
import eu.siacs.conversations.utils.GeoHelper;
import eu.siacs.conversations.utils.Patterns;
import eu.siacs.conversations.utils.XmppUri;

public class MyLinkify {

    private final static Pattern youtubePattern = Pattern.compile("(www\\.|m\\.)?(youtube\\.com|youtu\\.be|youtube-nocookie\\.com)/(((?!([\"'<])).)*)");
    private final static String youtubeURLPattern = "(?:youtube(?:-nocookie)?\\.com\\/(?:[^\\/\\n\\s]+\\/\\S+\\/|(?:v|e(?:mbed)?)\\/|\\S*?[?&]v=)|youtu\\.be\\/)([a-zA-Z0-9_-]{11})";

    public static boolean isYoutubeUrl(String url) {
        return !url.isEmpty() && url.matches("(?i:http|https):\\/\\/" + youtubePattern);
    }

    public static String getYoutubeVideoId(String url) {
        if (url == null || url.trim().length() <= 0) {
            return null;
        }
        final Pattern pattern = Pattern.compile(youtubeURLPattern, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String getYoutubeImageUrl(String url) {
        return "https://img.youtube.com/vi/" + getYoutubeVideoId(url) + "/0.jpg";
    }

    public static String replaceYoutube(Context context, String content) {
        return replaceYoutube(context, new SpannableStringBuilder(content)).toString();
    }

    public static SpannableStringBuilder replaceYoutube(Context context, SpannableStringBuilder content) {
        Matcher matcher = youtubePattern.matcher(content);
        if (useInvidious(context)) {
            while (matcher.find()) {
                final String youtubeId = matcher.group(3);
                if (matcher.group(2) != null && matcher.group(2).equals("youtu.be")) {
                    content = new SpannableStringBuilder(content.toString().replaceAll("https://" + Pattern.quote(matcher.group()), Matcher.quoteReplacement("https://" + invidiousHost(context) + "/watch?v=" + youtubeId + "&local=true")));
                } else {
                    content = new SpannableStringBuilder(content.toString().replaceAll("https://" + Pattern.quote(matcher.group()), Matcher.quoteReplacement("https://" + invidiousHost(context) + "/" + youtubeId + "&local=true")));
                }
            }
        }
        return content;
    }

    // https://github.com/M66B/FairEmail/blob/master/app/src/main/java/eu/faircode/email/UriHelper.java
    // https://github.com/newhouse/url-tracking-stripper
    private static final List<String> PARANOID_QUERY = Collections.unmodifiableList(Arrays.asList(
            // https://en.wikipedia.org/wiki/UTM_parameters
            "awt_a", // AWeber
            "awt_l", // AWeber
            "awt_m", // AWeber

            "icid", // Adobe
            "gclid", // Google
            "gclsrc", // Google ads
            "dclid", // DoubleClick (Google)
            "fbclid", // Facebook
            "igshid", // Instagram

            "mc_cid", // MailChimp
            "mc_eid", // MailChimp

            "zanpid", // Zanox (Awin)

            "kclickid" // https://support.freespee.com/hc/en-us/articles/202577831-Kenshoo-integration
    ));

    // https://github.com/snarfed/granary/blob/master/granary/facebook.py#L1789

    private static final List<String> FACEBOOK_WHITELIST_PATH = Collections.unmodifiableList(Arrays.asList(
            "/nd/", "/n/", "/story.php"
    ));

    private static final List<String> FACEBOOK_WHITELIST_QUERY = Collections.unmodifiableList(Arrays.asList(
            "story_fbid", "fbid", "id", "comment_id"
    ));

    public static SpannableString removeTrackingParameter(Uri uri) {
        if (uri.isOpaque())
            return new SpannableString(uri.toString());

        boolean changed = false;
        Uri url;
        Uri.Builder builder;
        if (uri.getHost() != null &&
                uri.getHost().endsWith("safelinks.protection.outlook.com") &&
                !TextUtils.isEmpty(uri.getQueryParameter("url"))) {
            changed = true;
            url = Uri.parse(uri.getQueryParameter("url"));
        } else if ("https".equals(uri.getScheme()) &&
                "smex-ctp.trendmicro.com".equals(uri.getHost()) &&
                "/wis/clicktime/v1/query".equals(uri.getPath()) &&
                !TextUtils.isEmpty(uri.getQueryParameter("url"))) {
            changed = true;
            url = Uri.parse(uri.getQueryParameter("url"));
        } else if ("https".equals(uri.getScheme()) &&
                "www.google.com".equals(uri.getHost()) &&
                uri.getPath() != null &&
                uri.getPath().startsWith("/amp/")) {
            // https://blog.amp.dev/2017/02/06/whats-in-an-amp-url/
            Uri result = null;
            String u = uri.toString();
            u = u.replace("https://www.google.com/amp/", "");
            int p = u.indexOf("/");
            while (p > 0) {
                String segment = u.substring(0, p);
                if (segment.contains(".")) {
                    result = Uri.parse("https://" + u);
                    break;
                }
                u = u.substring(p + 1);
                p = u.indexOf("/");
            }
            changed = (result != null);
            url = (result == null ? uri : result);
        } else if (uri.getQueryParameterNames().size() == 1) {
            // Sophos Email Appliance
            Uri result = null;
            String key = uri.getQueryParameterNames().iterator().next();
            if (TextUtils.isEmpty(uri.getQueryParameter(key)))
                try {
                    String data = new String(Base64.decode(key, Base64.DEFAULT));
                    int v = data.indexOf("ver=");
                    int u = data.indexOf("&&url=");
                    if (v == 0 && u > 0)
                        result = Uri.parse(URLDecoder.decode(data.substring(u + 6), StandardCharsets.UTF_8.name()));
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
            changed = (result != null);
            url = (result == null ? uri : result);
        } else
            url = uri;
        if (url.isOpaque()) {
            return new SpannableString(uri.toString());
        }
        builder = url.buildUpon();
        builder.clearQuery();
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null)
            host = host.toLowerCase(Locale.ROOT);
        if (path != null)
            path = path.toLowerCase(Locale.ROOT);
        boolean first = "www.facebook.com".equals(host);
        for (String key : url.getQueryParameterNames()) {
            // https://en.wikipedia.org/wiki/UTM_parameters
            // https://docs.oracle.com/en/cloud/saas/marketing/eloqua-user/Help/EloquaAsynchronousTrackingScripts/EloquaTrackingParameters.htm
            String lkey = key.toLowerCase(Locale.ROOT);
            if (PARANOID_QUERY.contains(lkey) ||
                    lkey.startsWith("utm_") ||
                    lkey.startsWith("elq") ||
                    ((host != null && host.endsWith("facebook.com")) &&
                            !first &&
                            FACEBOOK_WHITELIST_PATH.contains(path) &&
                            !FACEBOOK_WHITELIST_QUERY.contains(lkey)) ||
                    ("store.steampowered.com".equals(host) &&
                            "snr".equals(lkey)))
                changed = true;
            else if (!TextUtils.isEmpty(key))
                for (String value : url.getQueryParameters(key)) {
                    Log.d(Config.LOGTAG, "Query " + key + "=" + value);
                    Uri suri = Uri.parse(value);
                    if ("http".equals(suri.getScheme()) || "https".equals(suri.getScheme())) {
                        Uri s = Uri.parse(removeTrackingParameter(suri).toString());
                        if (s != null) {
                            changed = true;
                            value = s.toString();
                        }
                    }
                    builder.appendQueryParameter(key, value);
                }
            first = false;
        }
        return (changed ? new SpannableString(builder.build().toString()) : new SpannableString(uri.toString()));
    }

    private static boolean isValid(String url) {
        String urlstring = url;
        if (!urlstring.toLowerCase(Locale.US).startsWith("http://") && !urlstring.toLowerCase(Locale.US).startsWith("https://")) {
            urlstring = "https://" + url;
        }
        try {
            return URLUtil.isValidUrl(urlstring) && Patterns.WEB_URL.matcher(urlstring).matches();
        } catch (Exception e) {
            Log.d(Config.LOGTAG, "Could not use invidious host and using youtube-nocookie " + e);
        }
        return false;
    }

    private static final Linkify.TransformFilter WEBURL_TRANSFORM_FILTER = (matcher, url) -> {
        if (url == null) {
            return null;
        }
        final String lcUrl = url.toLowerCase(Locale.US);
        if (lcUrl.startsWith("http://") || lcUrl.startsWith("https://")) {
            return removeTrailingBracket(removeTrackingParameter(Uri.parse(url)).toString());
        } else {
            return "http://" + removeTrailingBracket(removeTrackingParameter(Uri.parse(url)).toString());
        }
    };

    public static String removeTrailingBracket(final String url) {
        int numOpenBrackets = 0;
        for (char c : url.toCharArray()) {
            if (c == '(') {
                ++numOpenBrackets;
            } else if (c == ')') {
                --numOpenBrackets;
            }
        }
        if (numOpenBrackets != 0 && url.charAt(url.length() - 1) == ')') {
            return url.substring(0, url.length() - 1);
        } else {
            return url;
        }
    }

    private static final Linkify.MatchFilter WEBURL_MATCH_FILTER = (cs, start, end) -> {
        if (start > 0) {
            if (cs.charAt(start - 1) == '@' || cs.charAt(start - 1) == '.'
                    || cs.subSequence(Math.max(0, start - 3), start).equals("://")) {
                return false;
            }
        }
        if (end < cs.length()) {
            // Reject strings that were probably matched only because they contain a dot followed by
            // by some known TLD (see also comment for WORD_BOUNDARY in Patterns.java)
            if (isAlphabetic(cs.charAt(end - 1)) && isAlphabetic(cs.charAt(end))) {
                return false;
            }
        }
        return true;
    };

    private static final Linkify.MatchFilter XMPPURI_MATCH_FILTER = (s, start, end) -> {
        XmppUri uri = new XmppUri(s.subSequence(start, end).toString());
        return uri.isValidJid();
    };

    private static boolean isAlphabetic(final int code) {
        return Character.isAlphabetic(code);
    }

    private static String invidiousHost(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String invidioushost = sharedPreferences.getString(SettingsActivity.INVIDIOUS_HOST, context.getResources().getString(R.string.invidious_host));
        if (invidioushost.length() == 0) {
            invidioushost = context.getResources().getString(R.string.invidious_host);
        }
        return invidioushost;
    }

    private static boolean useInvidious(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(SettingsActivity.USE_INVIDIOUS, context.getResources().getBoolean(R.bool.use_invidious));
    }

    public static void addLinks(Editable body, boolean includeGeo) {
        Linkify.addLinks(body, Patterns.XMPP_PATTERN, "xmpp", XMPPURI_MATCH_FILTER, null);
        Linkify.addLinks(body, Patterns.AUTOLINK_WEB_URL, "http", WEBURL_MATCH_FILTER, WEBURL_TRANSFORM_FILTER);
        if (includeGeo) {
            Linkify.addLinks(body, GeoHelper.GEO_URI, "geo");
        }
        FixedURLSpan.fix(body);
    }
}