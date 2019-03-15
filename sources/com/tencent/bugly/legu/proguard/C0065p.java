package com.tencent.bugly.legu.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.legu.C0004a;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.p */
public final class C0065p extends SQLiteOpenHelper {
    /* renamed from: a */
    private static int f533a = 11;
    /* renamed from: b */
    private Context f534b;
    /* renamed from: c */
    private List<C0004a> f535c;

    public C0065p(Context context, List<C0004a> list) {
        StringBuilder stringBuilder = new StringBuilder("bugly_db_");
        C0016a.m70a(context).getClass();
        super(context, stringBuilder.append("legu").toString(), null, f533a);
        this.f534b = context;
        this.f535c = list;
    }

    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_ui").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _ut").append(" int").append(" , _tp").append(" int").append(" , _dt").append(" blob").append(" , _pc").append(" text").append(" ) ");
            C0073w.m523c("create %s", stringBuilder.toString());
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_lr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tp").append(" int").append(" , _tm").append(" int").append(" , _pc").append(" text").append(" , _th").append(" text").append(" , _dt").append(" blob").append(" ) ");
            C0073w.m523c("create %s", stringBuilder.toString());
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_pf").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
            C0073w.m523c("create %s", stringBuilder.toString());
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_crd").append(" ( _id").append(" integer").append(" , _pc").append(" text").append(" , _tm").append(" int").append(" , _fl").append(" int").append(" , _sv").append(" text").append(" , _av").append(" text").append(" , _uid").append(" integer").append(",primary key(_id").append(",_pc").append(",_uid").append(" )) ");
            C0073w.m523c("create %s", stringBuilder.toString());
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_cr").append(" ( _id").append(" INTEGER PRIMARY KEY").append(" , _tm").append(" int").append(" , _s1").append(" text").append(" , _up").append(" int").append(" , _me").append(" int").append(" , _uc").append(" int").append(" , _dt").append(" blob").append(" ) ");
            C0073w.m523c("create %s", stringBuilder);
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS dl_1002").append(" (_id").append(" integer primary key autoincrement, _dUrl").append(" varchar(100), _sFile").append(" varchar(100), _sLen").append(" INTEGER, _tLen").append(" INTEGER, _MD5").append(" varchar(100), _DLTIME").append(" INTEGER)");
            C0073w.m523c("create %s", stringBuilder);
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE TABLE IF NOT EXISTS ge_1002").append(" (_id").append(" integer primary key autoincrement, _time").append(" INTEGER, _datas").append(" blob)");
            C0073w.m523c("create %s", stringBuilder);
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder.setLength(0);
            stringBuilder.append(" CREATE TABLE IF NOT EXISTS st_1002").append(" ( _id").append(" integer").append(" , _tp").append(" text").append(" , _tm").append(" int").append(" , _dt").append(" blob").append(",primary key(_id").append(",_tp").append(" )) ");
            C0073w.m523c("create %s", stringBuilder.toString());
            sQLiteDatabase.execSQL(stringBuilder.toString());
        } catch (Throwable th) {
            if (!C0073w.m522b(th)) {
                th.printStackTrace();
            }
        }
        if (this.f535c != null) {
            for (C0004a onDbCreate : this.f535c) {
                try {
                    onDbCreate.onDbCreate(sQLiteDatabase);
                } catch (Throwable th2) {
                    if (!C0073w.m522b(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private synchronized boolean m470a(SQLiteDatabase sQLiteDatabase) {
        boolean z = true;
        synchronized (this) {
            try {
                for (String str : new String[]{"t_crd", "t_lr", "t_ui", "t_pf"}) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                }
            } catch (Throwable th) {
                if (!C0073w.m522b(th)) {
                    th.printStackTrace();
                }
                z = false;
            }
        }
        return z;
    }

    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0073w.m524d("upgrade %d to %d , drop tables!", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.f535c != null) {
            for (C0004a onDbUpgrade : this.f535c) {
                try {
                    onDbUpgrade.onDbUpgrade(sQLiteDatabase, i, i2);
                } catch (Throwable th) {
                    if (!C0073w.m522b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (m470a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
        } else {
            C0073w.m524d("drop fail delete db", new Object[0]);
            File databasePath = this.f534b.getDatabasePath("bugly_db");
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (C0048a.m290d() >= 11) {
            C0073w.m524d("drowngrade %d to %d drop tables!}", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.f535c != null) {
                for (C0004a onDbDowngrade : this.f535c) {
                    try {
                        onDbDowngrade.onDbDowngrade(sQLiteDatabase, i, i2);
                    } catch (Throwable th) {
                        if (!C0073w.m522b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (m470a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                C0073w.m524d("drop fail delete db", new Object[0]);
                File databasePath = this.f534b.getDatabasePath("bugly_db");
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
                    C0073w.m524d("try db count %d", Integer.valueOf(i));
                    if (i == 5) {
                        C0073w.m525e("get db fail!", new Object[0]);
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
                    C0073w.m524d("try db %d", Integer.valueOf(i));
                    if (i == 5) {
                        C0073w.m525e("get db fail!", new Object[0]);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (sQLiteDatabase == null) {
                C0073w.m524d("db error delay error record 1min", new Object[0]);
            }
        }
        return sQLiteDatabase;
    }
}
