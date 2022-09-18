package com.rzandroid.procachemanager;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * <h1>MemoryCache</h1>
 * <p>
 * Use for object memory cache
 * </p>
 *
 * @author Rz Rasel (Md. Rashed - Uz - Zaman)
 * @version 100.00.01
 * @since 2018-12-17
 */

class MemoryCache {
    private static String skipClassName = null;
    private static String skipMethodName = null;
    private static String methodName = "methodName-var";

    public static Object getCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        methodName = "static Object getCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException";
        //return C0367a.m1386a(argContext, argCacheKey);
        ProMemoryCache.setSkipClassMethod("MemoryCache", "getCache");
        return ProMemoryCache.getCache(argContext, argCacheKey);
    }

    public static Object getCache(Context argContext, String argCacheKey, String argSkipClass, String argSkipMethod) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        methodName = "static Object getCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException";
        //return C0367a.m1386a(argContext, argCacheKey);
        ProMemoryCache.setSkipClassMethod(argSkipClass, argSkipMethod);
        return ProMemoryCache.getCache(argContext, argCacheKey);
    }

    public static void setCache(Context argContext, String argCacheKey, Object argCacheObject) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        methodName = "static void setCache(Context argContext, String argCacheKey, Object argObject) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException";
        ProMemoryCache.setSkipClassMethod("MemoryCache", "setCache");
        //C0367a.m1389a(argContext, argCacheKey, argCacheObject);
        ProMemoryCache.setCache(argContext, argCacheKey, argCacheObject);
    }

    public static void setCache(Context argContext, String argCacheKey, Object argCacheObject, String argSkipClass, String argSkipMethod) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        methodName = "static void setCache(Context argContext, String argCacheKey, Object argObject) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException";
        ProMemoryCache.setSkipClassMethod(argSkipClass, argSkipMethod);
        //C0367a.m1389a(argContext, argCacheKey, argCacheObject);
        ProMemoryCache.setCache(argContext, argCacheKey, argCacheObject);
    }

    public static boolean deleteCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        methodName = "static boolean onDeleteCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException";
        ProMemoryCache.setSkipClassMethod("MemoryCache", "deleteCache");
        //return C0367a.m1392b(argContext, argCacheKey);
        return ProMemoryCache.deleteCache(argContext, argCacheKey);
    }

    public static boolean deleteCache(Context argContext, String argCacheKey, String argSkipClass, String argSkipMethod) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        methodName = "static boolean onDeleteCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException";
        ProMemoryCache.setSkipClassMethod(argSkipClass, argSkipMethod);
        //return C0367a.m1392b(argContext, argCacheKey);
        return ProMemoryCache.deleteCache(argContext, argCacheKey);
    }

    public static boolean clearCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        methodName = "static boolean onDeleteCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException";
        ProMemoryCache.setSkipClassMethod("MemoryCache", "clearCache");
        //return C0367a.m1392b(argContext, argCacheKey);
        return ProMemoryCache.clearCache(argContext, argCacheKey);
    }

    public static boolean clearCache(Context argContext, String argCacheKey, String argSkipClass, String argSkipMethod) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        methodName = "static boolean onDeleteCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException";
        ProMemoryCache.setSkipClassMethod(argSkipClass, argSkipMethod);
        //return C0367a.m1392b(argContext, argCacheKey);
        return ProMemoryCache.clearCache(argContext, argCacheKey);
    }

    /*public static void clearAll(Context argContext) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        methodName = "static void onClearAll(Context argContext) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException";
        //C0367a.m1388a(argContext);
        //MemoryCacheCore.onClearAll(argContext);
    }*/
    /*protected static void setSkipClassMethod(String argClassName, String argMethodName) {
        skipClassName = argClassName;
        skipMethodName = argMethodName;
    }

    protected static void setDefaultClassAndMethod() {
        skipClassName = null;
        skipMethodName = null;
    }*/
}
