package com.quorum.album.network.interceptor;

import java.io.IOException;

import okhttp3.Response;

public interface ResponseInterceptor
{
    Response intercept(final Response response) throws IOException;
}
