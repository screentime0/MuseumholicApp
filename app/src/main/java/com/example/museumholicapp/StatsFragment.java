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

public class StatsFragment extends Fragment {

    public StatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        TextView titleTextView = view.findViewById(R.id.title);
        titleTextView.setText("Your Stats");

        CardView stepsCard = view.findViewById(R.id.stepsCard);
        TextView stepsText = view.findViewById(R.id.stepsText);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        TextView stepCountText = view.findViewById(R.id.stepCountText);

        stepsText.setText("Museum Steps");
        stepCountText.setText("5,839 museum steps"); // Example step count
        progressBar.setMax(10000);
        progressBar.setProgress(5839); // Example progress

        stepsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MuseumStepsFragment museumStepsFragment = new MuseumStepsFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, museumStepsFragment) // Use the correct fragment container ID
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
