package com.example.examprep21_02.service;

import com.example.examprep21_02.model.entity.User;
import com.example.examprep21_02.model.service.UserServiceModel;

public interface UserService {

    void initAdmin();

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    void loginUser(Long id, String username);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User findById(Long id);
}
