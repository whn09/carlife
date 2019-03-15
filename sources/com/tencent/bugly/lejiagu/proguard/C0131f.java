package com.tencent.bugly.lejiagu.proguard;

import com.tencent.bugly.lejiagu.crashreport.crash.jni.C0123b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.f */
public final class C0131f extends C0126j {
    /* renamed from: k */
    private static byte[] f1091k = null;
    /* renamed from: l */
    private static Map<String, String> f1092l = null;
    /* renamed from: m */
    private static /* synthetic */ boolean f1093m;
    /* renamed from: a */
    public short f1094a = (short) 0;
    /* renamed from: b */
    public int f1095b = 0;
    /* renamed from: c */
    public String f1096c = null;
    /* renamed from: d */
    public String f1097d = null;
    /* renamed from: e */
    public byte[] f1098e;
    /* renamed from: f */
    private byte f1099f = (byte) 0;
    /* renamed from: g */
    private int f1100g = 0;
    /* renamed from: h */
    private int f1101h = 0;
    /* renamed from: i */
    private Map<String, String> f1102i;
    /* renamed from: j */
    private Map<String, String> f1103j;

    static {
        boolean z;
        if (C0131f.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f1093m = z;
    }

    public final boolean equals(Object o) {
        C0131f c0131f = (C0131f) o;
        if (C0136k.m948a(1, c0131f.f1094a) && C0136k.m948a(1, c0131f.f1099f) && C0136k.m948a(1, c0131f.f1100g) && C0136k.m948a(1, c0131f.f1095b) && C0136k.m950a(Integer.valueOf(1), c0131f.f1096c) && C0136k.m950a(Integer.valueOf(1), c0131f.f1097d) && C0136k.m950a(Integer.valueOf(1), c0131f.f1098e) && C0136k.m948a(1, c0131f.f1101h) && C0136k.m950a(Integer.valueOf(1), c0131f.f1102i) && C0136k.m950a(Integer.valueOf(1), c0131f.f1103j)) {
            return true;
        }
        return false;
    }

    public final Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!f1093m) {
                throw new AssertionError();
            }
        }
        return obj;
    }

    /* renamed from: a */
    public final void mo40a(C0135i c0135i) {
        c0135i.m944a(this.f1094a, 1);
        c0135i.m936a(this.f1099f, 2);
        c0135i.m937a(this.f1100g, 3);
        c0135i.m937a(this.f1095b, 4);
        c0135i.m941a(this.f1096c, 5);
        c0135i.m941a(this.f1097d, 6);
        c0135i.m946a(this.f1098e, 7);
        c0135i.m937a(this.f1101h, 8);
        c0135i.m943a(this.f1102i, 9);
        c0135i.m943a(this.f1103j, 10);
    }

    /* renamed from: a */
    public final void mo39a(C0134h c0134h) {
        try {
            Map hashMap;
            this.f1094a = c0134h.m927a(this.f1094a, 1, true);
            this.f1099f = c0134h.m920a(this.f1099f, 2, true);
            this.f1100g = c0134h.m921a(this.f1100g, 3, true);
            this.f1095b = c0134h.m921a(this.f1095b, 4, true);
            this.f1096c = c0134h.m930b(5, true);
            this.f1097d = c0134h.m930b(6, true);
            if (f1091k == null) {
                f1091k = new byte[]{(byte) 0};
            }
            byte[] bArr = f1091k;
            this.f1098e = c0134h.m931c(7, true);
            this.f1101h = c0134h.m921a(this.f1101h, 8, true);
            if (f1092l == null) {
                hashMap = new HashMap();
                f1092l = hashMap;
                hashMap.put("", "");
            }
            this.f1102i = (Map) c0134h.m925a(f1092l, 9, true);
            if (f1092l == null) {
                hashMap = new HashMap();
                f1092l = hashMap;
                hashMap.put("", "");
            }
            this.f1103j = (Map) c0134h.m925a(f1092l, 10, true);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("RequestPacket decode error " + C0130e.m901a(this.f1098e));
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final void mo41a(StringBuilder stringBuilder, int i) {
        C0123b c0123b = new C0123b(stringBuilder, i);
        c0123b.m775a(this.f1094a, "iVersion");
        c0123b.m764a(this.f1099f, "cPacketType");
        c0123b.m768a(this.f1100g, "iMessageType");
        c0123b.m768a(this.f1095b, "iRequestId");
        c0123b.m772a(this.f1096c, "sServantName");
        c0123b.m772a(this.f1097d, "sFuncName");
        c0123b.m777a(this.f1098e, "sBuffer");
        c0123b.m768a(this.f1101h, "iTimeout");
        c0123b.m774a(this.f1102i, "context");
        c0123b.m774a(this.f1103j, "status");
    }
}
