package com.tencent.bugly.legu.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.u */
public final class C0070u implements Runnable {
    /* renamed from: a */
    private int f567a;
    /* renamed from: b */
    private int f568b;
    /* renamed from: c */
    private final Context f569c;
    /* renamed from: d */
    private final int f570d;
    /* renamed from: e */
    private final byte[] f571e;
    /* renamed from: f */
    private final C0016a f572f;
    /* renamed from: g */
    private final C0019a f573g;
    /* renamed from: h */
    private final C0067r f574h;
    /* renamed from: i */
    private final C0069t f575i;
    /* renamed from: j */
    private final int f576j;
    /* renamed from: k */
    private final C0007s f577k;
    /* renamed from: l */
    private final C0007s f578l;
    /* renamed from: m */
    private String f579m;
    /* renamed from: n */
    private int f580n;
    /* renamed from: o */
    private long f581o;
    /* renamed from: p */
    private long f582p;
    /* renamed from: q */
    private boolean f583q;

    public C0070u(Context context, int i, am amVar, String str, C0007s c0007s, boolean z) {
        this(context, i, amVar.f416g, C0048a.m273a(amVar), str, c0007s, z);
    }

    public C0070u(Context context, int i, int i2, byte[] bArr, String str, C0007s c0007s, boolean z) {
        this(context, i, i2, bArr, str, c0007s, z, 5, 60000);
    }

    private C0070u(Context context, int i, int i2, byte[] bArr, String str, C0007s c0007s, boolean z, int i3, int i4) {
        this.f567a = 3;
        this.f568b = 30000;
        this.f579m = "";
        this.f580n = 0;
        this.f581o = 0;
        this.f582p = 0;
        this.f583q = true;
        this.f569c = context;
        this.f572f = C0016a.m70a(context);
        this.f571e = bArr;
        this.f573g = C0019a.m114a();
        this.f574h = C0067r.m471a(context);
        this.f575i = C0069t.m478a();
        this.f576j = i;
        this.f579m = str;
        this.f577k = c0007s;
        C0069t c0069t = this.f575i;
        this.f578l = null;
        this.f583q = z;
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
        this.f570d = i2;
        this.f567a = 5;
        this.f568b = 60000;
    }

    /* renamed from: a */
    private void m507a(an anVar, boolean z, int i, String str, int i2) {
        String str2;
        switch (this.f570d) {
            case 630:
            case 830:
                str2 = "crash";
                break;
            case 640:
            case 840:
                str2 = "userinfo";
                break;
            default:
                str2 = String.valueOf(this.f570d);
                break;
        }
        if (z) {
            C0073w.m519a("[upload] success: %s", str2);
        } else {
            C0073w.m525e("[upload] fail! %s %d %s", str2, Integer.valueOf(i), str);
            if (this.f583q) {
                this.f575i.m499a(i2, null);
            }
        }
        if (this.f581o + this.f582p > 0) {
            this.f575i.m500a((this.f575i.m504b() + this.f581o) + this.f582p);
        }
        if (this.f577k != null) {
            C0007s c0007s = this.f577k;
            int i3 = this.f570d;
            long j = this.f581o;
            j = this.f582p;
            c0007s.mo5a(z);
        }
        if (this.f578l != null) {
            c0007s = this.f578l;
            i3 = this.f570d;
            j = this.f581o;
            j = this.f582p;
            c0007s.mo5a(z);
        }
    }

