package com.samuelford48gmail.campnavigateandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fragment_home  extends Fragment {
    List<Week> weeks = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmenthome, container, false);
        WeekAdapter adapter = new WeekAdapter(weeks);
        recyclerView = view.findViewById(R.id.rv);
        weeks.add(new Week(getString(R.string.tw1),getString(R.string.tdw1),R.drawable.week1));
       weeks.add(new Week(getString(R.string.tw2),getString(R.string.tdw2),R.drawable.week2));
       weeks.add(new Week(getString(R.string.tw3),getString(R.string.tdw3),R.drawable.week3));
        weeks.add(new Week(getString(R.string.tw4),getString(R.string.tdw4),R.drawable.week4));
        weeks.add(new Week(getString(R.string.tw5),getString(R.string.tdw5),R.drawable.week5));
        weeks.add(new Week(getString(R.string.tw6),getString(R.string.tdw6),R.drawable.week6));
        weeks.add(new Week(getString(R.string.tw7),getString(R.string.tdww7),R.drawable.week7));
        weeks.add(new Week(getString(R.string.tw8),getString(R.string.tdw8),R.drawable.week8));
        weeks.add(new Week(getString(R.string.tw9),getString(R.string.tdw9),R.drawable.week9));
        weeks.add(new Week(getString(R.string.tw10),getString(R.string.tdw10),R.drawable.week10));
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
       return view;


    }
}

