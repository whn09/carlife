package com.tencent.bugly.lejiagu.proguard;

import android.util.Log;
import com.tencent.bugly.lejiagu.C0081b;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.t */
public final class C0147t {
    /* renamed from: a */
    private static C0147t f1182a;
    /* renamed from: b */
    private ScheduledExecutorService f1183b = null;
    /* renamed from: c */
    private ThreadPoolExecutor f1184c = null;
    /* renamed from: d */
    private ThreadPoolExecutor f1185d = null;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.proguard.t$1 */
    class C01461 implements ThreadFactory {
        C01461(C0147t c0147t) {
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("BUGLY_THREAD");
            return thread;
        }
    }

    protected C0147t() {
        ThreadFactory c01461 = new C01461(this);
        this.f1183b = Executors.newScheduledThreadPool(3, c01461);
        this.f1184c = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(100), c01461);
        this.f1185d = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), c01461);
        if (this.f1183b == null || this.f1183b.isShutdown()) {
            C0148u.m1040d("ScheduledExecutorService is not valiable!", new Object[0]);
        }
        if (this.f1184c == null || this.f1184c.isShutdown()) {
            C0148u.m1040d("QueueExecutorService is not valiable!", new Object[0]);
        }
        if (this.f1185d == null || this.f1185d.isShutdown()) {
            C0148u.m1040d("ploadExecutorService is not valiable!", new Object[0]);
        }
    }

    /* renamed from: a */
    public static synchronized C0147t m1027a() {
        C0147t c0147t;
        synchronized (C0147t.class) {
            if (f1182a == null) {
                f1182a = new C0147t();
            }
            c0147t = f1182a;
        }
        return c0147t;
    }

    /* renamed from: a */
    public final synchronized boolean m1029a(Runnable runnable) {
        boolean z = false;
        synchronized (this) {
            if (m1028c()) {
                if (runnable != null) {
                    try {
                        this.f1184c.submit(runnable);
                        z = true;
                    } catch (Throwable th) {
                        if (C0081b.f637a) {
                            th.printStackTrace();
                        }
                    }
                } else if (C0081b.f637a) {
                    Log.w(C0148u.f1187b, "queue task is null");
                }
            } else if (C0081b.f637a) {
                Log.w(C0148u.f1187b, "queue handler was closed , should not post task!");
            }
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized boolean m1030a(Runnable runnable, long j) {
        boolean z = false;
        synchronized (this) {
            if (!m1028c()) {
                C0148u.m1040d("async handler was closed , should not post task!", new Object[0]);
            } else if (runnable == null) {
                C0148u.m1040d("async task == null", new Object[0]);
            } else {
                if (j <= 0) {
                    j = 0;
                }
                C0148u.m1039c("delay %d task %s", Long.valueOf(j), runnable.getClass().getName());
                try {
                    this.f1183b.schedule(runnable, j, TimeUnit.MILLISECONDS);
                    z = true;
                } catch (Throwable th) {
                    if (C0081b.f637a) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized boolean m1032b(Runnable runnable) {
        boolean z = false;
        synchronized (this) {
            if (!m1028c()) {
                C0148u.m1040d("async handler was closed , should not post task!", new Object[0]);
            } else if (runnable == null) {
                C0148u.m1040d("async task == null", new Object[0]);
            } else {
                C0148u.m1039c("normal task %s", runnable.getClass().getName());
                try {
                    this.f1183b.execute(runnable);
                    z = true;
                } catch (Throwable th) {
                    if (C0081b.f637a) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    public final synchronized boolean m1033c(Runnable runnable) {
        boolean z = false;
        synchronized (this) {
            if (m1028c()) {
                if (runnable != null) {
                    try {
                        this.f1185d.submit(runnable);
                        z = true;
                    } catch (Throwable th) {
                        if (C0081b.f637a) {
                            th.printStackTrace();
                        }
                    }
                } else if (C0081b.f637a) {
                    Log.w(C0148u.f1187b, "queue task is null");
                }
            } else if (C0081b.f637a) {
                Log.w(C0148u.f1187b, "queue handler was closed , should not post task!");
            }
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized void m1031b() {
        if (!(this.f1183b == null || this.f1183b.isShutdown())) {
            C0148u.m1039c("close async handler", new Object[0]);
            this.f1183b.shutdownNow();
        }
        if (!(this.f1184c == null || this.f1184c.isShutdown())) {
            C0148u.m1039c("close async queue handler", new Object[0]);
            this.f1184c.shutdownNow();
        }
        if (!(this.f1185d == null || this.f1185d.isShutdown())) {
            C0148u.m1039c("close async upload handler", new Object[0]);
            this.f1185d.shutdownNow();
        }
    }

    /* renamed from: c */
    private synchronized boolean m1028c() {
        boolean z;
        z = (this.f1183b == null || this.f1183b.isShutdown() || this.f1184c == null || this.f1184c.isShutdown() || this.f1185d == null || this.f1185d.isShutdown()) ? false : true;
        return z;
    }
}
