package com.tencent.bugly.lejiagu.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import java.util.Map;

/* compiled from: BUGLY */
public class StrategyBean implements Parcelable {
    public static final Creator<StrategyBean> CREATOR = new C00931();
    /* renamed from: a */
    public static String f747a;
    /* renamed from: u */
    private static String f748u = "http://android.bugly.qq.com/rqd/async";
    /* renamed from: v */
    private static String f749v = "http://android.bugly.qq.com/rqd/async";
    /* renamed from: w */
    private static String f750w = "http://rqd.uu.qq.com/rqd/sync";
    /* renamed from: b */
    public long f751b;
    /* renamed from: c */
    public long f752c;
    /* renamed from: d */
    public boolean f753d;
    /* renamed from: e */
    public boolean f754e;
    /* renamed from: f */
    public boolean f755f;
    /* renamed from: g */
    public boolean f756g;
    /* renamed from: h */
    public boolean f757h;
    /* renamed from: i */
    public boolean f758i;
    /* renamed from: j */
    public boolean f759j;
    /* renamed from: k */
    public boolean f760k;
    /* renamed from: l */
    public long f761l;
    /* renamed from: m */
    public long f762m;
    /* renamed from: n */
    public String f763n;
    /* renamed from: o */
    public String f764o;
    /* renamed from: p */
    public String f765p;
    /* renamed from: q */
    public String f766q;
    /* renamed from: r */
    public Map<String, String> f767r;
    /* renamed from: s */
    public int f768s;
    /* renamed from: t */
    public long f769t;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean$1 */
    static class C00931 implements Creator<StrategyBean> {
        C00931() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StrategyBean[i];
        }
    }

    public StrategyBean() {
        this.f751b = -1;
        this.f752c = -1;
        this.f753d = true;
        this.f754e = true;
        this.f755f = true;
        this.f756g = true;
        this.f757h = true;
        this.f758i = true;
        this.f759j = true;
        this.f760k = true;
        this.f762m = 30000;
        this.f763n = f748u;
        this.f764o = f749v;
        this.f765p = f750w;
        this.f768s = 10;
        this.f769t = 300000;
        this.f752c = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("S(@L@L").append("@)");
        f747a = stringBuilder.toString();
        stringBuilder.setLength(0);
        stringBuilder.append("*^@K#K").append("@!");
        this.f766q = stringBuilder.toString();
    }

    public StrategyBean(Parcel parcel) {
        boolean z = true;
        this.f751b = -1;
        this.f752c = -1;
        this.f753d = true;
        this.f754e = true;
        this.f755f = true;
        this.f756g = true;
        this.f757h = true;
        this.f758i = true;
        this.f759j = true;
        this.f760k = true;
        this.f762m = 30000;
        this.f763n = f748u;
        this.f764o = f749v;
        this.f765p = f750w;
        this.f768s = 10;
        this.f769t = 300000;
        try {
            boolean z2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("S(@L@L").append("@)");
            f747a = stringBuilder.toString();
            this.f752c = parcel.readLong();
            this.f753d = parcel.readByte() == (byte) 1;
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f754e = z2;
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f755f = z2;
            this.f763n = parcel.readString();
            this.f764o = parcel.readString();
            this.f766q = parcel.readString();
            this.f767r = C0124a.m816b(parcel);
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f756g = z2;
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f759j = z2;
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f760k = z2;
            this.f762m = parcel.readLong();
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f757h = z2;
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.f758i = z;
            this.f761l = parcel.readLong();
            this.f768s = parcel.readInt();
            this.f769t = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.f752c);
        parcel.writeByte((byte) (this.f753d ? 1 : 0));
        if (this.f754e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f755f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f763n);
        parcel.writeString(this.f764o);
        parcel.writeString(this.f766q);
        C0124a.m817b(parcel, this.f767r);
        if (this.f756g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f759j) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f760k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.f762m);
        if (this.f757h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f758i) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeLong(this.f761l);
        parcel.writeInt(this.f768s);
        parcel.writeLong(this.f769t);
    }
}
