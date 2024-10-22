package com.example.museumholicapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Get references to the ImageViews and ProgressBar
        ImageView imagePlaceholder1 = view.findViewById(R.id.imagePlaceholder1);
        ImageView imagePlaceholder2 = view.findViewById(R.id.imagePlaceholder2);
        ImageView imagePlaceholder3 = view.findViewById(R.id.imagePlaceholder3);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        CardView stepsCard = view.findViewById(R.id.stepsCard); // Reference to the steps card
        TextView viewStepsText = view.findViewById(R.id.viewStepsText); // Reference to the "View your steps" text

        // Set images
        imagePlaceholder1.setImageResource(R.drawable.visit_ngv2);
        imagePlaceholder2.setImageResource(R.drawable.whatson_lee_bull);
        imagePlaceholder3.setImageResource(R.drawable.whatson_thomas_price);

        // Set progress for the ProgressBar
        progressBar.setMax(100); // Set the maximum value for the progress bar
        progressBar.setProgress(70); // Set the current progress

        // Set onClick listener for the steps card
        stepsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to StatsFragment
                StatsFragment statsFragment = new StatsFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, statsFragment) // Use the correct fragment container ID
                        .addToBackStack(null) // Optional: adds the transaction to the back stack
                        .commit();
            }
        });

        return view;
    }
}
