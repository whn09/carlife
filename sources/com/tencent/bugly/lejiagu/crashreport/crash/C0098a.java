package com.tencent.bugly.lejiagu.crashreport.crash;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.a */
public final class C0098a implements Comparable<C0098a> {
    /* renamed from: a */
    public long f828a = -1;
    /* renamed from: b */
    public long f829b = -1;
    /* renamed from: c */
    public String f830c = null;
    /* renamed from: d */
    public boolean f831d = false;
    /* renamed from: e */
    public boolean f832e = false;
    /* renamed from: f */
    public int f833f = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C0098a c0098a = (C0098a) obj;
        if (c0098a != null) {
            long j = this.f829b - c0098a.f829b;
            if (j <= 0) {
                return j < 0 ? -1 : 0;
            }
        }
        return 1;
    }
}
