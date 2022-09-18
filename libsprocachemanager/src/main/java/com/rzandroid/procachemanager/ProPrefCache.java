package com.rzandroid.procachemanager;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

public class ProPrefCache {
    private Context context;
    //private static String PREFS_NAME = PrefCache.class.getSimpleName();
    private static String PREFS_NAME = ProPrefCache.class.getPackage().getName();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private MODE mode = MODE.PRIVATE;
    private String retVal;

    //SharedPreferences  settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    public ProPrefCache(Context argContext) {
        this(argContext, argContext.getPackageName());
        /*this.context = argContext;
        //mode = MODE.PRIVATE;
        PREFS_NAME = argContext.getPackageName();*/
    }

    public ProPrefCache(Context argContext, String argPrefsName) {
        this.context = argContext;
        //mode = MODE.PRIVATE;
        this.PREFS_NAME = argPrefsName;
    }

    public ProPrefCache setValue(String argKey, Object argValue) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, mode.getModeValue());
        editor = sharedPreferences.edit();
        if (argValue instanceof Boolean) {
            editor.putBoolean(argKey, (Boolean) argValue);
        } else if (argValue instanceof Float) {
            editor.putFloat(argKey, (Float) argValue);
        } else if (argValue instanceof Integer) {
            editor.putInt(argKey, (Integer) argValue);
        } else if (argValue instanceof Long) {
        } else if (argValue instanceof String) {
            editor.putString(argKey, (String) argValue);
        } else if (argValue instanceof Set<?>) {
            editor.putStringSet(argKey, (Set<String>) argValue);
        }
        onSave();
        return this;
    }

    private void onSave() {
        if (editor != null) {
            editor.commit();
        }
    }

    public Object getValue(String argKey) {
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        Object retObject = null;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, mode.getModeValue());
        if (sharedPreferences.contains(argKey)) {
            Map<String, ?> mapKeyValueItems = sharedPreferences.getAll();
            retObject = mapKeyValueItems.get(argKey);
            /*if (retObject instanceof Boolean && retObject == null) {
                retObject = false;
            }
            else if (retObject instanceof Float) {
                editor.putFloat(argKey, (Float) argValue);
            } else if (retObject instanceof Integer) {
                editor.putInt(argKey, (Integer) argValue);
            } else if (retObject instanceof Long) {
            } else if (retObject instanceof String) {
                editor.putString(argKey, (String) argValue);
            } else if (retObject instanceof Set<?>) {
                editor.putStringSet(argKey, (Set<String>) argValue);
            }*/
        }
        return retObject;
    }

    public Map<String, ?> getAllKeyValue() {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, mode.getModeValue());
        Map<String, ?> mapKeyValueItems = sharedPreferences.getAll();

        /*for (Map.Entry<String, ?> entry : mapKeyValueItems.entrySet()) {
            //Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            System.out.println("|----|------------|MAP_KEY|----|" + entry.getKey() + " |----|MAP_VALUE|----|" + entry.getValue().toString());
        }*/
        return mapKeyValueItems;
    }

    public Map<String, ?> printAllKeyValue() {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, mode.getModeValue());
        Map<String, ?> mapKeyValueItems = sharedPreferences.getAll();

        for (Map.Entry<String, ?> entry : mapKeyValueItems.entrySet()) {
            //Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            //System.out.println("|----|------------|MAP_KEY|----|" + entry.getKey() + " |----|MAP_VALUE|----|" + entry.getValue().toString());
            System.out.println("MAP-KEY-VALUE: " + entry.getKey() + " - " + entry.getValue().toString());
        }
        return mapKeyValueItems;
    }

    public void clearByKey(String argKey) {
        //removeValue
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, mode.getModeValue());
        editor = sharedPreferences.edit();

        editor.remove(argKey);
        editor.commit();
    }

    public void clearAll() {
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, mode.getModeValue());
        editor = sharedPreferences.edit();

        editor.clear();
        editor.commit();
    }

    public ProPrefCache setValueTemp(String argKey, String argValue) {
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, mode.getModeValue());
        editor = sharedPreferences.edit();
        editor.putString(argKey, argValue);
        return this;
    }

    public String getValueTemp(String argKey) {
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //sharedPreferences = context.getSharedPreferences(PREFS_NAME, mode.getModeValue());
        retVal = sharedPreferences.getString(argKey, null);
        return retVal;
    }

    public enum MODE {
        PRIVATE("private", Context.MODE_PRIVATE);
        private String modeName;
        private int modeValue;

        MODE(String argModeName, int argModeValue) {
            this.modeName = argModeName;
            this.modeValue = argModeValue;
        }

        public String getModeName() {
            return this.modeName;
        }

        public int getModeValue() {
            return this.modeValue;
        }
    }
}
