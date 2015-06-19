package com.health.testfragments;

import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "onCreate");
        if(savedInstanceState!=null){
            Log.i("MainActivity", "something in bundle");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("FragmentA");
        if(fragment==null){
            fragmentManager.beginTransaction().add(R.id.container, new FrgamentA(), "FragmentA").commit();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
    }
}
