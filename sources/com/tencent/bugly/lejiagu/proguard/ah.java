package com.tencent.bugly.lejiagu.proguard;

/* compiled from: BUGLY */
public final class ah extends C0126j implements Cloneable {
    /* renamed from: d */
    private static byte[] f980d;
    /* renamed from: a */
    private byte f981a = (byte) 0;
    /* renamed from: b */
    private String f982b = "";
    /* renamed from: c */
    private byte[] f983c = null;

    public ah(byte b, String str, byte[] bArr) {
        this.f981a = b;
        this.f982b = str;
        this.f983c = bArr;
    }

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m936a(this.f981a, 0);
        c0135i.m941a(this.f982b, 1);
        if (this.f983c != null) {
            c0135i.m946a(this.f983c, 2);
        }
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        byte[] bArr;
        this.f981a = c0134h.m920a(this.f981a, 0, true);
        this.f982b = c0134h.m930b(1, true);
        if (f980d == null) {
            bArr = new byte[1];
            f980d = bArr;
            bArr[0] = (byte) 0;
        }
        bArr = f980d;
        this.f983c = c0134h.m931c(2, false);
    }

    /* renamed from: a */
    public final void mo41a(StringBuilder stringBuilder, int i) {
    }
}
