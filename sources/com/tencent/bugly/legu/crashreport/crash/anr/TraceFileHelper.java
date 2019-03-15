package com.tencent.bugly.legu.crashreport.crash.anr;

import com.tencent.bugly.legu.proguard.C0073w;
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
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.anr.TraceFileHelper$b */
    public interface C0023b {
        /* renamed from: a */
        boolean mo6a(long j);

        /* renamed from: a */
        boolean mo7a(long j, long j2, String str);

        /* renamed from: a */
        boolean mo8a(String str, int i, String str2, String str3);
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.anr.TraceFileHelper$a */
    public static class C0026a {
        /* renamed from: a */
        public long f231a;
        /* renamed from: b */
        public String f232b;
        /* renamed from: c */
        public long f233c;
        /* renamed from: d */
        public Map<String, String[]> f234d;
    }

    public static C0026a readTargetDumpInfo(String str, String str2, final boolean z) {
        if (str == null || str2 == null) {
            return null;
        }
        final C0026a c0026a = new C0026a();
        readTraceFile(str2, new C0023b() {
            /* renamed from: a */
            public final boolean mo8a(String str, int i, String str2, String str3) {
                C0073w.m523c("new thread %s", str);
                if (c0026a.f231a > 0 && c0026a.f233c > 0 && c0026a.f232b != null) {
                    if (c0026a.f234d == null) {
                        c0026a.f234d = new HashMap();
                    }
                    c0026a.f234d.put(str, new String[]{str2, str3, i});
                }
                return true;
            }

            /* renamed from: a */
            public final boolean mo7a(long j, long j2, String str) {
                C0073w.m523c("new process %s", str);
                if (!str.equals(str)) {
                    return true;
                }
                c0026a.f231a = j;
                c0026a.f232b = str;
                c0026a.f233c = j2;
                if (z) {
                    return true;
                }
                return false;
            }

            /* renamed from: a */
            public final boolean mo6a(long j) {
                C0073w.m523c("process end %d", Long.valueOf(j));
                if (c0026a.f231a <= 0 || c0026a.f233c <= 0 || c0026a.f232b == null) {
                    return true;
                }
                return false;
            }
        });
        if (c0026a.f231a <= 0 || c0026a.f233c <= 0 || c0026a.f232b == null) {
            return null;
        }
        return c0026a;
    }

    public static C0026a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            C0073w.m525e("path:%s", str);
            return null;
        }
        final C0026a c0026a = new C0026a();
        readTraceFile(str, new C0023b() {
            /* renamed from: a */
            public final boolean mo8a(String str, int i, String str2, String str3) {
                C0073w.m523c("new thread %s", str);
                if (c0026a.f234d == null) {
                    c0026a.f234d = new HashMap();
                }
                c0026a.f234d.put(str, new String[]{str2, str3, i});
                return true;
            }

            /* renamed from: a */
            public final boolean mo7a(long j, long j2, String str) {
                C0073w.m523c("new process %s", str);
                c0026a.f231a = j;
                c0026a.f232b = str;
                c0026a.f233c = j2;
                if (z) {
                    return true;
                }
                return false;
            }

            /* renamed from: a */
            public final boolean mo6a(long j) {
                C0073w.m523c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (c0026a.f231a > 0 && c0026a.f233c > 0 && c0026a.f232b != null) {
            return c0026a;
        }
        C0073w.m525e("first dump error %s", c0026a.f231a + " " + c0026a.f233c + " " + c0026a.f232b);
        return null;
    }

    public static void readTraceFile(String str, C0023b c0023b) {
        Throwable e;
        Exception e2;
        if (str != null && c0023b != null) {
            File file = new File(str);
            if (file.exists()) {
                file.lastModified();
                file.length();
                BufferedReader bufferedReader = null;
                BufferedReader bufferedReader2;
                try {
                    bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                        Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                        Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                        Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                        while (true) {
                            Object[] a = m133a(bufferedReader2, compile);
                            if (a != null) {
                                String[] split = a[1].toString().split("\\s");
                                long parseLong = Long.parseLong(split[2]);
                                long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                                a = m133a(bufferedReader2, compile3);
                                if (a == null) {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (Throwable e3) {
                                        if (!C0073w.m520a(e3)) {
                                            e3.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                Matcher matcher = compile3.matcher(a[1].toString());
                                matcher.find();
                                matcher.group(1);
                                if (c0023b.mo7a(parseLong, time, matcher.group(1))) {
                                    while (true) {
                                        a = m133a(bufferedReader2, compile4, compile2);
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
                                            c0023b.mo8a(group, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), m132a(bufferedReader2), m134b(bufferedReader2));
                                        } else {
                                            break;
                                        }
                                    }
                                    if (!c0023b.mo6a(Long.parseLong(a[1].toString().split("\\s")[2]))) {
                                        try {
                                            bufferedReader2.close();
                                            return;
                                        } catch (Throwable e32) {
                                            if (!C0073w.m520a(e32)) {
                                                e32.printStackTrace();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                } else {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (Throwable e322) {
                                        if (!C0073w.m520a(e322)) {
                                            e322.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (Throwable e3222) {
                                if (!C0073w.m520a(e3222)) {
                                    e3222.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th) {
                        e3222 = th;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    try {
                        C0073w.m524d("trace open fail:%s : %s", e2.getClass().getName(), e2.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e32222) {
                                if (!C0073w.m520a(e32222)) {
                                    e32222.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        e32222 = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable e6) {
                                if (!C0073w.m520a(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        throw e32222;
                    }
                } catch (Throwable th3) {
                    e32222 = th3;
                    bufferedReader2 = null;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw e32222;
                }
            }
        }
    }

    /* renamed from: a */
    private static Object[] m133a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
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
    private static String m132a(BufferedReader bufferedReader) throws IOException {
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
    private static String m134b(BufferedReader bufferedReader) throws IOException {
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
