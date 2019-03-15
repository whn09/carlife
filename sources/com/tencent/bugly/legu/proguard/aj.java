package com.tencent.bugly.legu.proguard;

/* compiled from: BUGLY */
public final class aj extends C0049j implements Cloneable {
    /* renamed from: d */
    private static byte[] f373d;
    /* renamed from: a */
    private byte f374a = (byte) 0;
    /* renamed from: b */
    private String f375b = "";
    /* renamed from: c */
    private byte[] f376c = null;

    public aj(byte b, String str, byte[] bArr) {
        this.f374a = b;
        this.f375b = str;
        this.f376c = bArr;
    }

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m403a(this.f374a, 0);
        c0058i.m408a(this.f375b, 1);
        if (this.f376c != null) {
            c0058i.m413a(this.f376c, 2);
        }
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        byte[] bArr;
        this.f374a = c0057h.m387a(this.f374a, 0, true);
        this.f375b = c0057h.m397b(1, true);
        if (f373d == null) {
            bArr = new byte[1];
            f373d = bArr;
            bArr[0] = (byte) 0;
        }
        bArr = f373d;
        this.f376c = c0057h.m398c(2, false);
    }

    /* renamed from: a */
    public final void mo18a(StringBuilder stringBuilder, int i) {
    }
}
