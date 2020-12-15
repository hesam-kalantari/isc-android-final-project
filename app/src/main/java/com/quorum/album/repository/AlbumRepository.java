package com.quorum.album.repository;

import com.quorum.album.common.exception.ServiceCallException;
import com.quorum.album.db.album.AlbumDao;
import com.quorum.album.domain.Result;
import com.quorum.album.domain.model.Album;
import com.quorum.album.domain.mapper.AlbumMapper;
import com.quorum.album.network.api.album.AlbumResponseData;
import com.quorum.album.network.api.album.AlbumService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository
{

    private final AlbumService albumService;
    private final AlbumDao albumDao;
    private final AlbumMapper albumMapper;
    private final Executor diskIO;
    private final Executor mainThread;

    @Inject
    public AlbumRepository(
            final AlbumService albumService,
            final AlbumDao albumDao,
            final AlbumMapper albumMapper,
            final @Named("diskIO") Executor diskIO,
            final @Named("mainThread") Executor mainThread)
    {
        this.albumService = albumService;
        this.albumDao = albumDao;
        this.albumMapper = albumMapper;
        this.diskIO = diskIO;
        this.mainThread = mainThread;
    }

    public void getAllAlbums(final Result<List<Album>> callback) {
        this.albumService.getAlbums().enqueue(new Callback<List<AlbumResponseData>>()
        {
            @Override
            public void onResponse(final @NotNull Call<List<AlbumResponseData>> call, final @NotNull Response<List<AlbumResponseData>> response)
            {
                final List<Album> albums = albumMapper.fromResponseData(response.body());
                callback.success(albums);
            }

            @Override
            public void onFailure(@NotNull Call<List<AlbumResponseData>> call, @NotNull Throwable t)
            {
                if (t instanceof ServiceCallException)
                    callback.error(t.getMessage());
                else
                    callback.error("Unknown error");
            }
        });
    }
}
