package com.tencent.bugly.legu.proguard;

import android.content.Context;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.m */
public final class C0061m {
    /* renamed from: a */
    private static C0061m f510a = null;
    /* renamed from: b */
    private static long f511b = System.currentTimeMillis();

    private C0061m(Context context) {
    }

    /* renamed from: a */
    public static synchronized C0061m m421a(Context context) {
        C0061m c0061m;
        synchronized (C0061m.class) {
            if (f510a == null) {
                f510a = new C0061m(context);
            }
            c0061m = f510a;
        }
        return c0061m;
    }

    /* renamed from: a */
    public static synchronized C0061m m420a() {
        C0061m c0061m;
        synchronized (C0061m.class) {
            c0061m = f510a;
        }
        return c0061m;
    }

    /* renamed from: b */
    private synchronized boolean m423b(int i) {
        boolean z;
        try {
            String str = C0016a.m69a().f117d;
            if (str == null) {
                C0073w.m519a("process name is null", new Object[0]);
                z = false;
            } else {
                long d = m425d(0);
                C0064o a = C0064o.m440a();
                C0016a.m69a().getClass();
                List a2 = a.m463a(i, str, d, "2.1.9");
                if (a2 == null) {
                    z = false;
                } else if (a2.size() < 2) {
                    z = false;
                } else {
                    for (int i2 = 0; i2 + 1 < a2.size(); i2++) {
                        if (((C0060l) a2.get(i2 + 1)).f505c - ((C0060l) a2.get(i2)).f505c < 86400000) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                }
            }
        } catch (Exception e) {
            C0073w.m519a("FrenquencyCrash failed", new Object[0]);
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private synchronized C0060l m424c(int i) {
        C0060l c0060l = null;
        synchronized (this) {
            try {
                String str = C0016a.m69a().f117d;
                if (str == null) {
                    C0073w.m519a("process name is null", new Object[0]);
                } else {
                    c0060l = C0064o.m440a().m461a(i, str);
                }
            } catch (Exception e) {
                C0073w.m519a("getLatestCrashRecord failed", new Object[0]);
            }
        }
        return c0060l;
    }

    /* renamed from: a */
    public final synchronized boolean m427a(int i, int i2) {
        boolean z = false;
        synchronized (this) {
            try {
                C0060l c0060l = new C0060l();
                c0060l.f503a = 1004;
                c0060l.f504b = C0016a.m69a().f117d;
                c0060l.f508f = C0016a.m69a().f122i;
                C0016a.m69a().getClass();
                c0060l.f507e = "2.1.9";
                c0060l.f506d = i2;
                c0060l.f505c = System.currentTimeMillis();
                c0060l.f509g = f511b;
                z = C0064o.m440a().m467a(c0060l);
            } catch (Exception e) {
                C0073w.m519a("saveCrashRecord failed", new Object[0]);
            }
        }
        return z;
    }

    /* renamed from: b */
    private synchronized int m422b(int i, int i2) {
        int i3 = 0;
        synchronized (this) {
            try {
                i3 = C0064o.m440a().m457a(i, C0016a.m69a().f117d, m425d(1));
            } catch (Exception e) {
                C0073w.m519a("clearHistoryCrashRecord failed", new Object[0]);
            }
        }
        return i3;
    }

    /* renamed from: d */
    private synchronized long m425d(int i) {
        long j = 0;
        synchronized (this) {
            switch (i) {
                case 1:
                    j = System.currentTimeMillis() - 86400000;
                    break;
            }
        }
        return j;
    }

    /* renamed from: b */
    public final synchronized int m428b() {
        int i = 0;
        synchronized (this) {
            try {
                C0064o a = C0064o.m440a();
                C0016a.m69a().getClass();
                i = a.m469b();
            } catch (Exception e) {
                C0073w.m519a("clearInvalidCrashRecord failed", new Object[0]);
            }
        }
        return i;
    }

    /* renamed from: a */
    public final synchronized boolean m426a(int i) {
        boolean z = true;
        synchronized (this) {
            try {
                C0060l c = m424c(i);
                if (c != null && System.currentTimeMillis() - c.f505c <= 86400000 && m423b(i)) {
                    z = false;
                }
                if (z) {
                    m422b(i, 1);
                }
            } catch (Exception e) {
                C0073w.m519a("canInit failed", new Object[0]);
            }
        }
        return z;
    }
}
