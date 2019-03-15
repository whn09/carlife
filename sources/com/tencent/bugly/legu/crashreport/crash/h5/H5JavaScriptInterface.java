package com.tencent.bugly.legu.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.tencent.bugly.legu.crashreport.inner.InnerAPI;
import com.tencent.bugly.legu.proguard.C0048a;
import com.tencent.bugly.legu.proguard.C0073w;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BUGLY */
public class H5JavaScriptInterface {
    /* renamed from: a */
    private static HashMap<H5JavaScriptInterface, Integer> f316a = new HashMap();
    /* renamed from: b */
    private String f317b = null;
    /* renamed from: c */
    private Thread f318c = null;
    /* renamed from: d */
    private String f319d = null;
    /* renamed from: e */
    private Map<String, String> f320e = null;

    private H5JavaScriptInterface() {
    }

    public static H5JavaScriptInterface getInstance(WebView webView) {
        String str = null;
        if (webView == null || f316a.values().contains(Integer.valueOf(webView.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f316a.put(h5JavaScriptInterface, Integer.valueOf(webView.hashCode()));
        h5JavaScriptInterface.f318c = Thread.currentThread();
        Thread thread = h5JavaScriptInterface.f318c;
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
        h5JavaScriptInterface.f319d = str;
        Map hashMap = new HashMap();
        hashMap.put("[WebView] ContentDescription", webView.getContentDescription());
        h5JavaScriptInterface.f320e = hashMap;
        return h5JavaScriptInterface;
    }

    /* renamed from: a */
    private static C0042a m209a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C0042a c0042a = new C0042a();
            c0042a.f321a = jSONObject.getString("projectRoot");
            if (c0042a.f321a == null) {
                return null;
            }
            c0042a.f322b = jSONObject.getString("context");
            if (c0042a.f322b == null) {
                return null;
            }
            c0042a.f323c = jSONObject.getString("url");
            if (c0042a.f323c == null) {
                return null;
            }
            c0042a.f324d = jSONObject.getString("userAgent");
            if (c0042a.f324d == null) {
                return null;
            }
            c0042a.f325e = jSONObject.getString("language");
            if (c0042a.f325e == null) {
                return null;
            }
            c0042a.f326f = jSONObject.getString("name");
            if (c0042a.f326f == null || c0042a.f326f.equals("null")) {
                return null;
            }
            String string = jSONObject.getString("stacktrace");
            if (string == null) {
                return null;
            }
            int indexOf = string.indexOf("\n");
            if (indexOf < 0) {
                C0073w.m524d("H5 crash stack's format is wrong!", new Object[0]);
                return null;
            }
            c0042a.f328h = string.substring(indexOf + 1);
            c0042a.f327g = string.substring(0, indexOf);
            int indexOf2 = c0042a.f327g.indexOf(":");
            if (indexOf2 > 0) {
                c0042a.f327g = c0042a.f327g.substring(indexOf2 + 1);
            }
            c0042a.f329i = jSONObject.getString("file");
            if (c0042a.f326f == null) {
                return null;
            }
            c0042a.f330j = jSONObject.getLong("lineNumber");
            if (c0042a.f330j < 0) {
                return null;
            }
            c0042a.f331k = jSONObject.getLong("columnNumber");
            if (c0042a.f331k < 0) {
                return null;
            }
            C0073w.m519a("H5 crash information is following: ", new Object[0]);
            C0073w.m519a("[projectRoot]: " + c0042a.f321a, new Object[0]);
            C0073w.m519a("[context]: " + c0042a.f322b, new Object[0]);
            C0073w.m519a("[url]: " + c0042a.f323c, new Object[0]);
            C0073w.m519a("[userAgent]: " + c0042a.f324d, new Object[0]);
            C0073w.m519a("[language]: " + c0042a.f325e, new Object[0]);
            C0073w.m519a("[name]: " + c0042a.f326f, new Object[0]);
            C0073w.m519a("[message]: " + c0042a.f327g, new Object[0]);
            C0073w.m519a("[stacktrace]: \n" + c0042a.f328h, new Object[0]);
            C0073w.m519a("[file]: " + c0042a.f329i, new Object[0]);
            C0073w.m519a("[lineNumber]: " + c0042a.f330j, new Object[0]);
            C0073w.m519a("[columnNumber]: " + c0042a.f331k, new Object[0]);
            return c0042a;
        } catch (Throwable th) {
            if (C0073w.m520a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    @JavascriptInterface
    public void printLog(String str) {
        C0073w.m524d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C0073w.m524d("Payload from JS is null.", new Object[0]);
            return;
        }
        String b = C0048a.m281b(str.getBytes());
        if (this.f317b == null || !this.f317b.equals(b)) {
            this.f317b = b;
            C0073w.m524d("Handling JS exception ...", new Object[0]);
            C0042a a = m209a(str);
            if (a == null) {
                C0073w.m524d("Failed to parse payload.", new Object[0]);
                return;
            }
            Map linkedHashMap = new LinkedHashMap();
            Map linkedHashMap2 = new LinkedHashMap();
            if (a.f321a != null) {
                linkedHashMap2.put("[JS] projectRoot", a.f321a);
            }
            if (a.f322b != null) {
                linkedHashMap2.put("[JS] context", a.f322b);
            }
            if (a.f323c != null) {
                linkedHashMap2.put("[JS] url", a.f323c);
            }
            if (a.f324d != null) {
                linkedHashMap2.put("[JS] userAgent", a.f324d);
            }
            if (a.f329i != null) {
                linkedHashMap2.put("[JS] file", a.f329i);
            }
            if (a.f330j != 0) {
                linkedHashMap2.put("[JS] lineNumber", Long.toString(a.f330j));
            }
            linkedHashMap.putAll(linkedHashMap2);
            linkedHashMap.putAll(this.f320e);
            linkedHashMap.put("Java Stack", this.f319d);
            Thread thread = this.f318c;
            if (a != null) {
                InnerAPI.postH5CrashAsync(thread, a.f326f, a.f327g, a.f328h, linkedHashMap);
                return;
            }
            return;
        }
        C0073w.m524d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
    }
}
