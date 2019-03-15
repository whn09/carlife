package com.tencent.bugly.legu.proguard;

import android.util.Log;
import com.tencent.bugly.legu.C0005b;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.v */
public final class C0072v {
    /* renamed from: a */
    private static C0072v f584a;
    /* renamed from: b */
    private ScheduledExecutorService f585b = null;
    /* renamed from: c */
    private ThreadPoolExecutor f586c = null;
    /* renamed from: d */
    private ThreadPoolExecutor f587d = null;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.proguard.v$1 */
    class C00711 implements ThreadFactory {
        C00711(C0072v c0072v) {
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("BUGLY_THREAD");
            return thread;
        }
    }

    protected C0072v() {
        ThreadFactory c00711 = new C00711(this);
        this.f585b = Executors.newScheduledThreadPool(3, c00711);
        this.f586c = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(100), c00711);
        this.f587d = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), c00711);
        if (this.f585b == null || this.f585b.isShutdown()) {
            C0073w.m524d("ScheduledExecutorService is not valiable!", new Object[0]);
        }
        if (this.f586c == null || this.f586c.isShutdown()) {
            C0073w.m524d("QueueExecutorService is not valiable!", new Object[0]);
        }
        if (this.f587d == null || this.f587d.isShutdown()) {
            C0073w.m524d("ploadExecutorService is not valiable!", new Object[0]);
        }
    }

    /* renamed from: a */
    public static synchronized C0072v m511a() {
        C0072v c0072v;
        synchronized (C0072v.class) {
            if (f584a == null) {
                f584a = new C0072v();
            }
            c0072v = f584a;
        }
        return c0072v;
    }

    /* renamed from: a */
    public final synchronized boolean m513a(Runnable runnable) {
        boolean z = false;
        synchronized (this) {
            if (m512c()) {
                if (runnable != null) {
                    try {
                        this.f586c.submit(runnable);
                        z = true;
                    } catch (Throwable th) {
                        if (C0005b.f34b) {
                            th.printStackTrace();
                        }
                    }
                } else if (C0005b.f34b) {
                    Log.w(C0073w.f588a, "queue task is null");
                }
            } else if (C0005b.f34b) {
                Log.w(C0073w.f588a, "queue handler was closed , should not post task!");
            }
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized boolean m514a(Runnable runnable, long j) {
        boolean z = false;
        synchronized (this) {
            if (!m512c()) {
                C0073w.m524d("async handler was closed , should not post task!", new Object[0]);
            } else if (runnable == null) {
                C0073w.m524d("async task == null", new Object[0]);
            } else {
                if (j <= 0) {
                    j = 0;
                }
                C0073w.m523c("delay %d task %s", Long.valueOf(j), runnable.getClass().getName());
                try {
                    this.f585b.schedule(runnable, j, TimeUnit.MILLISECONDS);
                    z = true;
                } catch (Throwable th) {
                    if (C0005b.f34b) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized boolean m516b(Runnable runnable) {
        boolean z = false;
        synchronized (this) {
            if (!m512c()) {
                C0073w.m524d("async handler was closed , should not post task!", new Object[0]);
            } else if (runnable == null) {
                C0073w.m524d("async task == null", new Object[0]);
            } else {
                C0073w.m523c("normal task %s", runnable.getClass().getName());
                try {
                    this.f585b.execute(runnable);
                    z = true;
                } catch (Throwable th) {
                    if (C0005b.f34b) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    public final synchronized boolean m517c(Runnable runnable) {
        boolean z = false;
        synchronized (this) {
            if (m512c()) {
                if (runnable != null) {
                    try {
                        this.f587d.submit(runnable);
                        z = true;
                    } catch (Throwable th) {
                        if (C0005b.f34b) {
                            th.printStackTrace();
                        }
                    }
                } else if (C0005b.f34b) {
                    Log.w(C0073w.f588a, "queue task is null");
                }
            } else if (C0005b.f34b) {
                Log.w(C0073w.f588a, "queue handler was closed , should not post task!");
            }
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized void m515b() {
        if (!(this.f585b == null || this.f585b.isShutdown())) {
            C0073w.m523c("close async handler", new Object[0]);
            this.f585b.shutdownNow();
        }
        if (!(this.f586c == null || this.f586c.isShutdown())) {
            C0073w.m523c("close async queue handler", new Object[0]);
            this.f586c.shutdownNow();
        }
        if (!(this.f587d == null || this.f587d.isShutdown())) {
            C0073w.m523c("close async upload handler", new Object[0]);
            this.f587d.shutdownNow();
        }
    }

    /* renamed from: c */
    private synchronized boolean m512c() {
        boolean z;
        z = (this.f585b == null || this.f585b.isShutdown() || this.f586c == null || this.f586c.isShutdown() || this.f587d == null || this.f587d.isShutdown()) ? false : true;
        return z;
    }
}
