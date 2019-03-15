package com.tencent.bugly.lejiagu.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import com.tencent.bugly.lejiagu.BuglyStrategy.C0079a;
import com.tencent.bugly.lejiagu.C0081b;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.info.PlugInBean;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.lejiagu.proguard.C0083q;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0126j;
import com.tencent.bugly.lejiagu.proguard.C0137l;
import com.tencent.bugly.lejiagu.proguard.C0139m;
import com.tencent.bugly.lejiagu.proguard.C0141o;
import com.tencent.bugly.lejiagu.proguard.C0144r;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import com.tencent.bugly.lejiagu.proguard.af;
import com.tencent.bugly.lejiagu.proguard.ah;
import com.tencent.bugly.lejiagu.proguard.ai;
import com.tencent.bugly.lejiagu.proguard.aj;
import com.tencent.bugly.lejiagu.proguard.ak;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.crashreport.crash.b */
public final class C0108b {
    /* renamed from: a */
    private static int f863a = 0;
    /* renamed from: b */
    private Context f864b;
    /* renamed from: c */
    private C0139m f865c;
    /* renamed from: d */
    private C0095a f866d;
    /* renamed from: e */
    private C0137l f867e;
    /* renamed from: f */
    private C0079a f868f;

    public C0108b(int i, Context context, C0144r c0144r, C0139m c0139m, C0095a c0095a, C0079a c0079a, C0137l c0137l) {
        f863a = i;
        this.f864b = context;
        this.f865c = c0139m;
        this.f866d = c0095a;
        this.f868f = c0079a;
        this.f867e = c0137l;
    }

