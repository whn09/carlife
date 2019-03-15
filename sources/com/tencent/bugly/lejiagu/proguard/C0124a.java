package com.tencent.bugly.lejiagu.proguard;

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
import com.tencent.bugly.lejiagu.crashreport.biz.UserInfoBean;
import com.tencent.bugly.lejiagu.crashreport.common.info.AppInfo;
import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import com.tencent.bugly.lejiagu.crashreport.common.info.PlugInBean;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.C0095a;
import com.tencent.bugly.lejiagu.crashreport.common.strategy.StrategyBean;
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
/* renamed from: com.tencent.bugly.lejiagu.proguard.a */
public class C0124a {
    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f966a = new HashMap();
    /* renamed from: b */
    protected String f967b;
    /* renamed from: c */
    C0134h f968c;
    /* renamed from: d */
    private HashMap<String, Object> f969d;

    C0124a() {
        HashMap hashMap = new HashMap();
        this.f969d = new HashMap();
        this.f967b = "GBK";
        this.f968c = new C0134h();
    }

    /* renamed from: b */
    public static String m813b() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: a */
    public static ao m786a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        ao aoVar = new ao();
        aoVar.f1069a = userInfoBean.f654e;
        aoVar.f1073e = userInfoBean.f659j;
        aoVar.f1072d = userInfoBean.f652c;
        aoVar.f1071c = userInfoBean.f653d;
        aoVar.f1075g = C0092a.m597a().m620h();
        aoVar.f1076h = userInfoBean.f664o == 1;
        switch (userInfoBean.f651b) {
            case 1:
                aoVar.f1070b = (byte) 1;
                break;
            case 2:
                aoVar.f1070b = (byte) 4;
                break;
            case 3:
                aoVar.f1070b = (byte) 2;
                break;
            case 4:
                aoVar.f1070b = (byte) 3;
                break;
            default:
                if (userInfoBean.f651b >= 10 && userInfoBean.f651b < 20) {
                    aoVar.f1070b = (byte) userInfoBean.f651b;
                    break;
                }
                C0148u.m1041e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f651b));
                return null;
                break;
        }
        aoVar.f1074f = new HashMap();
        if (userInfoBean.f665p >= 0) {
            aoVar.f1074f.put("C01", userInfoBean.f665p);
        }
        if (userInfoBean.f666q >= 0) {
            aoVar.f1074f.put("C02", userInfoBean.f666q);
        }
        if (userInfoBean.f667r != null && userInfoBean.f667r.size() > 0) {
            for (Entry entry : userInfoBean.f667r.entrySet()) {
                aoVar.f1074f.put("C03_" + ((String) entry.getKey()), entry.getValue());
            }
        }
        if (userInfoBean.f668s != null && userInfoBean.f668s.size() > 0) {
            for (Entry entry2 : userInfoBean.f668s.entrySet()) {
                aoVar.f1074f.put("C04_" + ((String) entry2.getKey()), entry2.getValue());
            }
        }
        aoVar.f1074f.put("A36", (!userInfoBean.f661l));
        aoVar.f1074f.put("F02", userInfoBean.f656g);
        aoVar.f1074f.put("F03", userInfoBean.f657h);
        aoVar.f1074f.put("F04", userInfoBean.f659j);
        aoVar.f1074f.put("F05", userInfoBean.f658i);
        aoVar.f1074f.put("F06", userInfoBean.f662m);
        aoVar.f1074f.put("F10", userInfoBean.f660k);
        C0148u.m1039c("summary type %d vm:%d", Byte.valueOf(aoVar.f1070b), Integer.valueOf(aoVar.f1074f.size()));
        return aoVar;
    }

    /* renamed from: a */
    public void mo42a(String str) {
        this.f967b = str;
    }

    /* renamed from: c */
    public static String m822c() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: d */
    public static int m824d() {
        try {
            return VERSION.SDK_INT;
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* renamed from: a */
    public static String m794a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (!C0148u.m1036a(th2)) {
                th2.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: a */
    public static String m791a(Context context) {
        if (!AppInfo.m591a(context, "android.permission.READ_PHONE_STATE")) {
            C0148u.m1040d("no READ_PHONE_STATE permission to get IMEI", new Object[0]);
            return "null";
        } else if (context == null) {
            return null;
        } else {
            String deviceId;
            try {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId == null) {
                    return deviceId;
                }
                try {
                    return deviceId.toLowerCase();
                } catch (Throwable th) {
                    Log.i(C0148u.f1187b, "failed to get IMEI");
                    return deviceId;
                }
            } catch (Throwable th2) {
                deviceId = null;
                Log.i(C0148u.f1187b, "failed to get IMEI");
                return deviceId;
            }
        }
    }

    /* renamed from: n */
    public static String m837n() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
        } catch (Exception e) {
            return new Date().toString();
        }
    }

    /* renamed from: a */
    public static String m795a(ArrayList<String> arrayList) {
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
    public <T> void mo43a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            C0135i c0135i = new C0135i();
            c0135i.m934a(this.f967b);
            c0135i.m940a((Object) t, 0);
            Object a = C0136k.m952a(c0135i.m935a());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            m801a(arrayList, (Object) t);
            hashMap.put(C0124a.m795a(arrayList), a);
            this.f969d.remove(str);
            this.f966a.put(str, hashMap);
        }
    }

    /* renamed from: a */
    public static String m796a(Date date) {
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
    public static String m814b(Context context) {
        String subscriberId;
        if (!AppInfo.m591a(context, "android.permission.READ_PHONE_STATE")) {
            C0148u.m1040d("no READ_PHONE_STATE permission to get IMSI", new Object[0]);
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
                    Log.i(C0148u.f1187b, "failed to get IMSI");
                    return subscriberId;
                }
            } catch (Throwable th2) {
                subscriberId = null;
                Log.i(C0148u.f1187b, "failed to get IMSI");
                return subscriberId;
            }
        }
    }

    /* renamed from: c */
    public static String m823c(Context context) {
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
                if (!C0148u.m1036a(th)) {
                    return str;
                }
                Log.i(C0148u.f1187b, "failed to get Android ID");
                return str;
            }
        } catch (Throwable th4) {
            th = th4;
            if (!C0148u.m1036a(th)) {
                return str;
            }
            Log.i(C0148u.f1187b, "failed to get Android ID");
            return str;
        }
    }

    /* renamed from: a */
    public static ap m787a(List<UserInfoBean> list, int i) {
        if (list == null || list.size() == 0) {
            return null;
        }
        C0092a a = C0092a.m597a();
        ap apVar = new ap();
        apVar.f1080b = a.f724d;
        apVar.f1081c = a.m618g();
        ArrayList arrayList = new ArrayList();
        for (UserInfoBean a2 : list) {
            ao a3 = C0124a.m786a(a2);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        apVar.f1082d = arrayList;
        apVar.f1083e = new HashMap();
        apVar.f1083e.put("A7", a.f725e);
        apVar.f1083e.put("A6", a.m630r());
        apVar.f1083e.put("A5", a.m629q());
        apVar.f1083e.put("A2", a.m627o());
        apVar.f1083e.put("A1", a.m627o());
        apVar.f1083e.put("A24", a.f727g);
        apVar.f1083e.put("A17", a.m628p());
        apVar.f1083e.put("A15", a.m632t());
        apVar.f1083e.put("A13", a.m633u());
        apVar.f1083e.put("F08", a.f741u);
        apVar.f1083e.put("F09", a.f742v);
        Map z = a.m638z();
        if (z != null && z.size() > 0) {
            for (Entry entry : z.entrySet()) {
                apVar.f1083e.put("C04_" + ((String) entry.getKey()), entry.getValue());
            }
        }
        switch (i) {
            case 1:
                apVar.f1079a = (byte) 1;
                break;
            case 2:
                apVar.f1079a = (byte) 2;
                break;
            default:
                C0148u.m1041e("unknown up type %d ", Integer.valueOf(i));
                return null;
        }
        return apVar;
    }

    /* renamed from: a */
    public static byte[] m812a(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        if (i == 1) {
            try {
                ae adVar = new ad();
            } catch (Throwable th) {
                if (!C0148u.m1036a(th)) {
                    th.printStackTrace();
                }
                C0148u.m1040d("encrytype %d %s", Integer.valueOf(i), str);
                return null;
            }
        }
        adVar = i == 3 ? new ac() : null;
        if (adVar == null) {
            return null;
        }
        adVar.mo37a(str);
        return adVar.mo38a(bArr);
    }

    /* renamed from: d */
    public static String m825d(Context context) {
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
            if (C0148u.m1036a(th3)) {
                return str2;
            }
            th3.printStackTrace();
            return str2;
        }
    }

    /* renamed from: a */
    public static byte[] m809a(File file, String str) {
        FileInputStream fileInputStream;
        ByteArrayInputStream byteArrayInputStream;
        OutputStream byteArrayOutputStream;
        ZipOutputStream zipOutputStream;
        byte[] bArr;
        int read;
        Throwable th;
        Throwable th2;
        byte[] bArr2 = null;
        C0148u.m1039c("rqdp{  ZF start}", new Object[0]);
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
                                    C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
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
                            C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
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
                        C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
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
                C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
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
                    C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
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
            C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
        } catch (Throwable th422) {
            zipOutputStream = bArr2;
            th2 = th422;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
            throw th2;
        }
        return bArr2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: p */
    private static java.lang.String mo46p() {
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
        r2 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r1);
        if (r2 != 0) goto L_0x003c;
    L_0x0056:
        r1.printStackTrace();
        goto L_0x003c;
    L_0x005a:
        r1 = move-exception;
        r2 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r1);
        if (r2 != 0) goto L_0x003f;
    L_0x0061:
        r1.printStackTrace();
        goto L_0x003f;
    L_0x0065:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
    L_0x0068:
        r4 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r0);	 Catch:{ all -> 0x00ba }
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
        r2 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r0);
        if (r2 != 0) goto L_0x0076;
    L_0x0084:
        r0.printStackTrace();
        goto L_0x0076;
    L_0x0088:
        r0 = move-exception;
        r2 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r0);
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
        r2 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r1);
        if (r2 != 0) goto L_0x009b;
    L_0x00a8:
        r1.printStackTrace();
        goto L_0x009b;
    L_0x00ac:
        r1 = move-exception;
        r2 = com.tencent.bugly.lejiagu.proguard.C0148u.m1036a(r1);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.lejiagu.proguard.a.p():java.lang.String");
    }

    /* renamed from: a */
    public static <T extends C0126j> T m788a(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            C0126j c0126j = (C0126j) cls.newInstance();
            C0134h c0134h = new C0134h(bArr);
            c0134h.m922a("utf-8");
            c0126j.mo39a(c0134h);
            return c0126j;
        } catch (Throwable th) {
            if (!C0148u.m1038b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static ak m784a(Context context, int i, byte[] bArr) {
        C0092a a = C0092a.m597a();
        StrategyBean c = C0095a.m641a().m648c();
        if (a == null || c == null) {
            C0148u.m1041e("illigle access to create req pkg!", new Object[0]);
            return null;
        }
        try {
            ak akVar = new ak();
            synchronized (a) {
                akVar.f1017a = 1;
                akVar.f1018b = a.m614e();
                akVar.f1019c = a.f723c;
                akVar.f1020d = a.f729i;
                akVar.f1021e = a.f730j;
                a.getClass();
                akVar.f1022f = "2.1.6";
                akVar.f1023g = i;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                akVar.f1024h = bArr;
                akVar.f1025i = a.f726f;
                akVar.f1026j = a.f727g;
                akVar.f1027k = new HashMap();
                akVar.f1028l = a.m612d();
                akVar.f1029m = c.f761l;
                akVar.f1031o = a.m618g();
                akVar.f1032p = C0124a.m827e(context);
                akVar.f1033q = System.currentTimeMillis();
                akVar.f1034r = a.m622j();
                akVar.f1035s = a.m621i();
                akVar.f1036t = a.m624l();
                akVar.f1037u = a.m623k();
                akVar.f1038v = a.m625m();
                akVar.f1039w = akVar.f1032p;
                a.getClass();
                akVar.f1030n = "com.tencent.bugly";
            }
            return akVar;
        } catch (Throwable th) {
            if (!C0148u.m1038b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m810a(byte[] bArr, int i) {
        if (bArr == null) {
            return bArr;
        }
        C0148u.m1039c("rqdp{  zp:} %s rqdp{  len:} %s", Integer.valueOf(2), Integer.valueOf(bArr.length));
        try {
            C0125z a = C0154y.m1062a(2);
            if (a == null) {
                return null;
            }
            return a.mo35a(bArr);
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: e */
    public static String m826e() {
        try {
            String p = C0124a.mo46p();
            if (p == null) {
                p = System.getProperty("os.arch");
            }
            return p;
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: f */
    public static long m828f() {
        long j = -1;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return j;
            }
            th.printStackTrace();
            return j;
        }
    }

    /* renamed from: b */
    public static byte[] m820b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        C0148u.m1039c("rqdp{  unzp:} %s rqdp{  len:} %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
        try {
            C0125z a = C0154y.m1062a(i);
            if (a == null) {
                return null;
            }
            return a.mo36b(bArr);
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: g */
    public static long m830g() {
        long j = -1;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return j;
            }
            th.printStackTrace();
            return j;
        }
    }

    /* renamed from: a */
    private void m801a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            } else if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                m801a((ArrayList) arrayList, Array.get(obj, 0));
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
                m801a((ArrayList) arrayList, list.get(0));
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
                m801a((ArrayList) arrayList, obj2);
                return;
            }
            arrayList.add("?");
            arrayList.add("?");
        } else {
            arrayList.add(obj.getClass().getName());
        }
    }

    /* renamed from: a */
    public static byte[] m807a(ak akVar) {
        try {
            C0129d c0129d = new C0129d();
            c0129d.mo46p();
            c0129d.mo42a("utf-8");
            c0129d.m897b(1);
            c0129d.m898b("RqdServer");
            c0129d.m899c("sync");
            c0129d.mo43a("detail", akVar);
            return c0129d.mo45a();
        } catch (Throwable th) {
            if (!C0148u.m1038b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: h */
    public static long m831h() {
        Throwable th;
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        try {
            fileReader2 = new FileReader("/proc/meminfo");
            try {
                bufferedReader2 = new BufferedReader(fileReader2, 2048);
                try {
                    long parseLong = Long.parseLong(bufferedReader2.readLine().split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                    try {
                        bufferedReader2.close();
                    } catch (Throwable e) {
                        if (!C0148u.m1036a(e)) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        fileReader2.close();
                        return parseLong;
                    } catch (Throwable e2) {
                        if (C0148u.m1036a(e2)) {
                            return parseLong;
                        }
                        e2.printStackTrace();
                        return parseLong;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (fileReader2 != null) {
                        fileReader2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = null;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (fileReader2 != null) {
                    fileReader2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = null;
            fileReader2 = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (fileReader2 != null) {
                fileReader2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static byte[] m811a(byte[] bArr, int i, int i2, String str) {
        try {
            return C0124a.m820b(C0124a.m812a(bArr, 1, str), 2);
        } catch (Throwable e) {
            if (!C0148u.m1036a(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static al m785a(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                al alVar;
                C0129d c0129d = new C0129d();
                c0129d.mo46p();
                c0129d.mo42a("utf-8");
                c0129d.mo44a(bArr);
                Object b = c0129d.m892b("detail", new al());
                if (al.class.isInstance(b)) {
                    alVar = (al) al.class.cast(b);
                } else {
                    alVar = null;
                }
                if (z || alVar == null || alVar.f1045c == null || alVar.f1045c.length <= 0) {
                    return alVar;
                }
                C0148u.m1039c("resp buf %d", Integer.valueOf(alVar.f1045c.length));
                alVar.f1045c = C0124a.m811a(alVar.f1045c, 2, 1, StrategyBean.f747a);
                if (alVar.f1045c != null) {
                    return alVar;
                }
                C0148u.m1041e("resp sbuffer error!", new Object[0]);
                return null;
            } catch (Throwable th) {
                if (!C0148u.m1038b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: o */
    public static long m838o() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            return simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime();
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* renamed from: a */
    public byte[] mo45a() {
        C0135i c0135i = new C0135i(0);
        c0135i.m934a(this.f967b);
        c0135i.m943a(this.f966a, 0);
        return C0136k.m952a(c0135i.m935a());
    }

    /* renamed from: i */
    public static long m832i() {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        BufferedReader bufferedReader2 = null;
        FileReader fileReader2;
        try {
            fileReader2 = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader2 != null) {
                    fileReader2.close();
                }
                throw th;
            }
            try {
                bufferedReader.readLine();
                long parseLong = ((Long.parseLong(bufferedReader.readLine().split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + (Long.parseLong(bufferedReader.readLine().split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10)) + (Long.parseLong(bufferedReader.readLine().split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                try {
                    bufferedReader.close();
                } catch (Throwable e) {
                    if (!C0148u.m1036a(e)) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileReader2.close();
                    return parseLong;
                } catch (Throwable e2) {
                    if (C0148u.m1036a(e2)) {
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
                if (fileReader2 != null) {
                    fileReader2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader2 = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader2 != null) {
                fileReader2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public void mo44a(byte[] bArr) {
        this.f968c.m928a(bArr);
        this.f968c.m922a(this.f967b);
        Map hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f966a = this.f968c.m926a(hashMap, 0, false);
    }

    /* renamed from: a */
    public static byte[] m808a(C0126j c0126j) {
        try {
            C0135i c0135i = new C0135i();
            c0135i.m934a("utf-8");
            c0126j.mo40a(c0135i);
            return c0135i.m947b();
        } catch (Throwable th) {
            if (!C0148u.m1038b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static String m815b(byte[] bArr) {
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
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: j */
    public static long m833j() {
        if ((Environment.getExternalStorageState().equals("mounted") ? 1 : null) == null) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    /* renamed from: k */
    public static long m834k() {
        if ((Environment.getExternalStorageState().equals("mounted") ? 1 : null) == null) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    /* renamed from: a */
    public static boolean m803a(File file, File file2, int i) {
        Throwable th;
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream2 = null;
        C0148u.m1039c("rqdp{  ZF start}", new Object[0]);
        if (file == null || file2 == null || file.equals(file2)) {
            C0148u.m1040d("rqdp{  err ZF 1R!}", new Object[0]);
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
                if (!C0148u.m1036a(th2)) {
                    th2.printStackTrace();
                }
            }
            if (!file2.exists() || !file2.canRead()) {
                return false;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                    try {
                        zipOutputStream.setMethod(8);
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        byte[] bArr = new byte[5000];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.flush();
                        zipOutputStream.closeEntry();
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
                        return true;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (zipOutputStream != null) {
                            zipOutputStream.close();
                        }
                        C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    zipOutputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
                    throw th2;
                }
            } catch (Throwable th5) {
                th2 = th5;
                zipOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                C0148u.m1039c("rqdp{  ZF end}", new Object[0]);
                throw th2;
            }
        } else {
            C0148u.m1040d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
    }

    /* renamed from: l */
    public static String m835l() {
        String str = "fail";
        try {
            str = Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (!C0148u.m1036a(th)) {
                th.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: m */
    public static String m836m() {
        String str = "fail";
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return str;
            }
            th.printStackTrace();
            return str;
        }
    }

    /* renamed from: e */
    public static String m827e(Context context) {
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
            if (C0148u.m1036a(e)) {
                return str;
            }
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: a */
    public static ArrayList<String> m797a(Context context, String[] strArr) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        ArrayList<String> arrayList = new ArrayList();
        if (C0092a.m598a(context).m602C()) {
            arrayList = new ArrayList();
            arrayList.add(new String("unknown(low memory)"));
            return arrayList;
        }
        BufferedReader bufferedReader3;
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            bufferedReader3 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while (true) {
                try {
                    String readLine2 = bufferedReader3.readLine();
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
            bufferedReader.close();
            try {
                bufferedReader3.close();
                return arrayList;
            } catch (IOException e2) {
                e2.printStackTrace();
                return arrayList;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m793a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        List a = C0124a.m797a(context, new String[]{"/system/bin/sh", "-c", "getprop " + str});
        if (a == null || a.size() <= 0) {
            return "fail";
        }
        return (String) a.get(0);
    }

    /* renamed from: f */
    public static boolean m829f(Context context) {
        Boolean valueOf;
        boolean z = Build.TAGS != null && Build.TAGS.contains("test-keys");
        boolean exists;
        try {
            exists = new File("/system/app/Superuser.apk").exists();
        } catch (Throwable th) {
            exists = false;
        }
        Boolean bool = null;
        ArrayList a = C0124a.m797a(context, new String[]{"/system/bin/sh", "-c", "type su"});
        if (a != null && a.size() > 0) {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                C0148u.m1039c(str, new Object[0]);
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
    public static byte[] m806a(long j) {
        try {
            return (j).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static long m821c(byte[] bArr) {
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
    public static Object m789a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
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
    public static void m800a(Parcel parcel, Map<String, PlugInBean> map) {
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
            bundle.putString("pluginVal" + i + "plugInId", ((PlugInBean) arrayList2.get(i)).f692a);
            bundle.putString("pluginVal" + i + "plugInUUID", ((PlugInBean) arrayList2.get(i)).f694c);
            bundle.putString("pluginVal" + i + "plugInVersion", ((PlugInBean) arrayList2.get(i)).f693b);
            i++;
        }
        parcel.writeBundle(bundle);
    }

    /* renamed from: a */
    public static Map<String, PlugInBean> m799a(Parcel parcel) {
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
            C0148u.m1041e("map plugin parcel error!", new Object[0]);
            Map map = null;
        }
        return hashMap;
    }

    /* renamed from: b */
    public static void m817b(Parcel parcel, Map<String, String> map) {
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
    public static Map<String, String> m816b(Parcel parcel) {
        int i = 0;
        Bundle readBundle = parcel.readBundle();
        if (readBundle == null) {
            return null;
        }
        HashMap hashMap;
        List stringArrayList = readBundle.getStringArrayList("keys");
        List stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            C0148u.m1041e("map parcel error!", new Object[0]);
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
    public static <T> T m790a(byte[] bArr, Creator<T> creator) {
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
    public static String m792a(Context context, int i, String str) {
        String stringBuilder;
        Throwable th;
        if (AppInfo.m591a(context, "android.permission.READ_LOGS")) {
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
                if (C0148u.m1036a(th)) {
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
        C0148u.m1040d("no read_log permission!", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public static Map<String, String> m798a(int i, boolean z) {
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
    public static synchronized byte[] m804a(int i) {
        byte[] bArr;
        DataInputStream dataInputStream;
        Throwable e;
        Exception e2;
        KeyGenerator instance;
        synchronized (C0124a.class) {
            try {
                bArr = new byte[16];
                dataInputStream = new DataInputStream(new FileInputStream(new File("/dev/urandom")));
                try {
                    dataInputStream.readFully(bArr);
                    try {
                        dataInputStream.close();
                    } catch (Throwable e3) {
                        if (!C0148u.m1038b(e3)) {
                            e3.printStackTrace();
                        }
                        bArr = null;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    try {
                        C0148u.m1041e("Failed to read from /dev/urandom : %s", e2);
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
                C0148u.m1041e("Failed to read from /dev/urandom : %s", e2);
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
    public static byte[] m805a(int i, byte[] bArr, byte[] bArr2) {
        try {
            Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(i, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            if (!C0148u.m1038b(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m819b(int i, byte[] bArr, byte[] bArr2) {
        try {
            Key generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            if (!C0148u.m1038b(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m802a(Context context, String str, long j) {
        C0148u.m1039c("[Util] try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                C0148u.m1039c("[Util] lock file(%s) is expired, unlock it", str);
                C0124a.m818b(context, str);
            }
            if (!file.createNewFile()) {
                return false;
            }
            C0148u.m1039c("[Util] successfully locked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            C0148u.m1036a(th);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m818b(Context context, String str) {
        C0148u.m1039c("[Util] try to unlock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            C0148u.m1039c("[Util] successfully unlocked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            C0148u.m1036a(th);
            return false;
        }
    }
}
