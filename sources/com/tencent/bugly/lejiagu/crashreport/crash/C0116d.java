package com.tencent.bugly.lejiagu.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.crashreport.crash.h5.C0119b;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.C0152w;
import com.tencent.bugly.lejiagu.proguard.C0153x;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.d */
public final class C0116d {
    /* renamed from: a */
    private static C0153x f910a;
    /* renamed from: b */
    private static C0152w f911b;
    /* renamed from: c */
    private static C0119b f912c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.d$1 */
    static class C01121 implements Runnable {
        C01121() {
        }

        public final void run() {
            C0116d.m717a();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m717a() {
        Class cls;
        Object obj;
        C0092a a = C0092a.m597a();
        try {
            cls = Class.forName("com.tencent.bugly.unity.UnityAgent");
            obj = "com.tencent.bugly";
            a.getClass();
            String str = "lejiagu";
            if (!"".equals(str)) {
                obj = obj + "." + str;
            }
            try {
                Field declaredField = cls.getDeclaredField("sdkPackageName");
                declaredField.setAccessible(true);
                declaredField.set(null, obj);
            } catch (Exception e) {
            }
        } catch (Throwable th) {
            C0148u.m1035a("no unity agent", new Object[0]);
        }
        try {
            cls = Class.forName("com.tencent.bugly.cocos.Cocos2dxAgent");
            obj = "com.tencent.bugly";
            a.getClass();
            String str2 = "lejiagu";
            if (!"".equals(str2)) {
                obj = obj + "." + str2;
            }
            try {
                Field declaredField2 = cls.getDeclaredField("sdkPackageName");
                declaredField2.setAccessible(true);
                declaredField2.set(null, obj);
            } catch (Exception e2) {
            }
        } catch (Throwable th2) {
            C0148u.m1035a("no cocos agent", new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m718a(Context context) {
        C0111c a = C0111c.m698a();
        if (a != null) {
            f910a = new C0153x(context, a.f887k, C0095a.m641a(), C0092a.m597a(), a.f888l);
            f911b = new C0152w(context, a.f887k, C0095a.m641a(), C0092a.m597a(), a.f888l);
            f912c = new C0119b(context, a.f887k, C0095a.m641a(), C0092a.m597a(), a.f888l);
            C0147t.m1027a().m1032b(new C01121());
        }
    }

    /* renamed from: a */
    public static void m719a(StrategyBean strategyBean) {
        if (f911b != null) {
            C0152w c0152w = f911b;
            boolean z = strategyBean.f757h;
        }
    }

    /* renamed from: a */
    public static void m721a(final Thread thread, final String str, final String str2, final String str3) {
        if (f910a != null) {
            C0147t.m1027a().m1032b(new Runnable() {
                public final void run() {
                    try {
                        C0116d.f910a.m1061a(thread, str, str2, str3);
                    } catch (Throwable th) {
                        if (!C0148u.m1038b(th)) {
                            th.printStackTrace();
                        }
                        C0148u.m1041e("u3d crash error %s %s %s", str, str2, str3);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m720a(Thread thread, int i, String str, String str2, String str3) {
        if (f911b != null) {
            final Thread thread2 = thread;
            final int i2 = i;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            C0147t.m1027a().m1032b(new Runnable() {
                public final void run() {
                    try {
                        C0116d.f911b.m1060a(thread2, i2, str4, str5, str6);
                    } catch (Throwable th) {
                        if (!C0148u.m1038b(th)) {
                            th.printStackTrace();
                        }
                        C0148u.m1041e("cocos2d-x crash error %s %s %s", str4, str5, str6);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m722a(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (f912c != null) {
            final Thread thread2 = thread;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final Map<String, String> map2 = map;
            C0147t.m1027a().m1032b(new Runnable() {
                public final void run() {
                    try {
                        C0116d.f912c.m738a(thread2, str4, str5, str6, map2);
                    } catch (Throwable th) {
                        if (!C0148u.m1038b(th)) {
                            th.printStackTrace();
                        }
                        C0148u.m1041e("H5 crash error %s %s %s", str4, str5, str6);
                    }
                }
            });
        }
    }
}
