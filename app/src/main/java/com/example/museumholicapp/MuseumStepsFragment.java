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

public class MuseumStepsFragment extends Fragment {

    public MuseumStepsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_museum_steps, container, false);

        // Title TextView
        TextView titleTextView = view.findViewById(R.id.title);
        titleTextView.setText("Your Museum Steps");

        // Banner Image
        ImageView bannerImage = view.findViewById(R.id.bannerImage);
        bannerImage.setImageResource(R.drawable.visit_ngv2); // Use your banner image

        // Steps Card
        TextView stepsText = view.findViewById(R.id.stepsText);
        TextView stepCountText = view.findViewById(R.id.stepCountText);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        // Set the step count and progress
        stepCountText.setText("5,839 museum steps");
        progressBar.setMax(10000);
        progressBar.setProgress(5839); // Example progress

        // Step Distance Card
        TextView stepDistanceValue = view.findViewById(R.id.stepDistanceValue);
        stepDistanceValue.setText("1.27 KM"); // Set your step distance value

        // Previous Visits Card
        setPreviousVisits(view);

        return view;
    }

    private void setPreviousVisits(View view) {
        String[] visitDates = {"8 Sep", "10 Sep", "12 Sep", "14 Sep", "16 Sep", "18 Sep"};
        int[] visitProgress = {4500, 6000, 3500, 5000, 7000, 6200};

        for (int i = 0; i < visitDates.length; i++) {
            String visitDateId = "visitDate" + (i + 1);
            String progressVisitId = "progressVisit" + (i + 1);

            int visitDateResId = getResources().getIdentifier(visitDateId, "id", getActivity().getPackageName());
            int progressVisitResId = getResources().getIdentifier(progressVisitId, "id", getActivity().getPackageName());

            TextView visitDateTextView = view.findViewById(visitDateResId);
            ProgressBar progressVisitBar = view.findViewById(progressVisitResId);

            visitDateTextView.setText(visitDates[i]);
            progressVisitBar.setMax(10000);
            progressVisitBar.setProgress(visitProgress[i]);
        }
    }
}
