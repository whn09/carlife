package com.tencent.bugly.lejiagu.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.lejiagu.C0081b;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.crashreport.crash.C0108b;
import com.tencent.bugly.lejiagu.crashreport.crash.C0111c;
import com.tencent.bugly.lejiagu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.io.File;

/* compiled from: BUGLY */
public class NativeCrashHandler {
    /* renamed from: a */
    private static NativeCrashHandler f946a;
    /* renamed from: l */
    private static boolean f947l = false;
    /* renamed from: b */
    private final Context f948b;
    /* renamed from: c */
    private final C0092a f949c;
    /* renamed from: d */
    private final C0147t f950d;
    /* renamed from: e */
    private NativeExceptionHandler f951e;
    /* renamed from: f */
    private String f952f;
    /* renamed from: g */
    private final boolean f953g;
    /* renamed from: h */
    private boolean f954h = false;
    /* renamed from: i */
    private boolean f955i = false;
    /* renamed from: j */
    private boolean f956j = false;
    /* renamed from: k */
    private boolean f957k = false;
    /* renamed from: m */
    private C0108b f958m;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.jni.NativeCrashHandler$1 */
    class C01211 implements Runnable {
        /* renamed from: a */
        private /* synthetic */ NativeCrashHandler f945a;

        C01211(NativeCrashHandler nativeCrashHandler) {
            this.f945a = nativeCrashHandler;
        }

        public final void run() {
            String str;
            boolean z = true;
            String str2 = this.f945a.f949c.f731k;
            boolean z2 = str2 == null || str2.trim().length() <= 0;
            if (!z2) {
                str2 = this.f945a.f949c.f731k;
            }
            str2 = this.f945a.f949c.f731k;
            if (str2 != null && str2.trim().length() > 0) {
                z = false;
            }
            if (z) {
                str = "Bugly";
            } else {
                str = this.f945a.f949c.f731k;
            }
            this.f945a.f955i = NativeCrashHandler.m744a(str);
            if (this.f945a.f955i || this.f945a.f954h) {
                this.f945a.m756a(this.f945a.f953g);
                if (C0124a.m802a(this.f945a.f948b, "native_record_lock", 10000)) {
                    CrashDetailBean a = C0123b.m757a(this.f945a.f948b, this.f945a.f952f, this.f945a.f951e);
                    if (a != null) {
                        if (!this.f945a.f958m.m694a(a)) {
                            this.f945a.f958m.m692a(a, 5000, false);
                        }
                        C0123b.m761b(this.f945a.f952f);
                        C0148u.m1035a("get crash from native record!", new Object[0]);
                    }
                    this.f945a.m755a();
                    C0124a.m818b(this.f945a.f948b, "native_record_lock");
                    return;
                }
                C0148u.m1035a("Failed to lock file for handling native crash record.", new Object[0]);
            }
        }
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    protected native String removeNativeKeyValue(String str);

    protected native void testCrash();

