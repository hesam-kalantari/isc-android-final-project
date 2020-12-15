package com.quorum.album.domain.mapper;

import com.quorum.album.db.album.AlbumEntity;
import com.quorum.album.domain.model.Album;
import com.quorum.album.network.api.album.AlbumResponseData;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AlbumMapper
{

    Album fromResponseData(final AlbumResponseData dto);

    List<Album> fromResponseData(final List<AlbumResponseData> dtoList);

    AlbumEntity toEntity(final Album album);
}
