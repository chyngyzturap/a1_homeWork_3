package com.pharos.a1_homework_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ActivityTwo extends AppCompatActivity {

    public static final String TEXT_KEY = "textKey";
    public static final String PIC_KEY = "imageKey";
    private ImageView imageView2;
    public final int PICK_IMAGE = 1;
    private EditText editText;
    static Uri uriOfImage;
    private Button sendTheData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        imageView2 = findViewById(R.id.imageTwo);
        editText = findViewById(R.id.edTxt);
        sendTheData = findViewById(R.id.button2);

        imageView2 = (ImageView) findViewById(R.id.imageTwo);
        ImageView PickImage = (ImageView) findViewById(R.id.imageTwo);
        PickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(photoPickerIntent, "Select picture"), PICK_IMAGE);
            }
        });

        sendTheData.setOnClickListener(v -> {
            Intent backToMainAct = new Intent(ActivityTwo.this, MainActivity.class);
            backToMainAct.putExtra(TEXT_KEY, editText.getText().toString());
            backToMainAct.putExtra(PIC_KEY, String.valueOf(imageView2));
            startActivity(backToMainAct);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {

            uriOfImage = data.getData();
            imageView2.setImageURI(uriOfImage);
        }
    }

}
