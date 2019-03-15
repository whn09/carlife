package com.tencent.bugly.legu.proguard;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.bugly.legu.crashreport.biz.UserInfoBean;
import com.tencent.bugly.legu.crashreport.common.info.AppInfo;
import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import com.tencent.bugly.legu.crashreport.common.info.PlugInBean;
import com.tencent.bugly.legu.crashreport.common.strategy.C0019a;
import com.tencent.bugly.legu.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.a */
public class C0048a {
    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f359a = new HashMap();
    /* renamed from: b */
    protected String f360b;
    /* renamed from: c */
    C0057h f361c;
    /* renamed from: d */
    private HashMap<String, Object> f362d;

    C0048a() {
        HashMap hashMap = new HashMap();
        this.f362d = new HashMap();
        this.f360b = "GBK";
        this.f361c = new C0057h();
    }

    /* renamed from: b */
    public static String m279b() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: a */
    public static aq m252a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.f462a = userInfoBean.f46e;
        aqVar.f466e = userInfoBean.f51j;
        aqVar.f465d = userInfoBean.f44c;
        aqVar.f464c = userInfoBean.f45d;
        aqVar.f468g = C0016a.m69a().m93h();
        aqVar.f469h = userInfoBean.f56o == 1;
        switch (userInfoBean.f43b) {
            case 1:
                aqVar.f463b = (byte) 1;
                break;
            case 2:
                aqVar.f463b = (byte) 4;
                break;
            case 3:
                aqVar.f463b = (byte) 2;
                break;
            case 4:
                aqVar.f463b = (byte) 3;
                break;
            default:
                if (userInfoBean.f43b >= 10 && userInfoBean.f43b < 20) {
                    aqVar.f463b = (byte) userInfoBean.f43b;
                    break;
                }
                C0073w.m525e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f43b));
                return null;
                break;
        }
        aqVar.f467f = new HashMap();
        if (userInfoBean.f57p >= 0) {
            aqVar.f467f.put("C01", userInfoBean.f57p);
        }
        if (userInfoBean.f58q >= 0) {
            aqVar.f467f.put("C02", userInfoBean.f58q);
        }
        if (userInfoBean.f59r != null && userInfoBean.f59r.size() > 0) {
            for (Entry entry : userInfoBean.f59r.entrySet()) {
                aqVar.f467f.put("C03_" + ((String) entry.getKey()), entry.getValue());
            }
        }
        if (userInfoBean.f60s != null && userInfoBean.f60s.size() > 0) {
            for (Entry entry2 : userInfoBean.f60s.entrySet()) {
                aqVar.f467f.put("C04_" + ((String) entry2.getKey()), entry2.getValue());
            }
        }
        aqVar.f467f.put("A36", (!userInfoBean.f53l));
        aqVar.f467f.put("F02", userInfoBean.f48g);
        aqVar.f467f.put("F03", userInfoBean.f49h);
        aqVar.f467f.put("F04", userInfoBean.f51j);
        aqVar.f467f.put("F05", userInfoBean.f50i);
        aqVar.f467f.put("F06", userInfoBean.f54m);
        aqVar.f467f.put("F10", userInfoBean.f52k);
        C0073w.m523c("summary type %d vm:%d", Byte.valueOf(aqVar.f463b), Integer.valueOf(aqVar.f467f.size()));
        return aqVar;
    }

    /* renamed from: a */
    public void mo19a(String str) {
        this.f360b = str;
    }

    /* renamed from: c */
    public static String m288c() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: d */
    public static int m290d() {
        try {
            return VERSION.SDK_INT;
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* renamed from: a */
    public static String m260a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (!C0073w.m520a(th2)) {
                th2.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: a */
    public static String m257a(Context context) {
        String deviceId;
        if (!AppInfo.m63a(context, "android.permission.READ_PHONE_STATE")) {
            C0073w.m524d("no READ_PHONE_STATE permission to get IMEI", new Object[0]);
            return "null";
        } else if (context == null) {
            return null;
        } else {
            try {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId == null) {
                    return deviceId;
                }
                try {
                    return deviceId.toLowerCase();
                } catch (Throwable th) {
                    Log.i(C0073w.f588a, "failed to get IMEI");
                    return deviceId;
                }
            } catch (Throwable th2) {
                deviceId = null;
                Log.i(C0073w.f588a, "failed to get IMEI");
                return deviceId;
            }
        }
    }

    /* renamed from: n */
    public static String m303n() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
        } catch (Exception e) {
            return new Date().toString();
        }
    }

    /* renamed from: a */
    public static String m261a(ArrayList<String> arrayList) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        for (i = 0; i < arrayList.size(); i++) {
            Object obj = (String) arrayList.get(i);
            if (obj.equals("java.lang.Integer") || obj.equals("int")) {
                obj = "int32";
            } else if (obj.equals("java.lang.Boolean") || obj.equals("boolean")) {
                obj = "bool";
            } else if (obj.equals("java.lang.Byte") || obj.equals("byte")) {
                obj = "char";
            } else if (obj.equals("java.lang.Double") || obj.equals("double")) {
                obj = "double";
            } else if (obj.equals("java.lang.Float") || obj.equals("float")) {
                obj = "float";
            } else if (obj.equals("java.lang.Long") || obj.equals("long")) {
                obj = "int64";
            } else if (obj.equals("java.lang.Short") || obj.equals("short")) {
                obj = "short";
            } else if (obj.equals("java.lang.Character")) {
                throw new IllegalArgumentException("can not support java.lang.Character");
            } else if (obj.equals("java.lang.String")) {
                obj = "string";
            } else if (obj.equals("java.util.List")) {
                obj = "list";
            } else if (obj.equals("java.util.Map")) {
                obj = "map";
            }
            arrayList.set(i, obj);
        }
        Collections.reverse(arrayList);
        for (i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (str.equals("list")) {
                arrayList.set(i - 1, "<" + ((String) arrayList.get(i - 1)));
                arrayList.set(0, ((String) arrayList.get(0)) + ">");
            } else if (str.equals("map")) {
                arrayList.set(i - 1, "<" + ((String) arrayList.get(i - 1)) + ",");
                arrayList.set(0, ((String) arrayList.get(0)) + ">");
            } else if (str.equals("Array")) {
                arrayList.set(i - 1, "<" + ((String) arrayList.get(i - 1)));
                arrayList.set(0, ((String) arrayList.get(0)) + ">");
            }
        }
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public <T> void mo20a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            C0058i c0058i = new C0058i();
            c0058i.m401a(this.f360b);
            c0058i.m407a((Object) t, 0);
            Object a = C0059k.m419a(c0058i.m402a());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            m267a(arrayList, (Object) t);
            hashMap.put(C0048a.m261a(arrayList), a);
            this.f362d.remove(str);
            this.f359a.put(str, hashMap);
        }
    }

    /* renamed from: a */
    public static String m262a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception e) {
            return new Date().toString();
        }
    }

    /* renamed from: b */
    public static String m280b(Context context) {
        String subscriberId;
        if (!AppInfo.m63a(context, "android.permission.READ_PHONE_STATE")) {
            C0073w.m524d("no READ_PHONE_STATE permission to get IMSI", new Object[0]);
            return "null";
        } else if (context == null) {
            return null;
        } else {
            try {
                subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                if (subscriberId == null) {
                    return subscriberId;
                }
                try {
                    return subscriberId.toLowerCase();
                } catch (Throwable th) {
                    Log.i(C0073w.f588a, "failed to get IMSI");
                    return subscriberId;
                }
            } catch (Throwable th2) {
                subscriberId = null;
                Log.i(C0073w.f588a, "failed to get IMSI");
                return subscriberId;
            }
        }
    }

    /* renamed from: c */
    public static String m289c(Context context) {
        Throwable th;
        String str = "fail";
        if (context == null) {
            return str;
        }
        try {
            String string = Secure.getString(context.getContentResolver(), "android_id");
            if (string != null) {
                return string.toLowerCase();
            }
            try {
                return "null";
            } catch (Throwable th2) {
                Throwable th3 = th2;
                str = string;
                th = th3;
                if (!C0073w.m520a(th)) {
                    return str;
                }
                Log.i(C0073w.f588a, "failed to get Android ID");
                return str;
            }
        } catch (Throwable th4) {
            th = th4;
            if (!C0073w.m520a(th)) {
                return str;
            }
            Log.i(C0073w.f588a, "failed to get Android ID");
            return str;
        }
    }

    /* renamed from: a */
    public static ar m253a(List<UserInfoBean> list, int i) {
        if (list == null || list.size() == 0) {
            return null;
        }
        C0016a a = C0016a.m69a();
        ar arVar = new ar();
        arVar.f473b = a.f117d;
        arVar.f474c = a.m91g();
        ArrayList arrayList = new ArrayList();
        for (UserInfoBean a2 : list) {
            aq a3 = C0048a.m252a(a2);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        arVar.f475d = arrayList;
        arVar.f476e = new HashMap();
        arVar.f476e.put("A7", a.f118e);
        arVar.f476e.put("A6", a.m103r());
        arVar.f476e.put("A5", a.m102q());
        arVar.f476e.put("A2", a.m100o());
        arVar.f476e.put("A1", a.m100o());
        arVar.f476e.put("A24", a.f120g);
        arVar.f476e.put("A17", a.m101p());
        arVar.f476e.put("A15", a.m105t());
        arVar.f476e.put("A13", a.m106u());
        arVar.f476e.put("F08", a.f134u);
        arVar.f476e.put("F09", a.f135v);
        Map A = a.m72A();
        if (A != null && A.size() > 0) {
            for (Entry entry : A.entrySet()) {
                arVar.f476e.put("C04_" + ((String) entry.getKey()), entry.getValue());
            }
        }
        switch (i) {
            case 1:
                arVar.f472a = (byte) 1;
                break;
            case 2:
                arVar.f472a = (byte) 2;
                break;
            default:
                C0073w.m525e("unknown up type %d ", Integer.valueOf(i));
                return null;
        }
        return arVar;
    }

    /* renamed from: a */
    public static byte[] m278a(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        if (i == 1) {
            try {
                ag afVar = new af();
            } catch (Throwable th) {
                if (!C0073w.m520a(th)) {
                    th.printStackTrace();
                }
                C0073w.m524d("encrytype %d %s", Integer.valueOf(i), str);
                return null;
            }
        }
        afVar = i == 3 ? new ae() : null;
        if (afVar == null) {
            return null;
        }
        afVar.mo14a(str);
        return afVar.mo15a(bArr);
    }

    /* renamed from: d */
    public static String m291d(Context context) {
        String str = "fail";
        if (context == null) {
            return str;
        }
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (str == null) {
                return "null";
            }
            return str.toLowerCase();
        } catch (Throwable th) {
            Throwable th2 = th;
            String str2 = str;
            Throwable th3 = th2;
            if (C0073w.m520a(th3)) {
                return str2;
            }
            th3.printStackTrace();
            return str2;
        }
    }

    /* renamed from: a */
    public static byte[] m275a(File file, String str) {
        FileInputStream fileInputStream;
        ByteArrayInputStream byteArrayInputStream;
        OutputStream byteArrayOutputStream;
        ZipOutputStream zipOutputStream;
        byte[] bArr;
        int read;
        Throwable th;
        Throwable th2;
        byte[] bArr2 = null;
        C0073w.m523c("rqdp{  ZF start}", new Object[0]);
        String str2 = "buglyCacheLog.txt";
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        str2 = file.getName();
                        fileInputStream = fileInputStream2;
                        byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                        try {
                            zipOutputStream.setMethod(8);
                            zipOutputStream.putNextEntry(new ZipEntry(str2));
                            bArr = new byte[1024];
                            if (fileInputStream != null) {
                                while (true) {
                                    read = fileInputStream.read(bArr);
                                    if (read > 0) {
                                        zipOutputStream.write(bArr, 0, read);
                                    }
                                }
                                read = byteArrayInputStream.read(bArr);
                                if (read <= 0) {
                                    zipOutputStream.write(bArr, 0, read);
                                } else {
                                    zipOutputStream.closeEntry();
                                    zipOutputStream.flush();
                                    zipOutputStream.finish();
                                    bArr2 = byteArrayOutputStream.toByteArray();
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    zipOutputStream.close();
                                    C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                                    return bArr2;
                                }
                            }
                            while (true) {
                                read = byteArrayInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            zipOutputStream.closeEntry();
                            zipOutputStream.flush();
                            zipOutputStream.finish();
                            bArr2 = byteArrayOutputStream.toByteArray();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            zipOutputStream.close();
                            C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        fileInputStream = fileInputStream2;
                        zipOutputStream = bArr2;
                        th2 = th4;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (zipOutputStream != null) {
                            zipOutputStream.close();
                        }
                        C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                        throw th2;
                    }
                    return bArr2;
                }
            } catch (Throwable th42) {
                zipOutputStream = bArr2;
                fileInputStream = bArr2;
                th2 = th42;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                throw th2;
            }
        }
        fileInputStream = bArr2;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(str2));
            bArr = new byte[1024];
            if (fileInputStream != null) {
                while (true) {
                    read = fileInputStream.read(bArr);
                    if (read > 0) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                }
                read = byteArrayInputStream.read(bArr);
                if (read <= 0) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    zipOutputStream.flush();
                    zipOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    zipOutputStream.close();
                    C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                    return bArr2;
                }
            }
            while (true) {
                read = byteArrayInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.finish();
            bArr2 = byteArrayOutputStream.toByteArray();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            try {
                zipOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            C0073w.m523c("rqdp{  ZF end}", new Object[0]);
        } catch (Throwable th422) {
            zipOutputStream = bArr2;
            th2 = th422;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            C0073w.m523c("rqdp{  ZF end}", new Object[0]);
            throw th2;
        }
        return bArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: p */
    private static java.lang.String mo23p() {
        /*
        r6 = 2;
        r1 = 0;
        r0 = "/system/build.prop";
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0065, all -> 0x0093 }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x0065, all -> 0x0093 }
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00bc, all -> 0x00b7 }
        r0 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2.<init>(r3, r0);	 Catch:{ Throwable -> 0x00bc, all -> 0x00b7 }
    L_0x0010:
        r0 = r2.readLine();	 Catch:{ Throwable -> 0x00bf }
        if (r0 == 0) goto L_0x00c1;
    L_0x0016:
        r4 = "=";
        r5 = 2;
        r0 = r0.split(r4, r5);	 Catch:{ Throwable -> 0x00bf }
        r4 = r0.length;	 Catch:{ Throwable -> 0x00bf }
        if (r4 != r6) goto L_0x0010;
    L_0x0020:
        r4 = 0;
        r4 = r0[r4];	 Catch:{ Throwable -> 0x00bf }
        r5 = "ro.product.cpu.abilist";
        r4 = r4.equals(r5);	 Catch:{ Throwable -> 0x00bf }
        if (r4 == 0) goto L_0x0040;
    L_0x002b:
        r4 = 1;
        r0 = r0[r4];	 Catch:{ Throwable -> 0x00bf }
    L_0x002e:
        if (r0 == 0) goto L_0x0039;
    L_0x0030:
        r4 = ",";
        r0 = r0.split(r4);	 Catch:{ Throwable -> 0x00bf }
        r4 = 0;
        r0 = r0[r4];	 Catch:{ Throwable -> 0x00bf }
    L_0x0039:
        r2.close();	 Catch:{ IOException -> 0x004f }
    L_0x003c:
        r3.close();	 Catch:{ IOException -> 0x005a }
    L_0x003f:
        return r0;
    L_0x0040:
        r4 = 0;
        r4 = r0[r4];	 Catch:{ Throwable -> 0x00bf }
        r5 = "ro.product.cpu.abi";
        r4 = r4.equals(r5);	 Catch:{ Throwable -> 0x00bf }
        if (r4 == 0) goto L_0x0010;
    L_0x004b:
        r4 = 1;
        r0 = r0[r4];	 Catch:{ Throwable -> 0x00bf }
        goto L_0x002e;
    L_0x004f:
        r1 = move-exception;
        r2 = com.tencent.bugly.legu.proguard.C0073w.m520a(r1);
        if (r2 != 0) goto L_0x003c;
    L_0x0056:
        r1.printStackTrace();
        goto L_0x003c;
    L_0x005a:
        r1 = move-exception;
        r2 = com.tencent.bugly.legu.proguard.C0073w.m520a(r1);
        if (r2 != 0) goto L_0x003f;
    L_0x0061:
        r1.printStackTrace();
        goto L_0x003f;
    L_0x0065:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
    L_0x0068:
        r4 = com.tencent.bugly.legu.proguard.C0073w.m520a(r0);	 Catch:{ all -> 0x00ba }
        if (r4 != 0) goto L_0x0071;
    L_0x006e:
        r0.printStackTrace();	 Catch:{ all -> 0x00ba }
    L_0x0071:
        if (r2 == 0) goto L_0x0076;
    L_0x0073:
        r2.close();	 Catch:{ IOException -> 0x007d }
    L_0x0076:
        if (r3 == 0) goto L_0x007b;
    L_0x0078:
        r3.close();	 Catch:{ IOException -> 0x0088 }
    L_0x007b:
        r0 = r1;
        goto L_0x003f;
    L_0x007d:
        r0 = move-exception;
        r2 = com.tencent.bugly.legu.proguard.C0073w.m520a(r0);
        if (r2 != 0) goto L_0x0076;
    L_0x0084:
        r0.printStackTrace();
        goto L_0x0076;
    L_0x0088:
        r0 = move-exception;
        r2 = com.tencent.bugly.legu.proguard.C0073w.m520a(r0);
        if (r2 != 0) goto L_0x007b;
    L_0x008f:
        r0.printStackTrace();
        goto L_0x007b;
    L_0x0093:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
    L_0x0096:
        if (r2 == 0) goto L_0x009b;
    L_0x0098:
        r2.close();	 Catch:{ IOException -> 0x00a1 }
    L_0x009b:
        if (r3 == 0) goto L_0x00a0;
    L_0x009d:
        r3.close();	 Catch:{ IOException -> 0x00ac }
    L_0x00a0:
        throw r0;
    L_0x00a1:
        r1 = move-exception;
        r2 = com.tencent.bugly.legu.proguard.C0073w.m520a(r1);
        if (r2 != 0) goto L_0x009b;
    L_0x00a8:
        r1.printStackTrace();
        goto L_0x009b;
    L_0x00ac:
        r1 = move-exception;
        r2 = com.tencent.bugly.legu.proguard.C0073w.m520a(r1);
        if (r2 != 0) goto L_0x00a0;
    L_0x00b3:
        r1.printStackTrace();
        goto L_0x00a0;
    L_0x00b7:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0096;
    L_0x00ba:
        r0 = move-exception;
        goto L_0x0096;
    L_0x00bc:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0068;
    L_0x00bf:
        r0 = move-exception;
        goto L_0x0068;
    L_0x00c1:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.legu.proguard.a.p():java.lang.String");
    }

    /* renamed from: a */
    public static <T extends C0049j> T m254a(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            C0049j c0049j = (C0049j) cls.newInstance();
            C0057h c0057h = new C0057h(bArr);
            c0057h.m389a("utf-8");
            c0049j.mo16a(c0057h);
            return c0049j;
        } catch (Throwable th) {
            if (!C0073w.m522b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static am m250a(Context context, int i, byte[] bArr) {
        C0016a a = C0016a.m69a();
        StrategyBean c = C0019a.m114a().m121c();
        if (a == null || c == null) {
            C0073w.m525e("illigle access to create req pkg!", new Object[0]);
            return null;
        }
        try {
            am amVar = new am();
            synchronized (a) {
                amVar.f410a = 1;
                amVar.f411b = a.m87e();
                amVar.f412c = a.f116c;
                amVar.f413d = a.f122i;
                amVar.f414e = a.f123j;
                a.getClass();
                amVar.f415f = "2.1.9";
                amVar.f416g = i;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                amVar.f417h = bArr;
                amVar.f418i = a.f119f;
                amVar.f419j = a.f120g;
                amVar.f420k = new HashMap();
                amVar.f421l = a.m85d();
                amVar.f422m = c.f154l;
                amVar.f424o = a.m91g();
                amVar.f425p = C0048a.m293e(context);
                amVar.f426q = System.currentTimeMillis();
                amVar.f427r = a.m95j();
                amVar.f428s = a.m94i();
                amVar.f429t = a.m97l();
                amVar.f430u = a.m96k();
                amVar.f431v = a.m98m();
                amVar.f432w = amVar.f425p;
                a.getClass();
                amVar.f423n = "com.tencent.bugly";
            }
            amVar.f420k.put("F11", a.f138y);
            amVar.f420k.put("F12", a.f137x);
            return amVar;
        } catch (Throwable th) {
            if (!C0073w.m522b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m276a(byte[] bArr, int i) {
        if (bArr == null) {
            return bArr;
        }
        C0073w.m523c("rqdp{  zp:} %s rqdp{  len:} %s", Integer.valueOf(2), Integer.valueOf(bArr.length));
        try {
            ab a = aa.m310a(2);
            if (a == null) {
                return null;
            }
            return a.mo12a(bArr);
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: e */
    public static String m292e() {
        try {
            String p = C0048a.mo23p();
            if (p == null) {
                p = System.getProperty("os.arch");
            }
            return p;
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: f */
    public static long m294f() {
        long j = -1;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return j;
            }
            th.printStackTrace();
            return j;
        }
    }

    /* renamed from: b */
    public static byte[] m286b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        C0073w.m523c("rqdp{  unzp:} %s rqdp{  len:} %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
        try {
            ab a = aa.m310a(i);
            if (a == null) {
                return null;
            }
            return a.mo13b(bArr);
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: g */
    public static long m296g() {
        long j = -1;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return j;
            }
            th.printStackTrace();
            return j;
        }
    }

    /* renamed from: a */
    public static byte[] m273a(am amVar) {
        try {
            C0052d c0052d = new C0052d();
            c0052d.mo23p();
            c0052d.mo19a("utf-8");
            c0052d.m364b(1);
            c0052d.m365b("RqdServer");
            c0052d.m366c("sync");
            c0052d.mo20a("detail", amVar);
            return c0052d.mo22a();
        } catch (Throwable th) {
            if (!C0073w.m522b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private void m267a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            } else if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                m267a((ArrayList) arrayList, Array.get(obj, 0));
            } else {
                arrayList.add("Array");
                arrayList.add("?");
            }
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else if (obj instanceof List) {
            arrayList.add("java.util.List");
            List list = (List) obj;
            if (list.size() > 0) {
                m267a((ArrayList) arrayList, list.get(0));
            } else {
                arrayList.add("?");
            }
        } else if (obj instanceof Map) {
            arrayList.add("java.util.Map");
            Map map = (Map) obj;
            if (map.size() > 0) {
                Object next = map.keySet().iterator().next();
                Object obj2 = map.get(next);
                arrayList.add(next.getClass().getName());
                m267a((ArrayList) arrayList, obj2);
                return;
            }
            arrayList.add("?");
            arrayList.add("?");
        } else {
            arrayList.add(obj.getClass().getName());
        }
    }

    /* renamed from: h */
    public static long m297h() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader2;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    long parseLong = Long.parseLong(bufferedReader.readLine().split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                    try {
                        bufferedReader.close();
                    } catch (Throwable e) {
                        if (!C0073w.m520a(e)) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                        return parseLong;
                    } catch (Throwable e2) {
                        if (C0073w.m520a(e2)) {
                            return parseLong;
                        }
                        e2.printStackTrace();
                        return parseLong;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static an m251a(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                an anVar;
                C0052d c0052d = new C0052d();
                c0052d.mo23p();
                c0052d.mo19a("utf-8");
                c0052d.mo21a(bArr);
                Object b = c0052d.m359b("detail", new an());
                if (an.class.isInstance(b)) {
                    anVar = (an) an.class.cast(b);
                } else {
                    anVar = null;
                }
                if (z || anVar == null || anVar.f438c == null || anVar.f438c.length <= 0) {
                    return anVar;
                }
                C0073w.m523c("resp buf %d", Integer.valueOf(anVar.f438c.length));
                anVar.f438c = C0048a.m277a(anVar.f438c, 2, 1, StrategyBean.f140a);
                if (anVar.f438c != null) {
                    return anVar;
                }
                C0073w.m525e("resp sbuffer error!", new Object[0]);
                return null;
            } catch (Throwable th) {
                if (!C0073w.m522b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m277a(byte[] bArr, int i, int i2, String str) {
        try {
            return C0048a.m286b(C0048a.m278a(bArr, 1, str), 2);
        } catch (Throwable e) {
            if (!C0073w.m520a(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: o */
    public static long m304o() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            return simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime();
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* renamed from: a */
    public byte[] mo22a() {
        C0058i c0058i = new C0058i(0);
        c0058i.m401a(this.f360b);
        c0058i.m410a(this.f359a, 0);
        return C0059k.m419a(c0058i.m402a());
    }

    /* renamed from: i */
    public static long m298i() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader2;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
            try {
                bufferedReader.readLine();
                long parseLong = ((Long.parseLong(bufferedReader.readLine().split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + (Long.parseLong(bufferedReader.readLine().split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10)) + (Long.parseLong(bufferedReader.readLine().split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                try {
                    bufferedReader.close();
                } catch (Throwable e) {
                    if (!C0073w.m520a(e)) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return parseLong;
                } catch (Throwable e2) {
                    if (C0073w.m520a(e2)) {
                        return parseLong;
                    }
                    e2.printStackTrace();
                    return parseLong;
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public void mo21a(byte[] bArr) {
        this.f361c.m395a(bArr);
        this.f361c.m389a(this.f360b);
        Map hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f359a = this.f361c.m393a(hashMap, 0, false);
    }

    /* renamed from: a */
    public static byte[] m274a(C0049j c0049j) {
        try {
            C0058i c0058i = new C0058i();
            c0058i.m401a("utf-8");
            c0049j.mo17a(c0058i);
            return c0058i.m414b();
        } catch (Throwable th) {
            if (!C0073w.m522b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static String m281b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            byte[] digest = instance.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toHexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: j */
    public static long m299j() {
        if ((Environment.getExternalStorageState().equals("mounted") ? 1 : null) == null) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    /* renamed from: k */
    public static long m300k() {
        if ((Environment.getExternalStorageState().equals("mounted") ? 1 : null) == null) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    /* renamed from: a */
    public static boolean m269a(File file, File file2, int i) {
        Throwable th;
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream = null;
        C0073w.m523c("rqdp{  ZF start}", new Object[0]);
        if (file == null || file2 == null || file.equals(file2)) {
            C0073w.m524d("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        } else if (file.exists() && file.canRead()) {
            try {
                if (!(file2.getParentFile() == null || file2.getParentFile().exists())) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Throwable th2) {
                if (!C0073w.m520a(th2)) {
                    th2.printStackTrace();
                }
            }
            if (!file2.exists() || !file2.canRead()) {
                return false;
            }
            FileInputStream fileInputStream2;
            try {
                fileInputStream2 = new FileInputStream(file);
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                    try {
                        zipOutputStream.setMethod(8);
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        byte[] bArr = new byte[5000];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.flush();
                        zipOutputStream.closeEntry();
                        try {
                            fileInputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                        return true;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (zipOutputStream != null) {
                            zipOutputStream.close();
                        }
                        C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    zipOutputStream = null;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                    throw th2;
                }
            } catch (Throwable th5) {
                th2 = th5;
                zipOutputStream = null;
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                C0073w.m523c("rqdp{  ZF end}", new Object[0]);
                throw th2;
            }
        } else {
            C0073w.m524d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
    }

    /* renamed from: l */
    public static String m301l() {
        String str = "fail";
        try {
            str = Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (!C0073w.m520a(th)) {
                th.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: m */
    public static String m302m() {
        String str = "fail";
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return str;
            }
            th.printStackTrace();
            return str;
        }
    }

    /* renamed from: e */
    public static String m293e(Context context) {
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            String str2;
            if (activeNetworkInfo.getType() == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    int networkType = telephonyManager.getNetworkType();
                    switch (networkType) {
                        case 1:
                            return "GPRS";
                        case 2:
                            return "EDGE";
                        case 3:
                            return "UMTS";
                        case 4:
                            return "CDMA";
                        case 5:
                            return "EVDO_0";
                        case 6:
                            return "EVDO_A";
                        case 7:
                            return "1xRTT";
                        case 8:
                            return "HSDPA";
                        case 9:
                            return "HSUPA";
                        case 10:
                            return "HSPA";
                        case 11:
                            return "iDen";
                        case 12:
                            return "EVDO_B";
                        case 13:
                            return "LTE";
                        case 14:
                            return "eHRPD";
                        case 15:
                            return "HSPA+";
                        default:
                            str2 = "MOBILE(" + networkType + ")";
                            break;
                    }
                    return str2;
                }
            }
            str2 = str;
            return str2;
        } catch (Throwable e) {
            if (C0073w.m520a(e)) {
                return str;
            }
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: a */
    public static ArrayList<String> m263a(Context context, String[] strArr) {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        ArrayList<String> arrayList = new ArrayList();
        if (C0016a.m70a(context).m75D()) {
            arrayList = new ArrayList();
            arrayList.add(new String("unknown(low memory)"));
            return arrayList;
        }
        BufferedReader bufferedReader3;
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            bufferedReader3 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader3.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 != null) {
                        arrayList.add(readLine2);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            bufferedReader3.close();
            try {
                bufferedReader.close();
                return arrayList;
            } catch (IOException e2) {
                e2.printStackTrace();
                return arrayList;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader3 = null;
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m259a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        List a = C0048a.m263a(context, new String[]{"/system/bin/sh", "-c", "getprop " + str});
        if (a == null || a.size() <= 0) {
            return "fail";
        }
        return (String) a.get(0);
    }

    /* renamed from: f */
    public static boolean m295f(Context context) {
        Boolean valueOf;
        boolean z = Build.TAGS != null && Build.TAGS.contains("test-keys");
        boolean exists;
        try {
            exists = new File("/system/app/Superuser.apk").exists();
        } catch (Throwable th) {
            exists = false;
        }
        Boolean bool = null;
        ArrayList a = C0048a.m263a(context, new String[]{"/system/bin/sh", "-c", "type su"});
        if (a != null && a.size() > 0) {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                C0073w.m523c(str, new Object[0]);
                if (str.contains("not found")) {
                    valueOf = Boolean.valueOf(false);
                } else {
                    valueOf = bool;
                }
                bool = valueOf;
            }
            if (bool == null) {
                bool = Boolean.valueOf(true);
            }
        }
        valueOf = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        if (z || r4 || valueOf.booleanValue()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static byte[] m272a(long j) {
        try {
            return (j).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static long m287c(byte[] bArr) {
        long j = -1;
        if (bArr != null) {
            try {
                j = Long.parseLong(new String(bArr, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    /* renamed from: a */
    public static Object m255a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        Object obj2 = null;
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            obj2 = declaredMethod.invoke(null, objArr);
        } catch (Exception e) {
        }
        return obj2;
    }

    /* renamed from: a */
    public static void m266a(Parcel parcel, Map<String, PlugInBean> map) {
        int i = 0;
        if (map == null || map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Entry entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bundle.putString("pluginKey" + i2, (String) arrayList.get(i2));
        }
        while (i < arrayList.size()) {
            bundle.putString("pluginVal" + i + "plugInId", ((PlugInBean) arrayList2.get(i)).f85a);
            bundle.putString("pluginVal" + i + "plugInUUID", ((PlugInBean) arrayList2.get(i)).f87c);
            bundle.putString("pluginVal" + i + "plugInVersion", ((PlugInBean) arrayList2.get(i)).f86b);
            i++;
        }
        parcel.writeBundle(bundle);
    }

    /* renamed from: a */
    public static Map<String, PlugInBean> m265a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        if (readBundle == null) {
            return null;
        }
        int i;
        HashMap hashMap;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (i = 0; i < intValue; i++) {
            arrayList.add(readBundle.getString("pluginKey" + i));
        }
        for (i = 0; i < intValue; i++) {
            arrayList2.add(new PlugInBean(readBundle.getString("pluginVal" + i + "plugInId"), readBundle.getString("pluginVal" + i + "plugInVersion"), readBundle.getString("pluginVal" + i + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            HashMap hashMap2 = new HashMap(arrayList.size());
            for (i = 0; i < arrayList.size(); i++) {
                hashMap2.put(arrayList.get(i), PlugInBean.class.cast(arrayList2.get(i)));
            }
            hashMap = hashMap2;
        } else {
            C0073w.m525e("map plugin parcel error!", new Object[0]);
            Map map = null;
        }
        return hashMap;
    }

    /* renamed from: b */
    public static void m283b(Parcel parcel, Map<String, String> map) {
        if (map == null || map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Entry entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    /* renamed from: b */
    public static Map<String, String> m282b(Parcel parcel) {
        int i = 0;
        Bundle readBundle = parcel.readBundle();
        if (readBundle == null) {
            return null;
        }
        HashMap hashMap;
        List stringArrayList = readBundle.getStringArrayList("keys");
        List stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            C0073w.m525e("map parcel error!", new Object[0]);
            Map map = null;
        } else {
            HashMap hashMap2 = new HashMap(stringArrayList.size());
            while (i < stringArrayList.size()) {
                hashMap2.put(stringArrayList.get(i), stringArrayList2.get(i));
                i++;
            }
            hashMap = hashMap2;
        }
        return hashMap;
    }

    /* renamed from: a */
    public static <T> T m256a(byte[] bArr, Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            T createFromParcel = creator.createFromParcel(obtain);
            if (obtain == null) {
                return createFromParcel;
            }
            obtain.recycle();
            return createFromParcel;
        } catch (Throwable th) {
            if (obtain != null) {
                obtain.recycle();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m258a(Context context, int i, String str) {
        String stringBuilder;
        Throwable th;
        if (AppInfo.m63a(context, "android.permission.READ_LOGS")) {
            String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
            Process process = null;
            StringBuilder stringBuilder2 = new StringBuilder();
            try {
                Process exec = Runtime.getRuntime().exec(strArr);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder2.append(readLine).append("\n");
                        if (i > 0 && stringBuilder2.length() > i) {
                            stringBuilder2.delete(0, stringBuilder2.length() - i);
                        }
                    }
                    stringBuilder = stringBuilder2.toString();
                    if (exec == null) {
                        return stringBuilder;
                    }
                    try {
                        exec.getOutputStream().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        exec.getInputStream().close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        exec.getErrorStream().close();
                        return stringBuilder;
                    } catch (IOException e22) {
                        e22.printStackTrace();
                        return stringBuilder;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    process = exec;
                    if (process != null) {
                        process.getOutputStream().close();
                        process.getInputStream().close();
                        process.getErrorStream().close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (C0073w.m520a(th)) {
                    th.printStackTrace();
                }
                stringBuilder = stringBuilder2.append("\n[error:" + th.toString() + "]").toString();
                if (process != null) {
                    return stringBuilder;
                }
                process.getOutputStream().close();
                process.getInputStream().close();
                process.getErrorStream().close();
                return stringBuilder;
            }
        }
        C0073w.m524d("no read_log permission!", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static Map<String, String> m264a(int i, boolean z) {
        Map<String, String> hashMap = new HashMap(12);
        Map allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread.currentThread().getId();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : allStackTraces.entrySet()) {
            stringBuilder.setLength(0);
            if (!(entry.getValue() == null || ((StackTraceElement[]) entry.getValue()).length == 0)) {
                for (StackTraceElement stackTraceElement : (StackTraceElement[]) entry.getValue()) {
                    if (i > 0 && stringBuilder.length() >= i) {
                        stringBuilder.append("\n[Stack over limit size :" + i + " , has been cutted !]");
                        break;
                    }
                    stringBuilder.append(stackTraceElement.toString()).append("\n");
                }
                hashMap.put(((Thread) entry.getKey()).getName() + "(" + ((Thread) entry.getKey()).getId() + ")", stringBuilder.toString());
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static synchronized byte[] m270a(int i) {
        byte[] bArr;
        DataInputStream dataInputStream;
        Throwable e;
        Exception e2;
        KeyGenerator instance;
        synchronized (C0048a.class) {
            try {
                bArr = new byte[16];
                dataInputStream = new DataInputStream(new FileInputStream(new File("/dev/urandom")));
                try {
                    dataInputStream.readFully(bArr);
                    try {
                        dataInputStream.close();
                    } catch (Throwable e3) {
                        if (!C0073w.m522b(e3)) {
                            e3.printStackTrace();
                        }
                        bArr = null;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    try {
                        C0073w.m525e("Failed to read from /dev/urandom : %s", e2);
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        instance = KeyGenerator.getInstance("AES");
                        instance.init(128, new SecureRandom());
                        bArr = instance.generateKey().getEncoded();
                        return bArr;
                    } catch (Throwable th) {
                        e3 = th;
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw e3;
                    }
                }
            } catch (Exception e5) {
                e2 = e5;
                dataInputStream = null;
                C0073w.m525e("Failed to read from /dev/urandom : %s", e2);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                instance = KeyGenerator.getInstance("AES");
                instance.init(128, new SecureRandom());
                bArr = instance.generateKey().getEncoded();
                return bArr;
            } catch (Throwable th2) {
                e3 = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw e3;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m271a(int i, byte[] bArr, byte[] bArr2) {
        try {
            Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(i, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            if (!C0073w.m522b(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m285b(int i, byte[] bArr, byte[] bArr2) {
        try {
            Key generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            if (!C0073w.m522b(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m268a(Context context, String str, long j) {
        C0073w.m523c("[Util] try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                C0073w.m523c("[Util] lock file(%s) is expired, unlock it", str);
                C0048a.m284b(context, str);
            }
            if (!file.createNewFile()) {
                return false;
            }
            C0073w.m523c("[Util] successfully locked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            C0073w.m520a(th);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m284b(Context context, String str) {
        C0073w.m523c("[Util] try to unlock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            C0073w.m523c("[Util] successfully unlocked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            C0073w.m520a(th);
            return false;
        }
    }
}
