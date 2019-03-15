package com.tencent.bugly.legu.proguard;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
public final class ae implements ag {
    /* renamed from: a */
    private String f363a = null;

    /* renamed from: a */
    public final byte[] mo15a(byte[] bArr) throws Exception {
        int i = 0;
        if (this.f363a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(b + " ");
        }
        Key secretKeySpec = new SecretKeySpec(this.f363a.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(this.f363a.getBytes()));
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
    public final void mo14a(String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            this.f363a = str.substring(0, 16);
        }
    }
}
