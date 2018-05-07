package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

public class AsyncTaskTester extends AndroidTestCase {
    public void test(){
        String output = null;
        GCE_NetworkAsyncTask gce_networkAsyncTask =  new GCE_NetworkAsyncTask(getContext());
        gce_networkAsyncTask.execute();

        try {
            output = gce_networkAsyncTask.get();
            Log.d("AndroidTester","It is working and the output is  :"+output);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
