package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Select_flys extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Fly>list;
    DatabaseReference databaseReference;
    My_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_flys);
        recyclerView=findViewById(R.id.recyclerview);
        databaseReference= FirebaseDatabase.getInstance().getReference("admin");
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new My_Adapter(this,list);
        recyclerView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            Intent   data = getIntent();
                Intent county=getIntent();
                int total = 0;
              String date =   data.getStringExtra("datepicker");
              String date2 = data.getStringExtra("datepicker2");
              String spine_country=county.getStringExtra("sipne_country");
              String sp = data.getStringExtra("spinner1");
                String sp2 = data.getStringExtra("spinner2");
            String totalPrice = data.getStringExtra("totalprice");
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Fly fly=dataSnapshot.getValue(Fly.class);
             if(fly.getDeparture_one().equals(date)  && fly.getAirport_one().equals(sp)&& fly.getAirport_Two().equals(sp2)){
//                 fly.setPrice(fly.getPrice().substring(0,fly.getPrice().indexOf('$')));
                     total  = Integer.parseInt(fly.getPrice()) * Integer.parseInt(totalPrice);
                 fly.setPrice(String.valueOf(total)+"$");


                 list.add(fly);
             }

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}