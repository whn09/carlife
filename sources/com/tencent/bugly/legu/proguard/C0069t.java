package com.tencent.bugly.legu.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.t */
public final class C0069t {
    /* renamed from: a */
    private static C0069t f550a = null;
    /* renamed from: b */
    private final C0064o f551b;
    /* renamed from: c */
    private final Context f552c;
    /* renamed from: d */
    private Map<Integer, Long> f553d = new HashMap();
    /* renamed from: e */
    private LinkedBlockingQueue<Runnable> f554e = new LinkedBlockingQueue();
    /* renamed from: f */
    private final Object f555f = new Object();
    /* renamed from: g */
    private String f556g = null;
    /* renamed from: h */
    private byte[] f557h = null;
    /* renamed from: i */
    private long f558i = 0;
    /* renamed from: j */
    private byte[] f559j = null;
    /* renamed from: k */
    private long f560k = 0;
    /* renamed from: l */
    private String f561l = null;
    /* renamed from: m */
    private long f562m = 0;
    /* renamed from: n */
    private final Object f563n = new Object();
    /* renamed from: o */
    private boolean f564o = false;
    /* renamed from: p */
    private final Object f565p = new Object();
    /* renamed from: q */
    private boolean f566q = true;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.proguard.t$a */
    class C0068a implements Runnable {
        /* renamed from: a */
        private final Context f546a;
        /* renamed from: b */
        private final Runnable f547b;
        /* renamed from: c */
        private final long f548c;
        /* renamed from: d */
        private /* synthetic */ C0069t f549d;

        public C0068a(C0069t c0069t, Context context) {
            this(c0069t, context, null, 0);
        }

        public C0068a(C0069t c0069t, Context context, Runnable runnable, long j) {
            this.f549d = c0069t;
            this.f546a = context;
            this.f547b = runnable;
            this.f548c = j;
        }

        public final void run() {
            if (C0048a.m268a(this.f546a, "security_info", 30000)) {
                if (!this.f549d.m493f()) {
                    C0073w.m524d("[UploadManager] failed to load security info from database", new Object[0]);
                    this.f549d.m501a(false);
                }
                if (this.f549d.f561l != null) {
                    if (this.f549d.m506c()) {
                        C0073w.m523c("[UploadManager] sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        if (this.f547b != null) {
                            this.f549d.m481a(this.f547b, this.f548c);
                        }
                        this.f549d.m487b(0);
                        C0048a.m284b(this.f546a, "security_info");
                        synchronized (this.f549d.f565p) {
                            this.f549d.f564o = false;
                        }
                        return;
                    }
                    C0073w.m519a("[UploadManager] session ID is expired, drop it", new Object[0]);
                    this.f549d.m501a(true);
                }
                byte[] a = C0048a.m270a(128);
                if (a == null || (a.length << 3) != 128) {
                    C0073w.m524d("[UploadManager] failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                } else {
                    this.f549d.f559j = a;
                    C0073w.m523c("[UploadManager] execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    if (this.f547b != null) {
                        this.f549d.m481a(this.f547b, this.f548c);
                        return;
                    } else if (!this.f549d.m487b(1)) {
                        C0073w.m524d("[UploadManager] failed to execute one upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    } else {
                        return;
                    }
                }
                this.f549d.m501a(false);
                C0048a.m284b(this.f546a, "security_info");
                synchronized (this.f549d.f565p) {
                    this.f549d.f564o = false;
                }
                return;
            }
            C0072v a2 = C0072v.m511a();
            if (a2 == null) {
                C0073w.m525e("[UploadManager] async task handler has not been initialized", new Object[0]);
                return;
            }
            C0073w.m523c("[UploadManager] sleep %d try to lock security file again", Integer.valueOf(5000));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a2.m517c(new C0068a(this.f549d, this.f549d.f552c));
        }
    }

    private C0069t(Context context) {
        this.f552c = context;
        this.f551b = C0064o.m440a();
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException e) {
            C0073w.m519a("[UploadManager] can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.f566q = false;
        }
        if (this.f566q) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/").append("fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
            this.f556g = stringBuilder.toString();
        }
    }

    /* renamed from: a */
    public static synchronized C0069t m479a(Context context) {
        C0069t c0069t;
        synchronized (C0069t.class) {
            if (f550a == null) {
                f550a = new C0069t(context);
            }
            c0069t = f550a;
        }
        return c0069t;
    }

    /* renamed from: a */
    public static synchronized C0069t m478a() {
        C0069t c0069t;
        synchronized (C0069t.class) {
            c0069t = f550a;
        }
        return c0069t;
    }

    /* renamed from: a */
    public final void m497a(int i, am amVar, String str, C0007s c0007s) {
        m498a(i, amVar, null, c0007s, false, 0);
    }

