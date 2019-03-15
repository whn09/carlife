package com.tencent.bugly.legu.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.bugly.legu.BuglyStrategy;
import com.tencent.bugly.legu.crashreport.biz.C0011a.C0009a;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0069t;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.biz.b */
public final class C0014b {
    /* renamed from: a */
    public static C0011a f72a;
    /* renamed from: b */
    private static boolean f73b;
    /* renamed from: c */
    private static int f74c = 10;
    /* renamed from: d */
    private static long f75d = 300000;
    /* renamed from: e */
    private static long f76e = 30000;
    /* renamed from: f */
    private static long f77f = 0;
    /* renamed from: g */
    private static int f78g;
    /* renamed from: h */
    private static long f79h;
    /* renamed from: i */
    private static long f80i;
    /* renamed from: j */
    private static long f81j = 0;
    /* renamed from: k */
    private static ActivityLifecycleCallbacks f82k = null;
    /* renamed from: l */
    private static Class<?> f83l = null;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.biz.b$2 */
    static class C00132 implements ActivityLifecycleCallbacks {
        C00132() {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityResumed(Activity activity) {
            String str = "unknown";
            if (activity != null) {
                str = activity.getClass().getName();
            }
            if (C0014b.f83l == null || C0014b.f83l.getName().equals(str)) {
                C0073w.m523c(">>> %s onResumed <<<", str);
                C0016a a = C0016a.m69a();
                if (a != null) {
                    a.f127n = true;
                    a.f128o = str;
                    a.f129p = System.currentTimeMillis();
                    a.f132s = a.f129p - C0014b.f80i;
                    if (a.f129p - C0014b.f79h > (C0014b.f77f > 0 ? C0014b.f77f : C0014b.f76e)) {
                        a.m83c();
                        C0014b.m54g();
                        C0073w.m519a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(r3 / 1000), Long.valueOf(C0014b.f76e / 1000));
                        if (C0014b.f78g % C0014b.f74c == 0) {
                            C0014b.f72a.m38a(4, true, 0);
                            return;
                        }
                        C0014b.f72a.m38a(4, false, 0);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - C0014b.f81j > C0014b.f75d) {
                            C0014b.f81j = currentTimeMillis;
                            C0073w.m519a("add a timer to upload hot start user info", new Object[0]);
                            C0072v.m511a().m514a(new C0009a(C0014b.f72a, null, true), C0014b.f75d);
                        }
                    }
                }
            }
        }

