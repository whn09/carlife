package com.tencent.bugly.legu.proguard;

import com.tencent.bugly.legu.crashreport.crash.jni.C0047b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.f */
public final class C0054f extends C0049j {
    /* renamed from: k */
    private static byte[] f484k = null;
    /* renamed from: l */
    private static Map<String, String> f485l = null;
    /* renamed from: m */
    private static /* synthetic */ boolean f486m;
    /* renamed from: a */
    public short f487a = (short) 0;
    /* renamed from: b */
    public int f488b = 0;
    /* renamed from: c */
    public String f489c = null;
    /* renamed from: d */
    public String f490d = null;
    /* renamed from: e */
    public byte[] f491e;
    /* renamed from: f */
    private byte f492f = (byte) 0;
    /* renamed from: g */
    private int f493g = 0;
    /* renamed from: h */
    private int f494h = 0;
    /* renamed from: i */
    private Map<String, String> f495i;
    /* renamed from: j */
    private Map<String, String> f496j;

    static {
        boolean z;
        if (C0054f.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f486m = z;
    }

    public final boolean equals(Object o) {
        C0054f c0054f = (C0054f) o;
        if (C0059k.m415a(1, c0054f.f487a) && C0059k.m415a(1, c0054f.f492f) && C0059k.m415a(1, c0054f.f493g) && C0059k.m415a(1, c0054f.f488b) && C0059k.m417a(Integer.valueOf(1), c0054f.f489c) && C0059k.m417a(Integer.valueOf(1), c0054f.f490d) && C0059k.m417a(Integer.valueOf(1), c0054f.f491e) && C0059k.m415a(1, c0054f.f494h) && C0059k.m417a(Integer.valueOf(1), c0054f.f495i) && C0059k.m417a(Integer.valueOf(1), c0054f.f496j)) {
            return true;
        }
        return false;
    }

    public final Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!f486m) {
                throw new AssertionError();
            }
        }
        return obj;
    }

    /* renamed from: a */
    public final void mo17a(C0058i c0058i) {
        c0058i.m411a(this.f487a, 1);
        c0058i.m403a(this.f492f, 2);
        c0058i.m404a(this.f493g, 3);
        c0058i.m404a(this.f488b, 4);
        c0058i.m408a(this.f489c, 5);
        c0058i.m408a(this.f490d, 6);
        c0058i.m413a(this.f491e, 7);
        c0058i.m404a(this.f494h, 8);
        c0058i.m410a(this.f495i, 9);
        c0058i.m410a(this.f496j, 10);
    }

    /* renamed from: a */
    public final void mo16a(C0057h c0057h) {
        try {
            Map hashMap;
            this.f487a = c0057h.m394a(this.f487a, 1, true);
            this.f492f = c0057h.m387a(this.f492f, 2, true);
            this.f493g = c0057h.m388a(this.f493g, 3, true);
            this.f488b = c0057h.m388a(this.f488b, 4, true);
            this.f489c = c0057h.m397b(5, true);
            this.f490d = c0057h.m397b(6, true);
            if (f484k == null) {
                f484k = new byte[]{(byte) 0};
            }
            byte[] bArr = f484k;
            this.f491e = c0057h.m398c(7, true);
            this.f494h = c0057h.m388a(this.f494h, 8, true);
            if (f485l == null) {
                hashMap = new HashMap();
                f485l = hashMap;
                hashMap.put("", "");
            }
            this.f495i = (Map) c0057h.m392a(f485l, 9, true);
            if (f485l == null) {
                hashMap = new HashMap();
                f485l = hashMap;
                hashMap.put("", "");
            }
            this.f496j = (Map) c0057h.m392a(f485l, 10, true);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("RequestPacket decode error " + C0053e.m368a(this.f491e));
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final void mo18a(StringBuilder stringBuilder, int i) {
        C0047b c0047b = new C0047b(stringBuilder, i);
        c0047b.m241a(this.f487a, "iVersion");
        c0047b.m230a(this.f492f, "cPacketType");
        c0047b.m234a(this.f493g, "iMessageType");
        c0047b.m234a(this.f488b, "iRequestId");
        c0047b.m238a(this.f489c, "sServantName");
        c0047b.m238a(this.f490d, "sFuncName");
        c0047b.m243a(this.f491e, "sBuffer");
        c0047b.m234a(this.f494h, "iTimeout");
        c0047b.m240a(this.f495i, "context");
        c0047b.m240a(this.f496j, "status");
    }
}
