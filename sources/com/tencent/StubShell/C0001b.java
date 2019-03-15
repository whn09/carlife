package com.tencent.StubShell;

import com.tencent.bugly.legu.crashreport.CrashReport;

/* renamed from: com.tencent.StubShell.b */
class C0001b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ TxAppEntry f9a;

    C0001b(TxAppEntry txAppEntry) {
        this.f9a = txAppEntry;
    }

    public void run() {
        CrashReport.postCatchedException(new SystemInfoException(TxAppEntry.mSrcPath, TxAppEntry.f6g));
    }
}
