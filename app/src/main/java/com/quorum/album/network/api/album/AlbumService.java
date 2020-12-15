package com.quorum.album.network.api.album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AlbumService
{

    @GET("Album")
    Call<List<AlbumResponseData>> getAlbums();
}
