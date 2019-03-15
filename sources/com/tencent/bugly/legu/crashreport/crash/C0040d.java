package com.tencent.bugly.legu.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.crashreport.crash.h5.C0043b;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.C0077y;
import com.tencent.bugly.legu.proguard.C0078z;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.crash.d */
public final class C0040d {
    /* renamed from: a */
    private static C0078z f303a;
    /* renamed from: b */
    private static C0077y f304b;
    /* renamed from: c */
    private static C0043b f305c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.d$1 */
    static class C00361 implements Runnable {
        C00361() {
        }

        public final void run() {
            C0040d.m190a();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m190a() {
        Class cls;
        Object obj;
        C0016a a = C0016a.m69a();
        try {
            cls = Class.forName("com.tencent.bugly.unity.UnityAgent");
            obj = "com.tencent.bugly";
            a.getClass();
            String str = "legu";
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
            C0073w.m519a("no unity agent", new Object[0]);
        }
        try {
            cls = Class.forName("com.tencent.bugly.cocos.Cocos2dxAgent");
            obj = "com.tencent.bugly";
            a.getClass();
            String str2 = "legu";
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
            C0073w.m519a("no cocos agent", new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m191a(Context context) {
        C0035c a = C0035c.m171a();
        if (a != null) {
            f303a = new C0078z(context, a.f280k, C0019a.m114a(), C0016a.m69a(), a.f281l);
            f304b = new C0077y(context, a.f280k, C0019a.m114a(), C0016a.m69a(), a.f281l);
            f305c = new C0043b(context, a.f280k, C0019a.m114a(), C0016a.m69a(), a.f281l);
            C0072v.m511a().m516b(new C00361());
        }
    }

    /* renamed from: a */
    public static void m192a(StrategyBean strategyBean) {
        if (f304b != null) {
            C0077y c0077y = f304b;
            boolean z = strategyBean.f150h;
        }
    }

    /* renamed from: a */
    public static void m194a(final Thread thread, final String str, final String str2, final String str3) {
        if (f303a != null) {
            C0072v.m511a().m516b(new Runnable() {
                public final void run() {
                    try {
                        C0040d.f303a.m545a(thread, str, str2, str3);
                    } catch (Throwable th) {
                        if (!C0073w.m522b(th)) {
                            th.printStackTrace();
                        }
                        C0073w.m525e("u3d crash error %s %s %s", str, str2, str3);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m193a(Thread thread, int i, String str, String str2, String str3) {
        if (f304b != null) {
            final Thread thread2 = thread;
            final int i2 = i;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            C0072v.m511a().m516b(new Runnable() {
                public final void run() {
                    try {
                        C0040d.f304b.m544a(thread2, i2, str4, str5, str6);
                    } catch (Throwable th) {
                        if (!C0073w.m522b(th)) {
                            th.printStackTrace();
                        }
                        C0073w.m525e("cocos2d-x crash error %s %s %s", str4, str5, str6);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m195a(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (f305c != null) {
            final Thread thread2 = thread;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final Map<String, String> map2 = map;
            C0072v.m511a().m516b(new Runnable() {
                public final void run() {
                    try {
                        C0040d.f305c.m210a(thread2, str4, str5, str6, map2);
                    } catch (Throwable th) {
                        if (!C0073w.m522b(th)) {
                            th.printStackTrace();
                        }
                        C0073w.m525e("H5 crash error %s %s %s", str4, str5, str6);
                    }
                }
            });
        }
    }
}
