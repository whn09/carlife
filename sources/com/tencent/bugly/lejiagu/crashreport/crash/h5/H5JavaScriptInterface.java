package com.tencent.bugly.lejiagu.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.tencent.bugly.lejiagu.crashreport.inner.InnerAPI;
import com.tencent.bugly.lejiagu.proguard.C0124a;
import com.tencent.bugly.lejiagu.proguard.C0148u;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BUGLY */
public class H5JavaScriptInterface {
    /* renamed from: a */
    private static HashMap<H5JavaScriptInterface, Integer> f923a = new HashMap();
    /* renamed from: b */
    private String f924b = null;
    /* renamed from: c */
    private Thread f925c = null;
    /* renamed from: d */
    private String f926d = null;
    /* renamed from: e */
    private Map<String, String> f927e = null;

    private H5JavaScriptInterface() {
    }

    public static H5JavaScriptInterface getInstance(WebView webView) {
        String str = null;
        if (webView == null || f923a.values().contains(Integer.valueOf(webView.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f923a.put(h5JavaScriptInterface, Integer.valueOf(webView.hashCode()));
        h5JavaScriptInterface.f925c = Thread.currentThread();
        Thread thread = h5JavaScriptInterface.f925c;
        if (thread != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            for (int i = 2; i < thread.getStackTrace().length; i++) {
                StackTraceElement stackTraceElement = thread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    stringBuilder.append(stackTraceElement.toString()).append("\n");
                }
            }
            str = stringBuilder.toString();
        }
        h5JavaScriptInterface.f926d = str;
        Map hashMap = new HashMap();
        hashMap.put("[WebView] ContentDescription", webView.getContentDescription());
        h5JavaScriptInterface.f927e = hashMap;
        return h5JavaScriptInterface;
    }

    /* renamed from: a */
    private static C0118a m737a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C0118a c0118a = new C0118a();
            c0118a.f928a = jSONObject.getString("projectRoot");
            if (c0118a.f928a == null) {
                return null;
            }
            c0118a.f929b = jSONObject.getString("context");
            if (c0118a.f929b == null) {
                return null;
            }
            c0118a.f930c = jSONObject.getString("url");
            if (c0118a.f930c == null) {
                return null;
            }
            c0118a.f931d = jSONObject.getString("userAgent");
            if (c0118a.f931d == null) {
                return null;
            }
            c0118a.f932e = jSONObject.getString("language");
            if (c0118a.f932e == null) {
                return null;
            }
            c0118a.f933f = jSONObject.getString("name");
            if (c0118a.f933f == null || c0118a.f933f.equals("null")) {
                return null;
            }
            String string = jSONObject.getString("stacktrace");
            if (string == null) {
                return null;
            }
            int indexOf = string.indexOf("\n");
            if (indexOf < 0) {
                C0148u.m1040d("H5 crash stack's format is wrong!", new Object[0]);
                return null;
            }
            c0118a.f935h = string.substring(indexOf + 1);
            c0118a.f934g = string.substring(0, indexOf);
            int indexOf2 = c0118a.f934g.indexOf(":");
            if (indexOf2 > 0) {
                c0118a.f934g = c0118a.f934g.substring(indexOf2 + 1);
            }
            c0118a.f936i = jSONObject.getString("file");
            if (c0118a.f933f == null) {
                return null;
            }
            c0118a.f937j = jSONObject.getLong("lineNumber");
            if (c0118a.f937j < 0) {
                return null;
            }
            c0118a.f938k = jSONObject.getLong("columnNumber");
            if (c0118a.f938k < 0) {
                return null;
            }
            C0148u.m1035a("H5 crash information is following: ", new Object[0]);
            C0148u.m1035a("[projectRoot]: " + c0118a.f928a, new Object[0]);
            C0148u.m1035a("[context]: " + c0118a.f929b, new Object[0]);
            C0148u.m1035a("[url]: " + c0118a.f930c, new Object[0]);
            C0148u.m1035a("[userAgent]: " + c0118a.f931d, new Object[0]);
            C0148u.m1035a("[language]: " + c0118a.f932e, new Object[0]);
            C0148u.m1035a("[name]: " + c0118a.f933f, new Object[0]);
            C0148u.m1035a("[message]: " + c0118a.f934g, new Object[0]);
            C0148u.m1035a("[stacktrace]: \n" + c0118a.f935h, new Object[0]);
            C0148u.m1035a("[file]: " + c0118a.f936i, new Object[0]);
            C0148u.m1035a("[lineNumber]: " + c0118a.f937j, new Object[0]);
            C0148u.m1035a("[columnNumber]: " + c0118a.f938k, new Object[0]);
            return c0118a;
        } catch (Throwable th) {
            if (C0148u.m1036a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    @JavascriptInterface
    public void printLog(String str) {
        C0148u.m1040d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C0148u.m1040d("Payload from JS is null.", new Object[0]);
            return;
        }
        String b = C0124a.m815b(str.getBytes());
        if (this.f924b == null || !this.f924b.equals(b)) {
            this.f924b = b;
            C0148u.m1040d("Handling JS exception ...", new Object[0]);
            C0118a a = m737a(str);
            if (a == null) {
                C0148u.m1040d("Failed to parse payload.", new Object[0]);
                return;
            }
            Map linkedHashMap = new LinkedHashMap();
            Map linkedHashMap2 = new LinkedHashMap();
            if (a.f928a != null) {
                linkedHashMap2.put("[JS] projectRoot", a.f928a);
            }
            if (a.f929b != null) {
                linkedHashMap2.put("[JS] context", a.f929b);
            }
            if (a.f930c != null) {
                linkedHashMap2.put("[JS] url", a.f930c);
            }
            if (a.f931d != null) {
                linkedHashMap2.put("[JS] userAgent", a.f931d);
            }
            if (a.f936i != null) {
                linkedHashMap2.put("[JS] file", a.f936i);
            }
            if (a.f937j != 0) {
                linkedHashMap2.put("[JS] lineNumber", Long.toString(a.f937j));
            }
            linkedHashMap.putAll(linkedHashMap2);
            linkedHashMap.putAll(this.f927e);
            linkedHashMap.put("Java Stack", this.f926d);
            Thread thread = this.f925c;
            if (a != null) {
                InnerAPI.postH5CrashAsync(thread, a.f933f, a.f934g, a.f935h, linkedHashMap);
                return;
            }
            return;
        }
        C0148u.m1040d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
    }
}
