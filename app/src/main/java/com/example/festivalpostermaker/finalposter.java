package com.example.festivalpostermaker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

public class finalposter extends AppCompatActivity {

    ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    RadioGroup rgAltNumber;
    ImageView imgFPBack,imgFinalPoster,imgLogo;
    LinearLayout lnrLogo;
    RadioButton rdYes,rdNo;
    TextInputLayout edtBusinessNameLayout,edtAddressLayout,edtMobileLayout,edtAltNumLayout,edtEmailLayout,edtWebsiteLayout;
    TextInputEditText edtBusinessName,edtAddress,edtMobile,edtAltNum,edtEmail,edtWebsite;
    Button btnSubmit;
    int FinalImage;

    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalposter);
        initFP();
        getImage();

        imgFPBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pickMedia= registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), url->
        {
            if(url!=null) {
                imgLogo.setImageURI(url);
                uri = url;
                //Use of Picasso
                //Picasso.get().load(uri).into(imgProfile);
            }
        });

        lnrLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickMedia.launch(new PickVisualMediaRequest.Builder()
                        .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                        .build());
            }
        });

        rgAltNumber.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdYes)
                {
                    edtAltNumLayout.setVisibility(View.VISIBLE);
                    edtAltNum.setVisibility(View.VISIBLE);
                }
                else {
                    edtAltNumLayout.setVisibility(View.GONE);
                    edtAltNum.setVisibility(View.GONE);
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String BusinessName = edtBusinessName.getText().toString();
                String Address = edtAddress.getText().toString();
                String Mobile = edtMobile.getText().toString();
                String AltNumber = edtAltNum.getText().toString();
                String Email = edtEmail.getText().toString();
                String Website = edtWebsite.getText().toString();

                if (BusinessName.isEmpty())
                {
                    edtBusinessNameLayout.setErrorEnabled(true);
                    edtBusinessNameLayout.setError("Enter Business Name");
                }
                else if(Address.isEmpty())
                {
                    edtAddressLayout.setErrorEnabled(true);
                    edtAddressLayout.setError("Enter Address");
                }
                else if (Mobile.isEmpty())
                {
                    edtMobileLayout.setErrorEnabled(true);
                    edtMobileLayout.setError("Enter Mobile Number");
                }
                else if(rgAltNumber.getCheckedRadioButtonId() != R.id.rdYes && rgAltNumber.getCheckedRadioButtonId() != R.id.rdNo)
                {
                    Toast.makeText(finalposter.this,"Please Select Yes or No",Toast.LENGTH_SHORT).show();
                }
                else if(AltNumber.isEmpty() && rgAltNumber.getCheckedRadioButtonId() == R.id.rdYes)
                {
                    edtAltNumLayout.setErrorEnabled(true);
                    edtAltNumLayout.setError("Enter Alternative Number");
                }
                else if(Email.isEmpty())
                {
                    edtEmailLayout.setErrorEnabled(true);
                    edtEmailLayout.setError("Enter Email");
                }
                else if(Website.isEmpty())
                {
                    edtWebsiteLayout.setErrorEnabled(true);
                    edtWebsiteLayout.setError("Enter Website");
                }
                else
                {
                    edtBusinessNameLayout.setErrorEnabled(false);
                    edtAddressLayout.setErrorEnabled(false);
                    edtMobileLayout.setErrorEnabled(false);
                    edtAltNumLayout.setErrorEnabled(false);
                    edtEmailLayout.setErrorEnabled(false);
                    edtWebsiteLayout.setErrorEnabled(false);

                    Intent DataIntent = new Intent(finalposter.this,posteredited.class);
                    DataIntent.putExtra("businessName",BusinessName);
                    DataIntent.putExtra("address",Address);
                    DataIntent.putExtra("mobile",Mobile);
                    DataIntent.putExtra("altNumber",AltNumber);
                    DataIntent.putExtra("email",Email);
                    DataIntent.putExtra("website",Website);
                    DataIntent.putExtra("imageFinal",FinalImage);
                    //DataIntent.putExtra("urlImage",uri.toString());
                    startActivity(DataIntent);
                }
            }
        });

    }
    void initFP()
    {
        imgFPBack = findViewById(R.id.imgFPBack);
        imgFinalPoster= findViewById(R.id.imgFinalPoster);
        lnrLogo = findViewById(R.id.lnrLogo);
        imgLogo = findViewById(R.id.imgLogo);
        rgAltNumber = findViewById(R.id.rgAltNumber);
        rdYes = findViewById(R.id.rdYes);
        rdNo = findViewById(R.id.rdNo);
        edtBusinessNameLayout = findViewById(R.id.edtBusinessNameLayout);
        edtBusinessName = findViewById(R.id.edtBusinessName);
        edtAddressLayout = findViewById(R.id.edtAddressLayout);
        edtAddress = findViewById(R.id.edtAddress);
        edtMobileLayout = findViewById(R.id.edtMobileLayout);
        edtMobile = findViewById(R.id.edtMobile);
        edtAltNumLayout = findViewById(R.id.edtAltNumLayout);
        edtAltNum = findViewById(R.id.edtAltNum);
        edtEmailLayout = findViewById(R.id.edtEmailLayout);
        edtEmail = findViewById(R.id.edtEmail);
        edtWebsiteLayout = findViewById(R.id.edtWebsiteLayout);
        edtWebsite = findViewById(R.id.edtWebsite);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
    void getImage() {
        Intent Imageintent = getIntent();
        FinalImage = Imageintent.getIntExtra("finalImage",0);
        imgFinalPoster.setImageResource(FinalImage);
    }
}