package com.tencent.bugly.legu.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.legu.crashreport.common.info.AppInfo;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.crash.C0032b;
import com.tencent.bugly.legu.crashreport.crash.C0035c;
import com.tencent.bugly.legu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.C0076x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.crash.jni.a */
public final class C0046a implements NativeExceptionHandler {
    /* renamed from: a */
    private final Context f352a;
    /* renamed from: b */
    private final C0032b f353b;
    /* renamed from: c */
    private final C0016a f354c;
    /* renamed from: d */
    private final C0019a f355d;
    /* renamed from: e */
    private final String f356e;

    public C0046a(Context context, C0016a c0016a, C0032b c0032b, C0019a c0019a, String str) {
        this.f352a = context;
        this.f353b = c0032b;
        this.f354c = c0016a;
        this.f355d = c0019a;
        this.f356e = str;
    }

    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, byte[] bArr, Map<String, String> map, boolean z) {
        boolean l = C0035c.m171a().m189l();
        String str10 = l ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (l) {
            C0073w.m525e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f196b = 1;
        crashDetailBean.f199e = this.f354c.m91g();
        crashDetailBean.f200f = this.f354c.f122i;
        crashDetailBean.f201g = this.f354c.m105t();
        crashDetailBean.f207m = this.f354c.m89f();
        crashDetailBean.f208n = str3;
        crashDetailBean.f209o = str10;
        crashDetailBean.f210p = str4;
        crashDetailBean.f211q = str5;
        crashDetailBean.f212r = j;
        crashDetailBean.f215u = C0048a.m281b(crashDetailBean.f211q.getBytes());
        crashDetailBean.f220z = str;
        crashDetailBean.f175A = str2;
        crashDetailBean.f182H = this.f354c.m107v();
        crashDetailBean.f202h = this.f354c.m104s();
        crashDetailBean.f203i = this.f354c.m76E();
        crashDetailBean.f216v = str8;
        crashDetailBean.f183I = str7;
        crashDetailBean.f184J = str6;
        crashDetailBean.f185K = str9;
        crashDetailBean.f179E = this.f354c.m100o();
        crashDetailBean.f180F = this.f354c.m99n();
        crashDetailBean.f181G = this.f354c.m101p();
        if (z) {
            crashDetailBean.f176B = C0048a.m298i();
            crashDetailBean.f177C = C0048a.m296g();
            crashDetailBean.f178D = C0048a.m300k();
            crashDetailBean.f217w = C0048a.m258a(this.f352a, C0035c.f272d, null);
            crashDetailBean.f218x = C0076x.m538a(true);
            crashDetailBean.f186L = this.f354c.f114a;
            crashDetailBean.f187M = this.f354c.f127n;
            crashDetailBean.f189O = this.f354c.m73B();
            crashDetailBean.f190P = this.f354c.m74C();
            crashDetailBean.f191Q = this.f354c.m108w();
            crashDetailBean.f192R = this.f354c.m72A();
            crashDetailBean.f219y = C0048a.m264a(C0035c.f273e, false);
            str10 = "java:\n";
            if (crashDetailBean.f211q != null) {
                int indexOf = crashDetailBean.f211q.indexOf(str10);
                if (indexOf > 0) {
                    indexOf += str10.length();
                    String substring = crashDetailBean.f211q.substring(indexOf, crashDetailBean.f211q.length() - 1);
                    if (substring.length() > 0 && crashDetailBean.f219y.containsKey(crashDetailBean.f175A)) {
                        str10 = (String) crashDetailBean.f219y.get(crashDetailBean.f175A);
                        int indexOf2 = str10.indexOf(substring);
                        if (indexOf2 > 0) {
                            str10 = str10.substring(indexOf2);
                            crashDetailBean.f219y.put(crashDetailBean.f175A, str10);
                            crashDetailBean.f211q = crashDetailBean.f211q.substring(0, indexOf);
                            crashDetailBean.f211q += str10;
                        }
                    }
                }
            }
            if (str == null) {
                crashDetailBean.f220z = this.f354c.f117d;
            }
            this.f353b.m169b(crashDetailBean);
        } else {
            crashDetailBean.f176B = -1;
            crashDetailBean.f177C = -1;
            crashDetailBean.f178D = -1;
            crashDetailBean.f217w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            crashDetailBean.f186L = -1;
            crashDetailBean.f189O = -1;
            crashDetailBean.f190P = -1;
            crashDetailBean.f191Q = map;
            crashDetailBean.f192R = null;
            crashDetailBean.f219y = null;
            if (str == null) {
                crashDetailBean.f220z = "unknown(record)";
            }
            if (bArr == null) {
                crashDetailBean.f218x = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.".getBytes();
            } else {
                crashDetailBean.f218x = bArr;
            }
        }
        return crashDetailBean;
    }

    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        C0073w.m519a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    public final void handleNativeException2(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7, String[] strArr) {
        int i7;
        String str8;
        String str9;
        C0073w.m519a("Native Crash Happen v2", new Object[0]);
        try {
            this.f355d.m121c();
            if (!this.f355d.m120b()) {
                C0073w.m525e("waiting for remote sync", new Object[0]);
                i7 = 0;
                do {
                    if (this.f355d.m120b()) {
                        break;
                    }
                    Thread.sleep(500);
                    i7 += 500;
                } while (i7 < 5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
                return;
            }
            return;
        }
        long j3 = (1000 * j) + (j2 / 1000);
        String a = C0047b.m226a(str3);
        String str10 = "UNKNOWN(" + i4 + ")";
        if (i3 > 0) {
            str8 = "KERNEL";
            str9 = str + "(" + str5 + ")";
        } else if (i4 > 0) {
            Context context = this.f352a;
            str10 = AppInfo.m59a(i4);
            str8 = str5;
            str9 = str;
        } else {
            str8 = str5;
            str9 = str;
        }
        if (!this.f355d.m120b()) {
            C0073w.m524d("no remote but still store!", new Object[0]);
        }
        if (this.f355d.m121c().f146d || !this.f355d.m120b()) {
            String str11 = null;
            String str12 = null;
            if (strArr != null) {
                Map hashMap = new HashMap();
                for (String split : strArr) {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    } else {
                        C0073w.m524d("bad extraMsg %s", split);
                    }
                }
                str12 = (String) hashMap.get("ExceptionThreadName");
                str11 = (String) hashMap.get("ExceptionProcessName");
            } else {
                C0073w.m523c("not found extraMsg", new Object[0]);
            }
            if (str11 == null || str11.length() == 0) {
                str11 = this.f354c.f117d;
            } else {
                C0073w.m523c("crash process name change to %s", str11);
            }
            Thread currentThread;
            if (str12 != null && str12.length() != 0) {
                C0073w.m523c("crash thread name change to %s", str12);
                for (Thread currentThread2 : Thread.getAllStackTraces().keySet()) {
                    if (currentThread2.getName().equals(str12)) {
                        str12 = str12 + "(" + currentThread2.getId() + ")";
                        break;
                    }
                }
            }
            currentThread2 = Thread.currentThread();
            str12 = currentThread2.getName() + "(" + currentThread2.getId() + ")";
            CrashDetailBean packageCrashDatas = packageCrashDatas(str11, str12, j3, str9, str2, a, str8, str10, str4, str7, null, null, true);
            if (packageCrashDatas == null) {
                C0073w.m525e("pkg crash datas fail!", new Object[0]);
                return;
            }
            C0032b.m156a("NATIVE_CRASH", C0048a.m303n(), this.f354c.f117d, Thread.currentThread(), str9 + "\n" + str2 + "\n" + a, packageCrashDatas);
            if (!this.f353b.m168a(packageCrashDatas, i3)) {
                this.f353b.m165a(packageCrashDatas, 5000, true);
            }
            C0047b.m227b(this.f356e);
            return;
        }
        C0073w.m525e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
        C0032b.m156a("NATIVE_CRASH", C0048a.m303n(), this.f354c.f117d, Thread.currentThread(), str9 + "\n" + str2 + "\n" + a, null);
        if (str4 != null) {
            File file = new File(str4);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        }
    }
}
