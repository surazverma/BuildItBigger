package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;

public class AsyncTaskTester extends AndroidTestCase {
    public void test() throws InterruptedException {
        assertTrue(true);
        final CountDownLatch signal = new CountDownLatch(1);
        GCE_NetworkAsyncTask gce_networkAsyncTask = new GCE_NetworkAsyncTask(getContext()){
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if(result!=null){
                    assertTrue(result.length()>0);
                    signal.countDown();
                }
            }
        };
        gce_networkAsyncTask.execute();
        signal.await();

    }
}
