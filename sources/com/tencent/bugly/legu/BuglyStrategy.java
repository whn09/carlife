package com.tencent.bugly.legu;

import com.tencent.bugly.legu.crashreport.common.info.C0016a;
import java.util.Map;

/* compiled from: BUGLY */
public class BuglyStrategy {
    /* renamed from: a */
    private String f14a;
    /* renamed from: b */
    private String f15b;
    /* renamed from: c */
    private String f16c;
    /* renamed from: d */
    private long f17d;
    /* renamed from: e */
    private String f18e;
    /* renamed from: f */
    private String f19f;
    /* renamed from: g */
    private boolean f20g = true;
    /* renamed from: h */
    private boolean f21h = true;
    /* renamed from: i */
    private boolean f22i = true;
    /* renamed from: j */
    private Class<?> f23j = null;
    /* renamed from: k */
    private boolean f24k = true;
    /* renamed from: l */
    private boolean f25l = true;
    /* renamed from: m */
    private boolean f26m = false;
    /* renamed from: n */
    private C0003a f27n;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.legu.BuglyStrategy$a */
    public static class C0003a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized void setBuglyLogUpload(boolean z) {
        this.f24k = z;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.f26m = z;
        return this;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f24k;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f26m;
    }

    public boolean isReplaceOldChannel() {
        return this.f25l;
    }

    public void setReplaceOldChannel(boolean z) {
        this.f25l = z;
    }

    public synchronized String getAppVersion() {
        return this.f14a == null ? C0016a.m69a().f122i : this.f14a;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f14a = str;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f23j = cls;
        return this;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f23j;
    }

    public synchronized String getAppChannel() {
        return this.f15b == null ? C0016a.m69a().f123j : this.f15b;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f15b = str;
        return this;
    }

    public synchronized String getAppPackageName() {
        return this.f16c == null ? C0016a.m69a().f116c : this.f16c;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f16c = str;
        return this;
    }

    public synchronized long getAppReportDelay() {
        return this.f17d;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j) {
        this.f17d = j;
        return this;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f18e;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f18e = str;
        return this;
    }

    public synchronized String getDeviceID() {
        return this.f19f;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f19f = str;
        return this;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f20g;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f20g = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f22i = z;
        return this;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f22i;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f21h;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f21h = z;
        return this;
    }

    public synchronized C0003a getCrashHandleCallback() {
        return this.f27n;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(C0003a c0003a) {
        this.f27n = c0003a;
        return this;
    }
}
