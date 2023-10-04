package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Extrs extends AppCompatActivity {
    ImageView imgback,imgfly,imgmeal,imgcafe,imgextra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrs);
        imgback=findViewById(R.id.backButton);
        imgfly=findViewById(R.id.flywatch);
        imgmeal=findViewById(R.id.meal);
        imgcafe=findViewById(R.id.cafe_cafe);
        imgextra=findViewById(R.id.extra_Baggage);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Extrs.this,Home.class));
            }
        });
        imgfly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Extrs.this,Check_in.class));
            }
        });
        imgmeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Extrs.this,Check_in.class));
            }
        });
        imgcafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Extrs.this,Cafe.class));
            }
        });
        imgextra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Extrs.this,Check_in.class));

            }
        });


    }
}