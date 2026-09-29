package com.supermotors.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private static final String ARG_BIKE = "arg_bike";
    private Bike bike;

    public static ProfileFragment newInstance(Bike bike) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_BIKE, bike);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bike = (Bike) getArguments().getSerializable(ARG_BIKE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        if (bike != null) {
            ((TextView) view.findViewById(R.id.txt_bike_name)).setText(bike.getName());
            ((TextView) view.findViewById(R.id.txt_bike_type)).setText(bike.getType());
            ((TextView) view.findViewById(R.id.txt_bike_year)).setText("Año: " + bike.getYear());
            ((TextView) view.findViewById(R.id.txt_bike_cc)).setText("Cilindraje: " + bike.getDisplacement());
            ((TextView) view.findViewById(R.id.txt_bike_hp)).setText("Potencia: " + bike.getPower());
            ((TextView) view.findViewById(R.id.txt_bike_speed)).setText("Velocidad Máx: " + bike.getTopSpeed());
            ((TextView) view.findViewById(R.id.txt_bike_weight)).setText("Peso: " + bike.getWeight());
            ((TextView) view.findViewById(R.id.txt_bike_desc)).setText(bike.getDescription());
            ImageView imgBike = view.findViewById(R.id.img_bike);
            if (bike.getMainImageUrl() != null && !bike.getMainImageUrl().isEmpty()) {
                ImageLoader.loadImage(bike.getMainImageUrl(), imgBike, bike.getImageResId());
            } else {
                imgBike.setImageResource(bike.getImageResId());
            }
        }

        return view;
    }
}
