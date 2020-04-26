package com.samuelford48gmail.campnavigateandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.MyHolder>{

    List<Announcement> listdata;

    public AnnouncementAdapter(List<Announcement> listdata) {
        this.listdata = listdata;
    }

    @Override
    public AnnouncementAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_announcements,parent,false);

       AnnouncementAdapter.MyHolder myHolder = new AnnouncementAdapter.MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(AnnouncementAdapter.MyHolder holder, final int position) {

        final Announcement data = listdata.get(position);
        holder.announcement.setText(data.getAnnouncement());
        holder.timeStamp.setText(data.getTimestamp());




    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView announcement,timeStamp;

        public MyHolder(View itemView) {
            super(itemView);
            announcement = (TextView) itemView.findViewById(R.id.Announcement);
            timeStamp = (TextView) itemView.findViewById(R.id.timeStamp);


        }
    }

}
