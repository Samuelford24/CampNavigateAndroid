package com.samuelford48gmail.campnavigateandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
                String weekReference="";
                switch (position){
                    case 0:
                        weekReference="Week1";
                        break;
                    case 1:
                        weekReference="Week2";
                        break;
                    case 2:
                        weekReference="Week3";
                        break;
                    case 3:
                        weekReference="Week4";
                        break;
                    case 4:
                        weekReference="Week5";
                        break;
                    case 5:
                        weekReference="Week6";
                        break;
                    case 6:
                        weekReference="Week7";
                        break;
                    case 7:
                        weekReference="Week8";
                        break;
                    case 8:
                        weekReference="Week9";
                        break;
                    case 9:
                        weekReference="week";
                        break;
                    default:weekReference="None";
                }

                Context context = view.getContext();
                SharedPreferences mySharedPreferences = context.getSharedPreferences("WeekRef", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.putString("WeekRef", weekReference).commit();
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

