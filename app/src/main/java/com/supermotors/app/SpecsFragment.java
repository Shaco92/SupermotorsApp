package com.supermotors.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SpecsFragment extends Fragment {

    private static final String ARG_BIKE = "arg_bike";
    private Bike bike;

    public static SpecsFragment newInstance(Bike bike) {
        SpecsFragment fragment = new SpecsFragment();
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
        View view = inflater.inflate(R.layout.fragment_specs, container, false);

        if (bike != null) {
            setSpecItem(view.findViewById(R.id.spec_engine), "Motor", bike.getEngine());
            setSpecItem(view.findViewById(R.id.spec_cc), "Cilindraje", bike.getDisplacement());
            setSpecItem(view.findViewById(R.id.spec_power), "Potencia", bike.getPower());
            setSpecItem(view.findViewById(R.id.spec_torque), "Torque Máx", bike.getTorque());
            setSpecItem(view.findViewById(R.id.spec_brakes), "Frenos", bike.getBrakes());
            setSpecItem(view.findViewById(R.id.spec_weight), "Peso", bike.getWeight());
            setSpecItem(view.findViewById(R.id.spec_seat), "Altura Asiento", bike.getSeatHeight());
            setSpecItem(view.findViewById(R.id.spec_tank), "Capacidad Tanque", bike.getTankCapacity());
            setSpecItem(view.findViewById(R.id.spec_speed), "Velocidad Máx", bike.getTopSpeed());
        }

        return view;
    }

    private void setSpecItem(View container, String label, String value) {
        if (container != null) {
            ((TextView) container.findViewById(R.id.spec_label)).setText(label);
            ((TextView) container.findViewById(R.id.spec_value)).setText(value);
        }
    }
}
