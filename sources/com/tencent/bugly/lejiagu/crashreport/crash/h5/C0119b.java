package com.tencent.bugly.lejiagu.crashreport.crash.h5;

import android.content.Context;
import com.tencent.bugly.lejiagu.BuglyStrategy.C0079a;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.crashreport.crash.C0108b;
import com.tencent.bugly.lejiagu.crashreport.crash.C0111c;
import com.tencent.bugly.lejiagu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.C0151v;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.h5.b */
public final class C0119b {
    /* renamed from: a */
    private Context f939a;
    /* renamed from: b */
    private C0108b f940b;
    /* renamed from: c */
    private C0095a f941c;
    /* renamed from: d */
    private C0092a f942d;

    public C0119b(Context context, C0108b c0108b, C0095a c0095a, C0092a c0092a, C0079a c0079a) {
        this.f939a = context;
        this.f940b = c0108b;
        this.f941c = c0095a;
        this.f942d = c0092a;
    }

    /* renamed from: a */
    public final void m738a(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        C0148u.m1041e("H5 Crash Happen", new Object[0]);
        if (!this.f941c.m647b()) {
            C0148u.m1041e("waiting for remote sync", new Object[0]);
            int i = 0;
            do {
                if (!this.f941c.m647b()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        try {
                            if (!C0148u.m1036a(th)) {
                                th.printStackTrace();
                            }
                            C0148u.m1041e("handle end", new Object[0]);
                            return;
                        } catch (Throwable th2) {
                            C0148u.m1041e("handle end", new Object[0]);
                        }
                    }
                    i += 500;
                }
            } while (i < 5000);
        }
        if (!this.f941c.m647b()) {
            C0148u.m1040d("no remote but still store!", new Object[0]);
        }
        StrategyBean c = this.f941c.m648c();
        if (!c.f753d && this.f941c.m647b()) {
            C0148u.m1041e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
            C0108b.m683a("H5", C0124a.m837n(), this.f942d.f724d, thread, str + "\n" + str2 + "\n" + str3, null);
            C0148u.m1041e("handle end", new Object[0]);
        } else if (c.f758i) {
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f783B = C0124a.m832i();
            crashDetailBean.f784C = C0124a.m830g();
            crashDetailBean.f785D = C0124a.m834k();
            crashDetailBean.f786E = this.f942d.m627o();
            crashDetailBean.f787F = this.f942d.m626n();
            crashDetailBean.f788G = this.f942d.m628p();
            crashDetailBean.f824w = C0124a.m792a(this.f939a, C0111c.f879d, null);
            crashDetailBean.f803b = 5;
            crashDetailBean.f806e = this.f942d.m618g();
            crashDetailBean.f807f = this.f942d.f729i;
            crashDetailBean.f808g = this.f942d.m632t();
            crashDetailBean.f814m = this.f942d.m616f();
            crashDetailBean.f815n = str;
            crashDetailBean.f816o = str2;
            crashDetailBean.f817p = "0";
            crashDetailBean.f818q = str3;
            crashDetailBean.f819r = System.currentTimeMillis();
            crashDetailBean.f822u = C0124a.m815b(crashDetailBean.f818q.getBytes());
            crashDetailBean.f826y = C0124a.m798a(C0111c.f880e, false);
            crashDetailBean.f827z = this.f942d.f724d;
            crashDetailBean.f782A = thread.getName();
            crashDetailBean.f789H = this.f942d.m634v();
            crashDetailBean.f809h = this.f942d.m631s();
            crashDetailBean.f793L = this.f942d.f721a;
            crashDetailBean.f794M = this.f942d.f734n;
            crashDetailBean.f796O = this.f942d.m600A();
            crashDetailBean.f797P = this.f942d.m601B();
            crashDetailBean.f798Q = this.f942d.m635w();
            crashDetailBean.f799R = this.f942d.m638z();
            this.f940b.m696b(crashDetailBean);
            crashDetailBean.f825x = C0151v.m1054a(false);
            if (crashDetailBean.f795N == null) {
                crashDetailBean.f795N = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.f795N.putAll(map);
            }
            if (crashDetailBean == null) {
                C0148u.m1041e("pkg crash datas fail!", new Object[0]);
                C0148u.m1041e("handle end", new Object[0]);
                return;
            }
            C0108b.m683a("H5", C0124a.m837n(), this.f942d.f724d, thread, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!this.f940b.m694a(crashDetailBean)) {
                this.f940b.m692a(crashDetailBean, 5000, false);
            }
            C0148u.m1041e("handle end", new Object[0]);
        } else {
            C0148u.m1041e("cocos report is disabled.", new Object[0]);
            C0148u.m1041e("handle end", new Object[0]);
        }
    }
}
