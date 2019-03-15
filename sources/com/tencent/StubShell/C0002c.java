package com.tencent.StubShell;

import com.tencent.bugly.legu.crashreport.CrashReport;

/* renamed from: com.tencent.StubShell.c */
class C0002c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ TxAppEntry f10a;

    C0002c(TxAppEntry txAppEntry) {
        this.f10a = txAppEntry;
    }

    public void run() {
        CrashReport.postCatchedException(new SystemInfoException(TxAppEntry.mSrcPath, TxAppEntry.f6g));
    }
}
