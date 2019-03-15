package com.tencent.bugly.legu.proguard;

import java.util.ArrayList;

/* compiled from: BUGLY */
public final class ai extends C0049j implements Cloneable {
    /* renamed from: c */
    private static ArrayList<String> f370c;
    /* renamed from: a */
    private String f371a = "";
    /* renamed from: b */
    private ArrayList<String> f372b = null;

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m408a(this.f371a, 0);
        if (this.f372b != null) {
            c0058i.m409a(this.f372b, 1);
        }
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        this.f371a = c0057h.m397b(0, true);
        if (f370c == null) {
            f370c = new ArrayList();
            f370c.add("");
        }
        this.f372b = (ArrayList) c0057h.m392a(f370c, 1, false);
    }

    /* renamed from: a */
    public final void mo18a(StringBuilder stringBuilder, int i) {
    }
}
