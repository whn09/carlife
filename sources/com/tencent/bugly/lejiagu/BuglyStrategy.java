package com.tencent.bugly.lejiagu;

import com.tencent.bugly.lejiagu.crashreport.common.info.C0092a;
import java.util.Map;

/* compiled from: BUGLY */
public class BuglyStrategy {
    /* renamed from: a */
    private String f621a;
    /* renamed from: b */
    private String f622b;
    /* renamed from: c */
    private String f623c;
    /* renamed from: d */
    private long f624d;
    /* renamed from: e */
    private String f625e;
    /* renamed from: f */
    private String f626f;
    /* renamed from: g */
    private boolean f627g = true;
    /* renamed from: h */
    private boolean f628h = true;
    /* renamed from: i */
    private boolean f629i = true;
    /* renamed from: j */
    private boolean f630j = true;
    /* renamed from: k */
    private boolean f631k = false;
    /* renamed from: l */
    private C0079a f632l;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.lejiagu.BuglyStrategy$a */
    public static class C0079a {
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
        this.f630j = z;
    }

    public synchronized void setRecordUserInfoOnceADay(boolean z) {
        this.f631k = z;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f630j;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f631k;
    }

    public synchronized String getAppVersion() {
        return this.f621a == null ? C0092a.m597a().f729i : this.f621a;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f621a = str;
        return this;
    }

    public synchronized String getAppChannel() {
        return this.f622b == null ? C0092a.m597a().f730j : this.f622b;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f622b = str;
        return this;
    }

    public synchronized String getAppPackageName() {
        return this.f623c == null ? C0092a.m597a().f723c : this.f623c;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f623c = str;
        return this;
    }

    public synchronized long getAppReportDelay() {
        return this.f624d;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j) {
        this.f624d = j;
        return this;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f625e;
    }

    public synchronized void setLibBuglySOFilePath(String str) {
        this.f625e = str;
    }

    public synchronized String getDeviceID() {
        return this.f626f;
    }

    public synchronized void setDeviceID(String str) {
        this.f626f = str;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f627g;
    }

    public synchronized void setEnableNativeCrashMonitor(boolean z) {
        this.f627g = z;
    }

    public void setEnableUserInfo(boolean z) {
        this.f629i = z;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f629i;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f628h;
    }

    public synchronized void setEnableANRCrashMonitor(boolean z) {
        this.f628h = z;
    }

    public synchronized C0079a getCrashHandleCallback() {
        return this.f632l;
    }

    public synchronized void setCrashHandleCallback(C0079a c0079a) {
        this.f632l = c0079a;
    }
}
