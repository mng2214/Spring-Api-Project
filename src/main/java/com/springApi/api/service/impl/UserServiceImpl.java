package com.springApi.api.service.impl;

import com.springApi.api.model.User;
import com.springApi.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {

    @Override
    public void save(User obj) {
        super.save(obj.getId(), obj);
    }

    @Override
    public User findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<User> findAll() {
        return super.findAll();
    }

}