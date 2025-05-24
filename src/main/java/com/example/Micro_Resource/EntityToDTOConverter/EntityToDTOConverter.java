package com.example.Micro_Resource.EntityToDTOConverter;

import com.example.Micro_Resource.Entity.Student;

import java.util.Optional;

public interface EntityToDTOConverter<T,K> {

    public Optional<K> getDTOAsFull(T t);
}
