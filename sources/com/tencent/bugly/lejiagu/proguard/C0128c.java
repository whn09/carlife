package com.tencent.bugly.lejiagu.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.c */
public class C0128c extends C0124a {
    /* renamed from: d */
    protected HashMap<String, byte[]> f1084d = null;
    /* renamed from: e */
    private HashMap<String, Object> f1085e = new HashMap();
    /* renamed from: f */
    private C0134h f1086f = new C0134h();

    /* renamed from: p */
    public void mo46p() {
        this.f1084d = new HashMap();
    }

    /* renamed from: a */
    public <T> void mo43a(String str, T t) {
        if (this.f1084d == null) {
            super.mo43a(str, (Object) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            C0135i c0135i = new C0135i();
            c0135i.m934a(this.b);
            c0135i.m940a((Object) t, 0);
            this.f1084d.put(str, C0136k.m952a(c0135i.m935a()));
        }
    }

    /* renamed from: b */
    public final <T> T m892b(String str, T t) throws C0127b {
        T a;
        if (this.f1084d != null) {
            if (!this.f1084d.containsKey(str)) {
                return null;
            }
            if (this.f1085e.containsKey(str)) {
                return this.f1085e.get(str);
            }
            try {
                this.f1086f.m928a((byte[]) this.f1084d.get(str));
                this.f1086f.m922a(this.b);
                a = this.f1086f.m925a((Object) t, 0, true);
                if (a == null) {
                    return a;
                }
                this.f1085e.put(str, a);
                return a;
            } catch (Exception e) {
                throw new C0127b(e);
            }
        } else if (!this.a.containsKey(str)) {
            return null;
        } else {
            if (this.f1085e.containsKey(str)) {
                return this.f1085e.get(str);
            }
            byte[] bArr;
            byte[] bArr2 = new byte[0];
            Iterator it = ((HashMap) this.a.get(str)).entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                entry.getKey();
                bArr = (byte[]) entry.getValue();
            } else {
                bArr = bArr2;
            }
            try {
                this.f1086f.m928a(bArr);
                this.f1086f.m922a(this.b);
                a = this.f1086f.m925a((Object) t, 0, true);
                this.f1085e.put(str, a);
                return a;
            } catch (Exception e2) {
                throw new C0127b(e2);
            }
        }
    }

    /* renamed from: a */
    public byte[] mo45a() {
        if (this.f1084d == null) {
            return super.mo45a();
        }
        C0135i c0135i = new C0135i(0);
        c0135i.m934a(this.b);
        c0135i.m943a(this.f1084d, 0);
        return C0136k.m952a(c0135i.m935a());
    }

    /* renamed from: a */
    public void mo44a(byte[] bArr) {
        try {
            super.mo44a(bArr);
        } catch (Exception e) {
            this.f1086f.m928a(bArr);
            this.f1086f.m922a(this.b);
            Map hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f1084d = this.f1086f.m926a(hashMap, 0, false);
        }
    }
}
