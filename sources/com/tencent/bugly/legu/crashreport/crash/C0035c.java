package com.tencent.bugly.legu.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.legu.BuglyStrategy.C0003a;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.crashreport.crash.anr.C0030b;
import com.tencent.bugly.legu.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0062n;
import com.tencent.bugly.legu.proguard.C0064o;
import com.tencent.bugly.legu.proguard.C0066q;
import com.tencent.bugly.legu.proguard.C0069t;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.crash.c */
public final class C0035c {
    /* renamed from: a */
    public static int f269a = 0;
    /* renamed from: b */
    public static boolean f270b = false;
    /* renamed from: c */
    public static boolean f271c = true;
    /* renamed from: d */
    public static int f272d = 20000;
    /* renamed from: e */
    public static int f273e = 20000;
    /* renamed from: f */
    public static long f274f = 604800000;
    /* renamed from: g */
    public static String f275g = null;
    /* renamed from: h */
    public static boolean f276h = false;
    /* renamed from: i */
    public static String f277i = null;
    /* renamed from: j */
    public static int f278j = 5000;
    /* renamed from: n */
    private static C0035c f279n;
    /* renamed from: k */
    public final C0032b f280k;
    /* renamed from: l */
    public C0003a f281l;
    /* renamed from: m */
    private final Context f282m;
    /* renamed from: o */
    private final C0041e f283o;
    /* renamed from: p */
    private final NativeCrashHandler f284p;
    /* renamed from: q */
    private C0019a f285q;
    /* renamed from: r */
    private C0072v f286r;
    /* renamed from: s */
    private final C0030b f287s;
    /* renamed from: t */
    private Boolean f288t;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.c$2 */
    class C00342 extends Thread {
        /* renamed from: a */
        private /* synthetic */ C0035c f268a;

        C00342(C0035c c0035c) {
            this.f268a = c0035c;
        }

        public final void run() {
            if (C0048a.m268a(this.f268a.f282m, "local_crash_lock", 10000)) {
                List a = this.f268a.f280k.m164a();
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
                    this.f268a.f280k.m166a(arrayList, 0, false);
                }
                C0048a.m284b(this.f268a.f282m, "local_crash_lock");
            }
        }
    }

    private C0035c(int i, Context context, C0072v c0072v, boolean z, C0003a c0003a, C0062n c0062n, String str) {
        Context context2;
        f269a = i;
        if (context == null) {
            context2 = context;
        } else {
            context2 = context.getApplicationContext();
            if (context2 == null) {
                context2 = context;
            }
        }
        this.f282m = context2;
        this.f285q = C0019a.m114a();
        C0069t a = C0069t.m478a();
        C0064o a2 = C0064o.m440a();
        C0016a a3 = C0016a.m70a(context2);
        this.f286r = c0072v;
        this.f281l = c0003a;
        this.f280k = new C0032b(i, context2, a, a2, this.f285q, c0003a, c0062n);
        this.f283o = new C0041e(context2, this.f280k, this.f285q, a3);
        this.f284p = NativeCrashHandler.getInstance(context2, a3, this.f280k, this.f285q, c0072v, z, str);
        this.f287s = new C0030b(context2, this.f285q, a3, c0072v, this.f280k);
        BuglyBroadcastRecevier instance = BuglyBroadcastRecevier.getInstance();
        instance.addFilter("android.net.conn.CONNECTIVITY_CHANGE");
        instance.regist(context2, this.f280k);
    }

    /* renamed from: a */
    public static synchronized void m173a(int i, Context context, boolean z, C0003a c0003a, C0062n c0062n, String str) {
        synchronized (C0035c.class) {
            if (f279n == null) {
                f279n = new C0035c(1004, context, C0072v.m511a(), z, c0003a, null, null);
            }
        }
    }

    /* renamed from: a */
    public static C0035c m171a() {
        return f279n;
    }

    /* renamed from: a */
    public final void m176a(StrategyBean strategyBean) {
        this.f283o.m206a(strategyBean);
        this.f284p.onStrategyChanged(strategyBean);
        this.f287s.m145a(strategyBean);
    }

    /* renamed from: b */
    public final boolean m179b() {
        Boolean bool = this.f288t;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = C0016a.m69a().f117d;
        List<C0066q> a = C0064o.m440a().m462a(1);
        List arrayList = new ArrayList();
        if (a == null || a.size() <= 0) {
            this.f288t = Boolean.valueOf(false);
            return false;
        }
        for (C0066q c0066q : a) {
            if (str.equals(c0066q.f538c)) {
                this.f288t = Boolean.valueOf(true);
                arrayList.add(c0066q);
            }
        }
        if (arrayList.size() > 0) {
            C0064o.m440a();
            C0064o.m445a(arrayList);
        }
        return true;
    }

    /* renamed from: c */
    public final synchronized void m180c() {
        this.f283o.m205a();
        this.f284p.setUserOpened(true);
        this.f287s.m147a(true);
    }

    /* renamed from: d */
    public final synchronized void m181d() {
        this.f283o.m208b();
        this.f284p.setUserOpened(false);
        this.f287s.m147a(false);
    }

    /* renamed from: e */
    public final void m182e() {
        this.f283o.m205a();
    }

    /* renamed from: f */
    public final void m183f() {
        this.f284p.setUserOpened(false);
    }

    /* renamed from: g */
    public final void m184g() {
        this.f284p.setUserOpened(true);
    }

    /* renamed from: h */
    public final void m185h() {
        this.f287s.m147a(true);
    }

    /* renamed from: i */
    public final void m186i() {
        this.f287s.m147a(false);
    }

    /* renamed from: j */
    public final synchronized void m187j() {
        this.f284p.testNativeCrash();
    }

    /* renamed from: k */
    public final synchronized void m188k() {
        int i = 0;
        synchronized (this) {
            C0030b c0030b = this.f287s;
            while (true) {
                int i2 = i + 1;
                if (i >= 30) {
                    break;
                }
                C0073w.m519a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                try {
                    Thread.sleep(5000);
                    i = i2;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    i = i2;
                } catch (Throwable th) {
                    if (!C0073w.m520a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: l */
    public final boolean m189l() {
        return this.f287s.m148a();
    }

    /* renamed from: a */
    public final void m178a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        final Thread thread2 = thread;
        final Throwable th2 = th;
        final byte[] bArr2 = null;
        this.f286r.m516b(new Runnable(this, false, null) {
            /* renamed from: f */
            private /* synthetic */ C0035c f267f;

            public final void run() {
                try {
                    C0073w.m523c("post a throwable %b", Boolean.valueOf(false));
                    this.f267f.f283o.m207a(thread2, th2, false, null, bArr2);
                } catch (Throwable th) {
                    if (!C0073w.m522b(th)) {
                        th.printStackTrace();
                    }
                    C0073w.m525e("java catch error: %s", th2.toString());
                }
            }
        });
    }

    /* renamed from: a */
    public final void m177a(CrashDetailBean crashDetailBean) {
        this.f280k.m170c(crashDetailBean);
    }

    /* renamed from: a */
    public final void m175a(long j) {
        C0072v.m511a().m514a(new C00342(this), j);
    }
}
