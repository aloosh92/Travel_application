package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecialTwo extends AppCompatActivity {

    ImageView back;
    ImageView img;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_two);
        back=findViewById(R.id.backButton);
        img=findViewById(R.id.sha);
        textView=findViewById(R.id.text43);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SpecialTwo.this,Special.class));
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Check out this cool Application ");
                intent.putExtra(Intent.EXTRA_TEXT,"your Application link here");
                startActivity(Intent.createChooser(intent,"Share Via"));
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SpecialTwo.this,Select_plans.class));
            }
        });

    }
}