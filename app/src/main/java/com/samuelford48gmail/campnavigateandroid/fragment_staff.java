package com.samuelford48gmail.campnavigateandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class fragment_staff extends Fragment {
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_staff, container, false);
        ArrayList<Staff> staffList = new ArrayList<>();
        StaffAdapter adapter = new StaffAdapter(staffList);
        recyclerView = view.findViewById(R.id.RvStaff);
        staffList.add(new Staff(getString(R.string.position),getString(R.string.eleanorBio),R.drawable.eleanor,getString(R.string.eleanorEmail)));
       staffList.add(new Staff(getString(R.string.katelynposition),getString(R.string.katelynBio),R.drawable.katelyn,getString(R.string.katelynEmail)));
      staffList.add(new Staff(getString(R.string.marcelaPostition),getString(R.string.marcelaBio),R.drawable.marcela,getString(R.string.marcelaEmail)));
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    return view;
    }

}
