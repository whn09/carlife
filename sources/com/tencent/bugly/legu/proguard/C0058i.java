package com.tencent.bugly.legu.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.i */
public final class C0058i {
    /* renamed from: a */
    private ByteBuffer f501a;
    /* renamed from: b */
    private String f502b;

    public C0058i(int i) {
        this.f502b = "GBK";
        this.f501a = ByteBuffer.allocate(i);
    }

    public C0058i() {
        this(128);
    }

    /* renamed from: a */
    public final ByteBuffer m402a() {
        return this.f501a;
    }

    /* renamed from: b */
    public final byte[] m414b() {
        Object obj = new byte[this.f501a.position()];
        System.arraycopy(this.f501a.array(), 0, obj, 0, this.f501a.position());
        return obj;
    }

    /* renamed from: a */
    private void m399a(int i) {
        if (this.f501a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f501a.capacity() + i) << 1);
            allocate.put(this.f501a.array(), 0, this.f501a.position());
            this.f501a = allocate;
        }
    }

    /* renamed from: b */
    private void m400b(byte b, int i) {
        if (i < 15) {
            this.f501a.put((byte) ((i << 4) | b));
        } else if (i < 256) {
            this.f501a.put((byte) (b | 240));
            this.f501a.put((byte) i);
        } else {
            throw new C0050b("tag is too large: " + i);
        }
    }

    /* renamed from: a */
    public final void m412a(boolean z, int i) {
        m403a((byte) (z ? 1 : 0), i);
    }

    /* renamed from: a */
    public final void m403a(byte b, int i) {
        m399a(3);
        if (b == (byte) 0) {
            m400b((byte) 12, i);
            return;
        }
        m400b((byte) 0, i);
        this.f501a.put(b);
    }

    /* renamed from: a */
    public final void m411a(short s, int i) {
        m399a(4);
        if (s < (short) -128 || s > (short) 127) {
            m400b((byte) 1, i);
            this.f501a.putShort(s);
            return;
        }
        m403a((byte) s, i);
    }

    /* renamed from: a */
    public final void m404a(int i, int i2) {
        m399a(6);
        if (i < -32768 || i > 32767) {
            m400b((byte) 2, i2);
            this.f501a.putInt(i);
            return;
        }
        m411a((short) i, i2);
    }

    /* renamed from: a */
    public final void m405a(long j, int i) {
        m399a(10);
        if (j < -2147483648L || j > 2147483647L) {
            m400b((byte) 3, i);
            this.f501a.putLong(j);
            return;
        }
        m404a((int) j, i);
    }

    /* renamed from: a */
    public final void m408a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f502b);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        m399a(bytes.length + 10);
        if (bytes.length > 255) {
            m400b((byte) 7, i);
            this.f501a.putInt(bytes.length);
            this.f501a.put(bytes);
            return;
        }
        m400b((byte) 6, i);
        this.f501a.put((byte) bytes.length);
        this.f501a.put(bytes);
    }

    /* renamed from: a */
    public final <K, V> void m410a(Map<K, V> map, int i) {
        m399a(8);
        m400b((byte) 8, i);
        m404a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                m407a(entry.getKey(), 0);
                m407a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    public final void m413a(byte[] bArr, int i) {
        m399a(bArr.length + 8);
        m400b((byte) 13, i);
        m400b((byte) 0, 0);
        m404a(bArr.length, 0);
        this.f501a.put(bArr);
    }

    /* renamed from: a */
    public final <T> void m409a(Collection<T> collection, int i) {
        m399a(8);
        m400b((byte) 9, i);
        m404a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T a : collection) {
                m407a((Object) a, 0);
            }
        }
    }

    /* renamed from: a */
    public final void m406a(C0049j c0049j, int i) {
        m399a(2);
        m400b((byte) 10, i);
        c0049j.mo17a(this);
        m399a(2);
        m400b((byte) 11, 0);
    }

    /* renamed from: a */
    public final void m407a(Object obj, int i) {
        int i2 = 1;
        if (obj instanceof Byte) {
            m403a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                i2 = 0;
            }
            m403a((byte) i2, i);
        } else if (obj instanceof Short) {
            m411a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            m404a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            m405a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            m399a(6);
            m400b((byte) 4, i);
            this.f501a.putFloat(floatValue);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            m399a(10);
            m400b((byte) 5, i);
            this.f501a.putDouble(doubleValue);
        } else if (obj instanceof String) {
            m408a((String) obj, i);
        } else if (obj instanceof Map) {
            m410a((Map) obj, i);
        } else if (obj instanceof List) {
            m409a((List) obj, i);
        } else if (obj instanceof C0049j) {
            C0049j c0049j = (C0049j) obj;
            m399a(2);
            m400b((byte) 10, i);
            c0049j.mo17a(this);
            m399a(2);
            m400b((byte) 11, 0);
        } else if (obj instanceof byte[]) {
            m413a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            m399a(8);
            m400b((byte) 9, i);
            m404a(zArr.length, 0);
            for (boolean z : zArr) {
                m403a((byte) (z ? 1 : 0), 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            m399a(8);
            m400b((byte) 9, i);
            m404a(sArr.length, 0);
            for (short a : sArr) {
                m411a(a, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            m399a(8);
            m400b((byte) 9, i);
            m404a(iArr.length, 0);
            for (int a2 : iArr) {
                m404a(a2, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            m399a(8);
            m400b((byte) 9, i);
            m404a(jArr.length, 0);
            for (long a3 : jArr) {
                m405a(a3, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            m399a(8);
            m400b((byte) 9, i);
            m404a(fArr.length, 0);
            for (float f : fArr) {
                m399a(6);
                m400b((byte) 4, 0);
                this.f501a.putFloat(f);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            m399a(8);
            m400b((byte) 9, i);
            m404a(dArr.length, 0);
            for (double d : dArr) {
                m399a(10);
                m400b((byte) 5, 0);
                this.f501a.putDouble(d);
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            m399a(8);
            m400b((byte) 9, i);
            m404a(objArr.length, 0);
            for (Object a4 : objArr) {
                m407a(a4, 0);
            }
        } else if (obj instanceof Collection) {
            m409a((Collection) obj, i);
        } else {
            throw new C0050b("write object error: unsupport type. " + obj.getClass());
        }
    }

    /* renamed from: a */
    public final int m401a(String str) {
        this.f502b = str;
        return 0;
    }
}
