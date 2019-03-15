package com.tencent.bugly.legu.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.legu.crashreport.biz.C0014b;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0069t;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;

/* compiled from: BUGLY */
public class BuglyBroadcastRecevier extends BroadcastReceiver {
    public static String ACTION_PROCESS_CRASHED = "com.tencent.feedback.A02";
    public static String ACTION_PROCESS_LAUNCHED = "com.tencent.feedback.A01";
    public static final long UPLOADLIMITED = 60000;
    /* renamed from: d */
    private static BuglyBroadcastRecevier f171d = null;
    /* renamed from: a */
    private IntentFilter f172a = new IntentFilter();
    /* renamed from: b */
    private Context f173b;
    /* renamed from: c */
    private String f174c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.BuglyBroadcastRecevier$1 */
    class C00201 implements Runnable {
        C00201(BuglyBroadcastRecevier buglyBroadcastRecevier) {
        }

        public final void run() {
            C0014b.f72a.m39b();
        }
    }

    public static synchronized BuglyBroadcastRecevier getInstance() {
        BuglyBroadcastRecevier buglyBroadcastRecevier;
        synchronized (BuglyBroadcastRecevier.class) {
            if (f171d == null) {
                f171d = new BuglyBroadcastRecevier();
            }
            buglyBroadcastRecevier = f171d;
        }
        return buglyBroadcastRecevier;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.f173b != null) {
            this.f173b.unregisterReceiver(this);
        }
    }

    public synchronized void addFilter(String str) {
        if (!this.f172a.hasAction(str)) {
            this.f172a.addAction(str);
        }
        C0073w.m523c("add action %s", str);
    }

    public synchronized void regist(Context context, C0032b c0032b) {
        try {
            C0073w.m519a("regis BC", new Object[0]);
            this.f173b = context;
            context.registerReceiver(this, this.f172a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void unregist(Context context) {
        try {
            C0073w.m519a("unregis BC", new Object[0]);
            context.unregisterReceiver(this);
            this.f173b = context;
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            m122a(context, intent);
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private synchronized boolean m122a(Context context, Intent intent) {
        boolean z = true;
        synchronized (this) {
            if (!(context == null || intent == null)) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    String e = C0048a.m293e(this.f173b);
                    C0073w.m523c("is Connect BC " + e, new Object[0]);
                    C0073w.m519a("network %s changed to %s", this.f174c, e);
                    if (e == null) {
                        this.f174c = null;
                    } else {
                        String str = this.f174c;
                        this.f174c = e;
                        long currentTimeMillis = System.currentTimeMillis();
                        C0019a a = C0019a.m114a();
                        C0069t a2 = C0069t.m478a();
                        C0016a a3 = C0016a.m70a(context);
                        if (a == null || a2 == null || a3 == null) {
                            C0073w.m524d("not inited BC not work", new Object[0]);
                        } else if (!e.equals(str)) {
                            if (currentTimeMillis - a2.m494a(C0035c.f269a) > 60000) {
                                C0073w.m519a("try to upload crash on network changed.", new Object[0]);
                                C0035c.m171a().m175a(0);
                            }
                            if (currentTimeMillis - a2.m494a(1001) > 60000) {
                                C0073w.m519a("try to upload userinfo on network changed.", new Object[0]);
                                C0072v.m511a().m516b(new C00201(this));
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
