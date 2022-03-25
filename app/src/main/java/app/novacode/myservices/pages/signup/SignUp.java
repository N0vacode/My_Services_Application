package app.novacode.myservices.pages.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import app.novacode.myservices.MainActivity;
import app.novacode.myservices.R;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView returnLogin;
    TextView nextLogin;
    Spinner rolUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        ArrayAdapter<CharSequence> adapterRol =  ArrayAdapter.createFromResource(this, R.array.rol_user, android.R.layout.simple_spinner_item);
        Intent loginActivityIntent = new Intent(this, MainActivity.class);
        adapterRol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        returnLogin = (TextView) findViewById(R.id.returnLogin);
        nextLogin = (TextView) findViewById(R.id.nextLogin);


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





            }
        });



    }

    // TODO ESPABLECER REGLAS PARA SELECCION DATOS
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        System.out.println(adapterView.getItemAtPosition(i));
        adapterView.getItemAtPosition(i);

        if(adapterView.getItemAtPosition(i).equals("Client") || adapterView.getItemAtPosition(i).equals("Seller")){

        }else{
            Toast.makeText(SignUp.this,"Shoulbe select a rol",Toast.LENGTH_LONG ).show();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}