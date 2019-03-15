package com.tencent.bugly.lejiagu.proguard;

import android.content.Context;
import com.tencent.bugly.lejiagu.BuglyStrategy.C0079a;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.crash.C0108b;
import com.tencent.bugly.lejiagu.crashreport.crash.C0111c;
import com.tencent.bugly.lejiagu.crashreport.crash.CrashDetailBean;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.x */
public final class C0153x {
    /* renamed from: a */
    private Context f1214a;
    /* renamed from: b */
    private C0108b f1215b;
    /* renamed from: c */
    private C0095a f1216c;
    /* renamed from: d */
    private C0092a f1217d;

    public C0153x(Context context, C0108b c0108b, C0095a c0095a, C0092a c0092a, C0079a c0079a) {
        this.f1214a = context;
        this.f1215b = c0108b;
        this.f1216c = c0095a;
        this.f1217d = c0092a;
    }

    /* renamed from: a */
    public final void m1061a(Thread thread, String str, String str2, String str3) {
        C0148u.m1041e("U3D Crash Happen", new Object[0]);
        this.f1216c.m648c();
        if (!this.f1216c.m647b()) {
            C0148u.m1041e("waiting for remote sync", new Object[0]);
            int i = 0;
            do {
                if (!this.f1216c.m647b()) {
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
        if (!this.f1216c.m647b()) {
            C0148u.m1040d("no remote but still store!", new Object[0]);
        }
        if (this.f1216c.m648c().f753d || !this.f1216c.m647b()) {
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f783B = C0124a.m832i();
            crashDetailBean.f784C = C0124a.m830g();
            crashDetailBean.f785D = C0124a.m834k();
            crashDetailBean.f786E = this.f1217d.m627o();
            crashDetailBean.f787F = this.f1217d.m626n();
            crashDetailBean.f788G = this.f1217d.m628p();
            crashDetailBean.f824w = C0124a.m792a(this.f1214a, C0111c.f879d, null);
            crashDetailBean.f825x = C0151v.m1054a(false);
            crashDetailBean.f803b = 4;
            crashDetailBean.f806e = this.f1217d.m618g();
            crashDetailBean.f807f = this.f1217d.f729i;
            crashDetailBean.f808g = this.f1217d.m632t();
            crashDetailBean.f814m = this.f1217d.m616f();
            crashDetailBean.f815n = str;
            crashDetailBean.f816o = str2;
            String str4 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                if (split != null && split.length > 0) {
                    str4 = split[0];
                }
            }
            crashDetailBean.f817p = str4;
            crashDetailBean.f818q = str3;
            crashDetailBean.f819r = System.currentTimeMillis();
            crashDetailBean.f822u = C0124a.m815b(crashDetailBean.f818q.getBytes());
            crashDetailBean.f826y = C0124a.m798a(C0111c.f880e, false);
            crashDetailBean.f827z = this.f1217d.f724d;
            crashDetailBean.f782A = thread.getName();
            crashDetailBean.f789H = this.f1217d.m634v();
            crashDetailBean.f809h = this.f1217d.m631s();
            crashDetailBean.f810i = this.f1217d.m603D();
            crashDetailBean.f793L = this.f1217d.f721a;
            crashDetailBean.f794M = this.f1217d.f734n;
            crashDetailBean.f796O = this.f1217d.m600A();
            crashDetailBean.f797P = this.f1217d.m601B();
            crashDetailBean.f798Q = this.f1217d.m635w();
            crashDetailBean.f799R = this.f1217d.m638z();
            this.f1215b.m696b(crashDetailBean);
            if (crashDetailBean == null) {
                C0148u.m1041e("pkg crash datas fail!", new Object[0]);
                C0148u.m1041e("handle end", new Object[0]);
                return;
            }
            C0108b.m683a("U3D", C0124a.m837n(), this.f1217d.f724d, thread, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!this.f1215b.m694a(crashDetailBean)) {
                this.f1215b.m692a(crashDetailBean, 5000, true);
            }
            C0148u.m1041e("handle end", new Object[0]);
            return;
        }
        C0148u.m1041e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
        C0108b.m683a("U3D", C0124a.m837n(), this.f1217d.f724d, thread, str + "\n" + str2 + "\n" + str3, null);
        C0148u.m1041e("handle end", new Object[0]);
    }
}
