package com.tencent.bugly.lejiagu.crashreport.common.strategy;

import android.content.Context;
import android.os.Parcel;
import com.tencent.bugly.lejiagu.C0080a;
import com.tencent.bugly.lejiagu.crashreport.biz.C0090b;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0139m;
import com.tencent.bugly.lejiagu.proguard.C0141o;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.an;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.common.strategy.a */
public final class C0095a {
    /* renamed from: a */
    public static int f771a = 1000;
    /* renamed from: b */
    private static C0095a f772b = null;
    /* renamed from: c */
    private final List<C0080a> f773c;
    /* renamed from: d */
    private final C0147t f774d;
    /* renamed from: e */
    private final StrategyBean f775e;
    /* renamed from: f */
    private StrategyBean f776f = null;
    /* renamed from: g */
    private Context f777g;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.common.strategy.a$1 */
    class C00941 extends Thread {
        /* renamed from: a */
        private /* synthetic */ C0095a f770a;

        C00941(C0095a c0095a) {
            this.f770a = c0095a;
        }

        public final void run() {
            try {
                Map a = C0139m.m963a().m982a(C0095a.f771a, null, true);
                if (a != null) {
                    byte[] bArr = (byte[]) a.get("key_imei");
                    byte[] bArr2 = (byte[]) a.get("key_ip");
                    if (bArr != null) {
                        C0092a.m598a(this.f770a.f777g).m615e(new String(bArr));
                    }
                    if (bArr2 != null) {
                        C0092a.m598a(this.f770a.f777g).m613d(new String(bArr2));
                    }
                }
                C0095a c0095a = this.f770a;
                this.f770a.f776f = C0095a.m644d();
                this.f770a.m645a(this.f770a.f776f);
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private C0095a(Context context, List<C0080a> list) {
        this.f777g = context;
        this.f775e = new StrategyBean();
        this.f773c = list;
        this.f774d = C0147t.m1027a();
        this.f774d.m1032b(new C00941(this));
    }

    /* renamed from: a */
    public static synchronized C0095a m642a(Context context, List<C0080a> list) {
        C0095a c0095a;
        synchronized (C0095a.class) {
            if (f772b == null) {
                f772b = new C0095a(context, list);
            }
            c0095a = f772b;
        }
        return c0095a;
    }

    /* renamed from: a */
    public static synchronized C0095a m641a() {
        C0095a c0095a;
        synchronized (C0095a.class) {
            c0095a = f772b;
        }
        return c0095a;
    }

    /* renamed from: b */
    public final synchronized boolean m647b() {
        return this.f776f != null;
    }

    /* renamed from: c */
    public final StrategyBean m648c() {
        if (this.f776f != null) {
            return this.f776f;
        }
        return this.f775e;
    }

    /* renamed from: a */
    protected final void m645a(StrategyBean strategyBean) {
        for (C0080a c0080a : this.f773c) {
            try {
                C0148u.m1039c("[strategy] Notify %s", c0080a.getClass().getName());
                c0080a.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
        C0090b.m573a(strategyBean);
    }

    /* renamed from: a */
    public final void m646a(an anVar) {
        if (anVar != null) {
            if (this.f776f == null || anVar.f1063h != this.f776f.f761l) {
                StrategyBean strategyBean = new StrategyBean();
                strategyBean.f753d = anVar.f1056a;
                strategyBean.f755f = anVar.f1058c;
                strategyBean.f754e = anVar.f1057b;
                String str = anVar.f1059d;
                boolean z = str == null || str.trim().length() <= 0;
                if (!z) {
                    C0148u.m1039c("upload url changes to %s", anVar.f1059d);
                    strategyBean.f763n = anVar.f1059d;
                }
                str = anVar.f1060e;
                if (str == null || str.trim().length() <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    C0148u.m1039c("exception upload url changes to %s", anVar.f1060e);
                    strategyBean.f764o = anVar.f1060e;
                }
                if (anVar.f1061f != null) {
                    str = anVar.f1061f.f1051a;
                    if (str == null || str.trim().length() <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        strategyBean.f766q = anVar.f1061f.f1051a;
                    }
                }
                if (anVar.f1063h != 0) {
                    strategyBean.f761l = anVar.f1063h;
                }
                if (anVar.f1062g != null && anVar.f1062g.size() > 0) {
                    strategyBean.f767r = anVar.f1062g;
                    str = (String) anVar.f1062g.get("B11");
                    if (str == null || !str.equals("1")) {
                        strategyBean.f756g = false;
                    } else {
                        strategyBean.f756g = true;
                    }
                    strategyBean.f762m = (long) anVar.f1064i;
                    strategyBean.f769t = (long) anVar.f1064i;
                    str = (String) anVar.f1062g.get("B27");
                    if (str != null && str.length() > 0) {
                        try {
                            int parseInt = Integer.parseInt(str);
                            if (parseInt > 0) {
                                strategyBean.f768s = parseInt;
                            }
                        } catch (Throwable e) {
                            if (!C0148u.m1036a(e)) {
                                e.printStackTrace();
                            }
                        }
                    }
                    str = (String) anVar.f1062g.get("B25");
                    if (str == null || !str.equals("1")) {
                        strategyBean.f757h = false;
                    } else {
                        strategyBean.f757h = true;
                    }
                }
                C0148u.m1035a("cr:%b,qu:%b,uin:%b,an:%b,ss:%b,ssT:%b,ssOT:%d,cos:%b,lstT:%d", Boolean.valueOf(strategyBean.f753d), Boolean.valueOf(strategyBean.f755f), Boolean.valueOf(strategyBean.f754e), Boolean.valueOf(strategyBean.f756g), Boolean.valueOf(strategyBean.f759j), Boolean.valueOf(strategyBean.f760k), Long.valueOf(strategyBean.f762m), Boolean.valueOf(strategyBean.f757h), Long.valueOf(strategyBean.f761l));
                this.f776f = strategyBean;
                C0139m.m963a();
                C0139m.m973b(2);
                C0141o c0141o = new C0141o();
                c0141o.f1135b = 2;
                c0141o.f1134a = strategyBean.f751b;
                c0141o.f1138e = strategyBean.f752c;
                Parcel obtain = Parcel.obtain();
                strategyBean.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                c0141o.f1140g = marshall;
                C0139m.m963a().m985a(c0141o);
                m645a(strategyBean);
            }
        }
    }

    /* renamed from: d */
    public static StrategyBean m644d() {
        List a = C0139m.m963a().m981a(2);
        if (a != null && a.size() > 0) {
            C0141o c0141o = (C0141o) a.get(0);
            if (c0141o.f1140g != null) {
                return (StrategyBean) C0124a.m790a(c0141o.f1140g, StrategyBean.CREATOR);
            }
        }
        return null;
    }
}
