package com.supermotors.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PhotosFragment extends Fragment {

    private static final String ARG_PHOTO_URLS = "arg_photo_urls";
    private static final String ARG_PHOTOS = "arg_photos";
    private String[] photoUrls;
    private int[] photos;

    public static PhotosFragment newInstance(String[] photoUrls, int[] photos) {
        PhotosFragment fragment = new PhotosFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PHOTO_URLS, photoUrls);
        args.putIntArray(ARG_PHOTOS, photos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            photoUrls = getArguments().getStringArray(ARG_PHOTO_URLS);
            photos = getArguments().getIntArray(ARG_PHOTOS);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photos, container, false);

        ImageView photo1 = view.findViewById(R.id.photo1);
        ImageView photo2 = view.findViewById(R.id.photo2);
        ImageView photo3 = view.findViewById(R.id.photo3);

        int p1 = (photos != null && photos.length >= 1) ? photos[0] : R.drawable.img_placeholder;
        int p2 = (photos != null && photos.length >= 2) ? photos[1] : R.drawable.img_placeholder;
        int p3 = (photos != null && photos.length >= 3) ? photos[2] : R.drawable.img_placeholder;

        if (photoUrls != null && photoUrls.length >= 3) {
            ImageLoader.loadImage(photoUrls[0], photo1, p1);
            ImageLoader.loadImage(photoUrls[1], photo2, p2);
            ImageLoader.loadImage(photoUrls[2], photo3, p3);
        } else {
            photo1.setImageResource(p1);
            photo2.setImageResource(p2);
            photo3.setImageResource(p3);
        }

        return view;
    }
}
