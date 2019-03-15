package com.tencent.bugly.lejiagu.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.bugly.lejiagu.BuglyStrategy;
import com.tencent.bugly.lejiagu.crashreport.biz.C0087a.C0085a;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0144r;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.biz.b */
public final class C0090b {
    /* renamed from: a */
    public static C0087a f680a;
    /* renamed from: b */
    private static boolean f681b;
    /* renamed from: c */
    private static int f682c = 10;
    /* renamed from: d */
    private static long f683d = 300000;
    /* renamed from: e */
    private static long f684e = 30000;
    /* renamed from: f */
    private static long f685f = 0;
    /* renamed from: g */
    private static int f686g;
    /* renamed from: h */
    private static long f687h;
    /* renamed from: i */
    private static long f688i;
    /* renamed from: j */
    private static long f689j = 0;
    /* renamed from: k */
    private static ActivityLifecycleCallbacks f690k = null;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.biz.b$2 */
    static class C00892 implements ActivityLifecycleCallbacks {
        C00892() {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityResumed(Activity activity) {
            C0092a a = C0092a.m597a();
            if (a != null) {
                a.f734n = true;
                if (activity != null) {
                    a.f735o = activity.getClass().getName();
                } else {
                    a.f735o = "unknown";
                }
                a.f736p = System.currentTimeMillis();
                a.f739s = a.f736p - C0090b.f688i;
                if (a.f736p - C0090b.f687h > (C0090b.f685f > 0 ? C0090b.f685f : C0090b.f684e)) {
                    a.m610c();
                    C0090b.m582f();
                    C0148u.m1035a("[session] launch app one times (app in foreground %d seconds and over %d seconds)", Long.valueOf(r3 / 1000), Long.valueOf(C0090b.f684e / 1000));
                    if (C0090b.f686g % C0090b.f682c == 0) {
                        C0090b.f680a.m567a(4, true, 0);
                        return;
                    }
                    C0090b.f680a.m567a(4, false, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - C0090b.f689j > C0090b.f683d) {
                        C0090b.f689j = currentTimeMillis;
                        C0148u.m1035a("add a timer to upload hot start user info", new Object[0]);
                        C0147t.m1027a().m1030a(new C0085a(C0090b.f680a, null, true), C0090b.f683d);
                    }
                }
            }
        }

        public final void onActivityPaused(Activity activity) {
            C0092a a = C0092a.m597a();
            if (a != null) {
                a.f734n = false;
                a.f737q = System.currentTimeMillis();
                a.f738r = a.f737q - a.f736p;
                C0090b.f687h = a.f737q;
                if (a.f738r < 0) {
                    a.f738r = 0;
                }
                if (activity != null) {
                    a.f735o = "background";
                } else {
                    a.f735o = "unknown";
                }
            }
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }
    }

    /* renamed from: f */
    static /* synthetic */ int m582f() {
        int i = f686g;
        f686g = i + 1;
        return i;
    }

    /* renamed from: c */
    private static void m579c(Context context, BuglyStrategy buglyStrategy) {
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
            C0092a a = C0092a.m598a(context);
            List a2 = f680a.m565a(a.f724d);
            if (a2 != null) {
                for (int i = 0; i < a2.size(); i++) {
                    UserInfoBean userInfoBean = (UserInfoBean) a2.get(i);
                    if (userInfoBean.f663n.equals(a.f729i) && userInfoBean.f651b == 1) {
                        long o = C0124a.m838o();
                        if (o <= 0) {
                            break;
                        } else if (userInfoBean.f654e >= o) {
                            if (userInfoBean.f655f <= 0) {
                                f680a.m568b();
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
        C0092a a3 = C0092a.m597a();
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
                a3.f734n = true;
            } else {
                str = "background";
            }
            a3.f735o = str;
        }
        if (isEnableUserInfo) {
            Application application = null;
            if (VERSION.SDK_INT >= 14) {
                if (context.getApplicationContext() instanceof Application) {
                    application = (Application) context.getApplicationContext();
                }
                if (application != null) {
                    try {
                        if (f690k == null) {
                            f690k = new C00892();
                        }
                        application.registerActivityLifecycleCallbacks(f690k);
                    } catch (Exception e) {
                    }
                }
            }
        }
        f688i = System.currentTimeMillis();
        f680a.m567a(1, true, 0);
        C0144r.m994a().m1012a(1001, System.currentTimeMillis());
        C0148u.m1035a("[session] launch app, new start", new Object[0]);
        f680a.m566a();
        C0147t.m1027a().m1030a(new C0085a(f680a, null, true), 21600000);
    }

    /* renamed from: a */
    public static void m572a(final Context context, final BuglyStrategy buglyStrategy) {
        if (!f681b) {
            long appReportDelay;
            f684e = C0095a.m641a().m648c().f762m;
            f682c = C0095a.m641a().m648c().f768s;
            f680a = new C0087a(context);
            f681b = true;
            if (buglyStrategy != null) {
                appReportDelay = buglyStrategy.getAppReportDelay();
            } else {
                appReportDelay = 0;
            }
            if (appReportDelay <= 0) {
                C0090b.m579c(context, buglyStrategy);
            } else {
                C0147t.m1027a().m1030a(new Runnable() {
                    public final void run() {
                        C0090b.m579c(context, buglyStrategy);
                    }
                }, appReportDelay);
            }
        }
    }

    /* renamed from: a */
    public static void m570a(long j) {
        if (j < 0) {
            j = C0095a.m641a().m648c().f762m;
        }
        f685f = j;
    }

    /* renamed from: a */
    public static void m573a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f762m > 0) {
                f684e = strategyBean.f762m;
            }
            if (strategyBean.f768s > 0) {
                f682c = strategyBean.f768s;
            }
            if (strategyBean.f769t > 0) {
                f683d = strategyBean.f769t;
            }
        }
    }

    /* renamed from: a */
    public static void m569a() {
        if (f680a != null) {
            f680a.m567a(2, false, 0);
        }
    }

    /* renamed from: a */
    public static void m571a(Context context) {
        if (f681b && context != null) {
            Application application = null;
            if (VERSION.SDK_INT >= 14) {
                if (context.getApplicationContext() instanceof Application) {
                    application = (Application) context.getApplicationContext();
                }
                if (application != null) {
                    try {
                        if (f690k != null) {
                            application.unregisterActivityLifecycleCallbacks(f690k);
                        }
                    } catch (Exception e) {
                    }
                }
            }
            f681b = false;
        }
    }
}
