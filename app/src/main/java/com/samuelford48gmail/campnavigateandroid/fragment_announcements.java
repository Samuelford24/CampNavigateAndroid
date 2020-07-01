package com.samuelford48gmail.campnavigateandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class fragment_announcements extends Fragment {
    RecyclerView rv;
    List<Announcement> announcementList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragemnt_announcements, container, false);
        rv = view.findViewById(R.id.rvAnnouncements);
        retrieveData();
        return view;
    }
    public void retrieveData() {
       final AnnouncementAdapter recycler = new AnnouncementAdapter(announcementList);

        FirebaseFirestore.getInstance().collection("Announcements").orderBy("SortTimeStamp", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    //error
                }
               announcementList.clear();
                for (DocumentSnapshot d:queryDocumentSnapshots){
                    announcementList.add(new Announcement((String)d.get("announcement"),(String)d.get("timeStamp")));


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
