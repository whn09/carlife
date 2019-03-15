package com.tencent.bugly.legu.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: BUGLY */
public class PlugInBean implements Parcelable {
    public static final Creator<PlugInBean> CREATOR = new C00151();
    /* renamed from: a */
    public final String f85a;
    /* renamed from: b */
    public final String f86b;
    /* renamed from: c */
    public final String f87c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.common.info.PlugInBean$1 */
    static class C00151 implements Creator<PlugInBean> {
        C00151() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlugInBean[i];
        }
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f85a = str;
        this.f86b = str2;
        this.f87c = str3;
    }

    public String toString() {
        return "plid:" + this.f85a + " plV:" + this.f86b + " plUUID:" + this.f87c;
    }

    public PlugInBean(Parcel parcel) {
        this.f85a = parcel.readString();
        this.f86b = parcel.readString();
        this.f87c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f85a);
        parcel.writeString(this.f86b);
        parcel.writeString(this.f87c);
    }
}
