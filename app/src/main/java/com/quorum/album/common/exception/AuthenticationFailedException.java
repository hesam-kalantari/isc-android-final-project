package com.quorum.album.common.exception;

public class AuthenticationFailedException extends ServiceCallException
{

    public AuthenticationFailedException()
    {
        super("Failed to login");
    }
}
