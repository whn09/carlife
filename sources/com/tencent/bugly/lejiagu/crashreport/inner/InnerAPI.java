package com.tencent.bugly.lejiagu.crashreport.inner;

import android.content.Context;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.crash.C0116d;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.util.Map;

/* compiled from: BUGLY */
public class InnerAPI {
    public static Context context;

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C0148u.m1041e("post u3d fail args null", new Object[0]);
        }
        C0148u.m1035a("post u3d crash %s %s", str, str2);
        C0116d.m721a(Thread.currentThread(), str, str2, str3);
    }

    public static void postCocos2dxCrashAsync(int i, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C0148u.m1041e("post cocos2d-x fail args null", new Object[0]);
        } else if (i == 5 || i == 6) {
            C0148u.m1035a("post cocos2d-x crash %s %s", str, str2);
            C0116d.m720a(Thread.currentThread(), i, str, str2, str3);
        } else {
            C0148u.m1041e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i));
        }
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null) {
            C0148u.m1041e("post h5 fail args null", new Object[0]);
            return;
        }
        C0148u.m1035a("post h5 crash %s %s", str, str2);
        C0116d.m722a(thread, str, str2, str3, (Map) map);
    }

    public static void setOuterSdkVersion(Context context, String str, String str2) {
        int i;
        if (context == null) {
            C0148u.m1040d("context is null when putsdkdata", new Object[0]);
        }
        if (str == null || str.trim().length() <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0) {
            if (str2 == null || str2.trim().length() <= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                String replace = str.replace("[a-zA-Z[0-9]]+", "");
                if (replace.length() > 50) {
                    C0148u.m1040d("putSdkData key length over limit %d , will drop this new key %s", Integer.valueOf(50), replace);
                    return;
                }
                if (str2.length() > 200) {
                    C0148u.m1040d("putSdkData value length over limit %d , has been cutted!", Integer.valueOf(200));
                    str2 = str2.substring(0, 200);
                }
                C0092a.m598a(context).m609b("SDK_" + replace, str2);
                C0148u.m1037b("[param] putSdkData data: %s - %s", replace, str2);
            }
        }
    }
}
