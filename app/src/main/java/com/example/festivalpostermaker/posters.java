package com.example.festivalpostermaker;

import static com.example.festivalpostermaker.R.drawable.diwalip1;
import static com.example.festivalpostermaker.R.drawable.navratri;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.net.URISyntaxException;

public class posters extends AppCompatActivity {

    ImageView imgPoster1;
    ImageView imgPoster2;
    ImageView imgPoster3;
    ImageView imgPoster4;
    ImageView imgPoster5;
    ImageView imgBack;
    int posterD1,posterD2,posterD3,posterD4,posterD5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posters);
        passImage();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    void posterinit()
    {
        imgPoster1 = findViewById(R.id.imgPoster1);
        imgPoster2 = findViewById(R.id.imgPoster2);
        imgPoster3 = findViewById(R.id.imgPoster3);
        imgPoster4 = findViewById(R.id.imgPoster4);
        imgPoster5 = findViewById(R.id.imgPoster5);
        imgBack=findViewById(R.id.imgBack);
    }

    void getData()
    {
        Intent intent = getIntent();

        posterD1 = intent.getIntExtra("poster1",0);
        posterD2 = intent.getIntExtra("poster2",0);
        posterD3 = intent.getIntExtra("poster3",0);
        posterD4 = intent.getIntExtra("poster4",0);
        posterD5 = intent.getIntExtra("poster5",0);

        imgPoster1.setImageResource(posterD1);
        imgPoster2.setImageResource(posterD2);
        imgPoster3.setImageResource(posterD3);
        imgPoster4.setImageResource(posterD4);
        imgPoster5.setImageResource(posterD5);
    }
    void passImage()
    {
        posterinit();
        getData();

        imgPoster1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Imageintent = new Intent(posters.this,finalposter.class);
                Imageintent.putExtra("finalImage",posterD1);
                startActivity(Imageintent);
            }
        });
        imgPoster2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Imageintent = new Intent(posters.this,finalposter.class);
                Imageintent.putExtra("finalImage",posterD2);
                startActivity(Imageintent);
            }
        });
        imgPoster3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Imageintent = new Intent(posters.this,finalposter.class);
                Imageintent.putExtra("finalImage",posterD3);
                startActivity(Imageintent);
            }
        });
        imgPoster4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Imageintent = new Intent(posters.this,finalposter.class);
                Imageintent.putExtra("finalImage",posterD4);
                startActivity(Imageintent);
            }
        });
        imgPoster5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Imageintent = new Intent(posters.this,finalposter.class);
                Imageintent.putExtra("finalImage",posterD5);
                startActivity(Imageintent);
            }
        });
    }

}