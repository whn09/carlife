package com.tencent.bugly.legu.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.legu.BuglyStrategy;
import com.tencent.bugly.legu.BuglyStrategy.C0003a;
import com.tencent.bugly.legu.C0005b;
import com.tencent.bugly.legu.CrashModule;
import com.tencent.bugly.legu.crashreport.biz.C0014b;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.crash.BuglyBroadcastRecevier;
import com.tencent.bugly.legu.crashreport.crash.C0035c;
import com.tencent.bugly.legu.crashreport.crash.h5.C0044c;
import com.tencent.bugly.legu.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.legu.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: BUGLY */
public class CrashReport {
    /* renamed from: a */
    private static Context f41a;

    /* compiled from: BUGLY */
    public static class CrashHandleCallback extends C0003a {
    }

    /* compiled from: BUGLY */
    public static class UserStrategy extends BuglyStrategy {
        /* renamed from: a */
        private CrashHandleCallback f40a;

        public UserStrategy(Context context) {
        }

        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f40a;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f40a = crashHandleCallback;
        }
    }

    public static void enableBugly(boolean z) {
        C0005b.f33a = z;
    }

    public static synchronized void initCrashReport(Context context) {
        synchronized (CrashReport.class) {
            f41a = context;
            C0005b.m20a(CrashModule.getInstance());
            C0005b.m17a(context);
        }
    }

    public static synchronized void initCrashReport(Context context, UserStrategy userStrategy) {
        synchronized (CrashReport.class) {
            f41a = context;
            C0005b.m20a(CrashModule.getInstance());
            C0005b.m18a(context, userStrategy);
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
                f41a = context;
                C0005b.m20a(CrashModule.getInstance());
                C0005b.m19a(context, str, z, userStrategy);
            }
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            C0073w.m524d("Please call with context.", new Object[0]);
            return "unknown";
        }
        C0016a.m70a(context);
        return C0016a.m71b();
    }

    public static synchronized void testJavaCrash() {
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not test Java crash because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void testNativeCrash() {
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not test native crash because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0073w.m519a("start to create a native crash for test!", new Object[0]);
                C0035c.m171a().m187j();
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void testANRCrash() {
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not test ANR crash because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0073w.m519a("start to create a anr crash for test!", new Object[0]);
                C0035c.m171a().m188k();
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void postCatchedException(Throwable th) {
        synchronized (CrashReport.class) {
            postCatchedException(th, false);
        }
    }

    public static synchronized void postCatchedException(Throwable th, boolean z) {
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not post crash caught because bugly is disable.");
            } else if (!CrashModule.hasInitialized()) {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            } else if (th == null) {
                C0073w.m524d("throwable is null, just return", new Object[0]);
            } else {
                C0035c.m171a().m178a(Thread.currentThread(), th, false, null, null);
                if (z) {
                    C0073w.m519a("clear user datas", new Object[0]);
                    C0016a.m70a(f41a).m109x();
                }
            }
        }
    }

    public static synchronized void closeNativeReport() {
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not close native report because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0035c.m171a().m183f();
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void startCrashReport() {
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not start crash report because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0035c.m171a().m180c();
            } else {
                Log.w(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static synchronized void closeCrashReport() {
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not close crash report because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                C0035c.m171a().m181d();
            } else {
                Log.w(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
    }

    public static void closeBugly() {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.hasInitialized()) {
            Log.w(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (f41a != null) {
            BuglyBroadcastRecevier instance = BuglyBroadcastRecevier.getInstance();
            if (instance != null) {
                instance.unregist(f41a);
            }
            closeCrashReport();
            C0014b.m42a(f41a);
            C0072v a = C0072v.m511a();
            if (a != null) {
                a.m515b();
            }
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(C0073w.f588a, "setTag args context should not be null");
        } else {
            if (i <= 0) {
                C0073w.m524d("setTag args tagId should > 0", new Object[0]);
            }
            C0016a.m70a(context).m78a(i);
            C0073w.m521b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context != null) {
            return C0016a.m70a(context).m73B();
        } else {
            Log.e(C0073w.f588a, "getUserSceneTagId args context should not be null");
            return -1;
        }
    }

    public static String getUserData(Context context, String str) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not get user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(C0073w.f588a, "getUserDataValue args context should not be null");
            return "unknown";
        } else {
            Object obj = (str == null || str.trim().length() <= 0) ? 1 : null;
            if (obj != null) {
                return null;
            }
            return C0016a.m70a(context).m92g(str);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(C0073w.f588a, "putUserData args context should not be null");
        } else if (str == null) {
            str;
            C0073w.m524d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            str2;
            C0073w.m524d("putUserData args value should not be null", new Object[0]);
        } else if (str.matches("[a-zA-Z[0-9]]+")) {
            if (str2.length() > 200) {
                C0073w.m524d("user data value length over limit %d, it will be cutted!", Integer.valueOf(200));
                str2 = str2.substring(0, 200);
            }
            C0016a a = C0016a.m70a(context);
            NativeCrashHandler instance;
            if (a.m111z().contains(str)) {
                instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.putKeyValueToNative(str, str2);
                }
                C0016a.m70a(context).m80a(str, str2);
                C0073w.m523c("replace KV %s %s", str, str2);
            } else if (a.m110y() >= 10) {
                C0073w.m524d("user data size is over limit %d, it will be cutted!", Integer.valueOf(10));
            } else {
                if (str.length() > 50) {
                    C0073w.m524d("user data key length over limit %d , will drop this new key %s", Integer.valueOf(50), str);
                    str = str.substring(0, 50);
                }
                instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.putKeyValueToNative(str, str2);
                }
                C0016a.m70a(context).m80a(str, str2);
                C0073w.m521b("[param] set user data: %s - %s", str, str2);
            }
        } else {
            C0073w.m524d("putUserData args key should match [a-zA-Z[0-9]]+  {" + str + "}", new Object[0]);
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not remove user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(C0073w.f588a, "removeUserData args context should not be null");
            return "unknown";
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
            C0073w.m521b("[param] remove user data: %s", str);
            return C0016a.m70a(context).m90f(str);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context != null) {
            return C0016a.m70a(context).m111z();
        } else {
            Log.e(C0073w.f588a, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context != null) {
            return C0016a.m70a(context).m110y();
        } else {
            Log.e(C0073w.f588a, "getUserDatasSize args context should not be null");
            return -1;
        }
    }

    public static synchronized String getAppID() {
        String str;
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not get App ID because bugly is disable.");
                str = "unknown";
            } else if (CrashModule.hasInitialized()) {
                str = C0016a.m70a(f41a).m87e();
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                str = "unknown";
            }
        }
        return str;
    }

    public static void setUserId(String str) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not set user ID because bugly is disable.");
        } else if (CrashModule.hasInitialized()) {
            setUserId(f41a, str);
        } else {
            Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        }
    }

    public static void setUserId(Context context, String str) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(C0073w.f588a, "Context should not be null when bugly has not been initialed!");
        } else if (str == null) {
            C0073w.m524d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                C0073w.m524d("userId %s length is over limit %d substring to %s", str, Integer.valueOf(100), str.substring(0, 100));
                str = r0;
            }
            if (!str.equals(C0016a.m70a(context).m89f())) {
                C0016a.m70a(context).m81b(str);
                C0073w.m521b("[user] set userId : %s", str);
                if (CrashModule.hasInitialized()) {
                    C0014b.m40a();
                }
            }
        }
    }

    public static synchronized String getUserId() {
        String str;
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not get user ID because bugly is disable.");
                str = "unknown";
            } else if (CrashModule.hasInitialized()) {
                str = C0016a.m70a(f41a).m89f();
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                str = "unknown";
            }
        }
        return str;
    }

    public static synchronized String getAppVer() {
        String str;
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not get app version because bugly is disable.");
                str = "unknown";
            } else if (CrashModule.hasInitialized()) {
                str = C0016a.m70a(f41a).f122i;
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                str = "unknown";
            }
        }
        return str;
    }

    public static synchronized String getAppChannel() {
        String str;
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not get App channel because bugly is disable.");
                str = "unknown";
            } else if (CrashModule.hasInitialized()) {
                str = C0016a.m70a(f41a).f123j;
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
                str = "unknown";
            }
        }
        return str;
    }

    public static synchronized void setContext(Context context) {
        synchronized (CrashReport.class) {
            f41a = context;
        }
    }

    public static synchronized boolean isLastSessionCrash() {
        boolean z = false;
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            } else if (CrashModule.hasInitialized()) {
                z = C0035c.m171a().m179b();
            } else {
                Log.e(C0073w.f588a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            }
        }
        return z;
    }

    public static synchronized void setSdkExtraData(Context context, String str, String str2) {
        Object obj = null;
        synchronized (CrashReport.class) {
            if (!C0005b.f33a) {
                Log.w(C0073w.f588a, "Can not put SDK extra data because bugly is disable.");
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
                                map = C0005b.f35c;
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
                                C0005b.f35c = hashMap;
                            }
                        }
                    }
                }
                int i2 = 1;
                if (obj2 == null) {
                    i = 1;
                    if (obj == null) {
                        map = C0005b.f35c;
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
                        C0005b.f35c = hashMap;
                    }
                }
            }
        }
    }

    public static Map<String, String> getSdkExtraData() {
        if (C0005b.f33a) {
            return C0005b.f35c;
        }
        Log.w(C0073w.f588a, "Can not get SDK extra data because bugly is disable.");
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
                        Log.w(C0073w.f588a, String.format("putSdkData key length over limit %d, will be cutted.", new Object[]{Integer.valueOf(50)}));
                        replace = replace.substring(0, 50);
                    }
                    if (str2.length() > 500) {
                        Log.w(C0073w.f588a, String.format("putSdkData value length over limit %d, will be cutted!", new Object[]{Integer.valueOf(200)}));
                        str2 = str2.substring(0, 200);
                    }
                    C0016a.m70a(context).m82b(replace, str2);
                    C0073w.m521b(String.format("[param] putSdkData data: %s - %s", new Object[]{replace, str2}), new Object[0]);
                }
            }
        }
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not set 'isAppForeground' because bugly is disable.");
        } else if (context == null) {
            C0073w.m524d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                C0073w.m523c("App is in foreground.", new Object[0]);
            } else {
                C0073w.m523c("App is in background.", new Object[0]);
            }
            C0016a.m70a(context).f127n = z;
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            C0073w.m524d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                C0073w.m523c("This is a development device.", new Object[0]);
            } else {
                C0073w.m523c("This is not a development device.", new Object[0]);
            }
            C0016a.m70a(context).f137x = z;
        }
    }

    public static void setSessionIntervalMills(long j) {
        if (C0005b.f33a) {
            C0014b.m41a(j);
        } else {
            Log.w(C0073w.f588a, "Can not set 'SessionIntervalMills' because bugly is disable.");
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!C0005b.f33a) {
            Log.w(C0073w.f588a, "Can not set APP version because bugly is disable.");
        } else if (context == null) {
            Log.w(C0073w.f588a, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(C0073w.f588a, "Version is null, will not set");
        } else {
            C0016a.m70a(context).f122i = str;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(C0073w.f588a, "Webview is null.");
            return false;
        } else if (CrashModule.hasInitialized()) {
            C0073w.m519a("Set Javascript exception monitor of webview.", new Object[0]);
            if (C0005b.f33a) {
                C0073w.m523c("URL of webview is %s", webView.getUrl());
                if (webView.getUrl() == null) {
                    return false;
                }
                if (z2 || VERSION.SDK_INT >= 19) {
                    WebSettings settings = webView.getSettings();
                    if (!settings.getJavaScriptEnabled()) {
                        C0073w.m519a("Enable the javascript needed by webview monitor.", new Object[0]);
                        settings.setJavaScriptEnabled(true);
                    }
                    H5JavaScriptInterface instance = H5JavaScriptInterface.getInstance(webView);
                    if (instance != null) {
                        C0073w.m519a("Add a secure javascript interface to the webview.", new Object[0]);
                        webView.addJavascriptInterface(instance, "exceptionUploader");
                    }
                    if (z) {
                        C0073w.m519a("Inject bugly.js(v%s) to the webview.", C0044c.m212b());
                        String a = C0044c.m211a();
                        if (a == null) {
                            C0073w.m525e("Failed to inject Bugly.js.", C0044c.m212b());
                            return false;
                        }
                        webView.loadUrl("javascript:" + a);
                    }
                    return true;
                }
                C0073w.m525e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            Log.w(C0073w.f588a, "Can not set JavaScript monitor because bugly is disable.");
            return false;
        } else {
            C0073w.m525e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
    }
}
