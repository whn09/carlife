package com.tencent.bugly.lejiagu.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.lejiagu.crashreport.common.info.AppInfo;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.crash.C0108b;
import com.tencent.bugly.lejiagu.crashreport.crash.C0111c;
import com.tencent.bugly.lejiagu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.C0151v;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.jni.a */
public final class C0122a implements NativeExceptionHandler {
    /* renamed from: a */
    private final Context f959a;
    /* renamed from: b */
    private final C0108b f960b;
    /* renamed from: c */
    private final C0092a f961c;
    /* renamed from: d */
    private final C0095a f962d;
    /* renamed from: e */
    private final String f963e;

    public C0122a(Context context, C0092a c0092a, C0108b c0108b, C0095a c0095a, String str) {
        this.f959a = context;
        this.f960b = c0108b;
        this.f961c = c0092a;
        this.f962d = c0095a;
        this.f963e = str;
    }

    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, byte[] bArr, Map<String, String> map, boolean z) {
        boolean l = C0111c.m698a().m716l();
        String str10 = l ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (l) {
            C0148u.m1041e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f803b = 1;
        crashDetailBean.f806e = this.f961c.m618g();
        crashDetailBean.f807f = this.f961c.f729i;
        crashDetailBean.f808g = this.f961c.m632t();
        crashDetailBean.f814m = this.f961c.m616f();
        crashDetailBean.f815n = str3;
        crashDetailBean.f816o = str10;
        crashDetailBean.f817p = str4;
        crashDetailBean.f818q = str5;
        crashDetailBean.f819r = j;
        crashDetailBean.f822u = C0124a.m815b(crashDetailBean.f818q.getBytes());
        crashDetailBean.f827z = str;
        crashDetailBean.f782A = str2;
        crashDetailBean.f789H = this.f961c.m634v();
        crashDetailBean.f809h = this.f961c.m631s();
        crashDetailBean.f810i = this.f961c.m603D();
        crashDetailBean.f823v = str8;
        crashDetailBean.f790I = str7;
        crashDetailBean.f791J = str6;
        crashDetailBean.f792K = str9;
        crashDetailBean.f786E = this.f961c.m627o();
        crashDetailBean.f787F = this.f961c.m626n();
        crashDetailBean.f788G = this.f961c.m628p();
        if (z) {
            crashDetailBean.f783B = C0124a.m832i();
            crashDetailBean.f784C = C0124a.m830g();
            crashDetailBean.f785D = C0124a.m834k();
            crashDetailBean.f824w = C0124a.m792a(this.f959a, C0111c.f879d, null);
            crashDetailBean.f825x = C0151v.m1054a(true);
            crashDetailBean.f793L = this.f961c.f721a;
            crashDetailBean.f794M = this.f961c.f734n;
            crashDetailBean.f796O = this.f961c.m600A();
            crashDetailBean.f797P = this.f961c.m601B();
            crashDetailBean.f798Q = this.f961c.m635w();
            crashDetailBean.f799R = this.f961c.m638z();
            crashDetailBean.f826y = C0124a.m798a(C0111c.f880e, false);
            if (str == null) {
                crashDetailBean.f827z = this.f961c.f724d;
            }
            this.f960b.m696b(crashDetailBean);
        } else {
            crashDetailBean.f783B = -1;
            crashDetailBean.f784C = -1;
            crashDetailBean.f785D = -1;
            crashDetailBean.f824w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            crashDetailBean.f793L = -1;
            crashDetailBean.f796O = -1;
            crashDetailBean.f797P = -1;
            crashDetailBean.f798Q = map;
            crashDetailBean.f799R = null;
            crashDetailBean.f826y = null;
            if (str == null) {
                crashDetailBean.f827z = "unknown(record)";
            }
            if (bArr == null) {
                crashDetailBean.f825x = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.".getBytes();
            } else {
                crashDetailBean.f825x = bArr;
            }
        }
        return crashDetailBean;
    }

    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        C0148u.m1035a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    public final void handleNativeException2(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7, String[] strArr) {
        int i7;
        String str8;
        String str9;
        C0148u.m1035a("Native Crash Happen v2", new Object[0]);
        try {
            this.f962d.m648c();
            if (!this.f962d.m647b()) {
                C0148u.m1041e("waiting for remote sync", new Object[0]);
                i7 = 0;
                do {
                    if (this.f962d.m647b()) {
                        break;
                    }
                    Thread.sleep(500);
                    i7 += 500;
                } while (i7 < 5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
                return;
            }
            return;
        }
        long j3 = (1000 * j) + (j2 / 1000);
        String a = C0123b.m760a(str3);
        String str10 = "UNKNOWN(" + i4 + ")";
        if (i3 > 0) {
            str8 = "KERNEL";
            str9 = str + "(" + str5 + ")";
        } else if (i4 > 0) {
            Context context = this.f959a;
            str10 = AppInfo.m587a(i4);
            str8 = str5;
            str9 = str;
        } else {
            str8 = str5;
            str9 = str;
        }
        if (!this.f962d.m647b()) {
            C0148u.m1040d("no remote but still store!", new Object[0]);
        }
        if (this.f962d.m648c().f753d || !this.f962d.m647b()) {
            String str11 = null;
            String str12 = null;
            if (strArr != null) {
                Map hashMap = new HashMap();
                for (String split : strArr) {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    } else {
                        C0148u.m1040d("bad extraMsg %s", split);
                    }
                }
                str12 = (String) hashMap.get("ExceptionThreadName");
                str11 = (String) hashMap.get("ExceptionProcessName");
            } else {
                C0148u.m1039c("not found extraMsg", new Object[0]);
            }
            if (str11 == null || str11.length() == 0) {
                str11 = this.f961c.f724d;
            } else {
                C0148u.m1039c("crash process name change to %s", str11);
            }
            if (str12 == null || str12.length() == 0) {
                str12 = Thread.currentThread().getName();
            } else {
                C0148u.m1039c("crash thread name change to %s", str12);
            }
            CrashDetailBean packageCrashDatas = packageCrashDatas(str11, str12, j3, str9, str2, a, str8, str10, str4, str7, null, null, true);
            if (packageCrashDatas == null) {
                C0148u.m1041e("pkg crash datas fail!", new Object[0]);
                return;
            }
            C0108b.m683a("NATIVE_CRASH", C0124a.m837n(), this.f961c.f724d, Thread.currentThread(), str9 + "\n" + str2 + "\n" + a, packageCrashDatas);
            if (!this.f960b.m695a(packageCrashDatas, i3)) {
                this.f960b.m692a(packageCrashDatas, 5000, true);
            }
            C0123b.m761b(this.f963e);
            return;
        }
        C0148u.m1041e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
        C0108b.m683a("NATIVE_CRASH", C0124a.m837n(), this.f961c.f724d, Thread.currentThread(), str9 + "\n" + str2 + "\n" + a, null);
        if (str4 != null) {
            File file = new File(str4);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        }
    }
}
