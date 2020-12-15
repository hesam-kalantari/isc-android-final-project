package com.quorum.album.network.interceptor.impl;

import com.quorum.album.network.interceptor.RequestInterceptor;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Request;

public class HeaderInterceptor implements RequestInterceptor
{

    @Inject
    public HeaderInterceptor() { }

    @Override
    public Request intercept(Request request) throws IOException
    {
        Request.Builder requestBuilder = request.newBuilder();
//        requestBuilder.header("Content-Type", "application/json");
        requestBuilder.header("x-apikey", "46462fb8d79c61e0f75488729aa5f7d310ad2");

        return requestBuilder.build();
    }
}
