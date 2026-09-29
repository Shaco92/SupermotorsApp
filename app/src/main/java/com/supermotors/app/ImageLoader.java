package com.supermotors.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoader {
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static void loadImage(String urlString, ImageView imageView, int placeholderResId) {
        if (urlString == null || urlString.isEmpty()) {
            if (placeholderResId != 0) {
                imageView.setImageResource(placeholderResId);
            }
            return;
        }

        imageView.setTag(urlString);

        executor.execute(() -> {
            Bitmap bitmap = downloadBitmap(urlString);
            handler.post(() -> {
                if (urlString.equals(imageView.getTag())) {
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    } else if (placeholderResId != 0) {
                        imageView.setImageResource(placeholderResId);
                    }
                }
            });
        });
    }

    private static Bitmap downloadBitmap(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android; Mobile)");
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
