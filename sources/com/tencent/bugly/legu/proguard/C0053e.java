package com.tencent.bugly.legu.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.legu.proguard.e */
public final class C0053e {
    /* renamed from: a */
    private static final char[] f483a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m368a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[(i * 2) + 1] = f483a[b & 15];
            cArr[i * 2] = f483a[((byte) (b >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
