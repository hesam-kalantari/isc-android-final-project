package com.quorum.album;

import android.app.Application;

import com.quorum.album.common.ReleaseTree;

import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

@HiltAndroidApp
public class AlbumApplication extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();

        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
        else
            Timber.plant(new ReleaseTree());
    }
}
