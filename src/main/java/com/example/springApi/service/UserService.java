package com.example.springApi.service;

import com.example.springApi.api.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

   private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            userList.add(UserBuilder.buildUser());
        }
    }

    public List<User> getAllUsers (){
        return userList;
    }

//    public Optional<User> getUserIF(Integer id) {
//        Optional<User> optional = Optional.empty();
//        for (User user: userList) {
//            if(id == user.getId()){
//                optional = Optional.of(user);
//                return optional;
//            }
//        }
//        return optional;
//    }

    public Optional<User> getUser(Integer id) {
        return userList.stream().filter(user -> id.equals(user.getId())).findFirst();
    }
}