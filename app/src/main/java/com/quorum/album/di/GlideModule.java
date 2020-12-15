package com.quorum.album.di;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.quorum.album.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Module
@InstallIn(ApplicationComponent.class)
public class GlideModule
{

    @Singleton
    @Provides
    public RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.mipmap.ic_place_holder)
                .error(R.drawable.ic_error);
    }

    @Singleton
    @Provides
    public RequestManager provideGlideInstance(@ApplicationContext Context context, RequestOptions requestOptions) {
        return Glide.with(context)
                .setDefaultRequestOptions(requestOptions);
    }
}
