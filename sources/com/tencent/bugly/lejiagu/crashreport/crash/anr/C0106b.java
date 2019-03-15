package com.tencent.bugly.lejiagu.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.crashreport.crash.C0108b;
import com.tencent.bugly.lejiagu.crashreport.crash.C0111c;
import com.tencent.bugly.lejiagu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.lejiagu.crashreport.crash.anr.TraceFileHelper.C0102a;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.C0151v;
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
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.anr.b */
public final class C0106b {
    /* renamed from: a */
    private AtomicInteger f851a = new AtomicInteger(0);
    /* renamed from: b */
    private long f852b = -1;
    /* renamed from: c */
    private final Context f853c;
    /* renamed from: d */
    private final C0092a f854d;
    /* renamed from: e */
    private final C0147t f855e;
    /* renamed from: f */
    private final C0095a f856f;
    /* renamed from: g */
    private final String f857g;
    /* renamed from: h */
    private final C0108b f858h;
    /* renamed from: i */
    private FileObserver f859i;
    /* renamed from: j */
    private boolean f860j = true;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.anr.b$1 */
    class C01041 extends FileObserver {
        /* renamed from: a */
        private /* synthetic */ C0106b f849a;

        C01041(C0106b c0106b, String str, int i) {
            this.f849a = c0106b;
            super(str, 8);
        }