    protected native String unregist();

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, C0092a c0092a, C0108b c0108b, C0147t c0147t, boolean z, String str) {
        Context context2;
        boolean z2;
        if (context == null) {
            context2 = context;
        } else {
            context2 = context.getApplicationContext();
            if (context2 == null) {
                context2 = context;
            }
        }
        this.f948b = context2;
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    z2 = false;
                    if (z2) {
                        str = context.getDir("bugly", 0).getAbsolutePath();
                    }
                    this.f958m = c0108b;
                    this.f952f = str;
                    this.f949c = c0092a;
                    this.f950d = c0147t;
                    this.f953g = z;
                }
            } catch (Throwable th) {
                str = "/data/data/" + C0092a.m598a(context).f723c + "/app_bugly";
            }
        }
        z2 = true;
        if (z2) {
            str = context.getDir("bugly", 0).getAbsolutePath();
        }
        this.f958m = c0108b;
        this.f952f = str;
        this.f949c = c0092a;
        this.f950d = c0147t;
        this.f953g = z;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C0092a c0092a, C0108b c0108b, C0095a c0095a, C0147t c0147t, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f946a == null) {
                f946a = new NativeCrashHandler(context, c0092a, c0108b, c0147t, z, str);
            }
            nativeCrashHandler = f946a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f946a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f952f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f952f = str;
    }

    /* renamed from: a */
    protected final synchronized void m756a(boolean z) {
        if (this.f956j) {
            C0148u.m1040d("native already registed!", new Object[0]);
        } else {
            this.f951e = new C0122a(this.f948b, this.f949c, this.f958m, C0095a.m641a(), this.f952f);
            String replace;
            if (this.f955i) {
                try {
                    String regist = regist(this.f952f, z, 1);
                    if (regist != null) {
                        C0148u.m1035a("Native Crash Report enable!", new Object[0]);
                        C0148u.m1039c("Check extra jni for Bugly NDK v%s", regist);
                        String replace2 = "2.1.1".replace(".", "");
                        replace = regist.replace(".", "");
                        if (replace.length() == 2) {
                            replace = replace + "0";
                        } else if (replace.length() == 1) {
                            replace = replace + "00";
                        }
                        try {
                            if (Integer.parseInt(replace) >= Integer.parseInt(replace2)) {
                                f947l = true;
                            }
                        } catch (Throwable th) {
                        }
                        if (f947l) {
                            C0148u.m1035a("Extra bugly jni can be accessed.", new Object[0]);
                        } else {
                            C0148u.m1040d("Extra bugly jni can not be accessed.", new Object[0]);
                        }
                        this.f949c.f732l = regist;
                        this.f956j = true;
                    }
                } catch (Throwable th2) {
                    C0148u.m1039c("load bugly so fail", new Object[0]);
                }
            } else if (this.f954h) {
                try {
                    replace = (String) C0124a.m789a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE}, new Object[]{this.f952f, C0092a.m597a().m629q(), Integer.valueOf(C0092a.m597a().m604E()), Integer.valueOf(1)});
                    if (replace == null) {
                        replace = (String) C0124a.m789a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{this.f952f, C0092a.m597a().m629q(), Integer.valueOf(C0092a.m597a().m604E())});
                    }
                    if (replace != null) {
                        this.f956j = true;
                        C0092a.m597a().f732l = replace;
                        C0124a.m789a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(true)});
                        int i = C0081b.f637a ? 3 : 5;
                        C0124a.m789a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
                    }
                } catch (Throwable th3) {
                }
            }
            this.f955i = false;
            this.f954h = false;
        }
    }

    public synchronized void startNativeMonitor() {
        if (this.f955i || this.f954h) {
            m756a(this.f953g);
        } else {
            this.f950d.m1032b(new C01211(this));
        }
    }

    /* renamed from: a */
    private static boolean m744a(String str) {
        try {
            System.loadLibrary(str);
            try {
                C0148u.m1035a("[native] load so success: %s", str);
                return true;
            } catch (Throwable th) {
                return true;
            }
        } catch (Throwable th2) {
            return false;
        }
    }

    /* renamed from: b */
    private synchronized void m745b() {
        if (this.f956j) {
            try {
                if (unregist() != null) {
                    C0148u.m1035a("Native Crash Report close!", new Object[0]);
                    this.f956j = false;
                } else {
                    C0148u.m1039c("unregist bugly so success", new Object[0]);
                    try {
                        C0124a.m789a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(false)});
                        this.f956j = false;
                        C0148u.m1039c("unregist rqd so success", new Object[0]);
                    } catch (Throwable th) {
                        C0148u.m1039c("unregist rqd so fail", new Object[0]);
                        this.f955i = false;
                        this.f954h = false;
                    }
                }
            } catch (Throwable th2) {
                C0148u.m1039c("unregist bugly so fail", new Object[0]);
            }
        } else {
            C0148u.m1040d("native already unregisted!", new Object[0]);
        }
        return;
    }

    public void testNativeCrash() {
        if (this.f955i) {
            testCrash();
        } else {
            C0148u.m1040d("libBugly.so has not been load! so fail!", new Object[0]);
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f951e;
    }

    /* renamed from: a */
    protected final void m755a() {
        long o = C0124a.m838o() - C0111c.f881f;
        File file = new File(this.f952f);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                String str = "tomb_";
                String str2 = ".txt";
                int length = str.length();
                int i = 0;
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (name.startsWith(str)) {
                        try {
                            int indexOf = name.indexOf(str2);
                            if (indexOf > 0 && Long.parseLong(name.substring(length, indexOf)) >= o) {
                            }
                        } catch (Throwable th) {
                            C0148u.m1041e("tomb format error delete %s", name);
                        }
                        if (file2.delete()) {
                            i++;
                        }
                    }
                }
                C0148u.m1039c("clean tombs %d", Integer.valueOf(i));
            }
        }
    }

    /* renamed from: b */
    private synchronized void m746b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            m745b();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.f957k;
    }

    /* renamed from: c */
    private synchronized void m748c(boolean z) {
        if (this.f957k != z) {
            C0148u.m1035a("user change native %b", Boolean.valueOf(z));
            this.f957k = z;
        }
    }

    public void setUserOpened(boolean z) {
        m748c(z);
        boolean z2 = C0095a.m641a().m648c().f753d && isUserOpened();
        if (z2 != this.f956j) {
            C0148u.m1035a("native changed to %b", Boolean.valueOf(z2));
            m746b(z2);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        boolean z = true;
        synchronized (this) {
            if (strategyBean != null) {
                if (strategyBean.f753d != this.f956j) {
                    C0148u.m1040d("server native changed to %b", Boolean.valueOf(strategyBean.f753d));
                }
            }
            if (!(C0095a.m641a().m648c().f753d && this.f957k)) {
                z = false;
            }
            if (z != this.f956j) {
                C0148u.m1035a("native changed to %b", Boolean.valueOf(z));
                m746b(z);
            }
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        boolean z = false;
        if (!(!this.f955i || !f947l || str == null || str2 == null || str3 == null)) {
            try {
                z = appendNativeLog(str, str2, str3);
            } catch (UnsatisfiedLinkError e) {
                f947l = z;
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return z;
    }

    public boolean putKeyValueToNative(String str, String str2) {
        boolean z = false;
        if (this.f955i && f947l && str != null && str2 != null) {
            try {
                z = putNativeKeyValue(str, str2);
            } catch (UnsatisfiedLinkError e) {
                f947l = z;
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return z;
    }
}
