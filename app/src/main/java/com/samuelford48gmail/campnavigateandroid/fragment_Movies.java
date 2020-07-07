package com.samuelford48gmail.campnavigateandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class fragment_Movies extends Fragment {
    RecyclerView rv;
    List<Movie> MovieList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment__movies, container, false);
        rv = view.findViewById(R.id.rvMovie);
        retrieveData();
        return view;
    }
    public void retrieveData() {
        SharedPreferences mySharedPreferences = getContext().getSharedPreferences("WeekRef", Context.MODE_PRIVATE);

        final MovieAdapter recycler = new MovieAdapter(MovieList);
        String wr = mySharedPreferences.getString("WeekRef", "");
        System.out.println(wr);
        FirebaseFirestore.getInstance().collection(wr).document("Movies").collection("MovieEntries").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.i("Error", "No data");
                }
                MovieList.clear();
                for (DocumentSnapshot d:queryDocumentSnapshots){
                    MovieList.add(new Movie((String)d.get("k2"),(String)d.get("three5"),(String)d.get("ms")));


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
