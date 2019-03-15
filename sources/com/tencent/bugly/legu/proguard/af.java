package com.tencent.bugly.legu.proguard;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: BUGLY */
public final class af implements ag {
    /* renamed from: a */
    private String f364a = null;

    /* renamed from: a */
    public final byte[] mo15a(byte[] bArr) throws Exception {
        if (this.f364a == null || bArr == null) {
            return null;
        }
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f364a.getBytes("UTF-8"))), new IvParameterSpec(this.f364a.getBytes("UTF-8")));
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    public final void mo14a(String str) {
        if (str != null) {
            this.f364a = str;
        }
    }
}
