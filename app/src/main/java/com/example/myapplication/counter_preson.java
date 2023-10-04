package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class counter_preson extends AppCompatActivity {

    ImageView imageplus,imagemeons,imageplusTwo,imageTwo,imageplusthrer,imagethere;
    int count=0,count1=0,count2=0;
    TextView textView0,textView1,textView2,textviewok;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_preson);
        imageplus=findViewById(R.id.pl);
        textView1=findViewById(R.id.number1);
        textView0=findViewById(R.id.number);
        textView2=findViewById(R.id.number2);
        textviewok=findViewById(R.id.ok);
        textviewok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView0.getText().toString().equals("")||textView1.getText().equals("")||textView2.getText().equals("")){
                    Toast.makeText(counter_preson.this,"plase the insert number of passengers",Toast.LENGTH_SHORT).show();
                }

                else {
                    int number32=Integer.parseInt(textView0.getText().toString());
                    int number1=Integer.parseInt(textView1.getText().toString());
                    int number2=Integer.parseInt(textView2.getText().toString());
                    Intent intent=new Intent(counter_preson.this,Select_plans.class);
                    intent.putExtra("number32",number32);
                    intent.putExtra("number2",number2);
                    intent.putExtra("number1",number1);
                    startActivityForResult(intent,1);


                }
            }
        });
        imageplusthrer=findViewById(R.id.plus2);
        imageplusthrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.plus2){
                    count2++;
                    textView2.setText(count2+"");
                }
            }
        });
        imagethere=findViewById(R.id.me2);
        imagethere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.me2){
                    if(count2!=0){
                        count2--;
                        textView2.setText(count2+"");
                    }
                }
            }
        });
        imageTwo=findViewById(R.id.me1);
        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.me1){
                    if(count1!=0){
                        count1--;
                        textView1.setText(count1+"");
                    }
                }
            }
        });
        imageplusTwo=findViewById(R.id.plus1);
        imageplusTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.plus1){
                    count1++;
                    textView1.setText(count1+"");
                }
            }
        });

        imagemeons=findViewById(R.id.me);
        imageplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.pl){
                    count++;
                    textView0.setText(count+"");
                }
            }
        });
        imagemeons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.me){
                    if(count!=1){
                        count--;
                        textView0.setText(count+"");
                    }
                }

            }
        });



    }

}