package com.quorum.album.common.exception;

public class BadRequestException extends ServiceCallException
{

    public BadRequestException()
    {
        super("Bad request...!");
    }
}
