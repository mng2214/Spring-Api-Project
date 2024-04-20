package com.springApi.api.service;

import com.springApi.api.model.User;

import java.util.List;

public interface CrudService<T, ID> {

    T save(T obj);

    T findById(ID id);

    List<T> findAll();

    T deleteById(ID id);
}
