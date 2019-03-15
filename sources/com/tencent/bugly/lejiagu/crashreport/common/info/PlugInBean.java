package com.tencent.bugly.lejiagu.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: BUGLY */
public class PlugInBean implements Parcelable {
    public static final Creator<PlugInBean> CREATOR = new C00911();
    /* renamed from: a */
    public final String f692a;
    /* renamed from: b */
    public final String f693b;
    /* renamed from: c */
    public final String f694c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.common.info.PlugInBean$1 */
    static class C00911 implements Creator<PlugInBean> {
        C00911() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlugInBean[i];
        }
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f692a = str;
        this.f693b = str2;
        this.f694c = str3;
    }

    public String toString() {
        return "plid:" + this.f692a + " plV:" + this.f693b + " plUUID:" + this.f694c;
    }

    public PlugInBean(Parcel parcel) {
        this.f692a = parcel.readString();
        this.f693b = parcel.readString();
        this.f694c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f692a);
        parcel.writeString(this.f693b);
        parcel.writeString(this.f694c);
    }
}
