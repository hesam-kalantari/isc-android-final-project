package com.quorum.album.di;

import com.quorum.album.domain.mapper.AlbumMapper;

import org.mapstruct.factory.Mappers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class MapperModule
{

    @Singleton
    @Provides
    public AlbumMapper provideAlbumMapper()
    {
        return Mappers.getMapper(AlbumMapper.class);
    }
}
