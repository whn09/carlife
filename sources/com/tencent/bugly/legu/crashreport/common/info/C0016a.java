package com.tencent.bugly.legu.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.bugly.legu.C0005b;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0073w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.common.info.a */
public final class C0016a {
    /* renamed from: V */
    private static C0016a f88V = null;
    /* renamed from: A */
    private String f89A;
    /* renamed from: B */
    private String f90B;
    /* renamed from: C */
    private String f91C = "unknown";
    /* renamed from: D */
    private String f92D = "unknown";
    /* renamed from: E */
    private String f93E = "";
    /* renamed from: F */
    private String f94F = null;
    /* renamed from: G */
    private String f95G = null;
    /* renamed from: H */
    private String f96H = null;
    /* renamed from: I */
    private String f97I = null;
    /* renamed from: J */
    private long f98J = -1;
    /* renamed from: K */
    private long f99K = -1;
    /* renamed from: L */
    private long f100L = -1;
    /* renamed from: M */
    private String f101M = null;
    /* renamed from: N */
    private String f102N = null;
    /* renamed from: O */
    private Map<String, PlugInBean> f103O = null;
    /* renamed from: P */
    private boolean f104P = true;
    /* renamed from: Q */
    private String f105Q = null;
    /* renamed from: R */
    private String f106R = null;
    /* renamed from: S */
    private Boolean f107S = null;
    /* renamed from: T */
    private String f108T = null;
    /* renamed from: U */
    private Map<String, PlugInBean> f109U = null;
    /* renamed from: W */
    private int f110W = -1;
    /* renamed from: X */
    private int f111X = -1;
    /* renamed from: Y */
    private Map<String, String> f112Y = new HashMap();
    /* renamed from: Z */
    private Map<String, String> f113Z = new HashMap();
    /* renamed from: a */
    public final long f114a = System.currentTimeMillis();
    private final Object aa = new Object();
    private final Object ab = new Object();
    /* renamed from: b */
    public final byte f115b;
    /* renamed from: c */
    public String f116c;
    /* renamed from: d */
    public final String f117d;
    /* renamed from: e */
    public final String f118e;
    /* renamed from: f */
    public final String f119f;
    /* renamed from: g */
    public final String f120g;
    /* renamed from: h */
    public long f121h;
    /* renamed from: i */
    public String f122i = null;
    /* renamed from: j */
    public String f123j = null;
    /* renamed from: k */
    public String f124k = null;
    /* renamed from: l */
    public String f125l = null;
    /* renamed from: m */
    public List<String> f126m = null;
    /* renamed from: n */
    public boolean f127n;
    /* renamed from: o */
    public String f128o = "unknown";
    /* renamed from: p */
    public long f129p = 0;
    /* renamed from: q */
    public long f130q = 0;
    /* renamed from: r */
    public long f131r = 0;
    /* renamed from: s */
    public long f132s = 0;
    /* renamed from: t */
    public boolean f133t = false;
    /* renamed from: u */
    public String f134u = null;
    /* renamed from: v */
    public String f135v = null;
    /* renamed from: w */
    public String f136w = null;
    /* renamed from: x */
    public boolean f137x = false;
    /* renamed from: y */
    public boolean f138y = false;
    /* renamed from: z */
    private final Context f139z;

