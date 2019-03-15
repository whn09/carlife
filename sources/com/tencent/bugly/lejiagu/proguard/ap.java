package com.tencent.bugly.lejiagu.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ap extends C0126j implements Cloneable {
    /* renamed from: f */
    private static ArrayList<ao> f1077f;
    /* renamed from: g */
    private static Map<String, String> f1078g;
    /* renamed from: a */
    public byte f1079a = (byte) 0;
    /* renamed from: b */
    public String f1080b = "";
    /* renamed from: c */
    public String f1081c = "";
    /* renamed from: d */
    public ArrayList<ao> f1082d = null;
    /* renamed from: e */
    public Map<String, String> f1083e = null;

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m936a(this.f1079a, 0);
        if (this.f1080b != null) {
            c0135i.m941a(this.f1080b, 1);
        }
        if (this.f1081c != null) {
            c0135i.m941a(this.f1081c, 2);
        }
        if (this.f1082d != null) {
            c0135i.m942a(this.f1082d, 3);
        }
        if (this.f1083e != null) {
            c0135i.m943a(this.f1083e, 4);
        }
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        this.f1079a = c0134h.m920a(this.f1079a, 0, true);
        this.f1080b = c0134h.m930b(1, false);
        this.f1081c = c0134h.m930b(2, false);
        if (f1077f == null) {
            f1077f = new ArrayList();
            f1077f.add(new ao());
        }
        this.f1082d = (ArrayList) c0134h.m925a(f1077f, 3, false);
        if (f1078g == null) {
            f1078g = new HashMap();
            f1078g.put("", "");
        }
        this.f1083e = (Map) c0134h.m925a(f1078g, 4, false);
    }

    /* renamed from: a */
    public final void mo41a(StringBuilder stringBuilder, int i) {
    }
}
