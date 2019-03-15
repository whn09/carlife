package com.tencent.bugly.lejiagu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.bugly.lejiagu.BuglyStrategy.C0079a;
import com.tencent.bugly.lejiagu.crashreport.CrashReport;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.crashreport.crash.C0111c;
import com.tencent.bugly.lejiagu.crashreport.crash.C0116d;
import com.tencent.bugly.lejiagu.crashreport.inner.InnerAPI;
import com.tencent.bugly.lejiagu.proguard.C0148u;

/* compiled from: BUGLY */
public class CrashModule extends C0080a {
    public static final int MODULE_ID = 1004;
    /* renamed from: c */
    private static boolean f633c = false;
    /* renamed from: d */
    private static CrashModule f634d = new CrashModule();
    /* renamed from: a */
    private long f635a;
    /* renamed from: b */
    private C0079a f636b;

    public static CrashModule getInstance() {
        return f634d;
    }

    public static boolean hasInitialized() {
        return f633c;
    }

    public void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        if (context != null && !f633c) {
            f633c = true;
            CrashReport.setContext(context);
            m546a(context, buglyStrategy);
            C0111c.m700a(1004, context, z, this.f636b, null, null);
            C0111c a = C0111c.m698a();
            a.m709e();
            if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                a.m711g();
            } else {
                C0148u.m1035a("[crash] Closed native crash monitor!", new Object[0]);
                a.m710f();
            }
            if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                a.m712h();
            } else {
                C0148u.m1035a("[crash] Closed ANR monitor!", new Object[0]);
                a.m713i();
            }
            InnerAPI.context = context;
            C0116d.m718a(context);
            C0111c.m698a().m702a(this.f635a);
        }
    }

    /* renamed from: a */
    private synchronized void m546a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy != null) {
            Object libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                C0092a.m598a(context).f731k = libBuglySOFilePath;
                C0148u.m1035a("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.f636b = buglyStrategy.getCrashHandleCallback();
                C0148u.m1035a("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                this.f635a = buglyStrategy.getAppReportDelay();
                C0148u.m1035a("setted delay: %d", Long.valueOf(this.f635a));
            }
        }
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            C0111c a = C0111c.m698a();
            if (a != null) {
                a.m703a(strategyBean);
            }
            C0116d.m719a(strategyBean);
        }
    }

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(" CREATE TABLE t_cr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _s1").append(" text").append(" , _up").append(" int").append(" , _me").append(" int").append(" , _uc").append(" int").append(" , _dt").append(" blob").append(" ) ");
        C0148u.m1039c("create %s", stringBuilder);
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }
}
