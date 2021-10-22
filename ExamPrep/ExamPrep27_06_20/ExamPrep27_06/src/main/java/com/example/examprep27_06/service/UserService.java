package com.example.examprep27_06.service;

import com.example.examprep27_06.model.entity.User;
import com.example.examprep27_06.model.service.UserServiceModel;

public interface UserService {

    void initUsers();

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    void loginUser(Long id, String username);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User findById(Long id);
}
