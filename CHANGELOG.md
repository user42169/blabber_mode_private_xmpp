### Changelog

#### Version 3.1.4
* play movies in PIP mode on back key (blabber.im)
* fix wrong avatar being shown for group chats
* always ask for battery optimizations opt-out
* fix automatic updater
* use webrtc from threema
* bug fixes

#### Version 3.1.3
* set local only flag on 'x connected accounts' notifications
* bug fixes

#### Version 3.1.2
* set camera app in preference screen (attachments)
* bug fixes

#### Version 3.1.1
* update WebRTC
* fix crash ob older devices
* use mod_push_appserver instead of p2 (blabber.im)
* increase fast video upload to 15 MiB (without transcoding)
* small bug fixes

#### Version 3.1.0
* remove Android 4 support
* update WebRTC
* show channel avatars and number of users for channel discovery (blabber.im)
* add ability to ex-/import app settings (blabber.im)
* implement message retraction XEP-0424 (blabber.im)
* implement message history for corrected messages (blabber.im)
* add text formatting buttons in chat (blabber.im)
* hide text formatting in chats (blabber.im)
* add ability to delete own avatar (blabber.im)
* show black bars when remote video does not match aspect ratio of screen
* improve search performance
* bug fixes

#### Version 3.0.8
* pause the current voice message when you move your device away from your ear
* remove blabber.im XMPP service

#### Version 3.0.7
* bug fixes for PlayStore version

#### Version 3.0.6
* show message in chat, during video transcoding (blabber.im)
* Fixed 'No Connectivity' issues on Android 7.1
* bug fixes

#### Version 3.0.5
* improve compatibility with non libwebrtc WebRTC implementations
* improve memory management (blabber.im)
* ui improvements (blabber.im)
* fix HTTP up/download for users that don’t trust system CAs
* various bug fixes around Tor support
* improve call compatibility with Dino
* bug fixes

#### Version 3.0.4
* fix OpenPGP key id discovery for OpenKeychain 5.6+
* properly verify punycode TLS certificates
* improve stability of RTP session establishment (calling)
* verify A/V calls with preexisting OMEMO sessions
* add memory management in attachment settings (blabber.im)
* add setting to delete files older than x days (blabber.im)
* show message on devices with Android 4 that they are outdated (blabber.im)
* bug fixes

#### Version 3.0.3

* add custom tabs (blabber.im)
* show video/gif duration in preview (blabber.im)
* auto download all attachments (blabber.im)
* show notification on muc invites as private messages (blabber.im)
* offer Easy Invite generation on supporting servers
* display GIFs send from Movim
* store avatars in cache
* fixed connectivity issues when different accounts used different SCRAM mechanisms
* add support for SCRAM-SHA-512
* allow P2P (Jingle) file transfer with self contact
* show call button for offline contacts if they previously announced support
* bug fixes

#### Version 3.0.2
* play ogg files in audio player
* small UI improvements
* improve startup performance
* rework black theme
* bug fixes

#### Version 3.0.1
#### Version 3.0.0
* Pix-Art Messenger is now blabber.im
* rework missed call notifications (blabber.im)
* a lot UI improvements (blabber.im)
* show backups from other messengers (blabber.im)
* customize notifications for each contact/channel > Android O (blabber.im)
* automatically remove URL tracking parameters for sent/received links (blabber.im)
* search individual conversations
* notify user if message delivery fails
* remember display names (nicks) from Quicksy users across restarts
* add button to start Orbot (Tor) from notification if necessary
* handle GPX files
* fixed search on Android <= 5
* optimize memory consumption
* bug fixes

#### Version 2.5.2
* fix crash on PlayStore version  

#### Version 2.5.1
* rework lastseen and don't show offline as online (blabber.im)
* improve video quality a bit (blabber.im)
* add ability to reject all contact requests via long press (blabber.im)
* colorize pinned chats (blabber.im)
* add 'Return to chat' to audio call screen
* improve keyboard shortcuts
* improve performance for backup restore
* bug fixes

