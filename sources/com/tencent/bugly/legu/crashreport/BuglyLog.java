package com.tencent.bugly.legu.crashreport;

import android.util.Log;
import com.tencent.bugly.legu.C0005b;
import com.tencent.bugly.legu.proguard.C0076x;

/* compiled from: BUGLY */
public class BuglyLog {
    /* renamed from: v */
    public static void m26v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0005b.f34b) {
            Log.v(str, str2);
        }
        C0076x.m536a("V", str, str2);
    }

    /* renamed from: d */
    public static void m22d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0005b.f34b) {
            Log.d(str, str2);
        }
        C0076x.m536a("D", str, str2);
    }

    /* renamed from: i */
    public static void m25i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0005b.f34b) {
            Log.i(str, str2);
        }
        C0076x.m536a("I", str, str2);
    }

    /* renamed from: w */
    public static void m27w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0005b.f34b) {
            Log.w(str, str2);
        }
        C0076x.m536a("W", str, str2);
    }

    /* renamed from: e */
    public static void m23e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0005b.f34b) {
            Log.e(str, str2);
        }
        C0076x.m536a("E", str, str2);
    }

    /* renamed from: e */
    public static void m24e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0005b.f34b) {
            Log.e(str, str2, th);
        }
        C0076x.m537a("E", str, th);
    }

    public static void setCache(int i) {
        C0076x.m534a(i);
    }
}
