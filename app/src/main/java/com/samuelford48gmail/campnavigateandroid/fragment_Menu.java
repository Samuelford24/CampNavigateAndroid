package com.samuelford48gmail.campnavigateandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class fragment_Menu extends Fragment {
RecyclerView rv;
List<MenuItem> menuList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment__menu, container, false);
        rv = view.findViewById(R.id.rvMenu);
retrieveData();
        return view;
    }
    public void retrieveData() {
        SharedPreferences mySharedPreferences = getContext().getSharedPreferences("WeekRef", Context.MODE_PRIVATE);

        final MenuAdapter recycler = new MenuAdapter(menuList);
        String wr = mySharedPreferences.getString("WeekRef", "");
        System.out.println(wr);
        FirebaseFirestore.getInstance().collection(wr).document("Menu").collection("MenuEntries").orderBy("SortTimeStamp", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    //error
                }
                menuList.clear();
                for (DocumentSnapshot d:queryDocumentSnapshots){
                    menuList.add(new MenuItem((String)d.get("breakfast"),(String)d.get("lunch"),(String)d.get("day")));
                 MenuItem m = menuList.get(0);
                 System.out.println((m.getBreakfast()));
                }
                recycler.notifyDataSetChanged();
            }

        });
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(recycler);

    }
}