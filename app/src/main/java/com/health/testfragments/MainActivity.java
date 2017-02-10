package com.health.testfragments;

import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "onCreate");
        if(savedInstanceState!=null){
            Log.i("MainActivity", "something in bundle HELLO WORLD Ankur Kunwar");
            //gggjhgjhg
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("FragmentA");
        if(fragment==null){
            fragmentManager.beginTransaction().add(R.id.container, new FrgamentA(), "FragmentA").commit();
        }
        checkForUpdates();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterManagers();
        Log.i("MainActivity", "onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        // ... your own onResume implementation
        checkForCrashes();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterManagers();
    }





    private void checkForCrashes() {
        CrashManager.register(this);
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this);
    }

    private void unregisterManagers() {
        UpdateManager.unregister();
    }
}
