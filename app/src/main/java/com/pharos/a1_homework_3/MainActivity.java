package com.pharos.a1_homework_3;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.pharos.a1_homework_3.ActivityTwo.TEXT_KEY;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Button sendToGmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        checkIntent();
    }
    private void init() {
        textView = findViewById(R.id.txtView);
        imageView = findViewById(R.id.imageOne);
        sendToGmail = findViewById(R.id.buttonTwo);

    }

    private void checkIntent() {
        Intent dataFromSecAct = getIntent();
        String getText1 = dataFromSecAct.getStringExtra(TEXT_KEY);
        textView.setText(getText1);
        imageView.setImageURI(ActivityTwo.uriOfImage);
    }

    public void goToActivityTwo(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
        startActivity(intent);
    }

    public void sendToGmail(View view) {
        Intent dataFromSecAct = getIntent();
        String getText1 = dataFromSecAct.getStringExtra(TEXT_KEY);
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, getText1);
        startActivity(sendIntent);

    }

    ;
}


