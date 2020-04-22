package com.samuelford48gmail.campnavigateandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyHolder>{

    List<MenuItem> listdata;

    public MenuAdapter(List<MenuItem> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MenuAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_menu,parent,false);

       MenuAdapter.MyHolder myHolder = new MenuAdapter.MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MenuAdapter.MyHolder holder, final int position) {

        final MenuItem data = listdata.get(position);
        holder.breakfast.setText("Breakfast: " + data.getBreakfast());
        holder.lunch.setText("Lunch: " + data.getLunch());
        holder.day.setText(data.getDay());



    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView day , breakfast,lunch;

        public MyHolder(View itemView) {
            super(itemView);
            day = (TextView) itemView.findViewById(R.id.dayMenu);
            breakfast = (TextView) itemView.findViewById(R.id.breakfast);
            lunch = (TextView) itemView.findViewById(R.id.lunch);

        }
    }

}
