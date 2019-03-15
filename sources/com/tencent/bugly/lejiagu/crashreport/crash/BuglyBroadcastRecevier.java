package com.tencent.bugly.lejiagu.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.lejiagu.crashreport.biz.C0090b;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0144r;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;

/* compiled from: BUGLY */
public class BuglyBroadcastRecevier extends BroadcastReceiver {
    public static String ACTION_PROCESS_CRASHED = "com.tencent.feedback.A02";
    public static String ACTION_PROCESS_LAUNCHED = "com.tencent.feedback.A01";
    public static final long UPLOADLIMITED = 60000;
    /* renamed from: d */
    private static BuglyBroadcastRecevier f778d = null;
    /* renamed from: a */
    private IntentFilter f779a = new IntentFilter();
    /* renamed from: b */
    private Context f780b;
    /* renamed from: c */
    private String f781c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.BuglyBroadcastRecevier$1 */
    class C00961 implements Runnable {
        C00961(BuglyBroadcastRecevier buglyBroadcastRecevier) {
        }

        public final void run() {
            C0090b.f680a.m568b();
        }
    }

    public static synchronized BuglyBroadcastRecevier getInstance() {
        BuglyBroadcastRecevier buglyBroadcastRecevier;
        synchronized (BuglyBroadcastRecevier.class) {
            if (f778d == null) {
                f778d = new BuglyBroadcastRecevier();
            }
            buglyBroadcastRecevier = f778d;
        }
        return buglyBroadcastRecevier;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.f780b != null) {
            this.f780b.unregisterReceiver(this);
        }
    }

    public synchronized void addFilter(String str) {
        if (!this.f779a.hasAction(str)) {
            this.f779a.addAction(str);
        }
        C0148u.m1039c("add action %s", str);
    }

    public synchronized void regist(Context context, C0108b c0108b) {
        try {
            C0148u.m1035a("regis BC", new Object[0]);
            this.f780b = context;
            context.registerReceiver(this, this.f779a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void unregist(Context context) {
        try {
            C0148u.m1035a("unregis BC", new Object[0]);
            context.unregisterReceiver(this);
            this.f780b = context;
        } catch (Throwable th) {
        }
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            m649a(context, intent);
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private synchronized boolean m649a(Context context, Intent intent) {
        boolean z = true;
        synchronized (this) {
            if (!(context == null || intent == null)) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    String e = C0124a.m827e(this.f780b);
                    C0148u.m1039c("is Connect BC " + e, new Object[0]);
                    C0148u.m1035a("network %s changed to %s", this.f781c, e);
                    if (e == null) {
                        this.f781c = null;
                    } else {
                        String str = this.f781c;
                        this.f781c = e;
                        long currentTimeMillis = System.currentTimeMillis();
                        C0095a a = C0095a.m641a();
                        C0144r a2 = C0144r.m994a();
                        C0092a a3 = C0092a.m598a(context);
                        if (a == null || a2 == null || a3 == null) {
                            C0148u.m1040d("not inited BC not work", new Object[0]);
                        } else if (!e.equals(str)) {
                            if (currentTimeMillis - a2.m1010a(C0111c.f876a) > 60000) {
                                C0148u.m1035a("try to upload crash on network changed.", new Object[0]);
                                C0111c.m698a().m702a(0);
                            }
                            if (currentTimeMillis - a2.m1010a(1001) > 60000) {
                                C0148u.m1035a("try to upload userinfo on network changed.", new Object[0]);
                                C0147t.m1027a().m1032b(new C00961(this));
                            }
                        }
                    }
                }
            }
            z = false;
        }
        return z;
    }
}
