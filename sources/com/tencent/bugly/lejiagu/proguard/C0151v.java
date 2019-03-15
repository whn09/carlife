package com.tencent.bugly.lejiagu.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.v */
public final class C0151v {
    /* renamed from: a */
    public static boolean f1195a = true;
    /* renamed from: b */
    private static SimpleDateFormat f1196b;
    /* renamed from: c */
    private static int f1197c = 5120;
    /* renamed from: d */
    private static StringBuilder f1198d;
    /* renamed from: e */
    private static StringBuilder f1199e;
    /* renamed from: f */
    private static C0150a f1200f;
    /* renamed from: g */
    private static String f1201g;
    /* renamed from: h */
    private static String f1202h;
    /* renamed from: i */
    private static Context f1203i;
    /* renamed from: j */
    private static String f1204j;
    /* renamed from: k */
    private static boolean f1205k;
    /* renamed from: l */
    private static int f1206l;
    /* renamed from: m */
    private static Object f1207m = new Object();
    /* renamed from: n */
    private static Object f1208n = null;
    /* renamed from: o */
    private static Method f1209o;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.proguard.v$a */
    public static class C0150a {
        /* renamed from: a */
        private boolean f1190a;
        /* renamed from: b */
        private File f1191b;
        /* renamed from: c */
        private String f1192c;
        /* renamed from: d */
        private long f1193d;
        /* renamed from: e */
        private long f1194e = 30720;

        public C0150a(String str) {
            if (str != null && !str.equals("")) {
                this.f1192c = str;
                this.f1190a = m1043a();
            }
        }

        /* renamed from: a */
        private synchronized boolean m1043a() {
            boolean z = false;
            synchronized (this) {
                try {
                    this.f1191b = new File(this.f1192c);
                    if (!this.f1191b.exists() || this.f1191b.delete()) {
                        if (!this.f1191b.createNewFile()) {
                            this.f1190a = false;
                        }
                        z = true;
                    } else {
                        this.f1190a = false;
                    }
                } catch (Throwable th) {
                    this.f1190a = false;
                }
            }
            return z;
        }

        /* renamed from: a */
        public final synchronized boolean m1047a(String str) {
            boolean z = false;
            synchronized (this) {
                if (this.f1190a) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f1191b, true);
                        byte[] bytes = str.getBytes("UTF-8");
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.f1193d = ((long) bytes.length) + this.f1193d;
                        z = true;
                    } catch (Throwable th) {
                        this.f1190a = false;
                    }
                }
            }
            return z;
        }
    }

    static {
        f1196b = null;
        f1209o = null;
        try {
            f1196b = new SimpleDateFormat("MM-dd HH:mm:ss");
            f1209o = Class.forName("com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler").getDeclaredMethod("appendLogToNative", new Class[]{String.class, String.class, String.class});
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    private static boolean m1056b(String str, String str2, String str3) {
        if (f1209o == null) {
            return false;
        }
        if (f1208n == null) {
            Object a = C0124a.m789a("com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler", "getInstance", null, null, null);
            f1208n = a;
            if (a == null) {
                return false;
            }
        }
        try {
            return ((Boolean) f1209o.invoke(f1208n, new Object[]{str, str2, str3})).booleanValue();
        } catch (Throwable th) {
            Log.w(C0148u.f1187b, th.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static synchronized void m1051a(Context context) {
        synchronized (C0151v.class) {
            if (!(f1205k || context == null || !f1195a)) {
                try {
                    f1199e = new StringBuilder(0);
                    f1198d = new StringBuilder(0);
                    f1203i = context;
                    C0092a a = C0092a.m598a(context);
                    f1201g = a.f724d;
                    a.getClass();
                    f1202h = "lejiagu";
                    f1204j = f1203i.getFilesDir().getPath() + "/buglylog_" + f1201g + "_" + f1202h + ".txt";
                    f1206l = Process.myPid();
                } catch (Throwable th) {
                }
                f1205k = true;
            }
        }
    }

    /* renamed from: a */
    public static void m1050a(int i) {
        synchronized (f1207m) {
            f1197c = i;
            if (i < 0) {
                f1197c = 0;
            } else if (i > 10240) {
                f1197c = 10240;
            }
        }
    }

    /* renamed from: a */
    public static void m1053a(String str, String str2, Throwable th) {
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
            C0151v.m1052a(str, str2, append.append(message).toString());
        }
    }

    /* renamed from: a */
    public static synchronized void m1052a(String str, String str2, String str3) {
        synchronized (C0151v.class) {
            if (f1205k && f1195a) {
                C0151v.m1056b(str, str2, str3);
                int myTid = Process.myTid();
                f1198d.setLength(0);
                if (str3.length() > 30720) {
                    str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
                }
                Date date = new Date();
                f1198d.append(f1196b != null ? f1196b.format(date) : date.toString()).append(" ").append(f1206l).append(" ").append(myTid).append(" ").append(str).append(" ").append(str2).append(": ").append(str3).append("\u0001\r\n");
                final String stringBuilder = f1198d.toString();
                synchronized (f1207m) {
                    f1199e.append(stringBuilder);
                }
                if (f1199e.length() > f1197c) {
                    C0147t.m1027a().m1029a(new Runnable() {
                        public final void run() {
                            synchronized (C0151v.f1207m) {
                                try {
                                    if (C0151v.f1199e.length() <= C0151v.f1197c) {
                                        return;
                                    }
                                    if (C0151v.f1200f == null) {
                                        C0151v.f1200f = new C0150a(C0151v.f1204j);
                                    } else if (C0151v.f1200f.f1191b.length() + ((long) C0151v.f1199e.length()) > C0151v.f1200f.f1194e) {
                                        C0151v.f1200f.m1043a();
                                    }
                                    if (C0151v.f1200f.f1190a) {
                                        C0151v.f1200f.m1047a(C0151v.f1199e.toString());
                                        C0151v.f1199e.setLength(0);
                                    } else {
                                        C0151v.f1199e.setLength(0);
                                        C0151v.f1199e.append(stringBuilder);
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
    public static byte[] m1054a(boolean z) {
        byte[] bArr = null;
        if (f1195a) {
            synchronized (f1207m) {
                File a;
                if (z) {
                    try {
                        if (f1200f != null && f1200f.f1190a) {
                            a = f1200f.f1191b;
                            if (f1199e.length() == 0 || a != null) {
                                bArr = C0124a.m809a(a, f1199e.toString());
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
                a = bArr;
                if (f1199e.length() == 0) {
                }
                bArr = C0124a.m809a(a, f1199e.toString());
            }
        }
        return bArr;
    }
}
