package com.tencent.bugly.lejiagu.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.C0151v;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.e */
public final class C0117e implements UncaughtExceptionHandler {
    /* renamed from: f */
    private static UncaughtExceptionHandler f913f;
    /* renamed from: h */
    private static boolean f914h;
    /* renamed from: i */
    private static final Object f915i = new Object();
    /* renamed from: j */
    private static int f916j;
    /* renamed from: a */
    private Context f917a;
    /* renamed from: b */
    private C0108b f918b;
    /* renamed from: c */
    private C0095a f919c;
    /* renamed from: d */
    private C0092a f920d;
    /* renamed from: e */
    private UncaughtExceptionHandler f921e;
    /* renamed from: g */
    private boolean f922g = false;

    public C0117e(Context context, C0108b c0108b, C0095a c0095a, C0092a c0092a) {
        this.f917a = context;
        this.f918b = c0108b;
        this.f919c = c0095a;
        this.f920d = c0092a;
    }

    /* renamed from: a */
    public final synchronized void m733a() {
        if (f916j >= 10) {
            C0148u.m1035a("java crash handler over %d, no need set.", Integer.valueOf(10));
        } else {
            UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler == null || getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName()))) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    C0148u.m1035a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    f913f = defaultUncaughtExceptionHandler;
                    this.f921e = defaultUncaughtExceptionHandler;
                } else {
                    C0148u.m1035a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.f921e = defaultUncaughtExceptionHandler;
                }
                m727a(defaultUncaughtExceptionHandler);
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f922g = true;
                f916j++;
                C0148u.m1035a("registered java monitor: %s", toString());
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m736b() {
        this.f922g = false;
        C0148u.m1035a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            C0148u.m1035a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f921e);
            f916j--;
        }
    }

    /* renamed from: c */
    private synchronized boolean m731c() {
        return Thread.getDefaultUncaughtExceptionHandler() == this;
    }

    /* renamed from: a */
    private synchronized void m727a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f921e = uncaughtExceptionHandler;
    }

    /* renamed from: b */
    private CrashDetailBean m728b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        boolean l = C0111c.m698a().m716l();
        String str2 = (l && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (l && z) {
            C0148u.m1041e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        C0148u.m1041e("3", new Object[0]);
        crashDetailBean.f783B = C0124a.m832i();
        crashDetailBean.f784C = C0124a.m830g();
        crashDetailBean.f785D = C0124a.m834k();
        crashDetailBean.f786E = this.f920d.m627o();
        crashDetailBean.f787F = this.f920d.m626n();
        crashDetailBean.f788G = this.f920d.m628p();
        crashDetailBean.f824w = C0124a.m792a(this.f917a, C0111c.f879d, null);
        crashDetailBean.f825x = C0151v.m1054a(z);
        String str3 = "user log size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.f825x == null ? 0 : crashDetailBean.f825x.length);
        C0148u.m1035a(str3, objArr);
        crashDetailBean.f803b = z ? 0 : 2;
        crashDetailBean.f806e = this.f920d.m618g();
        crashDetailBean.f807f = this.f920d.f729i;
        crashDetailBean.f808g = this.f920d.m632t();
        crashDetailBean.f814m = this.f920d.m616f();
        if (th == null) {
            return null;
        }
        Throwable th2 = th;
        while (th2.getCause() != null) {
            th2 = th2.getCause();
        }
        String name = th.getClass().getName();
        str3 = C0117e.m729b(th, 1000);
        if (str3 == null) {
            str3 = "";
        }
        String str4 = "stack frame :%d, has cause %b";
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        C0148u.m1041e(str4, objArr2);
        String str5 = "";
        if (th.getStackTrace().length > 0) {
            str5 = th.getStackTrace()[0].toString();
        }
        if (th2 != th) {
            crashDetailBean.f815n = th2.getClass().getName();
            crashDetailBean.f816o = C0117e.m729b(th2, 1000);
            if (crashDetailBean.f816o == null) {
                crashDetailBean.f816o = "";
            }
            crashDetailBean.f817p = th2.getStackTrace()[0].toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(name).append(":").append(str3).append("\n");
            stringBuilder.append(str5);
            stringBuilder.append("\n......");
            stringBuilder.append("\nCaused by:\n");
            stringBuilder.append(crashDetailBean.f815n).append(":").append(crashDetailBean.f816o).append("\n");
            stringBuilder.append(C0117e.m726a(th2, C0111c.f880e));
            crashDetailBean.f818q = stringBuilder.toString();
        } else {
            crashDetailBean.f815n = name;
            crashDetailBean.f816o = str3 + str2;
            if (crashDetailBean.f816o == null) {
                crashDetailBean.f816o = "";
            }
            crashDetailBean.f817p = str5;
            crashDetailBean.f818q = C0117e.m726a(th, C0111c.f880e);
        }
        crashDetailBean.f819r = System.currentTimeMillis();
        crashDetailBean.f822u = C0124a.m815b(crashDetailBean.f818q.getBytes());
        try {
            crashDetailBean.f826y = C0124a.m798a(C0111c.f880e, false);
            crashDetailBean.f827z = this.f920d.f724d;
            crashDetailBean.f782A = thread.getName();
            crashDetailBean.f789H = this.f920d.m634v();
            crashDetailBean.f809h = this.f920d.m631s();
            crashDetailBean.f810i = this.f920d.m603D();
            crashDetailBean.f793L = this.f920d.f721a;
            crashDetailBean.f794M = this.f920d.f734n;
            crashDetailBean.f796O = this.f920d.m600A();
            crashDetailBean.f797P = this.f920d.m601B();
            crashDetailBean.f798Q = this.f920d.m635w();
            crashDetailBean.f799R = this.f920d.m638z();
        } catch (Throwable th22) {
            C0148u.m1041e("handle crash error %s", th22.toString());
        }
        if (z) {
            this.f918b.m696b(crashDetailBean);
        } else {
            Object obj = (str == null || str.length() <= 0) ? null : 1;
            Object obj2 = (bArr == null || bArr.length <= 0) ? null : 1;
            if (obj != null) {
                crashDetailBean.f795N = new HashMap(1);
                crashDetailBean.f795N.put("UserData", str);
            }
            if (obj2 != null) {
                crashDetailBean.f800S = bArr;
            }
        }
        return crashDetailBean;
    }

    /* renamed from: d */
    private static boolean m732d() {
        boolean z;
        synchronized (f915i) {
            z = f914h;
            f914h = true;
        }
        return z;
    }

    /* renamed from: a */
    public final void m735a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            C0148u.m1041e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (C0117e.m732d()) {
                C0148u.m1035a("this class has handled this exception", new Object[0]);
                if (f913f != null) {
                    C0148u.m1035a("call system handler", new Object[0]);
                    f913f.uncaughtException(thread, th);
                } else {
                    C0148u.m1041e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            C0148u.m1041e("Java Catch Happen", new Object[0]);
        }
        try {
            if (this.f922g) {
                if (!this.f919c.m647b()) {
                    C0148u.m1041e("waiting for remote sync", new Object[0]);
                    int i = 0;
                    do {
                        if (!this.f919c.m647b()) {
                            Thread.sleep(500);
                            i += 500;
                        }
                    } while (i < 5000);
                }
                if (!this.f919c.m647b()) {
                    C0148u.m1040d("no remote but still store!", new Object[0]);
                }
                if (this.f919c.m648c().f753d || !this.f919c.m647b()) {
                    CrashDetailBean b = m728b(thread, th, z, str, bArr);
                    if (b == null) {
                        C0148u.m1041e("pkg crash datas fail!", new Object[0]);
                        if (!z) {
                            C0148u.m1041e("not to shut down return", new Object[0]);
                            return;
                        } else if (this.f921e != null && C0117e.m730b(this.f921e)) {
                            C0148u.m1041e("sys default last handle start!", new Object[0]);
                            this.f921e.uncaughtException(thread, th);
                            C0148u.m1041e("sys default last handle end!", new Object[0]);
                            return;
                        } else if (f913f != null) {
                            C0148u.m1041e("system handle start!", new Object[0]);
                            f913f.uncaughtException(thread, th);
                            C0148u.m1041e("system handle end!", new Object[0]);
                            return;
                        } else {
                            C0148u.m1041e("crashreport last handle start!", new Object[0]);
                            C0148u.m1041e("current process die", new Object[0]);
                            Process.killProcess(Process.myPid());
                            System.exit(1);
                            C0148u.m1041e("crashreport last handle end!", new Object[0]);
                            return;
                        }
                    }
                    C0108b.m683a(z ? "JAVA_CRASH" : "JAVA_CATCH", C0124a.m837n(), this.f920d.f724d, thread, C0124a.m794a(th), b);
                    if (!this.f918b.m694a(b)) {
                        this.f918b.m692a(b, 5000, z);
                    }
                    if (!z) {
                        C0148u.m1041e("not to shut down return", new Object[0]);
                        return;
                    } else if (this.f921e != null && C0117e.m730b(this.f921e)) {
                        C0148u.m1041e("sys default last handle start!", new Object[0]);
                        this.f921e.uncaughtException(thread, th);
                        C0148u.m1041e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (f913f != null) {
                        C0148u.m1041e("system handle start!", new Object[0]);
                        f913f.uncaughtException(thread, th);
                        C0148u.m1041e("system handle end!", new Object[0]);
                        return;
                    } else {
                        C0148u.m1041e("crashreport last handle start!", new Object[0]);
                        C0148u.m1041e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        C0148u.m1041e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                String str2;
                C0148u.m1041e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                if (z) {
                    str2 = "JAVA_CRASH";
                } else {
                    str2 = "JAVA_CATCH";
                }
                C0108b.m683a(str2, C0124a.m837n(), this.f920d.f724d, thread, C0124a.m794a(th), null);
                if (!z) {
                    C0148u.m1041e("not to shut down return", new Object[0]);
                    return;
                } else if (this.f921e != null && C0117e.m730b(this.f921e)) {
                    C0148u.m1041e("sys default last handle start!", new Object[0]);
                    this.f921e.uncaughtException(thread, th);
                    C0148u.m1041e("sys default last handle end!", new Object[0]);
                    return;
                } else if (f913f != null) {
                    C0148u.m1041e("system handle start!", new Object[0]);
                    f913f.uncaughtException(thread, th);
                    C0148u.m1041e("system handle end!", new Object[0]);
                    return;
                } else {
                    C0148u.m1041e("crashreport last handle start!", new Object[0]);
                    C0148u.m1041e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    C0148u.m1041e("crashreport last handle end!", new Object[0]);
                    return;
                }
            }
            C0148u.m1039c("Java crash handler is disable. Just return.", new Object[0]);
            if (!z) {
                C0148u.m1041e("not to shut down return", new Object[0]);
            } else if (this.f921e != null && C0117e.m730b(this.f921e)) {
                C0148u.m1041e("sys default last handle start!", new Object[0]);
                this.f921e.uncaughtException(thread, th);
                C0148u.m1041e("sys default last handle end!", new Object[0]);
            } else if (f913f != null) {
                C0148u.m1041e("system handle start!", new Object[0]);
                f913f.uncaughtException(thread, th);
                C0148u.m1041e("system handle end!", new Object[0]);
            } else {
                C0148u.m1041e("crashreport last handle start!", new Object[0]);
                C0148u.m1041e("current process die", new Object[0]);
                Process.killProcess(Process.myPid());
                System.exit(1);
                C0148u.m1041e("crashreport last handle end!", new Object[0]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Throwable th2) {
            try {
                if (!C0148u.m1036a(th2)) {
                    th2.printStackTrace();
                }
                if (!z) {
                    C0148u.m1041e("not to shut down return", new Object[0]);
                } else if (this.f921e != null && C0117e.m730b(this.f921e)) {
                    C0148u.m1041e("sys default last handle start!", new Object[0]);
                    this.f921e.uncaughtException(thread, th);
                    C0148u.m1041e("sys default last handle end!", new Object[0]);
                } else if (f913f != null) {
                    C0148u.m1041e("system handle start!", new Object[0]);
                    f913f.uncaughtException(thread, th);
                    C0148u.m1041e("system handle end!", new Object[0]);
                } else {
                    C0148u.m1041e("crashreport last handle start!", new Object[0]);
                    C0148u.m1041e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    C0148u.m1041e("crashreport last handle end!", new Object[0]);
                }
            } catch (Throwable th3) {
                if (!z) {
                    C0148u.m1041e("not to shut down return", new Object[0]);
                } else if (this.f921e != null && C0117e.m730b(this.f921e)) {
                    C0148u.m1041e("sys default last handle start!", new Object[0]);
                    this.f921e.uncaughtException(thread, th);
                    C0148u.m1041e("sys default last handle end!", new Object[0]);
                } else if (f913f != null) {
                    C0148u.m1041e("system handle start!", new Object[0]);
                    f913f.uncaughtException(thread, th);
                    C0148u.m1041e("system handle end!", new Object[0]);
                } else {
                    C0148u.m1041e("crashreport last handle start!", new Object[0]);
                    C0148u.m1041e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    C0148u.m1041e("crashreport last handle end!", new Object[0]);
                }
            }
        }
    }

    /* renamed from: b */
    private static boolean m730b(UncaughtExceptionHandler uncaughtExceptionHandler) {
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
        m735a(thread, th, true, null, null);
    }

    /* renamed from: a */
    public final synchronized void m734a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f753d != m731c()) {
                C0148u.m1035a("java changed to %b", Boolean.valueOf(strategyBean.f753d));
                if (strategyBean.f753d) {
                    m733a();
                } else {
                    m736b();
                }
            }
        }
    }

    /* renamed from: a */
    private static String m726a(Throwable th, int i) {
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
            C0148u.m1041e("gen stack error %s", th2.toString());
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static String m729b(Throwable th, int i) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000" + ", has been cutted!]";
    }
}
