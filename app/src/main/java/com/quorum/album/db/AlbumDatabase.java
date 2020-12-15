package com.quorum.album.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.quorum.album.db.album.AlbumDao;
import com.quorum.album.db.album.AlbumEntity;

@Database(entities = {AlbumEntity.class}, version = 1)
public abstract class AlbumDatabase extends RoomDatabase
{

    public static final String DATABASE_NAME = "album_db";

    public abstract AlbumDao albumDao();
}