package com.tencent.bugly.legu.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import com.tencent.bugly.legu.BuglyStrategy.C0003a;
import com.tencent.bugly.legu.C0005b;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.info.PlugInBean;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.legu.proguard.C0007s;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0049j;
import com.tencent.bugly.legu.proguard.C0062n;
import com.tencent.bugly.legu.proguard.C0064o;
import com.tencent.bugly.legu.proguard.C0066q;
import com.tencent.bugly.legu.proguard.C0069t;
import com.tencent.bugly.legu.proguard.C0073w;
import com.tencent.bugly.legu.proguard.ah;
import com.tencent.bugly.legu.proguard.aj;
import com.tencent.bugly.legu.proguard.ak;
import com.tencent.bugly.legu.proguard.al;
import com.tencent.bugly.legu.proguard.am;
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
/* renamed from: com.tencent.bugly.legu.crashreport.crash.b */
public final class C0032b {
    /* renamed from: a */
    private static int f256a = 0;
    /* renamed from: b */
    private Context f257b;
    /* renamed from: c */
    private C0064o f258c;
    /* renamed from: d */
    private C0019a f259d;
    /* renamed from: e */
    private C0062n f260e;
    /* renamed from: f */
    private C0003a f261f;

    public C0032b(int i, Context context, C0069t c0069t, C0064o c0064o, C0019a c0019a, C0003a c0003a, C0062n c0062n) {
        f256a = i;
        this.f257b = context;
        this.f258c = c0064o;
        this.f259d = c0019a;
        this.f261f = c0003a;
        this.f260e = c0062n;
    }

