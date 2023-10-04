package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class View_one extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Fly> list;
    DatabaseReference databaseReference;
    My_Adapter_View_One myAdapter;
    ImageView imageViewback;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(View_one.this,Select_plans.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_one);
        imageViewback=findViewById(R.id.backButton);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(View_one.this,Oneway.class));
            }
        });
        recyclerView=findViewById(R.id.recyclerview);
        databaseReference= FirebaseDatabase.getInstance().getReference("admin");
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter=new My_Adapter_View_One(this,list);
        recyclerView.setAdapter(myAdapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Intent data = getIntent();
////                Intent county=getIntent();
                String date =   data.getStringExtra("datepicker");
//                String spine_country=county.getStringExtra("sipne_country");
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Fly fly=dataSnapshot.getValue(Fly.class);
                    if(fly.getDeparture_one().equals(date))
                    {
                        list.add(fly);
                    }
                }

                myAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}