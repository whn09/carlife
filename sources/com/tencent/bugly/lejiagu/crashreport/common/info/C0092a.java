package com.tencent.bugly.lejiagu.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.common.info.a */
public final class C0092a {
    /* renamed from: T */
    private static C0092a f695T = null;
    /* renamed from: A */
    private String f696A = "unknown";
    /* renamed from: B */
    private String f697B = "unknown";
    /* renamed from: C */
    private String f698C = "";
    /* renamed from: D */
    private String f699D = null;
    /* renamed from: E */
    private String f700E = null;
    /* renamed from: F */
    private String f701F = null;
    /* renamed from: G */
    private String f702G = null;
    /* renamed from: H */
    private long f703H = -1;
    /* renamed from: I */
    private long f704I = -1;
    /* renamed from: J */
    private long f705J = -1;
    /* renamed from: K */
    private String f706K = null;
    /* renamed from: L */
    private String f707L = null;
    /* renamed from: M */
    private Map<String, PlugInBean> f708M = null;
    /* renamed from: N */
    private boolean f709N = true;
    /* renamed from: O */
    private String f710O = null;
    /* renamed from: P */
    private String f711P = null;
    /* renamed from: Q */
    private Boolean f712Q = null;
    /* renamed from: R */
    private String f713R = null;
    /* renamed from: S */
    private Map<String, PlugInBean> f714S = null;
    /* renamed from: U */
    private int f715U = -1;
    /* renamed from: V */
    private int f716V = -1;
    /* renamed from: W */
    private Map<String, String> f717W = new HashMap();
    /* renamed from: X */
    private Map<String, String> f718X = new HashMap();
    /* renamed from: Y */
    private final Object f719Y = new Object();
    /* renamed from: Z */
    private final Object f720Z = new Object();
    /* renamed from: a */
    public final long f721a = System.currentTimeMillis();
    /* renamed from: b */
    public final byte f722b;
    /* renamed from: c */
    public String f723c;
    /* renamed from: d */
    public final String f724d;
    /* renamed from: e */
    public final String f725e;
    /* renamed from: f */
    public final String f726f;
    /* renamed from: g */
    public final String f727g;
    /* renamed from: h */
    public long f728h;
    /* renamed from: i */
    public String f729i = null;
    /* renamed from: j */
    public String f730j = null;
    /* renamed from: k */
    public String f731k = null;
    /* renamed from: l */
    public String f732l = null;
    /* renamed from: m */
    public List<String> f733m = null;
    /* renamed from: n */
    public boolean f734n;
    /* renamed from: o */
    public String f735o = "unknown";
    /* renamed from: p */
    public long f736p = 0;
    /* renamed from: q */
    public long f737q = 0;
    /* renamed from: r */
    public long f738r = 0;
    /* renamed from: s */
    public long f739s = 0;
    /* renamed from: t */
    public boolean f740t = false;
    /* renamed from: u */
    public String f741u = null;
    /* renamed from: v */
    public String f742v = null;
    /* renamed from: w */
    public String f743w = null;
    /* renamed from: x */
    private final Context f744x;
    /* renamed from: y */
    private String f745y;
    /* renamed from: z */
    private String f746z;

