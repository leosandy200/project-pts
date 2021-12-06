package com.example.ptsganjil11rpl2leosandy15.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ptsganjil11rpl2leosandy15.Activity.MainActivity;
import com.example.ptsganjil11rpl2leosandy15.R;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread background  = new Thread() {
            @Override
            public void run() {
                try {

                    sleep(3 * 1000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                    finish();
                } catch (Exception e) {

                }
            }
        };
        background.start();

    }
}