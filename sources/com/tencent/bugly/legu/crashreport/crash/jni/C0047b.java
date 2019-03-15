package com.tencent.bugly.legu.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0049j;
import com.tencent.bugly.legu.proguard.C0050b;
import com.tencent.bugly.legu.proguard.C0073w;
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
/* renamed from: com.tencent.bugly.legu.crashreport.crash.jni.b */
public class C0047b {
    /* renamed from: a */
    private StringBuilder f357a;
    /* renamed from: b */
    private int f358b = 0;

    /* renamed from: d */
    private void m229d(String str) {
        for (int i = 0; i < this.f358b; i++) {
            this.f357a.append('\t');
        }
        if (str != null) {
            this.f357a.append(str).append(": ");
        }
    }

    public C0047b(StringBuilder stringBuilder, int i) {
        this.f357a = stringBuilder;
        this.f358b = i;
    }

    /* renamed from: c */
    private static Map<String, Integer> m228c(String str) {
        if (str == null) {
            return null;
        }
        try {
            Map<String, Integer> hashMap = new HashMap();
            for (String split : str.split(",")) {
                String[] split2 = split.split(":");
                if (split2.length != 2) {
                    C0073w.m525e("error format at %s", split);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            C0073w.m525e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public C0047b m242a(boolean z, String str) {
        m229d(str);
        this.f357a.append(z ? 'T' : 'F').append('\n');
        return this;
    }

    /* renamed from: a */
    public C0047b m230a(byte b, String str) {
        m229d(str);
        this.f357a.append(b).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0047b m231a(char c, String str) {
        m229d(str);
        this.f357a.append(c).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0047b m241a(short s, String str) {
        m229d(str);
        this.f357a.append(s).append('\n');
        return this;
    }

    /* renamed from: a */
    protected static String m226a(String str) {
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
    public C0047b m234a(int i, String str) {
        m229d(str);
        this.f357a.append(i).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0047b m235a(long j, String str) {
        m229d(str);
        this.f357a.append(j).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0047b m233a(float f, String str) {
        m229d(str);
        this.f357a.append(f).append('\n');
        return this;
    }

    /* renamed from: a */
    private static CrashDetailBean m224a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        if (map == null) {
            return null;
        }
        if (C0016a.m70a(context) == null) {
            C0073w.m525e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str = (String) map.get("intStateStr");
        if (str == null || str.trim().length() <= 0) {
            C0073w.m525e("no intStateStr", new Object[0]);
            return null;
        }
        Map c = C0047b.m228c(str);
        if (c == null) {
            C0073w.m525e("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            int intValue = ((Integer) c.get("ep")).intValue();
            int intValue2 = ((Integer) c.get("et")).intValue();
            ((Integer) c.get("sino")).intValue();
            int intValue3 = ((Integer) c.get("sico")).intValue();
            int intValue4 = ((Integer) c.get("spd")).intValue();
            ((Integer) c.get("sud")).intValue();
            long intValue5 = (long) ((Integer) c.get("ets")).intValue();
            long intValue6 = (long) ((Integer) c.get("etms")).intValue();
            String str2 = (String) map.get("soVersion");
            if (str2 == null) {
                C0073w.m525e("error format at version", new Object[0]);
                return null;
            }
            String str3;
            String str4;
            String str5;
            String str6;
            str = (String) map.get("errorAddr");
            String str7 = str == null ? "unknown2" : str;
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
            intValue5 = (intValue5 * 1000) + (intValue6 / 1000);
            String a = C0047b.m226a(str);
            str = (String) map.get("sendingProcess");
            if (str == null) {
                str = "UNKNOWN";
            }
            String str8 = str + "(" + intValue4 + ")";
            if (intValue3 > 0) {
                str5 = str5 + "(" + str3 + ")";
                str3 = "KERNEL";
            }
            str = (String) map.get("nativeLog");
            byte[] bArr = null;
            if (!(str == null || str.isEmpty())) {
                bArr = C0048a.m275a(null, str);
            }
            str = (String) map.get("processName");
            if (str == null) {
                str6 = "unknown(" + intValue + ")";
            } else {
                str6 = str;
            }
            str = (String) map.get("threadName");
            if (str == null) {
                str = "unknown";
            }
            String str9 = str + "(" + intValue2 + ")";
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
            CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str6, str9, intValue5, str5, str7, a, str3, str8, str4, str2, bArr, map2, false);
            if (packageCrashDatas != null) {
                str = (String) map.get("userId");
                if (str != null) {
                    packageCrashDatas.f207m = str;
                }
                str = (String) map.get("sysLog");
                if (str != null) {
                    packageCrashDatas.f217w = str;
                }
                str6 = (String) map.get("appVersion");
                if (str != null) {
                    packageCrashDatas.f200f = str6;
                }
                packageCrashDatas.f219y = null;
                packageCrashDatas.f205k = true;
            }
            return packageCrashDatas;
        } catch (Throwable th) {
            C0073w.m525e("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public C0047b m232a(double d, String str) {
        m229d(str);
        this.f357a.append(d).append('\n');
        return this;
    }

    /* renamed from: a */
    public C0047b m238a(String str, String str2) {
        m229d(str2);
        if (str == null) {
            this.f357a.append("null\n");
        } else {
            this.f357a.append(str).append('\n');
        }
        return this;
    }

    /* renamed from: a */
    public C0047b m243a(byte[] bArr, String str) {
        m229d(str);
        if (bArr == null) {
            this.f357a.append("null\n");
        } else if (bArr.length == 0) {
            this.f357a.append(bArr.length).append(", []\n");
        } else {
            this.f357a.append(bArr.length).append(", [\n");
            C0047b c0047b = new C0047b(this.f357a, this.f358b + 1);
            for (byte a : bArr) {
                c0047b.m230a(a, null);
            }
            m231a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0047b m249a(short[] sArr, String str) {
        m229d(str);
        if (sArr == null) {
            this.f357a.append("null\n");
        } else if (sArr.length == 0) {
            this.f357a.append(sArr.length).append(", []\n");
        } else {
            this.f357a.append(sArr.length).append(", [\n");
            C0047b c0047b = new C0047b(this.f357a, this.f358b + 1);
            for (short a : sArr) {
                c0047b.m241a(a, null);
            }
            m231a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0047b m246a(int[] iArr, String str) {
        m229d(str);
        if (iArr == null) {
            this.f357a.append("null\n");
        } else if (iArr.length == 0) {
            this.f357a.append(iArr.length).append(", []\n");
        } else {
            this.f357a.append(iArr.length).append(", [\n");
            C0047b c0047b = new C0047b(this.f357a, this.f358b + 1);
            for (int a : iArr) {
                c0047b.m234a(a, null);
            }
            m231a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0047b m247a(long[] jArr, String str) {
        m229d(str);
        if (jArr == null) {
            this.f357a.append("null\n");
        } else if (jArr.length == 0) {
            this.f357a.append(jArr.length).append(", []\n");
        } else {
            this.f357a.append(jArr.length).append(", [\n");
            C0047b c0047b = new C0047b(this.f357a, this.f358b + 1);
            for (long a : jArr) {
                c0047b.m235a(a, null);
            }
            m231a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0047b m245a(float[] fArr, String str) {
        m229d(str);
        if (fArr == null) {
            this.f357a.append("null\n");
        } else if (fArr.length == 0) {
            this.f357a.append(fArr.length).append(", []\n");
        } else {
            this.f357a.append(fArr.length).append(", [\n");
            C0047b c0047b = new C0047b(this.f357a, this.f358b + 1);
            for (float a : fArr) {
                c0047b.m233a(a, null);
            }
            m231a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public C0047b m244a(double[] dArr, String str) {
        m229d(str);
        if (dArr == null) {
            this.f357a.append("null\n");
        } else if (dArr.length == 0) {
            this.f357a.append(dArr.length).append(", []\n");
        } else {
            this.f357a.append(dArr.length).append(", [\n");
            C0047b c0047b = new C0047b(this.f357a, this.f358b + 1);
            for (double a : dArr) {
                c0047b.m232a(a, null);
            }
            m231a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    private static String m225a(InputStream inputStream) throws IOException {
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
    public <K, V> C0047b m240a(Map<K, V> map, String str) {
        m229d(str);
        if (map == null) {
            this.f357a.append("null\n");
        } else if (map.isEmpty()) {
            this.f357a.append(map.size()).append(", {}\n");
        } else {
            this.f357a.append(map.size()).append(", {\n");
            C0047b c0047b = new C0047b(this.f357a, this.f358b + 1);
            C0047b c0047b2 = new C0047b(this.f357a, this.f358b + 2);
            for (Entry entry : map.entrySet()) {
                c0047b.m231a('(', null);
                c0047b2.m237a(entry.getKey(), null);
                c0047b2.m237a(entry.getValue(), null);
                c0047b.m231a(')', null);
            }
            m231a('}', null);
        }
        return this;
    }

    /* renamed from: a */
    public static CrashDetailBean m223a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        IOException e;
        Throwable th;
        CrashDetailBean crashDetailBean = null;
        if (context == null || str == null || nativeExceptionHandler == null) {
            C0073w.m525e("get eup record file args error", new Object[0]);
        } else {
            File file = new File(str, "rqd_record.eup");
            if (file.exists() && file.canRead()) {
                FileInputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String a = C0047b.m225a((InputStream) fileInputStream);
                        if (a == null || !a.equals("NATIVE_RQD_REPORT")) {
                            C0073w.m525e("record read fail! %s", a);
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            Map hashMap = new HashMap();
                            Object obj = crashDetailBean;
                            while (true) {
                                String a2 = C0047b.m225a((InputStream) fileInputStream);
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
                                C0073w.m525e("record not pair! drop! %s", obj);
                                try {
                                    fileInputStream.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                            } else {
                                crashDetailBean = C0047b.m224a(context, hashMap, nativeExceptionHandler);
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
    public <T> C0047b m248a(T[] tArr, String str) {
        m229d(str);
        if (tArr == null) {
            this.f357a.append("null\n");
        } else if (tArr.length == 0) {
            this.f357a.append(tArr.length).append(", []\n");
        } else {
            this.f357a.append(tArr.length).append(", [\n");
            C0047b c0047b = new C0047b(this.f357a, this.f358b + 1);
            for (Object a : tArr) {
                c0047b.m237a(a, null);
            }
            m231a(']', null);
        }
        return this;
    }

    /* renamed from: a */
    public <T> C0047b m239a(Collection<T> collection, String str) {
        if (collection != null) {
            return m248a(collection.toArray(), str);
        }
        m229d(str);
        this.f357a.append("null\t");
        return this;
    }

    /* renamed from: b */
    public static void m227b(String str) {
        File file = new File(str, "rqd_record.eup");
        if (file.exists() && file.canWrite()) {
            file.delete();
            C0073w.m523c("delete record file %s", file.getAbsoluteFile());
        }
    }

    /* renamed from: a */
    public <T> C0047b m237a(T t, String str) {
        if (t == null) {
            this.f357a.append("null\n");
        } else if (t instanceof Byte) {
            m230a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            m242a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            m241a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            m234a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            m235a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            m233a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            m232a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            m238a((String) t, str);
        } else if (t instanceof Map) {
            m240a((Map) t, str);
        } else if (t instanceof List) {
            m239a((List) t, str);
        } else if (t instanceof C0049j) {
            m236a((C0049j) t, str);
        } else if (t instanceof byte[]) {
            m243a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            m237a((boolean[]) t, str);
        } else if (t instanceof short[]) {
            m249a((short[]) t, str);
        } else if (t instanceof int[]) {
            m246a((int[]) t, str);
        } else if (t instanceof long[]) {
            m247a((long[]) t, str);
        } else if (t instanceof float[]) {
            m245a((float[]) t, str);
        } else if (t instanceof double[]) {
            m244a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            m248a((Object[]) t, str);
        } else {
            throw new C0050b("write object error: unsupport type.");
        }
        return this;
    }

    /* renamed from: a */
    public C0047b m236a(C0049j c0049j, String str) {
        m231a('{', str);
        if (c0049j == null) {
            this.f357a.append('\t').append("null");
        } else {
            c0049j.mo18a(this.f357a, this.f358b + 1);
        }
        m231a('}', null);
        return this;
    }
}
