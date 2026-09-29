package com.supermotors.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BikeListFragment extends Fragment {

    public interface OnBikeSelectedListener {
        void onBikeSelected(Bike bike);
    }

    private OnBikeSelectedListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnBikeSelectedListener) {
            listener = (OnBikeSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnBikeSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bike_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_bikes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        BikeAdapter adapter = new BikeAdapter(BikeRepository.getBikes(), bike -> {
            if (listener != null) {
                listener.onBikeSelected(bike);
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
