package com.tencent.bugly.lejiagu.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0126j;
import com.tencent.bugly.lejiagu.proguard.C0127b;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.jni.b */
public class C0123b {
    /* renamed from: a */
    private StringBuilder f964a;
    /* renamed from: b */
    private int f965b = 0;

    /* renamed from: d */
    private void m763d(String str) {
        for (int i = 0; i < this.f965b; i++) {
            this.f964a.append('\t');
        }
        if (str != null) {
            this.f964a.append(str).append(": ");
        }
    }

    public C0123b(StringBuilder stringBuilder, int i) {
        this.f964a = stringBuilder;
        this.f965b = i;
    }

    /* renamed from: c */
    private static Map<String, Integer> m762c(String str) {
        if (str == null) {
            return null;
        }
        try {
            Map<String, Integer> hashMap = new HashMap();
            for (String split : str.split(",")) {
                String[] split2 = split.split(":");
                if (split2.length != 2) {
                    C0148u.m1041e("error format at %s", split);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            C0148u.m1041e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public C0123b m776a(boolean z, String str) {
        m763d(str);
        this.f964a.append(z ? 'T' : 'F').append('\n');
        return this;
    }

    /* renamed from: a */
    public C0123b m764a(byte b, String str) {
        m763d(str);
        this.f964a.append(b).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0123b m765a(char c, String str) {
        m763d(str);
        this.f964a.append(c).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0123b m775a(short s, String str) {
        m763d(str);
        this.f964a.append(s).append('\n');
        return this;
    }

    /* renamed from: a */
    protected static String m760a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                stringBuilder.append(str2).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C0123b m768a(int i, String str) {
        m763d(str);
        this.f964a.append(i).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0123b m769a(long j, String str) {
        m763d(str);
        this.f964a.append(j).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0123b m767a(float f, String str) {
        m763d(str);
        this.f964a.append(f).append('\n');
        return this;
    }

    /* renamed from: a */
    private static CrashDetailBean m758a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        if (map == null) {
            return null;
        }
        if (C0092a.m598a(context) == null) {
            C0148u.m1041e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str = (String) map.get("intStateStr");
        if (str == null || str.trim().length() <= 0) {
            C0148u.m1041e("no intStateStr", new Object[0]);
            return null;
        }
        Map c = C0123b.m762c(str);
        if (c == null) {
            C0148u.m1041e("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            int intValue = ((Integer) c.get("ep")).intValue();
            int intValue2 = ((Integer) c.get("et")).intValue();
            ((Integer) c.get("sino")).intValue();
            int intValue3 = ((Integer) c.get("sico")).intValue();
            ((Integer) c.get("spd")).intValue();
            ((Integer) c.get("sud")).intValue();
            long intValue4 = (long) ((Integer) c.get("ets")).intValue();
            long intValue5 = (long) ((Integer) c.get("etms")).intValue();
            String str2 = (String) map.get("soVersion");
            if (str2 == null) {
                C0148u.m1041e("error format at version", new Object[0]);
                return null;
            }
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            str = (String) map.get("errorAddr");
            String str8 = str == null ? "unknown2" : str;
            str = (String) map.get("codeMsg");
            if (str == null) {
                str3 = "unknown2";
            } else {
                str3 = str;
            }
            str = (String) map.get("tombPath");
            if (str == null) {
                str4 = "unknown2";
            } else {
                str4 = str;
            }
            str = (String) map.get("signalName");
            if (str == null) {
                str5 = "unknown2";
            } else {
                str5 = str;
            }
            map.get("errnoMsg");
            str = (String) map.get("stack");
            if (str == null) {
                str6 = "unknown2";
            } else {
                str6 = str;
            }
            str = (String) map.get("jstack");
            if (str != null) {
                str = str6 + "java:\n" + str;
            } else {
                str = str6;
            }
            intValue4 = (intValue4 * 1000) + (intValue5 / 1000);
            String a = C0123b.m760a(str);
            String str9 = "UNKNOWN(" + intValue + ")";
            if (intValue3 > 0) {
                str5 = str5 + "(" + str3 + ")";
                str3 = "KERNEL";
            }
            str = (String) map.get("nativeLog");
            byte[] bArr = null;
            if (!(str == null || str.isEmpty())) {
                bArr = C0124a.m809a(null, str);
            }
            str = (String) map.get("processName");
            if (str == null) {
                str6 = "unknown(" + intValue + ")";
            } else {
                str6 = str;
            }
            str = (String) map.get("threadName");
            if (str == null) {
                str7 = "unknown(" + intValue2 + ")";
            } else {
                str7 = str;
            }
            Map map2 = null;
            str = (String) map.get("key-value");
            if (str != null) {
                map2 = new HashMap();
                for (String split : str.split("\n")) {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        map2.put(split2[0], split2[1]);
                    }
                }
            }
            CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str6, str7, intValue4, str5, str8, a, str3, str9, str4, str2, bArr, map2, false);
            if (packageCrashDatas == null) {
                return packageCrashDatas;
            }
            packageCrashDatas.f826y = null;
            packageCrashDatas.f812k = true;
            return packageCrashDatas;
        } catch (Throwable th) {
            C0148u.m1041e("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public C0123b m766a(double d, String str) {
        m763d(str);
        this.f964a.append(d).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0123b m772a(String str, String str2) {
        m763d(str2);
        if (str == null) {
            this.f964a.append("null\n");
        } else {
            this.f964a.append(str).append('\n');
        }
        return this;
    }

    /* renamed from: a */
    public C0123b m777a(byte[] bArr, String str) {
        m763d(str);
        if (bArr == null) {
            this.f964a.append("null\n");
        } else if (bArr.length == 0) {
            this.f964a.append(bArr.length).append(", []\n");
        } else {
            this.f964a.append(bArr.length).append(", [\n");
            C0123b c0123b = new C0123b(this.f964a, this.f965b + 1);
            for (byte a : bArr) {
                c0123b.m764a(a, null);
            }
            m765a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0123b m783a(short[] sArr, String str) {
        m763d(str);
        if (sArr == null) {
            this.f964a.append("null\n");
        } else if (sArr.length == 0) {
            this.f964a.append(sArr.length).append(", []\n");
        } else {
            this.f964a.append(sArr.length).append(", [\n");
            C0123b c0123b = new C0123b(this.f964a, this.f965b + 1);
            for (short a : sArr) {
                c0123b.m775a(a, null);
            }
            m765a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0123b m780a(int[] iArr, String str) {
        m763d(str);
        if (iArr == null) {
            this.f964a.append("null\n");
        } else if (iArr.length == 0) {
            this.f964a.append(iArr.length).append(", []\n");
        } else {
            this.f964a.append(iArr.length).append(", [\n");
            C0123b c0123b = new C0123b(this.f964a, this.f965b + 1);
            for (int a : iArr) {
                c0123b.m768a(a, null);
            }
            m765a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0123b m781a(long[] jArr, String str) {
        m763d(str);
        if (jArr == null) {
            this.f964a.append("null\n");
        } else if (jArr.length == 0) {
            this.f964a.append(jArr.length).append(", []\n");
        } else {
            this.f964a.append(jArr.length).append(", [\n");
            C0123b c0123b = new C0123b(this.f964a, this.f965b + 1);
            for (long a : jArr) {
                c0123b.m769a(a, null);
            }
            m765a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0123b m779a(float[] fArr, String str) {
        m763d(str);
        if (fArr == null) {
            this.f964a.append("null\n");
        } else if (fArr.length == 0) {
            this.f964a.append(fArr.length).append(", []\n");
        } else {
            this.f964a.append(fArr.length).append(", [\n");
            C0123b c0123b = new C0123b(this.f964a, this.f965b + 1);
            for (float a : fArr) {
                c0123b.m767a(a, null);
            }
            m765a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    private static String m759a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            if (read == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append((char) read);
        }
    }

    /* renamed from: a */
    public C0123b m778a(double[] dArr, String str) {
        m763d(str);
        if (dArr == null) {
            this.f964a.append("null\n");
        } else if (dArr.length == 0) {
            this.f964a.append(dArr.length).append(", []\n");
        } else {
            this.f964a.append(dArr.length).append(", [\n");
            C0123b c0123b = new C0123b(this.f964a, this.f965b + 1);
            for (double a : dArr) {
                c0123b.m766a(a, null);
            }
            m765a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public static CrashDetailBean m757a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        FileInputStream fileInputStream;
        IOException e;
        Throwable th;
        CrashDetailBean crashDetailBean = null;
        if (context == null || str == null || nativeExceptionHandler == null) {
            C0148u.m1041e("get eup record file args error", new Object[0]);
        } else {
            File file = new File(str, "rqd_record.eup");
            if (file.exists() && file.canRead()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String a = C0123b.m759a((InputStream) fileInputStream);
                        if (a == null || !a.equals("NATIVE_RQD_REPORT")) {
                            C0148u.m1041e("record read fail! %s", a);
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            Map hashMap = new HashMap();
                            Object obj = crashDetailBean;
                            while (true) {
                                String a2 = C0123b.m759a((InputStream) fileInputStream);
                                if (a2 == null) {
                                    break;
                                } else if (obj == null) {
                                    obj = a2;
                                } else {
                                    hashMap.put(obj, a2);
                                    obj = crashDetailBean;
                                }
                            }
                            if (obj != null) {
                                C0148u.m1041e("record not pair! drop! %s", obj);
                                try {
                                    fileInputStream.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                            } else {
                                crashDetailBean = C0123b.m758a(context, hashMap, nativeExceptionHandler);
                                try {
                                    fileInputStream.close();
                                } catch (IOException e222) {
                                    e222.printStackTrace();
                                }
                            }
                        }
                    } catch (IOException e3) {
                        e222 = e3;
                        try {
                            e222.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2222) {
                                    e2222.printStackTrace();
                                }
                            }
                            return crashDetailBean;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e22222) {
                                    e22222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e4) {
                    e22222 = e4;
                    fileInputStream = crashDetailBean;
                    e22222.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return crashDetailBean;
                } catch (Throwable th3) {
                    fileInputStream = crashDetailBean;
                    th = th3;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    public <K, V> C0123b m774a(Map<K, V> map, String str) {
        m763d(str);
        if (map == null) {
            this.f964a.append("null\n");
        } else if (map.isEmpty()) {
            this.f964a.append(map.size()).append(", {}\n");
        } else {
            this.f964a.append(map.size()).append(", {\n");
            C0123b c0123b = new C0123b(this.f964a, this.f965b + 1);
            C0123b c0123b2 = new C0123b(this.f964a, this.f965b + 2);
            for (Entry entry : map.entrySet()) {
                c0123b.m765a('(', null);
                c0123b2.m771a(entry.getKey(), null);
                c0123b2.m771a(entry.getValue(), null);
                c0123b.m765a(')', null);
            }
            m765a('}', null);
        }
        return this;
    }

    /* renamed from: a */
    public <T> C0123b m782a(T[] tArr, String str) {
        m763d(str);
        if (tArr == null) {
            this.f964a.append("null\n");
        } else if (tArr.length == 0) {
            this.f964a.append(tArr.length).append(", []\n");
        } else {
            this.f964a.append(tArr.length).append(", [\n");
            C0123b c0123b = new C0123b(this.f964a, this.f965b + 1);
            for (Object a : tArr) {
                c0123b.m771a(a, null);
            }
            m765a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public <T> C0123b m773a(Collection<T> collection, String str) {
        if (collection != null) {
            return m782a(collection.toArray(), str);
        }
        m763d(str);
        this.f964a.append("null\t");
        return this;
    }

    /* renamed from: b */
    public static void m761b(String str) {
        File file = new File(str, "rqd_record.eup");
        if (file.exists() && file.canWrite()) {
            file.delete();
            C0148u.m1039c("delete record file %s", file.getAbsoluteFile());
        }
    }

    /* renamed from: a */
    public <T> C0123b m771a(T t, String str) {
        if (t == null) {
            this.f964a.append("null\n");
        } else if (t instanceof Byte) {
            m764a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            m776a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            m775a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            m768a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            m769a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            m767a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            m766a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            m772a((String) t, str);
        } else if (t instanceof Map) {
            m774a((Map) t, str);
        } else if (t instanceof List) {
            m773a((List) t, str);
        } else if (t instanceof C0126j) {
            m770a((C0126j) t, str);
        } else if (t instanceof byte[]) {
            m777a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            m771a((boolean[]) t, str);
        } else if (t instanceof short[]) {
            m783a((short[]) t, str);
        } else if (t instanceof int[]) {
            m780a((int[]) t, str);
        } else if (t instanceof long[]) {
            m781a((long[]) t, str);
        } else if (t instanceof float[]) {
            m779a((float[]) t, str);
        } else if (t instanceof double[]) {
            m778a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            m782a((Object[]) t, str);
        } else {
            throw new C0127b("write object error: unsupport type.");
        }
        return this;
    }

    /* renamed from: a */
    public C0123b m770a(C0126j c0126j, String str) {
        m765a('{', str);
        if (c0126j == null) {
            this.f964a.append('\t').append("null");
        } else {
            c0126j.mo41a(this.f964a, this.f965b + 1);
        }
        m765a('}', null);
        return this;
    }
}
