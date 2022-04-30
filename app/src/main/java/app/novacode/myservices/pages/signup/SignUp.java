package app.novacode.myservices.pages.signup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.novacode.myservices.MainActivity;
import app.novacode.myservices.R;
import app.novacode.myservices.adapter.Validation;
import app.novacode.myservices.entity.Client;
import app.novacode.myservices.entity.Seller;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView returnLogin;
    TextView nextLogin;
    EditText firsName;
    EditText secondName;
    EditText emailSignUp;
    TextView errorMsm;
    Spinner rolUser;


    String userRol;

    Client client = new Client();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        ArrayAdapter<CharSequence> adapterRol =  ArrayAdapter.createFromResource(this, R.array.rol_user, android.R.layout.simple_spinner_item);
        Intent loginActivityIntent = new Intent(this, MainActivity.class);
        Intent signupClient = new Intent(this, SignUpClient.class);
        Intent signupSeller = new Intent(this, SignUpSeller.class);

        adapterRol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        returnLogin = (TextView) findViewById(R.id.returnLogin);
        nextLogin   = (TextView) findViewById(R.id.nextLogin);

        firsName    = (EditText) findViewById(R.id.firsName);
        secondName  = (EditText) findViewById(R.id.secondName);
        emailSignUp = (EditText) findViewById(R.id.emailSignUp);
        errorMsm    = (TextView) findViewById(R.id.errorMsm);


        rolUser     = (Spinner) findViewById(R.id.rolUser);
        rolUser.setAdapter(adapterRol);
        rolUser.setOnItemSelectedListener(this);



        returnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(loginActivityIntent);
            }
        });



        nextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    client.mailExist(emailSignUp.getText().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (
                        Validation.data( firsName, "You must write a NAME", "firtName" ) &&
                        Validation.data( secondName, "You must write a MAIL", "secondName" ) &&
                        Validation.data( emailSignUp, "you must write a SECOND NAME", "mail" )) {


                    // TODO ARREGLAR COMPROBACION DE MAIL


                        if (  !client.isMailExist() ) {

                            if (userRol.equals("Client")) {

                                signupClient.putExtra("userRol", userRol);
                                signupClient.putExtra("userFirstName", firsName.getText().toString());
                                signupClient.putExtra("userSecondName", secondName.getText().toString());
                                signupClient.putExtra("userMail", emailSignUp.getText().toString());
                                startActivity(signupClient);

                            } else {

                                signupSeller.putExtra("userRol", userRol);
                                signupSeller.putExtra("userFirstName", firsName.getText().toString());
                                signupSeller.putExtra("userSecondName", secondName.getText().toString());
                                signupSeller.putExtra("userMail", emailSignUp.getText().toString());
                                startActivity(signupSeller);

                            }


                        } else {

                            errorMsm.setText("If you forget your password you can retrieve it from the main menu.");
                            errorMsm.setTextColor(Color.RED);

                        }



                } else {

                        Toast.makeText(SignUp.this, "Error Of Data", Toast.LENGTH_SHORT).show();

                    }





            }
        });



    }

    // TODO ESPABLECER REGLAS PARA SELECCION DATOS
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        System.out.println(adapterView.getItemAtPosition(i));
        adapterView.getItemAtPosition(i);
        userRol = adapterView.getItemAtPosition(i).toString();

//        if(adapterView.getItemAtPosition(i).equals("Client") || adapterView.getItemAtPosition(i).equals("Seller")){
//
//        }else{
//            Toast.makeText(SignUp.this,"Shoulbe select a rol",Toast.LENGTH_LONG ).show();
//        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }



}