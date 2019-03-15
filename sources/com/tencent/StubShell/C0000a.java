package com.tencent.StubShell;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/* renamed from: com.tencent.StubShell.a */
public class C0000a {
    /* renamed from: a */
    private static final char[] f8a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m13a(InputStream inputStream) {
        String str = "";
        byte[] bArr = new byte[8192];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            str = C0000a.m15a(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: a */
    public static String m14a(String str) {
        InputStream fileInputStream;
        String a;
        Exception e;
        String str2 = "";
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a = C0000a.m13a(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                a = str2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return a;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            e.printStackTrace();
            a = str2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return a;
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        return a;
    }

    /* renamed from: a */
    public static String m15a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(f8a[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(f8a[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }
}
