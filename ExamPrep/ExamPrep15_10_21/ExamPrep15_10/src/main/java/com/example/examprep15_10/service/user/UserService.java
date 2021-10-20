package com.example.examprep15_10.service.user;

import com.example.examprep15_10.model.entity.user.User;
import com.example.examprep15_10.model.service.UserServiceModel;
import com.example.examprep15_10.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel > findAllUsersAndOrderCountDesc();
}