    /* renamed from: a */
    public final void m495a(int i, int i2, byte[] bArr, String str, C0007s c0007s) {
        try {
            if (this.f566q) {
                m482a(new C0070u(this.f552c, i, i2, bArr, null, c0007s, true), false, 0);
                return;
            }
            C0072v.m511a().m516b(new C0070u(this.f552c, i, i2, bArr, null, c0007s, false));
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m498a(int i, am amVar, String str, C0007s c0007s, boolean z, long j) {
        try {
            if (this.f566q) {
                m482a(new C0070u(this.f552c, i, amVar, str, c0007s, true), z, j);
                return;
            }
            Runnable c0070u = new C0070u(this.f552c, i, amVar, str, c0007s, false);
            if (z) {
                m481a(c0070u, j);
            } else {
                C0072v.m511a().m516b(c0070u);
            }
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public final long m504b() {
        long j;
        long j2 = 0;
        long o = C0048a.m304o();
        List a = this.f551b.m462a(3);
        if (a == null || a.size() <= 0) {
            j = 0;
        } else {
            try {
                C0066q c0066q = (C0066q) a.get(0);
                if (c0066q.f540e >= o) {
                    j2 = C0048a.m287c(c0066q.f542g);
                    a.remove(c0066q);
                }
                j = j2;
            } catch (Throwable th) {
                j = 0;
                C0073w.m525e("error local type %d", Integer.valueOf(3));
            }
            if (a.size() > 0) {
                C0064o c0064o = this.f551b;
                C0064o.m445a(a);
            }
        }
        C0073w.m523c("consume getted %d", Long.valueOf(j));
        return j;
    }

    /* renamed from: a */
    protected final synchronized void m500a(long j) {
        C0066q c0066q = new C0066q();
        c0066q.f537b = 3;
        c0066q.f540e = C0048a.m304o();
        c0066q.f538c = "";
        c0066q.f539d = "";
        c0066q.f542g = C0048a.m272a(j);
        C0064o c0064o = this.f551b;
        C0064o.m451b(3);
        this.f551b.m468a(c0066q);
        C0073w.m523c("consume update %d", Long.valueOf(j));
    }

    /* renamed from: a */
    public final synchronized void m496a(int i, long j) {
        if (i >= 0) {
            this.f553d.put(Integer.valueOf(i), Long.valueOf(j));
            C0073w.m523c("up %d %d", Integer.valueOf(i), Long.valueOf(j));
        } else {
            C0073w.m525e("unknown up %d", Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    public final synchronized long m494a(int i) {
        long longValue;
        if (i >= 0) {
            Long l = (Long) this.f553d.get(Integer.valueOf(i));
            longValue = l == null ? -2 : l.longValue();
        } else {
            C0073w.m525e("unknown up %d", Integer.valueOf(i));
            longValue = -2;
        }
        return longValue;
    }

    /* renamed from: d */
    private static boolean m491d() {
        boolean z = false;
        C0073w.m523c("[UploadManager] drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C0064o a = C0064o.m440a();
            if (a == null) {
                C0073w.m524d("[UploadManager] failed to get Database", new Object[0]);
            } else {
                z = a.m465a(555, "security_info", null, true);
            }
        } catch (Throwable th) {
            C0073w.m520a(th);
        }
        return z;
    }

    /* renamed from: e */
    private boolean m492e() {
        C0073w.m523c("[UploadManager] record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C0064o a = C0064o.m440a();
            if (a == null) {
                C0073w.m524d("[UploadManager] failed to get Database", new Object[0]);
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f559j != null) {
                stringBuilder.append(Base64.encodeToString(this.f559j, 0));
                stringBuilder.append("#");
                if (this.f562m != 0) {
                    stringBuilder.append(Long.toString(this.f560k));
                } else {
                    stringBuilder.append("null");
                }
                stringBuilder.append("#");
                if (this.f561l != null) {
                    stringBuilder.append(this.f561l);
                } else {
                    stringBuilder.append("null");
                }
                stringBuilder.append("#");
                if (this.f562m != 0) {
                    stringBuilder.append(Long.toString(this.f562m));
                } else {
                    stringBuilder.append("null");
                }
                a.m466a(555, "security_info", stringBuilder.toString().getBytes(), null, true);
                return true;
            }
            C0073w.m523c("[UploadManager] AES key is null, will not record", new Object[0]);
            return false;
        } catch (Throwable th) {
            C0073w.m520a(th);
            C0069t.m491d();
            return false;
        }
    }

    /* renamed from: f */
    private boolean m493f() {
        C0073w.m523c("[UploadManager] load security info from dataBase (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        int i;
        try {
            C0064o a = C0064o.m440a();
            if (a == null) {
                C0073w.m524d("[UploadManager] failed to get Database", new Object[0]);
                return false;
            }
            Map a2 = a.m464a(555, null, true);
            if (a2 != null && a2.containsKey("security_info")) {
                String[] split = new String((byte[]) a2.get("security_info")).split("#");
                if (split.length == 4) {
                    if (split[0].isEmpty() || split[0].equals("null")) {
                        i = 0;
                    } else {
                        this.f559j = Base64.decode(split[0], 0);
                        i = 0;
                    }
                    if (i == 0) {
                        if (!(split[1].isEmpty() || split[1].equals("null"))) {
                            try {
                                this.f560k = Long.parseLong(split[1]);
                            } catch (Throwable th) {
                                C0073w.m520a(th);
                                i = 1;
                            }
                        }
                    }
                    if (i == 0) {
                        if (!(split[2].isEmpty() || split[2].equals("null"))) {
                            this.f561l = split[2];
                        }
                    }
                    if (!(i != 0 || split[3].isEmpty() || split[3].equals("null"))) {
                        try {
                            this.f562m = Long.parseLong(split[3]);
                        } catch (Throwable th2) {
                            C0073w.m520a(th2);
                            i = 1;
                        }
                    }
                } else {
                    C0073w.m519a("securityInfo = %s, strings.length = %d", r3, Integer.valueOf(split.length));
                    i = 1;
                }
                if (i != 0) {
                    C0069t.m491d();
                }
            }
            return true;
        } catch (Throwable th22) {
            C0073w.m520a(th22);
            return false;
        }
    }

    /* renamed from: c */
    protected final boolean m506c() {
        if (this.f561l == null || this.f562m == 0) {
            return false;
        }
        if (this.f562m >= System.currentTimeMillis() + this.f558i) {
            return true;
        }
        C0073w.m523c("[UploadManager] session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(this.f562m), new Date(this.f562m).toString(), Long.valueOf(System.currentTimeMillis() + this.f558i), new Date(System.currentTimeMillis() + this.f558i).toString());
        return false;
    }

    /* renamed from: a */
    protected final void m501a(boolean z) {
        synchronized (this.f563n) {
            C0073w.m523c("[UploadManager] clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.f559j = null;
            this.f561l = null;
            this.f562m = 0;
        }
        if (z) {
            C0069t.m491d();
        }
    }

    /* renamed from: b */
    private boolean m487b(int i) {
        if (i < 0) {
            C0073w.m519a("[UploadManager] number of task to execute should >= 0", new Object[0]);
            return false;
        }
        synchronized (this.f555f) {
            if (this.f554e.isEmpty()) {
                return true;
            }
            C0073w.m523c("[UploadManager] execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(this.f554e.size()), Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()));
            if (i == 0 || i > this.f554e.size()) {
                i = this.f554e.size();
            }
            C0072v a = C0072v.m511a();
            if (a == null) {
                C0073w.m524d("[UploadManager] async task handler has not been initialized", new Object[0]);
                return false;
            }
            int i2 = 0;
            while (i2 < i) {
                try {
                    Runnable runnable = (Runnable) this.f554e.poll();
                    if (runnable != null) {
                        a.m517c(runnable);
                    } else {
                        C0073w.m524d("[UploadManager] upload task poll from queue is null", new Object[0]);
                    }
                    i2++;
                } catch (Throwable th) {
                    C0073w.m525e("[UploadManager] failed to execute upload task with message: %s", th.getMessage());
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private boolean m485a(Runnable runnable) {
        if (runnable == null) {
            C0073w.m524d("[UploadManager] upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C0073w.m523c("[UploadManager] add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f555f) {
                this.f554e.put(runnable);
            }
            return true;
        } catch (Throwable th) {
            C0073w.m525e("[UploadManager] failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private void m481a(Runnable runnable, long j) {
        if (runnable == null) {
            C0073w.m524d("[UploadManager] upload task should not be null", new Object[0]);
            return;
        }
        C0073w.m523c("[UploadManager] execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread thread = new Thread(runnable);
        thread.setName("BuglySyncUploadThread");
        thread.start();
        try {
            thread.join(j);
        } catch (Throwable th) {
            C0073w.m525e("[UploadManager] failed to execute upload synchronized task with message: %s. Add it to queue", th.getMessage());
            m485a(runnable);
        }
    }

    /* renamed from: a */
    private void m482a(Runnable runnable, boolean z, long j) {
        if (runnable == null) {
            C0073w.m524d("[UploadManager] upload task should not be null", new Object[0]);
        }
        C0072v a = C0072v.m511a();
        if (a == null) {
            C0073w.m524d("[UploadManager] async task handler has not been initialized", new Object[0]);
        }
        C0073w.m523c("[UploadManager] add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.f561l != null) {
            if (m506c()) {
                C0073w.m523c("[UploadManager] sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z) {
                    m481a(runnable, j);
                } else if (a == null) {
                    m485a(runnable);
                } else {
                    a.m517c(runnable);
                }
                m487b(0);
                return;
            }
            C0073w.m519a("[UploadManager] session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            m501a(false);
        }
        synchronized (this.f565p) {
            if (this.f564o) {
                m485a(runnable);
            } else {
                this.f564o = true;
                C0073w.m523c("[UploadManager] try to request session ID now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z) {
                    m481a(new C0068a(this, this.f552c, runnable, j), 0);
                } else {
                    m485a(runnable);
                    a.m517c(new C0068a(this, this.f552c));
                }
            }
        }
    }

    /* renamed from: a */
    public final void m499a(int i, an anVar) {
        if (this.f566q) {
            if (i == 2) {
                C0073w.m523c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                m501a(true);
            } else if (!this.f564o) {
                return;
            } else {
                if (anVar != null) {
                    boolean z;
                    C0073w.m523c("[UploadManager] record security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    try {
                        Map map = anVar.f443h;
                        if (map != null && map.containsKey("S1") && map.containsKey("S2")) {
                            this.f558i = anVar.f440e - System.currentTimeMillis();
                            C0073w.m523c("[UploadManager] time lag of server is: %d", Long.valueOf(this.f558i));
                            this.f561l = (String) map.get("S1");
                            C0073w.m523c("[UploadManager] session ID from server is: %s", this.f561l);
                            if (this.f561l.length() > 0) {
                                this.f562m = Long.parseLong((String) map.get("S2"));
                                C0073w.m523c("[UploadManager] session expired time from server is: %d(%s)", Long.valueOf(this.f562m), new Date(this.f562m).toString());
                                if (this.f562m < 1000) {
                                    C0073w.m524d("[UploadManager] session expired time from server is less than 1 second, will set to default value", new Object[0]);
                                    this.f562m = 259200000;
                                }
                                m487b(0);
                                if (m492e()) {
                                    z = false;
                                } else {
                                    C0073w.m523c("[UploadManager] failed to record database", new Object[0]);
                                    z = true;
                                }
                                if (z) {
                                    m501a(false);
                                }
                            } else {
                                C0073w.m523c("[UploadManager] session ID from server is invalid, try next time", new Object[0]);
                            }
                        }
                        z = true;
                    } catch (NumberFormatException e) {
                        C0073w.m524d("[UploadManager] session expired time is invalid, will set to default value", new Object[0]);
                        this.f562m = 259200000;
                    } catch (Throwable th) {
                        C0073w.m520a(th);
                        z = true;
                    }
                    if (z) {
                        m501a(false);
                    }
                } else {
                    C0073w.m523c("[UploadManager] fail to init security context and clear local info (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    m501a(false);
                }
            }
            synchronized (this.f565p) {
                if (this.f564o) {
                    this.f564o = false;
                    C0048a.m284b(this.f552c, "security_info");
                }
            }
        }
    }

    /* renamed from: a */
    public final byte[] m503a(byte[] bArr) {
        if (this.f559j != null && (this.f559j.length << 3) == 128) {
            return C0048a.m271a(1, bArr, this.f559j);
        }
        C0073w.m524d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* renamed from: b */
    public final byte[] m505b(byte[] bArr) {
        if (this.f559j != null && (this.f559j.length << 3) == 128) {
            return C0048a.m271a(2, bArr, this.f559j);
        }
        C0073w.m524d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    /* renamed from: a */
    public final boolean m502a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        C0073w.m523c("[UploadManager] integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.f561l != null) {
            map.put("secureSessionId", this.f561l);
            return true;
        } else if (this.f559j == null || (this.f559j.length << 3) != 128) {
            C0073w.m524d("[UploadManager] AES key is invalid", new Object[0]);
            return false;
        } else {
            if (this.f557h == null) {
                this.f557h = Base64.decode(this.f556g, 0);
                if (this.f557h == null) {
                    C0073w.m524d("[UploadManager] failed to decode RSA public key", new Object[0]);
                    return false;
                }
            }
            byte[] b = C0048a.m285b(1, this.f559j, this.f557h);
            if (b == null) {
                C0073w.m524d("[UploadManager] failed to encrypt AES key", new Object[0]);
                return false;
            }
            String encodeToString = Base64.encodeToString(b, 0);
            if (encodeToString == null) {
                C0073w.m524d("[UploadManager] failed to encode AES key", new Object[0]);
                return false;
            }
            map.put("raKey", encodeToString);
            return true;
        }
    }
}
