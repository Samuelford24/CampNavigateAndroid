package com.samuelford48gmail.campnavigateandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
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
import com.samuelford48gmail.campnavigateandroid.R;

import java.util.ArrayList;
import java.util.List;

public class fragment_FieldTrips extends Fragment {

  RecyclerView rv;
  List<FieldTrip> ftList = new ArrayList<>();
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.activity_fragment__field_trips, container, false);
    rv = view.findViewById(R.id.rvFt);
    retrieveData();
    return view;
  }
  public void retrieveData() {
    SharedPreferences mySharedPreferences = getContext().getSharedPreferences("WeekRef", Context.MODE_PRIVATE);
    final FieldTripAdapter recycler = new FieldTripAdapter(ftList);
    String wr = mySharedPreferences.getString("WeekRef", "");
    System.out.println(wr);
    FirebaseFirestore.getInstance().collection(wr).document("FieldTrips").collection("FieldTripEntries").orderBy("SortTimeStamp", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
      @Override
      public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
        if (e != null) {
          //error
        }
        ftList.clear();
        for (DocumentSnapshot d:queryDocumentSnapshots){
          ftList.add(new FieldTrip((String)d.get("where"),(String)d.get("day"),(String)d.get("when"),(String)d.get("departing"),(String)d.get("bring")));


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
