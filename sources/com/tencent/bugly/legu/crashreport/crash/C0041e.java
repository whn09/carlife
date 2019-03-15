package com.tencent.bugly.legu.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.C0076x;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.crash.e */
public final class C0041e implements UncaughtExceptionHandler {
    /* renamed from: f */
    private static UncaughtExceptionHandler f306f;
    /* renamed from: h */
    private static boolean f307h;
    /* renamed from: i */
    private static final Object f308i = new Object();
    /* renamed from: j */
    private static int f309j;
    /* renamed from: a */
    private Context f310a;
    /* renamed from: b */
    private C0032b f311b;
    /* renamed from: c */
    private C0019a f312c;
    /* renamed from: d */
    private C0016a f313d;
    /* renamed from: e */
    private UncaughtExceptionHandler f314e;
    /* renamed from: g */
    private boolean f315g = false;

    public C0041e(Context context, C0032b c0032b, C0019a c0019a, C0016a c0016a) {
        this.f310a = context;
        this.f311b = c0032b;
        this.f312c = c0019a;
        this.f313d = c0016a;
    }

    /* renamed from: a */
    public final synchronized void m205a() {
        if (f309j >= 10) {
            C0073w.m519a("java crash handler over %d, no need set.", Integer.valueOf(10));
        } else {
            UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler == null || getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName()))) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    C0073w.m519a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    f306f = defaultUncaughtExceptionHandler;
                    this.f314e = defaultUncaughtExceptionHandler;
                } else {
                    C0073w.m519a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.f314e = defaultUncaughtExceptionHandler;
                }
                m200a(defaultUncaughtExceptionHandler);
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f315g = true;
                f309j++;
                C0073w.m519a("registered java monitor: %s", toString());
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m208b() {
        this.f315g = false;
        C0073w.m519a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            C0073w.m519a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f314e);
            f309j--;
        }
    }

    /* renamed from: a */
    private synchronized void m200a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f314e = uncaughtExceptionHandler;
    }

    /* renamed from: b */
    private CrashDetailBean m201b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        boolean l = C0035c.m171a().m189l();
        String str2 = (l && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (l && z) {
            C0073w.m525e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        C0073w.m525e("3", new Object[0]);
        crashDetailBean.f176B = C0048a.m298i();
        crashDetailBean.f177C = C0048a.m296g();
        crashDetailBean.f178D = C0048a.m300k();
        crashDetailBean.f179E = this.f313d.m100o();
        crashDetailBean.f180F = this.f313d.m99n();
        crashDetailBean.f181G = this.f313d.m101p();
        crashDetailBean.f217w = C0048a.m258a(this.f310a, C0035c.f272d, null);
        crashDetailBean.f218x = C0076x.m538a(z);
        String str3 = "user log size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.f218x == null ? 0 : crashDetailBean.f218x.length);
        C0073w.m519a(str3, objArr);
        crashDetailBean.f196b = z ? 0 : 2;
        crashDetailBean.f199e = this.f313d.m91g();
        crashDetailBean.f200f = this.f313d.f122i;
        crashDetailBean.f201g = this.f313d.m105t();
        crashDetailBean.f207m = this.f313d.m89f();
        if (th == null) {
            return null;
        }
        Object a;
        Throwable th2 = th;
        while (th2.getCause() != null) {
            th2 = th2.getCause();
        }
        String name = th.getClass().getName();
        str3 = C0041e.m202b(th, 1000);
        if (str3 == null) {
            str3 = "";
        }
        String str4 = "stack frame :%d, has cause %b";
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        C0073w.m525e(str4, objArr2);
        String str5 = "";
        if (th.getStackTrace().length > 0) {
            str5 = th.getStackTrace()[0].toString();
        }
        if (th2 != th) {
            crashDetailBean.f208n = th2.getClass().getName();
            crashDetailBean.f209o = C0041e.m202b(th2, 1000);
            if (crashDetailBean.f209o == null) {
                crashDetailBean.f209o = "";
            }
            crashDetailBean.f210p = th2.getStackTrace()[0].toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(name).append(":").append(str3).append("\n");
            stringBuilder.append(str5);
            stringBuilder.append("\n......");
            stringBuilder.append("\nCaused by:\n");
            stringBuilder.append(crashDetailBean.f208n).append(":").append(crashDetailBean.f209o).append("\n");
            a = C0041e.m199a(th2, C0035c.f273e);
            stringBuilder.append(a);
            crashDetailBean.f211q = stringBuilder.toString();
        } else {
            crashDetailBean.f208n = name;
            crashDetailBean.f209o = str3 + str2;
            if (crashDetailBean.f209o == null) {
                crashDetailBean.f209o = "";
            }
            crashDetailBean.f210p = str5;
            a = C0041e.m199a(th, C0035c.f273e);
            crashDetailBean.f211q = a;
        }
        crashDetailBean.f212r = System.currentTimeMillis();
        crashDetailBean.f215u = C0048a.m281b(crashDetailBean.f211q.getBytes());
        try {
            crashDetailBean.f219y = C0048a.m264a(C0035c.f273e, false);
            crashDetailBean.f220z = this.f313d.f117d;
            crashDetailBean.f175A = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.f219y.put(crashDetailBean.f175A, a);
            crashDetailBean.f182H = this.f313d.m107v();
            crashDetailBean.f202h = this.f313d.m104s();
            crashDetailBean.f203i = this.f313d.m76E();
            crashDetailBean.f186L = this.f313d.f114a;
            crashDetailBean.f187M = this.f313d.f127n;
            crashDetailBean.f189O = this.f313d.m73B();
            crashDetailBean.f190P = this.f313d.m74C();
            crashDetailBean.f191Q = this.f313d.m108w();
            crashDetailBean.f192R = this.f313d.m72A();
        } catch (Throwable th22) {
            C0073w.m525e("handle crash error %s", th22.toString());
        }
        if (z) {
            this.f311b.m169b(crashDetailBean);
        } else {
            Object obj = (str == null || str.length() <= 0) ? null : 1;
            a = (bArr == null || bArr.length <= 0) ? null : 1;
            if (obj != null) {
                crashDetailBean.f188N = new HashMap(1);
                crashDetailBean.f188N.put("UserData", str);
            }
            if (a != null) {
                crashDetailBean.f193S = bArr;
            }
        }
        return crashDetailBean;
    }

    /* renamed from: c */
    private static boolean m204c() {
        boolean z;
        synchronized (f308i) {
            z = f307h;
            f307h = true;
        }
        return z;
    }

    /* renamed from: a */
    public final void m207a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            C0073w.m525e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (C0041e.m204c()) {
                C0073w.m519a("this class has handled this exception", new Object[0]);
                if (f306f != null) {
                    C0073w.m519a("call system handler", new Object[0]);
                    f306f.uncaughtException(thread, th);
                } else {
                    C0073w.m525e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            C0073w.m525e("Java Catch Happen", new Object[0]);
        }
        try {
            if (this.f315g) {
                if (!this.f312c.m120b()) {
                    C0073w.m525e("waiting for remote sync", new Object[0]);
                    int i = 0;
                    do {
                        if (!this.f312c.m120b()) {
                            Thread.sleep(500);
                            i += 500;
                        }
                    } while (i < 5000);
                }
                if (!this.f312c.m120b()) {
                    C0073w.m524d("no remote but still store!", new Object[0]);
                }
                if (this.f312c.m121c().f146d || !this.f312c.m120b()) {
                    CrashDetailBean b = m201b(thread, th, z, str, bArr);
                    if (b == null) {
                        C0073w.m525e("pkg crash datas fail!", new Object[0]);
                        if (!z) {
                            C0073w.m525e("not to shut down return", new Object[0]);
                            return;
                        } else if (this.f314e != null && C0041e.m203b(this.f314e)) {
                            C0073w.m525e("sys default last handle start!", new Object[0]);
                            this.f314e.uncaughtException(thread, th);
                            C0073w.m525e("sys default last handle end!", new Object[0]);
                            return;
                        } else if (f306f != null) {
                            C0073w.m525e("system handle start!", new Object[0]);
                            f306f.uncaughtException(thread, th);
                            C0073w.m525e("system handle end!", new Object[0]);
                            return;
                        } else {
                            C0073w.m525e("crashreport last handle start!", new Object[0]);
                            C0073w.m525e("current process die", new Object[0]);
                            Process.killProcess(Process.myPid());
                            System.exit(1);
                            C0073w.m525e("crashreport last handle end!", new Object[0]);
                            return;
                        }
                    }
                    C0032b.m156a(z ? "JAVA_CRASH" : "JAVA_CATCH", C0048a.m303n(), this.f313d.f117d, thread, C0048a.m260a(th), b);
                    if (!this.f311b.m167a(b)) {
                        this.f311b.m165a(b, 5000, z);
                    }
                    if (!z) {
                        C0073w.m525e("not to shut down return", new Object[0]);
                        return;
                    } else if (this.f314e != null && C0041e.m203b(this.f314e)) {
                        C0073w.m525e("sys default last handle start!", new Object[0]);
                        this.f314e.uncaughtException(thread, th);
                        C0073w.m525e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (f306f != null) {
                        C0073w.m525e("system handle start!", new Object[0]);
                        f306f.uncaughtException(thread, th);
                        C0073w.m525e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C0073w.m525e("crashreport last handle start!", new Object[0]);
                        C0073w.m525e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        C0073w.m525e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                String str2;
                C0073w.m525e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                if (z) {
                    str2 = "JAVA_CRASH";
                } else {
                    str2 = "JAVA_CATCH";
                }
                C0032b.m156a(str2, C0048a.m303n(), this.f313d.f117d, thread, C0048a.m260a(th), null);
                if (!z) {
                    C0073w.m525e("not to shut down return", new Object[0]);
                    return;
                } else if (this.f314e != null && C0041e.m203b(this.f314e)) {
                    C0073w.m525e("sys default last handle start!", new Object[0]);
                    this.f314e.uncaughtException(thread, th);
                    C0073w.m525e("sys default last handle end!", new Object[0]);
                    return;
                } else if (f306f != null) {
                    C0073w.m525e("system handle start!", new Object[0]);
                    f306f.uncaughtException(thread, th);
                    C0073w.m525e("system handle end!", new Object[0]);
                    return;
                } else {
                    C0073w.m525e("crashreport last handle start!", new Object[0]);
                    C0073w.m525e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    C0073w.m525e("crashreport last handle end!", new Object[0]);
                    return;
                }
            }
            C0073w.m523c("Java crash handler is disable. Just return.", new Object[0]);
            if (!z) {
                C0073w.m525e("not to shut down return", new Object[0]);
            } else if (this.f314e != null && C0041e.m203b(this.f314e)) {
                C0073w.m525e("sys default last handle start!", new Object[0]);
                this.f314e.uncaughtException(thread, th);
                C0073w.m525e("sys default last handle end!", new Object[0]);
            } else if (f306f != null) {
                C0073w.m525e("system handle start!", new Object[0]);
                f306f.uncaughtException(thread, th);
                C0073w.m525e("system handle end!", new Object[0]);
            } else {
                C0073w.m525e("crashreport last handle start!", new Object[0]);
                C0073w.m525e("current process die", new Object[0]);
                Process.killProcess(Process.myPid());
                System.exit(1);
                C0073w.m525e("crashreport last handle end!", new Object[0]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Throwable th2) {
            try {
                if (!C0073w.m520a(th2)) {
                    th2.printStackTrace();
                }
                if (!z) {
                    C0073w.m525e("not to shut down return", new Object[0]);
                } else if (this.f314e != null && C0041e.m203b(this.f314e)) {
                    C0073w.m525e("sys default last handle start!", new Object[0]);
                    this.f314e.uncaughtException(thread, th);
                    C0073w.m525e("sys default last handle end!", new Object[0]);
                } else if (f306f != null) {
                    C0073w.m525e("system handle start!", new Object[0]);
                    f306f.uncaughtException(thread, th);
                    C0073w.m525e("system handle end!", new Object[0]);
                } else {
                    C0073w.m525e("crashreport last handle start!", new Object[0]);
                    C0073w.m525e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    C0073w.m525e("crashreport last handle end!", new Object[0]);
                }
            } catch (Throwable th3) {
                if (!z) {
                    C0073w.m525e("not to shut down return", new Object[0]);
                } else if (this.f314e != null && C0041e.m203b(this.f314e)) {
                    C0073w.m525e("sys default last handle start!", new Object[0]);
                    this.f314e.uncaughtException(thread, th);
                    C0073w.m525e("sys default last handle end!", new Object[0]);
                } else if (f306f != null) {
                    C0073w.m525e("system handle start!", new Object[0]);
                    f306f.uncaughtException(thread, th);
                    C0073w.m525e("system handle end!", new Object[0]);
                } else {
                    C0073w.m525e("crashreport last handle start!", new Object[0]);
                    C0073w.m525e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    C0073w.m525e("crashreport last handle end!", new Object[0]);
                }
            }
        }
    }

    /* renamed from: b */
    private static boolean m203b(UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        String str = "uncaughtException";
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && str.equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        m207a(thread, th, true, null, null);
    }

    /* renamed from: a */
    public final synchronized void m206a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f146d != this.f315g) {
                C0073w.m519a("java changed to %b", Boolean.valueOf(strategyBean.f146d));
                if (strategyBean.f146d) {
                    m205a();
                } else {
                    m208b();
                }
            }
        }
    }

    /* renamed from: a */
    private static String m199a(Throwable th, int i) {
        if (th == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (i2 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (i <= 0 || stringBuilder.length() < i) {
                        stringBuilder.append(stackTraceElement.toString()).append("\n");
                        i2++;
                    } else {
                        stringBuilder.append("\n[Stack over limit size :" + i + " , has been cutted !]");
                        return stringBuilder.toString();
                    }
                }
            }
        } catch (Throwable th2) {
            C0073w.m525e("gen stack error %s", th2.toString());
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static String m202b(Throwable th, int i) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000" + ", has been cutted!]";
    }
}
