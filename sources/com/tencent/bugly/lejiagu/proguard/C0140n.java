package com.tencent.bugly.lejiagu.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.lejiagu.C0080a;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.n */
public final class C0140n extends SQLiteOpenHelper {
    /* renamed from: a */
    private static int f1131a = 9;
    /* renamed from: b */
    private Context f1132b;
    /* renamed from: c */
    private List<C0080a> f1133c;

    public C0140n(Context context, List<C0080a> list) {
        StringBuilder stringBuilder = new StringBuilder("bugly_db_");
        C0092a.m598a(context).getClass();
        super(context, stringBuilder.append("lejiagu").toString(), null, f1131a);
        this.f1132b = context;
        this.f1133c = list;
    }

    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE t_ui").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _ut").append(" int").append(" , _tp").append(" int").append(" , _dt").append(" blob").append(" , _pc").append(" text").append(" ) ");
            C0148u.m1039c("create %s", stringBuilder.toString());
            sQLiteDatabase.execSQL(r1);
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE t_lr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tp").append(" int").append(" , _tm").append(" int").append(" , _pc").append(" text").append(" , _th").append(" text").append(" , _dt").append(" blob").append(" ) ");
            C0148u.m1039c("create %s", stringBuilder.toString());
            sQLiteDatabase.execSQL(r1);
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE t_pf").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
            C0148u.m1039c("create %s", stringBuilder.toString());
            sQLiteDatabase.execSQL(r0);
        } catch (Throwable th) {
            if (!C0148u.m1038b(th)) {
                th.printStackTrace();
            }
        }
        if (this.f1133c != null) {
            for (C0080a onDbCreate : this.f1133c) {
                try {
                    onDbCreate.onDbCreate(sQLiteDatabase);
                } catch (Throwable th2) {
                    if (!C0148u.m1038b(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private synchronized boolean m986a(SQLiteDatabase sQLiteDatabase) {
        boolean z = true;
        synchronized (this) {
            try {
                for (String str : new String[]{"t_cr", "t_lr", "t_ui", "t_pf"}) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                }
            } catch (Throwable th) {
                if (!C0148u.m1038b(th)) {
                    th.printStackTrace();
                }
                z = false;
            }
        }
        return z;
    }

    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0148u.m1040d("upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.f1133c != null) {
            for (C0080a onDbUpgrade : this.f1133c) {
                try {
                    onDbUpgrade.onDbUpgrade(sQLiteDatabase, i, i2);
                } catch (Throwable th) {
                    if (!C0148u.m1038b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (m986a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
        } else {
            C0148u.m1040d("drop fail delete db", new Object[0]);
            File databasePath = this.f1132b.getDatabasePath("bugly_db");
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (C0124a.m824d() >= 11) {
            C0148u.m1040d("drowngrade %d to %d drop tables!}", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.f1133c != null) {
                for (C0080a onDbDowngrade : this.f1133c) {
                    try {
                        onDbDowngrade.onDbDowngrade(sQLiteDatabase, i, i2);
                    } catch (Throwable th) {
                        if (!C0148u.m1038b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (m986a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                C0148u.m1040d("drop fail delete db", new Object[0]);
                File databasePath = this.f1132b.getDatabasePath("bugly_db");
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        int i = 0;
        synchronized (this) {
            sQLiteDatabase = null;
            while (sQLiteDatabase == null && i < 5) {
                i++;
                try {
                    sQLiteDatabase = super.getReadableDatabase();
                } catch (Throwable th) {
                    C0148u.m1040d("try db count %d", Integer.valueOf(i));
                    if (i == 5) {
                        C0148u.m1041e("get db fail!", new Object[0]);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sQLiteDatabase;
    }

    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        int i = 0;
        synchronized (this) {
            sQLiteDatabase = null;
            while (sQLiteDatabase == null && i < 5) {
                i++;
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (Throwable th) {
                    C0148u.m1040d("try db %d", Integer.valueOf(i));
                    if (i == 5) {
                        C0148u.m1041e("get db fail!", new Object[0]);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (sQLiteDatabase == null) {
                C0148u.m1040d("db error delay error record 1min", new Object[0]);
            }
        }
        return sQLiteDatabase;
    }
}
