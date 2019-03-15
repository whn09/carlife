package com.tencent.bugly.legu;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.legu.BuglyStrategy.C0003a;
import com.tencent.bugly.legu.crashreport.CrashReport;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.crashreport.crash.C0035c;
import com.tencent.bugly.legu.crashreport.crash.C0040d;
import com.tencent.bugly.legu.crashreport.inner.InnerAPI;
import com.tencent.bugly.legu.proguard.C0061m;
import com.tencent.bugly.legu.proguard.C0073w;

/* compiled from: BUGLY */
public class CrashModule extends C0004a {
    public static final int MODULE_ID = 1004;
    /* renamed from: c */
    private static int f28c = 0;
    /* renamed from: d */
    private static boolean f29d = false;
    /* renamed from: e */
    private static CrashModule f30e = new CrashModule();
    /* renamed from: a */
    private long f31a;
    /* renamed from: b */
    private C0003a f32b;

    public static CrashModule getInstance() {
        f30e.id = 1004;
        return f30e;
    }

    public static boolean hasInitialized() {
        return f29d;
    }

    public void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        if (context != null && !f29d) {
            C0061m a = C0061m.m420a();
            int i = f28c + 1;
            f28c = i;
            a.m427a(1004, i);
            f29d = true;
            CrashReport.setContext(context);
            m16a(context, buglyStrategy);
            C0035c.m173a(1004, context, z, this.f32b, null, null);
            C0035c a2 = C0035c.m171a();
            a2.m182e();
            if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                a2.m184g();
            } else {
                C0073w.m519a("[crash] Closed native crash monitor!", new Object[0]);
                a2.m183f();
            }
            if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                a2.m185h();
            } else {
                C0073w.m519a("[crash] Closed ANR monitor!", new Object[0]);
                a2.m186i();
            }
            InnerAPI.context = context;
            C0040d.m191a(context);
            C0035c.m171a().m175a(this.f31a);
            a = C0061m.m420a();
            i = f28c - 1;
            f28c = i;
            a.m427a(1004, i);
        }
    }

    /* renamed from: a */
    private synchronized void m16a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy != null) {
            Object libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                C0016a.m70a(context).f124k = libBuglySOFilePath;
                C0073w.m519a("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.f32b = buglyStrategy.getCrashHandleCallback();
                C0073w.m519a("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                this.f31a = buglyStrategy.getAppReportDelay();
                C0073w.m519a("setted delay: %d", Long.valueOf(this.f31a));
            }
        }
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            C0035c a = C0035c.m171a();
            if (a != null) {
                a.m176a(strategyBean);
            }
            C0040d.m192a(strategyBean);
        }
    }

    public String[] getTables() {
        return new String[]{"t_cr"};
    }
}
