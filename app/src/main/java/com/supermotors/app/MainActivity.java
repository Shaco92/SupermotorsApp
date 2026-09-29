package com.supermotors.app;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements OnMenuSelectionListener, BikeListFragment.OnBikeSelectedListener {

    private FragmentManager fragmentManager;
    private View listContainer;
    private View detailContainer;
    private Bike selectedBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        listContainer = findViewById(R.id.list_container);
        detailContainer = findViewById(R.id.detail_container);

        if (savedInstanceState == null) {
            showBikeList();
        }
    }

    private void showBikeList() {
        listContainer.setVisibility(View.VISIBLE);
        detailContainer.setVisibility(View.GONE);
        
        fragmentManager.beginTransaction()
                .replace(R.id.list_container, new BikeListFragment())
                .commit();
    }

    @Override
    public void onBikeSelected(Bike bike) {
        this.selectedBike = bike;
        showBikeDetails(bike);
    }

    private void showBikeDetails(Bike bike) {
        listContainer.setVisibility(View.GONE);
        detailContainer.setVisibility(View.VISIBLE);

        fragmentManager.beginTransaction()
                .replace(R.id.menu_container, new MenuFragment())
                .commit();

        loadFragment(ProfileFragment.newInstance(bike));
    }

    @Override
    public void onMenuItemSelected(String menuOption) {
        if ("change_bike".equals(menuOption)) {
            showBikeList();
            return;
        }

        Fragment selectedFragment = null;

        switch (menuOption) {
            case "profile":
                selectedFragment = ProfileFragment.newInstance(selectedBike);
                break;
            case "photos":
                selectedFragment = PhotosFragment.newInstance(selectedBike.getPhotoUrls(), selectedBike.getPhotos());
                break;
            case "specs":
                selectedFragment = SpecsFragment.newInstance(selectedBike);
                break;
            case "web":
                selectedFragment = WebFragment.newInstance(selectedBike.getWebUrl());
                break;
            case "buttons":
                selectedFragment = new ButtonsFragment();
                break;
        }

        if (selectedFragment != null) {
            loadFragment(selectedFragment);
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_container, fragment);
        transaction.commit();
    }
}
