package com.tencent.bugly.legu.proguard;

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
/* renamed from: com.tencent.bugly.legu.proguard.h */
public final class C0057h {
    /* renamed from: a */
    private ByteBuffer f499a;
    /* renamed from: b */
    private String f500b = "GBK";

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.proguard.h$a */
    public static class C0056a {
        /* renamed from: a */
        public byte f497a;
        /* renamed from: b */
        public int f498b;
    }

    public C0057h(byte[] bArr) {
        this.f499a = ByteBuffer.wrap(bArr);
    }

    public C0057h(byte[] bArr, int i) {
        this.f499a = ByteBuffer.wrap(bArr);
        this.f499a.position(4);
    }

    /* renamed from: a */
    public final void m395a(byte[] bArr) {
        if (this.f499a != null) {
            this.f499a.clear();
        }
        this.f499a = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private static int m374a(C0056a c0056a, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c0056a.f497a = (byte) (b & 15);
        c0056a.f498b = (b & 240) >> 4;
        if (c0056a.f498b != 15) {
            return 1;
        }
        c0056a.f498b = byteBuffer.get();
        return 2;
    }

    /* renamed from: a */
    private boolean m378a(int i) {
        try {
            C0056a c0056a = new C0056a();
            while (true) {
                int a = C0057h.m374a(c0056a, this.f499a.duplicate());
                if (i > c0056a.f498b && c0056a.f497a != (byte) 11) {
                    this.f499a.position(a + this.f499a.position());
                    m377a(c0056a.f497a);
                }
            }
            if (i == c0056a.f498b) {
                return true;
            }
            return false;
        } catch (C0055g e) {
            return false;
        } catch (BufferUnderflowException e2) {
            return false;
        }
    }

    /* renamed from: a */
    private void m376a() {
        C0056a c0056a = new C0056a();
        do {
            C0057h.m374a(c0056a, this.f499a);
            m377a(c0056a.f497a);
        } while (c0056a.f497a != (byte) 11);
    }

    /* renamed from: a */
    private void m377a(byte b) {
        int i = 0;
        int a;
        C0056a c0056a;
        switch (b) {
            case (byte) 0:
                this.f499a.position(this.f499a.position() + 1);
                return;
            case (byte) 1:
                this.f499a.position(2 + this.f499a.position());
                return;
            case (byte) 2:
                this.f499a.position(this.f499a.position() + 4);
                return;
            case (byte) 3:
                this.f499a.position(this.f499a.position() + 8);
                return;
            case (byte) 4:
                this.f499a.position(this.f499a.position() + 4);
                return;
            case (byte) 5:
                this.f499a.position(this.f499a.position() + 8);
                return;
            case (byte) 6:
                i = this.f499a.get();
                if (i < 0) {
                    i += 256;
                }
                this.f499a.position(i + this.f499a.position());
                return;
            case (byte) 7:
                this.f499a.position(this.f499a.getInt() + this.f499a.position());
                return;
            case (byte) 8:
                a = m388a(0, 0, true);
                while (i < (a << 1)) {
                    c0056a = new C0056a();
                    C0057h.m374a(c0056a, this.f499a);
                    m377a(c0056a.f497a);
                    i++;
                }
                return;
            case (byte) 9:
                a = m388a(0, 0, true);
                while (i < a) {
                    c0056a = new C0056a();
                    C0057h.m374a(c0056a, this.f499a);
                    m377a(c0056a.f497a);
                    i++;
                }
                return;
            case (byte) 10:
                m376a();
                return;
            case (byte) 11:
            case (byte) 12:
                return;
            case (byte) 13:
                C0056a c0056a2 = new C0056a();
                C0057h.m374a(c0056a2, this.f499a);
                if (c0056a2.f497a != (byte) 0) {
                    throw new C0055g("skipField with invalid type, type value: " + b + ", " + c0056a2.f497a);
                }
                this.f499a.position(m388a(0, 0, true) + this.f499a.position());
                return;
            default:
                throw new C0055g("invalid type.");
        }
    }

    /* renamed from: a */
    public final boolean m396a(int i, boolean z) {
        if (m387a((byte) 0, i, z) != (byte) 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final byte m387a(byte b, int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 0:
                    return this.f499a.get();
                case (byte) 12:
                    return (byte) 0;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return b;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final short m394a(short s, int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 0:
                    return (short) this.f499a.get();
                case (byte) 1:
                    return this.f499a.getShort();
                case (byte) 12:
                    return (short) 0;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return s;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final int m388a(int i, int i2, boolean z) {
        if (m378a(i2)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 0:
                    return this.f499a.get();
                case (byte) 1:
                    return this.f499a.getShort();
                case (byte) 2:
                    return this.f499a.getInt();
                case (byte) 12:
                    return 0;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return i;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final long m390a(long j, int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 0:
                    return (long) this.f499a.get();
                case (byte) 1:
                    return (long) this.f499a.getShort();
                case (byte) 2:
                    return (long) this.f499a.getInt();
                case (byte) 3:
                    return this.f499a.getLong();
                case (byte) 12:
                    return 0;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return j;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: a */
    private float m373a(float f, int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 4:
                    return this.f499a.getFloat();
                case (byte) 12:
                    return 0.0f;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return f;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: a */
    private double m372a(double d, int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 4:
                    return (double) this.f499a.getFloat();
                case (byte) 5:
                    return this.f499a.getDouble();
                case (byte) 12:
                    return 0.0d;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return d;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: b */
    public final String m397b(int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            int i2;
            byte[] bArr;
            switch (c0056a.f497a) {
                case (byte) 6:
                    i2 = this.f499a.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.f499a.get(bArr);
                    try {
                        return new String(bArr, this.f500b);
                    } catch (UnsupportedEncodingException e) {
                        return new String(bArr);
                    }
                case (byte) 7:
                    i2 = this.f499a.getInt();
                    if (i2 > 104857600 || i2 < 0) {
                        throw new C0055g("String too long: " + i2);
                    }
                    bArr = new byte[i2];
                    this.f499a.get(bArr);
                    try {
                        return new String(bArr, this.f500b);
                    } catch (UnsupportedEncodingException e2) {
                        return new String(bArr);
                    }
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final <K, V> HashMap<K, V> m393a(Map<K, V> map, int i, boolean z) {
        return (HashMap) m375a(new HashMap(), map, i, z);
    }

    /* renamed from: a */
    private <K, V> Map<K, V> m375a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 8:
                    int a = m388a(0, 0, true);
                    if (a < 0) {
                        throw new C0055g("size invalid: " + a);
                    }
                    for (int i2 = 0; i2 < a; i2++) {
                        map.put(m392a(key, 0, true), m392a(value, 1, true));
                    }
                    return map;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return map;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: d */
    private boolean[] m381d(int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 9:
                    int a = m388a(0, 0, true);
                    if (a < 0) {
                        throw new C0055g("size invalid: " + a);
                    }
                    boolean[] zArr = new boolean[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        boolean z2;
                        if (m387a((byte) 0, 0, true) != (byte) 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zArr[i2] = z2;
                    }
                    return zArr;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: c */
    public final byte[] m398c(int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            byte[] bArr;
            switch (c0056a.f497a) {
                case (byte) 9:
                    int a = m388a(0, 0, true);
                    if (a < 0) {
                        throw new C0055g("size invalid: " + a);
                    }
                    bArr = new byte[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        bArr[i2] = m387a(bArr[0], 0, true);
                    }
                    return bArr;
                case (byte) 13:
                    C0056a c0056a2 = new C0056a();
                    C0057h.m374a(c0056a2, this.f499a);
                    if (c0056a2.f497a != (byte) 0) {
                        throw new C0055g("type mismatch, tag: " + i + ", type: " + c0056a.f497a + ", " + c0056a2.f497a);
                    }
                    int a2 = m388a(0, 0, true);
                    if (a2 < 0) {
                        throw new C0055g("invalid size, tag: " + i + ", type: " + c0056a.f497a + ", " + c0056a2.f497a + ", size: " + a2);
                    }
                    bArr = new byte[a2];
                    this.f499a.get(bArr);
                    return bArr;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: e */
    private short[] m382e(int i, boolean z) {
        short[] sArr = null;
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 9:
                    int a = m388a(0, 0, true);
                    if (a >= 0) {
                        sArr = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr[i2] = m394a(sArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0055g("size invalid: " + a);
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (z) {
            throw new C0055g("require field not exist.");
        }
        return sArr;
    }

    /* renamed from: f */
    private int[] m383f(int i, boolean z) {
        int[] iArr = null;
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 9:
                    int a = m388a(0, 0, true);
                    if (a >= 0) {
                        iArr = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr[i2] = m388a(iArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0055g("size invalid: " + a);
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (z) {
            throw new C0055g("require field not exist.");
        }
        return iArr;
    }

    /* renamed from: g */
    private long[] m384g(int i, boolean z) {
        long[] jArr = null;
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 9:
                    int a = m388a(0, 0, true);
                    if (a >= 0) {
                        jArr = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr[i2] = m390a(jArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0055g("size invalid: " + a);
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (z) {
            throw new C0055g("require field not exist.");
        }
        return jArr;
    }

    /* renamed from: h */
    private float[] m385h(int i, boolean z) {
        float[] fArr = null;
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 9:
                    int a = m388a(0, 0, true);
                    if (a >= 0) {
                        fArr = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr[i2] = m373a(fArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0055g("size invalid: " + a);
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (z) {
            throw new C0055g("require field not exist.");
        }
        return fArr;
    }

    /* renamed from: i */
    private double[] m386i(int i, boolean z) {
        double[] dArr = null;
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 9:
                    int a = m388a(0, 0, true);
                    if (a >= 0) {
                        dArr = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr[i2] = m372a(dArr[0], 0, true);
                        }
                        break;
                    }
                    throw new C0055g("size invalid: " + a);
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (z) {
            throw new C0055g("require field not exist.");
        }
        return dArr;
    }

    /* renamed from: a */
    private <T> T[] m379a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return m380b(tArr[0], i, z);
        }
        throw new C0055g("unable to get type of key and value.");
    }

    /* renamed from: b */
    private <T> T[] m380b(T t, int i, boolean z) {
        if (m378a(i)) {
            C0056a c0056a = new C0056a();
            C0057h.m374a(c0056a, this.f499a);
            switch (c0056a.f497a) {
                case (byte) 9:
                    int a = m388a(0, 0, true);
                    if (a < 0) {
                        throw new C0055g("size invalid: " + a);
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = m392a((Object) t, 0, true);
                    }
                    return objArr;
                default:
                    throw new C0055g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new C0055g("require field not exist.");
        }
    }

    /* renamed from: a */
    public final C0049j m391a(C0049j c0049j, int i, boolean z) {
        C0049j c0049j2 = null;
        if (m378a(i)) {
            try {
                c0049j2 = (C0049j) c0049j.getClass().newInstance();
                C0056a c0056a = new C0056a();
                C0057h.m374a(c0056a, this.f499a);
                if (c0056a.f497a != (byte) 10) {
                    throw new C0055g("type mismatch.");
                }
                c0049j2.mo16a(this);
                m376a();
            } catch (Exception e) {
                throw new C0055g(e.getMessage());
            }
        } else if (z) {
            throw new C0055g("require field not exist.");
        }
        return c0049j2;
    }

    /* renamed from: a */
    public final <T> Object m392a(T t, int i, boolean z) {
        int i2 = 0;
        if (t instanceof Byte) {
            return Byte.valueOf(m387a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            boolean z2;
            if (m387a((byte) 0, i, z) != (byte) 0) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        } else if (t instanceof Short) {
            return Short.valueOf(m394a((short) 0, i, z));
        } else {
            if (t instanceof Integer) {
                return Integer.valueOf(m388a(0, i, z));
            }
            if (t instanceof Long) {
                return Long.valueOf(m390a(0, i, z));
            }
            if (t instanceof Float) {
                return Float.valueOf(m373a(0.0f, i, z));
            }
            if (t instanceof Double) {
                return Double.valueOf(m372a(0.0d, i, z));
            }
            if (t instanceof String) {
                return String.valueOf(m397b(i, z));
            }
            if (t instanceof Map) {
                return (HashMap) m375a(new HashMap(), (Map) t, i, z);
            } else if (t instanceof List) {
                List list = (List) t;
                if (list == null || list.isEmpty()) {
                    return new ArrayList();
                }
                Object[] b = m380b(list.get(0), i, z);
                if (b == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (i2 < b.length) {
                    arrayList.add(b[i2]);
                    i2++;
                }
                return arrayList;
            } else if (t instanceof C0049j) {
                return m391a((C0049j) t, i, z);
            } else {
                if (!t.getClass().isArray()) {
                    throw new C0055g("read object error: unsupport type.");
                } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
                    return m398c(i, z);
                } else {
                    if (t instanceof boolean[]) {
                        return m381d(i, z);
                    }
                    if (t instanceof short[]) {
                        return m382e(i, z);
                    }
                    if (t instanceof int[]) {
                        return m383f(i, z);
                    }
                    if (t instanceof long[]) {
                        return m384g(i, z);
                    }
                    if (t instanceof float[]) {
                        return m385h(i, z);
                    }
                    if (t instanceof double[]) {
                        return m386i(i, z);
                    }
                    return m379a((Object[]) t, i, z);
                }
            }
        }
    }

    /* renamed from: a */
    public final int m389a(String str) {
        this.f500b = str;
        return 0;
    }
}
