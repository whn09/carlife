package com.tencent.bugly.legu.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.legu.proguard.C0048a;
import java.util.Map;

/* compiled from: BUGLY */
public class StrategyBean implements Parcelable {
    public static final Creator<StrategyBean> CREATOR = new C00171();
    /* renamed from: a */
    public static String f140a;
    /* renamed from: u */
    private static String f141u = "http://android.bugly.qq.com/rqd/async";
    /* renamed from: v */
    private static String f142v = "http://android.bugly.qq.com/rqd/async";
    /* renamed from: w */
    private static String f143w = "http://rqd.uu.qq.com/rqd/sync";
    /* renamed from: b */
    public long f144b;
    /* renamed from: c */
    public long f145c;
    /* renamed from: d */
    public boolean f146d;
    /* renamed from: e */
    public boolean f147e;
    /* renamed from: f */
    public boolean f148f;
    /* renamed from: g */
    public boolean f149g;
    /* renamed from: h */
    public boolean f150h;
    /* renamed from: i */
    public boolean f151i;
    /* renamed from: j */
    public boolean f152j;
    /* renamed from: k */
    public boolean f153k;
    /* renamed from: l */
    public long f154l;
    /* renamed from: m */
    public long f155m;
    /* renamed from: n */
    public String f156n;
    /* renamed from: o */
    public String f157o;
    /* renamed from: p */
    public String f158p;
    /* renamed from: q */
    public String f159q;
    /* renamed from: r */
    public Map<String, String> f160r;
    /* renamed from: s */
    public int f161s;
    /* renamed from: t */
    public long f162t;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean$1 */
    static class C00171 implements Creator<StrategyBean> {
        C00171() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StrategyBean[i];
        }
    }

    public StrategyBean() {
        this.f144b = -1;
        this.f145c = -1;
        this.f146d = true;
        this.f147e = true;
        this.f148f = true;
        this.f149g = true;
        this.f150h = true;
        this.f151i = true;
        this.f152j = true;
        this.f153k = true;
        this.f155m = 30000;
        this.f156n = f141u;
        this.f157o = f142v;
        this.f158p = f143w;
        this.f161s = 10;
        this.f162t = 300000;
        this.f145c = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("S(@L@L").append("@)");
        f140a = stringBuilder.toString();
        stringBuilder.setLength(0);
        stringBuilder.append("*^@K#K").append("@!");
        this.f159q = stringBuilder.toString();
    }

    public StrategyBean(Parcel parcel) {
        boolean z = true;
        this.f144b = -1;
        this.f145c = -1;
        this.f146d = true;
        this.f147e = true;
        this.f148f = true;
        this.f149g = true;
        this.f150h = true;
        this.f151i = true;
        this.f152j = true;
        this.f153k = true;
        this.f155m = 30000;
        this.f156n = f141u;
        this.f157o = f142v;
        this.f158p = f143w;
        this.f161s = 10;
        this.f162t = 300000;
        try {
            boolean z2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("S(@L@L").append("@)");
            f140a = stringBuilder.toString();
            this.f145c = parcel.readLong();
            this.f146d = parcel.readByte() == (byte) 1;
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f147e = z2;
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f148f = z2;
            this.f156n = parcel.readString();
            this.f157o = parcel.readString();
            this.f159q = parcel.readString();
            this.f160r = C0048a.m282b(parcel);
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f149g = z2;
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f152j = z2;
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f153k = z2;
            this.f155m = parcel.readLong();
            if (parcel.readByte() == (byte) 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f150h = z2;
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.f151i = z;
            this.f154l = parcel.readLong();
            this.f161s = parcel.readInt();
            this.f162t = parcel.readLong();
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
        parcel.writeLong(this.f145c);
        parcel.writeByte((byte) (this.f146d ? 1 : 0));
        if (this.f147e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f148f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f156n);
        parcel.writeString(this.f157o);
        parcel.writeString(this.f159q);
        C0048a.m283b(parcel, this.f160r);
        if (this.f149g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f152j) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f153k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.f155m);
        if (this.f150h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f151i) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeLong(this.f154l);
        parcel.writeInt(this.f161s);
        parcel.writeLong(this.f162t);
    }
}