    /* renamed from: a */
    private static boolean m508a(an anVar, C0016a c0016a, C0019a c0019a) {
        if (anVar == null) {
            C0073w.m524d("resp == null!", new Object[0]);
            return false;
        } else if (anVar.f436a != (byte) 0) {
            C0073w.m525e("resp result error %d", Byte.valueOf(anVar.f436a));
            return false;
        } else {
            try {
                String str = anVar.f439d;
                int i = (str == null || str.trim().length() <= 0) ? 1 : 0;
                if (i == 0 && C0016a.m69a().m93h() != anVar.f439d) {
                    C0064o.m440a().m466a(C0019a.f164a, "key_ip", anVar.f439d.getBytes("UTF-8"), null, true);
                    c0016a.m86d(anVar.f439d);
                }
                str = anVar.f442g;
                if (str == null || str.trim().length() <= 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0 && C0016a.m69a().m94i() != anVar.f442g) {
                    C0064o.m440a().m466a(C0019a.f164a, "key_imei", anVar.f442g.getBytes("UTF-8"), null, true);
                    c0016a.m88e(anVar.f442g);
                }
            } catch (Throwable th) {
            }
            c0016a.f121h = anVar.f440e;
            if (anVar.f437b == 510) {
                if (anVar.f438c == null) {
                    C0073w.m525e("remote data is miss! %d", Integer.valueOf(anVar.f437b));
                    return false;
                }
                ap apVar = (ap) C0048a.m254a(anVar.f438c, ap.class);
                if (apVar == null) {
                    C0073w.m525e("remote data is error! %d", Integer.valueOf(anVar.f437b));
                    return false;
                }
                String str2 = "en:%b qu:%b uin:%b vm:%d";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(apVar.f449a);
                objArr[1] = Boolean.valueOf(apVar.f451c);
                objArr[2] = Boolean.valueOf(apVar.f450b);
                objArr[3] = Integer.valueOf(apVar.f455g == null ? -1 : apVar.f455g.size());
                C0073w.m523c(str2, objArr);
                c0019a.m119a(apVar);
            }
            return true;
        }
    }

