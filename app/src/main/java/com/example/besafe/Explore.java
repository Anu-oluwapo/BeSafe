package com.example.besafe;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Explore extends Fragment {


    public Explore() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_explore, container, false);

        CardView cardView = v.findViewById(R.id.womenheroes);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),WomenHeroes.class);
                startActivity(intent);
            }
        });

        CardView unsafe = v.findViewById(R.id.unsafe);
        unsafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unasfeintent = new Intent(getActivity(), UnsafeAreas.class);
                startActivity(unasfeintent);
            }
        });


        CardView events = v.findViewById(R.id.events);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eventintent = new Intent(getActivity(), Events.class);
                startActivity(eventintent);
            }
        });

        CardView share = v.findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareintent = new Intent(getActivity(), Sharepost.class);
                startActivity(shareintent);
            }
        });

        // Inflate the layout for this fragment
        return v;

    }

}
