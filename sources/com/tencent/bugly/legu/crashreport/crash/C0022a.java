package com.tencent.bugly.legu.crashreport.crash;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.crash.a */
public final class C0022a implements Comparable<C0022a> {
    /* renamed from: a */
    public long f221a = -1;
    /* renamed from: b */
    public long f222b = -1;
    /* renamed from: c */
    public String f223c = null;
    /* renamed from: d */
    public boolean f224d = false;
    /* renamed from: e */
    public boolean f225e = false;
    /* renamed from: f */
    public int f226f = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C0022a c0022a = (C0022a) obj;
        if (c0022a != null) {
            long j = this.f222b - c0022a.f222b;
            if (j <= 0) {
                return j < 0 ? -1 : 0;
            }
        }
        return 1;
    }
}
