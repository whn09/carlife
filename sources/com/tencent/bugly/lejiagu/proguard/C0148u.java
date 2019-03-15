package com.tencent.bugly.lejiagu.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.u */
public final class C0148u {
    /* renamed from: a */
    public static String f1186a = "CrashReportInfo";
    /* renamed from: b */
    public static String f1187b = "CrashReport";
    /* renamed from: c */
    public static boolean f1188c = false;

    /* renamed from: a */
    private static boolean m1034a(int i, String str, Object... objArr) {
        if (!f1188c) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (!(objArr == null || objArr.length == 0)) {
            str = String.format(Locale.US, str, objArr);
        }
        switch (i) {
            case 0:
                Log.i(f1187b, str);
                return true;
            case 1:
                Log.d(f1187b, str);
                return true;
            case 2:
                Log.w(f1187b, str);
                return true;
            case 3:
                Log.e(f1187b, str);
                return true;
            case 5:
                Log.i(f1186a, str);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static boolean m1035a(String str, Object... objArr) {
        return C0148u.m1034a(0, str, objArr);
    }

    /* renamed from: b */
    public static boolean m1037b(String str, Object... objArr) {
        return C0148u.m1034a(5, str, objArr);
    }

    /* renamed from: c */
    public static boolean m1039c(String str, Object... objArr) {
        return C0148u.m1034a(1, str, objArr);
    }

    /* renamed from: d */
    public static boolean m1040d(String str, Object... objArr) {
        return C0148u.m1034a(2, str, objArr);
    }

    /* renamed from: a */
    public static boolean m1036a(Throwable th) {
        return !f1188c ? false : C0148u.m1034a(2, C0124a.m794a(th), new Object[0]);
    }

    /* renamed from: e */
    public static boolean m1041e(String str, Object... objArr) {
        return C0148u.m1034a(3, str, objArr);
    }

    /* renamed from: b */
    public static boolean m1038b(Throwable th) {
        return !f1188c ? false : C0148u.m1034a(3, C0124a.m794a(th), new Object[0]);
    }
}
