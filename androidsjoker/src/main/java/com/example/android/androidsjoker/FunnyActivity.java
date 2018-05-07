package com.example.android.androidsjoker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FunnyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny);
        TextView jokeTextView =  findViewById(R.id.joke_text);

        Bundle recievingBundle = getIntent().getExtras();

        if (recievingBundle != null) {
            String recievedJoke = recievingBundle.getString("theJoke");
            jokeTextView.setText(recievedJoke);
        }else{
            Toast.makeText(this,"Something is Broken",Toast.LENGTH_SHORT).show();
            jokeTextView.setText(R.string.no_joke_text);
        }



    }
}
