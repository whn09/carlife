package com.tencent.bugly.legu.crashreport.crash.h5;

import android.content.Context;
import com.tencent.bugly.legu.BuglyStrategy.C0003a;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.crashreport.crash.C0032b;
import com.tencent.bugly.legu.crashreport.crash.C0035c;
import com.tencent.bugly.legu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.C0076x;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.crash.h5.b */
public final class C0043b {
    /* renamed from: a */
    private Context f332a;
    /* renamed from: b */
    private C0032b f333b;
    /* renamed from: c */
    private C0019a f334c;
    /* renamed from: d */
    private C0016a f335d;

    public C0043b(Context context, C0032b c0032b, C0019a c0019a, C0016a c0016a, C0003a c0003a) {
        this.f332a = context;
        this.f333b = c0032b;
        this.f334c = c0019a;
        this.f335d = c0016a;
    }

    /* renamed from: a */
    public final void m210a(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        C0073w.m525e("H5 Crash Happen", new Object[0]);
        if (!this.f334c.m120b()) {
            C0073w.m525e("waiting for remote sync", new Object[0]);
            int i = 0;
            do {
                if (!this.f334c.m120b()) {
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
                    i += 500;
                }
            } while (i < 5000);
        }
        if (!this.f334c.m120b()) {
            C0073w.m524d("no remote but still store!", new Object[0]);
        }
        StrategyBean c = this.f334c.m121c();
        if (!c.f146d && this.f334c.m120b()) {
            C0073w.m525e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
            C0032b.m156a("H5", C0048a.m303n(), this.f335d.f117d, thread, str + "\n" + str2 + "\n" + str3, null);
            C0073w.m525e("handle end", new Object[0]);
        } else if (c.f151i) {
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f176B = C0048a.m298i();
            crashDetailBean.f177C = C0048a.m296g();
            crashDetailBean.f178D = C0048a.m300k();
            crashDetailBean.f179E = this.f335d.m100o();
            crashDetailBean.f180F = this.f335d.m99n();
            crashDetailBean.f181G = this.f335d.m101p();
            crashDetailBean.f217w = C0048a.m258a(this.f332a, C0035c.f272d, null);
            crashDetailBean.f196b = 5;
            crashDetailBean.f199e = this.f335d.m91g();
            crashDetailBean.f200f = this.f335d.f122i;
            crashDetailBean.f201g = this.f335d.m105t();
            crashDetailBean.f207m = this.f335d.m89f();
            crashDetailBean.f208n = str;
            crashDetailBean.f209o = str2;
            crashDetailBean.f210p = "0";
            crashDetailBean.f211q = str3;
            crashDetailBean.f212r = System.currentTimeMillis();
            crashDetailBean.f215u = C0048a.m281b(crashDetailBean.f211q.getBytes());
            crashDetailBean.f219y = C0048a.m264a(C0035c.f273e, false);
            crashDetailBean.f220z = this.f335d.f117d;
            crashDetailBean.f175A = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.f182H = this.f335d.m107v();
            crashDetailBean.f202h = this.f335d.m104s();
            crashDetailBean.f186L = this.f335d.f114a;
            crashDetailBean.f187M = this.f335d.f127n;
            crashDetailBean.f189O = this.f335d.m73B();
            crashDetailBean.f190P = this.f335d.m74C();
            crashDetailBean.f191Q = this.f335d.m108w();
            crashDetailBean.f192R = this.f335d.m72A();
            this.f333b.m169b(crashDetailBean);
            crashDetailBean.f218x = C0076x.m538a(false);
            if (crashDetailBean.f188N == null) {
                crashDetailBean.f188N = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.f188N.putAll(map);
            }
            if (crashDetailBean == null) {
                C0073w.m525e("pkg crash datas fail!", new Object[0]);
                C0073w.m525e("handle end", new Object[0]);
                return;
            }
            C0032b.m156a("H5", C0048a.m303n(), this.f335d.f117d, thread, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!this.f333b.m167a(crashDetailBean)) {
                this.f333b.m165a(crashDetailBean, 5000, false);
            }
            C0073w.m525e("handle end", new Object[0]);
        } else {
            C0073w.m525e("cocos report is disabled.", new Object[0]);
            C0073w.m525e("handle end", new Object[0]);
        }
    }
}
