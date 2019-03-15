package com.tencent.StubShell;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.bugly.legu.crashreport.CrashReport;
import com.tencent.bugly.legu.crashreport.CrashReport.UserStrategy;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

public class TxAppEntry extends Application {
    /* renamed from: a */
    public static String f0a = "";
    /* renamed from: b */
    public static String f1b = "";
    /* renamed from: c */
    static int f2c = 0;
    /* renamed from: d */
    private static Context f3d = null;
    /* renamed from: e */
    private static String f4e = null;
    /* renamed from: f */
    private static String f5f = null;
    /* renamed from: g */
    private static String f6g = "";
    private static String mOldAPPName = null;
    private static String mPKName = null;
    private static String mSocPath = null;
    private static String mSrcPath = null;
    private static String mVerFilePath = null;
    private static boolean mbVerCheck = false;
    private static final String version = "2825ef16f90a16de3c827e8f6fb4b40921d38c2ed21db5716d21fc5134d39d96";
    /* renamed from: h */
    private Handler f7h = null;

    /* renamed from: a */
    public static void m1a(Intent intent) {
        reciver(intent);
    }

    /* renamed from: a */
    private void m2a(String str) {
        String str2;
        ApplicationInfo applicationInfo = getApplicationInfo();
        String str3 = applicationInfo.dataDir + "/tx_shell";
        f1b = applicationInfo.sourceDir;
        int i = VERSION.SDK_INT;
        Object obj = null;
        if (i >= 19) {
            if (i > 19) {
                String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
                if (strArr != null && strArr.length > 1) {
                    obj = 1;
                }
            } else if (new File("/system/lib64").exists()) {
                obj = 1;
            }
        }
        String str4 = null;
        if (VERSION.SDK_INT < 21) {
            str4 = Build.CPU_ABI;
        }
        if ((str4 == null || str4.length() < 2) && VERSION.SDK_INT >= 21) {
            str4 = Build.SUPPORTED_ABIS[0];
        }
        Object obj2 = 1;
        if (str4.toLowerCase(Locale.US).contains("x86")) {
            obj2 = null;
        } else if (VERSION.SDK_INT >= 21) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            if (strArr2 != null) {
                for (String str22 : strArr2) {
                    if (str22.toLowerCase(Locale.US).contains("x86")) {
                        obj2 = null;
                    }
                }
            }
        }
        Object obj3 = null;
        if (str4.toLowerCase(Locale.US).contains("mips")) {
            obj3 = 1;
        }
        String str5 = VERSION.SDK_INT > 8 ? applicationInfo.nativeLibraryDir : "/data/data/" + mPKName + "/lib";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        str8 = "";
        if (obj2 != null) {
            str22 = str + m7d();
        } else {
            str22 = str + m7d();
            str8 = str + m7d();
        }
        str6 = str6 + "lib" + str22 + ".so";
        str8 = str7 + "lib" + str8 + ".so";
        File file = new File(str5 + "/" + str6);
        File file2 = new File(str3 + "/" + str8);
        if (obj2 == null && VERSION.SDK_INT < 19) {
            if (!file2.exists()) {
                if (ZipUtil.exist(f1b, "lib/armeabi/" + str8) == 0) {
                    if (ZipUtil.extract(f1b, "lib/armeabi/" + str8, str3 + "/" + str8) == 0) {
                    }
                } else if (ZipUtil.extract(f1b, "lib/armeabi-v7a/" + str8, str3 + "/" + str8) == 0) {
                }
            }
            try {
                Runtime.getRuntime().exec("chmod 700 " + str3 + "/" + str8);
                System.load(str3 + "/" + str8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.exists()) {
            System.loadLibrary(str22);
        } else {
            String str9;
            str5 = "";
            str8 = str3 + "/" + str6;
            if (ZipUtil.exist(f1b, "lib/" + str4 + "/" + str6) == 0) {
                str9 = "lib/" + str4 + "/" + str6;
            } else {
                if (obj != null) {
                    if (obj2 != null) {
                        if (ZipUtil.exist(f1b, "lib/arm64-v8a/" + str6) == 0) {
                            str9 = "lib/arm64-v8a/" + str6;
                        } else if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                            str9 = "lib/armeabi/" + str6;
                        } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                            str9 = "lib/armeabi-v7a/" + str6;
                        }
                    } else if (ZipUtil.exist(f1b, "lib/x86_64/" + str6) == 0) {
                        str9 = "lib/x86_64/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/arm64-v8a/" + str6) == 0) {
                        str9 = "lib/arm64-v8a/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/x86/" + str6) == 0) {
                        str9 = "lib/x86/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                        str9 = "lib/armeabi/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                        str9 = "lib/armeabi-v7a/" + str6;
                    }
                } else if (obj2 != null) {
                    Object obj4;
                    if (obj3 == null || ZipUtil.exist(f1b, "lib/mips/" + str6) != 0) {
                        obj4 = null;
                        str9 = str5;
                    } else {
                        obj4 = 1;
                        str9 = "lib/mips/" + str6;
                    }
                    if (obj4 == null) {
                        if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                            str9 = "lib/armeabi/" + str6;
                        } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                            str9 = "lib/armeabi-v7a/" + str6;
                        }
                    }
                } else if (ZipUtil.exist(f1b, "lib/x86/" + str6) == 0) {
                    str9 = "lib/x86/" + str6;
                } else if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                    str9 = "lib/armeabi/" + str6;
                } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                    str9 = "lib/armeabi-v7a/" + str6;
                }
                str9 = str5;
            }
            if (ZipUtil.extract(f1b, str9, str8) == 0) {
                try {
                    Runtime.getRuntime().exec("chmod 700 " + str8);
                    System.load(str8);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m4b(Context context) {
        if (context == null) {
            return false;
        }
        f3d = context;
        mPKName = getBaseContext().getPackageName();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(mPKName, 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            return false;
        }
        mOldAPPName = applicationInfo.metaData.getString("TxAppEntry");
        mSrcPath = f3d.getApplicationInfo().sourceDir;
        try {
            f6g = f3d.getPackageManager().getPackageInfo(mPKName, 0).versionName;
        } catch (Exception e2) {
        }
        mVerFilePath = "/data/data/";
        mVerFilePath += mPKName;
        mVerFilePath += "/tx_shell/";
        f0a = mVerFilePath;
        File file = new File(mVerFilePath);
        if (!file.exists()) {
            file.mkdir();
        }
        f4e = mVerFilePath + "libshella.so";
        f5f = mVerFilePath + "libshellb.so";
        mSocPath = mVerFilePath + "libshellc.so";
        mVerFilePath += m11g();
        return true;
    }

    /* renamed from: c */
    private String m5c() {
        return "2.8";
    }

    /* renamed from: c */
    private void m6c(Context context) {
        String str = f6g;
        String str2 = "user_bugly_appid";
        if (!str2.equals("user_bugly_appid")) {
            UserStrategy userStrategy = new UserStrategy(context);
            userStrategy.setAppVersion(str);
            userStrategy.setEnableUserInfo(false);
            userStrategy.setRecordUserInfoOnceADay(true);
            CrashReport.setSdkExtraData(context, str2, str);
            CrashReport.initCrashReport(context, str2, false, userStrategy);
        }
    }

    private static native void changeEnv(Context context);

    /* renamed from: d */
    private String m7d() {
        return "";
    }

    /* renamed from: d */
    private void m8d(Context context) {
        AssetManager assets = context.getAssets();
        String str = context.getApplicationInfo().sourceDir;
        try {
            System.loadLibrary("nfix");
            fixNativeResource(assets, str);
        } catch (Throwable th) {
        }
        try {
            System.loadLibrary("ufix");
            fixUnityResource(assets, str);
        } catch (Throwable th2) {
        }
    }

    /* renamed from: e */
    private void m9e() {
        String str;
        ApplicationInfo applicationInfo = getApplicationInfo();
        String str2 = applicationInfo.dataDir + "/tx_shell";
        f1b = applicationInfo.sourceDir;
        int i = VERSION.SDK_INT;
        Object obj = null;
        if (i >= 19) {
            if (i > 19) {
                String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
                if (strArr != null && strArr.length > 1) {
                    obj = 1;
                }
            } else if (new File("/system/lib64").exists()) {
                obj = 1;
            }
        }
        String str3 = null;
        if (VERSION.SDK_INT < 21) {
            str3 = Build.CPU_ABI;
        }
        if ((str3 == null || str3.length() < 2) && VERSION.SDK_INT >= 21) {
            str3 = Build.SUPPORTED_ABIS[0];
        }
        Object obj2 = 1;
        if (str3.toLowerCase(Locale.US).contains("x86")) {
            obj2 = null;
        } else if (VERSION.SDK_INT >= 21) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            if (strArr2 != null) {
                for (String str4 : strArr2) {
                    if (str4.toLowerCase(Locale.US).contains("x86")) {
                        obj2 = null;
                    }
                }
            }
        }
        Object obj3 = null;
        if (str3.toLowerCase(Locale.US).contains("mips")) {
            obj3 = 1;
        }
        String str5 = VERSION.SDK_INT > 8 ? applicationInfo.nativeLibraryDir : "/data/data/" + mPKName + "/lib";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        str8 = "";
        if (obj2 != null) {
            str4 = m10f() + "-" + m5c();
        } else {
            str4 = "shellx-" + m5c();
            str8 = m10f() + "-" + m5c();
        }
        str6 = str6 + "lib" + str4 + ".so";
        str8 = str7 + "lib" + str8 + ".so";
        File file = new File(str5 + "/" + str6);
        File file2 = new File(str2 + "/" + str8);
        if (obj2 == null && VERSION.SDK_INT < 19) {
            if (!file2.exists()) {
                if (ZipUtil.exist(f1b, "lib/armeabi/" + str8) == 0) {
                    if (ZipUtil.extract(f1b, "lib/armeabi/" + str8, str2 + "/" + str8) == 0) {
                    }
                } else if (ZipUtil.extract(f1b, "lib/armeabi-v7a/" + str8, str2 + "/" + str8) == 0) {
                }
            }
            try {
                Runtime.getRuntime().exec("chmod 700 " + str2 + "/" + str8);
                System.load(str2 + "/" + str8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.exists()) {
            System.loadLibrary(str4);
        } else {
            str5 = "";
            str4 = str2 + "/" + str6;
            if (ZipUtil.exist(f1b, "lib/" + str3 + "/" + str6) == 0) {
                str5 = "lib/" + str3 + "/" + str6;
            } else if (obj != null) {
                if (obj2 == null) {
                    if (VERSION.SDK_INT >= 21) {
                        String[] strArr3 = Build.SUPPORTED_ABIS;
                        r0 = "";
                        if (strArr3 != null) {
                            int i2 = 0;
                            while (i2 < strArr3.length) {
                                if (ZipUtil.exist(f1b, "lib/" + strArr3[i2].toLowerCase(Locale.US) + "/" + str8) == 0 || ZipUtil.exist(f1b, "lib/" + strArr3[i2].toLowerCase(Locale.US) + "/" + str6) == 0) {
                                    str3 = strArr3[i2].toLowerCase(Locale.US);
                                    obj = 1;
                                    if (ZipUtil.exist(f1b, "lib/x86_64/" + str6) == 0) {
                                        str3 = "lib/x86_64/" + str6;
                                    } else {
                                        if (str3.compareTo("arm64-v8a") == 0) {
                                            if (ZipUtil.exist(f1b, "lib/arm64-v8a/" + str6) == 0) {
                                                str3 = "lib/arm64-v8a/" + str6;
                                            }
                                        } else if (str3.compareTo("x86") == 0) {
                                            if (ZipUtil.exist(f1b, "lib/x86/" + str6) == 0) {
                                                str3 = "lib/x86/" + str6;
                                            }
                                        } else if (str3.compareTo("armeabi-v7a") == 0 || str3.compareTo("armeabi") == 0) {
                                            if (ZipUtil.exist(f1b, "lib/x86/" + str6) == 0) {
                                                str3 = "lib/x86/" + str6;
                                            } else if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                                                str3 = "lib/armeabi/" + str6;
                                            } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                                                str3 = "lib/armeabi-v7a/" + str6;
                                            }
                                        }
                                        str3 = str5;
                                    }
                                    if (VERSION.SDK_INT < 21 || r0 == null) {
                                        if (ZipUtil.exist(f1b, "lib/x86_64/" + str6) == 0) {
                                            str3 = "lib/x86_64/" + str6;
                                        } else if (ZipUtil.exist(f1b, "lib/arm64-v8a/" + str6) == 0) {
                                            str3 = "lib/arm64-v8a/" + str6;
                                        } else if (ZipUtil.exist(f1b, "lib/x86/" + str6) == 0) {
                                            str3 = "lib/x86/" + str6;
                                        } else if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                                            str3 = "lib/armeabi/" + str6;
                                        } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                                            str3 = "lib/armeabi-v7a/" + str6;
                                        }
                                    }
                                    str5 = str3;
                                } else {
                                    i2++;
                                }
                            }
                        }
                    }
                    obj = null;
                    str3 = str5;
                    if (ZipUtil.exist(f1b, "lib/x86_64/" + str6) == 0) {
                        str3 = "lib/x86_64/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/arm64-v8a/" + str6) == 0) {
                        str3 = "lib/arm64-v8a/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/x86/" + str6) == 0) {
                        str3 = "lib/x86/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                        str3 = "lib/armeabi/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                        str3 = "lib/armeabi-v7a/" + str6;
                    }
                    str5 = str3;
                } else if (ZipUtil.exist(f1b, "lib/arm64-v8a/" + str6) == 0) {
                    str5 = "lib/arm64-v8a/" + str6;
                } else if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                    str5 = "lib/armeabi/" + str6;
                } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                    str5 = "lib/armeabi-v7a/" + str6;
                }
            } else if (obj2 != null) {
                Object obj4;
                if (obj3 == null || ZipUtil.exist(f1b, "lib/mips/" + str6) != 0) {
                    obj4 = null;
                    r0 = str5;
                } else {
                    obj4 = 1;
                    r0 = "lib/mips/" + str6;
                }
                if (obj4 == null) {
                    if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                        r0 = "lib/armeabi/" + str6;
                    } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                        r0 = "lib/armeabi-v7a/" + str6;
                    }
                }
                str5 = r0;
            } else if (ZipUtil.exist(f1b, "lib/x86/" + str6) == 0) {
                str5 = "lib/x86/" + str6;
            } else if (ZipUtil.exist(f1b, "lib/armeabi/" + str6) == 0) {
                str5 = "lib/armeabi/" + str6;
            } else if (ZipUtil.exist(f1b, "lib/armeabi-v7a/" + str6) == 0) {
                str5 = "lib/armeabi-v7a/" + str6;
            }
            if (ZipUtil.extract(f1b, str5, str4) == 0) {
                try {
                    Runtime.getRuntime().exec("chmod 700 " + str4);
                    System.load(str4);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: f */
    private static String m10f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sh");
        stringBuilder.append("el");
        stringBuilder.append("la");
        return stringBuilder.toString();
    }

    private static native void fixNativeResource(AssetManager assetManager, String str);

    private static native void fixUnityResource(AssetManager assetManager, String str);

    /* renamed from: g */
    private static String m11g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sh");
        stringBuilder.append("el");
        stringBuilder.append("la");
        stringBuilder.append("_ve");
        stringBuilder.append("rs");
        stringBuilder.append("i");
        stringBuilder.append("on");
        return stringBuilder.toString();
    }

    private static native void load(Context context);

    private static native void reciver(Intent intent);

    private static native void runCreate(Context context);

    public static native Enumeration txEntries(DexFile dexFile);

    /* renamed from: a */
    public void m12a(Context context) {
        m9e();
        load(f3d);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (m4b(this)) {
            m8d(context);
            this.f7h = new Handler(getMainLooper());
            String str = "2.8";
            String str2 = "900015015";
            UserStrategy userStrategy = new UserStrategy(this);
            userStrategy.setAppVersion(str);
            CrashReport.setSdkExtraData(this, str2, str);
            CrashReport.initCrashReport(this, str2, false, userStrategy);
            new Thread(new C0001b(this)).start();
            m12a((Context) this);
        }
    }

    public String getPackageName() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        stackTrace[0].getClassName();
        stackTrace[0].getMethodName();
        String className = stackTrace[1].getClassName();
        String methodName = stackTrace[1].getMethodName();
        if (className.compareTo("android.app.ActivityThread") == 0 && methodName.compareTo("installProvider") == 0) {
            f2c++;
            if (f2c == 1) {
                return "";
            }
            if (f2c == 2) {
                changeEnv(this);
            }
        }
        return mPKName;
    }

    public void onCreate() {
        runCreate(this);
        m6c(f3d);
    }
}
