package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Specialone extends AppCompatActivity {
    ImageView backbutton;
    ImageView blueshare;
    TextView textView1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialone);
        backbutton=findViewById(R.id.backButton);
        blueshare=findViewById(R.id.blueshare);
        textView1=findViewById(R.id.pur);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Specialone.this,Special.class));
            }
        });
        blueshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Check out this cool Application ");
                intent.putExtra(Intent.EXTRA_TEXT,"your Application link here");
                startActivity(Intent.createChooser(intent,"Share Via"));

            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Specialone.this,Select_plans.class));

            }
        });
    }
}