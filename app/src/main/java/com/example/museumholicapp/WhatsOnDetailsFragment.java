package com.example.museumholicapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class WhatsOnDetailsFragment extends Fragment {

    private static final String ARG_IMAGE_RES = "image_res";
    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_DATE_LOCATION = "date_location";

    private int imageRes;
    private String title;
    private String description;
    private String dateLocation;

    public WhatsOnDetailsFragment() {
        // Required empty public constructor
    }

    public static WhatsOnDetailsFragment newInstance(int imageRes, String title, String description, String dateLocation) {
        WhatsOnDetailsFragment fragment = new WhatsOnDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RES, imageRes);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        args.putString(ARG_DATE_LOCATION, dateLocation);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageRes = getArguments().getInt(ARG_IMAGE_RES);
            title = getArguments().getString(ARG_TITLE);
            description = getArguments().getString(ARG_DESCRIPTION);
            dateLocation = getArguments().getString(ARG_DATE_LOCATION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_whats_on_details, container, false);

        // Get references to UI elements
        ImageView exhibitionImage = view.findViewById(R.id.exhibitionImage);
        TextView exhibitionTitle = view.findViewById(R.id.exhibitionTitle);
        TextView exhibitionDescription = view.findViewById(R.id.exhibitionDescription);
        TextView exhibitionDateLocation = view.findViewById(R.id.exhibitionDateLocation);

        // Set the content
        exhibitionImage.setImageResource(imageRes);
        exhibitionTitle.setText(title);
        exhibitionDescription.setText(description);
        exhibitionDateLocation.setText(dateLocation);

        return view;
    }
}
