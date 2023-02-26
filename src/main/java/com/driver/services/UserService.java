package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User user = new User(username, password);

        userRepository3.save(user);

        return user;
    }

    public void deleteUser(int userId){
        if(userRepository3.findById(userId)==null){
            return;
        }
        User user = userRepository3.findById(userId).get();
        userRepository3.delete(user);

    }

    public User updateUser(Integer id, String password){
        User user = userRepository3.findById(id).get();
        user.setPassword(password);
        userRepository3.save(user);
        return  user;

    }
}
