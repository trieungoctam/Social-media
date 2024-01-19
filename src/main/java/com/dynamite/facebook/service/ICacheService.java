package com.dynamite.facebook.service;

import com.dynamite.facebook.exception.ResponseException;

public interface ICacheService<T> {
    T getBackendData(Long key) throws ResponseException;
}
