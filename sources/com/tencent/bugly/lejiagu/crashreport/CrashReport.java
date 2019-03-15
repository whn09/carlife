package com.tencent.bugly.lejiagu.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.lejiagu.Bugly;
import com.tencent.bugly.lejiagu.BuglyStrategy;
import com.tencent.bugly.lejiagu.BuglyStrategy.C0079a;
import com.tencent.bugly.lejiagu.C0081b;
import com.tencent.bugly.lejiagu.CrashModule;
import com.tencent.bugly.lejiagu.crashreport.biz.C0090b;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.crash.C0111c;
import com.tencent.bugly.lejiagu.crashreport.crash.h5.C0120c;
import com.tencent.bugly.lejiagu.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.lejiagu.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.lejiagu.proguard.C0139m;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: BUGLY */
public class CrashReport {
    /* renamed from: a */
    private static Context f649a;

    /* compiled from: BUGLY */
    public static class CrashHandleCallback extends C0079a {
    }

    /* compiled from: BUGLY */
    public static class UserStrategy extends BuglyStrategy {
        /* renamed from: a */
        private CrashHandleCallback f648a;

        public UserStrategy(Context context) {
        }

        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f648a;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f648a = crashHandleCallback;
        }
    }

    public static void enableBugly(boolean z) {
        Bugly.enable = z;
    }

    public static synchronized void initCrashReport(Context context) {
        synchronized (CrashReport.class) {
            f649a = context;
            C0081b.m547a(context);
        }
    }

    public static synchronized void initCrashReport(Context context, UserStrategy userStrategy) {
        synchronized (CrashReport.class) {
            f649a = context;
            C0081b.m548a(context, userStrategy);
        }
    }

    public static synchronized void initCrashReport(Context context, String str, boolean z) {
        synchronized (CrashReport.class) {
            initCrashReport(context, str, z, null);
        }
    }

    public static synchronized void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        synchronized (CrashReport.class) {
            if (context != null) {
                f649a = context;
                C0081b.m549a(context, str, z, userStrategy);
            }
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            C0148u.m1040d("Please call with context.", new Object[0]);
            return "unknown";
        }
        C0092a.m598a(context);
        return C0092a.m599b();
    }

    public static synchronized void testJavaCrash() {
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not test Java crash because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void testNativeCrash() {
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not test native crash because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0148u.m1035a("start to create a native crash for test!", new Object[0]);
                C0111c.m698a().m714j();
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void testANRCrash() {
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not test ANR crash because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0148u.m1035a("start to create a anr crash for test!", new Object[0]);
                C0111c.m698a().m715k();
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void postCatchedException(Throwable th) {
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not post crash caught because bugly is disable.");
            } else if (!CrashModule.hasInitialized()) {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            } else if (th == null) {
                C0148u.m1040d("throwable is null, just return", new Object[0]);
            } else {
                C0111c.m698a().m705a(Thread.currentThread(), th, false, null, null);
            }
        }
    }

    public static synchronized void closeNativeReport() {
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not close native report because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0111c.m698a().m710f();
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void startCrashReport() {
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not start crash report because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0111c.m698a().m707c();
            } else {
                Log.w(C0148u.f1187b, "Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void closeCrashReport() {
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not close crash report because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0111c.m698a().m708d();
            } else {
                Log.w(C0148u.f1187b, "Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static void closeBugly() {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.hasInitialized()) {
            Log.w(C0148u.f1187b, "Report has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (f649a != null) {
            closeCrashReport();
            C0090b.m571a(f649a);
            C0147t a = C0147t.m1027a();
            if (a != null) {
                a.m1031b();
            }
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            throw new BuglyHintException("setTag args context should not be null");
        } else {
            if (i <= 0) {
                C0148u.m1040d("setTag args tagId should > 0", new Object[0]);
            }
            C0092a.m598a(context).m605a(i);
            C0148u.m1037b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context != null) {
            return C0092a.m598a(context).m600A();
        } else {
            throw new BuglyHintException("getUserSceneTagId args context should not be null");
        }
    }

    public static String getUserData(Context context, String str) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not get user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            throw new BuglyHintException("getUserDataValue args context should not be null");
        } else {
            Object obj = (str == null || str.trim().length() <= 0) ? 1 : null;
            if (obj != null) {
                return null;
            }
            return C0092a.m598a(context).m619g(str);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(C0148u.f1187b, "putUserData args context should not be null");
        } else if (str == null) {
            str;
            C0148u.m1040d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            str2;
            C0148u.m1040d("putUserData args value should not be null", new Object[0]);
        } else if (str.matches("[a-zA-Z[0-9]]+")) {
            if (str2.length() > 200) {
                C0148u.m1040d("user data value length over limit %d, it will be cutted!", Integer.valueOf(200));
                str2 = str2.substring(0, 200);
            }
            C0092a a = C0092a.m598a(context);
            NativeCrashHandler instance;
            if (a.m637y().contains(str)) {
                instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.putKeyValueToNative(str, str2);
                }
                C0092a.m598a(context).m607a(str, str2);
                C0148u.m1039c("replace KV %s %s", str, str2);
            } else if (a.m636x() >= 10) {
                C0148u.m1040d("user data size is over limit %d, it will be cutted!", Integer.valueOf(10));
            } else {
                if (str.length() > 50) {
                    C0148u.m1040d("user data key length over limit %d , will drop this new key %s", Integer.valueOf(50), str);
                    str = str.substring(0, 50);
                }
                instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.putKeyValueToNative(str, str2);
                }
                C0092a.m598a(context).m607a(str, str2);
                C0148u.m1037b("[param] set user data: %s - %s", str, str2);
            }
        } else {
            C0148u.m1040d("putUserData args key should match [a-zA-Z[0-9]]+  {" + str + "}", new Object[0]);
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not remove user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            throw new BuglyHintException("removeUserData args context should not be null");
        } else {
            int i;
            if (str == null || str.trim().length() <= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                return null;
            }
            C0148u.m1037b("[param] remove user data: %s", str);
            return C0092a.m598a(context).m617f(str);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context != null) {
            return C0092a.m598a(context).m637y();
        } else {
            throw new BuglyHintException("getAllUserDataKeys args context should not be null");
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context != null) {
            return C0092a.m598a(context).m636x();
        } else {
            throw new BuglyHintException("getUserDatasSize args context should not be null");
        }
    }

    public static synchronized String getAppID() {
        String str;
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not get App ID because bugly is disable.");
                str = "unknown";
            } else if (CrashModule.hasInitialized()) {
                str = C0092a.m598a(f649a).m614e();
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
        return str;
    }

    public static void setUserId(String str) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not set user ID because bugly is disable.");
        } else if (CrashModule.hasInitialized()) {
            setUserId(f649a, str);
        } else {
            throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserId(Context context, String str) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            throw new BuglyHintException("Context should not be null when bugly has not been initialed!");
        } else if (str == null) {
            C0148u.m1040d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                C0148u.m1040d("userId %s length is over limit %d substring to %s", str, Integer.valueOf(100), str.substring(0, 100));
                str = r0;
            }
            if (!str.equals(C0092a.m598a(context).m616f())) {
                C0092a.m598a(context).m608b(str);
                C0148u.m1037b("[user] set userId : %s", str);
                if (CrashModule.hasInitialized()) {
                    C0090b.m569a();
                }
            }
        }
    }

    public static synchronized String getUserId() {
        String str;
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not get user ID because bugly is disable.");
                str = "unknown";
            } else if (CrashModule.hasInitialized()) {
                str = C0092a.m598a(f649a).m616f();
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
        return str;
    }

    public static synchronized String getAppVer() {
        String str;
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not get app version because bugly is disable.");
                str = "unknown";
            } else if (CrashModule.hasInitialized()) {
                str = C0092a.m598a(f649a).f729i;
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
        return str;
    }

    public static synchronized String getAppChannel() {
        String str;
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not get App channel because bugly is disable.");
                str = "unknown";
            } else if (CrashModule.hasInitialized()) {
                str = C0092a.m598a(f649a).f730j;
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
        return str;
    }

    public static synchronized void setContext(Context context) {
        synchronized (CrashReport.class) {
            f649a = context;
        }
    }

    public static synchronized boolean isLastSessionCrash() {
        boolean z;
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
                z = false;
            } else if (CrashModule.hasInitialized()) {
                z = C0111c.m698a().m706b();
            } else {
                throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
        return z;
    }

    public static synchronized void setSdkExtraData(Context context, String str, String str2) {
        Object obj = null;
        synchronized (CrashReport.class) {
            if (!Bugly.enable) {
                Log.w(C0148u.f1187b, "Can not put SDK extra data because bugly is disable.");
            } else if (context != null) {
                Object obj2;
                int i;
                Map map;
                Map hashMap;
                String str3;
                String str4;
                if (str != null) {
                    if (str.trim().length() > 0) {
                        obj2 = null;
                        if (obj2 == null) {
                            if (str2 == null || str2.trim().length() <= 0) {
                                i = 1;
                            }
                            if (obj == null) {
                                map = C0081b.f638b;
                                if (map != null) {
                                    hashMap = new HashMap();
                                } else {
                                    hashMap = map;
                                }
                                hashMap.put(str, str2);
                                if (hashMap.size() > 0) {
                                    str3 = "SDK_INFO";
                                    str4 = "";
                                    for (Entry entry : hashMap.entrySet()) {
                                        str4 = str4 + "[" + ((String) entry.getKey()) + "," + ((String) entry.getValue()) + "] ";
                                    }
                                    putSdkData(context, str3, str4);
                                }
                                C0081b.f638b = hashMap;
                            }
                        }
                    }
                }
                int i2 = 1;
                if (obj2 == null) {
                    i = 1;
                    if (obj == null) {
                        map = C0081b.f638b;
                        if (map != null) {
                            hashMap = map;
                        } else {
                            hashMap = new HashMap();
                        }
                        hashMap.put(str, str2);
                        if (hashMap.size() > 0) {
                            str3 = "SDK_INFO";
                            str4 = "";
                            for (Entry entry2 : hashMap.entrySet()) {
                                str4 = str4 + "[" + ((String) entry2.getKey()) + "," + ((String) entry2.getValue()) + "] ";
                            }
                            putSdkData(context, str3, str4);
                        }
                        C0081b.f638b = hashMap;
                    }
                }
            }
        }
    }

    public static Map<String, String> getSdkExtraData() {
        if (Bugly.enable) {
            return C0081b.f638b;
        }
        Log.w(C0148u.f1187b, "Can not get SDK extra data because bugly is disable.");
        return new HashMap();
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context != null) {
            int i;
            if (str == null || str.trim().length() <= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                if (str2 == null || str2.trim().length() <= 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    String replace = str.replace("[a-zA-Z[0-9]]+", "");
                    if (replace.length() > 100) {
                        Log.w(C0148u.f1187b, String.format("putSdkData key length over limit %d, will be cutted.", new Object[]{Integer.valueOf(50)}));
                        replace = replace.substring(0, 50);
                    }
                    if (str2.length() > 500) {
                        Log.w(C0148u.f1187b, String.format("putSdkData value length over limit %d, will be cutted!", new Object[]{Integer.valueOf(200)}));
                        str2 = str2.substring(0, 200);
                    }
                    C0092a.m598a(context).m609b(replace, str2);
                    Log.w(C0148u.f1186a, String.format("[param] putSdkData data: %s - %s", new Object[]{replace, str2}));
                }
            }
        }
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not set 'isAppForeground' because bugly is disable.");
        } else if (context == null) {
            C0148u.m1040d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                C0148u.m1039c("App is in foreground.", new Object[0]);
            } else {
                C0148u.m1039c("App is in background.", new Object[0]);
            }
            C0092a.m598a(context).f734n = z;
        }
    }

    public static void setSessionIntervalMills(long j) {
        if (Bugly.enable) {
            C0090b.m570a(j);
        } else {
            Log.w(C0148u.f1187b, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not set APP version because bugly is disable.");
        } else if (context == null) {
            Log.w(C0148u.f1187b, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(C0148u.f1187b, "Version is null, will not set");
        } else {
            C0092a.m598a(context).f729i = str;
        }
    }

    public static void setAppChannel(String str, boolean z) {
        if (!Bugly.enable) {
            Log.w(C0148u.f1187b, "Can not set APP version because bugly is disable.");
        } else if (!CrashModule.hasInitialized()) {
            throw new BuglyHintException("Report has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (str == null) {
            Log.w(C0148u.f1187b, "channel is null, will not set");
        } else {
            C0139m a = C0139m.m963a();
            if (a == null) {
                Log.w(C0148u.f1187b, "DB Manager has not been initialed, can not replace App channel");
                return;
            }
            if (!z) {
                try {
                    Map a2 = a.m982a(556, null, true);
                    if (a2 != null && a2.containsKey("app_channel")) {
                        str = new String((byte[]) a2.get("app_channel"));
                    }
                } catch (Throwable th) {
                    if (C0081b.f637a) {
                        th.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            C0092a.m598a(f649a).f730j = str;
            a.m984a(556, "app_channel", str.toString().getBytes(), null, true);
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(C0148u.f1187b, "Webview is null.");
            return false;
        } else if (CrashModule.hasInitialized()) {
            C0148u.m1035a("Set Javascript exception monitor of webview.", new Object[0]);
            if (Bugly.enable) {
                C0148u.m1039c("URL of webview is %s", webView.getUrl());
                if (webView.getUrl() == null) {
                    return false;
                }
                if (z2 || VERSION.SDK_INT >= 19) {
                    WebSettings settings = webView.getSettings();
                    if (!settings.getJavaScriptEnabled()) {
                        C0148u.m1035a("Enable the javascript needed by webview monitor.", new Object[0]);
                        settings.setJavaScriptEnabled(true);
                    }
                    H5JavaScriptInterface instance = H5JavaScriptInterface.getInstance(webView);
                    if (instance != null) {
                        C0148u.m1035a("Add a secure javascript interface to the webview.", new Object[0]);
                        webView.addJavascriptInterface(instance, "exceptionUploader");
                    }
                    if (z) {
                        C0148u.m1035a("Inject bugly.js(v%s) to the webview.", C0120c.m740b());
                        String a = C0120c.m739a();
                        if (a == null) {
                            C0148u.m1041e("Failed to inject Bugly.js.", C0120c.m740b());
                            return false;
                        }
                        webView.loadUrl("javascript:" + a);
                    }
                    return true;
                }
                C0148u.m1041e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            Log.w(C0148u.f1187b, "Can not set JavaScript monitor because bugly is disable.");
            return false;
        } else {
            C0148u.m1041e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
    }
}
