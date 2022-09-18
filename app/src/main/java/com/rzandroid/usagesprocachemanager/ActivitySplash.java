package com.rzandroid.usagesprocachemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.rzandroid.procachemanager.ProMemCache;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ActivitySplash extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private List<ModelTest> modelTestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        context = this;
        setContentView(R.layout.activity_splash);
        //
        modelTestList = new ArrayList<>();
        modelTestList.add(ModelTest.setter(1, "Name 1"));
        modelTestList.add(ModelTest.setter(2, "Name 2"));
        //
        try {
            ProMemCache.setCache(context, "key_cache", modelTestList);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            modelTestList = (List<ModelTest>) ProMemCache.getCache(context, "key_cache");
            System.out.println("DEBUG_LOG_PRINT: Size: " + modelTestList.size());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}