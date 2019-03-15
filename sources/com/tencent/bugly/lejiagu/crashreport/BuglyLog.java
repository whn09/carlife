package com.tencent.bugly.lejiagu.crashreport;

import android.util.Log;
import com.tencent.bugly.lejiagu.C0081b;
import com.tencent.bugly.lejiagu.proguard.C0151v;

/* compiled from: BUGLY */
public class BuglyLog {
    /* renamed from: v */
    public static void m555v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0081b.f637a) {
            Log.v(str, str2);
        }
        C0151v.m1052a("V", str, str2);
    }

    /* renamed from: d */
    public static void m551d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0081b.f637a) {
            Log.d(str, str2);
        }
        C0151v.m1052a("D", str, str2);
    }

    /* renamed from: i */
    public static void m554i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0081b.f637a) {
            Log.i(str, str2);
        }
        C0151v.m1052a("I", str, str2);
    }

    /* renamed from: w */
    public static void m556w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0081b.f637a) {
            Log.w(str, str2);
        }
        C0151v.m1052a("W", str, str2);
    }

    /* renamed from: e */
    public static void m552e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0081b.f637a) {
            Log.e(str, str2);
        }
        C0151v.m1052a("E", str, str2);
    }

    /* renamed from: e */
    public static void m553e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C0081b.f637a) {
            Log.e(str, str2, th);
        }
        C0151v.m1053a("E", str, th);
    }

    public static void setCache(int i) {
        C0151v.m1050a(i);
    }
}
