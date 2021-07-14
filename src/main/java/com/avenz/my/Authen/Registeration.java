package com.avenz.my.Authen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avenz.my.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registeration extends AppCompatActivity {

    DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://myapp-54df2-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        EditText names = findViewById(R.id.nametf);
        EditText mail = findViewById(R.id.mailtf2);
        EditText mpass = findViewById(R.id.passwordtf);
        EditText conpass = findViewById(R.id.regconpass);
        Button subbtn = findViewById(R.id.submitbtn);
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = names.getText().toString();
                String email = mail.getText().toString();
                String pass = mpass.getText().toString();
                String cpass = conpass.getText().toString();

                if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || cpass.isEmpty()){
                    Toast.makeText(Registeration.this, "Entries not done...", Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals(cpass)){
                    Toast.makeText(Registeration.this, "Passwords are not matching...", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {

                            if (snapshot.hasChild(email)){
                                Toast.makeText(Registeration.this, "Email is already registered.... ", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                databaseRef.child("users").child(email).setValue(name);
                                databaseRef.child("users").child(email).setValue(email);
                                databaseRef.child("users").child(pass).setValue(pass);
                                databaseRef.child("users").child(cpass).setValue(cpass);

                                Toast.makeText(Registeration.this, "Registered Successfully.....", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

                        }

                    });


                }


                Intent in = new Intent(Registeration.this,Login.class);
                startActivity(in);
            }
        });
    }
}