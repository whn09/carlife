package com.tencent.bugly.lejiagu.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ai extends C0126j {
    /* renamed from: A */
    private static ArrayList<ah> f984A = new ArrayList();
    /* renamed from: B */
    private static Map<String, String> f985B = new HashMap();
    /* renamed from: C */
    private static Map<String, String> f986C = new HashMap();
    /* renamed from: v */
    private static Map<String, String> f987v = new HashMap();
    /* renamed from: w */
    private static ag f988w = new ag();
    /* renamed from: x */
    private static af f989x = new af();
    /* renamed from: y */
    private static ArrayList<af> f990y = new ArrayList();
    /* renamed from: z */
    private static ArrayList<af> f991z = new ArrayList();
    /* renamed from: a */
    public String f992a = "";
    /* renamed from: b */
    public long f993b = 0;
    /* renamed from: c */
    public String f994c = "";
    /* renamed from: d */
    public String f995d = "";
    /* renamed from: e */
    public String f996e = "";
    /* renamed from: f */
    public String f997f = "";
    /* renamed from: g */
    public String f998g = "";
    /* renamed from: h */
    public Map<String, String> f999h = null;
    /* renamed from: i */
    public String f1000i = "";
    /* renamed from: j */
    public ag f1001j = null;
    /* renamed from: k */
    public int f1002k = 0;
    /* renamed from: l */
    public String f1003l = "";
    /* renamed from: m */
    public String f1004m = "";
    /* renamed from: n */
    public af f1005n = null;
    /* renamed from: o */
    public ArrayList<af> f1006o = null;
    /* renamed from: p */
    public ArrayList<af> f1007p = null;
    /* renamed from: q */
    public ArrayList<ah> f1008q = null;
    /* renamed from: r */
    public Map<String, String> f1009r = null;
    /* renamed from: s */
    public Map<String, String> f1010s = null;
    /* renamed from: t */
    public String f1011t = "";
    /* renamed from: u */
    private boolean f1012u = true;

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m941a(this.f992a, 0);
        c0135i.m938a(this.f993b, 1);
        c0135i.m941a(this.f994c, 2);
        if (this.f995d != null) {
            c0135i.m941a(this.f995d, 3);
        }
        if (this.f996e != null) {
            c0135i.m941a(this.f996e, 4);
        }
        if (this.f997f != null) {
            c0135i.m941a(this.f997f, 5);
        }
        if (this.f998g != null) {
            c0135i.m941a(this.f998g, 6);
        }
        if (this.f999h != null) {
            c0135i.m943a(this.f999h, 7);
        }
        if (this.f1000i != null) {
            c0135i.m941a(this.f1000i, 8);
        }
        if (this.f1001j != null) {
            c0135i.m939a(this.f1001j, 9);
        }
        c0135i.m937a(this.f1002k, 10);
        if (this.f1003l != null) {
            c0135i.m941a(this.f1003l, 11);
        }
        if (this.f1004m != null) {
            c0135i.m941a(this.f1004m, 12);
        }
        if (this.f1005n != null) {
            c0135i.m939a(this.f1005n, 13);
        }
        if (this.f1006o != null) {
            c0135i.m942a(this.f1006o, 14);
        }
        if (this.f1007p != null) {
            c0135i.m942a(this.f1007p, 15);
        }
        if (this.f1008q != null) {
            c0135i.m942a(this.f1008q, 16);
        }
        if (this.f1009r != null) {
            c0135i.m943a(this.f1009r, 17);
        }
        if (this.f1010s != null) {
            c0135i.m943a(this.f1010s, 18);
        }
        if (this.f1011t != null) {
            c0135i.m941a(this.f1011t, 19);
        }
        c0135i.m945a(this.f1012u, 20);
    }

    static {
        f987v.put("", "");
        f990y.add(new af());
        f991z.add(new af());
        f984A.add(new ah());
        f985B.put("", "");
        f986C.put("", "");
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        this.f992a = c0134h.m930b(0, true);
        this.f993b = c0134h.m923a(this.f993b, 1, true);
        this.f994c = c0134h.m930b(2, true);
        this.f995d = c0134h.m930b(3, false);
        this.f996e = c0134h.m930b(4, false);
        this.f997f = c0134h.m930b(5, false);
        this.f998g = c0134h.m930b(6, false);
        this.f999h = (Map) c0134h.m925a(f987v, 7, false);
        this.f1000i = c0134h.m930b(8, false);
        this.f1001j = (ag) c0134h.m924a(f988w, 9, false);
        this.f1002k = c0134h.m921a(this.f1002k, 10, false);
        this.f1003l = c0134h.m930b(11, false);
        this.f1004m = c0134h.m930b(12, false);
        this.f1005n = (af) c0134h.m924a(f989x, 13, false);
        this.f1006o = (ArrayList) c0134h.m925a(f990y, 14, false);
        this.f1007p = (ArrayList) c0134h.m925a(f991z, 15, false);
        this.f1008q = (ArrayList) c0134h.m925a(f984A, 16, false);
        this.f1009r = (Map) c0134h.m925a(f985B, 17, false);
        this.f1010s = (Map) c0134h.m925a(f986C, 18, false);
        this.f1011t = c0134h.m930b(19, false);
        boolean z = this.f1012u;
        this.f1012u = c0134h.m929a(20, false);
    }
}
