package com.avenz.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.avenz.my.Authen.Login;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread = new Thread(){
          public void run(){
              try {
                  sleep(5000);

              } catch (Exception e) {
                  e.printStackTrace();
              }
              finally {
                  Intent in = new Intent(Splash_Screen.this, Login.class);
                  startActivity(in);
              }
          }
        };
        thread.start();
    }
}