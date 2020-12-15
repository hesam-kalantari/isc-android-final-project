package com.quorum.album.network.interceptor;

import java.io.IOException;

import okhttp3.Request;

public interface RequestInterceptor
{
    Request intercept(final Request request) throws IOException;
}
