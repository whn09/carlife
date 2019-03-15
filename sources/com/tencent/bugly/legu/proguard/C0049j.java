package com.tencent.bugly.legu.proguard;

import java.io.Serializable;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.j */
public abstract class C0049j implements Serializable {
    /* renamed from: a */
    public abstract void mo16a(C0057h c0057h);

    /* renamed from: a */
    public abstract void mo17a(C0058i c0058i);

    /* renamed from: a */
    public abstract void mo18a(StringBuilder stringBuilder, int i);

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        mo18a(stringBuilder, 0);
        return stringBuilder.toString();
    }
}
