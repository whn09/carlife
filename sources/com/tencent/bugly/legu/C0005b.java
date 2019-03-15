package com.tencent.bugly.legu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.legu.crashreport.biz.C0014b;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.proguard.C0061m;
import com.tencent.bugly.legu.proguard.C0064o;
import com.tencent.bugly.legu.proguard.C0069t;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.C0076x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.b */
public final class C0005b {
    /* renamed from: a */
    public static boolean f33a = true;
    /* renamed from: b */
    public static boolean f34b;
    /* renamed from: c */
    public static Map<String, String> f35c = null;
    /* renamed from: d */
    private static List<C0004a> f36d = new ArrayList();
    /* renamed from: e */
    private static C0064o f37e;
    /* renamed from: f */
    private static C0061m f38f;
    /* renamed from: g */
    private static boolean f39g;

    /* renamed from: a */
    private static boolean m21a(C0016a c0016a) {
        List list = c0016a.f126m;
        c0016a.getClass();
        Object obj;
        if ("legu".equals("")) {
            obj = "bugly";
        } else {
            c0016a.getClass();
            obj = "legu";
        }
        if (list == null || !list.contains(r0)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static synchronized void m17a(Context context) {
        synchronized (C0005b.class) {
            C0005b.m18a(context, null);
        }
    }

    /* renamed from: a */
    public static synchronized void m18a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (C0005b.class) {
            if (f39g) {
                C0073w.m524d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C0073w.f588a, "[init] context of init() is null, check it.");
            } else {
                C0016a a = C0016a.m70a(context);
                if (C0005b.m21a(a)) {
                    f33a = false;
                } else {
                    String e = a.m87e();
                    if (e == null) {
                        Log.e(C0073w.f588a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                    } else {
                        C0005b.m19a(context, e, a.f133t, buglyStrategy);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m19a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (C0005b.class) {
            if (f39g) {
                C0073w.m524d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C0073w.f588a, "[init] context of init() is null, check it.");
            } else if (str == null) {
                Log.e(C0073w.f588a, "init arg 'crashReportAppID' should not be null!");
            } else {
                f39g = true;
                if (z) {
                    f34b = true;
                    C0073w.f589b = true;
                    C0073w.m524d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    C0073w.m525e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C0073w.m524d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    C0073w.m524d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    C0073w.m524d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    C0073w.m524d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    C0073w.m525e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C0073w.m521b("[init] bugly in debug mode.", new Object[0]);
                }
                if (context != null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                C0076x.m535a(context);
                C0016a a = C0016a.m70a(context);
                f37e = C0064o.m441a(context, f36d);
                C0069t.m479a(context);
                C0019a.m115a(context, f36d);
                f38f = C0061m.m421a(context);
                if (C0005b.m21a(a)) {
                    f33a = false;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    a.getClass();
                    C0073w.m519a(stringBuilder.append("legu crash report start init!").toString(), new Object[0]);
                    C0073w.m521b("[init] bugly start init...", new Object[0]);
                    a.m79a(str);
                    C0073w.m519a("[param] setted APPID:%s", str);
                    if (buglyStrategy != null) {
                        String substring;
                        String appVersion = buglyStrategy.getAppVersion();
                        if (!TextUtils.isEmpty(appVersion)) {
                            if (appVersion.length() > 100) {
                                substring = appVersion.substring(0, 100);
                                C0073w.m524d("appVersion %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), substring);
                            } else {
                                substring = appVersion;
                            }
                            a.f122i = substring;
                            C0073w.m519a("setted APPVERSION:%s", buglyStrategy.getAppVersion());
                        }
                        try {
                            if (buglyStrategy.isReplaceOldChannel()) {
                                appVersion = buglyStrategy.getAppChannel();
                                if (!TextUtils.isEmpty(appVersion)) {
                                    String str2;
                                    if (appVersion.length() > 100) {
                                        C0073w.m524d("appChannel %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), appVersion.substring(0, 100));
                                        str2 = substring;
                                    } else {
                                        str2 = appVersion;
                                    }
                                    f37e.m466a(556, "app_channel", str2.getBytes(), null, false);
                                    a.f123j = str2;
                                }
                            } else {
                                Map a2 = f37e.m464a(556, null, true);
                                if (a2 != null) {
                                    byte[] bArr = (byte[]) a2.get("app_channel");
                                    if (bArr != null) {
                                        a.f123j = new String(bArr);
                                    }
                                }
                            }
                            C0073w.m519a("setted APPCHANNEL:%s", a.f123j);
                        } catch (Exception e) {
                            if (f34b) {
                                e.printStackTrace();
                            }
                        }
                        appVersion = buglyStrategy.getAppPackageName();
                        if (!TextUtils.isEmpty(appVersion)) {
                            if (appVersion.length() > 100) {
                                substring = appVersion.substring(0, 100);
                                C0073w.m524d("appPackageName %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), substring);
                            } else {
                                substring = appVersion;
                            }
                            a.f116c = substring;
                            C0073w.m519a("setted PACKAGENAME:%s", buglyStrategy.getAppPackageName());
                        }
                        appVersion = buglyStrategy.getDeviceID();
                        if (appVersion != null) {
                            if (appVersion.length() > 100) {
                                substring = appVersion.substring(0, 100);
                                C0073w.m524d("deviceId %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), substring);
                            } else {
                                substring = appVersion;
                            }
                            a.m84c(substring);
                            C0073w.m519a("setted deviceId :%s", substring);
                        }
                        C0076x.f597a = buglyStrategy.isBuglyLogUpload();
                    }
                    C0014b.m43a(context, buglyStrategy);
                    f38f.m428b();
                    for (int i = 0; i < f36d.size(); i++) {
                        try {
                            if (f38f.m426a(((C0004a) f36d.get(i)).id)) {
                                ((C0004a) f36d.get(i)).init(context, z, buglyStrategy);
                            }
                        } catch (Throwable th) {
                            if (!C0073w.m520a(th)) {
                                th.printStackTrace();
                            }
                        }
                    }
                    C0073w.m519a("crash report inited!", new Object[0]);
                    C0073w.m521b("[init] bugly init finished.", new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m20a(C0004a c0004a) {
        if (!f36d.contains(c0004a)) {
            f36d.add(c0004a);
        }
    }
}
