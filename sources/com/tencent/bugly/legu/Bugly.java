package com.tencent.bugly.legu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.proguard.C0064o;
import com.tencent.bugly.legu.proguard.C0073w;
import java.util.Map;

/* compiled from: BUGLY */
public class Bugly {
    public static final String SDK_IS_DEV = "false";
    /* renamed from: a */
    private static boolean f11a;
    public static Context applicationContext = null;
    /* renamed from: b */
    private static String[] f12b = new String[]{"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};
    /* renamed from: c */
    private static String[] f13c = new String[]{"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (!f11a) {
                f11a = true;
                if (context != null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                applicationContext = context;
                if (context == null) {
                    Log.e(C0073w.f588a, "init arg 'context' should not be null!");
                } else {
                    if (isDev()) {
                        f12b = f13c;
                    }
                    for (String str2 : f12b) {
                        try {
                            if (str2.equals("BuglyCrashModule")) {
                                C0005b.m20a(CrashModule.getInstance());
                            } else if (!(str2.equals("BuglyBetaModule") || str2.equals("BuglyRqdModule"))) {
                                str2.equals("BuglyFeedbackModule");
                            }
                        } catch (Throwable th) {
                            C0073w.m522b(th);
                        }
                    }
                    C0005b.f33a = enable;
                    C0005b.m19a(applicationContext, str, z, buglyStrategy);
                }
            }
        }
    }

    public static synchronized String getAppChannel() {
        String str = null;
        synchronized (Bugly.class) {
            C0016a a = C0016a.m69a();
            if (a != null) {
                if (TextUtils.isEmpty(a.f123j)) {
                    C0064o a2 = C0064o.m440a();
                    if (a2 == null) {
                        str = a.f123j;
                    } else {
                        Map a3 = a2.m464a(556, null, true);
                        if (a3 != null) {
                            byte[] bArr = (byte[]) a3.get("app_channel");
                            if (bArr != null) {
                                str = new String(bArr);
                            }
                        }
                    }
                }
                str = a.f123j;
            }
        }
        return str;
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean(SDK_IS_DEV.replace("@", "")));
        }
        return isDev.booleanValue();
    }
}
