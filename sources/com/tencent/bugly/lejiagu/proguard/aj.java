package com.tencent.bugly.lejiagu.proguard;

import java.util.ArrayList;

/* compiled from: BUGLY */
public final class aj extends C0126j implements Cloneable {
    /* renamed from: b */
    private static ArrayList<ai> f1013b;
    /* renamed from: a */
    public ArrayList<ai> f1014a = null;

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m942a(this.f1014a, 0);
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        if (f1013b == null) {
            f1013b = new ArrayList();
            f1013b.add(new ai());
        }
        this.f1014a = (ArrayList) c0134h.m925a(f1013b, 0, true);
    }

    /* renamed from: a */
    public final void mo41a(StringBuilder stringBuilder, int i) {
    }
}
