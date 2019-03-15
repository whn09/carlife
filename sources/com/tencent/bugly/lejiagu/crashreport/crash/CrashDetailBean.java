package com.tencent.bugly.lejiagu.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.lejiagu.crashreport.common.info.PlugInBean;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Creator<CrashDetailBean> CREATOR = new C00971();
    /* renamed from: A */
    public String f782A = "";
    /* renamed from: B */
    public long f783B = -1;
    /* renamed from: C */
    public long f784C = -1;
    /* renamed from: D */
    public long f785D = -1;
    /* renamed from: E */
    public long f786E = -1;
    /* renamed from: F */
    public long f787F = -1;
    /* renamed from: G */
    public long f788G = -1;
    /* renamed from: H */
    public String f789H = "";
    /* renamed from: I */
    public String f790I = "";
    /* renamed from: J */
    public String f791J = "";
    /* renamed from: K */
    public String f792K = "";
    /* renamed from: L */
    public long f793L = -1;
    /* renamed from: M */
    public boolean f794M = false;
    /* renamed from: N */
    public Map<String, String> f795N = null;
    /* renamed from: O */
    public int f796O = -1;
    /* renamed from: P */
    public int f797P = -1;
    /* renamed from: Q */
    public Map<String, String> f798Q = null;
    /* renamed from: R */
    public Map<String, String> f799R = null;
    /* renamed from: S */
    public byte[] f800S = null;
    /* renamed from: T */
    private String f801T = "";
    /* renamed from: a */
    public long f802a = -1;
    /* renamed from: b */
    public int f803b = 0;
    /* renamed from: c */
    public String f804c = UUID.randomUUID().toString();
    /* renamed from: d */
    public boolean f805d = false;
    /* renamed from: e */
    public String f806e = "";
    /* renamed from: f */
    public String f807f = "";
    /* renamed from: g */
    public String f808g = "";
    /* renamed from: h */
    public Map<String, PlugInBean> f809h = null;
    /* renamed from: i */
    public Map<String, PlugInBean> f810i = null;
    /* renamed from: j */
    public boolean f811j = false;
    /* renamed from: k */
    public boolean f812k = false;
    /* renamed from: l */
    public int f813l = 0;
    /* renamed from: m */
    public String f814m = "";
    /* renamed from: n */
    public String f815n = "";
    /* renamed from: o */
    public String f816o = "";
    /* renamed from: p */
    public String f817p = "";
    /* renamed from: q */
    public String f818q = "";
    /* renamed from: r */
    public long f819r = -1;
    /* renamed from: s */
    public String f820s = null;
    /* renamed from: t */
    public int f821t = 0;
    /* renamed from: u */
    public String f822u = "";
    /* renamed from: v */
    public String f823v = "";
    /* renamed from: w */
    public String f824w = null;
    /* renamed from: x */
    public byte[] f825x = null;
    /* renamed from: y */
    public Map<String, String> f826y = null;
    /* renamed from: z */
    public String f827z = "";

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.CrashDetailBean$1 */
    static class C00971 implements Creator<CrashDetailBean> {
        C00971() {
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
            long j = this.f819r - crashDetailBean.f819r;
            if (j <= 0) {
                return j < 0 ? -1 : 0;
            }
        }
        return 1;
    }

    public CrashDetailBean(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f803b = parcel.readInt();
        this.f804c = parcel.readString();
        this.f805d = parcel.readByte() == (byte) 1;
        this.f806e = parcel.readString();
        this.f807f = parcel.readString();
        this.f808g = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f811j = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f812k = z;
        this.f813l = parcel.readInt();
        this.f814m = parcel.readString();
        this.f815n = parcel.readString();
        this.f816o = parcel.readString();
        this.f817p = parcel.readString();
        this.f818q = parcel.readString();
        this.f819r = parcel.readLong();
        this.f820s = parcel.readString();
        this.f821t = parcel.readInt();
        this.f822u = parcel.readString();
        this.f823v = parcel.readString();
        this.f824w = parcel.readString();
        this.f826y = C0124a.m816b(parcel);
        this.f827z = parcel.readString();
        this.f782A = parcel.readString();
        this.f783B = parcel.readLong();
        this.f784C = parcel.readLong();
        this.f785D = parcel.readLong();
        this.f786E = parcel.readLong();
        this.f787F = parcel.readLong();
        this.f788G = parcel.readLong();
        this.f789H = parcel.readString();
        this.f801T = parcel.readString();
        this.f790I = parcel.readString();
        this.f791J = parcel.readString();
        this.f792K = parcel.readString();
        this.f793L = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f794M = z2;
        this.f795N = C0124a.m816b(parcel);
        this.f809h = C0124a.m799a(parcel);
        this.f810i = C0124a.m799a(parcel);
        this.f796O = parcel.readInt();
        this.f797P = parcel.readInt();
        this.f798Q = C0124a.m816b(parcel);
        this.f799R = C0124a.m816b(parcel);
        this.f800S = parcel.createByteArray();
        this.f825x = parcel.createByteArray();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f803b);
        parcel.writeString(this.f804c);
        parcel.writeByte((byte) (this.f805d ? 1 : 0));
        parcel.writeString(this.f806e);
        parcel.writeString(this.f807f);
        parcel.writeString(this.f808g);
        if (this.f811j) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f812k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.f813l);
        parcel.writeString(this.f814m);
        parcel.writeString(this.f815n);
        parcel.writeString(this.f816o);
        parcel.writeString(this.f817p);
        parcel.writeString(this.f818q);
        parcel.writeLong(this.f819r);
        parcel.writeString(this.f820s);
        parcel.writeInt(this.f821t);
        parcel.writeString(this.f822u);
        parcel.writeString(this.f823v);
        parcel.writeString(this.f824w);
        C0124a.m817b(parcel, this.f826y);
        parcel.writeString(this.f827z);
        parcel.writeString(this.f782A);
        parcel.writeLong(this.f783B);
        parcel.writeLong(this.f784C);
        parcel.writeLong(this.f785D);
        parcel.writeLong(this.f786E);
        parcel.writeLong(this.f787F);
        parcel.writeLong(this.f788G);
        parcel.writeString(this.f789H);
        parcel.writeString(this.f801T);
        parcel.writeString(this.f790I);
        parcel.writeString(this.f791J);
        parcel.writeString(this.f792K);
        parcel.writeLong(this.f793L);
        if (!this.f794M) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        C0124a.m817b(parcel, this.f795N);
        C0124a.m800a(parcel, this.f809h);
        C0124a.m800a(parcel, this.f810i);
        parcel.writeInt(this.f796O);
        parcel.writeInt(this.f797P);
        C0124a.m817b(parcel, this.f798Q);
        C0124a.m817b(parcel, this.f799R);
        parcel.writeByteArray(this.f800S);
        parcel.writeByteArray(this.f825x);
    }
}
