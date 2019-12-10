package com.example.newproject;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Details extends Fragment {

    TextView name,details;
    private String profile_name="";
    public Details() {
        // Required empty public constructor
    }

    public Details(String profile_name) {
        this.profile_name = profile_name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        name = view.findViewById(R.id.details_name);
        details = view.findViewById(R.id.workdetail);
        name.setText(profile_name);
        view.findViewById(R.id.profile_details).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile profile = new Profile();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.jobs_frame,profile).commit();
            }
        });
        details.setText(profile_name+"Details I will produce any Genre of music with unlimited track and extra fast delivery with Premium Quality. Im new to Fiverr but i have lot of experience in music industry. \n" +
                "\n" +
                "I Usually Produce\n" +
                "\n" +
                "    Hip Hop\n" +
                "\n" +
                "    Pop\n" +
                "\n" +
                "    Electronic\n" +
                "\n" +
                "    Country\n" +
                "\n" +
                "    Rock\n" +
                "\n" +
                "    Cinematic\n" +
                "\n" +
                "    Indian Loops, Songs\n" +
                "\n" +
                "\n" +
                "My gears are\n" +
                "\n" +
                "    Roland A-61 Midi Keyboard\n" +
                "    Scarlette 2i2 Soundcard\n" +
                "    DT 770 Headphones\n" +
                "    Mackintosh Machine");
        return view;
    }

}