        public final void onActivityPaused(Activity activity) {
            Object obj = "unknown";
            if (activity != null) {
                obj = activity.getClass().getName();
            }
            if (C0014b.f83l == null || C0014b.f83l.getName().equals(obj)) {
                C0073w.m523c(">>> %s onPaused <<<", obj);
                C0016a a = C0016a.m69a();
                if (a != null) {
                    a.f127n = false;
                    a.f130q = System.currentTimeMillis();
                    a.f131r = a.f130q - a.f129p;
                    C0014b.f79h = a.f130q;
                    if (a.f131r < 0) {
                        a.f131r = 0;
                    }
                    if (activity != null) {
                        a.f128o = "background";
                    } else {
                        a.f128o = "unknown";
                    }
                }
            }
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }
    }

    /* renamed from: g */
    static /* synthetic */ int m54g() {
        int i = f78g;
        f78g = i + 1;
        return i;
    }

    /* renamed from: c */
    private static void m50c(Context context, BuglyStrategy buglyStrategy) {
        boolean isEnableUserInfo;
        boolean z;
        if (buglyStrategy != null) {
            boolean recordUserInfoOnceADay = buglyStrategy.recordUserInfoOnceADay();
            isEnableUserInfo = buglyStrategy.isEnableUserInfo();
            z = recordUserInfoOnceADay;
        } else {
            isEnableUserInfo = true;
            z = false;
        }
        if (z) {
            Object obj;
            C0016a a = C0016a.m70a(context);
            List a2 = f72a.m36a(a.f117d);
            if (a2 != null) {
                for (int i = 0; i < a2.size(); i++) {
                    UserInfoBean userInfoBean = (UserInfoBean) a2.get(i);
                    if (userInfoBean.f55n.equals(a.f122i) && userInfoBean.f43b == 1) {
                        long o = C0048a.m304o();
                        if (o <= 0) {
                            break;
                        } else if (userInfoBean.f46e >= o) {
                            if (userInfoBean.f47f <= 0) {
                                f72a.m39b();
                            }
                            obj = null;
                            if (obj == null) {
                                isEnableUserInfo = false;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
            obj = 1;
            if (obj == null) {
                isEnableUserInfo = false;
            } else {
                return;
            }
        }
        C0016a a3 = C0016a.m69a();
        if (a3 != null) {
            Object obj2 = null;
            String str = null;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getMethodName().equals("onCreate")) {
                    str = stackTraceElement.getClassName();
                }
                if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                    obj2 = 1;
                }
            }
            if (str == null) {
                str = "unknown";
            } else if (obj2 != null) {
                a3.f127n = true;
            } else {
                str = "background";
            }
            a3.f128o = str;
        }
        if (isEnableUserInfo) {
            Application application = null;
            if (VERSION.SDK_INT >= 14) {
                if (context.getApplicationContext() instanceof Application) {
                    application = (Application) context.getApplicationContext();
                }
                if (application != null) {
                    try {
                        if (f82k == null) {
                            f82k = new C00132();
                        }
                        application.registerActivityLifecycleCallbacks(f82k);
                    } catch (Exception e) {
                    }
                }
            }
        }
        f80i = System.currentTimeMillis();
        f72a.m38a(1, true, 0);
        C0069t.m478a().m496a(1001, System.currentTimeMillis());
        C0073w.m519a("[session] launch app, new start", new Object[0]);
        f72a.m37a();
        C0072v.m511a().m514a(new C0009a(f72a, null, true), 21600000);
    }

    /* renamed from: a */
    public static void m43a(final Context context, final BuglyStrategy buglyStrategy) {
        if (!f73b) {
            long appReportDelay;
            f76e = C0019a.m114a().m121c().f155m;
            f74c = C0019a.m114a().m121c().f161s;
            f72a = new C0011a(context);
            f73b = true;
            if (buglyStrategy != null) {
                f83l = buglyStrategy.getUserInfoActivity();
                appReportDelay = buglyStrategy.getAppReportDelay();
            } else {
                appReportDelay = 0;
            }
            if (appReportDelay <= 0) {
                C0014b.m50c(context, buglyStrategy);
            } else {
                C0072v.m511a().m514a(new Runnable() {
                    public final void run() {
                        C0014b.m50c(context, buglyStrategy);
                    }
                }, appReportDelay);
            }
        }
    }

    /* renamed from: a */
    public static void m41a(long j) {
        if (j < 0) {
            j = C0019a.m114a().m121c().f155m;
        }
        f77f = j;
    }

    /* renamed from: a */
    public static void m44a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f155m > 0) {
                f76e = strategyBean.f155m;
            }
            if (strategyBean.f161s > 0) {
                f74c = strategyBean.f161s;
            }
            if (strategyBean.f162t > 0) {
                f75d = strategyBean.f162t;
            }
        }
    }

    /* renamed from: a */
    public static void m40a() {
        if (f72a != null) {
            f72a.m38a(2, false, 0);
        }
    }

    /* renamed from: a */
    public static void m42a(Context context) {
        if (f73b && context != null) {
            Application application = null;
            if (VERSION.SDK_INT >= 14) {
                if (context.getApplicationContext() instanceof Application) {
                    application = (Application) context.getApplicationContext();
                }
                if (application != null) {
                    try {
                        if (f82k != null) {
                            application.unregisterActivityLifecycleCallbacks(f82k);
                        }
                    } catch (Exception e) {
                    }
                }
            }
            f73b = false;
        }
    }
}
