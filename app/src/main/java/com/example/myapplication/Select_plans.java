package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class Select_plans extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText ed1;
    EditText ed2;
    EditText edselect1;
    EditText edTO;
    EditText edp,dnew;
    String text1,text;
    TextView oneway,round,return1,textViewselect,Test;
    Calendar calendar;
    int sumPrice;
    ImageView imageup ,table,back;
    private Spinner spinner,spinner2;

    DatePickerDialog.OnDateSetListener setListener;
    private DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    private  DatabaseReference databaseReference2=FirebaseDatabase.getInstance().getReference();
    private ArrayList<String>arrayList=new ArrayList<>();
    private ArrayList<String>arrayList2=new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        int i=intent.getIntExtra("number32",0);
        int i1=intent.getIntExtra("number1",0);
        int i2=intent.getIntExtra("number2",0);
         sumPrice = i+i1+i2;

        setContentView(R.layout.activity_select_plans);
        return1=findViewById(R.id.rut);
        table=findViewById(R.id.rn);
        back=findViewById(R.id.backButton);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
//        edselect1=findViewById(R.id.selected);
//        edTO=findViewById(R.id.edTo);
        imageup=findViewById(R.id.up_down);
        oneway=findViewById(R.id.oneway);
        round=findViewById(R.id.round);
        textViewselect=findViewById(R.id.search);

        spinner=findViewById(R.id.spiner);
        ShowDataSpiner();




        spinner2=findViewById(R.id.spiner2);
        ShowDataSpiner2();

        edp=findViewById(R.id.ed3);
        edp.setText("Adults(s) "+", "+ i +  "  chlid(ren) , " + i1 +"  Infant(s) , "+i2);
        dnew=edselect1;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Select_plans.this,Home.class));
            }
        });
        oneway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Select_plans.this,Oneway.class));
//                ed2.setVisibility(View.GONE);
//                table.setVisibility(View.GONE);
//                return1.setVisibility(View.GONE);
            }
        });

        round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Select_plans.this,Select_plans.class));
            }
        });
        edp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//          ButtomSheet buttomSheet=new ButtomSheet();
//          buttomSheet.show(getSupportFragmentManager(),"thank you");
                startActivity(new Intent(Select_plans.this,counter_preson.class));


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
                        Select_plans.this, new DatePickerDialog.OnDateSetListener() {
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

        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        ed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        Select_plans.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String data=day+"/"+month+"/"+year;
                        ed2.setText(data);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });



    }



    private void ShowDataSpiner() {
        databaseReference.child("admin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot item:snapshot.getChildren()){
                    if(!item.child("airport_one").getValue(String.class).isEmpty() && !arrayList.contains(item.child("airport_one").getValue(String.class))) {
                        arrayList.add(item.child("airport_one").getValue(String.class));
                    }
                }
                ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(Select_plans.this,R.layout.style_spiner,arrayList);
                spinner.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
          text=adapterView.getItemAtPosition(i).toString();
         text1=adapterView.getItemAtPosition(i).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void ShowDataSpiner2() {
        databaseReference2.child("admin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList2.clear();
                for(DataSnapshot item1:snapshot.getChildren()){
                    if(!item1.child("airport_Two").getValue(String.class).isEmpty() && !arrayList2.contains(item1.child("airport_Two").getValue(String.class)))
                    {
                    arrayList2.add(item1.child("airport_Two").getValue(String.class));
                    }
                }
                ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(Select_plans.this,R.layout.style_spiner,arrayList2);
                spinner2.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        imageup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(Select_plans.this,R.layout.style_spiner,arrayList2);
                ArrayAdapter<String>arrayAdapter1=new ArrayAdapter<>(Select_plans.this,R.layout.style_spiner,arrayList);
               if(spinner.getAdapter().getItem(0) ==arrayAdapter1.getItem(0))
               {
                   spinner.setAdapter(arrayAdapter);
                   spinner2.setAdapter(arrayAdapter1);
               }
               else
               {
                   spinner.setAdapter(arrayAdapter1);
                   spinner2.setAdapter(arrayAdapter);
               }


            }
        });
        textViewselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=1;
                String ed_data_string=ed1.getText().toString();
                String ed_data_string2=ed2.getText().toString();
                String ed_data_string3=edp.getText().toString();

                if(ed_data_string.isEmpty()){
                    ed1.setError("Deo is required!!");
                    ed1.requestFocus();
                    return;
                }
                if(ed_data_string2.isEmpty()){
                    ed2.setError("Return data is required!!");
                    ed2.requestFocus();
                    return;
                }
                if(ed_data_string3.isEmpty()){
                    edp.setError("Passengers is required!!");
                    edp.requestFocus();
                    return;
                }
                Intent intent=new Intent(Select_plans.this,Select_flys.class);
                intent.putExtra("spinner1",spinner.getSelectedItem().toString());
                intent.putExtra("totalprice",String.valueOf(sumPrice));
                intent.putExtra("spinner2",spinner2.getSelectedItem().toString());
                intent.putExtra("datepicker", ed1.getText().toString());
                intent.putExtra("datepicker2", ed2.getText().toString());
                startActivity(intent);

            }
        });
    }



}