package com.tencent.bugly.legu.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.proguard.C0007s;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0049j;
import com.tencent.bugly.legu.proguard.C0064o;
import com.tencent.bugly.legu.proguard.C0069t;
import com.tencent.bugly.legu.proguard.C0072v;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.crashreport.biz.a */
public final class C0011a {
    /* renamed from: a */
    private Context f67a;
    /* renamed from: b */
    private long f68b;
    /* renamed from: c */
    private int f69c;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.biz.a$a */
    class C0009a implements Runnable {
        /* renamed from: a */
        private boolean f63a;
        /* renamed from: b */
        private UserInfoBean f64b;
        /* renamed from: c */
        private /* synthetic */ C0011a f65c;

        public C0009a(C0011a c0011a, UserInfoBean userInfoBean, boolean z) {
            this.f65c = c0011a;
            this.f64b = userInfoBean;
            this.f63a = z;
        }

        public final void run() {
            try {
                if (this.f64b != null) {
                    UserInfoBean userInfoBean = this.f64b;
                    if (userInfoBean != null) {
                        C0016a a = C0016a.m69a();
                        if (a != null) {
                            userInfoBean.f51j = a.m85d();
                        }
                    }
                    C0073w.m523c("record userinfo", new Object[0]);
                    C0011a.m33a(this.f65c, this.f64b);
                }
                if (this.f63a) {
                    this.f65c.m39b();
                }
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.crashreport.biz.a$b */
    class C0010b implements Runnable {
        /* renamed from: a */
        private /* synthetic */ C0011a f66a;

        C0010b(C0011a c0011a) {
            this.f66a = c0011a;
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.f66a.f68b) {
                C0072v.m511a().m514a(new C0010b(this.f66a), (this.f66a.f68b - currentTimeMillis) + 5000);
                return;
            }
            this.f66a.f69c = this.f66a.f69c + 1;
            this.f66a.m38a(3, false, 0);
            this.f66a.m37a();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m33a(C0011a c0011a, UserInfoBean userInfoBean) {
        if (userInfoBean != null) {
            long a = C0064o.m440a().m459a("t_ui", C0011a.m31a(userInfoBean), null, true);
            if (a >= 0) {
                C0073w.m523c("insert %s success! %d", "t_ui", Long.valueOf(a));
                userInfoBean.f42a = a;
            }
        }
    }

    public C0011a(Context context) {
        this.f67a = context;
    }

    /* renamed from: a */
    public final void m38a(int i, boolean z, long j) {
        int i2 = 1;
        StrategyBean c = C0019a.m114a().m121c();
        if (c == null || c.f147e || i == 1 || i == 3) {
            if (i == 1) {
                this.f69c++;
            }
            Context context = this.f67a;
            if (i != 1) {
                i2 = 0;
            }
            C0016a a = C0016a.m70a(context);
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.f43b = i;
            userInfoBean.f44c = a.f117d;
            userInfoBean.f45d = a.m89f();
            userInfoBean.f46e = System.currentTimeMillis();
            userInfoBean.f47f = -1;
            userInfoBean.f55n = a.f122i;
            userInfoBean.f56o = i2;
            userInfoBean.f53l = a.f127n;
            userInfoBean.f54m = a.f128o;
            userInfoBean.f48g = a.f129p;
            userInfoBean.f49h = a.f130q;
            userInfoBean.f50i = a.f131r;
            userInfoBean.f52k = a.f132s;
            userInfoBean.f59r = a.m108w();
            userInfoBean.f60s = a.m72A();
            userInfoBean.f57p = a.m73B();
            userInfoBean.f58q = a.m74C();
            C0072v.m511a().m514a(new C0009a(this, userInfoBean, z), 0);
            return;
        }
        C0073w.m525e("UserInfo is disable", new Object[0]);
    }

    /* renamed from: a */
    public final void m37a() {
        this.f68b = C0048a.m304o() + 86400000;
        C0072v.m511a().m514a(new C0010b(this), (this.f68b - System.currentTimeMillis()) + 5000);
    }

    /* renamed from: b */
    public final synchronized void m39b() {
        int i = 1;
        synchronized (this) {
            int i2;
            List list;
            String str = C0016a.m70a(this.f67a).f117d;
            List arrayList = new ArrayList();
            List a = m36a(str);
            if (a != null) {
                UserInfoBean userInfoBean;
                int i3;
                int size = a.size() - 10;
                if (size > 0) {
                    for (int i4 = 0; i4 < a.size() - 1; i4++) {
                        for (i2 = i4 + 1; i2 < a.size(); i2++) {
                            if (((UserInfoBean) a.get(i4)).f46e > ((UserInfoBean) a.get(i2)).f46e) {
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
                    if (userInfoBean.f47f != -1) {
                        it.remove();
                        if (userInfoBean.f46e < C0048a.m304o()) {
                            arrayList.add(userInfoBean);
                        }
                    }
                    if (userInfoBean.f46e <= System.currentTimeMillis() - 600000 || !(userInfoBean.f43b == 1 || userInfoBean.f43b == 4)) {
                        i3 = i2;
                    } else {
                        i3 = i2 + 1;
                    }
                    i2 = i3;
                }
                if (i2 > 15) {
                    C0073w.m524d("[userinfo] userinfo too many times in 10 min: %d", Integer.valueOf(i2));
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
                C0011a.m34a(arrayList);
            }
            if (!(i2 == 0 || list == null || list.size() == 0)) {
                C0073w.m523c("[userinfo] do userinfo, size: %d", Integer.valueOf(list.size()));
                if (this.f69c != 1) {
                    i = 2;
                }
                C0049j a2 = C0048a.m253a(list, i);
                if (a2 == null) {
                    C0073w.m524d("[biz] create uPkg fail!", new Object[0]);
                } else {
                    byte[] a3 = C0048a.m274a(a2);
                    if (a3 == null) {
                        C0073w.m524d("[biz] send encode fail!", new Object[0]);
                    } else {
                        am a4 = C0048a.m250a(this.f67a, 640, a3);
                        if (a4 == null) {
                            C0073w.m524d("request package is null.", new Object[0]);
                        } else {
                            C0069t.m478a().m497a(1001, a4, null, new C0007s(this) {
                                /* renamed from: b */
                                private /* synthetic */ C0011a f62b;

                                /* renamed from: a */
                                public final void mo5a(boolean z) {
                                    if (z) {
                                        C0073w.m523c("up success do final", new Object[0]);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        for (UserInfoBean userInfoBean : list) {
                                            userInfoBean.f47f = currentTimeMillis;
                                            C0011a.m33a(this.f62b, userInfoBean);
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
    public final java.util.List<com.tencent.bugly.legu.crashreport.biz.UserInfoBean> m36a(java.lang.String r10) {
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
        r0 = com.tencent.bugly.legu.proguard.C0064o.m440a();	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
        r1 = "t_ui";
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 1;
        r8 = r0.m460a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x00ee, all -> 0x00e8 }
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
        r1 = com.tencent.bugly.legu.crashreport.biz.C0011a.m32a(r8);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        if (r1 == 0) goto L_0x0079;
    L_0x005d:
        r6.add(r1);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        goto L_0x0051;
    L_0x0061:
        r0 = move-exception;
        r1 = r8;
    L_0x0063:
        r2 = com.tencent.bugly.legu.proguard.C0073w.m520a(r0);	 Catch:{ all -> 0x00eb }
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
        com.tencent.bugly.legu.proguard.C0073w.m524d(r1, r2);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
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
        r0 = com.tencent.bugly.legu.proguard.C0064o.m440a();	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r1 = "t_ui";
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r0.m458a(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r1 = "[session] deleted %s error data %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r3 = 0;
        r4 = "t_ui";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r3 = 1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        r2[r3] = r0;	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
        com.tencent.bugly.legu.proguard.C0073w.m524d(r1, r2);	 Catch:{ Throwable -> 0x0061, all -> 0x009d }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.legu.crashreport.biz.a.a(java.lang.String):java.util.List<com.tencent.bugly.legu.crashreport.biz.UserInfoBean>");
    }

    /* renamed from: a */
    private static void m34a(List<UserInfoBean> list) {
        if (list != null && list.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (UserInfoBean userInfoBean : list) {
                stringBuilder.append(" or _id").append(" = ").append(userInfoBean.f42a);
            }
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 0) {
                stringBuilder2 = stringBuilder2.substring(4);
            }
            stringBuilder.setLength(0);
            try {
                int a = C0064o.m440a().m458a("t_ui", stringBuilder2, null, null, true);
                C0073w.m523c("deleted %s data %d", "t_ui", Integer.valueOf(a));
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private static ContentValues m31a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f42a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f42a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f46e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f47f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f43b));
            contentValues.put("_pc", userInfoBean.f44c);
            Parcel obtain = Parcel.obtain();
            userInfoBean.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            contentValues.put("_dt", marshall);
            return contentValues;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static UserInfoBean m32a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) C0048a.m256a(blob, UserInfoBean.CREATOR);
            if (userInfoBean == null) {
                return userInfoBean;
            }
            userInfoBean.f42a = j;
            return userInfoBean;
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
