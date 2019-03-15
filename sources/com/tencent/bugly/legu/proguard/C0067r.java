package com.tencent.bugly.legu.proguard;

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
/* renamed from: com.tencent.bugly.legu.proguard.r */
public final class C0067r {
    /* renamed from: b */
    private static C0067r f543b;
    /* renamed from: a */
    public Map<String, String> f544a = null;
    /* renamed from: c */
    private Context f545c;

    private C0067r(Context context) {
        this.f545c = context;
    }

    /* renamed from: a */
    public static C0067r m471a(Context context) {
        if (f543b == null) {
            f543b = new C0067r(context);
        }
        return f543b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final byte[] m476a(java.lang.String r16, byte[] r17, com.tencent.bugly.legu.proguard.C0070u r18, java.util.Map<java.lang.String, java.lang.String> r19) {
        /*
        r15 = this;
        if (r16 != 0) goto L_0x000c;
    L_0x0002:
        r2 = "rqdp{  no destUrl!}";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.bugly.legu.proguard.C0073w.m525e(r2, r3);
        r2 = 0;
    L_0x000b:
        return r2;
    L_0x000c:
        r6 = 0;
        r5 = 0;
        if (r17 != 0) goto L_0x005b;
    L_0x0010:
        r2 = 0;
    L_0x0012:
        r4 = "req %s sz:%d (pid=%d | tid=%d)";
        r7 = 4;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r16;
        r8 = 1;
        r9 = java.lang.Long.valueOf(r2);
        r7[r8] = r9;
        r8 = 2;
        r9 = android.os.Process.myPid();
        r9 = java.lang.Integer.valueOf(r9);
        r7[r8] = r9;
        r8 = 3;
        r9 = android.os.Process.myTid();
        r9 = java.lang.Integer.valueOf(r9);
        r7[r8] = r9;
        com.tencent.bugly.legu.proguard.C0073w.m523c(r4, r7);
        r4 = 0;
        r8 = r6;
        r7 = r16;
    L_0x003e:
        r6 = r8 + 1;
        r9 = 3;
        if (r8 >= r9) goto L_0x018e;
    L_0x0043:
        r8 = 2;
        if (r5 >= r8) goto L_0x018e;
    L_0x0046:
        if (r4 == 0) goto L_0x0060;
    L_0x0048:
        r4 = 0;
    L_0x0049:
        r8 = r15.f545c;
        r8 = com.tencent.bugly.legu.proguard.C0048a.m293e(r8);
        if (r8 != 0) goto L_0x007e;
    L_0x0051:
        r8 = "req but network not avail,so drop!";
        r9 = 0;
        r9 = new java.lang.Object[r9];
        com.tencent.bugly.legu.proguard.C0073w.m524d(r8, r9);
        r8 = r6;
        goto L_0x003e;
    L_0x005b:
        r0 = r17;
        r2 = r0.length;
        r2 = (long) r2;
        goto L_0x0012;
    L_0x0060:
        r8 = 1;
        if (r6 <= r8) goto L_0x0049;
    L_0x0063:
        r8 = new java.lang.StringBuilder;
        r9 = "try time ";
        r8.<init>(r9);
        r8 = r8.append(r6);
        r8 = r8.toString();
        r9 = 0;
        r9 = new java.lang.Object[r9];
        com.tencent.bugly.legu.proguard.C0073w.m523c(r8, r9);
        r8 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        android.os.SystemClock.sleep(r8);
        goto L_0x0049;
    L_0x007e:
        r0 = r18;
        r0.m509a(r2);
        r0 = r17;
        r1 = r19;
        r11 = r15.m473a(r7, r0, r8, r1);
        if (r11 == 0) goto L_0x017e;
    L_0x008d:
        r10 = r11.getResponseCode();	 Catch:{ IOException -> 0x0155 }
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r10 != r8) goto L_0x00bc;
    L_0x0095:
        r8 = com.tencent.bugly.legu.proguard.C0067r.m474a(r11);	 Catch:{ IOException -> 0x0155 }
        r15.f544a = r8;	 Catch:{ IOException -> 0x0155 }
        r8 = com.tencent.bugly.legu.proguard.C0067r.m475b(r11);	 Catch:{ IOException -> 0x0155 }
        if (r8 != 0) goto L_0x00ae;
    L_0x00a1:
        r9 = 0;
    L_0x00a3:
        r0 = r18;
        r0.m510b(r9);	 Catch:{ IOException -> 0x0155 }
        r11.disconnect();	 Catch:{ Throwable -> 0x00b1 }
    L_0x00ab:
        r2 = r8;
        goto L_0x000b;
    L_0x00ae:
        r9 = r8.length;	 Catch:{ IOException -> 0x0155 }
        r9 = (long) r9;
        goto L_0x00a3;
    L_0x00b1:
        r2 = move-exception;
        r3 = com.tencent.bugly.legu.proguard.C0073w.m520a(r2);
        if (r3 != 0) goto L_0x00ab;
    L_0x00b8:
        r2.printStackTrace();
        goto L_0x00ab;
    L_0x00bc:
        r8 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r10 == r8) goto L_0x00cc;
    L_0x00c0:
        r8 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r10 == r8) goto L_0x00cc;
    L_0x00c4:
        r8 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r10 == r8) goto L_0x00cc;
    L_0x00c8:
        r8 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r10 != r8) goto L_0x00f9;
    L_0x00cc:
        r8 = 1;
    L_0x00cd:
        if (r8 == 0) goto L_0x011d;
    L_0x00cf:
        r8 = 1;
        r4 = "Location";
        r9 = r11.getHeaderField(r4);	 Catch:{ IOException -> 0x0191 }
        if (r9 != 0) goto L_0x0106;
    L_0x00d8:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0191 }
        r9 = "rqdp{  redirect code:}";
        r4.<init>(r9);	 Catch:{ IOException -> 0x0191 }
        r4 = r4.append(r10);	 Catch:{ IOException -> 0x0191 }
        r9 = "rqdp{   Location is null! return}";
        r4 = r4.append(r9);	 Catch:{ IOException -> 0x0191 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0191 }
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ IOException -> 0x0191 }
        com.tencent.bugly.legu.proguard.C0073w.m525e(r4, r9);	 Catch:{ IOException -> 0x0191 }
        r11.disconnect();	 Catch:{ Throwable -> 0x00fb }
    L_0x00f6:
        r2 = 0;
        goto L_0x000b;
    L_0x00f9:
        r8 = 0;
        goto L_0x00cd;
    L_0x00fb:
        r2 = move-exception;
        r3 = com.tencent.bugly.legu.proguard.C0073w.m520a(r2);
        if (r3 != 0) goto L_0x00f6;
    L_0x0102:
        r2.printStackTrace();
        goto L_0x00f6;
    L_0x0106:
        r5 = r5 + 1;
        r6 = 0;
        r4 = "redirect code: %d ,to:%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ IOException -> 0x0196 }
        r12 = 0;
        r13 = java.lang.Integer.valueOf(r10);	 Catch:{ IOException -> 0x0196 }
        r7[r12] = r13;	 Catch:{ IOException -> 0x0196 }
        r12 = 1;
        r7[r12] = r9;	 Catch:{ IOException -> 0x0196 }
        com.tencent.bugly.legu.proguard.C0073w.m523c(r4, r7);	 Catch:{ IOException -> 0x0196 }
        r4 = r8;
        r7 = r9;
    L_0x011d:
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0155 }
        r9 = "response code ";
        r8.<init>(r9);	 Catch:{ IOException -> 0x0155 }
        r8 = r8.append(r10);	 Catch:{ IOException -> 0x0155 }
        r8 = r8.toString();	 Catch:{ IOException -> 0x0155 }
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ IOException -> 0x0155 }
        com.tencent.bugly.legu.proguard.C0073w.m524d(r8, r9);	 Catch:{ IOException -> 0x0155 }
        r8 = r11.getContentLength();	 Catch:{ IOException -> 0x0155 }
        r8 = (long) r8;	 Catch:{ IOException -> 0x0155 }
        r12 = 0;
        r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r10 >= 0) goto L_0x013f;
    L_0x013d:
        r8 = 0;
    L_0x013f:
        r0 = r18;
        r0.m510b(r8);	 Catch:{ IOException -> 0x0155 }
        r11.disconnect();	 Catch:{ Throwable -> 0x014a }
    L_0x0147:
        r8 = r6;
        goto L_0x003e;
    L_0x014a:
        r8 = move-exception;
        r9 = com.tencent.bugly.legu.proguard.C0073w.m520a(r8);
        if (r9 != 0) goto L_0x0147;
    L_0x0151:
        r8.printStackTrace();
        goto L_0x0147;
    L_0x0155:
        r8 = move-exception;
    L_0x0156:
        r9 = com.tencent.bugly.legu.proguard.C0073w.m520a(r8);	 Catch:{ all -> 0x016e }
        if (r9 != 0) goto L_0x015f;
    L_0x015c:
        r8.printStackTrace();	 Catch:{ all -> 0x016e }
    L_0x015f:
        r11.disconnect();	 Catch:{ Throwable -> 0x0163 }
        goto L_0x0147;
    L_0x0163:
        r8 = move-exception;
        r9 = com.tencent.bugly.legu.proguard.C0073w.m520a(r8);
        if (r9 != 0) goto L_0x0147;
    L_0x016a:
        r8.printStackTrace();
        goto L_0x0147;
    L_0x016e:
        r2 = move-exception;
        r11.disconnect();	 Catch:{ Throwable -> 0x0173 }
    L_0x0172:
        throw r2;
    L_0x0173:
        r3 = move-exception;
        r4 = com.tencent.bugly.legu.proguard.C0073w.m520a(r3);
        if (r4 != 0) goto L_0x0172;
    L_0x017a:
        r3.printStackTrace();
        goto L_0x0172;
    L_0x017e:
        r8 = "Failed to execute post.";
        r9 = 0;
        r9 = new java.lang.Object[r9];
        com.tencent.bugly.legu.proguard.C0073w.m523c(r8, r9);
        r8 = 0;
        r0 = r18;
        r0.m510b(r8);
        goto L_0x0147;
    L_0x018e:
        r2 = 0;
        goto L_0x000b;
    L_0x0191:
        r4 = move-exception;
        r14 = r4;
        r4 = r8;
        r8 = r14;
        goto L_0x0156;
    L_0x0196:
        r4 = move-exception;
        r7 = r9;
        r14 = r8;
        r8 = r4;
        r4 = r14;
        goto L_0x0156;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.legu.proguard.r.a(java.lang.String, byte[], com.tencent.bugly.legu.proguard.u, java.util.Map):byte[]");
    }

    /* renamed from: a */
    private static Map<String, String> m474a(HttpURLConnection httpURLConnection) {
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
    private static byte[] m475b(HttpURLConnection httpURLConnection) {
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
                        if (!C0073w.m520a(th3)) {
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
    private HttpURLConnection m473a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            C0073w.m525e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection a = C0067r.m472a(str2, str);
        if (a == null) {
            C0073w.m525e("Failed to get HttpURLConnection object.", new Object[0]);
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
            a.setRequestProperty("A38", URLEncoder.encode(C0048a.m293e(this.f545c), "utf-8"));
            a.connect();
            OutputStream outputStream = a.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a;
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            C0073w.m525e("Failed to upload crash, please check your network.", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m472a(String str, String str2) {
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
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
