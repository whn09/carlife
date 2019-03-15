package com.tencent.bugly.lejiagu.proguard;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: BUGLY */
public final class ad implements ae {
    /* renamed from: a */
    private String f971a = null;

    /* renamed from: a */
    public final byte[] mo38a(byte[] bArr) throws Exception {
        if (this.f971a == null || bArr == null) {
            return null;
        }
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f971a.getBytes("UTF-8"))), new IvParameterSpec(this.f971a.getBytes("UTF-8")));
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    public final void mo37a(String str) {
        if (str != null) {
            this.f971a = str;
        }
    }
}
