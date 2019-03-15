package com.tencent.bugly.lejiagu.proguard;

import com.tencent.bugly.lejiagu.crashreport.crash.jni.C0123b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class an extends C0126j implements Cloneable {
    /* renamed from: m */
    private static am f1053m = new am();
    /* renamed from: n */
    private static Map<String, String> f1054n = new HashMap();
    /* renamed from: o */
    private static /* synthetic */ boolean f1055o;
    /* renamed from: a */
    public boolean f1056a = true;
    /* renamed from: b */
    public boolean f1057b = true;
    /* renamed from: c */
    public boolean f1058c = true;
    /* renamed from: d */
    public String f1059d = "";
    /* renamed from: e */
    public String f1060e = "";
    /* renamed from: f */
    public am f1061f = null;
    /* renamed from: g */
    public Map<String, String> f1062g = null;
    /* renamed from: h */
    public long f1063h = 0;
    /* renamed from: i */
    public int f1064i = 0;
    /* renamed from: j */
    private String f1065j = "";
    /* renamed from: k */
    private String f1066k = "";
    /* renamed from: l */
    private int f1067l = 0;

    static {
        boolean z;
        if (an.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f1055o = z;
        f1054n.put("", "");
    }

    public final boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        an anVar = (an) o;
        if (C0136k.m951a(this.f1056a, anVar.f1056a) && C0136k.m951a(this.f1057b, anVar.f1057b) && C0136k.m951a(this.f1058c, anVar.f1058c) && C0136k.m950a(this.f1059d, anVar.f1059d) && C0136k.m950a(this.f1060e, anVar.f1060e) && C0136k.m950a(this.f1061f, anVar.f1061f) && C0136k.m950a(this.f1062g, anVar.f1062g) && C0136k.m949a(this.f1063h, anVar.f1063h) && C0136k.m950a(this.f1065j, anVar.f1065j) && C0136k.m950a(this.f1066k, anVar.f1066k) && C0136k.m948a(this.f1067l, anVar.f1067l) && C0136k.m948a(this.f1064i, anVar.f1064i)) {
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
            if (!f1055o) {
                throw new AssertionError();
            }
        }
        return obj;
    }

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m945a(this.f1056a, 0);
        c0135i.m945a(this.f1057b, 1);
        c0135i.m945a(this.f1058c, 2);
        if (this.f1059d != null) {
            c0135i.m941a(this.f1059d, 3);
        }
        if (this.f1060e != null) {
            c0135i.m941a(this.f1060e, 4);
        }
        if (this.f1061f != null) {
            c0135i.m939a(this.f1061f, 5);
        }
        if (this.f1062g != null) {
            c0135i.m943a(this.f1062g, 6);
        }
        c0135i.m938a(this.f1063h, 7);
        if (this.f1065j != null) {
            c0135i.m941a(this.f1065j, 8);
        }
        if (this.f1066k != null) {
            c0135i.m941a(this.f1066k, 9);
        }
        c0135i.m937a(this.f1067l, 10);
        c0135i.m937a(this.f1064i, 11);
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        boolean z = this.f1056a;
        this.f1056a = c0134h.m929a(0, true);
        z = this.f1057b;
        this.f1057b = c0134h.m929a(1, true);
        z = this.f1058c;
        this.f1058c = c0134h.m929a(2, true);
        this.f1059d = c0134h.m930b(3, false);
        this.f1060e = c0134h.m930b(4, false);
        this.f1061f = (am) c0134h.m924a(f1053m, 5, false);
        this.f1062g = (Map) c0134h.m925a(f1054n, 6, false);
        this.f1063h = c0134h.m923a(this.f1063h, 7, false);
        this.f1065j = c0134h.m930b(8, false);
        this.f1066k = c0134h.m930b(9, false);
        this.f1067l = c0134h.m921a(this.f1067l, 10, false);
        this.f1064i = c0134h.m921a(this.f1064i, 11, false);
    }

    /* renamed from: a */
    public final void mo41a(StringBuilder stringBuilder, int i) {
        C0123b c0123b = new C0123b(stringBuilder, i);
        c0123b.m776a(this.f1056a, "enable");
        c0123b.m776a(this.f1057b, "enableUserInfo");
        c0123b.m776a(this.f1058c, "enableQuery");
        c0123b.m772a(this.f1059d, "url");
        c0123b.m772a(this.f1060e, "expUrl");
        c0123b.m770a(this.f1061f, "security");
        c0123b.m774a(this.f1062g, "valueMap");
        c0123b.m769a(this.f1063h, "strategylastUpdateTime");
        c0123b.m772a(this.f1065j, "httpsUrl");
        c0123b.m772a(this.f1066k, "httpsExpUrl");
        c0123b.m768a(this.f1067l, "eventRecordCount");
        c0123b.m768a(this.f1064i, "eventTimeInterval");
    }
}
