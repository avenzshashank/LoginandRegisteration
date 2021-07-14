package com.avenz.my.Authen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.avenz.my.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://myapp-54df2-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText mailtxt = findViewById(R.id.mailtf2);
        EditText passtxt = findViewById(R.id.passwordtf);
        Button button = findViewById(R.id.subbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mailtxt.getText().toString();
                String pass = passtxt.getText().toString();

                if (email.isEmpty() || pass.isEmpty()){
                    Toast.makeText(Login.this, "Please Enter Email or Password Creditionals...", Toast.LENGTH_SHORT).show();
                }
                else{

                }

            }
        });
        TextView textView2 =findViewById(R.id.regtv);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(Login.this,Registeration.class);
                startActivity(inte);
                finish();
            }
        });
    }
}