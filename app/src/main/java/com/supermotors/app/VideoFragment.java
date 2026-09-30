package com.supermotors.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    private static final String ARG_BIKE = "arg_bike";
    private Bike bike;
    private WebView webView;
    private ImageView imgThumbnail;
    private View btnPlay;

    public static VideoFragment newInstance(Bike bike) {
        VideoFragment fragment = new VideoFragment();
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
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        if (bike == null && !BikeRepository.getBikes().isEmpty()) {
            bike = BikeRepository.getBikes().get(0);
        }

        if (bike == null) return view;

        TextView txtBadge = view.findViewById(R.id.txt_video_bike_badge);
        TextView txtDuration = view.findViewById(R.id.txt_video_duration);
        TextView txtTitle = view.findViewById(R.id.txt_video_title);
        TextView txtPower = view.findViewById(R.id.txt_power_telemetry);
        TextView txtSpeed = view.findViewById(R.id.txt_speed_telemetry);
        TextView txtAccel = view.findViewById(R.id.txt_accel_value);

        imgThumbnail = view.findViewById(R.id.img_video_thumbnail);
        webView = view.findViewById(R.id.web_video_player);
        btnPlay = view.findViewById(R.id.btn_play_video);
        Button btnOpenBrowser = view.findViewById(R.id.btn_open_external_video);
        Button btnShareVideo = view.findViewById(R.id.btn_share_video);

        // Bind data
        txtBadge.setText(bike.getName() + " · " + bike.getType() + " (" + bike.getYear() + ")");
        txtDuration.setText(bike.getVideoDuration() != null ? bike.getVideoDuration() : "04:30 min");
        txtTitle.setText(bike.getVideoTitle() != null ? bike.getVideoTitle() : "Test Drive Oficial & Telemetría en Circuito");
        txtPower.setText(bike.getPower() != null ? bike.getPower().split("@")[0].trim() : "200 CV");
        txtSpeed.setText(bike.getTopSpeed() != null ? bike.getTopSpeed() : "299 km/h");

        // Set estimated acceleration based on bike type
        if ("Deportiva".equalsIgnoreCase(bike.getType())) {
            txtAccel.setText("~3.1 seg");
        } else if ("Hyperbike".equalsIgnoreCase(bike.getType())) {
            txtAccel.setText("~2.6 seg");
        } else {
            txtAccel.setText("~2.8 seg");
        }

        // Set thumbnail image
        if (bike.getMainImageUrl() != null && !bike.getMainImageUrl().isEmpty()) {
            ImageLoader.loadImage(bike.getMainImageUrl(), imgThumbnail, bike.getImageResId());
        } else {
            imgThumbnail.setImageResource(bike.getImageResId());
        }

        // Setup WebView for inline video playback
        setupWebView();

        // Play action (start inline video or open YouTube)
        btnPlay.setOnClickListener(v -> playVideoInline());

        // Open external video
        btnOpenBrowser.setOnClickListener(v -> openExternalVideo());

        // Share video
        btnShareVideo.setOnClickListener(v -> shareVideo());

        return view;
    }

    private void setupWebView() {
        if (webView == null) return;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
    }

    private void playVideoInline() {
        if (bike == null) return;
        String videoUrl = bike.getVideoUrl();
        if (videoUrl == null || videoUrl.isEmpty()) {
            openExternalVideo();
            return;
        }

        // Convert watch?v= to embed/ if needed
        String embedUrl = videoUrl;
        if (embedUrl.contains("watch?v=")) {
            embedUrl = embedUrl.replace("watch?v=", "embed/");
        }

        String html = "<!DOCTYPE html><html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><style>body{margin:0;padding:0;background:#000;display:flex;justify-content:center;align-items:center;height:100vh;}iframe{width:100%;height:100%;border:none;}</style></head><body><iframe src=\"" 
                + embedUrl + "?autoplay=1&controls=1&modestbranding=1\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></body></html>";

        imgThumbnail.setVisibility(View.GONE);
        btnPlay.setVisibility(View.GONE);
        webView.setVisibility(View.VISIBLE);
        webView.loadDataWithBaseURL("https://www.youtube.com", html, "text/html", "utf-8", null);

        Toast.makeText(getContext(), "Cargando cápsula de video de " + bike.getName(), Toast.LENGTH_SHORT).show();
    }

    private void openExternalVideo() {
        if (bike == null) return;
        String url = bike.getVideoUrl();
        if (url == null || url.isEmpty()) {
            url = "https://www.youtube.com/results?search_query=" + Uri.encode(bike.getName() + " top speed test drive");
        }
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), "No se pudo abrir el navegador", Toast.LENGTH_SHORT).show();
        }
    }

    private void shareVideo() {
        if (bike == null) return;
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareBody = "🎬 ¡Mira este increíble video de la " + bike.getName() + "!\n\n"
                + "🏁 " + bike.getVideoTitle() + "\n"
                + "⚡ Potencia: " + bike.getPower() + "\n"
                + "🚀 Velocidad Máxima: " + bike.getTopSpeed() + "\n\n"
                + "Enlace del video: " + bike.getVideoUrl() + "\n\n"
                + "Compartido desde SuperMotors App 🏍️";
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Video de " + bike.getName());
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(shareIntent, "Compartir Video"));
    }

    @Override
    public void onDestroyView() {
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroyView();
    }
}
