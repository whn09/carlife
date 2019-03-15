package com.tencent.bugly.lejiagu.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.lejiagu.C0080a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.m */
public final class C0139m {
    /* renamed from: a */
    private static C0139m f1128a = null;
    /* renamed from: b */
    private static C0140n f1129b = null;
    /* renamed from: c */
    private static boolean f1130c = false;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.proguard.m$a */
    class C0138a extends Thread {
        /* renamed from: a */
        private int f1110a;
        /* renamed from: b */
        private C0137l f1111b;
        /* renamed from: c */
        private String f1112c;
        /* renamed from: d */
        private ContentValues f1113d;
        /* renamed from: e */
        private boolean f1114e;
        /* renamed from: f */
        private String[] f1115f;
        /* renamed from: g */
        private String f1116g;
        /* renamed from: h */
        private String[] f1117h;
        /* renamed from: i */
        private String f1118i;
        /* renamed from: j */
        private String f1119j;
        /* renamed from: k */
        private String f1120k;
        /* renamed from: l */
        private String f1121l;
        /* renamed from: m */
        private String f1122m;
        /* renamed from: n */
        private String[] f1123n;
        /* renamed from: o */
        private int f1124o;
        /* renamed from: p */
        private String f1125p;
        /* renamed from: q */
        private byte[] f1126q;
        /* renamed from: r */
        private /* synthetic */ C0139m f1127r;

        public C0138a(C0139m c0139m, int i, C0137l c0137l) {
            this.f1127r = c0139m;
            this.f1110a = i;
            this.f1111b = c0137l;
        }

        /* renamed from: a */
        public final void m956a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f1114e = z;
            this.f1112c = str;
            this.f1115f = strArr;
            this.f1116g = str2;
            this.f1117h = strArr2;
            this.f1118i = str3;
            this.f1119j = str4;
            this.f1120k = str5;
            this.f1121l = str6;
        }

