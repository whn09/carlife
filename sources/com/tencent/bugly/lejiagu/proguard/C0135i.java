package com.tencent.bugly.lejiagu.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.i */
public final class C0135i {
    /* renamed from: a */
    private ByteBuffer f1108a;
    /* renamed from: b */
    private String f1109b;

    public C0135i(int i) {
        this.f1109b = "GBK";
        this.f1108a = ByteBuffer.allocate(i);
    }

    public C0135i() {
        this(128);
    }

    /* renamed from: a */
    public final ByteBuffer m935a() {
        return this.f1108a;
    }

    /* renamed from: b */
    public final byte[] m947b() {
        Object obj = new byte[this.f1108a.position()];
        System.arraycopy(this.f1108a.array(), 0, obj, 0, this.f1108a.position());
        return obj;
    }

    /* renamed from: a */
    private void m932a(int i) {
        if (this.f1108a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f1108a.capacity() + i) << 1);
            allocate.put(this.f1108a.array(), 0, this.f1108a.position());
            this.f1108a = allocate;
        }
    }

    /* renamed from: b */
    private void m933b(byte b, int i) {
        if (i < 15) {
            this.f1108a.put((byte) ((i << 4) | b));
        } else if (i < 256) {
            this.f1108a.put((byte) (b | 240));
            this.f1108a.put((byte) i);
        } else {
            throw new C0127b("tag is too large: " + i);
        }
    }

    /* renamed from: a */
    public final void m945a(boolean z, int i) {
        m936a((byte) (z ? 1 : 0), i);
    }

    /* renamed from: a */
    public final void m936a(byte b, int i) {
        m932a(3);
        if (b == (byte) 0) {
            m933b((byte) 12, i);
            return;
        }
        m933b((byte) 0, i);
        this.f1108a.put(b);
    }

    /* renamed from: a */
    public final void m944a(short s, int i) {
        m932a(4);
        if (s < (short) -128 || s > (short) 127) {
            m933b((byte) 1, i);
            this.f1108a.putShort(s);
            return;
        }
        m936a((byte) s, i);
    }

    /* renamed from: a */
    public final void m937a(int i, int i2) {
        m932a(6);
        if (i < -32768 || i > 32767) {
            m933b((byte) 2, i2);
            this.f1108a.putInt(i);
            return;
        }
        m944a((short) i, i2);
    }

    /* renamed from: a */
    public final void m938a(long j, int i) {
        m932a(10);
        if (j < -2147483648L || j > 2147483647L) {
            m933b((byte) 3, i);
            this.f1108a.putLong(j);
            return;
        }
        m937a((int) j, i);
    }

    /* renamed from: a */
    public final void m941a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f1109b);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        m932a(bytes.length + 10);
        if (bytes.length > 255) {
            m933b((byte) 7, i);
            this.f1108a.putInt(bytes.length);
            this.f1108a.put(bytes);
            return;
        }
        m933b((byte) 6, i);
        this.f1108a.put((byte) bytes.length);
        this.f1108a.put(bytes);
    }

    /* renamed from: a */
    public final <K, V> void m943a(Map<K, V> map, int i) {
        m932a(8);
        m933b((byte) 8, i);
        m937a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                m940a(entry.getKey(), 0);
                m940a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    public final void m946a(byte[] bArr, int i) {
        m932a(bArr.length + 8);
        m933b((byte) 13, i);
        m933b((byte) 0, 0);
        m937a(bArr.length, 0);
        this.f1108a.put(bArr);
    }

    /* renamed from: a */
    public final <T> void m942a(Collection<T> collection, int i) {
        m932a(8);
        m933b((byte) 9, i);
        m937a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T a : collection) {
                m940a((Object) a, 0);
            }
        }
    }

    /* renamed from: a */
    public final void m939a(C0126j c0126j, int i) {
        m932a(2);
        m933b((byte) 10, i);
        c0126j.mo40a(this);
        m932a(2);
        m933b((byte) 11, 0);
    }

    /* renamed from: a */
    public final void m940a(Object obj, int i) {
        int i2 = 1;
        if (obj instanceof Byte) {
            m936a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                i2 = 0;
            }
            m936a((byte) i2, i);
        } else if (obj instanceof Short) {
            m944a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            m937a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            m938a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            m932a(6);
            m933b((byte) 4, i);
            this.f1108a.putFloat(floatValue);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            m932a(10);
            m933b((byte) 5, i);
            this.f1108a.putDouble(doubleValue);
        } else if (obj instanceof String) {
            m941a((String) obj, i);
        } else if (obj instanceof Map) {
            m943a((Map) obj, i);
        } else if (obj instanceof List) {
            m942a((List) obj, i);
        } else if (obj instanceof C0126j) {
            C0126j c0126j = (C0126j) obj;
            m932a(2);
            m933b((byte) 10, i);
            c0126j.mo40a(this);
            m932a(2);
            m933b((byte) 11, 0);
        } else if (obj instanceof byte[]) {
            m946a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            m932a(8);
            m933b((byte) 9, i);
            m937a(zArr.length, 0);
            for (boolean z : zArr) {
                m936a((byte) (z ? 1 : 0), 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            m932a(8);
            m933b((byte) 9, i);
            m937a(sArr.length, 0);
            for (short a : sArr) {
                m944a(a, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            m932a(8);
            m933b((byte) 9, i);
            m937a(iArr.length, 0);
            for (int a2 : iArr) {
                m937a(a2, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            m932a(8);
            m933b((byte) 9, i);
            m937a(jArr.length, 0);
            for (long a3 : jArr) {
                m938a(a3, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            m932a(8);
            m933b((byte) 9, i);
            m937a(fArr.length, 0);
            for (float f : fArr) {
                m932a(6);
                m933b((byte) 4, 0);
                this.f1108a.putFloat(f);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            m932a(8);
            m933b((byte) 9, i);
            m937a(dArr.length, 0);
            for (double d : dArr) {
                m932a(10);
                m933b((byte) 5, 0);
                this.f1108a.putDouble(d);
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            m932a(8);
            m933b((byte) 9, i);
            m937a(objArr.length, 0);
            for (Object a4 : objArr) {
                m940a(a4, 0);
            }
        } else if (obj instanceof Collection) {
            m942a((Collection) obj, i);
        } else {
            throw new C0127b("write object error: unsupport type. " + obj.getClass());
        }
    }

    /* renamed from: a */
    public final int m934a(String str) {
        this.f1109b = str;
        return 0;
    }
}
