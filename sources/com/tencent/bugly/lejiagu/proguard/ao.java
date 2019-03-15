package com.tencent.bugly.lejiagu.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ao extends C0126j {
    /* renamed from: i */
    private static Map<String, String> f1068i = new HashMap();
    /* renamed from: a */
    public long f1069a = 0;
    /* renamed from: b */
    public byte f1070b = (byte) 0;
    /* renamed from: c */
    public String f1071c = "";
    /* renamed from: d */
    public String f1072d = "";
    /* renamed from: e */
    public String f1073e = "";
    /* renamed from: f */
    public Map<String, String> f1074f = null;
    /* renamed from: g */
    public String f1075g = "";
    /* renamed from: h */
    public boolean f1076h = true;

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m938a(this.f1069a, 0);
        c0135i.m936a(this.f1070b, 1);
        if (this.f1071c != null) {
            c0135i.m941a(this.f1071c, 2);
        }
        if (this.f1072d != null) {
            c0135i.m941a(this.f1072d, 3);
        }
        if (this.f1073e != null) {
            c0135i.m941a(this.f1073e, 4);
        }
        if (this.f1074f != null) {
            c0135i.m943a(this.f1074f, 5);
        }
        if (this.f1075g != null) {
            c0135i.m941a(this.f1075g, 6);
        }
        c0135i.m945a(this.f1076h, 7);
    }

    static {
        f1068i.put("", "");
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        this.f1069a = c0134h.m923a(this.f1069a, 0, true);
        this.f1070b = c0134h.m920a(this.f1070b, 1, true);
        this.f1071c = c0134h.m930b(2, false);
        this.f1072d = c0134h.m930b(3, false);
        this.f1073e = c0134h.m930b(4, false);
        this.f1074f = (Map) c0134h.m925a(f1068i, 5, false);
        this.f1075g = c0134h.m930b(6, false);
        boolean z = this.f1076h;
        this.f1076h = c0134h.m929a(7, false);
    }
}
