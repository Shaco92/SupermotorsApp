package com.supermotors.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BikeAdapter extends RecyclerView.Adapter<BikeAdapter.BikeViewHolder> {

    private List<Bike> bikes;
    private OnBikeClickListener listener;

    public interface OnBikeClickListener {
        void onBikeClick(Bike bike);
    }

    public BikeAdapter(List<Bike> bikes, OnBikeClickListener listener) {
        this.bikes = bikes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bike, parent, false);
        return new BikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BikeViewHolder holder, int position) {
        Bike bike = bikes.get(position);
        holder.txtName.setText(bike.getName());
        holder.txtType.setText(bike.getType());
        if (bike.getMainImageUrl() != null && !bike.getMainImageUrl().isEmpty()) {
            ImageLoader.loadImage(bike.getMainImageUrl(), holder.imgBike, bike.getImageResId());
        } else {
            holder.imgBike.setImageResource(bike.getImageResId());
        }
        holder.itemView.setOnClickListener(v -> listener.onBikeClick(bike));
    }

    @Override
    public int getItemCount() {
        return bikes.size();
    }

    static class BikeViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtType;
        ImageView imgBike;

        public BikeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.item_txt_name);
            txtType = itemView.findViewById(R.id.item_txt_type);
            imgBike = itemView.findViewById(R.id.item_img_bike);
        }
    }
}
