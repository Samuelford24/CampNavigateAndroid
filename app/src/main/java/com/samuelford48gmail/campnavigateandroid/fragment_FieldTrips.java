package com.samuelford48gmail.campnavigateandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.samuelford48gmail.campnavigateandroid.R;

public class fragment_FieldTrips extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.activity_fragment__field_trips, container, false);
    return view;
  }
}
