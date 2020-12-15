package com.quorum.album.common.exception;

import java.io.IOException;

public abstract class ServiceCallException extends IOException
{

    public ServiceCallException(String message)
    {
        super(message);
    }
}
