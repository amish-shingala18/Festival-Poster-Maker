package com.example.festivalpostermaker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imgDiwali,imgNavratri,imgHoli,imgDussehra,imgMakarSankranti,imgGaneshChaturthi,
            imgJanamashtmi,imgMahaShivratri, imgRakshaBandhan,imgChristmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBinding();

        getOnBackPressedDispatcher().addCallback(MainActivity.this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                exit();
            }
        });

        imgDiwali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.diwalip1);
                intent.putExtra("poster2",R.drawable.diwalip2);
                intent.putExtra("poster3",R.drawable.diwalip3);
                intent.putExtra("poster4",R.drawable.diwalip4);
                intent.putExtra("poster5",R.drawable.diwalip5);
                startActivity(intent);
            }
        });
        imgNavratri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.navratrip1);
                intent.putExtra("poster2",R.drawable.navratrip2);
                intent.putExtra("poster3",R.drawable.navratrip3);
                intent.putExtra("poster4",R.drawable.navratrip4);
                intent.putExtra("poster5",R.drawable.navratrip5);
                startActivity(intent);
            }
        });
        imgHoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.holi1);
                intent.putExtra("poster2",R.drawable.holi2);
                intent.putExtra("poster3",R.drawable.holi3);
                intent.putExtra("poster4",R.drawable.holi4);
                intent.putExtra("poster5",R.drawable.holi5);
                startActivity(intent);
            }
        });
        imgDussehra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.dussehrap1);
                intent.putExtra("poster2",R.drawable.dussehrap2);
                intent.putExtra("poster3",R.drawable.dussehrap3);
                intent.putExtra("poster4",R.drawable.dussehra4);
                intent.putExtra("poster5",R.drawable.dussehrap5);
                startActivity(intent);
            }
        });
        imgMakarSankranti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.makar_sankranti1);
                intent.putExtra("poster2",R.drawable.makar_sankranti2);
                intent.putExtra("poster3",R.drawable.makar_sankranti3);
                intent.putExtra("poster4",R.drawable.makar_sankranti4);
                intent.putExtra("poster5",R.drawable.makar_sankranti5);
                startActivity(intent);
            }
        });
        imgGaneshChaturthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.ganesh1);
                intent.putExtra("poster2",R.drawable.ganesh2);
                intent.putExtra("poster3",R.drawable.ganesh3);
                intent.putExtra("poster4",R.drawable.ganesh4);
                intent.putExtra("poster5",R.drawable.ganesh5);
                startActivity(intent);
            }
        });
        imgMahaShivratri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.maha_shivratri1);
                intent.putExtra("poster2",R.drawable.maha_shivratri2);
                intent.putExtra("poster3",R.drawable.maha_shivratri3);
                intent.putExtra("poster4",R.drawable.maha_shivratri4);
                intent.putExtra("poster5",R.drawable.maha_shivratri5);
                startActivity(intent);
            }
        });
        imgJanamashtmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.janmashtami1);
                intent.putExtra("poster2",R.drawable.janmashtami2);
                intent.putExtra("poster3",R.drawable.janmashtami3);
                intent.putExtra("poster4",R.drawable.janmashtami4);
                intent.putExtra("poster5",R.drawable.janmashtami5);
                startActivity(intent);
            }
        });
        imgRakshaBandhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.rakshabandhan1);
                intent.putExtra("poster2",R.drawable.rakshabandhan2);
                intent.putExtra("poster3",R.drawable.rakshabandhan3);
                intent.putExtra("poster4",R.drawable.rakshabandhan4);
                intent.putExtra("poster5",R.drawable.rakshabandhan5);
                startActivity(intent);
            }
        });
        imgChristmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,posters.class);

                intent.putExtra("poster1",R.drawable.christmas1);
                intent.putExtra("poster2",R.drawable.christmas2);
                intent.putExtra("poster3",R.drawable.christmas3);
                intent.putExtra("poster4",R.drawable.christmas4);
                intent.putExtra("poster5",R.drawable.christmas5);
                startActivity(intent);
            }
        });
    }

    void initBinding()
    {
        imgDiwali = findViewById(R.id.imgDiwali);
        imgNavratri = findViewById(R.id.imgNavratri);
        imgHoli = findViewById(R.id.imgHoli);
        imgDussehra = findViewById(R.id.imgDussehra);
        imgMakarSankranti = findViewById(R.id.imgMakarSankranti);
        imgGaneshChaturthi = findViewById(R.id.imgGaneshChaturthi);
        imgMahaShivratri = findViewById(R.id.imgMahaShivratri);
        imgJanamashtmi = findViewById(R.id.imgJanamashtmi);
        imgRakshaBandhan = findViewById(R.id.imgRakshaBandhan);
        imgChristmas = findViewById(R.id.imgChristmas);
    }
    void exit()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setCancelable(false).
                setTitle("Do you want to exit?").
                setMessage("Festival Poster Maker").
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).
                setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();
    }
}