package com.samuelford48gmail.campnavigateandroid;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

import Widget.AnnouncementWidget;

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
                    Log.i("Error", "No data");
                }
               announcementList.clear();
                for (DocumentSnapshot d:queryDocumentSnapshots){
                    announcementList.add(new Announcement((String)d.get("announcement"),(String)d.get("timeStamp")));


                }
                updateWidget(getContext());
                recycler.notifyDataSetChanged();
            }

        });
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutmanager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(recycler);

    }

    public void updateWidget(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(context.getString(R.string.announcements), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        StringBuilder announcementbuilder = new StringBuilder();
        Intent intent = new Intent(context, AnnouncementWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] ids = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, AnnouncementWidget.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        System.out.println("Size" + announcementList.size());
        for (Announcement a : announcementList) {
            System.out.println("Announcement" + a.getAnnouncement());
            announcementbuilder.append(a.getAnnouncement()).append(",");
        }

        String announcementsfinal = announcementbuilder.toString().trim();
        System.out.println("AnnouncementsFinal" + announcementsfinal);
        editor.putString(getString(R.string.announcements), announcementsfinal).apply();
        context.sendBroadcast(intent);
    }
}
