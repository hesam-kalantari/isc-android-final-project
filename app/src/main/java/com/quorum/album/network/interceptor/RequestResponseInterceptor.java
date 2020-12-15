package com.quorum.album.network.interceptor;

import com.quorum.album.network.interceptor.impl.HeaderInterceptor;
import com.quorum.album.network.interceptor.impl.ResponseStatusInterceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestResponseInterceptor implements Interceptor
{

    private final HeaderInterceptor headerInterceptor;
    private final ResponseStatusInterceptor responseStatusInterceptor;

    @Inject
    public RequestResponseInterceptor(HeaderInterceptor headerInterceptor, ResponseStatusInterceptor responseStatusInterceptor)
    {
        this.headerInterceptor = headerInterceptor;
        this.responseStatusInterceptor = responseStatusInterceptor;
    }

    @Override
    public @NotNull Response intercept(@NotNull Chain chain) throws IOException
    {
        Request request = chain.request();

        request = headerInterceptor.intercept(request);

        Response response = chain.proceed(request);
        response = responseStatusInterceptor.intercept(response);

        return response;
    }
}