    public final void run() {
        byte[] bArr = this.f571e;
        this.f580n = 0;
        this.f581o = 0;
        this.f582p = 0;
        this.f575i.m496a(this.f576j, System.currentTimeMillis());
        if (this.f577k != null) {
            C0007s c0007s = this.f577k;
            int i = this.f570d;
        }
        if (this.f578l != null) {
            c0007s = this.f578l;
            i = this.f570d;
        }
        if (C0048a.m293e(this.f569c) == null) {
            m507a(null, false, 0, "network is not availiable!", 0);
        } else if (bArr == null || bArr.length == 0) {
            m507a(null, false, 0, "[upload] fail, request package is empty!", 0);
        } else {
            if (((long) bArr.length) + this.f575i.m504b() >= 2097152) {
                C0073w.m525e("up too much wait to next time ! %d %d ", Long.valueOf(this.f575i.m504b()), Long.valueOf(2097152));
                m507a(null, false, 0, "[upload] fail, over net consume: " + 2048 + "K", 0);
                return;
            }
            C0073w.m523c("do upload task %d", Integer.valueOf(this.f570d));
            if (this.f569c == null || bArr == null || this.f572f == null || this.f573g == null || this.f574h == null) {
                m507a(null, false, 0, "[upload] fail, illegal access error!", 0);
                return;
            }
            StrategyBean c = this.f573g.m121c();
            if (c == null) {
                m507a(null, false, 0, "[upload] fail, illegal local strategy!", 0);
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("prodId", this.f572f.m87e());
            hashMap.put("bundleId", this.f572f.f116c);
            hashMap.put("appVer", this.f572f.f122i);
            if (this.f583q) {
                hashMap.put("cmd", Integer.toString(this.f570d));
                hashMap.put("platformId", Byte.toString((byte) 1));
                this.f572f.getClass();
                hashMap.put("sdkVer", "2.1.9");
                hashMap.put("strategylastUpdateTime", Long.toString(c.f154l));
                if (this.f575i.m502a(hashMap)) {
                    bArr = C0048a.m276a(bArr, 2);
                    if (bArr == null) {
                        m507a(null, false, 0, "[upload] fail, failed to zip request body", 0);
                        return;
                    }
                    bArr = this.f575i.m503a(bArr);
                    if (bArr == null) {
                        m507a(null, false, 0, "[upload] fail, failed to encrypt request body", 0);
                        return;
                    }
                }
                m507a(null, false, 0, "[upload] fail, failed to add security info to HTTP headers", 0);
                return;
            }
            byte[] bArr2 = bArr;
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.f567a) {
                Object obj;
                int i5 = i3 + 1;
                if (i3 != 0) {
                    C0073w.m524d("failed to upload last time, wait and try(%d) again", Integer.valueOf(i5));
                    try {
                        Thread.sleep((long) this.f568b);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        if (!C0073w.m520a(th)) {
                            th.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                C0073w.m523c("send %d", Integer.valueOf(bArr2.length));
                String str = this.f579m;
                if (str == null || str.trim().length() <= 0) {
                    i3 = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (!this.f583q) {
                        this.f579m = c.f158p;
                    } else if (this.f570d == 830) {
                        this.f579m = c.f157o;
                    } else {
                        this.f579m = c.f156n;
                    }
                }
                C0073w.m523c("do upload to %s with cmd %d (pid=%d | tid=%d)", this.f579m, Integer.valueOf(this.f570d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                byte[] a = this.f574h.m476a(this.f579m, bArr2, this, hashMap);
                if (a == null) {
                    C0073w.m525e("try upload fail! %d %s", Integer.valueOf(this.f570d), "upload fail, no response!");
                    i3 = i5;
                    i4 = 1;
                } else {
                    Map map = this.f574h.f544a;
                    if (this.f583q) {
                        if (map == null || map.size() == 0 || !map.containsKey("status")) {
                            C0073w.m523c("no headers from server, just try again (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            C0073w.m525e("try upload fail! %d %s", Integer.valueOf(this.f570d), "upload fail, no status header");
                            i3 = i5;
                            i4 = 1;
                        } else {
                            try {
                                i2 = Integer.parseInt((String) map.get("status"));
                                C0073w.m523c("status from server is %d (pid=%d | tid=%d)", Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                if (i2 != 0) {
                                    if (i2 == 2) {
                                        if (this.f581o + this.f582p > 0) {
                                            this.f575i.m500a((this.f575i.m504b() + this.f581o) + this.f582p);
                                        }
                                        this.f575i.m499a(i2, null);
                                        C0073w.m519a("Session ID is invalid, will try again immediately (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                        this.f575i.m495a(this.f576j, this.f570d, this.f571e, null, this.f578l);
                                        return;
                                    }
                                    m507a(null, false, 1, "upload fail, status: " + Integer.toString(i2), i2);
                                    return;
                                }
                            } catch (Throwable th2) {
                                str = "upload fail, format of status header is invalid: " + Integer.toString(i2);
                                C0073w.m525e("try upload fail! %d %s", Integer.valueOf(this.f570d), str);
                                i3 = i5;
                                i4 = 1;
                            }
                        }
                    }
                    C0073w.m523c("recv %d", Integer.valueOf(a.length));
                    if (this.f583q) {
                        bArr = this.f575i.m505b(a);
                        if (bArr == null) {
                            m507a(null, false, 1, "upload fail, failed to decrypt response from server", 0);
                            return;
                        }
                        bArr = C0048a.m286b(bArr, 2);
                        if (bArr == null) {
                            m507a(null, false, 1, "upload fail, failed to unzip(gzip) response from server", 0);
                            return;
                        }
                    }
                    bArr = a;
                    an a2 = C0048a.m251a(bArr, this.f583q);
                    if (a2 == null) {
                        m507a(null, false, 1, "upload fail, resp null!", 0);
                        return;
                    }
                    if (this.f583q) {
                        this.f575i.m499a(i2, a2);
                    }
                    String str2 = "response %d %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(a2.f437b);
                    objArr[1] = Integer.valueOf(a2.f438c == null ? 0 : a2.f438c.length);
                    C0073w.m523c(str2, objArr);
                    if (C0070u.m508a(a2, this.f572f, this.f573g)) {
                        m507a(a2, true, 2, null, 0);
                        return;
                    } else {
                        m507a(a2, false, 2, a2.f441f, 0);
                        return;
                    }
                }
            }
            m507a(null, false, i4, "try OT Fail!", 0);
        }
    }

    /* renamed from: a */
    public final void m509a(long j) {
        this.f580n++;
        this.f581o += j;
    }

    /* renamed from: b */
    public final void m510b(long j) {
        this.f582p += j;
    }
}
