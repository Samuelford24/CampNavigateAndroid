package com.samuelford48gmail.campnavigateandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.MyHolder>{

        List<Movie> listdata;

public MovieAdapter(List<Movie> listdata) {
        this.listdata = listdata;
        }

@Override
public MovieAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_movies,parent,false);

    MovieAdapter.MyHolder myHolder = new MovieAdapter.MyHolder(view);
        return myHolder;
        }


public void onBindViewHolder(MovieAdapter.MyHolder holder, final int position) {

final Movie data = listdata.get(position);
        holder.k2.setText("Kindergarden: " + data.getK2());
        holder.three5.setText("3rd-5th: " + data.getThree5());
    holder.ms.setText("Middle School: " + data.getMs());



        }

@Override
public int getItemCount() {
        return listdata.size();
        }


class MyHolder extends RecyclerView.ViewHolder{
    TextView day , k2,three5, ms;

    public MyHolder(View itemView) {
        super(itemView);

        k2 =  itemView.findViewById(R.id.k2);
        three5 =  itemView.findViewById(R.id.three5);
        ms=  itemView.findViewById(R.id.ms);

    }
}

}
