package com.tencent.bugly.legu.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.bugly.legu.C0004a;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.o */
public final class C0064o {
    /* renamed from: a */
    private static C0064o f530a = null;
    /* renamed from: b */
    private static C0065p f531b = null;
    /* renamed from: c */
    private static boolean f532c = false;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.proguard.o$a */
    class C0063a extends Thread {
        /* renamed from: a */
        private int f512a;
        /* renamed from: b */
        private C0062n f513b;
        /* renamed from: c */
        private String f514c;
        /* renamed from: d */
        private ContentValues f515d;
        /* renamed from: e */
        private boolean f516e;
        /* renamed from: f */
        private String[] f517f;
        /* renamed from: g */
        private String f518g;
        /* renamed from: h */
        private String[] f519h;
        /* renamed from: i */
        private String f520i;
        /* renamed from: j */
        private String f521j;
        /* renamed from: k */
        private String f522k;
        /* renamed from: l */
        private String f523l;
        /* renamed from: m */
        private String f524m;
        /* renamed from: n */
        private String[] f525n;
        /* renamed from: o */
        private int f526o;
        /* renamed from: p */
        private String f527p;
        /* renamed from: q */
        private byte[] f528q;
        /* renamed from: r */
        private /* synthetic */ C0064o f529r;

        public C0063a(C0064o c0064o, int i, C0062n c0062n) {
            this.f529r = c0064o;
            this.f512a = i;
            this.f513b = c0062n;
        }

        /* renamed from: a */
        public final void m433a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f516e = z;
            this.f514c = str;
            this.f517f = strArr;
            this.f518g = str2;
            this.f519h = strArr2;
            this.f520i = str3;
            this.f521j = str4;
            this.f522k = str5;
            this.f523l = str6;
        }

        /* renamed from: a */
        public final void m432a(int i, String str, byte[] bArr) {
            this.f526o = i;
            this.f527p = str;
            this.f528q = bArr;
        }

