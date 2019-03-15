package com.tencent.bugly.legu.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.x */
public final class C0076x {
    /* renamed from: a */
    public static boolean f597a = true;
    /* renamed from: b */
    private static SimpleDateFormat f598b;
    /* renamed from: c */
    private static int f599c = 5120;
    /* renamed from: d */
    private static StringBuilder f600d;
    /* renamed from: e */
    private static StringBuilder f601e;
    /* renamed from: f */
    private static C0075a f602f;
    /* renamed from: g */
    private static String f603g;
    /* renamed from: h */
    private static String f604h;
    /* renamed from: i */
    private static Context f605i;
    /* renamed from: j */
    private static String f606j;
    /* renamed from: k */
    private static boolean f607k;
    /* renamed from: l */
    private static int f608l;
    /* renamed from: m */
    private static Object f609m = new Object();
    /* renamed from: n */
    private static Object f610n = null;
    /* renamed from: o */
    private static Method f611o;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.proguard.x$a */
    public static class C0075a {
        /* renamed from: a */
        private boolean f592a;
        /* renamed from: b */
        private File f593b;
        /* renamed from: c */
        private String f594c;
        /* renamed from: d */
        private long f595d;
        /* renamed from: e */
        private long f596e = 30720;

        public C0075a(String str) {
            if (str != null && !str.equals("")) {
                this.f594c = str;
                this.f592a = m527a();
            }
        }

        /* renamed from: a */
        private synchronized boolean m527a() {
            boolean z = false;
            synchronized (this) {
                try {
                    this.f593b = new File(this.f594c);
                    if (!this.f593b.exists() || this.f593b.delete()) {
                        if (!this.f593b.createNewFile()) {
                            this.f592a = false;
                        }
                        z = true;
                    } else {
                        this.f592a = false;
                    }
                } catch (Throwable th) {
                    this.f592a = false;
                }
            }
            return z;
        }

        /* renamed from: a */
        public final synchronized boolean m531a(String str) {
            boolean z = false;
            synchronized (this) {
                if (this.f592a) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f593b, true);
                        byte[] bytes = str.getBytes("UTF-8");
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.f595d = ((long) bytes.length) + this.f595d;
                        z = true;
                    } catch (Throwable th) {
                        this.f592a = false;
                    }
                }
            }
            return z;
        }
    }

    static {
        f598b = null;
        f611o = null;
        try {
            f598b = new SimpleDateFormat("MM-dd HH:mm:ss");
            f611o = Class.forName("com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler").getDeclaredMethod("appendLogToNative", new Class[]{String.class, String.class, String.class});
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    private static boolean m540b(String str, String str2, String str3) {
        if (f611o == null) {
            return false;
        }
        if (f610n == null) {
            Object a = C0048a.m255a("com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler", "getInstance", null, null, null);
            f610n = a;
            if (a == null) {
                return false;
            }
        }
        try {
            return ((Boolean) f611o.invoke(f610n, new Object[]{str, str2, str3})).booleanValue();
        } catch (Throwable th) {
            Log.w(C0073w.f588a, th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static synchronized void m535a(Context context) {
        synchronized (C0076x.class) {
            if (!(f607k || context == null || !f597a)) {
                try {
                    f601e = new StringBuilder(0);
                    f600d = new StringBuilder(0);
                    f605i = context;
                    C0016a a = C0016a.m70a(context);
                    f603g = a.f117d;
                    a.getClass();
                    f604h = "legu";
                    f606j = f605i.getFilesDir().getPath() + "/buglylog_" + f603g + "_" + f604h + ".txt";
                    f608l = Process.myPid();
                } catch (Throwable th) {
                }
                f607k = true;
            }
        }
    }

    /* renamed from: a */
    public static void m534a(int i) {
        synchronized (f609m) {
            f599c = i;
            if (i < 0) {
                f599c = 0;
            } else if (i > 10240) {
                f599c = 10240;
            }
        }
    }

    /* renamed from: a */
    public static void m537a(String str, String str2, Throwable th) {
        if (th != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            StringBuilder append = new StringBuilder().append(message).append('\n');
            if (th == null) {
                message = "";
            } else {
                Writer stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                printWriter.flush();
                message = stringWriter.toString();
            }
            C0076x.m536a(str, str2, append.append(message).toString());
        }
    }

    /* renamed from: a */
    public static synchronized void m536a(String str, String str2, String str3) {
        synchronized (C0076x.class) {
            if (f607k && f597a) {
                C0076x.m540b(str, str2, str3);
                int myTid = Process.myTid();
                f600d.setLength(0);
                if (str3.length() > 30720) {
                    str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
                }
                Date date = new Date();
                f600d.append(f598b != null ? f598b.format(date) : date.toString()).append(" ").append(f608l).append(" ").append(myTid).append(" ").append(str).append(" ").append(str2).append(": ").append(str3).append("\u0001\r\n");
                final String stringBuilder = f600d.toString();
                synchronized (f609m) {
                    f601e.append(stringBuilder);
                }
                if (f601e.length() > f599c) {
                    C0072v.m511a().m513a(new Runnable() {
                        public final void run() {
                            synchronized (C0076x.f609m) {
                                try {
                                    if (C0076x.f601e.length() <= C0076x.f599c) {
                                        return;
                                    }
                                    if (C0076x.f602f == null) {
                                        C0076x.f602f = new C0075a(C0076x.f606j);
                                    } else if (C0076x.f602f.f593b.length() + ((long) C0076x.f601e.length()) > C0076x.f602f.f596e) {
                                        C0076x.f602f.m527a();
                                    }
                                    if (C0076x.f602f.f592a) {
                                        C0076x.f602f.m531a(C0076x.f601e.toString());
                                        C0076x.f601e.setLength(0);
                                    } else {
                                        C0076x.f601e.setLength(0);
                                        C0076x.f601e.append(stringBuilder);
                                    }
                                } catch (Throwable th) {
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public static byte[] m538a(boolean z) {
        byte[] bArr = null;
        if (f597a) {
            synchronized (f609m) {
                File a;
                if (z) {
                    try {
                        if (f602f != null && f602f.f592a) {
                            a = f602f.f593b;
                            if (f601e.length() == 0 || a != null) {
                                bArr = C0048a.m275a(a, f601e.toString());
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
                a = bArr;
                if (f601e.length() == 0) {
                }
                bArr = C0048a.m275a(a, f601e.toString());
            }
        }
        return bArr;
    }
}
