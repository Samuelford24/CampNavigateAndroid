package com.samuelford48gmail.campnavigateandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.MyHolder>{

    List<Staff> staffList;

    public StaffAdapter(List<Staff> staffList) {
        this.staffList= staffList;
    }

    @Override
    public StaffAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_staff,parent,false);

        StaffAdapter.MyHolder myHolder = new StaffAdapter.MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(StaffAdapter.MyHolder holder, final int position) {

        final Staff data = staffList.get(position);
       holder.image.setImageResource(data.getDrawable());
        holder.position.setText(data.getName());
        holder.contactInfo.setText(data.getContactInfo());
        holder.description.setText(data.getBiography());



                //  Context context = view.getContext();
                //  Intent intent = new Intent(context, Add_class_to_user.class);
                // intent.putExtra("date_class", listdata.get(position).getDate_class());
                //  intent.putExtra("teacher", listdata.get(position).getTeacher());
                // intent.putExtra("room_number", listdata.get(position).getRnumber());
                //intent.putExtra("post_key", listdata.get(position).getUid());

                // context.startActivity(intent);



    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView position,description, contactInfo;

        public MyHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.staffImage);
           position = (TextView) itemView.findViewById(R.id.position);
            description = (TextView) itemView.findViewById(R.id.biography);
            contactInfo = itemView.findViewById(R.id.contactInfo);

        }
    }

}

