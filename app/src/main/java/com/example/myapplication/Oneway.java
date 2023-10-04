package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class Oneway extends AppCompatActivity {
Spinner spinner,spinner2;
    EditText ed1,edp;
    TextView roundtrip,textViewselect;
private DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    private DatabaseReference databaseReference2= FirebaseDatabase.getInstance().getReference();
    private ArrayList<String> arrayList=new ArrayList<>();

    private ArrayList<String> arrayList2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneway);
        Intent intents=getIntent();
        int i=intents.getIntExtra("number11",0);
        int i1=intents.getIntExtra("number22",0);
        int i2=intents.getIntExtra("number33",0);

        spinner=findViewById(R.id.spiner);
        ShowDataSpiner();
        spinner2=findViewById(R.id.spiner2);
        ShowDataSpiner2();
        ed1=findViewById(R.id.ed1);
        textViewselect=findViewById(R.id.search);
        textViewselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Oneway.this,View_one.class);
                intent.putExtra("datepicker", ed1.getText().toString());
                startActivity(intent);
//                startActivity(new Intent(Oneway.this,View_one.class));
            }
        });
        edp=findViewById(R.id.ed3);
        edp.setText("Adults(s) "+", "+ i +  "  chlid(ren) , " + i1 +"  Infant(s) , "+i2);
        edp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Oneway.this,counter_presons.class));
            }
        });
        roundtrip=findViewById(R.id.round);
        roundtrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Oneway.this,Select_plans.class));
            }
        });
        Calendar calendar=Calendar.getInstance();
        final int year1=calendar.get(Calendar.YEAR);
        final int month1=calendar.get(Calendar.MONTH);
        final int day1=calendar.get(Calendar.DAY_OF_MONTH);
        ed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        Oneway.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String data=day+"/"+month+"/"+year1;
                        ed1.setText(data);
                    }
                },year1,month1,day1);
                datePickerDialog.show();
            }
        });
    }

    private void ShowDataSpiner2() {
        databaseReference2.child("admin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList2.clear();
                for(DataSnapshot item1:snapshot.getChildren()){
                    arrayList2.add(item1.child("airport_Two").getValue(String.class));
                }
                ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(Oneway.this,R.layout.style_spiner,arrayList2);
                spinner2.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ShowDataSpiner() {
        databaseReference.child("admin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot item:snapshot.getChildren()){
                    arrayList.add(item.child("airport_one").getValue(String.class));
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(Oneway.this,R.layout.style_spiner,arrayList);
                spinner.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


}}