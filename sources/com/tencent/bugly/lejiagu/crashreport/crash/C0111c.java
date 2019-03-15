package com.tencent.bugly.lejiagu.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.lejiagu.BuglyStrategy.C0079a;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.crashreport.crash.anr.C0106b;
import com.tencent.bugly.lejiagu.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0137l;
import com.tencent.bugly.lejiagu.proguard.C0139m;
import com.tencent.bugly.lejiagu.proguard.C0141o;
import com.tencent.bugly.lejiagu.proguard.C0144r;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.c */
public final class C0111c {
    /* renamed from: a */
    public static int f876a = 0;
    /* renamed from: b */
    public static boolean f877b = false;
    /* renamed from: c */
    public static boolean f878c = true;
    /* renamed from: d */
    public static int f879d = 20000;
    /* renamed from: e */
    public static int f880e = 20000;
    /* renamed from: f */
    public static long f881f = 604800000;
    /* renamed from: g */
    public static String f882g = null;
    /* renamed from: h */
    public static boolean f883h = false;
    /* renamed from: i */
    public static String f884i = null;
    /* renamed from: j */
    public static int f885j = 5000;
    /* renamed from: n */
    private static C0111c f886n;
    /* renamed from: k */
    public final C0108b f887k;
    /* renamed from: l */
    public C0079a f888l;
    /* renamed from: m */
    private final Context f889m;
    /* renamed from: o */
    private final C0117e f890o;
    /* renamed from: p */
    private final NativeCrashHandler f891p;
    /* renamed from: q */
    private C0095a f892q;
    /* renamed from: r */
    private C0147t f893r;
    /* renamed from: s */
    private final C0106b f894s;
    /* renamed from: t */
    private Boolean f895t;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.c$2 */
    class C01102 extends Thread {
        /* renamed from: a */
        private /* synthetic */ C0111c f875a;

        C01102(C0111c c0111c) {
            this.f875a = c0111c;
        }

        public final void run() {
            if (C0124a.m802a(this.f875a.f889m, "local_crash_lock", 10000)) {
                List a = this.f875a.f887k.m691a();
                if (a != null && a.size() > 0) {
                    List arrayList;
                    int size = a.size();
                    if (((long) size) > 100) {
                        arrayList = new ArrayList();
                        Collections.sort(a);
                        for (int i = 0; ((long) i) < 100; i++) {
                            arrayList.add(a.get((size - 1) - i));
                        }
                    } else {
                        arrayList = a;
                    }
                    this.f875a.f887k.m693a(arrayList, 0, false);
                }
                C0124a.m818b(this.f875a.f889m, "local_crash_lock");
            }
        }
    }

    private C0111c(int i, Context context, C0147t c0147t, boolean z, C0079a c0079a, C0137l c0137l, String str) {
        Context context2;
        f876a = i;
        if (context == null) {
            context2 = context;
        } else {
            context2 = context.getApplicationContext();
            if (context2 == null) {
                context2 = context;
            }
        }
        this.f889m = context2;
        this.f892q = C0095a.m641a();
        C0144r a = C0144r.m994a();
        C0139m a2 = C0139m.m963a();
        C0092a a3 = C0092a.m598a(context2);
        this.f893r = c0147t;
        this.f888l = c0079a;
        this.f887k = new C0108b(i, context2, a, a2, this.f892q, c0079a, c0137l);
        this.f890o = new C0117e(context2, this.f887k, this.f892q, a3);
        this.f891p = NativeCrashHandler.getInstance(context2, a3, this.f887k, this.f892q, c0147t, z, str);
        this.f894s = new C0106b(context2, this.f892q, a3, c0147t, this.f887k);
        BuglyBroadcastRecevier instance = BuglyBroadcastRecevier.getInstance();
        instance.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
        instance.regist(context2, this.f887k);
    }

    /* renamed from: a */
    public static synchronized void m700a(int i, Context context, boolean z, C0079a c0079a, C0137l c0137l, String str) {
        synchronized (C0111c.class) {
            if (f886n == null) {
                f886n = new C0111c(1004, context, C0147t.m1027a(), z, c0079a, null, null);
            }
        }
    }

    /* renamed from: a */
    public static C0111c m698a() {
        return f886n;
    }

    /* renamed from: a */
    public final void m703a(StrategyBean strategyBean) {
        this.f890o.m734a(strategyBean);
        this.f891p.onStrategyChanged(strategyBean);
        this.f894s.m672a(strategyBean);
    }

    /* renamed from: b */
    public final boolean m706b() {
        Boolean bool = this.f895t;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = C0092a.m597a().f724d;
        List<C0141o> a = C0139m.m963a().m981a(1);
        List arrayList = new ArrayList();
        if (a == null || a.size() <= 0) {
            this.f895t = Boolean.valueOf(false);
            return false;
        }
        for (C0141o c0141o : a) {
            if (str.equals(c0141o.f1136c)) {
                this.f895t = Boolean.valueOf(true);
                arrayList.add(c0141o);
            }
        }
        if (arrayList.size() > 0) {
            C0139m.m963a();
            C0139m.m968a(arrayList);
        }
        return true;
    }

    /* renamed from: c */
    public final synchronized void m707c() {
        this.f890o.m733a();
        this.f891p.setUserOpened(true);
        this.f894s.m674a(true);
    }

    /* renamed from: d */
    public final synchronized void m708d() {
        this.f890o.m736b();
        this.f891p.setUserOpened(false);
        this.f894s.m674a(false);
    }

    /* renamed from: e */
    public final void m709e() {
        this.f890o.m733a();
    }

    /* renamed from: f */
    public final void m710f() {
        this.f891p.setUserOpened(false);
    }

    /* renamed from: g */
    public final void m711g() {
        this.f891p.setUserOpened(true);
    }

    /* renamed from: h */
    public final void m712h() {
        this.f894s.m674a(true);
    }

    /* renamed from: i */
    public final void m713i() {
        this.f894s.m674a(false);
    }

    /* renamed from: j */
    public final synchronized void m714j() {
        this.f891p.testNativeCrash();
    }

    /* renamed from: k */
    public final synchronized void m715k() {
        int i = 0;
        synchronized (this) {
            C0106b c0106b = this.f894s;
            while (true) {
                int i2 = i + 1;
                if (i >= 30) {
                    break;
                }
                C0148u.m1035a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                try {
                    Thread.sleep(5000);
                    i = i2;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    i = i2;
                } catch (Throwable th) {
                    if (!C0148u.m1036a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: l */
    public final boolean m716l() {
        return this.f894s.m675a();
    }

    /* renamed from: a */
    public final void m705a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        final Thread thread2 = thread;
        final Throwable th2 = th;
        final byte[] bArr2 = null;
        this.f893r.m1032b(new Runnable(this, false, null) {
            /* renamed from: f */
            private /* synthetic */ C0111c f874f;

            public final void run() {
                try {
                    C0148u.m1039c("post a throwable %b", Boolean.valueOf(false));
                    this.f874f.f890o.m735a(thread2, th2, false, null, bArr2);
                } catch (Throwable th) {
                    if (!C0148u.m1038b(th)) {
                        th.printStackTrace();
                    }
                    C0148u.m1041e("java catch error: %s", th2.toString());
                }
            }
        });
    }

    /* renamed from: a */
    public final void m704a(CrashDetailBean crashDetailBean) {
        this.f887k.m697c(crashDetailBean);
    }

    /* renamed from: a */
    public final void m702a(long j) {
        C0147t.m1027a().m1030a(new C01102(this), j);
    }
}
