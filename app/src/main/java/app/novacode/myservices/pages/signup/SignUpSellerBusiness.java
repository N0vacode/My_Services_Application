/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.signup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.entity.Client;
import app.novacode.myservices.entity.Seller;
import app.novacode.myservices.repository.BusinessRepository;
import app.novacode.myservices.services.MD5C;

public class SignUpSellerBusiness extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner categoryService;
    EditText bsName;
    EditText bsWebsite;
    EditText bsAbout;
    ImageView uploadBusinessImage;
    Button bsCreate;
    Button takePhoto;
    String categoryBussiness;

    boolean isImageSelected = false;


    Seller seller = new Seller();
    BusinessRepository businessRepository = new BusinessRepository();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_seller_business);
        ArrayAdapter<CharSequence> adapterRol =  ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapterRol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        uploadBusinessImage = (ImageView) findViewById(R.id.uploadBusinessImage);
        categoryService     = (Spinner) findViewById(R.id.categoryService);
        bsWebsite = (EditText)  findViewById(R.id.bsWebsite);
        bsCreate  = (Button) findViewById(R.id.bsCreate);
        bsAbout   = (EditText) findViewById(R.id.bsAbout);
        bsName    = (EditText) findViewById(R.id.bsName);
        takePhoto = (Button) findViewById(R.id.takePhoto);


        categoryService.setAdapter(adapterRol);
        categoryService.setOnItemSelectedListener(this);



        //TODO: CREATE A IMPORT DATA, UPLOAD IMAGE, REGISTER USER AND BUSSINESS
        // TODO; MODIFY BACKEND FOR REGISTER SELLER AND BUSINESS


        String userRol = getIntent().getExtras().getString(ConstantValues.USER_ROL_KEY);
        String userFirstName = getIntent().getExtras().getString(ConstantValues.USER_FNAME_KEY);
        String userSecondName = getIntent().getExtras().getString(ConstantValues.USER_SNAME_KEY);
        String userMail = getIntent().getExtras().getString(ConstantValues.USER_MAIL_KEY);
        String userCity = getIntent().getExtras().getString(ConstantValues.USER_CITY_KEY);
        String userPhone= getIntent().getExtras().getString(ConstantValues.USER_PHONE_KEY);
        String userPassword = getIntent().getExtras().getString(ConstantValues.USER_PASS_KEY);

        bsCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MD5C.setUserData(userPassword);
                String passMd5 = MD5C.convert();


                // TODO CREAR SELLER

                seller.setUsRol(userRol);
                seller.setUsFirsName(userFirstName);
                seller.setUsEmail(userMail);
                seller.setUsSecondName(userSecondName);
                seller.setUsPhone(userPhone);
                seller.setUsPassword(passMd5);
                seller.setUsCity(userCity);

                businessRepository.setBusinessAbout(bsAbout.getText().toString());
                businessRepository.setBusinessArea(categoryBussiness);
                businessRepository.setBusinessWebsite(bsWebsite.getText().toString());
                businessRepository.setBusinessName(bsName.getText().toString());
                businessRepository.setRate(0.0d);

                if( isImageSelected ){

                    seller.signUpSeller(SignUpSellerBusiness.this, seller, businessRepository);

                }else{

                    Toast.makeText(SignUpSellerBusiness.this, "Should select an image", Toast.LENGTH_SHORT).show();
                }


            }
        });


        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);

        categoryBussiness = parent.getItemAtPosition(position).toString();

     //   System.out.println(categoryBussiness);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        super.onActivityResult(requestCode, resultCode, data);

        if ( resultCode == RESULT_OK ) {

            Uri path = data.getData();
            uploadBusinessImage.setImageURI(path);
            isImageSelected = true;

            try {

                // Import image from path
                Bitmap imageBitMap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), path);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                // Modify the Quality
                 imageBitMap.compress(Bitmap.CompressFormat.JPEG, 30, bos);

                 // REzise Image
                 imageBitMap = Bitmap.createScaledBitmap(imageBitMap, 70, 70, false);
                 imageBitMap.recycle();


                 // Add Image Array of Byte to bussiness variable, for upload to blob mysql
                 businessRepository.setImageByte(bos.toByteArray());

                //String encodedImage = Base64.encodeToString(blob.getBytes(1,bArray.length), Base64.DEFAULT);


            } catch (IOException e) {

                e.printStackTrace();

            }

        }else{

            isImageSelected = false;
        }

    }



    @SuppressLint("IntentReset")
    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, 1);

    }
}