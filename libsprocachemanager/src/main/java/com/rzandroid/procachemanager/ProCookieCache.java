package com.rzandroid.procachemanager;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ProCookieCache {
    private CookieManager cookieManager;
    private String baseUrl = null;
    private HashMap<String, String> cookieDataMap = new HashMap<String, String>();
    private String cookieDataString = null;
    public Get get;

    public ProCookieCache(String argBaseUrl) {
        this.baseUrl = argBaseUrl;
        cookieDataMap = new HashMap<String, String>();
        cookieDataMap.clear();
        //
        intCookie();
        intParseCookie();
        //
        this.get = new Get();
        /*CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.acceptCookie();
        String srtCookie = cookieManager.getCookie(AppConstant.HTTP.API.WEB_VIEW_URL_BASE);
        //cookieManager.setAcceptThirdPartyCookies(sysWebViewPayment,true);
        cookieManager.setCookie(AppConstant.HTTP.API.WEB_VIEW_URL_BASE, "$cookieKey=$cookieValue");
        DebugLog.log(AppConstant.TAG_GLOBAL_DEBUG + "COOKIE_MANAGER: " + srtCookie);*/
    }

    private void intCookie() {
        cookieManager = CookieManager.getInstance();
        cookieManager.acceptCookie();
    }

    private void intParseCookie() {
        cookieDataString = cookieManager.getCookie(baseUrl);
        if (cookieDataString != null) {
            String[] cookieList = cookieDataString.trim().split(";");
            for (String cookieItem : cookieList) {
                //String[] item = cookieItem.trim().split("=");
                String[] item = cookieItem.split("=");
                if (item.length >= 2) {
                    cookieDataMap.put(item[0], item[1]);
                }
            }
        }
        //DebugLog.log(AppConstant.TAG_GLOBAL_DEBUG + "COOKIE_MANAGER: " + cookieDataMap.size() + " <> " + cookieDataMap.toString());
    }

    public ProCookieCache setCookie(String argKey, String argValue) {
        cookieDataMap.put(argKey, argValue);
        write();
        return this;
    }

    public ProCookieCache remove(String argKey) {
        if (cookieDataMap.containsKey(argKey)) {
            cookieDataMap.remove(argKey);
            write();
        }
        return this;
    }

    public void write() {
        //cookieManager.setCookie(AppConstant.HTTP.API.WEB_VIEW_URL_BASE, "$cookieKey=$cookieValue");
        cookieDataString = getAsCookieForm();
        cookieManager.setCookie(baseUrl, cookieDataString);
        cookieDataMap.clear();
        intCookie();
        intParseCookie();
    }

    public void fullFlush(Context argContext) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            //Log.d(C.TAG, "Using clearCookies code for API >=" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            /*CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();*/
            cookieManager.removeAllCookies(null);
            cookieManager.flush();
        } else {
            //Log.d(C.TAG, "Using clearCookies code for API <" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
            CookieSyncManager cookieSyncManager = CookieSyncManager.createInstance(argContext);
            cookieSyncManager.startSync();
            //CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncManager.stopSync();
            cookieSyncManager.sync();
        }
    }

    private String getAsCookieForm() {
        String retVal = "";
        Iterator iterator = cookieDataMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = entry.getKey() + "";
            String value = entry.getValue() + "";
            retVal += key + "=" + value;
            if (iterator.hasNext()) {
                retVal += ";";
            }
        }
        return retVal;
    }

    public Get get() {
        return new Get();
    }

    protected class Get {
        protected HashMap<String, String> asHashMap() {
            return cookieDataMap;
        }

        protected String asString() {
            /*cookieDataString = "";
            Iterator iterator = cookieDataMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String key = entry.getKey() + "";
                String value = entry.getValue() + "";
                cookieDataString += key + "=" + value;
                if (iterator.hasNext()) {
                    cookieDataString += ";";
                }
            }*/
            cookieDataString = getAsCookieForm();
            return cookieDataString;
        }
    }
}
/*
EasyCookieManager easyCookieManager = new EasyCookieManager(AppConstant.HTTP.API.WEB_VIEW_URL_BASE);
//
cookieDataString = easyCookieManager.get.asString();
DebugLog.log(AppConstant.TAG_GLOBAL_DEBUG + "COOKIE_MANAGER: " + cookieDataString);
//
easyCookieManager.setCookie("test_001", "test_001");
easyCookieManager.setCookie("test_002", "test_002");
cookieDataMap = easyCookieManager.get.asHashMap();
cookieDataString = easyCookieManager.get.asString();
DebugLog.log(AppConstant.TAG_GLOBAL_DEBUG + "COOKIE_MANAGER: " + cookieDataString);
//easyCookieManager.fullFlush(context);
*/
/*
LeadCookieManager
Set a cookie to a webView in Android
https://stackoverflow.com/questions/5716898/set-a-cookie-to-a-webview-in-android
https://developer.android.com/reference/android/webkit/CookieManager

String cookieString = "cookie_name=cookie_value; path=/";

val cookies = "key1=someValue1;key2=someValue2;key3=someValue3"
val cookiesList = cookies.split(";")
cookiesList.forEach { item ->
 CookieManager.getInstance().setCookie("http://someHost.com", item)
}

CookieManager.getInstance().setCookie("http://someHost.com", "key1=someValue1;key2=someValue2;key3=someValue3")
token=$2y$10$FJECPfsfyamkbpZkPFG99uBFcpNHilmmdrfNeVTmgo3j8aG4dw3g2

public static final String WEB_VIEW_URL_BASE = "http://192.168.2.17:3001/";


*/