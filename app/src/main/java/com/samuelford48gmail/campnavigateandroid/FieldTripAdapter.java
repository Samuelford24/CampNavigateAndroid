package com.samuelford48gmail.campnavigateandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FieldTripAdapter extends RecyclerView.Adapter<FieldTripAdapter.MyHolder>{

    List<FieldTrip> listdata;

    public FieldTripAdapter(List<FieldTrip> listdata) {
        this.listdata = listdata;
    }

    @Override
    public FieldTripAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fieldtrips,parent,false);

        FieldTripAdapter.MyHolder myHolder = new FieldTripAdapter.MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(FieldTripAdapter.MyHolder holder, final int position) {

        final FieldTrip data = listdata.get(position);
        holder.day.setText(data.getDay());
        holder.where.setText("Where: " + data.getWhere());
        holder.when.setText("When: " + data.getWhen());
        holder.departure.setText("Departing at: " + data.getDeparture());
         holder.bring.setText("Bring: " + data.getBring());




    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        TextView day , where,when,bring,departure;

        public MyHolder(View itemView) {
            super(itemView);
            day = (TextView) itemView.findViewById(R.id.dayFt);
            where = (TextView) itemView.findViewById(R.id.where);
            when = (TextView) itemView.findViewById(R.id.when);
            bring = itemView.findViewById(R.id.bring);
            departure = itemView.findViewById(R.id.departure);

        }
    }

}