    private C0092a(Context context) {
        Context context2;
        if (context == null) {
            context2 = context;
        } else {
            context2 = context.getApplicationContext();
            if (context2 == null) {
                context2 = context;
            }
        }
        this.f744x = context2;
        this.f722b = (byte) 1;
        PackageInfo b = AppInfo.m592b(context);
        if (b != null) {
            this.f729i = AppInfo.m589a(b);
            this.f741u = this.f729i;
            this.f742v = AppInfo.m593b(b);
        }
        this.f723c = AppInfo.m588a(context);
        this.f724d = AppInfo.m594c(context);
        this.f725e = C0124a.m836m();
        this.f726f = C0124a.m813b();
        this.f727g = "Android " + C0124a.m822c() + ",level " + C0124a.m824d();
        this.f726f + ";" + this.f727g;
        Map d = AppInfo.m595d(context);
        if (d != null) {
            try {
                this.f733m = AppInfo.m590a(d);
                String str = (String) d.get("BUGLY_APPID");
                if (str != null) {
                    this.f711P = str;
                }
                str = (String) d.get("BUGLY_APP_VERSION");
                if (str != null) {
                    this.f729i = str;
                }
                str = (String) d.get("BUGLY_APP_CHANNEL");
                if (str != null) {
                    this.f730j = str;
                }
                str = (String) d.get("BUGLY_ENABLE_DEBUG");
                if (str != null) {
                    boolean z;
                    if (str.toLowerCase().equals("true")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f740t = z;
                }
                str = (String) d.get("com.tencent.rdm.uuid");
                if (str != null) {
                    this.f743w = str;
                }
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
        C0148u.m1039c("com info create end", new Object[0]);
    }

    /* renamed from: a */
    public static synchronized C0092a m598a(Context context) {
        C0092a c0092a;
        synchronized (C0092a.class) {
            if (f695T == null) {
                f695T = new C0092a(context);
            }
            c0092a = f695T;
        }
        return c0092a;
    }

    /* renamed from: a */
    public static synchronized C0092a m597a() {
        C0092a c0092a;
        synchronized (C0092a.class) {
            c0092a = f695T;
        }
        return c0092a;
    }

    /* renamed from: b */
    public static String m599b() {
        return "2.1.6";
    }

    /* renamed from: c */
    public final void m610c() {
        synchronized (this.f719Y) {
            this.f745y = UUID.randomUUID().toString();
        }
    }

    /* renamed from: d */
    public final String m612d() {
        if (this.f745y == null) {
            synchronized (this.f719Y) {
                if (this.f745y == null) {
                    this.f745y = UUID.randomUUID().toString();
                }
            }
        }
        return this.f745y;
    }

    /* renamed from: e */
    public final String m614e() {
        String str = null;
        Object obj = (str == null || str.trim().length() <= 0) ? 1 : null;
        return obj == null ? str : this.f711P;
    }

    /* renamed from: a */
    public final void m606a(String str) {
        this.f711P = str;
    }

    /* renamed from: f */
    public final synchronized String m616f() {
        return this.f696A;
    }

    /* renamed from: b */
    public final synchronized void m608b(String str) {
        if (str == null) {
            str = "10000";
        }
        this.f696A = str;
    }

    /* renamed from: g */
    public final synchronized String m618g() {
        String str;
        if (this.f746z != null) {
            str = this.f746z;
        } else {
            this.f746z = m622j() + "|" + m624l() + "|" + m625m();
            str = this.f746z;
        }
        return str;
    }

    /* renamed from: c */
    public final synchronized void m611c(String str) {
        this.f746z = str;
    }

    /* renamed from: h */
    public final synchronized String m620h() {
        return this.f697B;
    }

    /* renamed from: d */
    public final synchronized void m613d(String str) {
        this.f697B = str;
    }

    /* renamed from: i */
    public final synchronized String m621i() {
        return this.f698C;
    }

    /* renamed from: e */
    public final synchronized void m615e(String str) {
        this.f698C = str;
    }

    /* renamed from: j */
    public final synchronized String m622j() {
        String str;
        if (this.f709N) {
            if (this.f699D == null) {
                this.f699D = C0124a.m791a(this.f744x);
            }
            str = this.f699D;
        } else {
            str = "";
        }
        return str;
    }

    /* renamed from: k */
    public final synchronized String m623k() {
        String str;
        if (this.f709N) {
            if (this.f700E == null) {
                this.f700E = C0124a.m825d(this.f744x);
            }
            str = this.f700E;
        } else {
            str = "";
        }
        return str;
    }

    /* renamed from: l */
    public final synchronized String m624l() {
        String str;
        if (this.f709N) {
            if (this.f701F == null) {
                this.f701F = C0124a.m814b(this.f744x);
            }
            str = this.f701F;
        } else {
            str = "";
        }
        return str;
    }

    /* renamed from: m */
    public final synchronized String m625m() {
        String str;
        if (this.f709N) {
            if (this.f702G == null) {
                this.f702G = C0124a.m823c(this.f744x);
            }
            str = this.f702G;
        } else {
            str = "";
        }
        return str;
    }

    /* renamed from: n */
    public final synchronized long m626n() {
        if (this.f703H <= 0) {
            this.f703H = C0124a.m828f();
        }
        return this.f703H;
    }

    /* renamed from: o */
    public final synchronized long m627o() {
        if (this.f704I <= 0) {
            this.f704I = C0124a.m831h();
        }
        return this.f704I;
    }

    /* renamed from: p */
    public final synchronized long m628p() {
        if (this.f705J <= 0) {
            this.f705J = C0124a.m833j();
        }
        return this.f705J;
    }

    /* renamed from: q */
    public final synchronized String m629q() {
        if (this.f706K == null) {
            this.f706K = C0124a.m826e();
        }
        return this.f706K;
    }

    /* renamed from: r */
    public final String m630r() {
        if (this.f707L == null) {
            synchronized (this.f720Z) {
                if (this.f707L == null) {
                    this.f707L = C0124a.m793a(this.f744x, "ro.board.platform");
                }
            }
        }
        return this.f707L;
    }

    /* renamed from: s */
    public final synchronized Map<String, PlugInBean> m631s() {
        return null;
    }

    /* renamed from: t */
    public final String m632t() {
        if (this.f710O == null) {
            this.f710O = C0124a.m835l();
        }
        return this.f710O;
    }

    /* renamed from: u */
    public final synchronized Boolean m633u() {
        if (this.f712Q == null) {
            this.f712Q = Boolean.valueOf(C0124a.m829f(this.f744x));
        }
        return this.f712Q;
    }

    /* renamed from: v */
    public final synchronized String m634v() {
        String str;
        Object obj = null;
        synchronized (this) {
            if (this.f713R == null) {
                int i;
                Object obj2;
                StringBuilder stringBuilder = new StringBuilder();
                Context context = this.f744x;
                String a = C0124a.m793a(context, "ro.miui.ui.version.name");
                if (a == null || a.trim().length() <= 0) {
                    i = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null || a.equals("fail")) {
                    a = C0124a.m793a(context, "ro.build.version.emui");
                    if (a == null || a.trim().length() <= 0) {
                        i = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null || a.equals("fail")) {
                        a = C0124a.m793a(context, "ro.lenovo.series");
                        if (a == null || a.trim().length() <= 0) {
                            i = 1;
                        } else {
                            obj2 = null;
                        }
                        if (obj2 != null || a.equals("fail")) {
                            a = C0124a.m793a(context, "ro.build.nubia.rom.name");
                            if (a == null || a.trim().length() <= 0) {
                                i = 1;
                            } else {
                                obj2 = null;
                            }
                            if (obj2 != null || a.equals("fail")) {
                                a = C0124a.m793a(context, "ro.meizu.product.model");
                                if (a == null || a.trim().length() <= 0) {
                                    i = 1;
                                } else {
                                    obj2 = null;
                                }
                                if (obj2 != null || a.equals("fail")) {
                                    a = C0124a.m793a(context, "ro.build.version.opporom");
                                    if (a == null || a.trim().length() <= 0) {
                                        i = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if (obj2 != null || a.equals("fail")) {
                                        a = C0124a.m793a(context, "ro.vivo.os.build.display.id");
                                        if (a == null || a.trim().length() <= 0) {
                                            i = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if (obj2 != null || a.equals("fail")) {
                                            a = C0124a.m793a(context, "ro.aa.romver");
                                            if (a == null || a.trim().length() <= 0) {
                                                i = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if (obj2 != null || a.equals("fail")) {
                                                a = C0124a.m793a(context, "ro.lewa.version");
                                                if (a == null || a.trim().length() <= 0) {
                                                    i = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if (obj2 != null || a.equals("fail")) {
                                                    a = C0124a.m793a(context, "ro.gn.gnromvernumber");
                                                    if (a == null || a.trim().length() <= 0) {
                                                        i = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if (obj2 != null || a.equals("fail")) {
                                                        String a2 = C0124a.m793a(context, "ro.build.tyd.kbstyle_version");
                                                        if (a2 == null || a2.trim().length() <= 0) {
                                                            int i2 = 1;
                                                        }
                                                        str = (obj != null || a2.equals("fail")) ? C0124a.m793a(context, "ro.build.fingerprint") + "/" + C0124a.m793a(context, "ro.build.rom.id") : "dido/" + a2;
                                                    } else {
                                                        str = "amigo/" + a + "/" + C0124a.m793a(context, "ro.build.display.id");
                                                    }
                                                } else {
                                                    str = "tcl/" + a + "/" + C0124a.m793a(context, "ro.build.display.id");
                                                }
                                            } else {
                                                str = "htc/" + a + "/" + C0124a.m793a(context, "ro.build.description");
                                            }
                                        } else {
                                            str = "vivo/FUNTOUCH/" + a;
                                        }
                                    } else {
                                        str = "Oppo/COLOROS/" + a;
                                    }
                                } else {
                                    str = "Meizu/FLYME/" + C0124a.m793a(context, "ro.build.display.id");
                                }
                            } else {
                                str = "Zte/NUBIA/" + a + "_" + C0124a.m793a(context, "ro.build.nubia.rom.code");
                            }
                        } else {
                            str = "Lenovo/VIBE/" + C0124a.m793a(context, "ro.build.version.incremental");
                        }
                    } else {
                        str = "HuaWei/EMOTION/" + a;
                    }
                } else {
                    str = "XiaoMi/MIUI/" + a;
                }
                this.f713R = stringBuilder.append(str).toString();
                C0148u.m1035a("rom:%s", this.f713R);
            }
            str = this.f713R;
        }
        return str;
    }

    /* renamed from: w */
    public final synchronized Map<String, String> m635w() {
        Map<String, String> map;
        if (this.f717W.size() <= 0) {
            map = null;
        } else {
            map = new HashMap(this.f717W);
        }
        return map;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final synchronized java.lang.String m617f(java.lang.String r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        monitor-enter(r4);
        if (r5 == 0) goto L_0x002c;
    L_0x0005:
        r2 = r5.trim();	 Catch:{ all -> 0x0037 }
        r2 = r2.length();	 Catch:{ all -> 0x0037 }
        if (r2 <= 0) goto L_0x002c;
    L_0x000f:
        if (r0 == 0) goto L_0x002e;
    L_0x0011:
        r0 = "key should not be empty %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0037 }
        r2 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0037 }
        r3.<init>();	 Catch:{ all -> 0x0037 }
        r3 = r3.append(r5);	 Catch:{ all -> 0x0037 }
        r3 = r3.toString();	 Catch:{ all -> 0x0037 }
        r1[r2] = r3;	 Catch:{ all -> 0x0037 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r0, r1);	 Catch:{ all -> 0x0037 }
        r0 = 0;
    L_0x002a:
        monitor-exit(r4);
        return r0;
    L_0x002c:
        r0 = r1;
        goto L_0x000f;
    L_0x002e:
        r0 = r4.f717W;	 Catch:{ all -> 0x0037 }
        r0 = r0.remove(r5);	 Catch:{ all -> 0x0037 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0037 }
        goto L_0x002a;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.lejiagu.crashreport.common.info.a.f(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final synchronized java.lang.String m619g(java.lang.String r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        monitor-enter(r4);
        if (r5 == 0) goto L_0x002c;
    L_0x0005:
        r2 = r5.trim();	 Catch:{ all -> 0x0037 }
        r2 = r2.length();	 Catch:{ all -> 0x0037 }
        if (r2 <= 0) goto L_0x002c;
    L_0x000f:
        if (r0 == 0) goto L_0x002e;
    L_0x0011:
        r0 = "key should not be empty %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0037 }
        r2 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0037 }
        r3.<init>();	 Catch:{ all -> 0x0037 }
        r3 = r3.append(r5);	 Catch:{ all -> 0x0037 }
        r3 = r3.toString();	 Catch:{ all -> 0x0037 }
        r1[r2] = r3;	 Catch:{ all -> 0x0037 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r0, r1);	 Catch:{ all -> 0x0037 }
        r0 = 0;
    L_0x002a:
        monitor-exit(r4);
        return r0;
    L_0x002c:
        r0 = r1;
        goto L_0x000f;
    L_0x002e:
        r0 = r4.f717W;	 Catch:{ all -> 0x0037 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0037 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0037 }
        goto L_0x002a;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.lejiagu.crashreport.common.info.a.g(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public final synchronized void m607a(String str, String str2) {
        Object obj = null;
        synchronized (this) {
            Object obj2;
            if (str != null) {
                if (str.trim().length() > 0) {
                    obj2 = null;
                    if (obj2 == null) {
                        if (str2 == null || str2.trim().length() <= 0) {
                            int i = 1;
                        }
                        if (obj == null) {
                            this.f717W.put(str, str2);
                        }
                    }
                    C0148u.m1040d("key&value should not be empty %s %s", str, str2);
                }
            }
            int i2 = 1;
            if (obj2 == null) {
                int i3 = 1;
                if (obj == null) {
                    this.f717W.put(str, str2);
                }
            }
            C0148u.m1040d("key&value should not be empty %s %s", str, str2);
        }
    }

    /* renamed from: x */
    public final synchronized int m636x() {
        return this.f717W.size();
    }

    /* renamed from: y */
    public final synchronized Set<String> m637y() {
        return this.f717W.keySet();
    }

    /* renamed from: b */
    public final synchronized void m609b(String str, String str2) {
        Object obj = null;
        synchronized (this) {
            Object obj2;
            if (str != null) {
                if (str.trim().length() > 0) {
                    obj2 = null;
                    if (obj2 == null) {
                        if (str2 == null || str2.trim().length() <= 0) {
                            int i = 1;
                        }
                        if (obj == null) {
                            this.f718X.put(str, str2);
                        }
                    }
                    C0148u.m1040d("server key&value should not be empty %s %s", str, str2);
                }
            }
            int i2 = 1;
            if (obj2 == null) {
                int i3 = 1;
                if (obj == null) {
                    this.f718X.put(str, str2);
                }
            }
            C0148u.m1040d("server key&value should not be empty %s %s", str, str2);
        }
    }

    /* renamed from: z */
    public final synchronized Map<String, String> m638z() {
        Map<String, String> map;
        if (this.f718X.size() <= 0) {
            map = null;
        } else {
            map = new HashMap(this.f718X);
        }
        return map;
    }

    /* renamed from: a */
    public final synchronized void m605a(int i) {
        if (this.f715U != i) {
            this.f715U = i;
            C0148u.m1035a("user scene tag %d changed to tag %d", Integer.valueOf(r0), Integer.valueOf(this.f715U));
        }
    }

    /* renamed from: A */
    public final synchronized int m600A() {
        return this.f715U;
    }

    /* renamed from: B */
    public final synchronized int m601B() {
        return this.f716V;
    }

    /* renamed from: C */
    public final synchronized boolean m602C() {
        return AppInfo.m596e(this.f744x);
    }

    /* renamed from: D */
    public final synchronized Map<String, PlugInBean> m603D() {
        return null;
    }

    /* renamed from: E */
    public final synchronized int m604E() {
        return C0124a.m824d();
    }
}
