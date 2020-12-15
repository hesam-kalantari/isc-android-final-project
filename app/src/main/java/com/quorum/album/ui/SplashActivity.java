package com.quorum.album.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.quorum.album.R;
import com.quorum.album.databinding.ActivitySplashBinding;
import com.quorum.album.domain.Result;
import com.quorum.album.domain.model.Album;
import com.quorum.album.repository.AlbumRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SplashActivity extends AppCompatActivity
{

    private ActivitySplashBinding binding;

    @Inject
    RequestManager glideInstance;

    @Inject
    AlbumRepository albumRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        }, 2000);
    }
}
