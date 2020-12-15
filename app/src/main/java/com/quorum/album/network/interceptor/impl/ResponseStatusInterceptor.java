package com.quorum.album.network.interceptor.impl;

import com.quorum.album.common.exception.AuthenticationFailedException;
import com.quorum.album.common.exception.BadRequestException;
import com.quorum.album.common.exception.InternalServerErrorException;
import com.quorum.album.network.interceptor.ResponseInterceptor;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Response;

public class ResponseStatusInterceptor implements ResponseInterceptor
{
    @Inject
    public ResponseStatusInterceptor() { }

    @Override
    public Response intercept(Response response) throws IOException
    {
        if (response.isSuccessful())
            return response;

        if (response.code() > 499)
            throw new InternalServerErrorException();

        if (response.code() == 401)
            throw new AuthenticationFailedException();

        throw new BadRequestException();
    }
}