        public final void run() {
            switch (this.f512a) {
                case 1:
                    this.f529r.m437a(this.f514c, this.f515d, this.f513b);
                    return;
                case 2:
                    this.f529r.m435a(this.f514c, this.f524m, this.f525n, this.f513b);
                    return;
                case 3:
                    this.f529r.m439a(this.f516e, this.f514c, this.f517f, this.f518g, this.f519h, this.f520i, this.f521j, this.f522k, this.f523l, this.f513b);
                    return;
                case 4:
                    this.f529r.m447a(this.f526o, this.f527p, this.f528q, this.f513b);
                    return;
                case 5:
                    this.f529r.m443a(this.f526o, this.f513b);
                    return;
                case 6:
                    C0064o c0064o = this.f529r;
                    C0064o.m446a(this.f526o, this.f527p, this.f513b);
                    return;
                default:
                    return;
            }
        }
    }

    private C0064o(Context context, List<C0004a> list) {
        f531b = new C0065p(context, list);
    }

    /* renamed from: a */
    public static synchronized C0064o m441a(Context context, List<C0004a> list) {
        C0064o c0064o;
        synchronized (C0064o.class) {
            if (f530a == null) {
                f530a = new C0064o(context, list);
            }
            c0064o = f530a;
        }
        return c0064o;
    }

    /* renamed from: a */
    public static synchronized C0064o m440a() {
        C0064o c0064o;
        synchronized (C0064o.class) {
            c0064o = f530a;
        }
        return c0064o;
    }

    /* renamed from: a */
    public final long m459a(String str, ContentValues contentValues, C0062n c0062n, boolean z) {
        return m437a(str, contentValues, null);
    }

    /* renamed from: a */
    public final Cursor m460a(String str, String[] strArr, String str2, String[] strArr2, C0062n c0062n, boolean z) {
        return m439a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    /* renamed from: a */
    public final int m458a(String str, String str2, String[] strArr, C0062n c0062n, boolean z) {
        return m435a(str, str2, null, null);
    }

    /* renamed from: a */
    private synchronized long m437a(String str, ContentValues contentValues, C0062n c0062n) {
        long j = 0;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
                if (!(writableDatabase == null || contentValues == null)) {
                    long replace = writableDatabase.replace(str, "_id", contentValues);
                    if (replace >= 0) {
                        C0073w.m523c("[db] insert %s success", str);
                    } else {
                        C0073w.m524d("[db] replace %s error", str);
                    }
                    j = replace;
                }
                if (c0062n != null) {
                    Long.valueOf(j);
                }
            } catch (Throwable th) {
                if (c0062n != null) {
                    Long.valueOf(0);
                }
            }
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private synchronized android.database.Cursor m439a(boolean r12, java.lang.String r13, java.lang.String[] r14, java.lang.String r15, java.lang.String[] r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.tencent.bugly.legu.proguard.C0062n r21) {
        /*
        r11 = this;
        monitor-enter(r11);
        r10 = 0;
        r0 = f531b;	 Catch:{ Throwable -> 0x0020 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x0020 }
        if (r0 == 0) goto L_0x0035;
    L_0x000a:
        r1 = r12;
        r2 = r13;
        r3 = r14;
        r4 = r15;
        r5 = r16;
        r6 = r17;
        r7 = r18;
        r8 = r19;
        r9 = r20;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x0020 }
    L_0x001c:
        if (r21 == 0) goto L_0x001e;
    L_0x001e:
        monitor-exit(r11);
        return r0;
    L_0x0020:
        r0 = move-exception;
        r1 = com.tencent.bugly.legu.proguard.C0073w.m520a(r0);	 Catch:{ all -> 0x002e }
        if (r1 != 0) goto L_0x002a;
    L_0x0027:
        r0.printStackTrace();	 Catch:{ all -> 0x002e }
    L_0x002a:
        if (r21 == 0) goto L_0x0033;
    L_0x002c:
        r0 = r10;
        goto L_0x001e;
    L_0x002e:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0030 }
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r11);
        throw r0;
    L_0x0033:
        r0 = r10;
        goto L_0x001e;
    L_0x0035:
        r0 = r10;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.legu.proguard.o.a(boolean, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.bugly.legu.proguard.n):android.database.Cursor");
    }

    /* renamed from: a */
    private synchronized int m435a(String str, String str2, String[] strArr, C0062n c0062n) {
        int i = 0;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
                if (writableDatabase != null) {
                    i = writableDatabase.delete(str, str2, strArr);
                }
                if (c0062n != null) {
                    Integer.valueOf(i);
                }
            } catch (Throwable th) {
                if (c0062n != null) {
                    Integer.valueOf(0);
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    public final boolean m466a(int i, String str, byte[] bArr, C0062n c0062n, boolean z) {
        if (z) {
            return m447a(i, str, bArr, null);
        }
        Runnable c0063a = new C0063a(this, 4, null);
        c0063a.m432a(i, str, bArr);
        C0072v.m511a().m516b(c0063a);
        return true;
    }

    /* renamed from: a */
    public final Map<String, byte[]> m464a(int i, C0062n c0062n, boolean z) {
        return m443a(i, null);
    }

    /* renamed from: a */
    public final boolean m465a(int i, String str, C0062n c0062n, boolean z) {
        return C0064o.m446a(555, str, null);
    }

    /* renamed from: a */
    private boolean m447a(int i, String str, byte[] bArr, C0062n c0062n) {
        boolean z = false;
        try {
            C0066q c0066q = new C0066q();
            c0066q.f536a = (long) i;
            c0066q.f541f = str;
            c0066q.f540e = System.currentTimeMillis();
            c0066q.f542g = bArr;
            z = m452b(c0066q);
            if (c0062n != null) {
                Boolean.valueOf(z);
            }
        } catch (Throwable th) {
            if (c0062n != null) {
                Boolean.valueOf(z);
            }
        }
        return z;
    }

    /* renamed from: a */
    private Map<String, byte[]> m443a(int i, C0062n c0062n) {
        Map<String, byte[]> map;
        Throwable th;
        try {
            List<C0066q> c = m455c(i);
            Map<String, byte[]> hashMap = new HashMap();
            try {
                for (C0066q c0066q : c) {
                    Object obj = c0066q.f542g;
                    if (obj != null) {
                        hashMap.put(c0066q.f541f, obj);
                    }
                }
                if (c0062n != null) {
                    return hashMap;
                }
                return hashMap;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                map = hashMap;
                th = th3;
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
                return c0062n == null ? map : map;
            }
        } catch (Throwable th22) {
            th = th22;
            map = null;
            if (C0073w.m520a(th)) {
                th.printStackTrace();
            }
            if (c0062n == null) {
            }
        }
    }

    /* renamed from: a */
    public final boolean m468a(C0066q c0066q) {
        if (c0066q == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            ContentValues c = C0064o.m453c(c0066q);
            if (c == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_lr", "_id", c);
            if (replace < 0) {
                return false;
            }
            C0073w.m523c("insert %s success!", "t_lr");
            c0066q.f536a = replace;
            return true;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private boolean m452b(C0066q c0066q) {
        if (c0066q == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            ContentValues d = C0064o.m456d(c0066q);
            if (d == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_pf", "_id", d);
            if (replace < 0) {
                return false;
            }
            C0073w.m523c("insert %s success!", "t_pf");
            c0066q.f536a = replace;
            return true;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final List<C0066q> m462a(int i) {
        Throwable th;
        Cursor cursor;
        SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
        if (writableDatabase != null) {
            String str;
            Cursor cursor2;
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = null;
                    cursor2.close();
                    throw th;
                }
            }
            str = null;
            cursor2 = writableDatabase.query("t_lr", null, str, null, null, null, null);
            if (cursor2 == null) {
                if (!(cursor2 == null || cursor2.isClosed())) {
                    cursor2.close();
                }
                return null;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                List<C0066q> arrayList = new ArrayList();
                while (cursor2.moveToNext()) {
                    C0066q a = C0064o.m442a(cursor2);
                    if (a != null) {
                        arrayList.add(a);
                    } else {
                        try {
                            stringBuilder.append(" or _id").append(" = ").append(cursor2.getLong(cursor2.getColumnIndex("_id")));
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                }
                str = stringBuilder.toString();
                if (str.length() > 0) {
                    int delete = writableDatabase.delete("t_lr", str.substring(4), null);
                    C0073w.m524d("deleted %s illegle data %d", "t_lr", Integer.valueOf(delete));
                }
                if (!(cursor2 == null || cursor2.isClosed())) {
                    cursor2.close();
                }
                return arrayList;
            } catch (Throwable th32) {
                th = th32;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m445a(List<C0066q> list) {
        if (list != null && list.size() != 0) {
            SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
            if (writableDatabase != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (C0066q c0066q : list) {
                    stringBuilder.append(" or _id").append(" = ").append(c0066q.f536a);
                }
                String stringBuilder2 = stringBuilder.toString();
                if (stringBuilder2.length() > 0) {
                    stringBuilder2 = stringBuilder2.substring(4);
                }
                stringBuilder.setLength(0);
                try {
                    int delete = writableDatabase.delete("t_lr", stringBuilder2, null);
                    C0073w.m523c("deleted %s data %d", "t_lr", Integer.valueOf(delete));
                } catch (Throwable th) {
                    if (!C0073w.m520a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static void m451b(int i) {
        String str = null;
        SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (Throwable th) {
                    if (!C0073w.m520a(th)) {
                        th.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            int delete = writableDatabase.delete("t_lr", str, null);
            C0073w.m523c("deleted %s data %d", "t_lr", Integer.valueOf(delete));
        }
    }

    /* renamed from: c */
    private static ContentValues m453c(C0066q c0066q) {
        if (c0066q == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (c0066q.f536a > 0) {
                contentValues.put("_id", Long.valueOf(c0066q.f536a));
            }
            contentValues.put("_tp", Integer.valueOf(c0066q.f537b));
            contentValues.put("_pc", c0066q.f538c);
            contentValues.put("_th", c0066q.f539d);
            contentValues.put("_tm", Long.valueOf(c0066q.f540e));
            if (c0066q.f542g != null) {
                contentValues.put("_dt", c0066q.f542g);
            }
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
    private static C0066q m442a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C0066q c0066q = new C0066q();
            c0066q.f536a = cursor.getLong(cursor.getColumnIndex("_id"));
            c0066q.f537b = cursor.getInt(cursor.getColumnIndex("_tp"));
            c0066q.f538c = cursor.getString(cursor.getColumnIndex("_pc"));
            c0066q.f539d = cursor.getString(cursor.getColumnIndex("_th"));
            c0066q.f540e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c0066q.f542g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c0066q;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private List<C0066q> m455c(int i) {
        Throwable th;
        Cursor cursor;
        Cursor query;
        try {
            SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
            if (writableDatabase != null) {
                String str = "_id = " + i;
                query = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (query == null) {
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    return null;
                }
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    List<C0066q> arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        C0066q b = C0064o.m450b(query);
                        if (b != null) {
                            arrayList.add(b);
                        } else {
                            try {
                                stringBuilder.append(" or _tp").append(" = ").append(query.getString(query.getColumnIndex("_tp")));
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(" and _id").append(" = ").append(i);
                        int delete = writableDatabase.delete("t_pf", str.substring(4), null);
                        C0073w.m524d("deleted %s illegle data %d", "t_pf", Integer.valueOf(delete));
                    }
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th22) {
                    th = th22;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            query.close();
            throw th;
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m446a(int i, String str, C0062n c0062n) {
        boolean z = true;
        boolean z2 = false;
        try {
            SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
            if (writableDatabase != null) {
                String str2;
                boolean z3 = str == null || str.trim().length() <= 0;
                if (z3) {
                    str2 = "_id = " + i;
                } else {
                    str2 = "_id = " + i + " and _tp" + " = \"" + str + "\"";
                }
                C0073w.m523c("deleted %s data %d", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str2, null)));
                if (writableDatabase.delete("t_pf", str2, null) <= 0) {
                    z = false;
                }
                z2 = z;
            }
            if (c0062n != null) {
                Boolean.valueOf(z2);
            }
        } catch (Throwable th) {
            if (c0062n != null) {
                Boolean.valueOf(false);
            }
        }
        return z2;
    }

    /* renamed from: d */
    private static ContentValues m456d(C0066q c0066q) {
        if (c0066q != null) {
            Object obj;
            String str = c0066q.f541f;
            if (str == null || str.trim().length() <= 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    if (c0066q.f536a > 0) {
                        contentValues.put("_id", Long.valueOf(c0066q.f536a));
                    }
                    contentValues.put("_tp", c0066q.f541f);
                    contentValues.put("_tm", Long.valueOf(c0066q.f540e));
                    if (c0066q.f542g == null) {
                        return contentValues;
                    }
                    contentValues.put("_dt", c0066q.f542g);
                    return contentValues;
                } catch (Throwable th) {
                    if (!C0073w.m520a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private static C0066q m450b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C0066q c0066q = new C0066q();
            c0066q.f536a = cursor.getLong(cursor.getColumnIndex("_id"));
            c0066q.f540e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c0066q.f541f = cursor.getString(cursor.getColumnIndex("_tp"));
            c0066q.f542g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c0066q;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final boolean m467a(C0060l c0060l) {
        if (c0060l == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            ContentValues b = C0064o.m449b(c0060l);
            if (b == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_crd", "_id", b);
            if (replace < 0) {
                return false;
            }
            C0073w.m523c("insert %s success!", "t_crd");
            c0060l.f503a = replace;
            return true;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final List<C0060l> m463a(int i, String str, long j, String str2) {
        Throwable th;
        Cursor cursor = null;
        SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
        if (writableDatabase != null) {
            Cursor query;
            try {
                query = writableDatabase.query("t_crd", null, "_id = " + i + " and _pc" + " = '" + str + "' and _fl" + " > 0 and " + "_sv = '" + str2 + "' " + (j != 0 ? " and _tm > " + j : ""), null, null, null, "_tm ASC");
                if (query == null) {
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    return null;
                }
                try {
                    List<C0060l> arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        C0060l c = C0064o.m454c(query);
                        if (c != null) {
                            arrayList.add(c);
                        }
                    }
                    if (query == null || query.isClosed()) {
                        return arrayList;
                    }
                    query.close();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!C0073w.m520a(th)) {
                            th.printStackTrace();
                        }
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = query;
                        cursor.close();
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                throw th;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final C0060l m461a(int i, String str) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        SQLiteDatabase writableDatabase = f531b.getWritableDatabase();
        if (writableDatabase == null) {
            return null;
        }
        try {
            query = writableDatabase.query("t_crd", null, "_id = " + i + " and _pc" + " = '" + str + "' and _fl" + " > 0", null, null, null, "_tm DESC");
            if (query != null) {
                C0060l c;
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            c = C0064o.m454c(query);
                            if (!(query == null || query.isClosed())) {
                                query.close();
                            }
                            return c;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            if (!C0073w.m520a(th)) {
                                th.printStackTrace();
                            }
                            if (query == null && !query.isClosed()) {
                                query.close();
                                return null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = query;
                            if (!(cursor == null || cursor.isClosed())) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                c = null;
                query.close();
                return c;
            } else if (query == null || query.isClosed()) {
                return null;
            } else {
                query.close();
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor.close();
            throw th;
        }
    }

    /* renamed from: a */
    public final int m457a(int i, String str, long j) {
        return m435a("t_crd", "_id = " + i + " and _pc" + " = '" + str + "' " + (j == 0 ? "" : " and _tm < " + j), null, null);
    }

    /* renamed from: b */
    public final int m469b() {
        StringBuilder stringBuilder = new StringBuilder("_fl = 0 or _sv <> '");
        C0016a.m69a().getClass();
        return m435a("t_crd", stringBuilder.append("2.1.9'").toString(), null, null);
    }

    /* renamed from: b */
    private static ContentValues m449b(C0060l c0060l) {
        if (c0060l == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (c0060l.f503a <= 0 || TextUtils.isEmpty(c0060l.f504b)) {
                return null;
            }
            contentValues.put("_id", Long.valueOf(c0060l.f503a));
            contentValues.put("_pc", c0060l.f504b);
            contentValues.put("_tm", Long.valueOf(c0060l.f505c));
            contentValues.put("_fl", Integer.valueOf(c0060l.f506d));
            contentValues.put("_av", c0060l.f508f);
            contentValues.put("_sv", c0060l.f507e);
            contentValues.put("_uid", Long.valueOf(c0060l.f509g));
            return contentValues;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private static C0060l m454c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C0060l c0060l = new C0060l();
            c0060l.f503a = cursor.getLong(cursor.getColumnIndex("_id"));
            c0060l.f504b = cursor.getString(cursor.getColumnIndex("_pc"));
            c0060l.f507e = cursor.getString(cursor.getColumnIndex("_sv"));
            c0060l.f508f = cursor.getString(cursor.getColumnIndex("_av"));
            c0060l.f505c = cursor.getLong(cursor.getColumnIndex("_tm"));
            c0060l.f506d = cursor.getInt(cursor.getColumnIndex("_fl"));
            c0060l.f509g = cursor.getLong(cursor.getColumnIndex("_uid"));
            return c0060l;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
