package com.tencent.bugly.lejiagu.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.s */
public final class C0145s implements Runnable {
    /* renamed from: a */
    private int f1165a;
    /* renamed from: b */
    private int f1166b;
    /* renamed from: c */
    private final Context f1167c;
    /* renamed from: d */
    private final int f1168d;
    /* renamed from: e */
    private final byte[] f1169e;
    /* renamed from: f */
    private final C0092a f1170f;
    /* renamed from: g */
    private final C0095a f1171g;
    /* renamed from: h */
    private final C0142p f1172h;
    /* renamed from: i */
    private final C0144r f1173i;
    /* renamed from: j */
    private final int f1174j;
    /* renamed from: k */
    private final C0083q f1175k;
    /* renamed from: l */
    private final C0083q f1176l;
    /* renamed from: m */
    private String f1177m;
    /* renamed from: n */
    private int f1178n;
    /* renamed from: o */
    private long f1179o;
    /* renamed from: p */
    private long f1180p;
    /* renamed from: q */
    private boolean f1181q;

    public C0145s(Context context, int i, ak akVar, String str, C0083q c0083q, boolean z) {
        this(context, i, akVar.f1023g, C0124a.m807a(akVar), str, c0083q, z);
    }

    public C0145s(Context context, int i, int i2, byte[] bArr, String str, C0083q c0083q, boolean z) {
        this(context, i, i2, bArr, str, c0083q, z, 5, 60000);
    }

    private C0145s(Context context, int i, int i2, byte[] bArr, String str, C0083q c0083q, boolean z, int i3, int i4) {
        this.f1165a = 3;
        this.f1166b = 30000;
        this.f1177m = "";
        this.f1178n = 0;
        this.f1179o = 0;
        this.f1180p = 0;
        this.f1181q = true;
        this.f1167c = context;
        this.f1170f = C0092a.m598a(context);
        this.f1169e = bArr;
        this.f1171g = C0095a.m641a();
        this.f1172h = C0142p.m987a(context);
        this.f1173i = C0144r.m994a();
        this.f1174j = i;
        this.f1177m = str;
        this.f1175k = c0083q;
        C0144r c0144r = this.f1173i;
        this.f1176l = null;
        this.f1181q = z;
        if (z) {
            switch (i2) {
                case 510:
                case 640:
                    i2 = 840;
                    break;
                case 630:
                    i2 = 830;
                    break;
            }
        }
        this.f1168d = i2;
        this.f1165a = 5;
        this.f1166b = 60000;
    }

    /* renamed from: a */
    private void m1023a(al alVar, boolean z, int i, String str, int i2) {
        String str2;
        switch (this.f1168d) {
            case 630:
            case 830:
                str2 = "crash";
                break;
            case 640:
            case 840:
                str2 = "userinfo";
                break;
            default:
                str2 = String.valueOf(this.f1168d);
                break;
        }
        if (z) {
            C0148u.m1035a("[upload] success: %s", str2);
        } else {
            C0148u.m1041e("[upload] fail! %s %d %s", str2, Integer.valueOf(i), str);
            if (this.f1181q) {
                this.f1173i.m1015a(i2, null);
            }
        }
        if (this.f1179o + this.f1180p > 0) {
            this.f1173i.m1016a((this.f1173i.m1020b() + this.f1179o) + this.f1180p);
        }
        if (this.f1175k != null) {
            C0083q c0083q = this.f1175k;
            int i3 = this.f1168d;
            long j = this.f1179o;
            j = this.f1180p;
            c0083q.mo28a(z);
        }
        if (this.f1176l != null) {
            c0083q = this.f1176l;
            i3 = this.f1168d;
            j = this.f1179o;
            j = this.f1180p;
            c0083q.mo28a(z);
        }
    }

