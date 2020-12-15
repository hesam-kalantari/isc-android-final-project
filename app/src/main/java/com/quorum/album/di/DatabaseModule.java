package com.quorum.album.di;

import android.content.Context;

import androidx.room.Room;

import com.quorum.album.db.AlbumDatabase;
import com.quorum.album.db.album.AlbumDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule
{

    @Singleton
    @Provides
    public AlbumDatabase provideAlbumDatabase(@ApplicationContext Context context) {
        return Room
                .databaseBuilder(context, AlbumDatabase.class, AlbumDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    public AlbumDao provideAlbumDao(final AlbumDatabase albumDatabase) {
        return albumDatabase.albumDao();
    }
}
