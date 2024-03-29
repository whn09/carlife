package com.tencent.bugly.lejiagu.proguard;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
public final class ac implements ae {
    /* renamed from: a */
    private String f970a = null;

    /* renamed from: a */
    public final byte[] mo38a(byte[] bArr) throws Exception {
        int i = 0;
        if (this.f970a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(b + " ");
        }
        Key secretKeySpec = new SecretKeySpec(this.f970a.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(this.f970a.getBytes()));
        byte[] doFinal = instance.doFinal(bArr);
        stringBuffer = new StringBuffer();
        int length = doFinal.length;
        while (i < length) {
            stringBuffer.append(doFinal[i] + " ");
            i++;
        }
        return doFinal;
    }

    /* renamed from: a */
    public final void mo37a(String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            this.f970a = str.substring(0, 16);
        }
    }
}