    /* renamed from: a */
    private static List<C0098a> m682a(List<C0098a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long o = C0124a.m838o();
        List<C0098a> arrayList = new ArrayList();
        for (C0098a c0098a : list) {
            if (c0098a.f831d && c0098a.f829b < o - 86400000) {
                arrayList.add(c0098a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private CrashDetailBean m679a(List<C0098a> list, CrashDetailBean crashDetailBean) {
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2;
        CrashDetailBean crashDetailBean3 = null;
        List arrayList = new ArrayList(10);
        for (C0098a c0098a : list) {
            if (c0098a.f832e) {
                arrayList.add(c0098a);
            }
        }
        if (arrayList.size() > 0) {
            List b = m687b(arrayList);
            if (b != null && b.size() > 0) {
                Collections.sort(b);
                int i = 0;
                while (i < b.size()) {
                    crashDetailBean2 = (CrashDetailBean) b.get(i);
                    if (i != 0) {
                        if (crashDetailBean2.f820s != null) {
                            String[] split = crashDetailBean2.f820s.split("\n");
                            if (split != null) {
                                for (String str : split) {
                                    if (!crashDetailBean3.f820s.contains(str)) {
                                        crashDetailBean3.f821t++;
                                        crashDetailBean3.f820s += str + "\n";
                                    }
                                }
                            }
                        }
                        crashDetailBean2 = crashDetailBean3;
                    }
                    i++;
                    crashDetailBean3 = crashDetailBean2;
                }
                crashDetailBean2 = crashDetailBean3;
                if (crashDetailBean2 != null) {
                    crashDetailBean.f811j = true;
                    crashDetailBean.f821t = 0;
                    crashDetailBean.f820s = "";
                    crashDetailBean3 = crashDetailBean;
                } else {
                    crashDetailBean3 = crashDetailBean2;
                }
                for (C0098a c0098a2 : list) {
                    if (!(c0098a2.f832e || c0098a2.f831d || crashDetailBean3.f820s.contains(c0098a2.f829b))) {
                        crashDetailBean3.f821t++;
                        crashDetailBean3.f820s += c0098a2.f829b + "\n";
                    }
                }
                if (crashDetailBean3.f819r == crashDetailBean.f819r && !crashDetailBean3.f820s.contains(crashDetailBean.f819r)) {
                    crashDetailBean3.f821t++;
                    crashDetailBean3.f820s += crashDetailBean.f819r + "\n";
                    return crashDetailBean3;
                }
            }
        }
        crashDetailBean2 = null;
        if (crashDetailBean2 != null) {
            crashDetailBean3 = crashDetailBean2;
        } else {
            crashDetailBean.f811j = true;
            crashDetailBean.f821t = 0;
            crashDetailBean.f820s = "";
            crashDetailBean3 = crashDetailBean;
        }
        for (C0098a c0098a22 : list) {
            crashDetailBean3.f821t++;
            crashDetailBean3.f820s += c0098a22.f829b + "\n";
        }
        return crashDetailBean3.f819r == crashDetailBean.f819r ? crashDetailBean3 : crashDetailBean3;
    }

    /* renamed from: a */
    public final boolean m694a(CrashDetailBean crashDetailBean) {
        return m695a(crashDetailBean, -123456789);
    }

    /* renamed from: a */
    public final boolean m695a(CrashDetailBean crashDetailBean, int i) {
        int i2 = crashDetailBean.f803b;
        String str = crashDetailBean.f815n;
        str = crashDetailBean.f817p;
        str = crashDetailBean.f818q;
        long j = crashDetailBean.f819r;
        str = crashDetailBean.f814m;
        str = crashDetailBean.f806e;
        str = crashDetailBean.f804c;
        if (this.f867e != null && !this.f867e.m955c()) {
            return true;
        }
        if (crashDetailBean.f803b != 2) {
            C0141o c0141o = new C0141o();
            c0141o.f1135b = 1;
            c0141o.f1136c = crashDetailBean.f827z;
            c0141o.f1137d = crashDetailBean.f782A;
            c0141o.f1138e = crashDetailBean.f819r;
            C0139m c0139m = this.f865c;
            C0139m.m973b(1);
            this.f865c.m985a(c0141o);
            C0148u.m1037b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C0148u.m1037b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C0098a> b = m686b();
        List list = null;
        if (b != null && b.size() > 0) {
            List arrayList = new ArrayList(10);
            List arrayList2 = new ArrayList(10);
            arrayList.addAll(C0108b.m682a((List) b));
            b.removeAll(arrayList);
            if (!C0081b.f637a && C0111c.f878c) {
                int i3 = 0;
                for (C0098a c0098a : b) {
                    if (crashDetailBean.f822u.equals(c0098a.f830c)) {
                        if (c0098a.f832e) {
                            i3 = true;
                        }
                        arrayList2.add(c0098a);
                    }
                    i3 = i3;
                }
                if (i3 != 0 || arrayList2.size() + 1 >= 5) {
                    C0148u.m1035a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean a = m679a(arrayList2, crashDetailBean);
                    a.f802a = -1;
                    m697c(a);
                    arrayList.addAll(arrayList2);
                    C0108b.m688c(arrayList);
                    C0148u.m1037b("[crash] save crash success. this device crash many times, won't upload crashes immediately", new Object[0]);
                    return true;
                }
            }
            list = arrayList;
        }
        m697c(crashDetailBean);
        C0108b.m688c(list);
        C0148u.m1037b("[crash] save crash success", new Object[0]);
        return false;
    }

    /* renamed from: a */
    public final List<CrashDetailBean> m691a() {
        StrategyBean c = C0095a.m641a().m648c();
        if (c == null) {
            C0148u.m1040d("have not synced remote!", new Object[0]);
            return null;
        } else if (c.f753d) {
            long currentTimeMillis = System.currentTimeMillis();
            long o = C0124a.m838o();
            List b = m686b();
            if (b == null || b.size() <= 0) {
                return null;
            }
            List arrayList = new ArrayList();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                C0098a c0098a = (C0098a) it.next();
                if (c0098a.f829b < o - C0111c.f881f) {
                    it.remove();
                    arrayList.add(c0098a);
                } else if (c0098a.f831d) {
                    if (c0098a.f829b >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!c0098a.f832e) {
                        it.remove();
                        arrayList.add(c0098a);
                    }
                } else if (((long) c0098a.f833f) >= 3 && c0098a.f829b < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(c0098a);
                }
            }
            if (arrayList.size() > 0) {
                C0108b.m688c(arrayList);
            }
            List arrayList2 = new ArrayList();
            List<CrashDetailBean> b2 = m687b(b);
            if (b2 != null && b2.size() > 0) {
                String str = C0092a.m597a().f729i;
                Iterator it2 = b2.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean crashDetailBean = (CrashDetailBean) it2.next();
                    if (!str.equals(crashDetailBean.f807f)) {
                        it2.remove();
                        arrayList2.add(crashDetailBean);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                C0108b.m690d(arrayList2);
            }
            return b2;
        } else {
            C0148u.m1040d("Crashreport remote closed, please check your APPID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C0148u.m1037b("[init] WARNING! Crashreport closed by server, please check your APPID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public final void m692a(CrashDetailBean crashDetailBean, long j, boolean z) {
        C0148u.m1035a("try to upload right now", new Object[0]);
        List arrayList = new ArrayList();
        arrayList.add(crashDetailBean);
        m693a(arrayList, 5000, z);
        int i = crashDetailBean.f803b;
        if (this.f867e != null) {
            C0137l c0137l = this.f867e;
        }
    }

    /* renamed from: a */
    public final void m693a(final List<CrashDetailBean> list, long j, boolean z) {
        C0126j c0126j = null;
        if (!this.f866d.m648c().f753d) {
            C0148u.m1040d("remote report is disable!", new Object[0]);
            C0148u.m1037b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
        } else if (list != null && list.size() != 0) {
            try {
                Context context = this.f864b;
                C0092a a = C0092a.m597a();
                if (context == null || list == null || list.size() == 0 || a == null) {
                    C0148u.m1040d("enEXPPkg args == null!", new Object[0]);
                } else {
                    C0126j ajVar = new aj();
                    ajVar.f1014a = new ArrayList();
                    for (CrashDetailBean a2 : list) {
                        ajVar.f1014a.add(C0108b.m681a(context, a2, a));
                    }
                    c0126j = ajVar;
                }
                if (c0126j == null) {
                    C0148u.m1040d("create eupPkg fail!", new Object[0]);
                    return;
                }
                byte[] a3 = C0124a.m808a(c0126j);
                if (a3 == null) {
                    C0148u.m1040d("send encode fail!", new Object[0]);
                    return;
                }
                ak a4 = C0124a.m784a(this.f864b, 630, a3);
                if (a4 == null) {
                    C0148u.m1040d("request package is null.", new Object[0]);
                    return;
                }
                C0083q c01071 = new C0083q(this) {
                    /* renamed from: b */
                    private /* synthetic */ C0108b f862b;

                    /* renamed from: a */
                    public final void mo28a(boolean z) {
                        C0108b c0108b = this.f862b;
                        C0108b.m684a(z, list);
                    }
                };
                if (z) {
                    C0144r.m994a().m1014a(f863a, a4, null, c01071, true, j);
                    C0148u.m1035a("wake up!", new Object[0]);
                    return;
                }
                C0144r.m994a().m1013a(f863a, a4, null, c01071);
            } catch (Throwable th) {
                C0148u.m1041e("req cr error %s", th.toString());
                if (!C0148u.m1038b(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m684a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C0148u.m1039c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                C0148u.m1039c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f804c, Integer.valueOf(crashDetailBean.f813l), Boolean.valueOf(crashDetailBean.f805d), Boolean.valueOf(crashDetailBean.f811j));
                crashDetailBean.f813l++;
                crashDetailBean.f805d = z;
                C0148u.m1039c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f804c, Integer.valueOf(crashDetailBean.f813l), Boolean.valueOf(crashDetailBean.f805d), Boolean.valueOf(crashDetailBean.f811j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                C0111c.m698a().m704a(crashDetailBean2);
            }
            C0148u.m1039c("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            C0148u.m1037b("[crash] upload fail.", new Object[0]);
        }
    }

    /* renamed from: b */
    public final void m696b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            if (this.f868f != null || this.f867e != null) {
                try {
                    int i;
                    String b;
                    C0148u.m1035a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
                    switch (crashDetailBean.f803b) {
                        case 0:
                            i = 0;
                            break;
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 1;
                            break;
                        case 3:
                            i = 4;
                            break;
                        case 4:
                            i = 3;
                            break;
                        case 5:
                            i = 5;
                            break;
                        case 6:
                            i = 6;
                            break;
                        default:
                            return;
                    }
                    int i2 = crashDetailBean.f803b;
                    String str = crashDetailBean.f815n;
                    str = crashDetailBean.f817p;
                    str = crashDetailBean.f818q;
                    long j = crashDetailBean.f819r;
                    Map map = null;
                    if (this.f867e != null) {
                        C0137l c0137l = this.f867e;
                        b = this.f867e.m954b();
                        if (b != null) {
                            map = new HashMap(1);
                            map.put("userData", b);
                        }
                    } else if (this.f868f != null) {
                        map = this.f868f.onCrashHandleStart(i, crashDetailBean.f815n, crashDetailBean.f816o, crashDetailBean.f818q);
                    }
                    if (map != null && map.size() > 0) {
                        crashDetailBean.f795N = new LinkedHashMap(map.size());
                        for (Entry entry : map.entrySet()) {
                            b = (String) entry.getKey();
                            int i3 = (b == null || b.trim().length() <= 0) ? 1 : 0;
                            if (i3 == 0) {
                                b = (String) entry.getKey();
                                if (b.length() > 100) {
                                    b = b.substring(0, 100);
                                    C0148u.m1040d("setted key length is over limit %d substring to %s", Integer.valueOf(100), b);
                                }
                                String str2 = b;
                                b = (String) entry.getValue();
                                i3 = (b == null || b.trim().length() <= 0) ? 1 : 0;
                                if (i3 != 0 || ((String) entry.getValue()).length() <= 30000) {
                                    str = ((String) entry.getValue());
                                } else {
                                    str = ((String) entry.getValue()).substring(((String) entry.getValue()).length() - 30000);
                                    C0148u.m1040d("setted %s value length is over limit %d substring", str2, Integer.valueOf(30000));
                                }
                                crashDetailBean.f795N.put(str2, str);
                                C0148u.m1035a("add setted key %s value size:%d", str2, Integer.valueOf(str.length()));
                            }
                        }
                    }
                    C0148u.m1035a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    byte[] bArr = null;
                    if (this.f867e != null) {
                        bArr = this.f867e.m953a();
                    } else if (this.f868f != null) {
                        bArr = this.f868f.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.f815n, crashDetailBean.f816o, crashDetailBean.f818q);
                    }
                    crashDetailBean.f800S = bArr;
                    if (crashDetailBean.f800S != null) {
                        if (crashDetailBean.f800S.length > 30000) {
                            C0148u.m1040d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(crashDetailBean.f800S.length), Integer.valueOf(30000));
                            byte[] bArr2 = new byte[30000];
                            for (i2 = 0; i2 < 30000; i2++) {
                                bArr2[i2] = crashDetailBean.f800S[i2];
                            }
                        }
                        C0148u.m1035a("add extra bytes %d ", Integer.valueOf(crashDetailBean.f800S.length));
                    }
                } catch (Throwable th) {
                    C0148u.m1040d("crash handle callback somthing wrong! %s", th.getClass().getName());
                    if (!C0148u.m1036a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private static ContentValues m689d(CrashDetailBean crashDetailBean) {
        int i = 1;
        if (crashDetailBean == null) {
            return null;
        }
        try {
            int i2;
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f802a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f802a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f819r));
            contentValues.put("_s1", crashDetailBean.f822u);
            String str = "_up";
            if (crashDetailBean.f805d) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            contentValues.put(str, Integer.valueOf(i2));
            String str2 = "_me";
            if (!crashDetailBean.f811j) {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f813l));
            Parcel obtain = Parcel.obtain();
            crashDetailBean.writeToParcel(obtain, 0);
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
    private static CrashDetailBean m678a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C0124a.m790a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean == null) {
                return crashDetailBean;
            }
            crashDetailBean.f802a = j;
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: c */
    public final void m697c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            ContentValues d = C0108b.m689d(crashDetailBean);
            if (d != null) {
                long a = C0139m.m963a().m979a("t_cr", d, null, true);
                if (a >= 0) {
                    C0148u.m1039c("insert %s success!", "t_cr");
                    crashDetailBean.f802a = a;
                }
            }
        }
    }

    /* renamed from: b */
    private List<CrashDetailBean> m687b(List<C0098a> list) {
        Throwable th;
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (C0098a c0098a : list) {
            stringBuilder.append(" or _id").append(" = ").append(c0098a.f828a);
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() > 0) {
            stringBuilder2 = stringBuilder2.substring(4);
        }
        stringBuilder.setLength(0);
        Cursor a;
        try {
            a = C0139m.m963a().m980a("t_cr", null, stringBuilder2, null, null, true);
            if (a == null) {
                if (!(a == null || a.isClosed())) {
                    a.close();
                }
                return null;
            }
            try {
                List<CrashDetailBean> arrayList = new ArrayList();
                while (a.moveToNext()) {
                    CrashDetailBean a2 = C0108b.m678a(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        try {
                            stringBuilder.append(" or _id").append(" = ").append(a.getLong(a.getColumnIndex("_id")));
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
                String stringBuilder3 = stringBuilder.toString();
                if (stringBuilder3.length() > 0) {
                    int a3 = C0139m.m963a().m978a("t_cr", stringBuilder3.substring(4), null, null, true);
                    C0148u.m1040d("deleted %s illegle data %d", "t_cr", Integer.valueOf(a3));
                }
                if (!(a == null || a.isClosed())) {
                    a.close();
                }
                return arrayList;
            } catch (Throwable th22) {
                th = th22;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            a.close();
            throw th;
        }
    }

    /* renamed from: b */
    private static C0098a m685b(Cursor cursor) {
        boolean z = true;
        if (cursor == null) {
            return null;
        }
        try {
            C0098a c0098a = new C0098a();
            c0098a.f828a = cursor.getLong(cursor.getColumnIndex("_id"));
            c0098a.f829b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c0098a.f830c = cursor.getString(cursor.getColumnIndex("_s1"));
            c0098a.f831d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) != 1) {
                z = false;
            }
            c0098a.f832e = z;
            c0098a.f833f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c0098a;
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private List<C0098a> m686b() {
        Throwable th;
        Cursor cursor = null;
        List<C0098a> arrayList = new ArrayList();
        Cursor a;
        try {
            a = C0139m.m963a().m980a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (a == null) {
                if (!(a == null || a.isClosed())) {
                    a.close();
                }
                return null;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (a.moveToNext()) {
                    C0098a b = C0108b.m685b(a);
                    if (b != null) {
                        arrayList.add(b);
                    } else {
                        try {
                            stringBuilder.append(" or _id").append(" = ").append(a.getLong(a.getColumnIndex("_id")));
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
                String stringBuilder2 = stringBuilder.toString();
                if (stringBuilder2.length() > 0) {
                    int a2 = C0139m.m963a().m978a("t_cr", stringBuilder2.substring(4), null, null, true);
                    C0148u.m1040d("deleted %s illegle data %d", "t_cr", Integer.valueOf(a2));
                }
                if (!(a == null || a.isClosed())) {
                    a.close();
                }
                return arrayList;
            } catch (Throwable th22) {
                th = th22;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            a.close();
            throw th;
        }
    }

    /* renamed from: c */
    private static void m688c(List<C0098a> list) {
        if (list != null && list.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (C0098a c0098a : list) {
                stringBuilder.append(" or _id").append(" = ").append(c0098a.f828a);
            }
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 0) {
                stringBuilder2 = stringBuilder2.substring(4);
            }
            stringBuilder.setLength(0);
            try {
                int a = C0139m.m963a().m978a("t_cr", stringBuilder2, null, null, true);
                C0148u.m1039c("deleted %s data %d", "t_cr", Integer.valueOf(a));
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: d */
    private static void m690d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (CrashDetailBean crashDetailBean : list) {
                        stringBuilder.append(" or _id").append(" = ").append(crashDetailBean.f802a);
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    if (stringBuilder2.length() > 0) {
                        stringBuilder2 = stringBuilder2.substring(4);
                    }
                    stringBuilder.setLength(0);
                    int a = C0139m.m963a().m978a("t_cr", stringBuilder2, null, null, true);
                    C0148u.m1039c("deleted %s data %d", "t_cr", Integer.valueOf(a));
                }
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private static ai m681a(Context context, CrashDetailBean crashDetailBean, C0092a c0092a) {
        boolean z = true;
        if (context == null || crashDetailBean == null || c0092a == null) {
            C0148u.m1040d("enExp args == null", new Object[0]);
            return null;
        }
        ai aiVar = new ai();
        switch (crashDetailBean.f803b) {
            case 0:
                aiVar.f992a = crashDetailBean.f811j ? "200" : "100";
                break;
            case 1:
                aiVar.f992a = crashDetailBean.f811j ? "201" : "101";
                break;
            case 2:
                aiVar.f992a = crashDetailBean.f811j ? "202" : "102";
                break;
            case 3:
                aiVar.f992a = crashDetailBean.f811j ? "203" : "103";
                break;
            case 4:
                aiVar.f992a = crashDetailBean.f811j ? "204" : "104";
                break;
            case 5:
                aiVar.f992a = crashDetailBean.f811j ? "207" : "107";
                break;
            case 6:
                aiVar.f992a = crashDetailBean.f811j ? "206" : "106";
                break;
            default:
                C0148u.m1041e("crash type error! %d", Integer.valueOf(crashDetailBean.f803b));
                break;
        }
        aiVar.f993b = crashDetailBean.f819r;
        aiVar.f994c = crashDetailBean.f815n;
        aiVar.f995d = crashDetailBean.f816o;
        aiVar.f996e = crashDetailBean.f817p;
        aiVar.f998g = crashDetailBean.f818q;
        aiVar.f999h = crashDetailBean.f826y;
        aiVar.f1000i = crashDetailBean.f804c;
        aiVar.f1001j = null;
        aiVar.f1003l = crashDetailBean.f814m;
        aiVar.f1004m = crashDetailBean.f806e;
        aiVar.f997f = crashDetailBean.f782A;
        aiVar.f1011t = C0092a.m597a().m620h();
        aiVar.f1005n = null;
        if (crashDetailBean.f810i != null && crashDetailBean.f810i.size() > 0) {
            aiVar.f1006o = new ArrayList();
            for (Entry entry : crashDetailBean.f810i.entrySet()) {
                af afVar = new af();
                afVar.f972a = ((PlugInBean) entry.getValue()).f692a;
                afVar.f974c = ((PlugInBean) entry.getValue()).f694c;
                afVar.f975d = ((PlugInBean) entry.getValue()).f693b;
                afVar.f973b = c0092a.m629q();
                aiVar.f1006o.add(afVar);
            }
        }
        if (crashDetailBean.f809h != null && crashDetailBean.f809h.size() > 0) {
            aiVar.f1007p = new ArrayList();
            for (Entry entry2 : crashDetailBean.f809h.entrySet()) {
                afVar = new af();
                afVar.f972a = ((PlugInBean) entry2.getValue()).f692a;
                afVar.f974c = ((PlugInBean) entry2.getValue()).f694c;
                afVar.f975d = ((PlugInBean) entry2.getValue()).f693b;
                aiVar.f1007p.add(afVar);
            }
        }
        if (crashDetailBean.f811j) {
            int size;
            aiVar.f1002k = crashDetailBean.f821t;
            if (crashDetailBean.f820s != null && crashDetailBean.f820s.length() > 0) {
                if (aiVar.f1008q == null) {
                    aiVar.f1008q = new ArrayList();
                }
                try {
                    aiVar.f1008q.add(new ah((byte) 1, "alltimes.txt", crashDetailBean.f820s.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    aiVar.f1008q = null;
                }
            }
            String str = "crashcount:%d sz:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(aiVar.f1002k);
            if (aiVar.f1008q != null) {
                size = aiVar.f1008q.size();
            } else {
                size = 0;
            }
            objArr[1] = Integer.valueOf(size);
            C0148u.m1039c(str, objArr);
        }
        if (crashDetailBean.f824w != null) {
            if (aiVar.f1008q == null) {
                aiVar.f1008q = new ArrayList();
            }
            try {
                aiVar.f1008q.add(new ah((byte) 1, "log.txt", crashDetailBean.f824w.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                aiVar.f1008q = null;
            }
        }
        if (crashDetailBean.f825x != null && crashDetailBean.f825x.length > 0) {
            ah ahVar = new ah((byte) 2, "buglylog.zip", crashDetailBean.f825x);
            C0148u.m1039c("attach user log", new Object[0]);
            if (aiVar.f1008q == null) {
                aiVar.f1008q = new ArrayList();
            }
            aiVar.f1008q.add(ahVar);
        }
        if (crashDetailBean.f803b == 3) {
            if (aiVar.f1008q == null) {
                aiVar.f1008q = new ArrayList();
            }
            if (crashDetailBean.f795N != null && crashDetailBean.f795N.containsKey("BUGLY_CR_01")) {
                try {
                    aiVar.f1008q.add(new ah((byte) 1, "anrMessage.txt", ((String) crashDetailBean.f795N.get("BUGLY_CR_01")).getBytes("utf-8")));
                    C0148u.m1039c("attach anr message", new Object[0]);
                } catch (UnsupportedEncodingException e22) {
                    e22.printStackTrace();
                    aiVar.f1008q = null;
                }
                crashDetailBean.f795N.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.f823v != null) {
                ahVar = C0108b.m680a("trace.zip", context, crashDetailBean.f823v);
                if (ahVar != null) {
                    C0148u.m1039c("attach traces", new Object[0]);
                    aiVar.f1008q.add(ahVar);
                }
            }
        }
        if (crashDetailBean.f803b == 1) {
            if (aiVar.f1008q == null) {
                aiVar.f1008q = new ArrayList();
            }
            if (crashDetailBean.f823v != null) {
                ahVar = C0108b.m680a("tomb.zip", context, crashDetailBean.f823v);
                if (ahVar != null) {
                    C0148u.m1039c("attach tombs", new Object[0]);
                    aiVar.f1008q.add(ahVar);
                }
            }
        }
        if (crashDetailBean.f800S != null && crashDetailBean.f800S.length > 0) {
            if (aiVar.f1008q == null) {
                aiVar.f1008q = new ArrayList();
            }
            aiVar.f1008q.add(new ah((byte) 1, "userExtraByteData", crashDetailBean.f800S));
            C0148u.m1039c("attach extraData", new Object[0]);
        }
        aiVar.f1009r = new HashMap();
        aiVar.f1009r.put("A9", crashDetailBean.f783B);
        aiVar.f1009r.put("A11", crashDetailBean.f784C);
        aiVar.f1009r.put("A10", crashDetailBean.f785D);
        aiVar.f1009r.put("A23", crashDetailBean.f807f);
        aiVar.f1009r.put("A7", c0092a.f725e);
        aiVar.f1009r.put("A6", c0092a.m630r());
        aiVar.f1009r.put("A5", c0092a.m629q());
        aiVar.f1009r.put("A22", c0092a.m618g());
        aiVar.f1009r.put("A2", crashDetailBean.f787F);
        aiVar.f1009r.put("A1", crashDetailBean.f786E);
        aiVar.f1009r.put("A24", c0092a.f727g);
        aiVar.f1009r.put("A17", crashDetailBean.f788G);
        aiVar.f1009r.put("A3", c0092a.m622j());
        aiVar.f1009r.put("A16", c0092a.m624l());
        aiVar.f1009r.put("A25", c0092a.m625m());
        aiVar.f1009r.put("A14", c0092a.m623k());
        aiVar.f1009r.put("A15", c0092a.m632t());
        aiVar.f1009r.put("A13", c0092a.m633u());
        aiVar.f1009r.put("A34", crashDetailBean.f827z);
        if (c0092a.f743w != null) {
            aiVar.f1009r.put("productIdentify", c0092a.f743w);
        }
        try {
            aiVar.f1009r.put("A26", URLEncoder.encode(crashDetailBean.f789H, "utf-8"));
        } catch (UnsupportedEncodingException e222) {
            e222.printStackTrace();
        }
        if (crashDetailBean.f803b == 1) {
            aiVar.f1009r.put("A27", crashDetailBean.f791J);
            aiVar.f1009r.put("A28", crashDetailBean.f790I);
            aiVar.f1009r.put("A29", crashDetailBean.f812k);
        }
        aiVar.f1009r.put("A30", crashDetailBean.f792K);
        aiVar.f1009r.put("A18", crashDetailBean.f793L);
        aiVar.f1009r.put("A36", (!crashDetailBean.f794M));
        aiVar.f1009r.put("F02", c0092a.f736p);
        aiVar.f1009r.put("F03", c0092a.f737q);
        aiVar.f1009r.put("F04", c0092a.m612d());
        aiVar.f1009r.put("F05", c0092a.f738r);
        aiVar.f1009r.put("F06", c0092a.f735o);
        aiVar.f1009r.put("F08", c0092a.f741u);
        aiVar.f1009r.put("F09", c0092a.f742v);
        aiVar.f1009r.put("F10", c0092a.f739s);
        if (crashDetailBean.f796O >= 0) {
            aiVar.f1009r.put("C01", crashDetailBean.f796O);
        }
        if (crashDetailBean.f797P >= 0) {
            aiVar.f1009r.put("C02", crashDetailBean.f797P);
        }
        if (crashDetailBean.f798Q != null && crashDetailBean.f798Q.size() > 0) {
            for (Entry entry22 : crashDetailBean.f798Q.entrySet()) {
                aiVar.f1009r.put("C03_" + ((String) entry22.getKey()), entry22.getValue());
            }
        }
        if (crashDetailBean.f799R != null && crashDetailBean.f799R.size() > 0) {
            for (Entry entry222 : crashDetailBean.f799R.entrySet()) {
                aiVar.f1009r.put("C04_" + ((String) entry222.getKey()), entry222.getValue());
            }
        }
        aiVar.f1010s = null;
        if (crashDetailBean.f795N != null && crashDetailBean.f795N.size() > 0) {
            aiVar.f1010s = crashDetailBean.f795N;
            C0148u.m1035a("setted message size %d", Integer.valueOf(aiVar.f1010s.size()));
        }
        String str2 = "%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d";
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.f815n;
        objArr2[1] = crashDetailBean.f804c;
        objArr2[2] = c0092a.m612d();
        objArr2[3] = Long.valueOf((crashDetailBean.f819r - crashDetailBean.f793L) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.f812k);
        objArr2[5] = Boolean.valueOf(crashDetailBean.f794M);
        objArr2[6] = Boolean.valueOf(crashDetailBean.f811j);
        if (crashDetailBean.f803b != 1) {
            z = false;
        }
        objArr2[7] = Boolean.valueOf(z);
        objArr2[8] = Integer.valueOf(crashDetailBean.f821t);
        objArr2[9] = crashDetailBean.f820s;
        objArr2[10] = Boolean.valueOf(crashDetailBean.f805d);
        objArr2[11] = Integer.valueOf(aiVar.f1009r.size());
        C0148u.m1039c(str2, objArr2);
        return aiVar;
    }

    /* renamed from: a */
    private static ah m680a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        Throwable e;
        Throwable th;
        if (str2 == null || context == null) {
            C0148u.m1040d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        C0148u.m1039c("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (C0124a.m803a(file, file2, 5000)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[1000];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                        byteArrayOutputStream.flush();
                    }
                    C0148u.m1039c("read bytes :%d", Integer.valueOf(byteArrayOutputStream.toByteArray().length));
                    ah ahVar = new ah((byte) 2, file2.getName(), bArr);
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        if (!C0148u.m1036a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                    if (file2.exists()) {
                        C0148u.m1039c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return ahVar;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!C0148u.m1036a(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                if (!C0148u.m1036a(th3)) {
                                    th3.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            return null;
                        }
                        C0148u.m1039c("del tmp", new Object[0]);
                        file2.delete();
                        return null;
                    } catch (Throwable th4) {
                        e2 = th4;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th32) {
                                if (!C0148u.m1036a(th32)) {
                                    th32.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            C0148u.m1039c("del tmp", new Object[0]);
                            file2.delete();
                        }
                        throw e2;
                    }
                }
            } catch (Throwable th322) {
                fileInputStream = null;
                e2 = th322;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (file2.exists()) {
                    C0148u.m1039c("del tmp", new Object[0]);
                    file2.delete();
                }
                throw e2;
            }
        }
        C0148u.m1040d("zip fail!", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static void m683a(String str, String str2, String str3, Thread thread, String str4, CrashDetailBean crashDetailBean) {
        C0092a a = C0092a.m597a();
        if (a != null) {
            int i;
            C0148u.m1041e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
            C0148u.m1041e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
            C0148u.m1041e("# PKG NAME: %s", a.f723c);
            C0148u.m1041e("# APP VER: %s", a.f729i);
            C0148u.m1041e("# LAUNCH TIME: %s", C0124a.m796a(new Date(C0092a.m597a().f721a)));
            C0148u.m1041e("# CRASH TYPE: %s", str);
            C0148u.m1041e("# CRASH TIME: %s", str2);
            C0148u.m1041e("# CRASH PROCESS: %s", str3);
            if (thread != null) {
                C0148u.m1041e("# CRASH THREAD: %s", thread.getName());
            }
            if (crashDetailBean != null) {
                C0148u.m1041e("# REPORT ID: %s", crashDetailBean.f804c);
                String str5 = "# CRASH DEVICE: %s %s";
                Object[] objArr = new Object[2];
                objArr[0] = a.f726f;
                objArr[1] = a.m633u().booleanValue() ? "ROOTED" : "UNROOT";
                C0148u.m1041e(str5, objArr);
                C0148u.m1041e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f783B), Long.valueOf(crashDetailBean.f784C), Long.valueOf(crashDetailBean.f785D));
                C0148u.m1041e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f786E), Long.valueOf(crashDetailBean.f787F), Long.valueOf(crashDetailBean.f788G));
                String str6 = crashDetailBean.f791J;
                if (str6 == null || str6.trim().length() <= 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    C0148u.m1041e("# EXCEPTION FIRED BY %s %s", crashDetailBean.f791J, crashDetailBean.f790I);
                } else if (crashDetailBean.f803b == 3) {
                    str5 = "# EXCEPTION ANR MESSAGE:\n %s";
                    objArr = new Object[1];
                    objArr[0] = crashDetailBean.f795N == null ? "null" : ((String) crashDetailBean.f795N.get("BUGLY_CR_01"));
                    C0148u.m1041e(str5, objArr);
                }
            }
            if (str4 == null || str4.trim().length() <= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                C0148u.m1041e("# CRASH STACK: ", new Object[0]);
                C0148u.m1041e(str4, new Object[0]);
            }
            C0148u.m1041e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
        }
    }
}
