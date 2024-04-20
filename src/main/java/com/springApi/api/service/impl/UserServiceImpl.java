package com.springApi.api.service.impl;

import com.springApi.api.model.User;
import com.springApi.api.service.UserService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {

    @Override
    public User save(User obj) {
        return super.save(obj.getId(), obj);
    }

    @Override
    public User findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<User> findAll() {
        return super.findAll();
    }

    @Override
    public User deleteById(Integer id) {
        return map.remove(id);
    }

    @Override
    public User update(Integer integer, User sourceUser) {
        User user = findById(integer);

        user.updateFields(sourceUser);


        return save(user.getId(), user);
    }

}
