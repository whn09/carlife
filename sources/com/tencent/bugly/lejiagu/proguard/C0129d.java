package com.tencent.bugly.lejiagu.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.d */
public final class C0129d extends C0128c {
    /* renamed from: f */
    private static HashMap<String, byte[]> f1087f = null;
    /* renamed from: g */
    private static HashMap<String, HashMap<String, byte[]>> f1088g = null;
    /* renamed from: e */
    private C0131f f1089e = new C0131f();

    /* renamed from: a */
    public final <T> void mo43a(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
        super.mo43a(str, t);
    }

    /* renamed from: p */
    public final void mo46p() {
        super.mo46p();
        this.f1089e.f1094a = (short) 3;
    }

    /* renamed from: a */
    public final byte[] mo45a() {
        if (this.f1089e.f1094a != (short) 2) {
            if (this.f1089e.f1096c == null) {
                this.f1089e.f1096c = "";
            }
            if (this.f1089e.f1097d == null) {
                this.f1089e.f1097d = "";
            }
        } else if (this.f1089e.f1096c.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.f1089e.f1097d.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        C0135i c0135i = new C0135i(0);
        c0135i.m934a(this.b);
        if (this.f1089e.f1094a == (short) 2) {
            c0135i.m943a(this.a, 0);
        } else {
            c0135i.m943a(this.d, 0);
        }
        this.f1089e.f1098e = C0136k.m952a(c0135i.m935a());
        c0135i = new C0135i(0);
        c0135i.m934a(this.b);
        this.f1089e.mo40a(c0135i);
        byte[] a = C0136k.m952a(c0135i.m935a());
        int length = a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(a).flip();
        return allocate.array();
    }

    /* renamed from: a */
    public final void mo44a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            C0134h c0134h = new C0134h(bArr, 4);
            c0134h.m922a(this.b);
            this.f1089e.mo39a(c0134h);
            HashMap hashMap;
            if (this.f1089e.f1094a == (short) 3) {
                c0134h = new C0134h(this.f1089e.f1098e);
                c0134h.m922a(this.b);
                if (f1087f == null) {
                    hashMap = new HashMap();
                    f1087f = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.d = c0134h.m926a(f1087f, 0, false);
                return;
            }
            c0134h = new C0134h(this.f1089e.f1098e);
            c0134h.m922a(this.b);
            if (f1088g == null) {
                f1088g = new HashMap();
                hashMap = new HashMap();
                hashMap.put("", new byte[0]);
                f1088g.put("", hashMap);
            }
            this.a = c0134h.m926a(f1088g, 0, false);
            HashMap hashMap2 = new HashMap();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public final void m898b(String str) {
        this.f1089e.f1096c = str;
    }

    /* renamed from: c */
    public final void m899c(String str) {
        this.f1089e.f1097d = str;
    }

    /* renamed from: b */
    public final void m897b(int i) {
        this.f1089e.f1095b = 1;
    }
}