    /* renamed from: a */
    private static List<C0022a> m155a(List<C0022a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long o = C0048a.m304o();
        List<C0022a> arrayList = new ArrayList();
        for (C0022a c0022a : list) {
            if (c0022a.f224d && c0022a.f222b < o - 86400000) {
                arrayList.add(c0022a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private CrashDetailBean m152a(List<C0022a> list, CrashDetailBean crashDetailBean) {
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2;
        CrashDetailBean crashDetailBean3 = null;
        List arrayList = new ArrayList(10);
        for (C0022a c0022a : list) {
            if (c0022a.f225e) {
                arrayList.add(c0022a);
            }
        }
        if (arrayList.size() > 0) {
            List b = m160b(arrayList);
            if (b != null && b.size() > 0) {
                Collections.sort(b);
                int i = 0;
                while (i < b.size()) {
                    crashDetailBean2 = (CrashDetailBean) b.get(i);
                    if (i != 0) {
                        if (crashDetailBean2.f213s != null) {
                            String[] split = crashDetailBean2.f213s.split("\n");
                            if (split != null) {
                                for (String str : split) {
                                    if (!crashDetailBean3.f213s.contains(str)) {
                                        crashDetailBean3.f214t++;
                                        crashDetailBean3.f213s += str + "\n";
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
                    crashDetailBean.f204j = true;
                    crashDetailBean.f214t = 0;
                    crashDetailBean.f213s = "";
                    crashDetailBean3 = crashDetailBean;
                } else {
                    crashDetailBean3 = crashDetailBean2;
                }
                for (C0022a c0022a2 : list) {
                    if (!(c0022a2.f225e || c0022a2.f224d || crashDetailBean3.f213s.contains(c0022a2.f222b))) {
                        crashDetailBean3.f214t++;
                        crashDetailBean3.f213s += c0022a2.f222b + "\n";
                    }
                }
                if (crashDetailBean3.f212r == crashDetailBean.f212r && !crashDetailBean3.f213s.contains(crashDetailBean.f212r)) {
                    crashDetailBean3.f214t++;
                    crashDetailBean3.f213s += crashDetailBean.f212r + "\n";
                    return crashDetailBean3;
                }
            }
        }
        crashDetailBean2 = null;
        if (crashDetailBean2 != null) {
            crashDetailBean3 = crashDetailBean2;
        } else {
            crashDetailBean.f204j = true;
            crashDetailBean.f214t = 0;
            crashDetailBean.f213s = "";
            crashDetailBean3 = crashDetailBean;
        }
        for (C0022a c0022a22 : list) {
            crashDetailBean3.f214t++;
            crashDetailBean3.f213s += c0022a22.f222b + "\n";
        }
        return crashDetailBean3.f212r == crashDetailBean.f212r ? crashDetailBean3 : crashDetailBean3;
    }

    /* renamed from: a */
    public final boolean m167a(CrashDetailBean crashDetailBean) {
        return m168a(crashDetailBean, -123456789);
    }

    /* renamed from: a */
    public final boolean m168a(CrashDetailBean crashDetailBean, int i) {
        int i2 = crashDetailBean.f196b;
        String str = crashDetailBean.f208n;
        str = crashDetailBean.f210p;
        str = crashDetailBean.f211q;
        long j = crashDetailBean.f212r;
        str = crashDetailBean.f207m;
        str = crashDetailBean.f199e;
        str = crashDetailBean.f197c;
        if (this.f260e != null && !this.f260e.m431c()) {
            return true;
        }
        if (crashDetailBean.f196b != 2) {
            C0066q c0066q = new C0066q();
            c0066q.f537b = 1;
            c0066q.f538c = crashDetailBean.f220z;
            c0066q.f539d = crashDetailBean.f175A;
            c0066q.f540e = crashDetailBean.f212r;
            C0064o c0064o = this.f258c;
            C0064o.m451b(1);
            this.f258c.m468a(c0066q);
            C0073w.m521b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C0073w.m521b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C0022a> b = m159b();
        List list = null;
        if (b != null && b.size() > 0) {
            List arrayList = new ArrayList(10);
            List arrayList2 = new ArrayList(10);
            arrayList.addAll(C0032b.m155a((List) b));
            b.removeAll(arrayList);
            if (!C0005b.f34b && C0035c.f271c) {
                int i3 = 0;
                for (C0022a c0022a : b) {
                    if (crashDetailBean.f215u.equals(c0022a.f223c)) {
                        if (c0022a.f225e) {
                            i3 = true;
                        }
                        arrayList2.add(c0022a);
                    }
                    i3 = i3;
                }
                if (i3 != 0 || arrayList2.size() + 1 >= 5) {
                    C0073w.m519a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean a = m152a(arrayList2, crashDetailBean);
                    a.f195a = -1;
                    m170c(a);
                    arrayList.addAll(arrayList2);
                    C0032b.m161c(arrayList);
                    C0073w.m521b("[crash] save crash success. this device crash many times, won't upload crashes immediately", new Object[0]);
                    return true;
                }
            }
            list = arrayList;
        }
        m170c(crashDetailBean);
        C0032b.m161c(list);
        C0073w.m521b("[crash] save crash success", new Object[0]);
        return false;
    }

    /* renamed from: a */
    public final List<CrashDetailBean> m164a() {
        StrategyBean c = C0019a.m114a().m121c();
        if (c == null) {
            C0073w.m524d("have not synced remote!", new Object[0]);
            return null;
        } else if (c.f146d) {
            long currentTimeMillis = System.currentTimeMillis();
            long o = C0048a.m304o();
            List b = m159b();
            if (b == null || b.size() <= 0) {
                return null;
            }
            List arrayList = new ArrayList();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                C0022a c0022a = (C0022a) it.next();
                if (c0022a.f222b < o - C0035c.f274f) {
                    it.remove();
                    arrayList.add(c0022a);
                } else if (c0022a.f224d) {
                    if (c0022a.f222b >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!c0022a.f225e) {
                        it.remove();
                        arrayList.add(c0022a);
                    }
                } else if (((long) c0022a.f226f) >= 3 && c0022a.f222b < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(c0022a);
                }
            }
            if (arrayList.size() > 0) {
                C0032b.m161c(arrayList);
            }
            List arrayList2 = new ArrayList();
            List<CrashDetailBean> b2 = m160b(b);
            if (b2 != null && b2.size() > 0) {
                String str = C0016a.m69a().f122i;
                Iterator it2 = b2.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean crashDetailBean = (CrashDetailBean) it2.next();
                    if (!str.equals(crashDetailBean.f200f)) {
                        it2.remove();
                        arrayList2.add(crashDetailBean);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                C0032b.m163d(arrayList2);
            }
            return b2;
        } else {
            C0073w.m524d("Crashreport remote closed, please check your APPID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C0073w.m521b("[init] WARNING! Crashreport closed by server, please check your APPID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public final void m165a(CrashDetailBean crashDetailBean, long j, boolean z) {
        C0073w.m519a("try to upload right now", new Object[0]);
        List arrayList = new ArrayList();
        arrayList.add(crashDetailBean);
        m166a(arrayList, 5000, z);
        int i = crashDetailBean.f196b;
        if (this.f260e != null) {
            C0062n c0062n = this.f260e;
        }
    }

    /* renamed from: a */
    public final void m166a(final List<CrashDetailBean> list, long j, boolean z) {
        C0049j c0049j = null;
        if (!this.f259d.m121c().f146d) {
            C0073w.m524d("remote report is disable!", new Object[0]);
            C0073w.m521b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
        } else if (list != null && list.size() != 0) {
            try {
                Context context = this.f257b;
                C0016a a = C0016a.m69a();
                if (context == null || list == null || list.size() == 0 || a == null) {
                    C0073w.m524d("enEXPPkg args == null!", new Object[0]);
                } else {
                    C0049j alVar = new al();
                    alVar.f407a = new ArrayList();
                    for (CrashDetailBean a2 : list) {
                        alVar.f407a.add(C0032b.m154a(context, a2, a));
                    }
                    c0049j = alVar;
                }
                if (c0049j == null) {
                    C0073w.m524d("create eupPkg fail!", new Object[0]);
                    return;
                }
                byte[] a3 = C0048a.m274a(c0049j);
                if (a3 == null) {
                    C0073w.m524d("send encode fail!", new Object[0]);
                    return;
                }
                am a4 = C0048a.m250a(this.f257b, 630, a3);
                if (a4 == null) {
                    C0073w.m524d("request package is null.", new Object[0]);
                    return;
                }
                C0007s c00311 = new C0007s(this) {
                    /* renamed from: b */
                    private /* synthetic */ C0032b f255b;

                    /* renamed from: a */
                    public final void mo5a(boolean z) {
                        C0032b c0032b = this.f255b;
                        C0032b.m157a(z, list);
                    }
                };
                if (z) {
                    C0069t.m478a().m498a(f256a, a4, null, c00311, true, j);
                    C0073w.m519a("wake up!", new Object[0]);
                    return;
                }
                C0069t.m478a().m497a(f256a, a4, null, c00311);
            } catch (Throwable th) {
                C0073w.m525e("req cr error %s", th.toString());
                if (!C0073w.m522b(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m157a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C0073w.m523c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                C0073w.m523c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f197c, Integer.valueOf(crashDetailBean.f206l), Boolean.valueOf(crashDetailBean.f198d), Boolean.valueOf(crashDetailBean.f204j));
                crashDetailBean.f206l++;
                crashDetailBean.f198d = z;
                C0073w.m523c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f197c, Integer.valueOf(crashDetailBean.f206l), Boolean.valueOf(crashDetailBean.f198d), Boolean.valueOf(crashDetailBean.f204j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                C0035c.m171a().m177a(crashDetailBean2);
            }
            C0073w.m523c("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            C0073w.m521b("[crash] upload fail.", new Object[0]);
        }
    }

    /* renamed from: b */
    public final void m169b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            if (this.f261f != null || this.f260e != null) {
                try {
                    int i;
                    String b;
                    C0073w.m519a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
                    switch (crashDetailBean.f196b) {
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
                    int i2 = crashDetailBean.f196b;
                    String str = crashDetailBean.f208n;
                    str = crashDetailBean.f210p;
                    str = crashDetailBean.f211q;
                    long j = crashDetailBean.f212r;
                    Map map = null;
                    if (this.f260e != null) {
                        C0062n c0062n = this.f260e;
                        b = this.f260e.m430b();
                        if (b != null) {
                            map = new HashMap(1);
                            map.put("userData", b);
                        }
                    } else if (this.f261f != null) {
                        map = this.f261f.onCrashHandleStart(i, crashDetailBean.f208n, crashDetailBean.f209o, crashDetailBean.f211q);
                    }
                    if (map != null && map.size() > 0) {
                        crashDetailBean.f188N = new LinkedHashMap(map.size());
                        for (Entry entry : map.entrySet()) {
                            b = (String) entry.getKey();
                            int i3 = (b == null || b.trim().length() <= 0) ? 1 : 0;
                            if (i3 == 0) {
                                b = (String) entry.getKey();
                                if (b.length() > 100) {
                                    b = b.substring(0, 100);
                                    C0073w.m524d("setted key length is over limit %d substring to %s", Integer.valueOf(100), b);
                                }
                                String str2 = b;
                                b = (String) entry.getValue();
                                i3 = (b == null || b.trim().length() <= 0) ? 1 : 0;
                                if (i3 != 0 || ((String) entry.getValue()).length() <= 30000) {
                                    str = ((String) entry.getValue());
                                } else {
                                    str = ((String) entry.getValue()).substring(((String) entry.getValue()).length() - 30000);
                                    C0073w.m524d("setted %s value length is over limit %d substring", str2, Integer.valueOf(30000));
                                }
                                crashDetailBean.f188N.put(str2, str);
                                C0073w.m519a("add setted key %s value size:%d", str2, Integer.valueOf(str.length()));
                            }
                        }
                    }
                    C0073w.m519a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    byte[] bArr = null;
                    if (this.f260e != null) {
                        bArr = this.f260e.m429a();
                    } else if (this.f261f != null) {
                        bArr = this.f261f.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.f208n, crashDetailBean.f209o, crashDetailBean.f211q);
                    }
                    crashDetailBean.f193S = bArr;
                    if (crashDetailBean.f193S != null) {
                        if (crashDetailBean.f193S.length > 30000) {
                            C0073w.m524d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(crashDetailBean.f193S.length), Integer.valueOf(30000));
                        }
                        C0073w.m519a("add extra bytes %d ", Integer.valueOf(crashDetailBean.f193S.length));
                    }
                } catch (Throwable th) {
                    C0073w.m524d("crash handle callback somthing wrong! %s", th.getClass().getName());
                    if (!C0073w.m520a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private static ContentValues m162d(CrashDetailBean crashDetailBean) {
        int i = 1;
        if (crashDetailBean == null) {
            return null;
        }
        try {
            int i2;
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f195a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f195a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f212r));
            contentValues.put("_s1", crashDetailBean.f215u);
            String str = "_up";
            if (crashDetailBean.f198d) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            contentValues.put(str, Integer.valueOf(i2));
            String str2 = "_me";
            if (!crashDetailBean.f204j) {
                i = 0;
            }
            contentValues.put(str2, Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f206l));
            Parcel obtain = Parcel.obtain();
            crashDetailBean.writeToParcel(obtain, 0);
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
    private static CrashDetailBean m151a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C0048a.m256a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean == null) {
                return crashDetailBean;
            }
            crashDetailBean.f195a = j;
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: c */
    public final void m170c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            ContentValues d = C0032b.m162d(crashDetailBean);
            if (d != null) {
                long a = C0064o.m440a().m459a("t_cr", d, null, true);
                if (a >= 0) {
                    C0073w.m523c("insert %s success!", "t_cr");
                    crashDetailBean.f195a = a;
                }
            }
        }
    }

    /* renamed from: b */
    private List<CrashDetailBean> m160b(List<C0022a> list) {
        Throwable th;
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (C0022a c0022a : list) {
            stringBuilder.append(" or _id").append(" = ").append(c0022a.f221a);
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() > 0) {
            stringBuilder2 = stringBuilder2.substring(4);
        }
        stringBuilder.setLength(0);
        Cursor a;
        try {
            a = C0064o.m440a().m460a("t_cr", null, stringBuilder2, null, null, true);
            if (a == null) {
                if (!(a == null || a.isClosed())) {
                    a.close();
                }
                return null;
            }
            try {
                List<CrashDetailBean> arrayList = new ArrayList();
                while (a.moveToNext()) {
                    CrashDetailBean a2 = C0032b.m151a(a);
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
                    int a3 = C0064o.m440a().m458a("t_cr", stringBuilder3.substring(4), null, null, true);
                    C0073w.m524d("deleted %s illegle data %d", "t_cr", Integer.valueOf(a3));
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
    private static C0022a m158b(Cursor cursor) {
        boolean z = true;
        if (cursor == null) {
            return null;
        }
        try {
            C0022a c0022a = new C0022a();
            c0022a.f221a = cursor.getLong(cursor.getColumnIndex("_id"));
            c0022a.f222b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c0022a.f223c = cursor.getString(cursor.getColumnIndex("_s1"));
            c0022a.f224d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) != 1) {
                z = false;
            }
            c0022a.f225e = z;
            c0022a.f226f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c0022a;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private List<C0022a> m159b() {
        Throwable th;
        Cursor cursor = null;
        List<C0022a> arrayList = new ArrayList();
        Cursor a;
        try {
            a = C0064o.m440a().m460a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (a == null) {
                if (!(a == null || a.isClosed())) {
                    a.close();
                }
                return null;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (a.moveToNext()) {
                    C0022a b = C0032b.m158b(a);
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
                    int a2 = C0064o.m440a().m458a("t_cr", stringBuilder2.substring(4), null, null, true);
                    C0073w.m524d("deleted %s illegle data %d", "t_cr", Integer.valueOf(a2));
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
    private static void m161c(List<C0022a> list) {
        if (list != null && list.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (C0022a c0022a : list) {
                stringBuilder.append(" or _id").append(" = ").append(c0022a.f221a);
            }
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 0) {
                stringBuilder2 = stringBuilder2.substring(4);
            }
            stringBuilder.setLength(0);
            try {
                int a = C0064o.m440a().m458a("t_cr", stringBuilder2, null, null, true);
                C0073w.m523c("deleted %s data %d", "t_cr", Integer.valueOf(a));
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: d */
    private static void m163d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (CrashDetailBean crashDetailBean : list) {
                        stringBuilder.append(" or _id").append(" = ").append(crashDetailBean.f195a);
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    if (stringBuilder2.length() > 0) {
                        stringBuilder2 = stringBuilder2.substring(4);
                    }
                    stringBuilder.setLength(0);
                    int a = C0064o.m440a().m458a("t_cr", stringBuilder2, null, null, true);
                    C0073w.m523c("deleted %s data %d", "t_cr", Integer.valueOf(a));
                }
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private static ak m154a(Context context, CrashDetailBean crashDetailBean, C0016a c0016a) {
        boolean z = true;
        if (context == null || crashDetailBean == null || c0016a == null) {
            C0073w.m524d("enExp args == null", new Object[0]);
            return null;
        }
        ak akVar = new ak();
        switch (crashDetailBean.f196b) {
            case 0:
                akVar.f385a = crashDetailBean.f204j ? "200" : "100";
                break;
            case 1:
                akVar.f385a = crashDetailBean.f204j ? "201" : "101";
                break;
            case 2:
                akVar.f385a = crashDetailBean.f204j ? "202" : "102";
                break;
            case 3:
                akVar.f385a = crashDetailBean.f204j ? "203" : "103";
                break;
            case 4:
                akVar.f385a = crashDetailBean.f204j ? "204" : "104";
                break;
            case 5:
                akVar.f385a = crashDetailBean.f204j ? "207" : "107";
                break;
            case 6:
                akVar.f385a = crashDetailBean.f204j ? "206" : "106";
                break;
            default:
                C0073w.m525e("crash type error! %d", Integer.valueOf(crashDetailBean.f196b));
                break;
        }
        akVar.f386b = crashDetailBean.f212r;
        akVar.f387c = crashDetailBean.f208n;
        akVar.f388d = crashDetailBean.f209o;
        akVar.f389e = crashDetailBean.f210p;
        akVar.f391g = crashDetailBean.f211q;
        akVar.f392h = crashDetailBean.f219y;
        akVar.f393i = crashDetailBean.f197c;
        akVar.f394j = null;
        akVar.f396l = crashDetailBean.f207m;
        akVar.f397m = crashDetailBean.f199e;
        akVar.f390f = crashDetailBean.f175A;
        akVar.f404t = C0016a.m69a().m93h();
        akVar.f398n = null;
        if (crashDetailBean.f203i != null && crashDetailBean.f203i.size() > 0) {
            akVar.f399o = new ArrayList();
            for (Entry entry : crashDetailBean.f203i.entrySet()) {
                ah ahVar = new ah();
                ahVar.f365a = ((PlugInBean) entry.getValue()).f85a;
                ahVar.f367c = ((PlugInBean) entry.getValue()).f87c;
                ahVar.f368d = ((PlugInBean) entry.getValue()).f86b;
                ahVar.f366b = c0016a.m102q();
                akVar.f399o.add(ahVar);
            }
        }
        if (crashDetailBean.f202h != null && crashDetailBean.f202h.size() > 0) {
            akVar.f400p = new ArrayList();
            for (Entry entry2 : crashDetailBean.f202h.entrySet()) {
                ahVar = new ah();
                ahVar.f365a = ((PlugInBean) entry2.getValue()).f85a;
                ahVar.f367c = ((PlugInBean) entry2.getValue()).f87c;
                ahVar.f368d = ((PlugInBean) entry2.getValue()).f86b;
                akVar.f400p.add(ahVar);
            }
        }
        if (crashDetailBean.f204j) {
            int size;
            akVar.f395k = crashDetailBean.f214t;
            if (crashDetailBean.f213s != null && crashDetailBean.f213s.length() > 0) {
                if (akVar.f401q == null) {
                    akVar.f401q = new ArrayList();
                }
                try {
                    akVar.f401q.add(new aj((byte) 1, "alltimes.txt", crashDetailBean.f213s.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    akVar.f401q = null;
                }
            }
            String str = "crashcount:%d sz:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(akVar.f395k);
            if (akVar.f401q != null) {
                size = akVar.f401q.size();
            } else {
                size = 0;
            }
            objArr[1] = Integer.valueOf(size);
            C0073w.m523c(str, objArr);
        }
        if (crashDetailBean.f217w != null) {
            if (akVar.f401q == null) {
                akVar.f401q = new ArrayList();
            }
            try {
                akVar.f401q.add(new aj((byte) 1, "log.txt", crashDetailBean.f217w.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                akVar.f401q = null;
            }
        }
        if (crashDetailBean.f218x != null && crashDetailBean.f218x.length > 0) {
            aj ajVar = new aj((byte) 2, "buglylog.zip", crashDetailBean.f218x);
            C0073w.m523c("attach user log", new Object[0]);
            if (akVar.f401q == null) {
                akVar.f401q = new ArrayList();
            }
            akVar.f401q.add(ajVar);
        }
        if (crashDetailBean.f196b == 3) {
            if (akVar.f401q == null) {
                akVar.f401q = new ArrayList();
            }
            if (crashDetailBean.f188N != null && crashDetailBean.f188N.containsKey("BUGLY_CR_01")) {
                try {
                    akVar.f401q.add(new aj((byte) 1, "anrMessage.txt", ((String) crashDetailBean.f188N.get("BUGLY_CR_01")).getBytes("utf-8")));
                    C0073w.m523c("attach anr message", new Object[0]);
                } catch (UnsupportedEncodingException e22) {
                    e22.printStackTrace();
                    akVar.f401q = null;
                }
                crashDetailBean.f188N.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.f216v != null) {
                ajVar = C0032b.m153a("trace.zip", context, crashDetailBean.f216v);
                if (ajVar != null) {
                    C0073w.m523c("attach traces", new Object[0]);
                    akVar.f401q.add(ajVar);
                }
            }
        }
        if (crashDetailBean.f196b == 1) {
            if (akVar.f401q == null) {
                akVar.f401q = new ArrayList();
            }
            if (crashDetailBean.f216v != null) {
                ajVar = C0032b.m153a("tomb.zip", context, crashDetailBean.f216v);
                if (ajVar != null) {
                    C0073w.m523c("attach tombs", new Object[0]);
                    akVar.f401q.add(ajVar);
                }
            }
        }
        if (crashDetailBean.f193S != null && crashDetailBean.f193S.length > 0) {
            if (akVar.f401q == null) {
                akVar.f401q = new ArrayList();
            }
            akVar.f401q.add(new aj((byte) 1, "userExtraByteData", crashDetailBean.f193S));
            C0073w.m523c("attach extraData", new Object[0]);
        }
        akVar.f402r = new HashMap();
        akVar.f402r.put("A9", crashDetailBean.f176B);
        akVar.f402r.put("A11", crashDetailBean.f177C);
        akVar.f402r.put("A10", crashDetailBean.f178D);
        akVar.f402r.put("A23", crashDetailBean.f200f);
        akVar.f402r.put("A7", c0016a.f118e);
        akVar.f402r.put("A6", c0016a.m103r());
        akVar.f402r.put("A5", c0016a.m102q());
        akVar.f402r.put("A22", c0016a.m91g());
        akVar.f402r.put("A2", crashDetailBean.f180F);
        akVar.f402r.put("A1", crashDetailBean.f179E);
        akVar.f402r.put("A24", c0016a.f120g);
        akVar.f402r.put("A17", crashDetailBean.f181G);
        akVar.f402r.put("A3", c0016a.m95j());
        akVar.f402r.put("A16", c0016a.m97l());
        akVar.f402r.put("A25", c0016a.m98m());
        akVar.f402r.put("A14", c0016a.m96k());
        akVar.f402r.put("A15", c0016a.m105t());
        akVar.f402r.put("A13", c0016a.m106u());
        akVar.f402r.put("A34", crashDetailBean.f220z);
        if (c0016a.f136w != null) {
            akVar.f402r.put("productIdentify", c0016a.f136w);
        }
        try {
            akVar.f402r.put("A26", URLEncoder.encode(crashDetailBean.f182H, "utf-8"));
        } catch (UnsupportedEncodingException e222) {
            e222.printStackTrace();
        }
        if (crashDetailBean.f196b == 1) {
            akVar.f402r.put("A27", crashDetailBean.f184J);
            akVar.f402r.put("A28", crashDetailBean.f183I);
            akVar.f402r.put("A29", crashDetailBean.f205k);
        }
        akVar.f402r.put("A30", crashDetailBean.f185K);
        akVar.f402r.put("A18", crashDetailBean.f186L);
        akVar.f402r.put("A36", (!crashDetailBean.f187M));
        akVar.f402r.put("F02", c0016a.f129p);
        akVar.f402r.put("F03", c0016a.f130q);
        akVar.f402r.put("F04", c0016a.m85d());
        akVar.f402r.put("F05", c0016a.f131r);
        akVar.f402r.put("F06", c0016a.f128o);
        akVar.f402r.put("F08", c0016a.f134u);
        akVar.f402r.put("F09", c0016a.f135v);
        akVar.f402r.put("F10", c0016a.f132s);
        if (crashDetailBean.f189O >= 0) {
            akVar.f402r.put("C01", crashDetailBean.f189O);
        }
        if (crashDetailBean.f190P >= 0) {
            akVar.f402r.put("C02", crashDetailBean.f190P);
        }
        if (crashDetailBean.f191Q != null && crashDetailBean.f191Q.size() > 0) {
            for (Entry entry22 : crashDetailBean.f191Q.entrySet()) {
                akVar.f402r.put("C03_" + ((String) entry22.getKey()), entry22.getValue());
            }
        }
        if (crashDetailBean.f192R != null && crashDetailBean.f192R.size() > 0) {
            for (Entry entry222 : crashDetailBean.f192R.entrySet()) {
                akVar.f402r.put("C04_" + ((String) entry222.getKey()), entry222.getValue());
            }
        }
        akVar.f403s = null;
        if (crashDetailBean.f188N != null && crashDetailBean.f188N.size() > 0) {
            akVar.f403s = crashDetailBean.f188N;
            C0073w.m519a("setted message size %d", Integer.valueOf(akVar.f403s.size()));
        }
        String str2 = "%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d";
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.f208n;
        objArr2[1] = crashDetailBean.f197c;
        objArr2[2] = c0016a.m85d();
        objArr2[3] = Long.valueOf((crashDetailBean.f212r - crashDetailBean.f186L) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.f205k);
        objArr2[5] = Boolean.valueOf(crashDetailBean.f187M);
        objArr2[6] = Boolean.valueOf(crashDetailBean.f204j);
        if (crashDetailBean.f196b != 1) {
            z = false;
        }
        objArr2[7] = Boolean.valueOf(z);
        objArr2[8] = Integer.valueOf(crashDetailBean.f214t);
        objArr2[9] = crashDetailBean.f213s;
        objArr2[10] = Boolean.valueOf(crashDetailBean.f198d);
        objArr2[11] = Integer.valueOf(akVar.f402r.size());
        C0073w.m523c(str2, objArr2);
        return akVar;
    }

    /* renamed from: a */
    private static aj m153a(String str, Context context, String str2) {
        Throwable e;
        Throwable th;
        if (str2 == null || context == null) {
            C0073w.m524d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        C0073w.m523c("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (C0048a.m269a(file, file2, 5000)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileInputStream fileInputStream;
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
                    C0073w.m523c("read bytes :%d", Integer.valueOf(byteArrayOutputStream.toByteArray().length));
                    aj ajVar = new aj((byte) 2, file2.getName(), bArr);
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        if (!C0073w.m520a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                    if (file2.exists()) {
                        C0073w.m523c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return ajVar;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!C0073w.m520a(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                if (!C0073w.m520a(th3)) {
                                    th3.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            return null;
                        }
                        C0073w.m523c("del tmp", new Object[0]);
                        file2.delete();
                        return null;
                    } catch (Throwable th4) {
                        e2 = th4;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th32) {
                                if (!C0073w.m520a(th32)) {
                                    th32.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            C0073w.m523c("del tmp", new Object[0]);
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
                    C0073w.m523c("del tmp", new Object[0]);
                    file2.delete();
                }
                throw e2;
            }
        }
        C0073w.m524d("zip fail!", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static void m156a(String str, String str2, String str3, Thread thread, String str4, CrashDetailBean crashDetailBean) {
        C0016a a = C0016a.m69a();
        if (a != null) {
            int i;
            C0073w.m525e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
            C0073w.m525e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
            C0073w.m525e("# PKG NAME: %s", a.f116c);
            C0073w.m525e("# APP VER: %s", a.f122i);
            C0073w.m525e("# LAUNCH TIME: %s", C0048a.m262a(new Date(C0016a.m69a().f114a)));
            C0073w.m525e("# CRASH TYPE: %s", str);
            C0073w.m525e("# CRASH TIME: %s", str2);
            C0073w.m525e("# CRASH PROCESS: %s", str3);
            if (thread != null) {
                C0073w.m525e("# CRASH THREAD: %s", thread.getName());
            }
            if (crashDetailBean != null) {
                C0073w.m525e("# REPORT ID: %s", crashDetailBean.f197c);
                String str5 = "# CRASH DEVICE: %s %s";
                Object[] objArr = new Object[2];
                objArr[0] = a.f119f;
                objArr[1] = a.m106u().booleanValue() ? "ROOTED" : "UNROOT";
                C0073w.m525e(str5, objArr);
                C0073w.m525e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f176B), Long.valueOf(crashDetailBean.f177C), Long.valueOf(crashDetailBean.f178D));
                C0073w.m525e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f179E), Long.valueOf(crashDetailBean.f180F), Long.valueOf(crashDetailBean.f181G));
                String str6 = crashDetailBean.f184J;
                if (str6 == null || str6.trim().length() <= 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    C0073w.m525e("# EXCEPTION FIRED BY %s %s", crashDetailBean.f184J, crashDetailBean.f183I);
                } else if (crashDetailBean.f196b == 3) {
                    str5 = "# EXCEPTION ANR MESSAGE:\n %s";
                    objArr = new Object[1];
                    objArr[0] = crashDetailBean.f188N == null ? "null" : ((String) crashDetailBean.f188N.get("BUGLY_CR_01"));
                    C0073w.m525e(str5, objArr);
                }
            }
            if (str4 == null || str4.trim().length() <= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                C0073w.m525e("# CRASH STACK: ", new Object[0]);
                C0073w.m525e(str4, new Object[0]);
            }
            C0073w.m525e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
        }
    }
}
