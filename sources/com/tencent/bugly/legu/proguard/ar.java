package com.tencent.bugly.legu.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ar extends C0049j implements Cloneable {
    /* renamed from: f */
    private static ArrayList<aq> f470f;
    /* renamed from: g */
    private static Map<String, String> f471g;
    /* renamed from: a */
    public byte f472a = (byte) 0;
    /* renamed from: b */
    public String f473b = "";
    /* renamed from: c */
    public String f474c = "";
    /* renamed from: d */
    public ArrayList<aq> f475d = null;
    /* renamed from: e */
    public Map<String, String> f476e = null;

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m403a(this.f472a, 0);
        if (this.f473b != null) {
            c0058i.m408a(this.f473b, 1);
        }
        if (this.f474c != null) {
            c0058i.m408a(this.f474c, 2);
        }
        if (this.f475d != null) {
            c0058i.m409a(this.f475d, 3);
        }
        if (this.f476e != null) {
            c0058i.m410a(this.f476e, 4);
        }
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        this.f472a = c0057h.m387a(this.f472a, 0, true);
        this.f473b = c0057h.m397b(1, false);
        this.f474c = c0057h.m397b(2, false);
        if (f470f == null) {
            f470f = new ArrayList();
            f470f.add(new aq());
        }
        this.f475d = (ArrayList) c0057h.m392a(f470f, 3, false);
        if (f471g == null) {
            f471g = new HashMap();
            f471g.put("", "");
        }
        this.f476e = (Map) c0057h.m392a(f471g, 4, false);
    }

    /* renamed from: a */
    public final void mo18a(StringBuilder stringBuilder, int i) {
    }
}
