package com.rzandroid.procachemanager;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

class MemCache {
    public static Object getCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        return MemoryCache.getCache(argContext, argCacheKey, "MemCache", "getCache");
    }

    public static void setCache(Context argContext, String argCacheKey, Object argObject) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        MemoryCache.setCache(argContext, argCacheKey, argObject, "MemCache", "setCache");
    }

    public static boolean deleteCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return MemoryCache.deleteCache(argContext, argCacheKey, "MemCache", "deleteCache");
    }

    public static boolean clearCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return MemoryCache.clearCache(argContext, argCacheKey, "MemCache", "clearCache");
    }

    /*public static void clearAll(Context argContext) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        MemoryCache.clearAll(argContext);
    }*/
}
