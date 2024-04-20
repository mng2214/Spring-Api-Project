package com.springApi.api.service;

import java.util.List;

public interface CrudService<T, ID> {

    void save(T obj);

    T findById(ID id);

    List<T> findAll();
}
