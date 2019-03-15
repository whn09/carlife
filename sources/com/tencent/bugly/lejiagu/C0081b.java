package com.tencent.bugly.lejiagu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.legu.Bugly;
import com.tencent.bugly.lejiagu.crashreport.BuglyHintException;
import com.tencent.bugly.lejiagu.crashreport.biz.C0090b;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0139m;
import com.tencent.bugly.lejiagu.proguard.C0144r;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.C0151v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.b */
public final class C0081b {
    /* renamed from: a */
    public static boolean f637a;
    /* renamed from: b */
    public static Map<String, String> f638b = null;
    /* renamed from: c */
    private static List<C0080a> f639c = new ArrayList();
    /* renamed from: d */
    private static final String f640d;
    /* renamed from: e */
    private static final String f641e = (f640d + ".CrashModule");
    /* renamed from: f */
    private static final String f642f = (f640d + ".beta.Beta");
    /* renamed from: g */
    private static final String f643g = (f640d + ".feedback.BFeedback");
    /* renamed from: h */
    private static String[] f644h = new String[]{f641e, "com.tencent.feedback.eup.CrashReport", f642f};
    /* renamed from: i */
    private static String[] f645i = new String[]{"com.tencent.feedback.eup.CrashReport", f641e, f642f, f643g};
    /* renamed from: j */
    private static Boolean f646j;
    /* renamed from: k */
    private static boolean f647k;

    static {
        StringBuilder stringBuilder = new StringBuilder("com.tencent.bugly");
        String str = ("lejiagu".equals("") || "lejiagu".contains("@")) ? "" : ".lejiagu";
        f640d = stringBuilder.append(str).toString();
    }

    /* renamed from: a */
    private static boolean m550a(C0092a c0092a) {
        List list = c0092a.f733m;
        c0092a.getClass();
        Object obj;
        if ("lejiagu".equals("")) {
            obj = "bugly";
        } else {
            c0092a.getClass();
            obj = "lejiagu";
        }
        if (list == null || !list.contains(r0)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static synchronized void m547a(Context context) {
        synchronized (C0081b.class) {
            C0081b.m548a(context, null);
        }
    }

    /* renamed from: a */
    public static synchronized void m548a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (C0081b.class) {
            if (f647k) {
                C0148u.m1040d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C0148u.f1187b, "[init] context of init() is null, check it.");
            } else {
                C0092a a = C0092a.m598a(context);
                if (C0081b.m550a(a)) {
                    Bugly.enable = false;
                } else {
                    String e = a.m614e();
                    if (e == null) {
                        throw new BuglyHintException("[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                    }
                    C0081b.m549a(context, e, a.f740t, buglyStrategy);
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m549a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        int i = 0;
        synchronized (C0081b.class) {
            if (f647k) {
                C0148u.m1040d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C0148u.f1187b, "[init] context of init() is null, check it.");
            } else if (str == null) {
                throw new BuglyHintException("init arg 'crashReportAppID' should not be null!");
            } else {
                f647k = true;
                if (z) {
                    f637a = true;
                    C0148u.f1188c = true;
                    C0148u.m1040d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    C0148u.m1041e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C0148u.m1040d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    C0148u.m1040d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    C0148u.m1040d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    C0148u.m1040d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    C0148u.m1041e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C0148u.m1037b("[init] bugly in debug mode.", new Object[0]);
                }
                if (context != null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (f646j == null) {
                    f646j = Boolean.valueOf(Boolean.parseBoolean(Bugly.SDK_IS_DEV.replace("@", "")));
                }
                if (f646j.booleanValue()) {
                    f644h = f645i;
                }
                for (String a : f644h) {
                    try {
                        C0080a c0080a = (C0080a) C0124a.m789a(a, "getInstance", null, null, null);
                        if (c0080a != null) {
                            f639c.add(c0080a);
                            C0148u.m1039c("[module] load: %s", a);
                        }
                    } catch (Throwable th) {
                    }
                }
                C0151v.m1051a(context);
                C0139m.m964a(context, f639c);
                C0144r.m995a(context);
                C0095a.m642a(context, f639c);
                C0092a a2 = C0092a.m598a(context);
                if (C0081b.m550a(a2)) {
                    Bugly.enable = false;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    a2.getClass();
                    C0148u.m1035a(stringBuilder.append("lejiagu crash report start init!").toString(), new Object[0]);
                    C0148u.m1037b("[init] bugly start init...", new Object[0]);
                    a2.m606a(str);
                    C0148u.m1035a("[param] setted APPID:%s", str);
                    if (buglyStrategy != null) {
                        String substring;
                        String appVersion = buglyStrategy.getAppVersion();
                        if (!TextUtils.isEmpty(appVersion)) {
                            if (appVersion.length() > 100) {
                                substring = appVersion.substring(0, 100);
                                C0148u.m1040d("appVersion %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), substring);
                            } else {
                                substring = appVersion;
                            }
                            a2.f729i = substring;
                            C0148u.m1035a("setted APPVERSION:%s", buglyStrategy.getAppVersion());
                        }
                        appVersion = buglyStrategy.getAppChannel();
                        if (!TextUtils.isEmpty(appVersion)) {
                            if (appVersion.length() > 100) {
                                substring = appVersion.substring(0, 100);
                                C0148u.m1040d("appChannel %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), substring);
                            } else {
                                substring = appVersion;
                            }
                            a2.f730j = substring;
                            C0148u.m1035a("setted APPCHANNEL:%s", buglyStrategy.getAppChannel());
                        }
                        appVersion = buglyStrategy.getAppPackageName();
                        if (!TextUtils.isEmpty(appVersion)) {
                            if (appVersion.length() > 100) {
                                substring = appVersion.substring(0, 100);
                                C0148u.m1040d("appPackageName %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), substring);
                            } else {
                                substring = appVersion;
                            }
                            a2.f723c = substring;
                            C0148u.m1035a("setted PACKAGENAME:%s", buglyStrategy.getAppPackageName());
                        }
                        appVersion = buglyStrategy.getDeviceID();
                        if (appVersion != null) {
                            if (appVersion.length() > 100) {
                                substring = appVersion.substring(0, 100);
                                C0148u.m1040d("deviceId %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), substring);
                            } else {
                                substring = appVersion;
                            }
                            a2.m611c(substring);
                            C0148u.m1035a("setted deviceId :%s", substring);
                        }
                        C0151v.f1195a = buglyStrategy.isBuglyLogUpload();
                    }
                    C0090b.m572a(context, buglyStrategy);
                    while (i < f639c.size()) {
                        try {
                            ((C0080a) f639c.get(i)).init(context, z, buglyStrategy);
                        } catch (Throwable th2) {
                            if (!C0148u.m1036a(th2)) {
                                th2.printStackTrace();
                            }
                        }
                        i++;
                    }
                    C0148u.m1035a("crash report inited!", new Object[0]);
                    C0148u.m1037b("[init] bugly init finished.", new Object[0]);
                }
            }
        }
    }
}
