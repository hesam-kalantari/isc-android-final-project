package com.quorum.album.db.album;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlbumDao
{

    @Query("SELECT * FROM TLB_ALBUM")
    List<AlbumEntity> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(final AlbumEntity entity);
}
