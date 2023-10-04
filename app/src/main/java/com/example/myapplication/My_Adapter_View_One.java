package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class My_Adapter_View_One extends  RecyclerView.Adapter<My_Adapter_View_One.MyViewHolder> {

    public My_Adapter_View_One(Context context, ArrayList<Fly> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<Fly> list;

    @NonNull
    @Override
    public My_Adapter_View_One.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userunty,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull My_Adapter_View_One.MyViewHolder holder, int position) {
        Fly fly=list.get(position);

        holder.clock1.setText(list.get(position).getDeparture_time_one());
        holder.date.setText(list.get(position).getDeparture_one());
        holder.to.setText(list.get(position).getAirport_Two());
        holder.clock2.setText(list.get(position).getDeparture_time_Two());
        holder.forms.setText(list.get(position).getAirport_one());
        holder.price.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  static class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView forms,clock1,date,to,clock2,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            forms=itemView.findViewById(R.id.from);
            clock1=itemView.findViewById(R.id.c_1);
            date=itemView.findViewById(R.id.dte);
            to=itemView.findViewById(R.id.t);
            clock2=itemView.findViewById(R.id.c_2);
            price=itemView.findViewById(R.id.p);
        }
    }
}
