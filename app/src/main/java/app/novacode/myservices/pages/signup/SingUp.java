package app.novacode.myservices.pages.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import app.novacode.myservices.MainActivity;
import app.novacode.myservices.R;

public class SingUp extends AppCompatActivity {

    TextView returnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        returnLogin = (TextView) findViewById(R.id.returnLogin);



        Intent loginActivityIntent = new Intent(this, MainActivity.class);


        returnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(loginActivityIntent);
            }
        });






    }
}