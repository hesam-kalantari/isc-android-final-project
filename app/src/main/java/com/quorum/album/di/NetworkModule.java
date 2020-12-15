package com.quorum.album.di;

import com.quorum.album.network.api.album.AlbumService;
import com.quorum.album.network.interceptor.RequestResponseInterceptor;
import com.quorum.album.network.interceptor.impl.HeaderInterceptor;
import com.quorum.album.network.interceptor.impl.ResponseStatusInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule
{

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient(final RequestResponseInterceptor interceptor) {

        final int CONNECT_TIMEOUT_SEC = 10 * 60;
        final int READ_TIMEOUT_SEC = 10 * 60;

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS);
        builder.addInterceptor(interceptor);
        return builder.build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(final OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl("https://iscandroiddemodb-4944.restdb.io/rest/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public AlbumService provideAlbumService(final Retrofit retrofit) {
        return retrofit.create(AlbumService.class);
    }
}
