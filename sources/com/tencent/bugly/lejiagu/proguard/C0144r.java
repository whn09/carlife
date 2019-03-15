package com.tencent.bugly.lejiagu.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.r */
public final class C0144r {
    /* renamed from: a */
    private static C0144r f1148a = null;
    /* renamed from: b */
    private final C0139m f1149b;
    /* renamed from: c */
    private final Context f1150c;
    /* renamed from: d */
    private Map<Integer, Long> f1151d = new HashMap();
    /* renamed from: e */
    private LinkedBlockingQueue<Runnable> f1152e = new LinkedBlockingQueue();
    /* renamed from: f */
    private final Object f1153f = new Object();
    /* renamed from: g */
    private String f1154g = null;
    /* renamed from: h */
    private byte[] f1155h = null;
    /* renamed from: i */
    private long f1156i = 0;
    /* renamed from: j */
    private byte[] f1157j = null;
    /* renamed from: k */
    private long f1158k = 0;
    /* renamed from: l */
    private String f1159l = null;
    /* renamed from: m */
    private long f1160m = 0;
    /* renamed from: n */
    private final Object f1161n = new Object();
    /* renamed from: o */
    private boolean f1162o = false;
    /* renamed from: p */
    private final Object f1163p = new Object();
    /* renamed from: q */
    private boolean f1164q = true;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.proguard.r$a */
    class C0143a implements Runnable {
        /* renamed from: a */
        private final Context f1144a;
        /* renamed from: b */
        private final Runnable f1145b;
        /* renamed from: c */
        private final long f1146c;
        /* renamed from: d */
        private /* synthetic */ C0144r f1147d;

        public C0143a(C0144r c0144r, Context context) {
            this(c0144r, context, null, 0);
        }

        public C0143a(C0144r c0144r, Context context, Runnable runnable, long j) {
            this.f1147d = c0144r;
            this.f1144a = context;
            this.f1145b = runnable;
            this.f1146c = j;
        }

        public final void run() {
            if (C0124a.m802a(this.f1144a, "security_info", 30000)) {
                if (!this.f1147d.m1009f()) {
                    C0148u.m1040d("[UploadManager] failed to load security info from database", new Object[0]);
                    this.f1147d.m1017a(false);
                }
                if (this.f1147d.f1159l != null) {
                    if (this.f1147d.m1022c()) {
                        C0148u.m1039c("[UploadManager] sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        if (this.f1145b != null) {
                            this.f1147d.m997a(this.f1145b, this.f1146c);
                        }
                        this.f1147d.m1003b(0);
                        C0124a.m818b(this.f1144a, "security_info");
                        synchronized (this.f1147d.f1163p) {
                            this.f1147d.f1162o = false;
                        }
                        return;
                    }
                    C0148u.m1035a("[UploadManager] session ID is expired, drop it", new Object[0]);
                    this.f1147d.m1017a(true);
                }
                byte[] a = C0124a.m804a(128);
                if (a == null || (a.length << 3) != 128) {
                    C0148u.m1040d("[UploadManager] failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                } else {
                    this.f1147d.f1157j = a;
                    C0148u.m1039c("[UploadManager] execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    if (this.f1145b != null) {
                        this.f1147d.m997a(this.f1145b, this.f1146c);
                        return;
                    } else if (!this.f1147d.m1003b(1)) {
                        C0148u.m1040d("[UploadManager] failed to execute one upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    } else {
                        return;
                    }
                }
                this.f1147d.m1017a(false);
                C0124a.m818b(this.f1144a, "security_info");
                synchronized (this.f1147d.f1163p) {
                    this.f1147d.f1162o = false;
                }
                return;
            }
            C0147t a2 = C0147t.m1027a();
            if (a2 == null) {
                C0148u.m1041e("[UploadManager] async task handler has not been initialized", new Object[0]);
                return;
            }
            C0148u.m1039c("[UploadManager] sleep %d try to lock security file again", Integer.valueOf(5000));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a2.m1033c(new C0143a(this.f1147d, this.f1147d.f1150c));
        }
    }

    private C0144r(Context context) {
        this.f1150c = context;
        this.f1149b = C0139m.m963a();
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException e) {
            C0148u.m1035a("[UploadManager] can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.f1164q = false;
        }
        if (this.f1164q) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/").append("fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
            this.f1154g = stringBuilder.toString();
        }
    }

