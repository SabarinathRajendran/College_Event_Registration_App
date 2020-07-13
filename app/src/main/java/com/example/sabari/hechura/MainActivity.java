package com.example.sabari.hechura;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mregbtn;
    private Button mpaymentverify;
    private Button mevents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mregbtn = findViewById(R.id.register);
        mpaymentverify = findViewById(R.id.mnewreg);
        mevents = findViewById(R.id.events);

        mregbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this ,cietregister.class);
                startActivity(i);
            }
        });

        mpaymentverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this ,registerpayment.class);
                startActivity(i);

            }
        });

        mevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this ,events.class);
                startActivity(i);

            }
        });
    }
}