#### Version 2.5.0
* remove OTR encryption (blabber.im)
* show help button if A/V call fails
* fixed some annoying crashes
* fixed Jingle connections (file transfer + calls) with bare JIDs
* fixed notifications not showing up under certain conditions
* fixed compatibility issues and crashes related to A/V calls

#### Version 2.4.1
* move call icon to the left in order to keep other toolbar icons in a consistent place
* show call duration during audio calls
* tie breaking for A/V calls (the same two people calling each other at the same time)
* add ability to pin chats on top (add to favorites)
* offer to record voice message when callee is busy
* reduce echo during calls on some devices
* fix login when passwords contains special characters
* play dial and busy tones on speaker during video calls
* move channel discovery choice to ChannelDiscoveryActivity menu (blabber.im)
* colorize accept/dismiss actions in call notification (blabber.im)
* don't end call on pressing back key (blabber.im)
* show used account for calls (blabber.im)
* notify on missed calls (blabber.im)
* bug fixes

#### Version 2.4.0
* Audio/Video calls (Requires server support in form of STUN and TURN servers discoverable via XEP-0215)
* bug fixes

#### Version 2.3.7
* bug fixes

#### Version 2.3.6
* bug fixes

#### Version 2.3.5
* start removing OTR
* rework conference and contact details (big avatar is available via long click) (blabber.im)
* resume download of OMEMO encrypted files
* channels now use '#' as symbol in avatar
* support for ?register and ?register;preauth XMPP uri parameters
* update connection settings
* use ExoPlayer for video playback (blabber.im)
* show artist - title for audio files (blabber.im)
* show PDF previews (blabber.im)
* minor UI improvements (blabber.im)
* use 12 byte IV for OMEMO
* a lot of bug fixes

#### Version 2.3.4
* fixes for Jingle IBB file transfer
* fixes for repeated corrections filling up the database
* switched to Last Message Correction v1.1
* increase mam messages catchup (blabber.im)
* bug fixes

#### Version 2.3.3
* fix missing send button

#### Version 2.3.2
* fix shareWithActivity

#### Version 2.3.1
* bug fixes

