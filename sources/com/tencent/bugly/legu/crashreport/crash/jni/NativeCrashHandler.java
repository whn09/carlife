package com.tencent.bugly.legu.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.legu.C0005b;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.crashreport.crash.C0032b;
import com.tencent.bugly.legu.crashreport.crash.C0035c;
import com.tencent.bugly.legu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;
import java.io.File;

/* compiled from: BUGLY */
public class NativeCrashHandler {
    /* renamed from: a */
    private static NativeCrashHandler f339a;
    /* renamed from: l */
    private static boolean f340l = false;
    /* renamed from: b */
    private final Context f341b;
    /* renamed from: c */
    private final C0016a f342c;
    /* renamed from: d */
    private final C0072v f343d;
    /* renamed from: e */
    private NativeExceptionHandler f344e;
    /* renamed from: f */
    private String f345f;
    /* renamed from: g */
    private final boolean f346g;
    /* renamed from: h */
    private boolean f347h = false;
    /* renamed from: i */
    private boolean f348i = false;
    /* renamed from: j */
    private boolean f349j = false;
    /* renamed from: k */
    private boolean f350k = false;
    /* renamed from: m */
    private C0032b f351m;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.jni.NativeCrashHandler$1 */
    class C00451 implements Runnable {
        /* renamed from: a */
        private /* synthetic */ NativeCrashHandler f338a;

        C00451(NativeCrashHandler nativeCrashHandler) {
            this.f338a = nativeCrashHandler;
        }

