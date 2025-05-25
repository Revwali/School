package com.example.Micro_Resource.EntityToDTOConverter;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface EntityToDTOConverter<T,K> {

    public Optional<K> getDTOAsBasic(T t);
    public Optional<List<K>> getAllDTOAsBasic(Iterator<T> t);
    
}