    private C0016a(Context context) {
        Context context2;
        if (context == null) {
            context2 = context;
        } else {
            context2 = context.getApplicationContext();
            if (context2 == null) {
                context2 = context;
            }
        }
        this.f139z = context2;
        this.f115b = (byte) 1;
        PackageInfo b = AppInfo.m64b(context);
        if (b != null) {
            this.f122i = AppInfo.m61a(b);
            this.f134u = this.f122i;
            this.f135v = AppInfo.m65b(b);
        }
        this.f116c = AppInfo.m60a(context);
        this.f117d = AppInfo.m66c(context);
        this.f118e = C0048a.m302m();
        this.f119f = C0048a.m279b();
        this.f120g = "Android " + C0048a.m288c() + ",level " + C0048a.m290d();
        this.f119f + ";" + this.f120g;
        Map d = AppInfo.m67d(context);
        if (d != null) {
            try {
                this.f126m = AppInfo.m62a(d);
                String str = (String) d.get("BUGLY_APPID");
                if (str != null) {
                    this.f106R = str;
                }
                str = (String) d.get("BUGLY_APP_VERSION");
                if (str != null) {
                    this.f122i = str;
                }
                str = (String) d.get("BUGLY_APP_CHANNEL");
                if (str != null) {
                    this.f123j = str;
                }
                str = (String) d.get("BUGLY_ENABLE_DEBUG");
                if (str != null) {
                    boolean z;
                    if (str.toLowerCase().equals("true")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f133t = z;
                }
                str = (String) d.get("com.tencent.rdm.uuid");
                if (str != null) {
                    this.f136w = str;
                }
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_legu").exists()) {
                this.f138y = true;
                C0073w.m523c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th2) {
            if (C0005b.f34b) {
                th2.printStackTrace();
            }
        }
        C0073w.m523c("com info create end", new Object[0]);
    }

    /* renamed from: a */
    public static synchronized C0016a m70a(Context context) {
        C0016a c0016a;
        synchronized (C0016a.class) {
            if (f88V == null) {
                f88V = new C0016a(context);
            }
            c0016a = f88V;
        }
        return c0016a;
    }

    /* renamed from: a */
    public static synchronized C0016a m69a() {
        C0016a c0016a;
        synchronized (C0016a.class) {
            c0016a = f88V;
        }
        return c0016a;
    }

    /* renamed from: b */
    public static String m71b() {
        return "2.1.9";
    }

    /* renamed from: c */
    public final void m83c() {
        synchronized (this.aa) {
            this.f89A = UUID.randomUUID().toString();
        }
    }

    /* renamed from: d */
    public final String m85d() {
        if (this.f89A == null) {
            synchronized (this.aa) {
                if (this.f89A == null) {
                    this.f89A = UUID.randomUUID().toString();
                }
            }
        }
        return this.f89A;
    }

    /* renamed from: e */
    public final String m87e() {
        String str = null;
        Object obj = (str == null || str.trim().length() <= 0) ? 1 : null;
        return obj == null ? str : this.f106R;
    }

    /* renamed from: a */
    public final void m79a(String str) {
        this.f106R = str;
    }

    /* renamed from: f */
    public final synchronized String m89f() {
        return this.f91C;
    }

    /* renamed from: b */
    public final synchronized void m81b(String str) {
        if (str == null) {
            str = "10000";
        }
        this.f91C = str;
    }

    /* renamed from: g */
    public final synchronized String m91g() {
        String str;
        if (this.f90B != null) {
            str = this.f90B;
        } else {
            this.f90B = m95j() + "|" + m97l() + "|" + m98m();
            str = this.f90B;
        }
        return str;
    }

    /* renamed from: c */
    public final synchronized void m84c(String str) {
        this.f90B = str;
    }

    /* renamed from: h */
    public final synchronized String m93h() {
        return this.f92D;
    }

    /* renamed from: d */
    public final synchronized void m86d(String str) {
        this.f92D = str;
    }

    /* renamed from: i */
    public final synchronized String m94i() {
        return this.f93E;
    }

    /* renamed from: e */
    public final synchronized void m88e(String str) {
        this.f93E = str;
    }

    /* renamed from: j */
    public final synchronized String m95j() {
        String str;
        if (this.f104P) {
            if (this.f94F == null) {
                this.f94F = C0048a.m257a(this.f139z);
            }
            str = this.f94F;
        } else {
            str = "";
        }
        return str;
    }

    /* renamed from: k */
    public final synchronized String m96k() {
        String str;
        if (this.f104P) {
            if (this.f95G == null) {
                this.f95G = C0048a.m291d(this.f139z);
            }
            str = this.f95G;
        } else {
            str = "";
        }
        return str;
    }

    /* renamed from: l */
    public final synchronized String m97l() {
        String str;
        if (this.f104P) {
            if (this.f96H == null) {
                this.f96H = C0048a.m280b(this.f139z);
            }
            str = this.f96H;
        } else {
            str = "";
        }
        return str;
    }

    /* renamed from: m */
    public final synchronized String m98m() {
        String str;
        if (this.f104P) {
            if (this.f97I == null) {
                this.f97I = C0048a.m289c(this.f139z);
            }
            str = this.f97I;
        } else {
            str = "";
        }
        return str;
    }

    /* renamed from: n */
    public final synchronized long m99n() {
        if (this.f98J <= 0) {
            this.f98J = C0048a.m294f();
        }
        return this.f98J;
    }

    /* renamed from: o */
    public final synchronized long m100o() {
        if (this.f99K <= 0) {
            this.f99K = C0048a.m297h();
        }
        return this.f99K;
    }

    /* renamed from: p */
    public final synchronized long m101p() {
        if (this.f100L <= 0) {
            this.f100L = C0048a.m299j();
        }
        return this.f100L;
    }

    /* renamed from: q */
    public final synchronized String m102q() {
        if (this.f101M == null) {
            this.f101M = C0048a.m292e();
        }
        return this.f101M;
    }

    /* renamed from: r */
    public final String m103r() {
        if (this.f102N == null) {
            synchronized (this.ab) {
                if (this.f102N == null) {
                    this.f102N = C0048a.m259a(this.f139z, "ro.board.platform");
                }
            }
        }
        return this.f102N;
    }

    /* renamed from: s */
    public final synchronized Map<String, PlugInBean> m104s() {
        return null;
    }

    /* renamed from: t */
    public final String m105t() {
        if (this.f105Q == null) {
            this.f105Q = C0048a.m301l();
        }
        return this.f105Q;
    }

    /* renamed from: u */
    public final synchronized Boolean m106u() {
        if (this.f107S == null) {
            this.f107S = Boolean.valueOf(C0048a.m295f(this.f139z));
        }
        return this.f107S;
    }

    /* renamed from: v */
    public final synchronized String m107v() {
        String str;
        Object obj = null;
        synchronized (this) {
            if (this.f108T == null) {
                int i;
                Object obj2;
                StringBuilder stringBuilder = new StringBuilder();
                Context context = this.f139z;
                String a = C0048a.m259a(context, "ro.miui.ui.version.name");
                if (a == null || a.trim().length() <= 0) {
                    i = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null || a.equals("fail")) {
                    a = C0048a.m259a(context, "ro.build.version.emui");
                    if (a == null || a.trim().length() <= 0) {
                        i = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null || a.equals("fail")) {
                        a = C0048a.m259a(context, "ro.lenovo.series");
                        if (a == null || a.trim().length() <= 0) {
                            i = 1;
                        } else {
                            obj2 = null;
                        }
                        if (obj2 != null || a.equals("fail")) {
                            a = C0048a.m259a(context, "ro.build.nubia.rom.name");
                            if (a == null || a.trim().length() <= 0) {
                                i = 1;
                            } else {
                                obj2 = null;
                            }
                            if (obj2 != null || a.equals("fail")) {
                                a = C0048a.m259a(context, "ro.meizu.product.model");
                                if (a == null || a.trim().length() <= 0) {
                                    i = 1;
                                } else {
                                    obj2 = null;
                                }
                                if (obj2 != null || a.equals("fail")) {
                                    a = C0048a.m259a(context, "ro.build.version.opporom");
                                    if (a == null || a.trim().length() <= 0) {
                                        i = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if (obj2 != null || a.equals("fail")) {
                                        a = C0048a.m259a(context, "ro.vivo.os.build.display.id");
                                        if (a == null || a.trim().length() <= 0) {
                                            i = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if (obj2 != null || a.equals("fail")) {
                                            a = C0048a.m259a(context, "ro.aa.romver");
                                            if (a == null || a.trim().length() <= 0) {
                                                i = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if (obj2 != null || a.equals("fail")) {
                                                a = C0048a.m259a(context, "ro.lewa.version");
                                                if (a == null || a.trim().length() <= 0) {
                                                    i = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if (obj2 != null || a.equals("fail")) {
                                                    a = C0048a.m259a(context, "ro.gn.gnromvernumber");
                                                    if (a == null || a.trim().length() <= 0) {
                                                        i = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if (obj2 != null || a.equals("fail")) {
                                                        String a2 = C0048a.m259a(context, "ro.build.tyd.kbstyle_version");
                                                        if (a2 == null || a2.trim().length() <= 0) {
                                                            int i2 = 1;
                                                        }
                                                        str = (obj != null || a2.equals("fail")) ? C0048a.m259a(context, "ro.build.fingerprint") + "/" + C0048a.m259a(context, "ro.build.rom.id") : "dido/" + a2;
                                                    } else {
                                                        str = "amigo/" + a + "/" + C0048a.m259a(context, "ro.build.display.id");
                                                    }
                                                } else {
                                                    str = "tcl/" + a + "/" + C0048a.m259a(context, "ro.build.display.id");
                                                }
                                            } else {
                                                str = "htc/" + a + "/" + C0048a.m259a(context, "ro.build.description");
                                            }
                                        } else {
                                            str = "vivo/FUNTOUCH/" + a;
                                        }
                                    } else {
                                        str = "Oppo/COLOROS/" + a;
                                    }
                                } else {
                                    str = "Meizu/FLYME/" + C0048a.m259a(context, "ro.build.display.id");
                                }
                            } else {
                                str = "Zte/NUBIA/" + a + "_" + C0048a.m259a(context, "ro.build.nubia.rom.code");
                            }
                        } else {
                            str = "Lenovo/VIBE/" + C0048a.m259a(context, "ro.build.version.incremental");
                        }
                    } else {
                        str = "HuaWei/EMOTION/" + a;
                    }
                } else {
                    str = "XiaoMi/MIUI/" + a;
                }
                this.f108T = stringBuilder.append(str).toString();
                C0073w.m519a("rom:%s", this.f108T);
            }
            str = this.f108T;
        }
        return str;
    }

    /* renamed from: w */
    public final synchronized Map<String, String> m108w() {
        Map<String, String> map;
        if (this.f112Y.size() <= 0) {
            map = null;
        } else {
            map = new HashMap(this.f112Y);
        }
        return map;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final synchronized java.lang.String m90f(java.lang.String r5) {
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
        com.tencent.bugly.legu.proguard.C0073w.m524d(r0, r1);	 Catch:{ all -> 0x0037 }
        r0 = 0;
    L_0x002a:
        monitor-exit(r4);
        return r0;
    L_0x002c:
        r0 = r1;
        goto L_0x000f;
    L_0x002e:
        r0 = r4.f112Y;	 Catch:{ all -> 0x0037 }
        r0 = r0.remove(r5);	 Catch:{ all -> 0x0037 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0037 }
        goto L_0x002a;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.legu.crashreport.common.info.a.f(java.lang.String):java.lang.String");
    }

    /* renamed from: x */
    public final synchronized void m109x() {
        this.f112Y.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final synchronized java.lang.String m92g(java.lang.String r5) {
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
        com.tencent.bugly.legu.proguard.C0073w.m524d(r0, r1);	 Catch:{ all -> 0x0037 }
        r0 = 0;
    L_0x002a:
        monitor-exit(r4);
        return r0;
    L_0x002c:
        r0 = r1;
        goto L_0x000f;
    L_0x002e:
        r0 = r4.f112Y;	 Catch:{ all -> 0x0037 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0037 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0037 }
        goto L_0x002a;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.legu.crashreport.common.info.a.g(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public final synchronized void m80a(String str, String str2) {
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
                            this.f112Y.put(str, str2);
                        }
                    }
                    C0073w.m524d("key&value should not be empty %s %s", str, str2);
                }
            }
            int i2 = 1;
            if (obj2 == null) {
                int i3 = 1;
                if (obj == null) {
                    this.f112Y.put(str, str2);
                }
            }
            C0073w.m524d("key&value should not be empty %s %s", str, str2);
        }
    }

    /* renamed from: y */
    public final synchronized int m110y() {
        return this.f112Y.size();
    }

    /* renamed from: z */
    public final synchronized Set<String> m111z() {
        return this.f112Y.keySet();
    }

    /* renamed from: b */
    public final synchronized void m82b(String str, String str2) {
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
                            this.f113Z.put(str, str2);
                        }
                    }
                    C0073w.m524d("server key&value should not be empty %s %s", str, str2);
                }
            }
            int i2 = 1;
            if (obj2 == null) {
                int i3 = 1;
                if (obj == null) {
                    this.f113Z.put(str, str2);
                }
            }
            C0073w.m524d("server key&value should not be empty %s %s", str, str2);
        }
    }

    /* renamed from: A */
    public final synchronized Map<String, String> m72A() {
        Map<String, String> map;
        if (this.f113Z.size() <= 0) {
            map = null;
        } else {
            map = new HashMap(this.f113Z);
        }
        return map;
    }

    /* renamed from: a */
    public final synchronized void m78a(int i) {
        if (this.f110W != i) {
            this.f110W = i;
            C0073w.m519a("user scene tag %d changed to tag %d", Integer.valueOf(r0), Integer.valueOf(this.f110W));
        }
    }

    /* renamed from: B */
    public final synchronized int m73B() {
        return this.f110W;
    }

    /* renamed from: C */
    public final synchronized int m74C() {
        return this.f111X;
    }

    /* renamed from: D */
    public final synchronized boolean m75D() {
        return AppInfo.m68e(this.f139z);
    }

    /* renamed from: E */
    public final synchronized Map<String, PlugInBean> m76E() {
        return null;
    }

    /* renamed from: F */
    public final synchronized int m77F() {
        return C0048a.m290d();
    }
}