    /* renamed from: a */
    private static boolean m1024a(al alVar, C0092a c0092a, C0095a c0095a) {
        if (alVar == null) {
            C0148u.m1040d("resp == null!", new Object[0]);
            return false;
        } else if (alVar.f1043a != (byte) 0) {
            C0148u.m1041e("resp result error %d", Byte.valueOf(alVar.f1043a));
            return false;
        } else {
            try {
                String str = alVar.f1046d;
                int i = (str == null || str.trim().length() <= 0) ? 1 : 0;
                if (i == 0 && C0092a.m597a().m620h() != alVar.f1046d) {
                    C0139m.m963a().m984a(C0095a.f771a, "key_ip", alVar.f1046d.getBytes("UTF-8"), null, true);
                    c0092a.m613d(alVar.f1046d);
                }
                str = alVar.f1049g;
                if (str == null || str.trim().length() <= 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0 && C0092a.m597a().m621i() != alVar.f1049g) {
                    C0139m.m963a().m984a(C0095a.f771a, "key_imei", alVar.f1049g.getBytes("UTF-8"), null, true);
                    c0092a.m615e(alVar.f1049g);
                }
            } catch (Throwable th) {
            }
            c0092a.f728h = alVar.f1047e;
            if (alVar.f1044b == 510) {
                if (alVar.f1045c == null) {
                    C0148u.m1041e("remote data is miss! %d", Integer.valueOf(alVar.f1044b));
                    return false;
                }
                an anVar = (an) C0124a.m788a(alVar.f1045c, an.class);
                if (anVar == null) {
                    C0148u.m1041e("remote data is error! %d", Integer.valueOf(alVar.f1044b));
                    return false;
                }
                String str2 = "en:%b qu:%b uin:%b vm:%d";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(anVar.f1056a);
                objArr[1] = Boolean.valueOf(anVar.f1058c);
                objArr[2] = Boolean.valueOf(anVar.f1057b);
                objArr[3] = Integer.valueOf(anVar.f1062g == null ? -1 : anVar.f1062g.size());
                C0148u.m1039c(str2, objArr);
                c0095a.m646a(anVar);
            }
            return true;
        }
    }

