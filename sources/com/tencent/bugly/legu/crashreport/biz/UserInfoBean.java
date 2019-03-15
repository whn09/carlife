package com.tencent.bugly.legu.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.legu.proguard.C0048a;
import java.util.Map;

/* compiled from: BUGLY */
public class UserInfoBean implements Parcelable {
    public static final Creator<UserInfoBean> CREATOR = new C00061();
    /* renamed from: a */
    public long f42a;
    /* renamed from: b */
    public int f43b;
    /* renamed from: c */
    public String f44c;
    /* renamed from: d */
    public String f45d;
    /* renamed from: e */
    public long f46e;
    /* renamed from: f */
    public long f47f;
    /* renamed from: g */
    public long f48g;
    /* renamed from: h */
    public long f49h;
    /* renamed from: i */
    public long f50i;
    /* renamed from: j */
    public String f51j;
    /* renamed from: k */
    public long f52k = 0;
    /* renamed from: l */
    public boolean f53l = false;
    /* renamed from: m */
    public String f54m = "unknown";
    /* renamed from: n */
    public String f55n;
    /* renamed from: o */
    public int f56o;
    /* renamed from: p */
    public int f57p = -1;
    /* renamed from: q */
    public int f58q = -1;
    /* renamed from: r */
    public Map<String, String> f59r = null;
    /* renamed from: s */
    public Map<String, String> f60s = null;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.biz.UserInfoBean$1 */
    static class C00061 implements Creator<UserInfoBean> {
        C00061() {
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
        this.f43b = parcel.readInt();
        this.f44c = parcel.readString();
        this.f45d = parcel.readString();
        this.f46e = parcel.readLong();
        this.f47f = parcel.readLong();
        this.f48g = parcel.readLong();
        this.f49h = parcel.readLong();
        this.f50i = parcel.readLong();
        this.f51j = parcel.readString();
        this.f52k = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f53l = z;
        this.f54m = parcel.readString();
        this.f57p = parcel.readInt();
        this.f58q = parcel.readInt();
        this.f59r = C0048a.m282b(parcel);
        this.f60s = C0048a.m282b(parcel);
        this.f55n = parcel.readString();
        this.f56o = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f43b);
        parcel.writeString(this.f44c);
        parcel.writeString(this.f45d);
        parcel.writeLong(this.f46e);
        parcel.writeLong(this.f47f);
        parcel.writeLong(this.f48g);
        parcel.writeLong(this.f49h);
        parcel.writeLong(this.f50i);
        parcel.writeString(this.f51j);
        parcel.writeLong(this.f52k);
        parcel.writeByte((byte) (this.f53l ? 1 : 0));
        parcel.writeString(this.f54m);
        parcel.writeInt(this.f57p);
        parcel.writeInt(this.f58q);
        C0048a.m283b(parcel, this.f59r);
        C0048a.m283b(parcel, this.f60s);
        parcel.writeString(this.f55n);
        parcel.writeInt(this.f56o);
    }
}
