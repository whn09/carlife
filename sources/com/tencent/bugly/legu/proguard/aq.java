package com.tencent.bugly.legu.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class aq extends C0049j {
    /* renamed from: i */
    private static Map<String, String> f461i = new HashMap();
    /* renamed from: a */
    public long f462a = 0;
    /* renamed from: b */
    public byte f463b = (byte) 0;
    /* renamed from: c */
    public String f464c = "";
    /* renamed from: d */
    public String f465d = "";
    /* renamed from: e */
    public String f466e = "";
    /* renamed from: f */
    public Map<String, String> f467f = null;
    /* renamed from: g */
    public String f468g = "";
    /* renamed from: h */
    public boolean f469h = true;

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m405a(this.f462a, 0);
        c0058i.m403a(this.f463b, 1);
        if (this.f464c != null) {
            c0058i.m408a(this.f464c, 2);
        }
        if (this.f465d != null) {
            c0058i.m408a(this.f465d, 3);
        }
        if (this.f466e != null) {
            c0058i.m408a(this.f466e, 4);
        }
        if (this.f467f != null) {
            c0058i.m410a(this.f467f, 5);
        }
        if (this.f468g != null) {
            c0058i.m408a(this.f468g, 6);
        }
        c0058i.m412a(this.f469h, 7);
    }

    static {
        f461i.put("", "");
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        this.f462a = c0057h.m390a(this.f462a, 0, true);
        this.f463b = c0057h.m387a(this.f463b, 1, true);
        this.f464c = c0057h.m397b(2, false);
        this.f465d = c0057h.m397b(3, false);
        this.f466e = c0057h.m397b(4, false);
        this.f467f = (Map) c0057h.m392a(f461i, 5, false);
        this.f468g = c0057h.m397b(6, false);
        boolean z = this.f469h;
        this.f469h = c0057h.m396a(7, false);
    }
}
