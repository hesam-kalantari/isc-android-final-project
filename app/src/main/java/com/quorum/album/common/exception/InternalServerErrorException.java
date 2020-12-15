package com.quorum.album.common.exception;

public class InternalServerErrorException extends ServiceCallException
{

    public InternalServerErrorException()
    {
        super("Internal server error!");
    }
}
