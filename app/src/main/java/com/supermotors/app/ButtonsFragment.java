package com.supermotors.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ButtonsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        Button btnSpecs = view.findViewById(R.id.btn_specs);
        Button btnPrice = view.findViewById(R.id.btn_price);
        Button btnShare = view.findViewById(R.id.btn_share);

        btnSpecs.setOnClickListener(v -> showToast("Honda CBR 600RR - 600cc - 118 HP - 260 km/h"));
        
        btnPrice.setOnClickListener(v -> showToast("Precio aproximado: $65.000.000 COP"));
        
        btnShare.setOnClickListener(v -> showToast("Compartiendo en redes sociales..."));

        return view;
    }

    private void showToast(String message) {
        if (getContext() != null) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