        public final void run() {
            if (C0048a.m268a(this.f338a.f341b, "native_record_lock", 10000)) {
                CrashDetailBean a = C0047b.m223a(this.f338a.f341b, this.f338a.f345f, this.f338a.f344e);
                if (a != null) {
                    if (!this.f338a.f351m.m167a(a)) {
                        this.f338a.f351m.m165a(a, 5000, false);
                    }
                    C0047b.m227b(this.f338a.f345f);
                    C0073w.m519a("get crash from native record!", new Object[0]);
                }
                this.f338a.m222a();
                C0048a.m284b(this.f338a.f341b, "native_record_lock");
                return;
            }
            C0073w.m519a("Failed to lock file for handling native crash record.", new Object[0]);
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
    private NativeCrashHandler(Context context, C0016a c0016a, C0032b c0032b, C0072v c0072v, boolean z, String str) {
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
        this.f341b = context2;
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    z2 = false;
                    if (z2) {
                        str = context.getDir("bugly", 0).getAbsolutePath();
                    }
                    this.f351m = c0032b;
                    this.f345f = str;
                    this.f342c = c0016a;
                    this.f343d = c0072v;
                    this.f346g = z;
                }
            } catch (Throwable th) {
                str = "/data/data/" + C0016a.m70a(context).f116c + "/app_bugly";
            }
        }
        z2 = true;
        if (z2) {
            str = context.getDir("bugly", 0).getAbsolutePath();
        }
        this.f351m = c0032b;
        this.f345f = str;
        this.f342c = c0016a;
        this.f343d = c0072v;
        this.f346g = z;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C0016a c0016a, C0032b c0032b, C0019a c0019a, C0072v c0072v, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f339a == null) {
                f339a = new NativeCrashHandler(context, c0016a, c0032b, c0072v, z, str);
            }
            nativeCrashHandler = f339a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f339a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f345f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f345f = str;
    }

    /* renamed from: a */
    private synchronized void m214a(boolean z) {
        if (this.f349j) {
            C0073w.m524d("native already registed!", new Object[0]);
        } else {
            this.f344e = new C0046a(this.f341b, this.f342c, this.f351m, C0019a.m114a(), this.f345f);
            String replace;
            if (this.f348i) {
                try {
                    String regist = regist(this.f345f, z, 1);
                    if (regist != null) {
                        C0073w.m519a("Native Crash Report enable!", new Object[0]);
                        C0073w.m523c("Check extra jni for Bugly NDK v%s", regist);
                        String replace2 = "2.1.1".replace(".", "");
                        replace = regist.replace(".", "");
                        if (replace.length() == 2) {
                            replace = replace + "0";
                        } else if (replace.length() == 1) {
                            replace = replace + "00";
                        }
                        try {
                            if (Integer.parseInt(replace) >= Integer.parseInt(replace2)) {
                                f340l = true;
                            }
                        } catch (Throwable th) {
                        }
                        if (f340l) {
                            C0073w.m519a("Extra bugly jni can be accessed.", new Object[0]);
                        } else {
                            C0073w.m524d("Extra bugly jni can not be accessed.", new Object[0]);
                        }
                        this.f342c.f125l = regist;
                        this.f349j = true;
                    }
                } catch (Throwable th2) {
                    C0073w.m523c("load bugly so fail", new Object[0]);
                }
            } else if (this.f347h) {
                try {
                    replace = (String) C0048a.m255a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE}, new Object[]{this.f345f, C0016a.m69a().m102q(), Integer.valueOf(C0016a.m69a().m77F()), Integer.valueOf(1)});
                    if (replace == null) {
                        replace = (String) C0048a.m255a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, new Class[]{String.class, String.class, Integer.TYPE}, new Object[]{this.f345f, C0016a.m69a().m102q(), Integer.valueOf(C0016a.m69a().m77F())});
                    }
                    if (replace != null) {
                        this.f349j = true;
                        C0016a.m69a().f125l = replace;
                        C0048a.m255a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(true)});
                        int i = C0005b.f34b ? 3 : 5;
                        C0048a.m255a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
                    }
                } catch (Throwable th3) {
                }
            }
            this.f348i = false;
            this.f347h = false;
        }
    }

    public synchronized void startNativeMonitor() {
        boolean z = true;
        synchronized (this) {
            if (this.f348i || this.f347h) {
                m214a(this.f346g);
            } else {
                boolean z2;
                String str = this.f342c.f124k;
                if (str == null || str.trim().length() <= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    str = this.f342c.f124k;
                }
                str = this.f342c.f124k;
                if (str == null || str.trim().length() <= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                String str2 = z2 ? "Bugly" : this.f342c.f124k;
                str = this.f342c.f124k;
                if (str == null || str.trim().length() <= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    z = false;
                }
                this.f348i = m215a(str2, z);
                if (this.f348i || this.f347h) {
                    m214a(this.f346g);
                    this.f343d.m516b(new C00451(this));
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m215a(String str, boolean z) {
        Throwable th;
        boolean z2;
        try {
            C0073w.m519a("[native] trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                C0073w.m519a("[native] load so success: %s", str);
                return true;
            } catch (Throwable th2) {
                th = th2;
                z2 = true;
            }
        } catch (Throwable th22) {
            th = th22;
            z2 = false;
            C0073w.m524d(th.getMessage(), new Object[0]);
            C0073w.m524d("[native] Failed to load so, please check.", str);
            return z2;
        }
    }

    /* renamed from: b */
    private synchronized void m217b() {
        if (this.f349j) {
            try {
                if (unregist() != null) {
                    C0073w.m519a("Native Crash Report close!", new Object[0]);
                    this.f349j = false;
                } else {
                    C0073w.m523c("unregist bugly so success", new Object[0]);
                    try {
                        C0048a.m255a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(false)});
                        this.f349j = false;
                        C0073w.m523c("unregist rqd so success", new Object[0]);
                    } catch (Throwable th) {
                        C0073w.m523c("unregist rqd so fail", new Object[0]);
                        this.f348i = false;
                        this.f347h = false;
                    }
                }
            } catch (Throwable th2) {
                C0073w.m523c("unregist bugly so fail", new Object[0]);
            }
        } else {
            C0073w.m524d("native already unregisted!", new Object[0]);
        }
        return;
    }

    public void testNativeCrash() {
        if (this.f348i) {
            testCrash();
        } else {
            C0073w.m524d("libBugly.so has not been load! so fail!", new Object[0]);
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f344e;
    }

    /* renamed from: a */
    protected final void m222a() {
        long o = C0048a.m304o() - C0035c.f274f;
        File file = new File(this.f345f);
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
                            C0073w.m525e("tomb format error delete %s", name);
                        }
                        if (file2.delete()) {
                            i++;
                        }
                    }
                }
                C0073w.m523c("clean tombs %d", Integer.valueOf(i));
            }
        }
    }

    /* renamed from: b */
    private synchronized void m218b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            m217b();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.f350k;
    }

    /* renamed from: c */
    private synchronized void m220c(boolean z) {
        if (this.f350k != z) {
            C0073w.m519a("user change native %b", Boolean.valueOf(z));
            this.f350k = z;
        }
    }

    public void setUserOpened(boolean z) {
        m220c(z);
        boolean z2 = C0019a.m114a().m121c().f146d && isUserOpened();
        if (z2 != this.f349j) {
            C0073w.m519a("native changed to %b", Boolean.valueOf(z2));
            m218b(z2);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        boolean z = true;
        synchronized (this) {
            if (strategyBean != null) {
                if (strategyBean.f146d != this.f349j) {
                    C0073w.m524d("server native changed to %b", Boolean.valueOf(strategyBean.f146d));
                }
            }
            if (!(C0019a.m114a().m121c().f146d && this.f350k)) {
                z = false;
            }
            if (z != this.f349j) {
                C0073w.m519a("native changed to %b", Boolean.valueOf(z));
                m218b(z);
            }
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        boolean z = false;
        if (!(!this.f348i || !f340l || str == null || str2 == null || str3 == null)) {
            try {
                z = appendNativeLog(str, str2, str3);
            } catch (UnsatisfiedLinkError e) {
                f340l = z;
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return z;
    }

    public boolean putKeyValueToNative(String str, String str2) {
        boolean z = false;
        if (this.f348i && f340l && str != null && str2 != null) {
            try {
                z = putNativeKeyValue(str, str2);
            } catch (UnsatisfiedLinkError e) {
                f340l = z;
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return z;
    }
}
