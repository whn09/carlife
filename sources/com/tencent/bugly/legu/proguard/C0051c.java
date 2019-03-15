package com.tencent.bugly.legu.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.c */
public class C0051c extends C0048a {
    /* renamed from: d */
    protected HashMap<String, byte[]> f477d = null;
    /* renamed from: e */
    private HashMap<String, Object> f478e = new HashMap();
    /* renamed from: f */
    private C0057h f479f = new C0057h();

    /* renamed from: p */
    public void mo23p() {
        this.f477d = new HashMap();
    }

    /* renamed from: a */
    public <T> void mo20a(String str, T t) {
        if (this.f477d == null) {
            super.mo20a(str, (Object) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            C0058i c0058i = new C0058i();
            c0058i.m401a(this.b);
            c0058i.m407a((Object) t, 0);
            this.f477d.put(str, C0059k.m419a(c0058i.m402a()));
        }
    }

    /* renamed from: b */
    public final <T> T m359b(String str, T t) throws C0050b {
        T a;
        if (this.f477d != null) {
            if (!this.f477d.containsKey(str)) {
                return null;
            }
            if (this.f478e.containsKey(str)) {
                return this.f478e.get(str);
            }
            try {
                this.f479f.m395a((byte[]) this.f477d.get(str));
                this.f479f.m389a(this.b);
                a = this.f479f.m392a((Object) t, 0, true);
                if (a == null) {
                    return a;
                }
                this.f478e.put(str, a);
                return a;
            } catch (Exception e) {
                throw new C0050b(e);
            }
        } else if (!this.a.containsKey(str)) {
            return null;
        } else {
            if (this.f478e.containsKey(str)) {
                return this.f478e.get(str);
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
                this.f479f.m395a(bArr);
                this.f479f.m389a(this.b);
                a = this.f479f.m392a((Object) t, 0, true);
                this.f478e.put(str, a);
                return a;
            } catch (Exception e2) {
                throw new C0050b(e2);
            }
        }
    }

    /* renamed from: a */
    public byte[] mo22a() {
        if (this.f477d == null) {
            return super.mo22a();
        }
        C0058i c0058i = new C0058i(0);
        c0058i.m401a(this.b);
        c0058i.m410a(this.f477d, 0);
        return C0059k.m419a(c0058i.m402a());
    }

    /* renamed from: a */
    public void mo21a(byte[] bArr) {
        try {
            super.mo21a(bArr);
        } catch (Exception e) {
            this.f479f.m395a(bArr);
            this.f479f.m389a(this.b);
            Map hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f477d = this.f479f.m393a(hashMap, 0, false);
        }
    }
}
