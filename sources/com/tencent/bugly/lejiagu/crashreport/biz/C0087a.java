package com.tencent.bugly.lejiagu.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.proguard.C0083q;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0126j;
import com.tencent.bugly.lejiagu.proguard.C0139m;
import com.tencent.bugly.lejiagu.proguard.C0144r;
import com.tencent.bugly.lejiagu.proguard.C0147t;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.biz.a */
public final class C0087a {
    /* renamed from: a */
    private Context f675a;
    /* renamed from: b */
    private long f676b;
    /* renamed from: c */
    private int f677c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.biz.a$a */
    class C0085a implements Runnable {
        /* renamed from: a */
        private boolean f671a;
        /* renamed from: b */
        private UserInfoBean f672b;
        /* renamed from: c */
        private /* synthetic */ C0087a f673c;

        public C0085a(C0087a c0087a, UserInfoBean userInfoBean, boolean z) {
            this.f673c = c0087a;
            this.f672b = userInfoBean;
            this.f671a = z;
        }

        public final void run() {
            try {
                if (this.f672b != null) {
                    UserInfoBean userInfoBean = this.f672b;
                    if (userInfoBean != null) {
                        C0092a a = C0092a.m597a();
                        if (a != null) {
                            userInfoBean.f659j = a.m612d();
                        }
                    }
                    C0148u.m1039c("record userinfo", new Object[0]);
                    C0087a.m562a(this.f673c, this.f672b);
                }
                if (this.f671a) {
                    this.f673c.m568b();
                }
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.crashreport.biz.a$b */
    class C0086b implements Runnable {
        /* renamed from: a */
        private /* synthetic */ C0087a f674a;

        C0086b(C0087a c0087a) {
            this.f674a = c0087a;
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.f674a.f676b) {
                C0147t.m1027a().m1030a(new C0086b(this.f674a), (this.f674a.f676b - currentTimeMillis) + 5000);
                return;
            }
            this.f674a.f677c = this.f674a.f677c + 1;
            this.f674a.m567a(3, false, 0);
            this.f674a.m566a();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m562a(C0087a c0087a, UserInfoBean userInfoBean) {
        if (userInfoBean != null) {
            long a = C0139m.m963a().m979a("t_ui", C0087a.m560a(userInfoBean), null, true);
            if (a >= 0) {
                C0148u.m1039c("insert %s success! %d", "t_ui", Long.valueOf(a));
                userInfoBean.f650a = a;
            }
        }
    }

    public C0087a(Context context) {
        this.f675a = context;
    }

    /* renamed from: a */
    public final void m567a(int i, boolean z, long j) {
        int i2 = 1;
        StrategyBean c = C0095a.m641a().m648c();
        if (c == null || c.f754e || i == 1 || i == 3) {
            if (i == 1) {
                this.f677c++;
            }
            Context context = this.f675a;
            if (i != 1) {
                i2 = 0;
            }
            C0092a a = C0092a.m598a(context);
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.f651b = i;
            userInfoBean.f652c = a.f724d;
            userInfoBean.f653d = a.m616f();
            userInfoBean.f654e = System.currentTimeMillis();
            userInfoBean.f655f = -1;
            userInfoBean.f663n = a.f729i;
            userInfoBean.f664o = i2;
            userInfoBean.f661l = a.f734n;
            userInfoBean.f662m = a.f735o;
            userInfoBean.f656g = a.f736p;
            userInfoBean.f657h = a.f737q;
            userInfoBean.f658i = a.f738r;
            userInfoBean.f660k = a.f739s;
            userInfoBean.f667r = a.m635w();
            userInfoBean.f668s = a.m638z();
            userInfoBean.f665p = a.m600A();
            userInfoBean.f666q = a.m601B();
            C0147t.m1027a().m1030a(new C0085a(this, userInfoBean, z), 0);
            return;
        }
        C0148u.m1041e("UserInfo is disable", new Object[0]);
    }

    /* renamed from: a */
    public final void m566a() {
        this.f676b = C0124a.m838o() + 86400000;
        C0147t.m1027a().m1030a(new C0086b(this), (this.f676b - System.currentTimeMillis()) + 5000);
    }

    /* renamed from: b */
    public final synchronized void m568b() {
        int i = 1;
        synchronized (this) {
            int i2;
            List list;
            String str = C0092a.m598a(this.f675a).f724d;
            List arrayList = new ArrayList();
            List a = m565a(str);
            if (a != null) {
                UserInfoBean userInfoBean;
                int i3;
                int size = a.size() - 10;
                if (size > 0) {
                    for (int i4 = 0; i4 < a.size() - 1; i4++) {
                        for (i2 = i4 + 1; i2 < a.size(); i2++) {
                            if (((UserInfoBean) a.get(i4)).f654e > ((UserInfoBean) a.get(i2)).f654e) {
                                userInfoBean = (UserInfoBean) a.get(i4);
                                a.set(i4, a.get(i2));
                                a.set(i2, userInfoBean);
                            }
                        }
                    }
                    for (i3 = 0; i3 < size; i3++) {
                        arrayList.add(a.get(i3));
                    }
                }
                Iterator it = a.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    userInfoBean = (UserInfoBean) it.next();
                    if (userInfoBean.f655f != -1) {
                        it.remove();
                        if (userInfoBean.f654e < C0124a.m838o()) {
                            arrayList.add(userInfoBean);
                        }
                    }
                    if (userInfoBean.f654e <= System.currentTimeMillis() - 600000 || !(userInfoBean.f651b == 1 || userInfoBean.f651b == 4)) {
                        i3 = i2;
                    } else {
                        i3 = i2 + 1;
                    }
                    i2 = i3;
                }
                if (i2 > 15) {
                    C0148u.m1040d("[userinfo] userinfo too many times in 10 min: %d", Integer.valueOf(i2));
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                i2 = i3;
                list = a;
            } else {
                list = new ArrayList();
                i2 = 1;
            }
            if (arrayList.size() > 0) {
                C0087a.m563a(arrayList);
            }
            if (!(i2 == 0 || list == null || list.size() == 0)) {
                C0148u.m1039c("[userinfo] do userinfo, size: %d", Integer.valueOf(list.size()));
                if (this.f677c != 1) {
                    i = 2;
                }
                C0126j a2 = C0124a.m787a(list, i);
                if (a2 == null) {
                    C0148u.m1040d("[biz] create uPkg fail!", new Object[0]);
                } else {
                    byte[] a3 = C0124a.m808a(a2);
                    if (a3 == null) {
                        C0148u.m1040d("[biz] send encode fail!", new Object[0]);
                    } else {
                        ak a4 = C0124a.m784a(this.f675a, 640, a3);
                        if (a4 == null) {
                            C0148u.m1040d("request package is null.", new Object[0]);
                        } else {
                            C0144r.m994a().m1013a(1001, a4, null, new C0083q(this) {
                                /* renamed from: b */
                                private /* synthetic */ C0087a f670b;

                                /* renamed from: a */
                                public final void mo28a(boolean z) {
                                    if (z) {
                                        C0148u.m1039c("up success do final", new Object[0]);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        for (UserInfoBean userInfoBean : list) {
                                            userInfoBean.f655f = currentTimeMillis;
                                            C0087a.m562a(this.f670b, userInfoBean);
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final java.util.List<com.tencent.bugly.lejiagu.crashreport.biz.UserInfoBean> m565a(java.lang.String r10) {
        /*
        r9 = this;
        r0 = 0;
        r1 = 1;
        r7 = 0;
        if (r10 == 0) goto L_0x002f;
    L_0x0005:
        r2 = r10.trim();	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        r2 = r2.length();	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        if (r2 <= 0) goto L_0x002f;
    L_0x000f:
        if (r0 == 0) goto L_0x0031;
    L_0x0011:
        r3 = r7;
    L_0x0012:
        r0 = com.tencent.bugly.lejiagu.proguard.C0139m.m963a();	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        r1 = "t_ui";
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 1;
        r8 = r0.m980a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        if (r8 != 0) goto L_0x0047;
    L_0x0022:
        if (r8 == 0) goto L_0x002d;
    L_0x0024:
        r0 = r8.isClosed();
        if (r0 != 0) goto L_0x002d;
    L_0x002a:
        r8.close();
    L_0x002d:
        r0 = r7;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = r1;
        goto L_0x000f;
    L_0x0031:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        r1 = "_pc = '";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        r0 = r0.append(r10);	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        r1 = "'";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        r3 = r0.toString();	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        goto L_0x0012;
    L_0x0047:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r0.<init>();	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r6 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r6.<init>();	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
    L_0x0051:
        r1 = r8.moveToNext();	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        if (r1 == 0) goto L_0x00aa;
    L_0x0057:
        r1 = com.tencent.bugly.lejiagu.crashreport.biz.C0087a.m561a(r8);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        if (r1 == 0) goto L_0x0079;
    L_0x005d:
        r6.add(r1);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        goto L_0x0051;
    L_0x0061:
        r0 = move-exception;
        r1 = r8;
    L_0x0063:
        r2 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r0);	 Catch:{ all -> 0x00eb }
        if (r2 != 0) goto L_0x006c;
    L_0x0069:
        r0.printStackTrace();	 Catch:{ all -> 0x00eb }
    L_0x006c:
        if (r1 == 0) goto L_0x0077;
    L_0x006e:
        r0 = r1.isClosed();
        if (r0 != 0) goto L_0x0077;
    L_0x0074:
        r1.close();
    L_0x0077:
        r0 = r7;
        goto L_0x002e;
    L_0x0079:
        r1 = "_id";
        r1 = r8.getColumnIndex(r1);	 Catch:{ Throwable -> 0x0093, all -> 0x009d }
        r1 = r8.getLong(r1);	 Catch:{ Throwable -> 0x0093, all -> 0x009d }
        r3 = " or _id";
        r3 = r0.append(r3);	 Catch:{ Throwable -> 0x0093, all -> 0x009d }
        r4 = " = ";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0093, all -> 0x009d }
        r3.append(r1);	 Catch:{ Throwable -> 0x0093, all -> 0x009d }
        goto L_0x0051;
    L_0x0093:
        r1 = move-exception;
        r1 = "unknown id!";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r1, r2);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        goto L_0x0051;
    L_0x009d:
        r0 = move-exception;
    L_0x009e:
        if (r8 == 0) goto L_0x00a9;
    L_0x00a0:
        r1 = r8.isClosed();
        if (r1 != 0) goto L_0x00a9;
    L_0x00a6:
        r8.close();
    L_0x00a9:
        throw r0;
    L_0x00aa:
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r1 = r0.length();	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        if (r1 <= 0) goto L_0x00da;
    L_0x00b4:
        r1 = 4;
        r2 = r0.substring(r1);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r0 = com.tencent.bugly.lejiagu.proguard.C0139m.m963a();	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r1 = "t_ui";
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r0.m978a(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r1 = "[session] deleted %s error data %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r3 = 0;
        r4 = "t_ui";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r3 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r2[r3] = r0;	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r1, r2);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
    L_0x00da:
        if (r8 == 0) goto L_0x00e5;
    L_0x00dc:
        r0 = r8.isClosed();
        if (r0 != 0) goto L_0x00e5;
    L_0x00e2:
        r8.close();
    L_0x00e5:
        r0 = r6;
        goto L_0x002e;
    L_0x00e8:
        r0 = move-exception;
        r8 = r7;
        goto L_0x009e;
    L_0x00eb:
        r0 = move-exception;
        r8 = r1;
        goto L_0x009e;
    L_0x00ee:
        r0 = move-exception;
        r1 = r7;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.lejiagu.crashreport.biz.a.a(java.lang.String):java.util.List<com.tencent.bugly.lejiagu.crashreport.biz.UserInfoBean>");
    }

    /* renamed from: a */
    private static void m563a(List<UserInfoBean> list) {
        if (list != null && list.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (UserInfoBean userInfoBean : list) {
                stringBuilder.append(" or _id").append(" = ").append(userInfoBean.f650a);
            }
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 0) {
                stringBuilder2 = stringBuilder2.substring(4);
            }
            stringBuilder.setLength(0);
            try {
                int a = C0139m.m963a().m978a("t_ui", stringBuilder2, null, null, true);
                C0148u.m1039c("deleted %s data %d", "t_ui", Integer.valueOf(a));
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private static ContentValues m560a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f650a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f650a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f654e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f655f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f651b));
            contentValues.put("_pc", userInfoBean.f652c);
            Parcel obtain = Parcel.obtain();
            userInfoBean.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            contentValues.put("_dt", marshall);
            return contentValues;
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static UserInfoBean m561a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) C0124a.m790a(blob, UserInfoBean.CREATOR);
            if (userInfoBean == null) {
                return userInfoBean;
            }
            userInfoBean.f650a = j;
            return userInfoBean;
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
