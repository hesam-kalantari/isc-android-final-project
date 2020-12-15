package com.quorum.album.domain;

public interface Result<T>
{
    void success(final T result);
    void error(final String message);
}
