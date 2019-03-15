package com.tencent.bugly.lejiagu.proguard;

import java.util.ArrayList;

/* compiled from: BUGLY */
public final class ag extends C0126j implements Cloneable {
    /* renamed from: c */
    private static ArrayList<String> f977c;
    /* renamed from: a */
    private String f978a = "";
    /* renamed from: b */
    private ArrayList<String> f979b = null;

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m941a(this.f978a, 0);
        if (this.f979b != null) {
            c0135i.m942a(this.f979b, 1);
        }
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        this.f978a = c0134h.m930b(0, true);
        if (f977c == null) {
            f977c = new ArrayList();
            f977c.add("");
        }
        this.f979b = (ArrayList) c0134h.m925a(f977c, 1, false);
    }

    /* renamed from: a */
    public final void mo41a(StringBuilder stringBuilder, int i) {
    }
}
