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
       weeks.add(new Week(getString(R.string.tw3),getString(R.string.tdw4),R.drawable.week3));
        weeks.add(new Week(getString(R.string.tw4),"This week we will think outside the box! Our Campers will learn from past inventors that had courage to make mistakes and discover that failures can be the beginning of something great. Attitude and perspective changes everything! We can’t wait to see what our Campers will create!",R.drawable.week4));
        weeks.add(new Week(getString(R.string.tw5),"This week our campers will enjoy many activities that will remind us of the bravery of so many heroes throughout history. Many have benefited by the courage of our forefathers. Campers will explore our great nation’s history and celebrate the freedoms that we are so privileged to have. They will be designing their very own T-Shirt in honor of our Country’s Birthday!",R.drawable.week5));
        weeks.add(new Week(getString(R.string.tw6),"We are blessed to have a real hero that watches over us daily. This week our devotionals will focus on the strength and love that we receive from God every single day. Our activities will center around how best to connect and celebrate each other with a Christ like love. And of course there will be a few Christmas surprises along the way.",R.drawable.week6));
        weeks.add(new Week(getString(R.string.tw7),"We love our campers just the way they are! This week we will learn to love and respect ourselves! We all come in different shapes and sizes and this week we will focus on our amazing uniqueness! Having courage to be the best “me” requires making wise choices.",R.drawable.week7));
        weeks.add(new Week(getString(R.string.tw8),"Join us as we have a week full of activities of Olympic proportion. This week we will learn about the courageous athletes who have traveled to Japan to represent the United States at the Summer Olympics. We will hear their stories of struggles and success; we will learn the history of this great event; and we will have some very competitive, yet friendly, Summer Games –Camp Navigate style!",R.drawable.week8));
        weeks.add(new Week(getString(R.string.tw9),"This week is a favorite for our Campers! They love preparing group acts or going solo…either way, it is their creation (within limits). No capes needed for these Super Heroes that are up on stage!",R.drawable.week9));
        weeks.add(new Week(getString(R.string.tw10),"During this last week of Camp, we celebrate with a private pool party at the Robinson pool and our end of the summer family cookout! By the end of summer, the Campers have played hard, worked hard and learned a lot about how to succeed in life! Our hope is that they will now better know how to communicate in a respectful manner with friends and family as they have the courage to enter a new school year.",R.drawable.week10));
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
       return view;


    }
}

