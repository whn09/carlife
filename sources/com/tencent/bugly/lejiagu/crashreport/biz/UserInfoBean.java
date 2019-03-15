package com.tencent.bugly.lejiagu.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import java.util.Map;

/* compiled from: BUGLY */
public class UserInfoBean implements Parcelable {
    public static final Creator<UserInfoBean> CREATOR = new C00821();
    /* renamed from: a */
    public long f650a;
    /* renamed from: b */
    public int f651b;
    /* renamed from: c */
    public String f652c;
    /* renamed from: d */
    public String f653d;
    /* renamed from: e */
    public long f654e;
    /* renamed from: f */
    public long f655f;
    /* renamed from: g */
    public long f656g;
    /* renamed from: h */
    public long f657h;
    /* renamed from: i */
    public long f658i;
    /* renamed from: j */
    public String f659j;
    /* renamed from: k */
    public long f660k = 0;
    /* renamed from: l */
    public boolean f661l = false;
    /* renamed from: m */
    public String f662m = "unknown";
    /* renamed from: n */
    public String f663n;
    /* renamed from: o */
    public int f664o;
    /* renamed from: p */
    public int f665p = -1;
    /* renamed from: q */
    public int f666q = -1;
    /* renamed from: r */
    public Map<String, String> f667r = null;
    /* renamed from: s */
    public Map<String, String> f668s = null;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.biz.UserInfoBean$1 */
    static class C00821 implements Creator<UserInfoBean> {
        C00821() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UserInfoBean[i];
        }
    }

    public UserInfoBean(Parcel parcel) {
        boolean z = true;
        this.f651b = parcel.readInt();
        this.f652c = parcel.readString();
        this.f653d = parcel.readString();
        this.f654e = parcel.readLong();
        this.f655f = parcel.readLong();
        this.f656g = parcel.readLong();
        this.f657h = parcel.readLong();
        this.f658i = parcel.readLong();
        this.f659j = parcel.readString();
        this.f660k = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f661l = z;
        this.f662m = parcel.readString();
        this.f665p = parcel.readInt();
        this.f666q = parcel.readInt();
        this.f667r = C0124a.m816b(parcel);
        this.f668s = C0124a.m816b(parcel);
        this.f663n = parcel.readString();
        this.f664o = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f651b);
        parcel.writeString(this.f652c);
        parcel.writeString(this.f653d);
        parcel.writeLong(this.f654e);
        parcel.writeLong(this.f655f);
        parcel.writeLong(this.f656g);
        parcel.writeLong(this.f657h);
        parcel.writeLong(this.f658i);
        parcel.writeString(this.f659j);
        parcel.writeLong(this.f660k);
        parcel.writeByte((byte) (this.f661l ? 1 : 0));
        parcel.writeString(this.f662m);
        parcel.writeInt(this.f665p);
        parcel.writeInt(this.f666q);
        C0124a.m817b(parcel, this.f667r);
        C0124a.m817b(parcel, this.f668s);
        parcel.writeString(this.f663n);
        parcel.writeInt(this.f664o);
    }
}
