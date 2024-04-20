package com.springApi.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    T findById(ID id) {
        return map.get(id);
    }

    List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    T delete(ID id) {
        return map.remove(id);
    }


}
