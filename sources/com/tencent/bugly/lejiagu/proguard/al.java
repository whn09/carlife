package com.tencent.bugly.lejiagu.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class al extends C0126j {
    /* renamed from: i */
    private static byte[] f1041i;
    /* renamed from: j */
    private static Map<String, String> f1042j = new HashMap();
    /* renamed from: a */
    public byte f1043a = (byte) 0;
    /* renamed from: b */
    public int f1044b = 0;
    /* renamed from: c */
    public byte[] f1045c = null;
    /* renamed from: d */
    public String f1046d = "";
    /* renamed from: e */
    public long f1047e = 0;
    /* renamed from: f */
    public String f1048f = "";
    /* renamed from: g */
    public String f1049g = "";
    /* renamed from: h */
    public Map<String, String> f1050h = null;

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m936a(this.f1043a, 0);
        c0135i.m937a(this.f1044b, 1);
        if (this.f1045c != null) {
            c0135i.m946a(this.f1045c, 2);
        }
        if (this.f1046d != null) {
            c0135i.m941a(this.f1046d, 3);
        }
        c0135i.m938a(this.f1047e, 4);
        if (this.f1048f != null) {
            c0135i.m941a(this.f1048f, 5);
        }
        if (this.f1049g != null) {
            c0135i.m941a(this.f1049g, 6);
        }
        if (this.f1050h != null) {
            c0135i.m943a(this.f1050h, 7);
        }
    }

    static {
        byte[] bArr = new byte[1];
        f1041i = bArr;
        bArr[0] = (byte) 0;
        f1042j.put("", "");
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        this.f1043a = c0134h.m920a(this.f1043a, 0, true);
        this.f1044b = c0134h.m921a(this.f1044b, 1, true);
        byte[] bArr = f1041i;
        this.f1045c = c0134h.m931c(2, false);
        this.f1046d = c0134h.m930b(3, false);
        this.f1047e = c0134h.m923a(this.f1047e, 4, false);
        this.f1048f = c0134h.m930b(5, false);
        this.f1049g = c0134h.m930b(6, false);
        this.f1050h = (Map) c0134h.m925a(f1042j, 7, false);
    }
}
