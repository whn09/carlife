package com.tencent.bugly.lejiagu.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.h */
public final class C0134h {
    /* renamed from: a */
    private ByteBuffer f1106a;
    /* renamed from: b */
    private String f1107b = "GBK";

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.proguard.h$a */
    public static class C0133a {
        /* renamed from: a */
        public byte f1104a;
        /* renamed from: b */
        public int f1105b;
    }

    public C0134h(byte[] bArr) {
        this.f1106a = ByteBuffer.wrap(bArr);
    }

    public C0134h(byte[] bArr, int i) {
        this.f1106a = ByteBuffer.wrap(bArr);
        this.f1106a.position(4);
    }

    /* renamed from: a */
    public final void m928a(byte[] bArr) {
        if (this.f1106a != null) {
            this.f1106a.clear();
        }
        this.f1106a = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private static int m907a(C0133a c0133a, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c0133a.f1104a = (byte) (b & 15);
        c0133a.f1105b = (b & 240) >> 4;
        if (c0133a.f1105b != 15) {
            return 1;
        }
        c0133a.f1105b = byteBuffer.get();
        return 2;
    }

    /* renamed from: a */
    private boolean m911a(int i) {
        try {
            C0133a c0133a = new C0133a();
            while (true) {
                int a = C0134h.m907a(c0133a, this.f1106a.duplicate());
                if (i > c0133a.f1105b && c0133a.f1104a != (byte) 11) {
                    this.f1106a.position(a + this.f1106a.position());
                    m910a(c0133a.f1104a);
                }
            }
            if (i == c0133a.f1105b) {
                return true;
            }
            return false;
        } catch (C0132g e) {
            return false;
        } catch (BufferUnderflowException e2) {
            return false;
        }
    }

    /* renamed from: a */
    private void m909a() {
        C0133a c0133a = new C0133a();
        do {
            C0134h.m907a(c0133a, this.f1106a);
            m910a(c0133a.f1104a);
        } while (c0133a.f1104a != (byte) 11);
    }

    /* renamed from: a */
    private void m910a(byte b) {
        int i = 0;
        int a;
        C0133a c0133a;
        switch (b) {
            case (byte) 0:
                this.f1106a.position(this.f1106a.position() + 1);
                return;
            case (byte) 1:
                this.f1106a.position(2 + this.f1106a.position());
                return;
            case (byte) 2:
                this.f1106a.position(this.f1106a.position() + 4);
                return;
            case (byte) 3:
                this.f1106a.position(this.f1106a.position() + 8);
                return;
            case (byte) 4:
                this.f1106a.position(this.f1106a.position() + 4);
                return;
            case (byte) 5:
                this.f1106a.position(this.f1106a.position() + 8);
                return;
            case (byte) 6:
                i = this.f1106a.get();
                if (i < 0) {
                    i += 256;
                }
                this.f1106a.position(i + this.f1106a.position());
                return;
            case (byte) 7:
                this.f1106a.position(this.f1106a.getInt() + this.f1106a.position());
                return;
            case (byte) 8:
                a = m921a(0, 0, true);
                while (i < (a << 1)) {
                    c0133a = new C0133a();
                    C0134h.m907a(c0133a, this.f1106a);
                    m910a(c0133a.f1104a);
                    i++;
                }
                return;
            case (byte) 9:
                a = m921a(0, 0, true);
                while (i < a) {
                    c0133a = new C0133a();
                    C0134h.m907a(c0133a, this.f1106a);
                    m910a(c0133a.f1104a);
                    i++;
                }
                return;
            case (byte) 10:
                m909a();
                return;
            case (byte) 11:
            case (byte) 12:
                return;
            case (byte) 13:
                C0133a c0133a2 = new C0133a();
                C0134h.m907a(c0133a2, this.f1106a);
                if (c0133a2.f1104a != (byte) 0) {
                    throw new C0132g("skipField with invalid type, type value: " + b + ", " + c0133a2.f1104a);
                }
                this.f1106a.position(m921a(0, 0, true) + this.f1106a.position());
                return;
            default:
                throw new C0132g("invalid type.");
        }
    }

    /* renamed from: a */
    public final boolean m929a(int i, boolean z) {
        if (m920a((byte) 0, i, z) != (byte) 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final byte m920a(byte b, int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 0:
                    return this.f1106a.get();
                case (byte) 12:
                    return (byte) 0;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return b;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final short m927a(short s, int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 0:
                    return (short) this.f1106a.get();
                case (byte) 1:
                    return this.f1106a.getShort();
                case (byte) 12:
                    return (short) 0;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return s;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final int m921a(int i, int i2, boolean z) {
        if (m911a(i2)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 0:
                    return this.f1106a.get();
                case (byte) 1:
                    return this.f1106a.getShort();
                case (byte) 2:
                    return this.f1106a.getInt();
                case (byte) 12:
                    return 0;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return i;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final long m923a(long j, int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 0:
                    return (long) this.f1106a.get();
                case (byte) 1:
                    return (long) this.f1106a.getShort();
                case (byte) 2:
                    return (long) this.f1106a.getInt();
                case (byte) 3:
                    return this.f1106a.getLong();
                case (byte) 12:
                    return 0;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return j;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: a */
    private float m906a(float f, int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 4:
                    return this.f1106a.getFloat();
                case (byte) 12:
                    return 0.0f;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return f;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: a */
    private double m905a(double d, int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 4:
                    return (double) this.f1106a.getFloat();
                case (byte) 5:
                    return this.f1106a.getDouble();
                case (byte) 12:
                    return 0.0d;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return d;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: b */
    public final String m930b(int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            int i2;
            byte[] bArr;
            switch (c0133a.f1104a) {
                case (byte) 6:
                    i2 = this.f1106a.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.f1106a.get(bArr);
                    try {
                        return new String(bArr, this.f1107b);
                    } catch (UnsupportedEncodingException e) {
                        return new String(bArr);
                    }
                case (byte) 7:
                    i2 = this.f1106a.getInt();
                    if (i2 > 104857600 || i2 < 0) {
                        throw new C0132g("String too long: " + i2);
                    }
                    bArr = new byte[i2];
                    this.f1106a.get(bArr);
                    try {
                        return new String(bArr, this.f1107b);
                    } catch (UnsupportedEncodingException e2) {
                        return new String(bArr);
                    }
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final <K, V> HashMap<K, V> m926a(Map<K, V> map, int i, boolean z) {
        return (HashMap) m908a(new HashMap(), map, i, z);
    }

    /* renamed from: a */
    private <K, V> Map<K, V> m908a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 8:
                    int a = m921a(0, 0, true);
                    if (a < 0) {
                        throw new C0132g("size invalid: " + a);
                    }
                    for (int i2 = 0; i2 < a; i2++) {
                        map.put(m925a(key, 0, true), m925a(value, 1, true));
                    }
                    return map;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return map;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: d */
    private boolean[] m914d(int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 9:
                    int a = m921a(0, 0, true);
                    if (a < 0) {
                        throw new C0132g("size invalid: " + a);
                    }
                    boolean[] zArr = new boolean[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        boolean z2;
                        if (m920a((byte) 0, 0, true) != (byte) 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zArr[i2] = z2;
                    }
                    return zArr;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: c */
    public final byte[] m931c(int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            byte[] bArr;
            switch (c0133a.f1104a) {
                case (byte) 9:
                    int a = m921a(0, 0, true);
                    if (a < 0) {
                        throw new C0132g("size invalid: " + a);
                    }
                    bArr = new byte[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        bArr[i2] = m920a(bArr[0], 0, true);
                    }
                    return bArr;
                case (byte) 13:
                    C0133a c0133a2 = new C0133a();
                    C0134h.m907a(c0133a2, this.f1106a);
                    if (c0133a2.f1104a != (byte) 0) {
                        throw new C0132g("type mismatch, tag: " + i + ", type: " + c0133a.f1104a + ", " + c0133a2.f1104a);
                    }
                    int a2 = m921a(0, 0, true);
                    if (a2 < 0) {
                        throw new C0132g("invalid size, tag: " + i + ", type: " + c0133a.f1104a + ", " + c0133a2.f1104a + ", size: " + a2);
                    }
                    bArr = new byte[a2];
                    this.f1106a.get(bArr);
                    return bArr;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: e */
    private short[] m915e(int i, boolean z) {
        short[] sArr = null;
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 9:
                    int a = m921a(0, 0, true);
                    if (a >= 0) {
                        sArr = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr[i2] = m927a(sArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0132g("size invalid: " + a);
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (z) {
            throw new C0132g("require field not exist.");
        }
        return sArr;
    }

    /* renamed from: f */
    private int[] m916f(int i, boolean z) {
        int[] iArr = null;
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 9:
                    int a = m921a(0, 0, true);
                    if (a >= 0) {
                        iArr = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr[i2] = m921a(iArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0132g("size invalid: " + a);
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (z) {
            throw new C0132g("require field not exist.");
        }
        return iArr;
    }

    /* renamed from: g */
    private long[] m917g(int i, boolean z) {
        long[] jArr = null;
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 9:
                    int a = m921a(0, 0, true);
                    if (a >= 0) {
                        jArr = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr[i2] = m923a(jArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0132g("size invalid: " + a);
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (z) {
            throw new C0132g("require field not exist.");
        }
        return jArr;
    }

    /* renamed from: h */
    private float[] m918h(int i, boolean z) {
        float[] fArr = null;
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 9:
                    int a = m921a(0, 0, true);
                    if (a >= 0) {
                        fArr = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr[i2] = m906a(fArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0132g("size invalid: " + a);
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (z) {
            throw new C0132g("require field not exist.");
        }
        return fArr;
    }

    /* renamed from: i */
    private double[] m919i(int i, boolean z) {
        double[] dArr = null;
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 9:
                    int a = m921a(0, 0, true);
                    if (a >= 0) {
                        dArr = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr[i2] = m905a(dArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0132g("size invalid: " + a);
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (z) {
            throw new C0132g("require field not exist.");
        }
        return dArr;
    }

    /* renamed from: a */
    private <T> T[] m912a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return m913b(tArr[0], i, z);
        }
        throw new C0132g("unable to get type of key and value.");
    }

    /* renamed from: b */
    private <T> T[] m913b(T t, int i, boolean z) {
        if (m911a(i)) {
            C0133a c0133a = new C0133a();
            C0134h.m907a(c0133a, this.f1106a);
            switch (c0133a.f1104a) {
                case (byte) 9:
                    int a = m921a(0, 0, true);
                    if (a < 0) {
                        throw new C0132g("size invalid: " + a);
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = m925a((Object) t, 0, true);
                    }
                    return objArr;
                default:
                    throw new C0132g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0132g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final C0126j m924a(C0126j c0126j, int i, boolean z) {
        C0126j c0126j2 = null;
        if (m911a(i)) {
            try {
                c0126j2 = (C0126j) c0126j.getClass().newInstance();
                C0133a c0133a = new C0133a();
                C0134h.m907a(c0133a, this.f1106a);
                if (c0133a.f1104a != (byte) 10) {
                    throw new C0132g("type mismatch.");
                }
                c0126j2.mo39a(this);
                m909a();
            } catch (Exception e) {
                throw new C0132g(e.getMessage());
            }
        } else if (z) {
            throw new C0132g("require field not exist.");
        }
        return c0126j2;
    }

    /* renamed from: a */
    public final <T> Object m925a(T t, int i, boolean z) {
        int i2 = 0;
        if (t instanceof Byte) {
            return Byte.valueOf(m920a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            boolean z2;
            if (m920a((byte) 0, i, z) != (byte) 0) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        } else if (t instanceof Short) {
            return Short.valueOf(m927a((short) 0, i, z));
        } else {
            if (t instanceof Integer) {
                return Integer.valueOf(m921a(0, i, z));
            }
            if (t instanceof Long) {
                return Long.valueOf(m923a(0, i, z));
            }
            if (t instanceof Float) {
                return Float.valueOf(m906a(0.0f, i, z));
            }
            if (t instanceof Double) {
                return Double.valueOf(m905a(0.0d, i, z));
            }
            if (t instanceof String) {
                return String.valueOf(m930b(i, z));
            }
            if (t instanceof Map) {
                return (HashMap) m908a(new HashMap(), (Map) t, i, z);
            } else if (t instanceof List) {
                List list = (List) t;
                if (list == null || list.isEmpty()) {
                    return new ArrayList();
                }
                Object[] b = m913b(list.get(0), i, z);
                if (b == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (i2 < b.length) {
                    arrayList.add(b[i2]);
                    i2++;
                }
                return arrayList;
            } else if (t instanceof C0126j) {
                return m924a((C0126j) t, i, z);
            } else {
                if (!t.getClass().isArray()) {
                    throw new C0132g("read object error: unsupport type.");
                } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
                    return m931c(i, z);
                } else {
                    if (t instanceof boolean[]) {
                        return m914d(i, z);
                    }
                    if (t instanceof short[]) {
                        return m915e(i, z);
                    }
                    if (t instanceof int[]) {
                        return m916f(i, z);
                    }
                    if (t instanceof long[]) {
                        return m917g(i, z);
                    }
                    if (t instanceof float[]) {
                        return m918h(i, z);
                    }
                    if (t instanceof double[]) {
                        return m919i(i, z);
                    }
                    return m912a((Object[]) t, i, z);
                }
            }
        }
    }

    /* renamed from: a */
    public final int m922a(String str) {
        this.f1107b = str;
        return 0;
    }
}
