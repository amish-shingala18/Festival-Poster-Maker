package com.example.festivalpostermaker;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class posteredited extends AppCompatActivity {
    int imagePoster;
    ImageView imgEditPoster,imgPEBack,PELogo;
    TextView txtSetBusiness,txtSetMobile,txtSetAltMobile,txtSetEmail,
            txtSetWebsite,txtSetAddress,txtDownload,txtShare;
    LinearLayout lnrSec1;
    FloatingActionButton editBtn;
    RelativeLayout relImagePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posteredited);
        initPE();
        getFinalData();

        txtDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImage();

                Toast.makeText(posteredited.this, "Image Downloaded", Toast.LENGTH_SHORT).show();
            }
        });
        txtShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        imgPEBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editFontColor();
            }
        });
    }
    void initPE()
    {
        imgPEBack = findViewById(R.id.imgPEBack);
        imgEditPoster = findViewById(R.id.imgEditPoster);
        txtSetBusiness = findViewById(R.id.txtSetBusiness);
        txtSetMobile = findViewById(R.id.txtSetMobile);
        txtSetAltMobile = findViewById(R.id.txtSetAltMobile);
        txtSetEmail = findViewById(R.id.txtSetEmail);
        txtSetWebsite = findViewById(R.id.txtSetWebsite);
        txtSetAddress = findViewById(R.id.txtSetAddress);
        txtDownload = findViewById(R.id.txtDownload);
        txtShare = findViewById(R.id.txtShare);
        lnrSec1 = findViewById(R.id.lnrSec1);
        editBtn = findViewById(R.id.editBtn);
        relImagePoster = findViewById(R.id.relImagePoster);
        PELogo = findViewById(R.id.PELogo);
    }
    void getFinalData()
    {
        Intent DataIntent = getIntent();
        imagePoster = DataIntent.getIntExtra("imageFinal",0);
        String PEBusiness = DataIntent.getStringExtra("businessName");
        String PEMobile = DataIntent.getStringExtra("mobile");
        String PEAltNumber = DataIntent.getStringExtra("altNumber");
        String PEEmail = DataIntent.getStringExtra("email");
        String PEWebsite = DataIntent.getStringExtra("website");
        String PEAddress = DataIntent.getStringExtra("address");
        String logoImage = DataIntent.getStringExtra("urlImage");

        Picasso.get().load(logoImage).into(PELogo);
        imgEditPoster.setImageResource(imagePoster);
        txtSetBusiness.setText(PEBusiness);
        txtSetMobile.setText(PEMobile);
        if(PEAltNumber.isEmpty())
        {
            txtSetAltMobile.setVisibility(View.GONE);
        }
        else
        {
            txtSetAltMobile.setText(PEAltNumber);
        }
        txtSetEmail.setText(PEEmail);
        txtSetWebsite.setText(PEWebsite);
        txtSetAddress.setText(PEAddress);
    }

    void editFontColor()
    {
        Dialog dialog = new Dialog(posteredited.this);
        dialog.setContentView(R.layout.editdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        LinearLayout closeEditLayout = dialog.findViewById(R.id.closeEditLayout);

        closeEditLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        LinearLayout BgBlack = dialog.findViewById(R.id.BgBlack);
        LinearLayout BgRed = dialog.findViewById(R.id.BgRed);
        LinearLayout BgBlue = dialog.findViewById(R.id.BgBlue);
        LinearLayout BgGreen = dialog.findViewById(R.id.BgGreen);
        LinearLayout BgPurple = dialog.findViewById(R.id.BgPurple);
        LinearLayout BgYellow = dialog.findViewById(R.id.BgYellow);
        LinearLayout BgTrans = dialog.findViewById(R.id.BgTrans);

        LinearLayout FontBlack = dialog.findViewById(R.id.FontBlack);
        LinearLayout FontRed = dialog.findViewById(R.id.FontRed);
        LinearLayout FontBlue = dialog.findViewById(R.id.FontBlue);
        LinearLayout FontGreen = dialog.findViewById(R.id.FontGreen);
        LinearLayout FontPurple = dialog.findViewById(R.id.FontPurple);
        LinearLayout FontYellow = dialog.findViewById(R.id.FontYellow);
        LinearLayout FontWhite = dialog.findViewById(R.id.FontWhite);

        TextView FontItalic = dialog.findViewById(R.id.FontItalic);
        TextView FontBebasNeue =dialog.findViewById(R.id.FontBebasNeue);
        TextView FontCaveat = dialog.findViewById(R.id.FontCaveat);
        TextView FontPlayfair = dialog.findViewById(R.id.FontPlayfair);
        TextView FontTac_One = dialog.findViewById(R.id.FontTac_One);

        BgBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "onClick: ====== " );
                lnrSec1.setBackgroundColor(getColor(R.color.black));
                dialog.dismiss();
            }
        });
        BgRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Drawable drawable = AppCompatResources.getDrawable(DigiCardActivity.this,R.drawable.purprect);
                Drawable undrawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTint(drawable,);*/
                lnrSec1.setBackgroundColor(getColor(R.color.red));
                dialog.dismiss();
            }
        });
        BgBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.Blue));
                dialog.dismiss();
            }
        });
        BgGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.green));
                dialog.dismiss();
            }
        });
        BgPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.purple));
                dialog.dismiss();
            }
        });
        BgYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.yellow));
                dialog.dismiss();
            }
        });
        BgTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.trans));
                dialog.dismiss();
            }
        });

        FontBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSetBusiness.setTextColor(getColor(R.color.black));
                txtSetMobile.setTextColor(getColor(R.color.black));
                txtSetAltMobile.setTextColor(getColor(R.color.black));
                txtSetEmail.setTextColor(getColor(R.color.black));
                txtSetWebsite.setTextColor(getColor(R.color.black));
                txtSetAddress.setTextColor(getColor(R.color.black));
                dialog.dismiss();
            }
        });
        FontRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSetBusiness.setTextColor(getColor(R.color.red));
                txtSetMobile.setTextColor(getColor(R.color.red));
                txtSetAltMobile.setTextColor(getColor(R.color.red));
                txtSetEmail.setTextColor(getColor(R.color.red));
                txtSetAddress.setTextColor(getColor(R.color.red));
                txtSetWebsite.setTextColor(getColor(R.color.red));
                dialog.dismiss();
            }
        });
        FontBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSetMobile.setTextColor(getColor(R.color.Blue));
                txtSetAltMobile.setTextColor(getColor(R.color.Blue));
                txtSetEmail.setTextColor(getColor(R.color.Blue));
                txtSetWebsite.setTextColor(getColor(R.color.Blue));
                txtSetAddress.setTextColor(getColor(R.color.Blue));
                txtSetBusiness.setTextColor(getColor(R.color.Blue));
                dialog.dismiss();
            }
        });
        FontGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSetBusiness.setTextColor(getColor(R.color.green));
                txtSetMobile.setTextColor(getColor(R.color.green));
                txtSetAltMobile.setTextColor(getColor(R.color.green));
                txtSetEmail.setTextColor(getColor(R.color.green));
                txtSetWebsite.setTextColor(getColor(R.color.green));
                txtSetAddress.setTextColor(getColor(R.color.green));
                dialog.dismiss();
            }
        });
        FontPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSetBusiness.setTextColor(getColor(R.color.purple));
                txtSetMobile.setTextColor(getColor(R.color.purple));
                txtSetAltMobile.setTextColor(getColor(R.color.purple));
                txtSetEmail.setTextColor(getColor(R.color.purple));
                txtSetWebsite.setTextColor(getColor(R.color.purple));
                txtSetAddress.setTextColor(getColor(R.color.purple));
                dialog.dismiss();
            }
        });
        FontYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSetBusiness.setTextColor(getColor(R.color.yellow));
                txtSetMobile.setTextColor(getColor(R.color.yellow));
                txtSetAltMobile.setTextColor(getColor(R.color.yellow));
                txtSetEmail.setTextColor(getColor(R.color.yellow));
                txtSetWebsite.setTextColor(getColor(R.color.yellow));
                txtSetAddress.setTextColor(getColor(R.color.yellow));
                dialog.dismiss();
            }
        });
        FontWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSetBusiness.setTextColor(getColor(R.color.white));
                txtSetMobile.setTextColor(getColor(R.color.white));
                txtSetAltMobile.setTextColor(getColor(R.color.white));
                txtSetWebsite.setTextColor(getColor(R.color.white));
                txtSetEmail.setTextColor(getColor(R.color.white));
                txtSetAddress.setTextColor(getColor(R.color.white));
                dialog.dismiss();
            }
        });

        FontItalic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface italic = ResourcesCompat.getFont(posteredited.this,R.font.italic);
                txtSetBusiness.setTypeface(italic);
                txtSetMobile.setTypeface(italic);
                txtSetAltMobile.setTypeface(italic);
                txtSetEmail.setTypeface(italic);
                txtSetWebsite.setTypeface(italic);
                txtSetAddress.setTypeface(italic);
                dialog.dismiss();
            }
        });
        FontItalic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface italic = ResourcesCompat.getFont(posteredited.this,R.font.italic);
                txtSetBusiness.setTypeface(italic);
                txtSetMobile.setTypeface(italic);
                txtSetAltMobile.setTypeface(italic);
                txtSetEmail.setTypeface(italic);
                txtSetWebsite.setTypeface(italic);
                txtSetAddress.setTypeface(italic);
                dialog.dismiss();
            }
        });
        FontCaveat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface caveat = ResourcesCompat.getFont(posteredited.this,R.font.caveat);
                txtSetBusiness.setTypeface(caveat);
                txtSetMobile.setTypeface(caveat);
                txtSetAltMobile.setTypeface(caveat);
                txtSetEmail.setTypeface(caveat);
                txtSetWebsite.setTypeface(caveat);
                txtSetAddress.setTypeface(caveat);
                dialog.dismiss();
            }
        });
        FontBebasNeue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface bebas_neue = ResourcesCompat.getFont(posteredited.this,R.font.bebas_neue);
                txtSetBusiness.setTypeface(bebas_neue);
                txtSetMobile.setTypeface(bebas_neue);
                txtSetAltMobile.setTypeface(bebas_neue);
                txtSetEmail.setTypeface(bebas_neue);
               txtSetWebsite.setTypeface(bebas_neue);
                txtSetAddress.setTypeface(bebas_neue);
                dialog.dismiss();
            }
        });
        FontPlayfair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface playfair = ResourcesCompat.getFont(posteredited.this,R.font.playfair);
                txtSetBusiness.setTypeface(playfair);
                txtSetMobile.setTypeface(playfair);
                txtSetAltMobile.setTypeface(playfair);
                txtSetEmail.setTypeface(playfair);
                txtSetWebsite.setTypeface(playfair);
                txtSetAddress.setTypeface(playfair);
                dialog.dismiss();
            }
        });
        FontTac_One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface tac_one = ResourcesCompat.getFont(posteredited.this,R.font.tac_one);
                txtSetBusiness.setTypeface(tac_one);
                txtSetMobile.setTypeface(tac_one);
                txtSetAltMobile.setTypeface(tac_one);
                txtSetEmail.setTypeface(tac_one);
                txtSetWebsite.setTypeface(tac_one);
                txtSetAddress.setTypeface(tac_one);
                dialog.dismiss();
            }
        });
    }

    Bitmap convertImage()
    {
        relImagePoster.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(relImagePoster.getDrawingCache());
        relImagePoster.setDrawingCacheEnabled(false);
        return bitmap;
    }
    void saveImage()
    {
        Bitmap bitmap = convertImage();

        SimpleDateFormat sdf = new SimpleDateFormat("hh_mm_ss_dd_MM_yyyy");
        Date date = new Date();
        String image = sdf.format(date);

        File filename = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String path = filename.getPath()+"/"+image+".png";
        File file = new File(path);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void share()
    {
        Bitmap bitmap = convertImage();
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/png");
        Uri imageuri = Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM,imageuri);
        startActivity(Intent.createChooser(share,"select"));
    }
}