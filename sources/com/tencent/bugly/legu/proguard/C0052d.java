package com.tencent.bugly.legu.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.d */
public final class C0052d extends C0051c {
    /* renamed from: f */
    private static HashMap<String, byte[]> f480f = null;
    /* renamed from: g */
    private static HashMap<String, HashMap<String, byte[]>> f481g = null;
    /* renamed from: e */
    private C0054f f482e = new C0054f();

    /* renamed from: a */
    public final <T> void mo20a(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
        super.mo20a(str, t);
    }

    /* renamed from: p */
    public final void mo23p() {
        super.mo23p();
        this.f482e.f487a = (short) 3;
    }

    /* renamed from: a */
    public final byte[] mo22a() {
        if (this.f482e.f487a != (short) 2) {
            if (this.f482e.f489c == null) {
                this.f482e.f489c = "";
            }
            if (this.f482e.f490d == null) {
                this.f482e.f490d = "";
            }
        } else if (this.f482e.f489c.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.f482e.f490d.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        C0058i c0058i = new C0058i(0);
        c0058i.m401a(this.b);
        if (this.f482e.f487a == (short) 2) {
            c0058i.m410a(this.a, 0);
        } else {
            c0058i.m410a(this.d, 0);
        }
        this.f482e.f491e = C0059k.m419a(c0058i.m402a());
        c0058i = new C0058i(0);
        c0058i.m401a(this.b);
        this.f482e.mo17a(c0058i);
        byte[] a = C0059k.m419a(c0058i.m402a());
        int length = a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(a).flip();
        return allocate.array();
    }

    /* renamed from: a */
    public final void mo21a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            C0057h c0057h = new C0057h(bArr, 4);
            c0057h.m389a(this.b);
            this.f482e.mo16a(c0057h);
            HashMap hashMap;
            if (this.f482e.f487a == (short) 3) {
                c0057h = new C0057h(this.f482e.f491e);
                c0057h.m389a(this.b);
                if (f480f == null) {
                    hashMap = new HashMap();
                    f480f = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.d = c0057h.m393a(f480f, 0, false);
                return;
            }
            c0057h = new C0057h(this.f482e.f491e);
            c0057h.m389a(this.b);
            if (f481g == null) {
                f481g = new HashMap();
                hashMap = new HashMap();
                hashMap.put("", new byte[0]);
                f481g.put("", hashMap);
            }
            this.a = c0057h.m393a(f481g, 0, false);
            HashMap hashMap2 = new HashMap();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public final void m365b(String str) {
        this.f482e.f489c = str;
    }

    /* renamed from: c */
    public final void m366c(String str) {
        this.f482e.f490d = str;
    }

    /* renamed from: b */
    public final void m364b(int i) {
        this.f482e.f488b = 1;
    }
}
