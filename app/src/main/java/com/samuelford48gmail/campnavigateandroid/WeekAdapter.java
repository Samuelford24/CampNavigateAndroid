package com.samuelford48gmail.campnavigateandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.MyHolder>{

    List<Week> weeks;

    public WeekAdapter(List<Week> weeks) {
        this.weeks= weeks;
    }

    @Override
    public WeekAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_week,parent,false);

       WeekAdapter.MyHolder myHolder = new WeekAdapter.MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(WeekAdapter.MyHolder holder, final int position) {
        final Week data = weeks.get(position);
        holder.picture.setImageResource(data.getDrawable());
        holder.week.setText(data.getWeek());
        holder.description.setText(data.getTheme());
        //System.out.println(data.getDate_class2());
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( final View view) {
                Context context = view.getContext();
Intent i = new Intent(context,WeekLayout.class);
context.startActivity(i);
              //  Context context = view.getContext();
              //  Intent intent = new Intent(context, Add_class_to_user.class);
               // intent.putExtra("date_class", listdata.get(position).getDate_class());
              //  intent.putExtra("teacher", listdata.get(position).getTeacher());
               // intent.putExtra("room_number", listdata.get(position).getRnumber());
                //intent.putExtra("post_key", listdata.get(position).getUid());

               // context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return weeks.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        ImageView picture;
        TextView week,description;

        public MyHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture);
           week = (TextView) itemView.findViewById(R.id.week);
       description = (TextView) itemView.findViewById(R.id.theme);

        }
    }

}

