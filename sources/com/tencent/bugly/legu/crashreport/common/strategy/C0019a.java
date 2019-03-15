package com.tencent.bugly.legu.crashreport.common.strategy;

import android.content.Context;
import android.os.Parcel;
import com.tencent.bugly.legu.C0004a;
import com.tencent.bugly.legu.crashreport.biz.C0014b;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0064o;
import com.tencent.bugly.legu.proguard.C0066q;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.ap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.common.strategy.a */
public final class C0019a {
    /* renamed from: a */
    public static int f164a = 1000;
    /* renamed from: b */
    private static C0019a f165b = null;
    /* renamed from: c */
    private final List<C0004a> f166c;
    /* renamed from: d */
    private final C0072v f167d;
    /* renamed from: e */
    private final StrategyBean f168e;
    /* renamed from: f */
    private StrategyBean f169f = null;
    /* renamed from: g */
    private Context f170g;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.common.strategy.a$1 */
    class C00181 extends Thread {
        /* renamed from: a */
        private /* synthetic */ C0019a f163a;

        C00181(C0019a c0019a) {
            this.f163a = c0019a;
        }

        public final void run() {
            try {
                Map a = C0064o.m440a().m464a(C0019a.f164a, null, true);
                if (a != null) {
                    byte[] bArr = (byte[]) a.get("key_imei");
                    byte[] bArr2 = (byte[]) a.get("key_ip");
                    if (bArr != null) {
                        C0016a.m70a(this.f163a.f170g).m88e(new String(bArr));
                    }
                    if (bArr2 != null) {
                        C0016a.m70a(this.f163a.f170g).m86d(new String(bArr2));
                    }
                }
                C0019a c0019a = this.f163a;
                this.f163a.f169f = C0019a.m117d();
                this.f163a.m118a(this.f163a.f169f);
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private C0019a(Context context, List<C0004a> list) {
        this.f170g = context;
        this.f168e = new StrategyBean();
        this.f166c = list;
        this.f167d = C0072v.m511a();
        this.f167d.m516b(new C00181(this));
    }

    /* renamed from: a */
    public static synchronized C0019a m115a(Context context, List<C0004a> list) {
        C0019a c0019a;
        synchronized (C0019a.class) {
            if (f165b == null) {
                f165b = new C0019a(context, list);
            }
            c0019a = f165b;
        }
        return c0019a;
    }

    /* renamed from: a */
    public static synchronized C0019a m114a() {
        C0019a c0019a;
        synchronized (C0019a.class) {
            c0019a = f165b;
        }
        return c0019a;
    }

    /* renamed from: b */
    public final synchronized boolean m120b() {
        return this.f169f != null;
    }

    /* renamed from: c */
    public final StrategyBean m121c() {
        if (this.f169f != null) {
            return this.f169f;
        }
        return this.f168e;
    }

    /* renamed from: a */
    protected final void m118a(StrategyBean strategyBean) {
        for (C0004a c0004a : this.f166c) {
            try {
                C0073w.m523c("[strategy] Notify %s", c0004a.getClass().getName());
                c0004a.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
        C0014b.m44a(strategyBean);
    }

    /* renamed from: a */
    public final void m119a(ap apVar) {
        if (apVar != null) {
            if (this.f169f == null || apVar.f456h != this.f169f.f154l) {
                StrategyBean strategyBean = new StrategyBean();
                strategyBean.f146d = apVar.f449a;
                strategyBean.f148f = apVar.f451c;
                strategyBean.f147e = apVar.f450b;
                String str = apVar.f452d;
                boolean z = str == null || str.trim().length() <= 0;
                if (!z) {
                    C0073w.m523c("upload url changes to %s", apVar.f452d);
                    strategyBean.f156n = apVar.f452d;
                }
                str = apVar.f453e;
                if (str == null || str.trim().length() <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    C0073w.m523c("exception upload url changes to %s", apVar.f453e);
                    strategyBean.f157o = apVar.f453e;
                }
                if (apVar.f454f != null) {
                    str = apVar.f454f.f444a;
                    if (str == null || str.trim().length() <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        strategyBean.f159q = apVar.f454f.f444a;
                    }
                }
                if (apVar.f456h != 0) {
                    strategyBean.f154l = apVar.f456h;
                }
                if (apVar.f455g != null && apVar.f455g.size() > 0) {
                    strategyBean.f160r = apVar.f455g;
                    str = (String) apVar.f455g.get("B11");
                    if (str == null || !str.equals("1")) {
                        strategyBean.f149g = false;
                    } else {
                        strategyBean.f149g = true;
                    }
                    strategyBean.f155m = (long) apVar.f457i;
                    strategyBean.f162t = (long) apVar.f457i;
                    str = (String) apVar.f455g.get("B27");
                    if (str != null && str.length() > 0) {
                        try {
                            int parseInt = Integer.parseInt(str);
                            if (parseInt > 0) {
                                strategyBean.f161s = parseInt;
                            }
                        } catch (Throwable e) {
                            if (!C0073w.m520a(e)) {
                                e.printStackTrace();
                            }
                        }
                    }
                    str = (String) apVar.f455g.get("B25");
                    if (str == null || !str.equals("1")) {
                        strategyBean.f150h = false;
                    } else {
                        strategyBean.f150h = true;
                    }
                }
                C0073w.m519a("cr:%b,qu:%b,uin:%b,an:%b,ss:%b,ssT:%b,ssOT:%d,cos:%b,lstT:%d", Boolean.valueOf(strategyBean.f146d), Boolean.valueOf(strategyBean.f148f), Boolean.valueOf(strategyBean.f147e), Boolean.valueOf(strategyBean.f149g), Boolean.valueOf(strategyBean.f152j), Boolean.valueOf(strategyBean.f153k), Long.valueOf(strategyBean.f155m), Boolean.valueOf(strategyBean.f150h), Long.valueOf(strategyBean.f154l));
                this.f169f = strategyBean;
                C0064o.m440a();
                C0064o.m451b(2);
                C0066q c0066q = new C0066q();
                c0066q.f537b = 2;
                c0066q.f536a = strategyBean.f144b;
                c0066q.f540e = strategyBean.f145c;
                Parcel obtain = Parcel.obtain();
                strategyBean.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                c0066q.f542g = marshall;
                C0064o.m440a().m468a(c0066q);
                m118a(strategyBean);
            }
        }
    }

    /* renamed from: d */
    public static StrategyBean m117d() {
        List a = C0064o.m440a().m462a(2);
        if (a != null && a.size() > 0) {
            C0066q c0066q = (C0066q) a.get(0);
            if (c0066q.f542g != null) {
                return (StrategyBean) C0048a.m256a(c0066q.f542g, StrategyBean.CREATOR);
            }
        }
        return null;
    }
}
