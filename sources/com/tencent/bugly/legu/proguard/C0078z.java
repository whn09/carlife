package com.tencent.bugly.legu.proguard;

import android.content.Context;
import com.tencent.bugly.legu.BuglyStrategy.C0003a;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.crash.C0032b;
import com.tencent.bugly.legu.crashreport.crash.C0035c;
import com.tencent.bugly.legu.crashreport.crash.CrashDetailBean;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.z */
public final class C0078z {
    /* renamed from: a */
    private Context f616a;
    /* renamed from: b */
    private C0032b f617b;
    /* renamed from: c */
    private C0019a f618c;
    /* renamed from: d */
    private C0016a f619d;

    public C0078z(Context context, C0032b c0032b, C0019a c0019a, C0016a c0016a, C0003a c0003a) {
        this.f616a = context;
        this.f617b = c0032b;
        this.f618c = c0019a;
        this.f619d = c0016a;
    }

    /* renamed from: a */
    public final void m545a(Thread thread, String str, String str2, String str3) {
        C0073w.m525e("U3D Crash Happen", new Object[0]);
        this.f618c.m121c();
        if (!this.f618c.m120b()) {
            C0073w.m525e("waiting for remote sync", new Object[0]);
            int i = 0;
            do {
                if (!this.f618c.m120b()) {
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
        if (!this.f618c.m120b()) {
            C0073w.m524d("no remote but still store!", new Object[0]);
        }
        if (this.f618c.m121c().f146d || !this.f618c.m120b()) {
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f176B = C0048a.m298i();
            crashDetailBean.f177C = C0048a.m296g();
            crashDetailBean.f178D = C0048a.m300k();
            crashDetailBean.f179E = this.f619d.m100o();
            crashDetailBean.f180F = this.f619d.m99n();
            crashDetailBean.f181G = this.f619d.m101p();
            crashDetailBean.f217w = C0048a.m258a(this.f616a, C0035c.f272d, null);
            crashDetailBean.f218x = C0076x.m538a(false);
            crashDetailBean.f196b = 4;
            crashDetailBean.f199e = this.f619d.m91g();
            crashDetailBean.f200f = this.f619d.f122i;
            crashDetailBean.f201g = this.f619d.m105t();
            crashDetailBean.f207m = this.f619d.m89f();
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
            crashDetailBean.f220z = this.f619d.f117d;
            crashDetailBean.f175A = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.f182H = this.f619d.m107v();
            crashDetailBean.f202h = this.f619d.m104s();
            crashDetailBean.f203i = this.f619d.m76E();
            crashDetailBean.f186L = this.f619d.f114a;
            crashDetailBean.f187M = this.f619d.f127n;
            crashDetailBean.f189O = this.f619d.m73B();
            crashDetailBean.f190P = this.f619d.m74C();
            crashDetailBean.f191Q = this.f619d.m108w();
            crashDetailBean.f192R = this.f619d.m72A();
            this.f617b.m169b(crashDetailBean);
            if (crashDetailBean == null) {
                C0073w.m525e("pkg crash datas fail!", new Object[0]);
                C0073w.m525e("handle end", new Object[0]);
                return;
            }
            C0032b.m156a("U3D", C0048a.m303n(), this.f619d.f117d, thread, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!this.f617b.m167a(crashDetailBean)) {
                this.f617b.m165a(crashDetailBean, 5000, true);
            }
            C0073w.m525e("handle end", new Object[0]);
            return;
        }
        C0073w.m525e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
        C0032b.m156a("U3D", C0048a.m303n(), this.f619d.f117d, thread, str + "\n" + str2 + "\n" + str3, null);
        C0073w.m525e("handle end", new Object[0]);
    }
}
