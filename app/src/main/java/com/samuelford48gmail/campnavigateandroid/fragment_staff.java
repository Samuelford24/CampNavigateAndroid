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
        staffList.add(new Staff("Eleanor Ramseier – Camp Navigate Director","Eleanor has been serving youth in the Wabash Valley for 27+ years. She began volunteering as a youth worker alongside her husband in 1990. In the most recent past, as Executive Director of the local YMCA, she helped develop and oversee the youth activities as well as the summer camps. She is the mother of three awesome adult children. She has always had a desire to encourage youth to find their passion, set goals and be strong in their faith! With Camp Navigate she can now combine these passions with another aspiration she has– developing youth to succeed in our community’s workforce! She loves spending time with family and friends, running, hiking, and anything adventurous.",R.drawable.eleanor,"Email:eleanor@campnavigate.org"));
       staffList.add(new Staff("Katelyn Ellinger – Program Director","We are so blessed to have Katelyn as a part of our Camp Navigate Team!  In Katelyn’s words, “I was born to put my whole heart into our youth. My day is filled with LOVE from littles, they teach me so much!” Katelyn starts her day at Fuqua Elementary as a Special Education Assistant and continues it at Camp Navigate’s After-School Care as the Program Director! During the summer she will assist in designing and Co-Directing our programs at camp. She has two years completed at Indiana State University in Elementary Education and plans to further her education with the end goal being a kindergarten teacher. Some of her favorite days are spent with friends, her fur babies and being outdoors in the sunshine!",R.drawable.katelyn,"Email: katelyn@campnavigate.org"));
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    return view;
    }

}
