package com.tencent.bugly.lejiagu;

import android.content.Context;
import com.tencent.bugly.lejiagu.crashreport.BuglyHintException;

/* compiled from: BUGLY */
public class Bugly {
    /* renamed from: a */
    private static boolean f620a;
    public static boolean enable = true;

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (!f620a) {
                f620a = true;
                if (context != null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (context == null) {
                    throw new BuglyHintException("init arg 'context' should not be null!");
                }
                C0081b.m549a(context, str, z, buglyStrategy);
            }
        }
    }
}