#### Version 2.3.0
* show name in quotes (blabber.im)
* introduce theme based on systems theme (blabber.im)
* increase default video quality (720p instead of 360p) (blabber.im)
* replace YouTube links with Invidious links (blabber.im)
* rework profile view (blabber.im)
* introduce app intro and some help screens (blabber.im)
* fixed minor security issues
* share XMPP uri from channel search by long pressing a result
* fixed OMEMO self healing (after backup restore) on servers w/o MAM
* introduce expert setting to perform channel discovery on local server instead of [search.jabber.network](https://search.jabber.network)
* introduce new orange theme color (blabber.im)
* bug fixes

#### Version 2.2.9
* bug fixes

#### Version 2.2.8
* stability improvements for group chats and channels
* allow backups to be restored from anywhere
* make short vibrate in open chat configurable and respect silent mode (blabber.im)
* fixes for Jingle file transfer
* fixed some rare crashes
* when sharing a message from and to messenger insert it as quote
* find orphaned files and show them in the chat again instead of showing them deleted (blabber.im)
* introduce file uploads/downloads with queue (blabber.im)
* fixed connection issues over Tor
* P2P file transfer (Jingle) now offers direct candidates
* support XEP-0396: Jingle Encrypted Transports - OMEMO
* bug fixes

#### Version 2.2.7
* fixing crashes

#### Version 2.2.6
* fixing connection issues
* fix broken updater

#### Version 2.2.5
* make backup compatible to Conversations (only works for Android >= 8) (blabber.im)
* bug fix

#### Version 2.2.4
* added channel search via search.jabbercat.org
* reworked onboarding screens
* warn when trying to enter domain address or channel address in Add Contact dialog
* set own OMEMO devices to inactive after not seeing them for 60 days. (was 7 days)
* bug fixes for peer to peer file transfer (Jingle)
* fixed server info for unlimited/unknown max file size
* make backup compatible to Conversations (blabber.im)
* performance improvements
* bug fixes

#### Version 2.2.3
* bug fixes

#### Version 2.2.2
* add activity to define some important privacy settings on first start (blabber.im)
* add ability to delete account also from server (blabber.im)
* add ability to kick users from room and not just ban them (blabber.im)
* bug fixes

#### Version 2.2.1
* use extra activity for enter name during registration (blabber.im)
* bug fixes

#### Version 2.2.0
* add ability to set/edit nickname in own profile (blabber.im)
* add ability to configure autojoin flag in groupchat details (blabber.im)
* support for Android 9 'message style' notifications
* OMEMO stability improvements
* do not show deleted files in media browser
* added 'Keep Original' as image and video quality choice (blabber.im)
* fixed avatar not being refreshed in group chats
* make users avatars configurable (prefer either from xmpp or addressbook) (blabber.im)
* integrate last message deletion on remote devices (server and client need support for message correction) (blabber.im)
* clearly distinguish between (private) group chats and (public) channels
* redesigned participants view for group chats and channels
* redesigned create new contact/group chat/channel flow in Start Conversation screen
* reworked backup & restore
* use Ad-Hoc Commands to invite new users (blabber.im)
* show link preview in chat (blabber.im)
* bug fixes

#### Version 2.1.5
* improved handling of bookmark nicks
* long press on 'allow' or 'add back' snackbar to bring up 'reject'
* let the user forbid android from taking screenshots (blabber.im)
* make PEP avatars public to play nice with Prosody 0.11
* fixed re-sending failed files in group chats
* OMEMO stability improvements
* context menu when long pressing avatar in 1:1 chat
* synchronize group chat join/leaves across multiple clients
* fixed sending PGP encrypted messages from quick reply
* bug fixes

#### Version 2.1.4
* fix crash with xmpp uris
 
#### Version 2.1.3
* bring back gif support in internal mediaviewer
* fixed group chat mentions when nick ends in . (dot)
* fixed not asking for permissions after direct share
* fixed CVE-2018-18467
* implement message deletion (blabber.im)
* bug fixes

#### Version 2.1.2
* fix crash with updater

#### Version 2.1.1
* make quick actions/attachment choice configurable (blabber.im)
* add a hideable separate quick button for voice messages (blabber.im)
* switch between speaker/earpiece while playing audios/voice messages
* store bookmarks in PEP if server has ability to convert to old bookmarks
* show Jabber IDs from address book in address book
* preview and ask for confirmation before sending media files
* view per conversation media files in contact and conference details screens
* enable foreground service by default for Android 8 (notification can be disabled by long pressing it)
* reworked MediaViewer (blabber.im)
* support TLSv1.3 (ejabberd ≤ 18.06 is incompatible with openssl 1.1.1 - Update ejabberd or downgrade openssl if you get ›Stream opening error‹)
* add push messages for playstore versions
* bug fixes

#### Version 2.1.0
* use group chat name as primary identifier
* upload group chat avatar on compatible servers
* show group name and subject in group chat details
* UI improvements
* introduce Expert Setting to enable direct search
* introduce Paste As Quote on Android 6+
* attempt to delete broken bundles from PEP
* offer Paste as quote for HTML content
* use SNI on STARTTLS to fix gtalk
* use Consistent Color Generation (XEP-0392)
* bug fixes

#### Version 2.0.2
* bug fixes especially for Android 4

#### Version 2.0.1
* improved recording quality
* let the user select a public server for account creation (blabber.im)
* add possibility to de-/activate accounts in multi account mode
* bug fixes 

#### Version 2.0.0
* highlight irregular unicode code blocks in Jabber IDs
* integrate QR code scanner (requires camera permission)
* removed support for customizable resources
* reworked message search
* added splash screen at startup
* integrate dark theme
* keep OTR, but without further development and support, just for compatibility (blabber.im)
* added configurable font size
* added global OMEMO preference
* added scroll to bottom button
* added contact button as android widget
* only mark visible messages as read
* a lot of bug fixes

#### Version 1.22.1
* show extended/TOR connection options in expert settings
* bug fixes

#### Version 1.22.0
* integrated expert option to enable multiple account (blabber.im)
* some UI improvements
* improved MAM support
* bug fixes 

#### Version 1.21.3
* small self messages improvement
* small notification improvement
* bug fixes

#### Version 1.21.2
* bug fixes

#### Version 1.21.1
* don't use integrated updater if Messenger is installed from F-Droid (blabber.im)
* check if app installs from unknown sources are allowed, if not open settings to allow this (blabber.im)
* show hint in chatview if private message is activated (blabber.im)
* send delivery receipts after MAM catchup
* reduce number of wake locks
* add possibility to destroy group chats (blabber.im)
* show progress dialog while downloading update with internal updater (blabber.im)
* implemented message search (blabber.im)
* improved self chat
* bug fixes

#### Version 1.21.0
* replaced google maps location service with open street map services via leaflet (blabber.im)
* let screen on while playing audio files (blabber.im)
* add Turkish translations
* bug fixes

#### Version 1.20.3
* show icon instead of image preview in conversation overview
* fixed loop when trying to decrypt with YubiKey
* Removed NFC support
* Fixed OMEMO device list no being announced
* bug fixes

#### Version 1.20.2
* bug fixes

#### Version 1.20.1
* bug fixes

#### Version 1.20.0
* reworked AppUpdater and show a notification if there is an update available (blabber.im)
* some UI and performance improvements
* add french and spanish translations
* text markup *bold*, _italic_,`monospace` and ~strikethrough~
* fixed 'No permission to access …' when opening files shared from the SD card
* always open URLs in new tab
* bring back quick share (default off) and return to previous app after sharing
* send and show read markers in private, non-anonymous groups
* warn if chat is unencrypted and switch to OMEMO if available after pressing OK (warning can be disabled in settings) (blabber.im)
* support sending and receiving opus file
* bug fixes


#### Version 1.19.2
* reworked inline player for audio messages
* long press the 'add back' button to show block menu
* foregroundservice can be switched off 
* bug fixes

#### Version 1.19.1
* fixed OTR encrypted file transfer
* bug fixes

#### Version 1.19.0
* Added 'App Shortcuts' to quickly access frequent contacts
* Use DNSSEC to verify hostname instead of domain in certificate
* Setting to enable Heads-up notifications
* Made DNSSEC hostname validation opt-in
* work around for OpensFire's self signed certs
* use VPN's DNS servers first
* fixed connection loop on Android < 4.4
* presence subscription no longer required for OMEMO on compatible servers
* bug fixes


#### Version 1.18.2
* colorize send button only after history is caught up
* improved MAM catchup strategy
* bug fixes

#### Version 1.18.1
* limited GPG encryption for MUC offline members
* show extended connection settings for open version in export settings
* fixed landscape layout problems for tablets
* fixed UI freezes during connection timeout
* fixed notification sound playing twice
* fixed conversations being marked as read
* removed 'copy text' in favor of 'select text' and 'share with'
* bug fixes

#### Version 1.18.0
* enable OTR and OpenPGP again
* fix bug with updater on devices < SDK 21 (blabber.im)
* Show colored contact names for their presence status (via settings)
* treat URL as file if URL is in oob or contains key
* added support for Android Auto
* fixed HTTP Download over Tor
* work around for nimbuzz.com MUCs
* bug fixes

#### Version 1.17.1
* grey out offline contacts in StartConversation (blabber.im)
* change emoji library which supports newer emojis
* change avatar images to circles
* Switch Aztec to QR for faster scans
* make automatic fullscreen media rotation configurable (blabber.im)
* open version can use tor networks
* make image compression configurable (blabber.im)
* show read/received markers in chatlist (blabber.im)
* OMEMO: put auth tag into key (verify auth tag as well)
* offer to block entire domain in message from stanger snackbar
* bug fixes

#### Version 1.17.0
* add date bubbles in chat view (blabber.im)
* show last used resource in contact details
* make brightness overwrite in image/video viewer configurable (blabber.im)
* make video resolution configurable (blabber.im)
* do not notify for messages from strangers by default
* blocking a JID closes the corresponding conversation
* show message sender in conversation overview
* Support for the latest MAM namespace
* Icons for attach menu
* send typing notifications in private, non-anonymous MUCs
* change media directory names (blabber.im)
* bug fixes

#### Version 1.16.5
* show read marker in whisper messages
* bug fixes 

#### Version 1.16.4
* show failed file uploads in chatlist (blabber.im)
* resend failed file uploads automatically (blabber.im)
* preview files in chatlist
* move (un)mute settings to contact-/conference details
* UI performance fixes
* bug fixes

#### Version 1.16.3
* don't use jingle as fallback if file is too big
* bug fixes

#### Version 1.16.2
* show app name and version from shared apk files
* add ability to compress videos with 720p and not only bigger ones

#### Version 1.16.1
* bug fixes

#### Version 1.16.0
* show unread messages in chatlist (blabber.im)
* increase image size to 4k UHD (blabber.im)
* add support for GIF files
* reworked video compression (blabber.im)
* reworked app updater
* bug fixes

#### Version 1.15.4
* improve video compression quality (blabber.im)
* support for POSH (RFC7711)
* support for quoting messages (via select text)
* verified messages show shield icon; unverified messages show lock
* bug fixes

#### Version 1.15.3
* new [Blind Trust Before Verification](https://gultsch.de/trust.html) mode
* easily share Barcode and XMPP uri from Account details
* bug fixes

#### Version 1.15.2
* automatically remove old OMEMO devices after 7 days
* bug fixes

#### Version 1.15.1
* introduces preference option to choose if videos should be compressed (always, automatically, never)
* bug fixes

#### Version 1.15.0
* make OMEMO working with other clients
* make OMEMO encryption standard for 1:1 chats as default
* start navigation app directly from show location activity (blabber.im)
* show map preview on shared locations (blabber.im)
* show contacts name on shared VCARDs (blabber.im)
* send text directly via ShareWithActivity
* bug fixes 

#### Version 1.14.5
* error message accessible via context menu for failed messages
* don't include pgp signature in anonymous mucs
* bug fixes

#### Version 1.14.4
* make error notification dismissable
* bug fixes

#### Version 1.14.3
* set different auto-download-sizes for mobile, roaming and WiFi connections (blabber.im)
* add ability to report errors and bugs directly from menu (blabber.im)
* XEP-0377: Sblabber.im Reporting
* fix rare start up crashes
* bug fixes

#### Version 1.14.2
* support ANONYMOUS SASL
* add custom Emojis
* scroll long actionbar titles
* some performance improvements
* some video compression improvements (blabber.im)
* bug fixes

#### Version 1.14.1
* fix crash on taking photos directly within the app

#### Version 1.14.0
* compress videos > 5 MB before sending
* improvments for Android N
* quick reply to notifications on Android N
* don't download avatars and files when data saver is on
* bug fixes

#### Version 1.13.9
* add icons for files in chat view
* reworked backup service to automatically backup database encrypted to local storage at 4 am each day (blabber.im)
* make human readable log export optional (blabber.im)
* bug fixes

#### Version 1.13.8
* bug fixes

#### Version 1.13.7
* improved video thumbnails in chatlist
* bug fixes

#### Version 1.13.6
* share image/video directly from fullscreen view (blabber.im)
* show online status in foreground service
* support jingle ft:4
* show contact as DND if one resource is
* bug fixes

#### Version 1.13.5
* add image preview before sending single images directly (blabber.im)
* add vibrate notification when app is open (blabber.im)
* hide actionbar in fullscreen image/video view (blabber.im)
* bug fixes

#### Version 1.13.4
* new PGP decryption logic
* bug fixes

#### Version 1.13.3
* new permission check and request at startup (blabber.im)
* bug fixes

#### Version 1.13.2
* refactored lastseen info
* bug fixes

#### Version 1.13.1
* bug fixes

#### Version 1.13.0
* changed applicationId (blabber.im)
* play videos directly without touching play button (blabber.im)
* add database importer from local storage as backup (blabber.im)
* changed files directories and names (blabber.im)
* bug fixes

#### Version 1.12.6
* bug fixes
* add database exporter to local storage as backup (blabber.im)

#### Version 1.12.5
* bug fixes

#### Version 1.12.4
* new create conference dialog
* show first unread message on top
* show geo uri as links
* circumvent long message DOS
* integrate simple videoplayer and image viewer (blabber.im)

#### Version 1.12.3
* show offline members in conferences
* various bug fixes

#### Version 1.12.2
* make omemo default when all resources support it
* show presence of other resources as template
* start typing in StartConversationsActivity to search
* show addresses in locations (blabber.im)
* show video previews in chats
* various bug fixes and improvements
* fixed pgp presence signing

#### Version 1.12.1
* expert setting to modify presence
* added simple audio player (blabber.im)
* added audio recorder (blabber.im)
* added location services (blabber.im)
* changed theme color from green to blue (blabber.im)
* small bug fixes

#### Version 1.12.0
* added welcome screen for first start
* use IP/Port instead of query DNS to improve connection performance
* UI improvements
* bug fixes

#### Version 1.11.7
* Share xmpp uri from conference details
* add setting to allow quick sharing
* use material design icons for android < lollipop
* make foreground service always activated (blabber.im)
* disable account deactivation
* UI improvements
* various bug fixes

#### Version 1.11.6
* added preference to disable notification light
* various bug fixes

#### Version 1.11.5
* check file ownership to not accidentally share private files

#### Version 1.11.4
* fixed a bug where contacts are shown as offline
* improved broken PEP detection
* check maximum file size when using HTTP Upload
* properly calculate caps hash
* some UI improvements

#### Version 1.11.3
* only add image files to media scanner
* allow to delete files
* various bug fixes

#### Version 1.11.2
* added voice recorder to plugins
* bug fixes

#### Version 1.11.1
* fixed some bugs when sharing files with Conversations

#### Version 1.11.0
* OMEMO encrypted conferences
* resend failed filetransfers automatically
* Support for XEP-0357: Push Notifications
* disable support for only one account

#### Version 1.10.1
* support only one account
* various bug fixes

#### Version 1.10.0
* Support for XEP-0308: Last Message Correction

#### Version 1.9.4
* prevent cleared Conversations from reloading history with MAM
* various MAM fixes

#### Version 1.9.3
* expert setting that enables host and port configuration
* expert setting opt-out of bookmark autojoin handling
* offer to rejoin a conference after server sent unavailable
* internal rewrites and optimizations

#### Version 1.9.2
* prevent startup crash on Sailfish OS
* minor bug fixes
* removed contact-/conferece-details button (blabber.im)
* touch contact name or conference name in action bar opens contact-/conference-details (blabber.im)

#### Version 1.9.1
* minor bug fixes incl. a workaround for nimbuzz.com

#### Version 1.9.0
* Per conference notification settings
* Let user decide whether to compress pictures
* Support for XEP-0368
* Ask user to exclude Conversations from battery optimizations

#### Version 1.8.4
* prompt to trust own OMEMO devices
* fixed rotation issues in avatar publication
* invite non-contact JIDs to conferences

#### Version 1.8.3
* brought text selection back
* hide settings, manage accounts and updater in all menus except in the main activity
* bug fixes

#### Version 1.8.2
* fixed stuck at 'connecting...' bug
* make message box behave correctly with multiple links
* bug fixes

#### Version 1.8.1
* enabled direct share on Android 6.0
* ask for permissions on Android 6.0
* notify on MAM catchup messages
* bug fixes

#### Version 1.8.0
* TOR/ORBOT support in advanced settings
* show vcard avatars of participants in a conference
* Own contact picture in tile for conferences with only one other occupant
* added button to updater dialog to show full changelog
* added plugin loader to settings
* fixed PGP encrypted file transfer
* bug fixes

#### Versrion 1.7.3
* changed app name from Conversations to Pix-Art Messenger (blabber.im)
* changed chat background to light yellow
* added own name for sent locations (blabber.im)

#### Version 1.7.2
* let users crop their avatars
* bug fixes

#### Versrion 1.7.1
* performance improvements when opening a conversation
* bug fixes

#### Version 1.7.0
* redownload deleted files from HTTP hosts
* bug fixes
* show lastseen info as subitle in single chats

#### Version 1.6.13
* bugfixes
* fetching MUC history via MAM
* Expert setting to automatically set presence
* show client-to-client encryption in chatview
* added changelog to AppUpdater dialog
* delete old version files in download folder on updating
* use standard namespace for file transfers
* CAPTCHA support
* SASL EXTERNAL (client certifiates)

#### Version 1.6.12
* added blue tick as read indicator
* tab completion for MUC nicks
* history export to SD card
* bug fixes

#### Version 1.6.11
* optimized app updater and increased app update check period to once a day

#### Version 1.6.10
* fixed facebook login
* fixed bug with ejabberd mam
* run app updater automatically

#### Version 1.6.9
* basic keyboard support
* bug fixes
* update checker with in app version updates

#### Version 1.6.8
* reworked 'enter is send' setting
* reworked DNS server discovery on lolipop devices
* various bug fixes

#### Version 1.6.7
* bug fixes

#### Version 1.6.6
* best 1.6 release yet

#### Version 1.6.5
* more OMEMO fixes

#### Version 1.6.4
* setting to enable white chat bubbles
* limit OMEMO key publish attempts to work around broken PEP
* various bug fixes

#### Version 1.6.3
* bug fixes

#### Version 1.6.2
* fixed issues with connection time out when server does not support ping

#### Version 1.6.1
* fixed crashes

#### Version 1.6.0
* new multi-end-to-multi-end encryption method
* show unexpected encryption changes as red chat bubbles
* always notify in private/non-anonymous conferences
* some bugfixes
* hard coded pix-art.de as standard server

#### Version 1.5.2
* added new message bubbles
* added subtitles to chatviews in ActionBar to display typing info in single chats and participant names in conferences
* some bug fixes

#### Version 1.5.1
* fixed rare crashes
* improved otr support
* moved typing info to ActionBar

#### Version 1.5.0
* new file transfer mode to offline contacts and conferences for files smaller than 20 MB: upload files to HTTP host and share them in MUCs. requires new [HttpUploadComponent](https://github.com/siacs/HttpUploadComponent) on server side
* default image format is JPEG
* small layout modifications with bigger avatars
* show contacts name in locations shared in conferences

#### Version 1.4.5
* fixes to message parser to not display some ejabberd muc status messages

#### Version 1.4.4
* added unread count badges on supported devices
* rewrote message parser

#### Version 1.4.0
* send button turns into quick action button to offer faster access to take photo, send location or record audio
* visually separate merged messages
* faster reconnects of failed accounts after network switches 
* r/o vcard avatars for contacts
* various bug fixes

#### Version 1.3.0
* swipe conversations to end them
* quickly enable / disable account via slider
* share multiple images at once
* expert option to distrust system CAs
* mlink compatibility
* bug fixes

#### Version 1.2.0
* Send current location. (requires [plugin](https://play.google.com/store/apps/details?id=eu.siacs.conversations.sharelocation))
* Invite multiple contacts at once
* performance improvements
* bug fixes

#### Version 1.1.0
* Typing notifications (must be turned on in settings)
* Various UI performance improvements
* bug fixes

#### Version 1.0.4
* load avatars asynchronously on start up
* support for XEP-0092: Software Version

#### Version 1.0.3
* load messages asynchronously on start up
* bug fixes

#### Version 1.0.2
* skipped

#### Version 1.0.1
* accept more ciphers

#### Version 1.0
* MUC controls (Affiliaton changes)
* Added download button to notification
* Added check box to hide offline contacts
* Use Material theme and icons on Android L
* Improved security
* bug fixes + code clean up

#### Version 0.10
* Support for Message Archive Management
* Dynamically load message history
* Ability to block contacts
* New UI to verify fingerprints
* Ability to change password on server
* removed stream compression
* quiet hours
* fixed connection issues on ipv6 servers

#### Version 0.9.3
* bug fixes

#### Version 0.9.2
* more bug fixes

#### Version 0.9.1
* bug fixes including some that caused Conversations to crash on start

#### Version 0.9
* arbitrary file transfer
* more options to verify OTR (SMP, QR Codes, NFC)
* ability to create instant conferences
* r/o dynamic tags (presence and roster groups)
* optional foreground service (expert option)
* added SCRAM-SHA1 login method
* bug fixes

#### Version 0.8.4
* bug fixes

#### Version 0.8.3
* increased UI performance
* fixed rotation bugs

#### Version 0.8.2
* Share contacts via QR codes or NFC
* Slightly improved UI
* minor bug fixes

#### Version 0.8.1
* minor bug fixes

#### Version 0.8
* Download HTTP images
* Show avatars in MUC tiles
* Disabled SSLv3
* Performance improvements
* bug fixes

#### Version 0.7.3
* revised tablet ui
* internal rewrites
* bug fixes

#### Version 0.7.2
* show full timestamp in messages
* brought back option to use JID to identify conferences
* optionally request delivery receipts (expert option)
* more languages
* bug fixes

#### Version 0.7.1
* Optionally use send button as status indicator

#### Version 0.7
* Ability to disable notifications for single conversations
* Merge messages in chat bubbles
* Fixes for OpenPGP and OTR (please republish your public key)
* Improved reliability on sending messages
* Join password protected Conferences
* Configurable font size
* Expert options for encryption

#### Version 0.6
* Support for server side avatars
* save images in gallery
* show contact name and picture in non-anonymous conferences
* reworked account creation
* various bug fixes

#### Version 0.5.2
* minor bug fixes

#### Version 0.5.1
* couple of small bug fixes that have been missed in 0.5
* complete translations for Swedish, Dutch, German, Spanish, French, Russian

#### Version 0.5
* UI overhaul
* MUC / Conference bookmarks
* A lot of bug fixes

#### Version 0.4
* OTR file encryption
* keep OTR messages and files on device until both parties or online at the same time
* XEP-0333. Mark whether the other party has read your messages
* Delayed messages are now tagged properly
* Share images from the Gallery
* Infinit history scrolling
* Mark the last used presence in presence selection dialog

#### Version 0.3
* Mostly bug fixes and internal rewrites
* Touch contact picture in conference to highlight
* Long press on received image to share
* made OTR more reliable
* improved issues with occasional message lost
* experimental conference encryption. (see FAQ)

#### Version 0.2.3
* regression fix with receiving encrypted images

#### Version 0.2.2
* Ability to take photos directly
* Improved openPGP offline handling
* Various bug fixes
* Updated Translations

#### Version 0.2.1
* Various bug fixes
* Updated Translations

#### Version 0.2
* Image file transfer
* Better integration with OpenKeychain (PGP encryption)
* Nicer conversation tiles for conferences
* Ability to clear conversation history
* A lot of bug fixes and code clean up

#### Version 0.1.3
* Switched to minidns library to resolve SRV records
* Faster DNS in some cases
* Enabled stream compression
* Added permanent notification when an account fails to connect
* Various bug fixes involving message notifications
* Added support for DIGEST-MD5 auth

#### Version 0.1.2
* Various bug fixes relating to conferences
* Further DNS lookup improvements

#### Version 0.1.1
* Fixed the 'server not found' bug

#### Version 0.1
* Initial release
