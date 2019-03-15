package com.tencent.bugly.legu.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.w */
public final class C0073w {
    /* renamed from: a */
    public static String f588a = "CrashReport";
    /* renamed from: b */
    public static boolean f589b = false;
    /* renamed from: c */
    private static String f590c = "CrashReportInfo";

    /* renamed from: a */
    private static boolean m518a(int i, String str, Object... objArr) {
        if (!f589b) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (!(objArr == null || objArr.length == 0)) {
            str = String.format(Locale.US, str, objArr);
        }
        switch (i) {
            case 0:
                Log.i(f588a, str);
                return true;
            case 1:
                Log.d(f588a, str);
                return true;
            case 2:
                Log.w(f588a, str);
                return true;
            case 3:
                Log.e(f588a, str);
                return true;
            case 5:
                Log.i(f590c, str);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static boolean m519a(String str, Object... objArr) {
        return C0073w.m518a(0, str, objArr);
    }

    /* renamed from: b */
    public static boolean m521b(String str, Object... objArr) {
        return C0073w.m518a(5, str, objArr);
    }

    /* renamed from: c */
    public static boolean m523c(String str, Object... objArr) {
        return C0073w.m518a(1, str, objArr);
    }

    /* renamed from: d */
    public static boolean m524d(String str, Object... objArr) {
        return C0073w.m518a(2, str, objArr);
    }

    /* renamed from: a */
    public static boolean m520a(Throwable th) {
        return !f589b ? false : C0073w.m518a(2, C0048a.m260a(th), new Object[0]);
    }

    /* renamed from: e */
    public static boolean m525e(String str, Object... objArr) {
        return C0073w.m518a(3, str, objArr);
    }

    /* renamed from: b */
    public static boolean m522b(Throwable th) {
        return !f589b ? false : C0073w.m518a(3, C0048a.m260a(th), new Object[0]);
    }
}
