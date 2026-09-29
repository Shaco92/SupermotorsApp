package com.supermotors.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private OnMenuSelectionListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuSelectionListener) {
            listener = (OnMenuSelectionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnMenuSelectionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        setupMenuListeners(view);

        return view;
    }

    private void setupMenuListeners(View view) {
        view.findViewById(R.id.menu_profile).setOnClickListener(v -> listener.onMenuItemSelected("profile"));
        view.findViewById(R.id.menu_photos).setOnClickListener(v -> listener.onMenuItemSelected("photos"));
        view.findViewById(R.id.menu_specs).setOnClickListener(v -> listener.onMenuItemSelected("specs"));
        view.findViewById(R.id.menu_web).setOnClickListener(v -> listener.onMenuItemSelected("web"));
        view.findViewById(R.id.menu_buttons).setOnClickListener(v -> listener.onMenuItemSelected("buttons"));
        view.findViewById(R.id.menu_change_bike).setOnClickListener(v -> listener.onMenuItemSelected("change_bike"));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
