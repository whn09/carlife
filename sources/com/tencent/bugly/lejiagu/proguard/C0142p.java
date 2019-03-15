package com.tencent.bugly.lejiagu.proguard;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.p */
public final class C0142p {
    /* renamed from: b */
    private static C0142p f1141b;
    /* renamed from: a */
    public Map<String, String> f1142a = null;
    /* renamed from: c */
    private Context f1143c;

    private C0142p(Context context) {
        this.f1143c = context;
    }

    /* renamed from: a */
    public static C0142p m987a(Context context) {
        if (f1141b == null) {
            f1141b = new C0142p(context);
        }
        return f1141b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final byte[] m992a(java.lang.String r16, byte[] r17, com.tencent.bugly.lejiagu.proguard.C0145s r18, java.util.Map<java.lang.String, java.lang.String> r19) {
        /*
        r15 = this;
        if (r16 != 0) goto L_0x000c;
    L_0x0002:
        r2 = "rqdp{  no destUrl!}";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.bugly.lejiagu.proguard.C0148u.m1041e(r2, r3);
        r2 = 0;
    L_0x000b:
        return r2;
    L_0x000c:
        r7 = 0;
        r6 = 0;
        if (r17 != 0) goto L_0x005b;
    L_0x0010:
        r2 = 0;
    L_0x0012:
        r4 = "req %s sz:%d (pid=%d | tid=%d)";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r5[r8] = r16;
        r8 = 1;
        r9 = java.lang.Long.valueOf(r2);
        r5[r8] = r9;
        r8 = 2;
        r9 = android.os.Process.myPid();
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 3;
        r9 = android.os.Process.myTid();
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        com.tencent.bugly.lejiagu.proguard.C0148u.m1039c(r4, r5);
        r4 = 0;
        r5 = r7;
        r8 = r16;
    L_0x003e:
        r7 = r5 + 1;
        r9 = 3;
        if (r5 >= r9) goto L_0x014e;
    L_0x0043:
        r5 = 2;
        if (r6 >= r5) goto L_0x014e;
    L_0x0046:
        if (r4 == 0) goto L_0x0060;
    L_0x0048:
        r4 = 0;
    L_0x0049:
        r5 = r15.f1143c;
        r5 = com.tencent.bugly.lejiagu.proguard.C0124a.m827e(r5);
        if (r5 != 0) goto L_0x007e;
    L_0x0051:
        r5 = "req but network not avail,so drop!";
        r9 = 0;
        r9 = new java.lang.Object[r9];
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r5, r9);
        r5 = r7;
        goto L_0x003e;
    L_0x005b:
        r0 = r17;
        r2 = r0.length;
        r2 = (long) r2;
        goto L_0x0012;
    L_0x0060:
        r5 = 1;
        if (r7 <= r5) goto L_0x0049;
    L_0x0063:
        r5 = new java.lang.StringBuilder;
        r9 = "try time ";
        r5.<init>(r9);
        r5 = r5.append(r7);
        r5 = r5.toString();
        r9 = 0;
        r9 = new java.lang.Object[r9];
        com.tencent.bugly.lejiagu.proguard.C0148u.m1039c(r5, r9);
        r9 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        android.os.SystemClock.sleep(r9);
        goto L_0x0049;
    L_0x007e:
        r0 = r18;
        r0.m1025a(r2);
        r0 = r17;
        r1 = r19;
        r10 = r15.m989a(r8, r0, r5, r1);
        if (r10 == 0) goto L_0x013c;
    L_0x008d:
        r11 = r10.getResponseCode();	 Catch:{ IOException -> 0x012b }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r11 != r5) goto L_0x00ae;
    L_0x0095:
        r5 = com.tencent.bugly.lejiagu.proguard.C0142p.m990a(r10);	 Catch:{ IOException -> 0x012b }
        r15.f1142a = r5;	 Catch:{ IOException -> 0x012b }
        r5 = com.tencent.bugly.lejiagu.proguard.C0142p.m991b(r10);	 Catch:{ IOException -> 0x012b }
        if (r5 != 0) goto L_0x00ab;
    L_0x00a1:
        r9 = 0;
    L_0x00a3:
        r0 = r18;
        r0.m1026b(r9);	 Catch:{ IOException -> 0x012b }
        r2 = r5;
        goto L_0x000b;
    L_0x00ab:
        r9 = r5.length;	 Catch:{ IOException -> 0x012b }
        r9 = (long) r9;
        goto L_0x00a3;
    L_0x00ae:
        r5 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r11 == r5) goto L_0x00be;
    L_0x00b2:
        r5 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r11 == r5) goto L_0x00be;
    L_0x00b6:
        r5 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r11 == r5) goto L_0x00be;
    L_0x00ba:
        r5 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r11 != r5) goto L_0x00e8;
    L_0x00be:
        r5 = 1;
    L_0x00bf:
        if (r5 == 0) goto L_0x0156;
    L_0x00c1:
        r5 = 1;
        r4 = "Location";
        r9 = r10.getHeaderField(r4);	 Catch:{ IOException -> 0x0151 }
        if (r9 != 0) goto L_0x00ea;
    L_0x00ca:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0151 }
        r9 = "rqdp{  redirect code:}";
        r4.<init>(r9);	 Catch:{ IOException -> 0x0151 }
        r4 = r4.append(r11);	 Catch:{ IOException -> 0x0151 }
        r9 = "rqdp{   Location is null! return}";
        r4 = r4.append(r9);	 Catch:{ IOException -> 0x0151 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0151 }
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ IOException -> 0x0151 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1041e(r4, r9);	 Catch:{ IOException -> 0x0151 }
        r2 = 0;
        goto L_0x000b;
    L_0x00e8:
        r5 = 0;
        goto L_0x00bf;
    L_0x00ea:
        r6 = r6 + 1;
        r7 = 0;
        r4 = "redirect code: %d ,to:%s";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ IOException -> 0x0153 }
        r12 = 0;
        r13 = java.lang.Integer.valueOf(r11);	 Catch:{ IOException -> 0x0153 }
        r8[r12] = r13;	 Catch:{ IOException -> 0x0153 }
        r12 = 1;
        r8[r12] = r9;	 Catch:{ IOException -> 0x0153 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1039c(r4, r8);	 Catch:{ IOException -> 0x0153 }
        r8 = r9;
    L_0x0100:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0151 }
        r9 = "response code ";
        r4.<init>(r9);	 Catch:{ IOException -> 0x0151 }
        r4 = r4.append(r11);	 Catch:{ IOException -> 0x0151 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0151 }
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ IOException -> 0x0151 }
        com.tencent.bugly.lejiagu.proguard.C0148u.m1040d(r4, r9);	 Catch:{ IOException -> 0x0151 }
        r4 = r10.getContentLength();	 Catch:{ IOException -> 0x0151 }
        r9 = (long) r4;	 Catch:{ IOException -> 0x0151 }
        r11 = 0;
        r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r4 >= 0) goto L_0x0122;
    L_0x0120:
        r9 = 0;
    L_0x0122:
        r0 = r18;
        r0.m1026b(r9);	 Catch:{ IOException -> 0x0151 }
        r4 = r5;
        r5 = r7;
        goto L_0x003e;
    L_0x012b:
        r5 = move-exception;
        r14 = r5;
        r5 = r4;
        r4 = r14;
    L_0x012f:
        r9 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r4);
        if (r9 != 0) goto L_0x0138;
    L_0x0135:
        r4.printStackTrace();
    L_0x0138:
        r4 = r5;
        r5 = r7;
        goto L_0x003e;
    L_0x013c:
        r5 = "Failed to execute post.";
        r9 = 0;
        r9 = new java.lang.Object[r9];
        com.tencent.bugly.lejiagu.proguard.C0148u.m1039c(r5, r9);
        r9 = 0;
        r0 = r18;
        r0.m1026b(r9);
        r5 = r7;
        goto L_0x003e;
    L_0x014e:
        r2 = 0;
        goto L_0x000b;
    L_0x0151:
        r4 = move-exception;
        goto L_0x012f;
    L_0x0153:
        r4 = move-exception;
        r8 = r9;
        goto L_0x012f;
    L_0x0156:
        r5 = r4;
        goto L_0x0100;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.lejiagu.proguard.p.a(java.lang.String, byte[], com.tencent.bugly.lejiagu.proguard.s, java.util.Map):byte[]");
    }

    /* renamed from: a */
    private static Map<String, String> m990a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List list = (List) headerFields.get(str);
            if (list.size() > 0) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private static byte[] m991b(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        if (httpURLConnection != null) {
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr2);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    th3 = th4;
                    try {
                        if (!C0148u.m1036a(th3)) {
                            th3.printStackTrace();
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th32) {
                                th32.printStackTrace();
                            }
                        }
                        return bArr;
                    } catch (Throwable th5) {
                        th2 = th5;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th322) {
                                th322.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3222) {
                bufferedInputStream = bArr;
                th2 = th3222;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th2;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    private HttpURLConnection m989a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            C0148u.m1041e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection a = C0142p.m988a(str2, str);
        if (a == null) {
            C0148u.m1041e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Entry entry : map.entrySet()) {
                    a.setRequestProperty((String) entry.getKey(), URLEncoder.encode((String) entry.getValue(), "utf-8"));
                }
            }
            a.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            a.setRequestProperty("A38", URLEncoder.encode(C0124a.m827e(this.f1143c), "utf-8"));
            a.connect();
            OutputStream outputStream = a.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a;
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            C0148u.m1041e("Failed to upload crash, please check your network.", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m988a(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(str2);
            if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