        public final void onEvent(int i, String str) {
            if (str != null) {
                String str2 = "/data/anr/" + str;
                if (str2.contains("trace")) {
                    this.f849a.m673a(str2);
                    return;
                }
                C0148u.m1040d("not anr file %s", str2);
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.anr.b$2 */
    class C01052 implements Runnable {
        /* renamed from: a */
        private /* synthetic */ C0106b f850a;

        C01052(C0106b c0106b) {
            this.f850a = c0106b;
        }

        public final void run() {
            this.f850a.m676b();
        }
    }

    public C0106b(Context context, C0095a c0095a, C0092a c0092a, C0147t c0147t, C0108b c0108b) {
        Context context2;
        if (context == null) {
            context2 = context;
        } else {
            context2 = context.getApplicationContext();
            if (context2 == null) {
                context2 = context;
            }
        }
        this.f853c = context2;
        this.f857g = context.getDir("bugly", 0).getAbsolutePath();
        this.f854d = c0092a;
        this.f855e = c0147t;
        this.f856f = c0095a;
        this.f858h = c0108b;
    }

    /* renamed from: a */
    private static ProcessErrorStateInfo m662a(Context context, long j) {
        long j2 = 10000 < 0 ? 0 : 10000;
        C0148u.m1039c("to find!", new Object[0]);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long j3 = j2 / 500;
        int i = 0;
        while (true) {
            C0148u.m1039c("waiting!", new Object[0]);
            List<ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        C0148u.m1039c("found!", new Object[0]);
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
                C0148u.m1039c("end!", new Object[0]);
                return null;
            }
            i = i2;
        }
    }

    /* renamed from: a */
    private CrashDetailBean m663a(C0103a c0103a) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f783B = C0124a.m832i();
            crashDetailBean.f784C = C0124a.m830g();
            crashDetailBean.f785D = C0124a.m834k();
            crashDetailBean.f786E = this.f854d.m627o();
            crashDetailBean.f787F = this.f854d.m626n();
            crashDetailBean.f788G = this.f854d.m628p();
            crashDetailBean.f824w = C0124a.m792a(this.f853c, C0111c.f879d, null);
            crashDetailBean.f825x = C0151v.m1054a(true);
            crashDetailBean.f803b = 3;
            crashDetailBean.f806e = this.f854d.m618g();
            crashDetailBean.f807f = this.f854d.f729i;
            crashDetailBean.f808g = this.f854d.m632t();
            crashDetailBean.f814m = this.f854d.m616f();
            crashDetailBean.f815n = "ANR_EXCEPTION";
            crashDetailBean.f816o = c0103a.f847f;
            crashDetailBean.f818q = c0103a.f848g;
            crashDetailBean.f795N = new HashMap();
            crashDetailBean.f795N.put("BUGLY_CR_01", c0103a.f846e);
            int indexOf = crashDetailBean.f818q.indexOf("\n");
            crashDetailBean.f817p = indexOf > 0 ? crashDetailBean.f818q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f819r = c0103a.f844c;
            crashDetailBean.f822u = C0124a.m815b(crashDetailBean.f818q.getBytes());
            crashDetailBean.f826y = c0103a.f843b;
            crashDetailBean.f827z = this.f854d.f724d;
            crashDetailBean.f782A = "main";
            crashDetailBean.f789H = this.f854d.m634v();
            crashDetailBean.f809h = this.f854d.m631s();
            crashDetailBean.f810i = this.f854d.m603D();
            crashDetailBean.f823v = c0103a.f845d;
            crashDetailBean.f792K = this.f854d.f732l;
            crashDetailBean.f793L = this.f854d.f721a;
            crashDetailBean.f794M = this.f854d.f734n;
            crashDetailBean.f796O = this.f854d.m600A();
            crashDetailBean.f797P = this.f854d.m601B();
            crashDetailBean.f798Q = this.f854d.m635w();
            crashDetailBean.f799R = this.f854d.m638z();
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    private static boolean m665a(String str, String str2, String str3) {
        Throwable e;
        C0102a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.f841d == null || readTargetDumpInfo.f841d.size() <= 0) {
            C0148u.m1041e("not found trace dump for %s", str3);
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
                BufferedWriter bufferedWriter = null;
                BufferedWriter bufferedWriter2;
                try {
                    bufferedWriter2 = new BufferedWriter(new FileWriter(file, false));
                    try {
                        String[] strArr = (String[]) readTargetDumpInfo.f841d.get("main");
                        if (strArr != null && strArr.length >= 3) {
                            String str4 = strArr[0];
                            bufferedWriter2.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + strArr[1] + "\n\n");
                            bufferedWriter2.flush();
                        }
                        for (Entry entry : readTargetDumpInfo.f841d.entrySet()) {
                            if (!(((String) entry.getKey()).equals("main") || entry.getValue() == null || ((String[]) entry.getValue()).length < 3)) {
                                String str5 = ((String[]) entry.getValue())[0];
                                bufferedWriter2.write("\"" + ((String) entry.getKey()) + "\" tid=" + ((String[]) entry.getValue())[2] + " :\n" + str5 + "\n" + ((String[]) entry.getValue())[1] + "\n\n");
                                bufferedWriter2.flush();
                            }
                        }
                        try {
                            bufferedWriter2.close();
                        } catch (Throwable e2) {
                            if (!C0148u.m1036a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e3) {
                        e2 = e3;
                        bufferedWriter = bufferedWriter2;
                        try {
                            if (!C0148u.m1036a(e2)) {
                                e2.printStackTrace();
                            }
                            C0148u.m1041e("dump trace fail %s", e2.getClass().getName() + ":" + e2.getMessage());
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Throwable e22) {
                                    if (!C0148u.m1036a(e22)) {
                                        e22.printStackTrace();
                                    }
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            e22 = th;
                            bufferedWriter2 = bufferedWriter;
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (Throwable e4) {
                                    if (!C0148u.m1036a(e4)) {
                                        e4.printStackTrace();
                                    }
                                }
                            }
                            throw e22;
                        }
                    } catch (Throwable th2) {
                        e22 = th2;
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                        throw e22;
                    }
                } catch (IOException e5) {
                    e22 = e5;
                    if (C0148u.m1036a(e22)) {
                        e22.printStackTrace();
                    }
                    C0148u.m1041e("dump trace fail %s", e22.getClass().getName() + ":" + e22.getMessage());
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    return false;
                } catch (Throwable th3) {
                    e22 = th3;
                    bufferedWriter2 = null;
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                    throw e22;
                }
            }
            C0148u.m1041e("backup file create fail %s", str2);
            return false;
        } catch (Throwable e222) {
            if (!C0148u.m1036a(e222)) {
                e222.printStackTrace();
            }
            C0148u.m1041e("backup file create error! %s  %s", e222.getClass().getName() + ":" + e222.getMessage(), str2);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m675a() {
        return this.f851a.get() != 0;
    }

    /* renamed from: a */
    private boolean m664a(Context context, String str, ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        int i;
        this.f856f.m648c();
        if (!this.f856f.m647b()) {
            C0148u.m1041e("waiting for remote sync", new Object[0]);
            i = 0;
            while (!this.f856f.m647b()) {
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
        C0103a c0103a = new C0103a();
        c0103a.f844c = j;
        c0103a.f845d = file.getAbsolutePath();
        c0103a.f842a = processErrorStateInfo.processName;
        c0103a.f847f = processErrorStateInfo.shortMsg;
        c0103a.f846e = processErrorStateInfo.longMsg;
        c0103a.f843b = map;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (str2.startsWith("main(")) {
                    c0103a.f848g = (String) map.get(str2);
                }
            }
        }
        String str3 = "anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(c0103a.f844c);
        objArr[1] = c0103a.f845d;
        objArr[2] = c0103a.f842a;
        objArr[3] = c0103a.f847f;
        objArr[4] = c0103a.f846e;
        if (c0103a.f843b == null) {
            i = 0;
        } else {
            i = c0103a.f843b.size();
        }
        objArr[5] = Integer.valueOf(i);
        C0148u.m1039c(str3, objArr);
        if (!this.f856f.m647b()) {
            C0148u.m1041e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
            C0108b.m683a("ANR", C0124a.m837n(), c0103a.f842a, null, c0103a.f846e, null);
            return false;
        } else if (this.f856f.m648c().f756g) {
            C0148u.m1035a("found visiable anr , start to upload!", new Object[0]);
            CrashDetailBean a = m663a(c0103a);
            if (a == null) {
                C0148u.m1041e("pack anr fail!", new Object[0]);
                return false;
            }
            C0111c.m698a().m704a(a);
            if (a.f802a >= 0) {
                C0148u.m1035a("backup anr record success!", new Object[0]);
            } else {
                C0148u.m1040d("backup anr record fail!", new Object[0]);
            }
            if (str != null && new File(str).exists()) {
                this.f851a.set(3);
                if (C0106b.m665a(str, c0103a.f845d, c0103a.f842a)) {
                    C0148u.m1035a("backup trace success", new Object[0]);
                }
            }
            C0108b.m683a("ANR", C0124a.m837n(), c0103a.f842a, null, c0103a.f846e, a);
            if (!this.f858h.m694a(a)) {
                this.f858h.m692a(a, 5000, true);
            }
            this.f858h.m696b(a);
            return true;
        } else {
            C0148u.m1040d("ANR Report is closed!", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m673a(java.lang.String r11) {
        /*
        r10 = this;
        r8 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = -1;
        r7 = 0;
        monitor-enter(r10);
        r2 = r10.f851a;	 Catch:{ all -> 0x0063 }
        r2 = r2.get();	 Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x0018;
    L_0x000e:
        r0 = "trace started return ";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0063 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1039c(r0, r1);	 Catch:{ all -> 0x0063 }
        monitor-exit(r10);	 Catch:{ all -> 0x0063 }
    L_0x0017:
        return;
    L_0x0018:
        r2 = r10.f851a;	 Catch:{ all -> 0x0063 }
        r3 = 1;
        r2.set(r3);	 Catch:{ all -> 0x0063 }
        monitor-exit(r10);	 Catch:{ all -> 0x0063 }
        r2 = "read trace first dump for create time!";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1039c(r2, r3);	 Catch:{ Throwable -> 0x00e9 }
        r2 = 0;
        r2 = com.tencent.bugly.lejiagu.crashreport.crash.anr.TraceFileHelper.readFirstDumpInfo(r11, r2);	 Catch:{ Throwable -> 0x00e9 }
        if (r2 == 0) goto L_0x0114;
    L_0x002e:
        r4 = r2.f840c;	 Catch:{ Throwable -> 0x00e9 }
    L_0x0030:
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x0040;
    L_0x0034:
        r0 = "trace dump fail could not get time!";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00e9 }
    L_0x0040:
        r0 = r10.f852b;	 Catch:{ Throwable -> 0x00e9 }
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
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f851a;
        r0.set(r7);
        goto L_0x0017;
    L_0x0063:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0066:
        r10.f852b = r4;	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f851a;	 Catch:{ Throwable -> 0x00e9 }
        r1 = 1;
        r0.set(r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = com.tencent.bugly.lejiagu.crashreport.crash.C0111c.f880e;	 Catch:{ Throwable -> 0x008b }
        r1 = 0;
        r6 = com.tencent.bugly.lejiagu.proguard.C0124a.m798a(r0, r1);	 Catch:{ Throwable -> 0x008b }
        if (r6 == 0) goto L_0x007d;
    L_0x0077:
        r0 = r6.size();	 Catch:{ Throwable -> 0x00e9 }
        if (r0 > 0) goto L_0x009e;
    L_0x007d:
        r0 = "can't get all thread skip this anr";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f851a;
        r0.set(r7);
        goto L_0x0017;
    L_0x008b:
        r0 = move-exception;
        com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r0);	 Catch:{ Throwable -> 0x00e9 }
        r0 = "get all thread stack fail!";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1041e(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f851a;
        r0.set(r7);
        goto L_0x0017;
    L_0x009e:
        r0 = r10.f853c;	 Catch:{ Throwable -> 0x00e9 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3 = com.tencent.bugly.lejiagu.crashreport.crash.anr.C0106b.m662a(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        if (r3 != 0) goto L_0x00b7;
    L_0x00a8:
        r0 = "proc state is unvisiable!";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1039c(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f851a;
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
        com.tencent.bugly.lejiagu.proguard.C0148u.m1039c(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f851a;
        r0.set(r7);
        goto L_0x0017;
    L_0x00d3:
        r0 = "found visiable anr , start to process!";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e9 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1035a(r0, r1);	 Catch:{ Throwable -> 0x00e9 }
        r1 = r10.f853c;	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10;
        r2 = r11;
        r0.m664a(r1, r2, r3, r4, r6);	 Catch:{ Throwable -> 0x00e9 }
        r0 = r10.f851a;
        r0.set(r7);
        goto L_0x0017;
    L_0x00e9:
        r0 = move-exception;
        r1 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r0);	 Catch:{ all -> 0x010d }
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
        com.tencent.bugly.lejiagu.proguard.C0148u.m1041e(r1, r2);	 Catch:{ all -> 0x010d }
        r0 = r10.f851a;
        r0.set(r7);
        goto L_0x0017;
    L_0x010d:
        r0 = move-exception;
        r1 = r10.f851a;
        r1.set(r7);
        throw r0;
    L_0x0114:
        r4 = r0;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.lejiagu.crashreport.crash.anr.b.a(java.lang.String):void");
    }

    /* renamed from: c */
    private synchronized void m667c() {
        if (m670e()) {
            C0148u.m1040d("start when started!", new Object[0]);
        } else {
            this.f859i = new C01041(this, "/data/anr/", 8);
            try {
                this.f859i.startWatching();
                C0148u.m1035a("start anr monitor!", new Object[0]);
                this.f855e.m1032b(new C01052(this));
            } catch (Throwable th) {
                this.f859i = null;
                C0148u.m1040d("start anr monitor failed!", new Object[0]);
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: d */
    private synchronized void m669d() {
        if (m670e()) {
            try {
                this.f859i.stopWatching();
                this.f859i = null;
                C0148u.m1040d("close anr monitor!", new Object[0]);
            } catch (Throwable th) {
                C0148u.m1040d("stop anr monitor failed!", new Object[0]);
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        } else {
            C0148u.m1040d("close when closed!", new Object[0]);
        }
    }

    /* renamed from: e */
    private synchronized boolean m670e() {
        return this.f859i != null;
    }

    /* renamed from: b */
    private synchronized void m666b(boolean z) {
        if (z) {
            m667c();
        } else {
            m669d();
        }
    }

    /* renamed from: f */
    private synchronized boolean m671f() {
        return this.f860j;
    }

    /* renamed from: c */
    private synchronized void m668c(boolean z) {
        if (this.f860j != z) {
            C0148u.m1035a("user change anr %b", Boolean.valueOf(z));
            this.f860j = z;
        }
    }

    /* renamed from: a */
    public final void m674a(boolean z) {
        m668c(z);
        boolean z2 = C0095a.m641a().m648c().f756g && m671f();
        if (z2 != m670e()) {
            C0148u.m1035a("anr changed to %b", Boolean.valueOf(z2));
            m666b(z2);
        }
    }

    /* renamed from: b */
    protected final void m676b() {
        long o = C0124a.m838o() - C0111c.f881f;
        File file = new File(this.f857g);
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
                            C0148u.m1041e("tomb format error delete %s", name);
                        }
                        if (file2.delete()) {
                            i++;
                        }
                    }
                }
                C0148u.m1039c("clean tombs %d", Integer.valueOf(i));
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m672a(StrategyBean strategyBean) {
        boolean z = true;
        synchronized (this) {
            if (strategyBean != null) {
                if (strategyBean.f756g != m670e()) {
                    C0148u.m1040d("server anr changed to %b", Boolean.valueOf(strategyBean.f756g));
                }
            }
            if (!(strategyBean.f756g && m671f())) {
                z = false;
            }
            if (z != m670e()) {
                C0148u.m1035a("anr changed to %b", Boolean.valueOf(z));
                m666b(z);
            }
        }
    }
}
