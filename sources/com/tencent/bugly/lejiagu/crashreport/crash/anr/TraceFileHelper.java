package com.tencent.bugly.lejiagu.crashreport.crash.anr;

import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.anr.TraceFileHelper$b */
    public interface C0099b {
        /* renamed from: a */
        boolean mo29a(long j);

        /* renamed from: a */
        boolean mo30a(long j, long j2, String str);

        /* renamed from: a */
        boolean mo31a(String str, int i, String str2, String str3);
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.anr.TraceFileHelper$a */
    public static class C0102a {
        /* renamed from: a */
        public long f838a;
        /* renamed from: b */
        public String f839b;
        /* renamed from: c */
        public long f840c;
        /* renamed from: d */
        public Map<String, String[]> f841d;
    }

    public static C0102a readTargetDumpInfo(String str, String str2, final boolean z) {
        if (str == null || str2 == null) {
            return null;
        }
        final C0102a c0102a = new C0102a();
        readTraceFile(str2, new C0099b() {
            /* renamed from: a */
            public final boolean mo31a(String str, int i, String str2, String str3) {
                C0148u.m1039c("new thread %s", str);
                if (c0102a.f838a > 0 && c0102a.f840c > 0 && c0102a.f839b != null) {
                    if (c0102a.f841d == null) {
                        c0102a.f841d = new HashMap();
                    }
                    c0102a.f841d.put(str, new String[]{str2, str3, i});
                }
                return true;
            }

            /* renamed from: a */
            public final boolean mo30a(long j, long j2, String str) {
                C0148u.m1039c("new process %s", str);
                if (!str.equals(str)) {
                    return true;
                }
                c0102a.f838a = j;
                c0102a.f839b = str;
                c0102a.f840c = j2;
                if (z) {
                    return true;
                }
                return false;
            }

            /* renamed from: a */
            public final boolean mo29a(long j) {
                C0148u.m1039c("process end %d", Long.valueOf(j));
                if (c0102a.f838a <= 0 || c0102a.f840c <= 0 || c0102a.f839b == null) {
                    return true;
                }
                return false;
            }
        });
        if (c0102a.f838a <= 0 || c0102a.f840c <= 0 || c0102a.f839b == null) {
            return null;
        }
        return c0102a;
    }

    public static C0102a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            C0148u.m1041e("path:%s", str);
            return null;
        }
        final C0102a c0102a = new C0102a();
        readTraceFile(str, new C0099b() {
            /* renamed from: a */
            public final boolean mo31a(String str, int i, String str2, String str3) {
                C0148u.m1039c("new thread %s", str);
                if (c0102a.f841d == null) {
                    c0102a.f841d = new HashMap();
                }
                c0102a.f841d.put(str, new String[]{str2, str3, i});
                return true;
            }

            /* renamed from: a */
            public final boolean mo30a(long j, long j2, String str) {
                C0148u.m1039c("new process %s", str);
                c0102a.f838a = j;
                c0102a.f839b = str;
                c0102a.f840c = j2;
                if (z) {
                    return true;
                }
                return false;
            }

            /* renamed from: a */
            public final boolean mo29a(long j) {
                C0148u.m1039c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (c0102a.f838a > 0 && c0102a.f840c > 0 && c0102a.f839b != null) {
            return c0102a;
        }
        C0148u.m1041e("first dump error %s", c0102a.f838a + " " + c0102a.f840c + " " + c0102a.f839b);
        return null;
    }

    public static void readTraceFile(String str, C0099b c0099b) {
        BufferedReader bufferedReader;
        Throwable e;
        Exception e2;
        if (str != null && c0099b != null) {
            File file = new File(str);
            if (file.exists()) {
                file.lastModified();
                file.length();
                BufferedReader bufferedReader2 = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                        Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                        Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                        Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                        while (true) {
                            Object[] a = m660a(bufferedReader, compile);
                            if (a != null) {
                                String[] split = a[1].toString().split("\\s");
                                long parseLong = Long.parseLong(split[2]);
                                long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                                a = m660a(bufferedReader, compile3);
                                if (a == null) {
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (Throwable e3) {
                                        if (!C0148u.m1036a(e3)) {
                                            e3.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                Matcher matcher = compile3.matcher(a[1].toString());
                                matcher.find();
                                matcher.group(1);
                                if (c0099b.mo30a(parseLong, time, matcher.group(1))) {
                                    while (true) {
                                        a = m660a(bufferedReader, compile4, compile2);
                                        if (a != null) {
                                            if (a[0] != compile4) {
                                                break;
                                            }
                                            CharSequence obj = a[1].toString();
                                            Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                            matcher2.find();
                                            String group = matcher2.group();
                                            group = group.substring(1, group.length() - 1);
                                            obj.contains("NATIVE");
                                            matcher = Pattern.compile("tid=\\d+").matcher(obj);
                                            matcher.find();
                                            String group2 = matcher.group();
                                            c0099b.mo31a(group, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), m659a(bufferedReader), m661b(bufferedReader));
                                        } else {
                                            break;
                                        }
                                    }
                                    if (!c0099b.mo29a(Long.parseLong(a[1].toString().split("\\s")[2]))) {
                                        try {
                                            bufferedReader.close();
                                            return;
                                        } catch (Throwable e32) {
                                            if (!C0148u.m1036a(e32)) {
                                                e32.printStackTrace();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                } else {
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (Throwable e322) {
                                        if (!C0148u.m1036a(e322)) {
                                            e322.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            try {
                                bufferedReader.close();
                                return;
                            } catch (Throwable e3222) {
                                if (!C0148u.m1036a(e3222)) {
                                    e3222.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th) {
                        e3222 = th;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    try {
                        C0148u.m1040d("trace open fail:%s : %s", e2.getClass().getName(), e2.getMessage());
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable e32222) {
                                if (!C0148u.m1036a(e32222)) {
                                    e32222.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        e32222 = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e6) {
                                if (!C0148u.m1036a(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        throw e32222;
                    }
                } catch (Throwable th3) {
                    e32222 = th3;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw e32222;
                }
            }
        }
    }

    /* renamed from: a */
    private static Object[] m660a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader == null || patternArr == null) {
            return null;
        }
        while (true) {
            CharSequence readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern matcher : patternArr) {
                if (matcher.matcher(readLine).matches()) {
                    return new Object[]{patternArr[r1], readLine};
                }
            }
        }
    }

    /* renamed from: a */
    private static String m659a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m661b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.trim().length() > 0) {
                stringBuffer.append(readLine + "\n");
            }
        }
        return stringBuffer.toString();
    }
}
