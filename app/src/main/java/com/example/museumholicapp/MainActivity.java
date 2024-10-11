package com.example.museumholicapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.museumholicapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Force the app to always use dark mode as default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.search) {
                replaceFragment(new SearchFragment());
            } else if (item.getItemId() == R.id.qr_scanner) {
                replaceFragment(new QrScannerFragment());
            } else if (item.getItemId() == R.id.browse) {
                replaceFragment(new BrowseFragment());
            } else if (item.getItemId() == R.id.likes) {
                replaceFragment(new LikesFragment());
            }


            return true;
        });

        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment()); // Set initial fragment
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit(); // Fixed method call
    }

    // Keep your commented-out code
    // EdgeToEdge.enable(this);
    // setContentView(R.layout.activity_main);
    // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
    //     Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
    //     v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
    //     return insets;
    // });
}
