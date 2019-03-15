package com.tencent.bugly.legu.proguard;

import java.util.ArrayList;

/* compiled from: BUGLY */
public final class al extends C0049j implements Cloneable {
    /* renamed from: b */
    private static ArrayList<ak> f406b;
    /* renamed from: a */
    public ArrayList<ak> f407a = null;

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m409a(this.f407a, 0);
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        if (f406b == null) {
            f406b = new ArrayList();
            f406b.add(new ak());
        }
        this.f407a = (ArrayList) c0057h.m392a(f406b, 0, true);
    }

    /* renamed from: a */
    public final void mo18a(StringBuilder stringBuilder, int i) {
    }
}
