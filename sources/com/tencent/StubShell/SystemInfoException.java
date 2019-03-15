package com.tencent.StubShell;

import android.os.Build;
import com.tencent.bugly.legu.crashreport.BuglyLog;
import java.io.File;
import org.json.JSONObject;

public class SystemInfoException extends Throwable {
    public SystemInfoException(String str) {
        if (str != null) {
            try {
                BuglyLog.m25i("Legu", str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public SystemInfoException(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fingerprint", Build.FINGERPRINT);
            if (new File("/system/lib/libdvm.so").exists()) {
                jSONObject.put("libdvm32", C0000a.m14a("/system/lib/libdvm.so"));
            }
            if (new File("/system/lib/libart.so").exists()) {
                jSONObject.put("libart32", C0000a.m14a("/system/lib/libart.so"));
            }
            if (new File("/system/lib64/libdvm.so").exists()) {
                jSONObject.put("libdvm64", C0000a.m14a("/system/lib64/libdvm.so"));
            }
            if (new File("/system/lib64/libart.so").exists()) {
                jSONObject.put("libart64", C0000a.m14a("/system/lib64/libart.so"));
            }
            if (new File(str).exists()) {
                jSONObject.put("apk_md5", C0000a.m14a(str));
            }
            jSONObject.put("apk_version", str2);
            BuglyLog.m25i("Legu", jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