    public final void run() {
        byte[] bArr = this.f1169e;
        this.f1178n = 0;
        this.f1179o = 0;
        this.f1180p = 0;
        this.f1173i.m1012a(this.f1174j, System.currentTimeMillis());
        if (this.f1175k != null) {
            C0083q c0083q = this.f1175k;
            int i = this.f1168d;
        }
        if (this.f1176l != null) {
            c0083q = this.f1176l;
            i = this.f1168d;
        }
        if (C0124a.m827e(this.f1167c) == null) {
            m1023a(null, false, 0, "network is not availiable!", 0);
        } else if (bArr == null || bArr.length == 0) {
            m1023a(null, false, 0, "[upload] fail, request package is empty!", 0);
        } else {
            if (((long) bArr.length) + this.f1173i.m1020b() >= 2097152) {
                C0148u.m1041e("up too much wait to next time ! %d %d ", Long.valueOf(this.f1173i.m1020b()), Long.valueOf(2097152));
                m1023a(null, false, 0, "[upload] fail, over net consume: " + 2048 + "K", 0);
                return;
            }
            C0148u.m1039c("do upload task %d", Integer.valueOf(this.f1168d));
            if (this.f1167c == null || bArr == null || this.f1170f == null || this.f1171g == null || this.f1172h == null) {
                m1023a(null, false, 0, "[upload] fail, illegal access error!", 0);
                return;
            }
            StrategyBean c = this.f1171g.m648c();
            if (c == null) {
                m1023a(null, false, 0, "[upload] fail, illegal local strategy!", 0);
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("prodId", this.f1170f.m614e());
            hashMap.put("bundleId", this.f1170f.f723c);
            hashMap.put("appVer", this.f1170f.f729i);
            if (this.f1181q) {
                hashMap.put("cmd", Integer.toString(this.f1168d));
                hashMap.put("platformId", Byte.toString((byte) 1));
                this.f1170f.getClass();
                hashMap.put("sdkVer", "2.1.6");
                hashMap.put("strategylastUpdateTime", Long.toString(c.f761l));
                if (this.f1173i.m1018a(hashMap)) {
                    bArr = C0124a.m810a(bArr, 2);
                    if (bArr == null) {
                        m1023a(null, false, 0, "[upload] fail, failed to zip request body", 0);
                        return;
                    }
                    bArr = this.f1173i.m1019a(bArr);
                    if (bArr == null) {
                        m1023a(null, false, 0, "[upload] fail, failed to encrypt request body", 0);
                        return;
                    }
                }
                m1023a(null, false, 0, "[upload] fail, failed to add security info to HTTP headers", 0);
                return;
            }
            byte[] bArr2 = bArr;
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.f1165a) {
                Object obj;
                int i5 = i3 + 1;
                if (i3 != 0) {
                    C0148u.m1040d("failed to upload last time, wait and try(%d) again", Integer.valueOf(i5));
                    try {
                        Thread.sleep((long) this.f1166b);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        if (!C0148u.m1036a(th)) {
                            th.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                C0148u.m1039c("send %d", Integer.valueOf(bArr2.length));
                String str = this.f1177m;
                if (str == null || str.trim().length() <= 0) {
                    i3 = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (!this.f1181q) {
                        this.f1177m = c.f765p;
                    } else if (this.f1168d == 830) {
                        this.f1177m = c.f764o;
                    } else {
                        this.f1177m = c.f763n;
                    }
                }
                C0148u.m1039c("do upload to %s with cmd %d (pid=%d | tid=%d)", this.f1177m, Integer.valueOf(this.f1168d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                byte[] a = this.f1172h.m992a(this.f1177m, bArr2, this, hashMap);
                if (a == null) {
                    C0148u.m1041e("try upload fail! %d %s", Integer.valueOf(this.f1168d), "upload fail, no response!");
                    i3 = i5;
                    i4 = 1;
                } else {
                    Map map = this.f1172h.f1142a;
                    if (this.f1181q) {
                        if (map == null || map.size() == 0 || !map.containsKey("status")) {
                            C0148u.m1039c("no headers from server, just try again (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            C0148u.m1041e("try upload fail! %d %s", Integer.valueOf(this.f1168d), "upload fail, no status header");
                            i3 = i5;
                            i4 = 1;
                        } else {
                            try {
                                i2 = Integer.parseInt((String) map.get("status"));
                                C0148u.m1039c("status from server is %d (pid=%d | tid=%d)", Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                if (i2 != 0) {
                                    if (i2 == 2) {
                                        if (this.f1179o + this.f1180p > 0) {
                                            this.f1173i.m1016a((this.f1173i.m1020b() + this.f1179o) + this.f1180p);
                                        }
                                        this.f1173i.m1015a(i2, null);
                                        C0148u.m1035a("Session ID is invalid, will try again immediately (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                        this.f1173i.m1011a(this.f1174j, this.f1168d, this.f1169e, null, this.f1176l);
                                        return;
                                    }
                                    m1023a(null, false, 1, "upload fail, status: " + Integer.toString(i2), i2);
                                    return;
                                }
                            } catch (Throwable th2) {
                                str = "upload fail, format of status header is invalid: " + Integer.toString(i2);
                                C0148u.m1041e("try upload fail! %d %s", Integer.valueOf(this.f1168d), str);
                                i3 = i5;
                                i4 = 1;
                            }
                        }
                    }
                    C0148u.m1039c("recv %d", Integer.valueOf(a.length));
                    if (this.f1181q) {
                        bArr = this.f1173i.m1021b(a);
                        if (bArr == null) {
                            m1023a(null, false, 1, "upload fail, failed to decrypt response from server", 0);
                            return;
                        }
                        bArr = C0124a.m820b(bArr, 2);
                        if (bArr == null) {
                            m1023a(null, false, 1, "upload fail, failed to unzip(gzip) response from server", 0);
                            return;
                        }
                    }
                    bArr = a;
                    al a2 = C0124a.m785a(bArr, this.f1181q);
                    if (a2 == null) {
                        m1023a(null, false, 1, "upload fail, resp null!", 0);
                        return;
                    }
                    if (this.f1181q) {
                        this.f1173i.m1015a(i2, a2);
                    }
                    String str2 = "response %d %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(a2.f1044b);
                    objArr[1] = Integer.valueOf(a2.f1045c == null ? 0 : a2.f1045c.length);
                    C0148u.m1039c(str2, objArr);
                    if (C0145s.m1024a(a2, this.f1170f, this.f1171g)) {
                        m1023a(a2, true, 2, null, 0);
                        return;
                    } else {
                        m1023a(a2, false, 2, a2.f1048f, 0);
                        return;
                    }
                }
            }
            m1023a(null, false, i4, "try OT Fail!", 0);
        }
    }

    /* renamed from: a */
    public final void m1025a(long j) {
        this.f1178n++;
        this.f1179o += j;
    }

    /* renamed from: b */
    public final void m1026b(long j) {
        this.f1180p += j;
    }
}
