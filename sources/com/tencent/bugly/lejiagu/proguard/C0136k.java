package com.tencent.bugly.lejiagu.proguard;

import java.nio.ByteBuffer;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.lejiagu.proguard.k */
public final class C0136k {
    /* renamed from: a */
    public static boolean m951a(boolean z, boolean z2) {
        return z == z2;
    }

    /* renamed from: a */
    public static boolean m948a(int i, int i2) {
        return i == i2;
    }

    /* renamed from: a */
    public static boolean m949a(long j, long j2) {
        return j == j2;
    }

    /* renamed from: a */
    public static boolean m950a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static byte[] m952a(ByteBuffer byteBuffer) {
        Object obj = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, obj, 0, obj.length);
        return obj;
    }

    static {
        byte[] bArr = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
    }
}