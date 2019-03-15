package com.tencent.bugly.legu.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.crashreport.crash.C0032b;
import com.tencent.bugly.legu.crashreport.crash.C0035c;
import com.tencent.bugly.legu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.legu.crashreport.crash.anr.TraceFileHelper.C0026a;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.C0076x;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.crash.anr.b */
public final class C0030b {
    /* renamed from: a */
    private AtomicInteger f244a = new AtomicInteger(0);
    /* renamed from: b */
    private long f245b = -1;
    /* renamed from: c */
    private final Context f246c;
    /* renamed from: d */
    private final C0016a f247d;
    /* renamed from: e */
    private final C0072v f248e;
    /* renamed from: f */
    private final C0019a f249f;
    /* renamed from: g */
    private final String f250g;
    /* renamed from: h */
    private final C0032b f251h;
    /* renamed from: i */
    private FileObserver f252i;
    /* renamed from: j */
    private boolean f253j = true;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.anr.b$1 */
    class C00281 extends FileObserver {
        /* renamed from: a */
        private /* synthetic */ C0030b f242a;

        C00281(C0030b c0030b, String str, int i) {
            this.f242a = c0030b;
            super(str, 8);
        }

        public final void onEvent(int i, String str) {
            if (str != null) {
                String str2 = "/data/anr/" + str;
                if (str2.contains("trace")) {
                    this.f242a.m146a(str2);
                    return;
                }
                C0073w.m524d("not anr file %s", str2);
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.anr.b$2 */
    class C00292 implements Runnable {
        /* renamed from: a */
        private /* synthetic */ C0030b f243a;

        C00292(C0030b c0030b) {
            this.f243a = c0030b;
        }

        public final void run() {
            this.f243a.m149b();
        }
    }

    public C0030b(Context context, C0019a c0019a, C0016a c0016a, C0072v c0072v, C0032b c0032b) {
        Context context2;
        if (context == null) {
            context2 = context;
        } else {
            context2 = context.getApplicationContext();
            if (context2 == null) {
                context2 = context;
            }
        }
        this.f246c = context2;
        this.f250g = context.getDir("bugly", 0).getAbsolutePath();
        this.f247d = c0016a;
        this.f248e = c0072v;
        this.f249f = c0019a;
        this.f251h = c0032b;
    }

    /* renamed from: a */
    private static ProcessErrorStateInfo m135a(Context context, long j) {
        long j2 = 10000 < 0 ? 0 : 10000;
        C0073w.m523c("to find!", new Object[0]);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long j3 = j2 / 500;
        int i = 0;
        while (true) {
            C0073w.m523c("waiting!", new Object[0]);
            List<ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        C0073w.m523c("found!", new Object[0]);
                        return processErrorStateInfo;
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i2 = i + 1;
            if (((long) i) >= j3) {
                C0073w.m523c("end!", new Object[0]);
                return null;
            }
            i = i2;
        }
    }

    /* renamed from: a */
    private CrashDetailBean m136a(C0027a c0027a) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f176B = C0048a.m298i();
            crashDetailBean.f177C = C0048a.m296g();
            crashDetailBean.f178D = C0048a.m300k();
            crashDetailBean.f179E = this.f247d.m100o();
            crashDetailBean.f180F = this.f247d.m99n();
            crashDetailBean.f181G = this.f247d.m101p();
            crashDetailBean.f217w = C0048a.m258a(this.f246c, C0035c.f272d, null);
            crashDetailBean.f218x = C0076x.m538a(true);
            crashDetailBean.f196b = 3;
            crashDetailBean.f199e = this.f247d.m91g();
            crashDetailBean.f200f = this.f247d.f122i;
            crashDetailBean.f201g = this.f247d.m105t();
            crashDetailBean.f207m = this.f247d.m89f();
            crashDetailBean.f208n = "ANR_EXCEPTION";
            crashDetailBean.f209o = c0027a.f240f;
            crashDetailBean.f211q = c0027a.f241g;
            crashDetailBean.f188N = new HashMap();
            crashDetailBean.f188N.put("BUGLY_CR_01", c0027a.f239e);
            int indexOf = crashDetailBean.f211q.indexOf("\n");
            crashDetailBean.f210p = indexOf > 0 ? crashDetailBean.f211q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f212r = c0027a.f237c;
            crashDetailBean.f215u = C0048a.m281b(crashDetailBean.f211q.getBytes());
            crashDetailBean.f219y = c0027a.f236b;
            crashDetailBean.f220z = this.f247d.f117d;
            crashDetailBean.f175A = "main(1)";
            crashDetailBean.f182H = this.f247d.m107v();
            crashDetailBean.f202h = this.f247d.m104s();
            crashDetailBean.f203i = this.f247d.m76E();
            crashDetailBean.f216v = c0027a.f238d;
            crashDetailBean.f185K = this.f247d.f125l;
            crashDetailBean.f186L = this.f247d.f114a;
            crashDetailBean.f187M = this.f247d.f127n;
            crashDetailBean.f189O = this.f247d.m73B();
            crashDetailBean.f190P = this.f247d.m74C();
            crashDetailBean.f191Q = this.f247d.m108w();
            crashDetailBean.f192R = this.f247d.m72A();
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    private static boolean m138a(String str, String str2, String str3) {
        BufferedWriter bufferedWriter;
        Throwable e;
        C0026a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.f234d == null || readTargetDumpInfo.f234d.size() <= 0) {
            C0073w.m525e("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (file.exists() && file.canWrite()) {
                BufferedWriter bufferedWriter2 = null;
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                    try {
                        String[] strArr = (String[]) readTargetDumpInfo.f234d.get("main");
                        if (strArr != null && strArr.length >= 3) {
                            String str4 = strArr[0];
                            bufferedWriter.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + strArr[1] + "\n\n");
                            bufferedWriter.flush();
                        }
                        for (Entry entry : readTargetDumpInfo.f234d.entrySet()) {
                            if (!(((String) entry.getKey()).equals("main") || entry.getValue() == null || ((String[]) entry.getValue()).length < 3)) {
                                String str5 = ((String[]) entry.getValue())[0];
                                bufferedWriter.write("\"" + ((String) entry.getKey()) + "\" tid=" + ((String[]) entry.getValue())[2] + " :\n" + str5 + "\n" + ((String[]) entry.getValue())[1] + "\n\n");
                                bufferedWriter.flush();
                            }
                        }
                        try {
                            bufferedWriter.close();
                        } catch (Throwable e2) {
                            if (!C0073w.m520a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e3) {
                        e2 = e3;
                        bufferedWriter2 = bufferedWriter;
                        try {
                            if (!C0073w.m520a(e2)) {
                                e2.printStackTrace();
                            }
                            C0073w.m525e("dump trace fail %s", e2.getClass().getName() + ":" + e2.getMessage());
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (Throwable e22) {
                                    if (!C0073w.m520a(e22)) {
                                        e22.printStackTrace();
                                    }
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            e22 = th;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Throwable e4) {
                                    if (!C0073w.m520a(e4)) {
                                        e4.printStackTrace();
                                    }
                                }
                            }
                            throw e22;
                        }
                    } catch (Throwable th2) {
                        e22 = th2;
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        throw e22;
                    }
                } catch (IOException e5) {
                    e22 = e5;
                    if (C0073w.m520a(e22)) {
                        e22.printStackTrace();
                    }
                    C0073w.m525e("dump trace fail %s", e22.getClass().getName() + ":" + e22.getMessage());
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    e22 = th3;
                    bufferedWriter = null;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    throw e22;
                }
            }
            C0073w.m525e("backup file create fail %s", str2);
            return false;
        } catch (Throwable e222) {
            if (!C0073w.m520a(e222)) {
                e222.printStackTrace();
            }
            C0073w.m525e("backup file create error! %s  %s", e222.getClass().getName() + ":" + e222.getMessage(), str2);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m148a() {
        return this.f244a.get() != 0;
    }

    /* renamed from: a */
    private boolean m137a(Context context, String str, ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        int i;
        this.f249f.m121c();
        if (!this.f249f.m120b()) {
            C0073w.m525e("waiting for remote sync", new Object[0]);
            i = 0;
            while (!this.f249f.m120b()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i += 500;
                if (i >= 5000) {
                    break;
                }
            }
        }
        File file = new File(context.getFilesDir(), "bugly/bugly_trace_" + j + ".txt");
        C0027a c0027a = new C0027a();
        c0027a.f237c = j;
        c0027a.f238d = file.getAbsolutePath();
        c0027a.f235a = processErrorStateInfo.processName;
        c0027a.f240f = processErrorStateInfo.shortMsg;
        c0027a.f239e = processErrorStateInfo.longMsg;
        c0027a.f236b = map;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (str2.startsWith("main(")) {
                    c0027a.f241g = (String) map.get(str2);
                }
            }
        }
        String str3 = "anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(c0027a.f237c);
        objArr[1] = c0027a.f238d;
        objArr[2] = c0027a.f235a;
        objArr[3] = c0027a.f240f;
        objArr[4] = c0027a.f239e;
        if (c0027a.f236b == null) {
            i = 0;
        } else {
            i = c0027a.f236b.size();
        }
        objArr[5] = Integer.valueOf(i);
        C0073w.m523c(str3, objArr);
        if (!this.f249f.m120b()) {
            C0073w.m525e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
            C0032b.m156a("ANR", C0048a.m303n(), c0027a.f235a, null, c0027a.f239e, null);
            return false;
        } else if (this.f249f.m121c().f149g) {
            C0073w.m519a("found visiable anr , start to upload!", new Object[0]);
            CrashDetailBean a = m136a(c0027a);
            if (a == null) {
                C0073w.m525e("pack anr fail!", new Object[0]);
                return false;
            }
            C0035c.m171a().m177a(a);
            if (a.f195a >= 0) {
                C0073w.m519a("backup anr record success!", new Object[0]);
            } else {
                C0073w.m524d("backup anr record fail!", new Object[0]);
            }
            if (str != null && new File(str).exists()) {
                this.f244a.set(3);
                if (C0030b.m138a(str, c0027a.f238d, c0027a.f235a)) {
                    C0073w.m519a("backup trace success", new Object[0]);
                }
            }
            C0032b.m156a("ANR", C0048a.m303n(), c0027a.f235a, null, c0027a.f239e, a);
            if (!this.f251h.m167a(a)) {
                this.f251h.m165a(a, 5000, true);
            }
            this.f251h.m169b(a);
            return true;
        } else {
            C0073w.m524d("ANR Report is closed!", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m146a(java.lang.String r11) {
        /*
        r10 = this;
        r8 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = -1;
        r7 = 0;
        monitor-enter(r10);
        r2 = r10.f244a;	 Catch:{ all -> 0x0063 }
        r2 = r2.get();	 Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x0018;
    L_0x000e:
        r0 = "trace started return ";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0063 }
        com.tencent.bugly.legu.proguard.C0073w.m523c(r0, r1);	 Catch:{ all -> 0x0063 }
        monitor-exit(r10);	 Catch:{ all -> 0x0063 }
    L_0x0017:
        return;
    L_0x0018:
        r2 = r10.f244a;	 Catch:{ all -> 0x0063 }
        r3 = 1;
        r2.set(r3);	 Catch:{ all -> 0x0063 }
        monitor-exit(r10);	 Catch:{ all -> 0x0063 }
        r2 = "read trace first dump for create time!";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.legu.proguard.C0073w.m523c(r2, r3);	 Catch:{ Throwable -> 0x00e9 }
        r2 = 0;
        r2 = com.tencent.bugly.legu.crashreport.crash.anr.TraceFileHelper.readFirstDumpInfo(r11, r2);	 Catch:{ Throwable -> 0x00e9 }
        if (r2 == 0) goto L_0x0114;
    L_0x002e:
        r4 = r2.f233c;	 Catch:{ Throwable -> 0x00e9 }
    L_0x0030:
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x0040;
    L_0x0034:
        r0 = "trace dump fail could not get time!";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.legu.proguard.C0073w.m524d(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00e9 }
    L_0x0040:
        r0 = r10.f245b;	 Catch:{ Throwable -> 0x00e9 }
        r0 = r4 - r0;
        r0 = java.lang.Math.abs(r0);	 Catch:{ Throwable -> 0x00e9 }
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 >= 0) goto L_0x0066;
    L_0x004c:
        r0 = "should not process ANR too Fre in %d";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        r2 = 0;
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x00e9 }
        r1[r2] = r3;	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.legu.proguard.C0073w.m524d(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f244a;
        r0.set(r7);
        goto L_0x0017;
    L_0x0063:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0066:
        r10.f245b = r4;	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f244a;	 Catch:{ Throwable -> 0x00e9 }
        r1 = 1;
        r0.set(r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = com.tencent.bugly.legu.crashreport.crash.C0035c.f273e;	 Catch:{ Throwable -> 0x008b }
        r1 = 0;
        r6 = com.tencent.bugly.legu.proguard.C0048a.m264a(r0, r1);	 Catch:{ Throwable -> 0x008b }
        if (r6 == 0) goto L_0x007d;
    L_0x0077:
        r0 = r6.size();	 Catch:{ Throwable -> 0x00e9 }
        if (r0 > 0) goto L_0x009e;
    L_0x007d:
        r0 = "can't get all thread skip this anr";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.legu.proguard.C0073w.m524d(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f244a;
        r0.set(r7);
        goto L_0x0017;
    L_0x008b:
        r0 = move-exception;
        com.tencent.bugly.legu.proguard.C0073w.m520a(r0);	 Catch:{ Throwable -> 0x00e9 }
        r0 = "get all thread stack fail!";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.legu.proguard.C0073w.m525e(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f244a;
        r0.set(r7);
        goto L_0x0017;
    L_0x009e:
        r0 = r10.f246c;	 Catch:{ Throwable -> 0x00e9 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3 = com.tencent.bugly.legu.crashreport.crash.anr.C0030b.m135a(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        if (r3 != 0) goto L_0x00b7;
    L_0x00a8:
        r0 = "proc state is unvisiable!";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.legu.proguard.C0073w.m523c(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f244a;
        r0.set(r7);
        goto L_0x0017;
    L_0x00b7:
        r0 = r3.pid;	 Catch:{ Throwable -> 0x00e9 }
        r1 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x00e9 }
        if (r0 == r1) goto L_0x00d3;
    L_0x00bf:
        r0 = "not mind proc!";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        r2 = 0;
        r3 = r3.processName;	 Catch:{ Throwable -> 0x00e9 }
        r1[r2] = r3;	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.legu.proguard.C0073w.m523c(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f244a;
        r0.set(r7);
        goto L_0x0017;
    L_0x00d3:
        r0 = "found visiable anr , start to process!";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.legu.proguard.C0073w.m519a(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r1 = r10.f246c;	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10;
        r2 = r11;
        r0.m137a(r1, r2, r3, r4, r6);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f244a;
        r0.set(r7);
        goto L_0x0017;
    L_0x00e9:
        r0 = move-exception;
        r1 = com.tencent.bugly.legu.proguard.C0073w.m520a(r0);	 Catch:{ all -> 0x010d }
        if (r1 != 0) goto L_0x00f3;
    L_0x00f0:
        r0.printStackTrace();	 Catch:{ all -> 0x010d }
    L_0x00f3:
        r1 = "handle anr error %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x010d }
        r3 = 0;
        r0 = r0.getClass();	 Catch:{ all -> 0x010d }
        r0 = r0.toString();	 Catch:{ all -> 0x010d }
        r2[r3] = r0;	 Catch:{ all -> 0x010d }
        com.tencent.bugly.legu.proguard.C0073w.m525e(r1, r2);	 Catch:{ all -> 0x010d }
        r0 = r10.f244a;
        r0.set(r7);
        goto L_0x0017;
    L_0x010d:
        r0 = move-exception;
        r1 = r10.f244a;
        r1.set(r7);
        throw r0;
    L_0x0114:
        r4 = r0;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.legu.crashreport.crash.anr.b.a(java.lang.String):void");
    }

    /* renamed from: c */
    private synchronized void m140c() {
        if (m143e()) {
            C0073w.m524d("start when started!", new Object[0]);
        } else {
            this.f252i = new C00281(this, "/data/anr/", 8);
            try {
                this.f252i.startWatching();
                C0073w.m519a("start anr monitor!", new Object[0]);
                this.f248e.m516b(new C00292(this));
            } catch (Throwable th) {
                this.f252i = null;
                C0073w.m524d("start anr monitor failed!", new Object[0]);
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: d */
    private synchronized void m142d() {
        if (m143e()) {
            try {
                this.f252i.stopWatching();
                this.f252i = null;
                C0073w.m524d("close anr monitor!", new Object[0]);
            } catch (Throwable th) {
                C0073w.m524d("stop anr monitor failed!", new Object[0]);
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        } else {
            C0073w.m524d("close when closed!", new Object[0]);
        }
    }

    /* renamed from: e */
    private synchronized boolean m143e() {
        return this.f252i != null;
    }

    /* renamed from: b */
    private synchronized void m139b(boolean z) {
        if (z) {
            m140c();
        } else {
            m142d();
        }
    }

    /* renamed from: f */
    private synchronized boolean m144f() {
        return this.f253j;
    }

    /* renamed from: c */
    private synchronized void m141c(boolean z) {
        if (this.f253j != z) {
            C0073w.m519a("user change anr %b", Boolean.valueOf(z));
            this.f253j = z;
        }
    }

    /* renamed from: a */
    public final void m147a(boolean z) {
        m141c(z);
        boolean z2 = C0019a.m114a().m121c().f149g && m144f();
        if (z2 != m143e()) {
            C0073w.m519a("anr changed to %b", Boolean.valueOf(z2));
            m139b(z2);
        }
    }

    /* renamed from: b */
    protected final void m149b() {
        long o = C0048a.m304o() - C0035c.f274f;
        File file = new File(this.f250g);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                String str = "bugly_trace_";
                String str2 = ".txt";
                int length = str.length();
                int i = 0;
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (name.startsWith(str)) {
                        try {
                            int indexOf = name.indexOf(str2);
                            if (indexOf > 0 && Long.parseLong(name.substring(length, indexOf)) >= o) {
                            }
                        } catch (Throwable th) {
                            C0073w.m525e("tomb format error delete %s", name);
                        }
                        if (file2.delete()) {
                            i++;
                        }
                    }
                }
                C0073w.m523c("clean tombs %d", Integer.valueOf(i));
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m145a(StrategyBean strategyBean) {
        boolean z = true;
        synchronized (this) {
            if (strategyBean != null) {
                if (strategyBean.f149g != m143e()) {
                    C0073w.m524d("server anr changed to %b", Boolean.valueOf(strategyBean.f149g));
                }
            }
            if (!(strategyBean.f149g && m144f())) {
                z = false;
            }
            if (z != m143e()) {
                C0073w.m519a("anr changed to %b", Boolean.valueOf(z));
                m139b(z);
            }
        }
    }
}