        public final void run() {
            switch (this.f1110a) {
                case 1:
                    this.f1127r.m960a(this.f1112c, this.f1113d, this.f1111b);
                    return;
                case 2:
                    this.f1127r.m958a(this.f1112c, this.f1122m, this.f1123n, this.f1111b);
                    return;
                case 3:
                    this.f1127r.m962a(this.f1114e, this.f1112c, this.f1115f, this.f1116g, this.f1117h, this.f1118i, this.f1119j, this.f1120k, this.f1121l, this.f1111b);
                    return;
                case 4:
                    this.f1127r.m970a(this.f1124o, this.f1125p, this.f1126q, this.f1111b);
                    return;
                case 5:
                    this.f1127r.m966a(this.f1124o, this.f1111b);
                    return;
                case 6:
                    C0139m c0139m = this.f1127r;
                    C0139m.m969a(this.f1124o, this.f1125p, this.f1111b);
                    return;
                default:
                    return;
            }
        }
    }

    private C0139m(Context context, List<C0080a> list) {
        f1129b = new C0140n(context, list);
    }

    /* renamed from: a */
    public static synchronized C0139m m964a(Context context, List<C0080a> list) {
        C0139m c0139m;
        synchronized (C0139m.class) {
            if (f1128a == null) {
                f1128a = new C0139m(context, list);
            }
            c0139m = f1128a;
        }
        return c0139m;
    }

    /* renamed from: a */
    public static synchronized C0139m m963a() {
        C0139m c0139m;
        synchronized (C0139m.class) {
            c0139m = f1128a;
        }
        return c0139m;
    }

    /* renamed from: a */
    public final long m979a(String str, ContentValues contentValues, C0137l c0137l, boolean z) {
        return m960a(str, contentValues, null);
    }

    /* renamed from: a */
    public final Cursor m980a(String str, String[] strArr, String str2, String[] strArr2, C0137l c0137l, boolean z) {
        return m962a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    /* renamed from: a */
    public final int m978a(String str, String str2, String[] strArr, C0137l c0137l, boolean z) {
        return m958a(str, str2, null, null);
    }

    /* renamed from: a */
    private synchronized long m960a(String str, ContentValues contentValues, C0137l c0137l) {
        long j = 0;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
                if (!(writableDatabase == null || contentValues == null)) {
                    long replace = writableDatabase.replace(str, "_id", contentValues);
                    if (replace >= 0) {
                        C0148u.m1039c("[db] insert %s success", str);
                    } else {
                        C0148u.m1040d("[db] replace %s error", str);
                    }
                    j = replace;
                }
                if (c0137l != null) {
                    Long.valueOf(j);
                }
            } catch (Throwable th) {
                if (c0137l != null) {
                    Long.valueOf(0);
                }
            }
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private synchronized android.database.Cursor m962a(boolean r12, java.lang.String r13, java.lang.String[] r14, java.lang.String r15, java.lang.String[] r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.tencent.bugly.lejiagu.proguard.C0137l r21) {
        /*
        r11 = this;
        monitor-enter(r11);
        r10 = 0;
        r0 = f1129b;	 Catch:{ Throwable -> 0x0020 }
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
        r1 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r0);	 Catch:{ all -> 0x002e }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.lejiagu.proguard.m.a(boolean, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.bugly.lejiagu.proguard.l):android.database.Cursor");
    }

    /* renamed from: a */
    private synchronized int m958a(String str, String str2, String[] strArr, C0137l c0137l) {
        int i = 0;
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
                if (writableDatabase != null) {
                    i = writableDatabase.delete(str, str2, strArr);
                }
                if (c0137l != null) {
                    Integer.valueOf(i);
                }
            } catch (Throwable th) {
                if (c0137l != null) {
                    Integer.valueOf(0);
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    public final boolean m984a(int i, String str, byte[] bArr, C0137l c0137l, boolean z) {
        return m970a(i, str, bArr, null);
    }

    /* renamed from: a */
    public final Map<String, byte[]> m982a(int i, C0137l c0137l, boolean z) {
        return m966a(i, null);
    }

    /* renamed from: a */
    public final boolean m983a(int i, String str, C0137l c0137l, boolean z) {
        return C0139m.m969a(555, str, null);
    }

    /* renamed from: a */
    private boolean m970a(int i, String str, byte[] bArr, C0137l c0137l) {
        boolean z = false;
        try {
            C0141o c0141o = new C0141o();
            c0141o.f1134a = (long) i;
            c0141o.f1139f = str;
            c0141o.f1138e = System.currentTimeMillis();
            c0141o.f1140g = bArr;
            z = m974b(c0141o);
            if (c0137l != null) {
                Boolean.valueOf(z);
            }
        } catch (Throwable th) {
            if (c0137l != null) {
                Boolean.valueOf(z);
            }
        }
        return z;
    }

    /* renamed from: a */
    private Map<String, byte[]> m966a(int i, C0137l c0137l) {
        Map<String, byte[]> map;
        Throwable th;
        try {
            List<C0141o> c = m976c(i);
            Map<String, byte[]> hashMap = new HashMap();
            try {
                for (C0141o c0141o : c) {
                    Object obj = c0141o.f1140g;
                    if (obj != null) {
                        hashMap.put(c0141o.f1139f, obj);
                    }
                }
                if (c0137l != null) {
                    return hashMap;
                }
                return hashMap;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                map = hashMap;
                th = th3;
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
                return c0137l == null ? map : map;
            }
        } catch (Throwable th22) {
            th = th22;
            map = null;
            if (C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            if (c0137l == null) {
            }
        }
    }

    /* renamed from: a */
    public final boolean m985a(C0141o c0141o) {
        if (c0141o == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            ContentValues c = C0139m.m975c(c0141o);
            if (c == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_lr", "_id", c);
            if (replace < 0) {
                return false;
            }
            C0148u.m1039c("insert %s success!", "t_lr");
            c0141o.f1134a = replace;
            return true;
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private boolean m974b(C0141o c0141o) {
        if (c0141o == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            ContentValues d = C0139m.m977d(c0141o);
            if (d == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_pf", "_id", d);
            if (replace < 0) {
                return false;
            }
            C0148u.m1039c("insert %s success!", "t_pf");
            c0141o.f1134a = replace;
            return true;
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final List<C0141o> m981a(int i) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2;
        SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
        if (writableDatabase != null) {
            String str;
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
                List<C0141o> arrayList = new ArrayList();
                while (cursor2.moveToNext()) {
                    C0141o a = C0139m.m965a(cursor2);
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
                    C0148u.m1040d("deleted %s illegle data %d", "t_lr", Integer.valueOf(delete));
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
    public static void m968a(List<C0141o> list) {
        if (list != null && list.size() != 0) {
            SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
            if (writableDatabase != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (C0141o c0141o : list) {
                    stringBuilder.append(" or _id").append(" = ").append(c0141o.f1134a);
                }
                String stringBuilder2 = stringBuilder.toString();
                if (stringBuilder2.length() > 0) {
                    stringBuilder2 = stringBuilder2.substring(4);
                }
                stringBuilder.setLength(0);
                try {
                    int delete = writableDatabase.delete("t_lr", stringBuilder2, null);
                    C0148u.m1039c("deleted %s data %d", "t_lr", Integer.valueOf(delete));
                } catch (Throwable th) {
                    if (!C0148u.m1036a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static void m973b(int i) {
        String str = null;
        SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (Throwable th) {
                    if (!C0148u.m1036a(th)) {
                        th.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            int delete = writableDatabase.delete("t_lr", str, null);
            C0148u.m1039c("deleted %s data %d", "t_lr", Integer.valueOf(delete));
        }
    }

    /* renamed from: c */
    private static ContentValues m975c(C0141o c0141o) {
        if (c0141o == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (c0141o.f1134a > 0) {
                contentValues.put("_id", Long.valueOf(c0141o.f1134a));
            }
            contentValues.put("_tp", Integer.valueOf(c0141o.f1135b));
            contentValues.put("_pc", c0141o.f1136c);
            contentValues.put("_th", c0141o.f1137d);
            contentValues.put("_tm", Long.valueOf(c0141o.f1138e));
            if (c0141o.f1140g != null) {
                contentValues.put("_dt", c0141o.f1140g);
            }
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
    private static C0141o m965a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C0141o c0141o = new C0141o();
            c0141o.f1134a = cursor.getLong(cursor.getColumnIndex("_id"));
            c0141o.f1135b = cursor.getInt(cursor.getColumnIndex("_tp"));
            c0141o.f1136c = cursor.getString(cursor.getColumnIndex("_pc"));
            c0141o.f1137d = cursor.getString(cursor.getColumnIndex("_th"));
            c0141o.f1138e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c0141o.f1140g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c0141o;
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private List<C0141o> m976c(int i) {
        Throwable th;
        Cursor cursor;
        Cursor query;
        try {
            SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
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
                    List<C0141o> arrayList = new ArrayList();
                    while (query.moveToNext()) {
                        C0141o b = C0139m.m972b(query);
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
                        C0148u.m1040d("deleted %s illegle data %d", "t_pf", Integer.valueOf(delete));
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
    public static boolean m969a(int i, String str, C0137l c0137l) {
        boolean z = true;
        boolean z2 = false;
        try {
            SQLiteDatabase writableDatabase = f1129b.getWritableDatabase();
            if (writableDatabase != null) {
                String str2;
                boolean z3 = str == null || str.trim().length() <= 0;
                if (z3) {
                    str2 = "_id = " + i;
                } else {
                    str2 = "_id = " + i + " and _tp" + " = \"" + str + "\"";
                }
                C0148u.m1039c("deleted %s data %d", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str2, null)));
                if (writableDatabase.delete("t_pf", str2, null) <= 0) {
                    z = false;
                }
                z2 = z;
            }
            if (c0137l != null) {
                Boolean.valueOf(z2);
            }
        } catch (Throwable th) {
            if (c0137l != null) {
                Boolean.valueOf(false);
            }
        }
        return z2;
    }

    /* renamed from: d */
    private static ContentValues m977d(C0141o c0141o) {
        if (c0141o != null) {
            Object obj;
            String str = c0141o.f1139f;
            if (str == null || str.trim().length() <= 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    if (c0141o.f1134a > 0) {
                        contentValues.put("_id", Long.valueOf(c0141o.f1134a));
                    }
                    contentValues.put("_tp", c0141o.f1139f);
                    contentValues.put("_tm", Long.valueOf(c0141o.f1138e));
                    if (c0141o.f1140g == null) {
                        return contentValues;
                    }
                    contentValues.put("_dt", c0141o.f1140g);
                    return contentValues;
                } catch (Throwable th) {
                    if (!C0148u.m1036a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private static C0141o m972b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C0141o c0141o = new C0141o();
            c0141o.f1134a = cursor.getLong(cursor.getColumnIndex("_id"));
            c0141o.f1138e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c0141o.f1139f = cursor.getString(cursor.getColumnIndex("_tp"));
            c0141o.f1140g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c0141o;
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
