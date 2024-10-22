package com.example.museumholicapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BrowseFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;

    // Track the currently selected filter button
    private TextView selectedFilter;

    public BrowseFragment() {
        // Required empty public constructor
    }

    public static BrowseFragment newInstance(String param1, String param2) {
        BrowseFragment fragment = new BrowseFragment();
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
        itemList = new ArrayList<>();
        // Load the default list for Medieval Europe
        loadMedievalEuropeItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browse, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        itemAdapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(itemAdapter);

        setupFilterButtons(view);

        return view;
    }

    private void setupFilterButtons(View view) {
        TextView activeFilter = view.findViewById(R.id.activeFilter);
        TextView inactiveFilter1 = view.findViewById(R.id.inactiveFilter1);
        TextView inactiveFilter2 = view.findViewById(R.id.inactiveFilter2);
        TextView inactiveFilter3 = view.findViewById(R.id.inactiveFilter3);
        TextView inactiveFilter4 = view.findViewById(R.id.inactiveFilter4);
        TextView inactiveFilter5 = view.findViewById(R.id.inactiveFilter5);

        // Set default selected filter
        selectedFilter = activeFilter;

        // Click listeners for each filter
        activeFilter.setOnClickListener(v -> {
            updateSelectedFilter(activeFilter);
            loadMedievalEuropeItems();
            itemAdapter.notifyDataSetChanged();
        });

        inactiveFilter1.setOnClickListener(v -> {
            updateSelectedFilter(inactiveFilter1);
            loadArtifactsItems();
            itemAdapter.notifyDataSetChanged();
        });

        inactiveFilter2.setOnClickListener(v -> {
            updateSelectedFilter(inactiveFilter2);
            loadPaintingsItems();
            itemAdapter.notifyDataSetChanged();
        });

        inactiveFilter3.setOnClickListener(v -> {
            updateSelectedFilter(inactiveFilter3);
            loadSculpturesItems();
            itemAdapter.notifyDataSetChanged();
        });

        inactiveFilter4.setOnClickListener(v -> {
            updateSelectedFilter(inactiveFilter4);
            loadCeramicsItems();
            itemAdapter.notifyDataSetChanged();
        });

        inactiveFilter5.setOnClickListener(v -> {
            updateSelectedFilter(inactiveFilter5);
            loadTextilesItems();
            itemAdapter.notifyDataSetChanged();
        });
    }

    private void updateSelectedFilter(TextView newSelectedFilter) {
        // Reset the previously selected filter's appearance
        if (selectedFilter != null) {
            selectedFilter.setBackgroundResource(R.drawable.filter_background_inactive);
            selectedFilter.setTextColor(getResources().getColor(R.color.surface));
        }

        // Set the new selected filter's appearance
        selectedFilter = newSelectedFilter;
        selectedFilter.setBackgroundResource(R.drawable.filter_background_active);
        selectedFilter.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    private void loadMedievalEuropeItems() {
        itemList.clear();
        itemList.add(new Item("The Crown Jewels", "An exquisite collection of royal regalia from the medieval period, featuring ornate gold and gemstones."));
        itemList.add(new Item("Medieval Manuscript", "An elaborately illustrated manuscript from the 14th century, featuring intricate calligraphy and artwork."));
        itemList.add(new Item("Knight Armor", "A suit of armor worn by knights during the medieval battles, showcasing the craftsmanship of the period."));
    }

    private void loadArtifactsItems() {
        itemList.clear();
        itemList.add(new Item("Ancient Pottery", "Artifacts from the early civilizations showcasing craftsmanship."));
        itemList.add(new Item("Stone Tools", "Tools made by prehistoric humans, made from stone."));
    }

    private void loadPaintingsItems() {
        itemList.clear();
        itemList.add(new Item("Renaissance Painting", "A beautiful painting from the Renaissance period."));
        itemList.add(new Item("Impressionist Art", "A collection of impressionist artworks."));
    }

    private void loadSculpturesItems() {
        itemList.clear();
        itemList.add(new Item("Greek Statue", "An ancient Greek statue representing a famous figure."));
        itemList.add(new Item("Modern Sculpture", "A contemporary piece of art."));
    }

    private void loadCeramicsItems() {
        itemList.clear();
        itemList.add(new Item("Ancient Vase", "A beautifully crafted vase from the Roman era."));
        itemList.add(new Item("Modern Ceramic", "A modern take on traditional ceramic art."));
    }

    private void loadTextilesItems() {
        itemList.clear();
        itemList.add(new Item("Medieval Tapestry", "A large tapestry depicting historical events."));
        itemList.add(new Item("Ancient Textile", "An ancient fabric woven with care."));
    }
}
