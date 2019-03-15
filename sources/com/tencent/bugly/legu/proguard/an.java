package com.tencent.bugly.legu.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class an extends C0049j {
    /* renamed from: i */
    private static byte[] f434i;
    /* renamed from: j */
    private static Map<String, String> f435j = new HashMap();
    /* renamed from: a */
    public byte f436a = (byte) 0;
    /* renamed from: b */
    public int f437b = 0;
    /* renamed from: c */
    public byte[] f438c = null;
    /* renamed from: d */
    public String f439d = "";
    /* renamed from: e */
    public long f440e = 0;
    /* renamed from: f */
    public String f441f = "";
    /* renamed from: g */
    public String f442g = "";
    /* renamed from: h */
    public Map<String, String> f443h = null;

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m403a(this.f436a, 0);
        c0058i.m404a(this.f437b, 1);
        if (this.f438c != null) {
            c0058i.m413a(this.f438c, 2);
        }
        if (this.f439d != null) {
            c0058i.m408a(this.f439d, 3);
        }
        c0058i.m405a(this.f440e, 4);
        if (this.f441f != null) {
            c0058i.m408a(this.f441f, 5);
        }
        if (this.f442g != null) {
            c0058i.m408a(this.f442g, 6);
        }
        if (this.f443h != null) {
            c0058i.m410a(this.f443h, 7);
        }
    }

    static {
        byte[] bArr = new byte[1];
        f434i = bArr;
        bArr[0] = (byte) 0;
        f435j.put("", "");
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        this.f436a = c0057h.m387a(this.f436a, 0, true);
        this.f437b = c0057h.m388a(this.f437b, 1, true);
        byte[] bArr = f434i;
        this.f438c = c0057h.m398c(2, false);
        this.f439d = c0057h.m397b(3, false);
        this.f440e = c0057h.m390a(this.f440e, 4, false);
        this.f441f = c0057h.m397b(5, false);
        this.f442g = c0057h.m397b(6, false);
        this.f443h = (Map) c0057h.m392a(f435j, 7, false);
    }
}