    /* renamed from: a */
    public static synchronized C0144r m995a(Context context) {
        C0144r c0144r;
        synchronized (C0144r.class) {
            if (f1148a == null) {
                f1148a = new C0144r(context);
            }
            c0144r = f1148a;
        }
        return c0144r;
    }

    /* renamed from: a */
    public static synchronized C0144r m994a() {
        C0144r c0144r;
        synchronized (C0144r.class) {
            c0144r = f1148a;
        }
        return c0144r;
    }

    /* renamed from: a */
    public final void m1013a(int i, ak akVar, String str, C0083q c0083q) {
        m1014a(i, akVar, null, c0083q, false, 0);
    }

    /* renamed from: a */
    public final void m1011a(int i, int i2, byte[] bArr, String str, C0083q c0083q) {
        try {
            if (this.f1164q) {
                m998a(new C0145s(this.f1150c, i, i2, bArr, null, c0083q, true), false, 0);
                return;
            }
            C0147t.m1027a().m1032b(new C0145s(this.f1150c, i, i2, bArr, null, c0083q, false));
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m1014a(int i, ak akVar, String str, C0083q c0083q, boolean z, long j) {
        try {
            if (this.f1164q) {
                m998a(new C0145s(this.f1150c, i, akVar, str, c0083q, true), z, j);
                return;
            }
            Runnable c0145s = new C0145s(this.f1150c, i, akVar, str, c0083q, false);
            if (z) {
                m997a(c0145s, j);
            } else {
                C0147t.m1027a().m1032b(c0145s);
            }
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public final long m1020b() {
        long j;
        long j2 = 0;
        long o = C0124a.m838o();
        List a = this.f1149b.m981a(3);
        if (a == null || a.size() <= 0) {
            j = 0;
        } else {
            try {
                C0141o c0141o = (C0141o) a.get(0);
                if (c0141o.f1138e >= o) {
                    j2 = C0124a.m821c(c0141o.f1140g);
                    a.remove(c0141o);
                }
                j = j2;
            } catch (Throwable th) {
                j = 0;
                C0148u.m1041e("error local type %d", Integer.valueOf(3));
            }
            if (a.size() > 0) {
                C0139m c0139m = this.f1149b;
                C0139m.m968a(a);
            }
        }
        C0148u.m1039c("consume getted %d", Long.valueOf(j));
        return j;
    }

    /* renamed from: a */
    protected final synchronized void m1016a(long j) {
        C0141o c0141o = new C0141o();
        c0141o.f1135b = 3;
        c0141o.f1138e = C0124a.m838o();
        c0141o.f1136c = "";
        c0141o.f1137d = "";
        c0141o.f1140g = C0124a.m806a(j);
        C0139m c0139m = this.f1149b;
        C0139m.m973b(3);
        this.f1149b.m985a(c0141o);
        C0148u.m1039c("consume update %d", Long.valueOf(j));
    }

    /* renamed from: a */
    public final synchronized void m1012a(int i, long j) {
        if (i >= 0) {
            this.f1151d.put(Integer.valueOf(i), Long.valueOf(j));
            C0148u.m1039c("up %d %d", Integer.valueOf(i), Long.valueOf(j));
        } else {
            C0148u.m1041e("unknown up %d", Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    public final synchronized long m1010a(int i) {
        long longValue;
        if (i >= 0) {
            Long l = (Long) this.f1151d.get(Integer.valueOf(i));
            longValue = l == null ? -2 : l.longValue();
        } else {
            C0148u.m1041e("unknown up %d", Integer.valueOf(i));
            longValue = -2;
        }
        return longValue;
    }

    /* renamed from: d */
    private static boolean m1007d() {
        boolean z = false;
        C0148u.m1039c("[UploadManager] drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C0139m a = C0139m.m963a();
            if (a == null) {
                C0148u.m1040d("[UploadManager] failed to get Database", new Object[0]);
            } else {
                z = a.m983a(555, "security_info", null, true);
            }
        } catch (Throwable th) {
            C0148u.m1036a(th);
        }
        return z;
    }

    /* renamed from: e */
    private boolean m1008e() {
        C0148u.m1039c("[UploadManager] record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C0139m a = C0139m.m963a();
            if (a == null) {
                C0148u.m1040d("[UploadManager] failed to get Database", new Object[0]);
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f1157j != null) {
                stringBuilder.append(Base64.encodeToString(this.f1157j, 0));
                stringBuilder.append("#");
                if (this.f1160m != 0) {
                    stringBuilder.append(Long.toString(this.f1158k));
                } else {
                    stringBuilder.append("null");
                }
                stringBuilder.append("#");
                if (this.f1159l != null) {
                    stringBuilder.append(this.f1159l);
                } else {
                    stringBuilder.append("null");
                }
                stringBuilder.append("#");
                if (this.f1160m != 0) {
                    stringBuilder.append(Long.toString(this.f1160m));
                } else {
                    stringBuilder.append("null");
                }
                a.m984a(555, "security_info", stringBuilder.toString().getBytes(), null, true);
                return true;
            }
            C0148u.m1039c("[UploadManager] AES key is null, will not record", new Object[0]);
            return false;
        } catch (Throwable th) {
            C0148u.m1036a(th);
            C0144r.m1007d();
            return false;
        }
    }

    /* renamed from: f */
    private boolean m1009f() {
        C0148u.m1039c("[UploadManager] load security info from dataBase (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        int i;
        try {
            C0139m a = C0139m.m963a();
            if (a == null) {
                C0148u.m1040d("[UploadManager] failed to get Database", new Object[0]);
                return false;
            }
            Map a2 = a.m982a(555, null, true);
            if (a2 != null && a2.containsKey("security_info")) {
                String[] split = new String((byte[]) a2.get("security_info")).split("#");
                if (split.length == 4) {
                    if (split[0].isEmpty() || split[0].equals("null")) {
                        i = 0;
                    } else {
                        this.f1157j = Base64.decode(split[0], 0);
                        i = 0;
                    }
                    if (i == 0) {
                        if (!(split[1].isEmpty() || split[1].equals("null"))) {
                            try {
                                this.f1158k = Long.parseLong(split[1]);
                            } catch (Throwable th) {
                                C0148u.m1036a(th);
                                i = 1;
                            }
                        }
                    }
                    if (i == 0) {
                        if (!(split[2].isEmpty() || split[2].equals("null"))) {
                            this.f1159l = split[2];
                        }
                    }
                    if (!(i != 0 || split[3].isEmpty() || split[3].equals("null"))) {
                        try {
                            this.f1160m = Long.parseLong(split[3]);
                        } catch (Throwable th2) {
                            C0148u.m1036a(th2);
                            i = 1;
                        }
                    }
                } else {
                    C0148u.m1035a("securityInfo = %s, strings.length = %d", r3, Integer.valueOf(split.length));
                    i = 1;
                }
                if (i != 0) {
                    C0144r.m1007d();
                }
            }
            return true;
        } catch (Throwable th22) {
            C0148u.m1036a(th22);
            return false;
        }
    }

    /* renamed from: c */
    protected final boolean m1022c() {
        if (this.f1159l == null || this.f1160m == 0) {
            return false;
        }
        if (this.f1160m >= System.currentTimeMillis() + this.f1156i) {
            return true;
        }
        C0148u.m1039c("[UploadManager] session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(this.f1160m), new Date(this.f1160m).toString(), Long.valueOf(System.currentTimeMillis() + this.f1156i), new Date(System.currentTimeMillis() + this.f1156i).toString());
        return false;
    }

    /* renamed from: a */
    protected final void m1017a(boolean z) {
        synchronized (this.f1161n) {
            C0148u.m1039c("[UploadManager] clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.f1157j = null;
            this.f1159l = null;
            this.f1160m = 0;
        }
        if (z) {
            C0144r.m1007d();
        }
    }

    /* renamed from: b */
    private boolean m1003b(int i) {
        if (i < 0) {
            C0148u.m1035a("[UploadManager] number of task to execute should >= 0", new Object[0]);
            return false;
        }
        synchronized (this.f1153f) {
            if (this.f1152e.isEmpty()) {
                return true;
            }
            C0148u.m1039c("[UploadManager] execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(this.f1152e.size()), Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()));
            if (i == 0 || i > this.f1152e.size()) {
                i = this.f1152e.size();
            }
            C0147t a = C0147t.m1027a();
            if (a == null) {
                C0148u.m1040d("[UploadManager] async task handler has not been initialized", new Object[0]);
                return false;
            }
            int i2 = 0;
            while (i2 < i) {
                try {
                    Runnable runnable = (Runnable) this.f1152e.poll();
                    if (runnable != null) {
                        a.m1033c(runnable);
                    } else {
                        C0148u.m1040d("[UploadManager] upload task poll from queue is null", new Object[0]);
                    }
                    i2++;
                } catch (Throwable th) {
                    C0148u.m1041e("[UploadManager] failed to execute upload task with message: %s", th.getMessage());
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private boolean m1001a(Runnable runnable) {
        if (runnable == null) {
            C0148u.m1040d("[UploadManager] upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C0148u.m1039c("[UploadManager] add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f1153f) {
                this.f1152e.put(runnable);
            }
            return true;
        } catch (Throwable th) {
            C0148u.m1041e("[UploadManager] failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private void m997a(Runnable runnable, long j) {
        if (runnable == null) {
            C0148u.m1040d("[UploadManager] upload task should not be null", new Object[0]);
            return;
        }
        C0148u.m1039c("[UploadManager] execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread thread = new Thread(runnable);
        thread.setName("BuglySyncUploadThread");
        thread.start();
        try {
            thread.join(j);
        } catch (Throwable th) {
            C0148u.m1041e("[UploadManager] failed to execute upload synchronized task with message: %s. Add it to queue", th.getMessage());
            m1001a(runnable);
        }
    }

    /* renamed from: a */
    private void m998a(Runnable runnable, boolean z, long j) {
        if (runnable == null) {
            C0148u.m1040d("[UploadManager] upload task should not be null", new Object[0]);
        }
        C0147t a = C0147t.m1027a();
        if (a == null) {
            C0148u.m1040d("[UploadManager] async task handler has not been initialized", new Object[0]);
        }
        C0148u.m1039c("[UploadManager] add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.f1159l != null) {
            if (m1022c()) {
                C0148u.m1039c("[UploadManager] sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z) {
                    m997a(runnable, j);
                } else if (a == null) {
                    m1001a(runnable);
                } else {
                    a.m1033c(runnable);
                }
                m1003b(0);
                return;
            }
            C0148u.m1035a("[UploadManager] session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            m1017a(false);
        }
        synchronized (this.f1163p) {
            if (this.f1162o) {
                m1001a(runnable);
            } else {
                this.f1162o = true;
                C0148u.m1039c("[UploadManager] try to request session ID now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z) {
                    m997a(new C0143a(this, this.f1150c, runnable, j), 0);
                } else {
                    m1001a(runnable);
                    a.m1033c(new C0143a(this, this.f1150c));
                }
            }
        }
    }

    /* renamed from: a */
    public final void m1015a(int i, al alVar) {
        if (this.f1164q) {
            if (i == 2) {
                C0148u.m1039c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                m1017a(true);
            } else if (!this.f1162o) {
                return;
            } else {
                if (alVar != null) {
                    boolean z;
                    C0148u.m1039c("[UploadManager] record security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    try {
                        Map map = alVar.f1050h;
                        if (map != null && map.containsKey("S1") && map.containsKey("S2")) {
                            this.f1156i = alVar.f1047e - System.currentTimeMillis();
                            C0148u.m1039c("[UploadManager] time lag of server is: %d", Long.valueOf(this.f1156i));
                            this.f1159l = (String) map.get("S1");
                            C0148u.m1039c("[UploadManager] session ID from server is: %s", this.f1159l);
                            if (this.f1159l.length() > 0) {
                                this.f1160m = Long.parseLong((String) map.get("S2"));
                                C0148u.m1039c("[UploadManager] session expired time from server is: %d(%s)", Long.valueOf(this.f1160m), new Date(this.f1160m).toString());
                                if (this.f1160m < 1000) {
                                    C0148u.m1040d("[UploadManager] session expired time from server is less than 1 second, will set to default value", new Object[0]);
                                    this.f1160m = 259200000;
                                }
                                m1003b(0);
                                if (m1008e()) {
                                    z = false;
                                } else {
                                    C0148u.m1039c("[UploadManager] failed to record database", new Object[0]);
                                    z = true;
                                }
                                if (z) {
                                    m1017a(false);
                                }
                            } else {
                                C0148u.m1039c("[UploadManager] session ID from server is invalid, try next time", new Object[0]);
                            }
                        }
                        z = true;
                    } catch (NumberFormatException e) {
                        C0148u.m1040d("[UploadManager] session expired time is invalid, will set to default value", new Object[0]);
                        this.f1160m = 259200000;
                    } catch (Throwable th) {
                        C0148u.m1036a(th);
                        z = true;
                    }
                    if (z) {
                        m1017a(false);
                    }
                } else {
                    C0148u.m1039c("[UploadManager] fail to init security context and clear local info (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    m1017a(false);
                }
            }
            synchronized (this.f1163p) {
                if (this.f1162o) {
                    this.f1162o = false;
                    C0124a.m818b(this.f1150c, "security_info");
                }
            }
        }
    }

    /* renamed from: a */
    public final byte[] m1019a(byte[] bArr) {
        if (this.f1157j != null && (this.f1157j.length << 3) == 128) {
            return C0124a.m805a(1, bArr, this.f1157j);
        }
        C0148u.m1040d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* renamed from: b */
    public final byte[] m1021b(byte[] bArr) {
        if (this.f1157j != null && (this.f1157j.length << 3) == 128) {
            return C0124a.m805a(2, bArr, this.f1157j);
        }
        C0148u.m1040d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* renamed from: a */
    public final boolean m1018a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        C0148u.m1039c("[UploadManager] integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.f1159l != null) {
            map.put("secureSessionId", this.f1159l);
            return true;
        } else if (this.f1157j == null || (this.f1157j.length << 3) != 128) {
            C0148u.m1040d("[UploadManager] AES key is invalid", new Object[0]);
            return false;
        } else {
            if (this.f1155h == null) {
                this.f1155h = Base64.decode(this.f1154g, 0);
                if (this.f1155h == null) {
                    C0148u.m1040d("[UploadManager] failed to decode RSA public key", new Object[0]);
                    return false;
                }
            }
            byte[] b = C0124a.m819b(1, this.f1157j, this.f1155h);
            if (b == null) {
                C0148u.m1040d("[UploadManager] failed to encrypt AES key", new Object[0]);
                return false;
            }
            String encodeToString = Base64.encodeToString(b, 0);
            if (encodeToString == null) {
                C0148u.m1040d("[UploadManager] failed to encode AES key", new Object[0]);
                return false;
            }
            map.put("raKey", encodeToString);
            return true;
        }
    }
}
