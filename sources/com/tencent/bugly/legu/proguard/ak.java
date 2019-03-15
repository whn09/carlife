package com.tencent.bugly.legu.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ak extends C0049j {
    /* renamed from: A */
    private static ArrayList<aj> f377A = new ArrayList();
    /* renamed from: B */
    private static Map<String, String> f378B = new HashMap();
    /* renamed from: C */
    private static Map<String, String> f379C = new HashMap();
    /* renamed from: v */
    private static Map<String, String> f380v = new HashMap();
    /* renamed from: w */
    private static ai f381w = new ai();
    /* renamed from: x */
    private static ah f382x = new ah();
    /* renamed from: y */
    private static ArrayList<ah> f383y = new ArrayList();
    /* renamed from: z */
    private static ArrayList<ah> f384z = new ArrayList();
    /* renamed from: a */
    public String f385a = "";
    /* renamed from: b */
    public long f386b = 0;
    /* renamed from: c */
    public String f387c = "";
    /* renamed from: d */
    public String f388d = "";
    /* renamed from: e */
    public String f389e = "";
    /* renamed from: f */
    public String f390f = "";
    /* renamed from: g */
    public String f391g = "";
    /* renamed from: h */
    public Map<String, String> f392h = null;
    /* renamed from: i */
    public String f393i = "";
    /* renamed from: j */
    public ai f394j = null;
    /* renamed from: k */
    public int f395k = 0;
    /* renamed from: l */
    public String f396l = "";
    /* renamed from: m */
    public String f397m = "";
    /* renamed from: n */
    public ah f398n = null;
    /* renamed from: o */
    public ArrayList<ah> f399o = null;
    /* renamed from: p */
    public ArrayList<ah> f400p = null;
    /* renamed from: q */
    public ArrayList<aj> f401q = null;
    /* renamed from: r */
    public Map<String, String> f402r = null;
    /* renamed from: s */
    public Map<String, String> f403s = null;
    /* renamed from: t */
    public String f404t = "";
    /* renamed from: u */
    private boolean f405u = true;

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m408a(this.f385a, 0);
        c0058i.m405a(this.f386b, 1);
        c0058i.m408a(this.f387c, 2);
        if (this.f388d != null) {
            c0058i.m408a(this.f388d, 3);
        }
        if (this.f389e != null) {
            c0058i.m408a(this.f389e, 4);
        }
        if (this.f390f != null) {
            c0058i.m408a(this.f390f, 5);
        }
        if (this.f391g != null) {
            c0058i.m408a(this.f391g, 6);
        }
        if (this.f392h != null) {
            c0058i.m410a(this.f392h, 7);
        }
        if (this.f393i != null) {
            c0058i.m408a(this.f393i, 8);
        }
        if (this.f394j != null) {
            c0058i.m406a(this.f394j, 9);
        }
        c0058i.m404a(this.f395k, 10);
        if (this.f396l != null) {
            c0058i.m408a(this.f396l, 11);
        }
        if (this.f397m != null) {
            c0058i.m408a(this.f397m, 12);
        }
        if (this.f398n != null) {
            c0058i.m406a(this.f398n, 13);
        }
        if (this.f399o != null) {
            c0058i.m409a(this.f399o, 14);
        }
        if (this.f400p != null) {
            c0058i.m409a(this.f400p, 15);
        }
        if (this.f401q != null) {
            c0058i.m409a(this.f401q, 16);
        }
        if (this.f402r != null) {
            c0058i.m410a(this.f402r, 17);
        }
        if (this.f403s != null) {
            c0058i.m410a(this.f403s, 18);
        }
        if (this.f404t != null) {
            c0058i.m408a(this.f404t, 19);
        }
        c0058i.m412a(this.f405u, 20);
    }

    static {
        f380v.put("", "");
        f383y.add(new ah());
        f384z.add(new ah());
        f377A.add(new aj());
        f378B.put("", "");
        f379C.put("", "");
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        this.f385a = c0057h.m397b(0, true);
        this.f386b = c0057h.m390a(this.f386b, 1, true);
        this.f387c = c0057h.m397b(2, true);
        this.f388d = c0057h.m397b(3, false);
        this.f389e = c0057h.m397b(4, false);
        this.f390f = c0057h.m397b(5, false);
        this.f391g = c0057h.m397b(6, false);
        this.f392h = (Map) c0057h.m392a(f380v, 7, false);
        this.f393i = c0057h.m397b(8, false);
        this.f394j = (ai) c0057h.m391a(f381w, 9, false);
        this.f395k = c0057h.m388a(this.f395k, 10, false);
        this.f396l = c0057h.m397b(11, false);
        this.f397m = c0057h.m397b(12, false);
        this.f398n = (ah) c0057h.m391a(f382x, 13, false);
        this.f399o = (ArrayList) c0057h.m392a(f383y, 14, false);
        this.f400p = (ArrayList) c0057h.m392a(f384z, 15, false);
        this.f401q = (ArrayList) c0057h.m392a(f377A, 16, false);
        this.f402r = (Map) c0057h.m392a(f378B, 17, false);
        this.f403s = (Map) c0057h.m392a(f379C, 18, false);
        this.f404t = c0057h.m397b(19, false);
        boolean z = this.f405u;
        this.f405u = c0057h.m396a(20, false);
    }
}
