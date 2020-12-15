package com.quorum.album.di;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class ExecutorModule
{

    @Singleton
    @Provides
    @Named("networkIO")
    public Executor provideNetworkThread() {
        return Executors.newSingleThreadExecutor();
    }

    @Singleton
    @Provides
    @Named("diskIO")
    public Executor provideDiskThread() {
        return Executors.newSingleThreadExecutor();
    }

    @Singleton
    @Provides
    @Named("mainThread")
    public Executor provideMainThread() {
        return new MainThreadExecutor();
    }

    private static class MainThreadExecutor implements Executor {

        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
