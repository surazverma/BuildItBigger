package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.android.androidsjoker.FunnyActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class GCE_NetworkAsyncTask extends AsyncTask<Void,Void,String> {
    private static MyApi myApiService = null;
    private Context context;



     GCE_NetworkAsyncTask(Context context){
        this.context = context;
    }



    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
        try {
            return myApiService.sayHi().execute().getData();
        }catch (IOException e){
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String s) {

        final Intent jokingIntent = new Intent(context, FunnyActivity.class);
        jokingIntent.putExtra("theJoke",s);
        context.startActivity(jokingIntent);



    }
}
