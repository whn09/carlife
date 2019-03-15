package com.tencent.bugly.legu.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.legu.crashreport.common.info.PlugInBean;
import com.tencent.bugly.legu.proguard.C0048a;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Creator<CrashDetailBean> CREATOR = new C00211();
    /* renamed from: A */
    public String f175A = "";
    /* renamed from: B */
    public long f176B = -1;
    /* renamed from: C */
    public long f177C = -1;
    /* renamed from: D */
    public long f178D = -1;
    /* renamed from: E */
    public long f179E = -1;
    /* renamed from: F */
    public long f180F = -1;
    /* renamed from: G */
    public long f181G = -1;
    /* renamed from: H */
    public String f182H = "";
    /* renamed from: I */
    public String f183I = "";
    /* renamed from: J */
    public String f184J = "";
    /* renamed from: K */
    public String f185K = "";
    /* renamed from: L */
    public long f186L = -1;
    /* renamed from: M */
    public boolean f187M = false;
    /* renamed from: N */
    public Map<String, String> f188N = null;
    /* renamed from: O */
    public int f189O = -1;
    /* renamed from: P */
    public int f190P = -1;
    /* renamed from: Q */
    public Map<String, String> f191Q = null;
    /* renamed from: R */
    public Map<String, String> f192R = null;
    /* renamed from: S */
    public byte[] f193S = null;
    /* renamed from: T */
    private String f194T = "";
    /* renamed from: a */
    public long f195a = -1;
    /* renamed from: b */
    public int f196b = 0;
    /* renamed from: c */
    public String f197c = UUID.randomUUID().toString();
    /* renamed from: d */
    public boolean f198d = false;
    /* renamed from: e */
    public String f199e = "";
    /* renamed from: f */
    public String f200f = "";
    /* renamed from: g */
    public String f201g = "";
    /* renamed from: h */
    public Map<String, PlugInBean> f202h = null;
    /* renamed from: i */
    public Map<String, PlugInBean> f203i = null;
    /* renamed from: j */
    public boolean f204j = false;
    /* renamed from: k */
    public boolean f205k = false;
    /* renamed from: l */
    public int f206l = 0;
    /* renamed from: m */
    public String f207m = "";
    /* renamed from: n */
    public String f208n = "";
    /* renamed from: o */
    public String f209o = "";
    /* renamed from: p */
    public String f210p = "";
    /* renamed from: q */
    public String f211q = "";
    /* renamed from: r */
    public long f212r = -1;
    /* renamed from: s */
    public String f213s = null;
    /* renamed from: t */
    public int f214t = 0;
    /* renamed from: u */
    public String f215u = "";
    /* renamed from: v */
    public String f216v = "";
    /* renamed from: w */
    public String f217w = null;
    /* renamed from: x */
    public byte[] f218x = null;
    /* renamed from: y */
    public Map<String, String> f219y = null;
    /* renamed from: z */
    public String f220z = "";

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.crash.CrashDetailBean$1 */
    static class C00211 implements Creator<CrashDetailBean> {
        C00211() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CrashDetailBean[i];
        }
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        CrashDetailBean crashDetailBean = (CrashDetailBean) obj;
        if (crashDetailBean != null) {
            long j = this.f212r - crashDetailBean.f212r;
            if (j <= 0) {
                return j < 0 ? -1 : 0;
            }
        }
        return 1;
    }

    public CrashDetailBean(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f196b = parcel.readInt();
        this.f197c = parcel.readString();
        this.f198d = parcel.readByte() == (byte) 1;
        this.f199e = parcel.readString();
        this.f200f = parcel.readString();
        this.f201g = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f204j = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f205k = z;
        this.f206l = parcel.readInt();
        this.f207m = parcel.readString();
        this.f208n = parcel.readString();
        this.f209o = parcel.readString();
        this.f210p = parcel.readString();
        this.f211q = parcel.readString();
        this.f212r = parcel.readLong();
        this.f213s = parcel.readString();
        this.f214t = parcel.readInt();
        this.f215u = parcel.readString();
        this.f216v = parcel.readString();
        this.f217w = parcel.readString();
        this.f219y = C0048a.m282b(parcel);
        this.f220z = parcel.readString();
        this.f175A = parcel.readString();
        this.f176B = parcel.readLong();
        this.f177C = parcel.readLong();
        this.f178D = parcel.readLong();
        this.f179E = parcel.readLong();
        this.f180F = parcel.readLong();
        this.f181G = parcel.readLong();
        this.f182H = parcel.readString();
        this.f194T = parcel.readString();
        this.f183I = parcel.readString();
        this.f184J = parcel.readString();
        this.f185K = parcel.readString();
        this.f186L = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f187M = z2;
        this.f188N = C0048a.m282b(parcel);
        this.f202h = C0048a.m265a(parcel);
        this.f203i = C0048a.m265a(parcel);
        this.f189O = parcel.readInt();
        this.f190P = parcel.readInt();
        this.f191Q = C0048a.m282b(parcel);
        this.f192R = C0048a.m282b(parcel);
        this.f193S = parcel.createByteArray();
        this.f218x = parcel.createByteArray();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f196b);
        parcel.writeString(this.f197c);
        parcel.writeByte((byte) (this.f198d ? 1 : 0));
        parcel.writeString(this.f199e);
        parcel.writeString(this.f200f);
        parcel.writeString(this.f201g);
        if (this.f204j) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f205k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.f206l);
        parcel.writeString(this.f207m);
        parcel.writeString(this.f208n);
        parcel.writeString(this.f209o);
        parcel.writeString(this.f210p);
        parcel.writeString(this.f211q);
        parcel.writeLong(this.f212r);
        parcel.writeString(this.f213s);
        parcel.writeInt(this.f214t);
        parcel.writeString(this.f215u);
        parcel.writeString(this.f216v);
        parcel.writeString(this.f217w);
        C0048a.m283b(parcel, this.f219y);
        parcel.writeString(this.f220z);
        parcel.writeString(this.f175A);
        parcel.writeLong(this.f176B);
        parcel.writeLong(this.f177C);
        parcel.writeLong(this.f178D);
        parcel.writeLong(this.f179E);
        parcel.writeLong(this.f180F);
        parcel.writeLong(this.f181G);
        parcel.writeString(this.f182H);
        parcel.writeString(this.f194T);
        parcel.writeString(this.f183I);
        parcel.writeString(this.f184J);
        parcel.writeString(this.f185K);
        parcel.writeLong(this.f186L);
        if (!this.f187M) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        C0048a.m283b(parcel, this.f188N);
        C0048a.m266a(parcel, this.f202h);
        C0048a.m266a(parcel, this.f203i);
        parcel.writeInt(this.f189O);
        parcel.writeInt(this.f190P);
        C0048a.m283b(parcel, this.f191Q);
        C0048a.m283b(parcel, this.f192R);
        parcel.writeByteArray(this.f193S);
        parcel.writeByteArray(this.f218x);
    }
}
