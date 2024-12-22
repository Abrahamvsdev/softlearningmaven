package com.core.appservices.serializers;

import com.core.entities.exceptions.ServiceException;

public interface Serializer<T> {
    public String serialize(T object)throws ServiceException;
    public T deserialize(String source, Class<T> object)throws ServiceException;
}
