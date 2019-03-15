package com.tencent.bugly.legu.proguard;

import com.tencent.bugly.legu.crashreport.crash.jni.C0047b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ap extends C0049j implements Cloneable {
    /* renamed from: m */
    private static ao f446m = new ao();
    /* renamed from: n */
    private static Map<String, String> f447n = new HashMap();
    /* renamed from: o */
    private static /* synthetic */ boolean f448o;
    /* renamed from: a */
    public boolean f449a = true;
    /* renamed from: b */
    public boolean f450b = true;
    /* renamed from: c */
    public boolean f451c = true;
    /* renamed from: d */
    public String f452d = "";
    /* renamed from: e */
    public String f453e = "";
    /* renamed from: f */
    public ao f454f = null;
    /* renamed from: g */
    public Map<String, String> f455g = null;
    /* renamed from: h */
    public long f456h = 0;
    /* renamed from: i */
    public int f457i = 0;
    /* renamed from: j */
    private String f458j = "";
    /* renamed from: k */
    private String f459k = "";
    /* renamed from: l */
    private int f460l = 0;

    static {
        boolean z;
        if (ap.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f448o = z;
        f447n.put("", "");
    }

    public final boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        ap apVar = (ap) o;
        if (C0059k.m418a(this.f449a, apVar.f449a) && C0059k.m418a(this.f450b, apVar.f450b) && C0059k.m418a(this.f451c, apVar.f451c) && C0059k.m417a(this.f452d, apVar.f452d) && C0059k.m417a(this.f453e, apVar.f453e) && C0059k.m417a(this.f454f, apVar.f454f) && C0059k.m417a(this.f455g, apVar.f455g) && C0059k.m416a(this.f456h, apVar.f456h) && C0059k.m417a(this.f458j, apVar.f458j) && C0059k.m417a(this.f459k, apVar.f459k) && C0059k.m415a(this.f460l, apVar.f460l) && C0059k.m415a(this.f457i, apVar.f457i)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!f448o) {
                throw new AssertionError();
            }
        }
        return obj;
    }

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m412a(this.f449a, 0);
        c0058i.m412a(this.f450b, 1);
        c0058i.m412a(this.f451c, 2);
        if (this.f452d != null) {
            c0058i.m408a(this.f452d, 3);
        }
        if (this.f453e != null) {
            c0058i.m408a(this.f453e, 4);
        }
        if (this.f454f != null) {
            c0058i.m406a(this.f454f, 5);
        }
        if (this.f455g != null) {
            c0058i.m410a(this.f455g, 6);
        }
        c0058i.m405a(this.f456h, 7);
        if (this.f458j != null) {
            c0058i.m408a(this.f458j, 8);
        }
        if (this.f459k != null) {
            c0058i.m408a(this.f459k, 9);
        }
        c0058i.m404a(this.f460l, 10);
        c0058i.m404a(this.f457i, 11);
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        boolean z = this.f449a;
        this.f449a = c0057h.m396a(0, true);
        z = this.f450b;
        this.f450b = c0057h.m396a(1, true);
        z = this.f451c;
        this.f451c = c0057h.m396a(2, true);
        this.f452d = c0057h.m397b(3, false);
        this.f453e = c0057h.m397b(4, false);
        this.f454f = (ao) c0057h.m391a(f446m, 5, false);
        this.f455g = (Map) c0057h.m392a(f447n, 6, false);
        this.f456h = c0057h.m390a(this.f456h, 7, false);
        this.f458j = c0057h.m397b(8, false);
        this.f459k = c0057h.m397b(9, false);
        this.f460l = c0057h.m388a(this.f460l, 10, false);
        this.f457i = c0057h.m388a(this.f457i, 11, false);
    }

    /* renamed from: a */
    public final void mo18a(StringBuilder stringBuilder, int i) {
        C0047b c0047b = new C0047b(stringBuilder, i);
        c0047b.m242a(this.f449a, "enable");
        c0047b.m242a(this.f450b, "enableUserInfo");
        c0047b.m242a(this.f451c, "enableQuery");
        c0047b.m238a(this.f452d, "url");
        c0047b.m238a(this.f453e, "expUrl");
        c0047b.m236a(this.f454f, "security");
        c0047b.m240a(this.f455g, "valueMap");
        c0047b.m235a(this.f456h, "strategylastUpdateTime");
        c0047b.m238a(this.f458j, "httpsUrl");
        c0047b.m238a(this.f459k, "httpsExpUrl");
        c0047b.m234a(this.f460l, "eventRecordCount");
        c0047b.m234a(this.f457i, "eventTimeInterval");
    }
}
