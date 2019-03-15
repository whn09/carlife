package com.tencent.bugly.legu.proguard;

import android.content.Context;
import com.tencent.bugly.legu.BuglyStrategy.C0003a;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.crashreport.crash.C0032b;
import com.tencent.bugly.legu.crashreport.crash.C0035c;
import com.tencent.bugly.legu.crashreport.crash.CrashDetailBean;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.y */
public final class C0077y {
    /* renamed from: a */
    private Context f612a;
    /* renamed from: b */
    private C0032b f613b;
    /* renamed from: c */
    private C0019a f614c;
    /* renamed from: d */
    private C0016a f615d;

    public C0077y(Context context, C0032b c0032b, C0019a c0019a, C0016a c0016a, C0003a c0003a) {
        this.f612a = context;
        this.f613b = c0032b;
        this.f614c = c0019a;
        this.f615d = c0016a;
    }

    /* renamed from: a */
    public final void m544a(Thread thread, int i, String str, String str2, String str3) {
        C0073w.m525e("Cocos2d-x Crash Happen", new Object[0]);
        this.f614c.m121c();
        if (!this.f614c.m120b()) {
            C0073w.m525e("waiting for remote sync", new Object[0]);
            int i2 = 0;
            do {
                if (!this.f614c.m120b()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        try {
                            if (!C0073w.m520a(th)) {
                                th.printStackTrace();
                            }
                            C0073w.m525e("handle end", new Object[0]);
                            return;
                        } catch (Throwable th2) {
                            C0073w.m525e("handle end", new Object[0]);
                        }
                    }
                    i2 += 500;
                }
            } while (i2 < 5000);
        }
        if (!this.f614c.m120b()) {
            C0073w.m524d("no remote but still store!", new Object[0]);
        }
        StrategyBean c = this.f614c.m121c();
        if (!c.f146d && this.f614c.m120b()) {
            C0073w.m525e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
            C0032b.m156a("Cocos2dx", C0048a.m303n(), this.f615d.f117d, thread, str + "\n" + str2 + "\n" + str3, null);
            C0073w.m525e("handle end", new Object[0]);
        } else if (c.f150h) {
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f176B = C0048a.m298i();
            crashDetailBean.f177C = C0048a.m296g();
            crashDetailBean.f178D = C0048a.m300k();
            crashDetailBean.f179E = this.f615d.m100o();
            crashDetailBean.f180F = this.f615d.m99n();
            crashDetailBean.f181G = this.f615d.m101p();
            crashDetailBean.f217w = C0048a.m258a(this.f612a, C0035c.f272d, null);
            crashDetailBean.f218x = C0076x.m538a(false);
            crashDetailBean.f196b = i;
            crashDetailBean.f199e = this.f615d.m91g();
            crashDetailBean.f200f = this.f615d.f122i;
            crashDetailBean.f201g = this.f615d.m105t();
            crashDetailBean.f207m = this.f615d.m89f();
            crashDetailBean.f208n = str;
            crashDetailBean.f209o = str2;
            String str4 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                if (split != null && split.length > 0) {
                    str4 = split[0];
                }
            }
            crashDetailBean.f210p = str4;
            crashDetailBean.f211q = str3;
            crashDetailBean.f212r = System.currentTimeMillis();
            crashDetailBean.f215u = C0048a.m281b(crashDetailBean.f211q.getBytes());
            crashDetailBean.f219y = C0048a.m264a(C0035c.f273e, false);
            crashDetailBean.f220z = this.f615d.f117d;
            crashDetailBean.f175A = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.f182H = this.f615d.m107v();
            crashDetailBean.f202h = this.f615d.m104s();
            crashDetailBean.f203i = this.f615d.m76E();
            crashDetailBean.f186L = this.f615d.f114a;
            crashDetailBean.f187M = this.f615d.f127n;
            crashDetailBean.f189O = this.f615d.m73B();
            crashDetailBean.f190P = this.f615d.m74C();
            crashDetailBean.f191Q = this.f615d.m108w();
            crashDetailBean.f192R = this.f615d.m72A();
            this.f613b.m169b(crashDetailBean);
            if (crashDetailBean == null) {
                C0073w.m525e("pkg crash datas fail!", new Object[0]);
                C0073w.m525e("handle end", new Object[0]);
                return;
            }
            C0032b.m156a("Cocos2dx", C0048a.m303n(), this.f615d.f117d, thread, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!this.f613b.m167a(crashDetailBean)) {
                this.f613b.m165a(crashDetailBean, 5000, false);
            }
            C0073w.m525e("handle end", new Object[0]);
        } else {
            C0073w.m525e("cocos report is disabled.", new Object[0]);
            C0073w.m525e("handle end", new Object[0]);
        }
    }
}
