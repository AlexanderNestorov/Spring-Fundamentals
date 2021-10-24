package com.example.exam24_10_21.service.user;

import com.example.exam24_10_21.model.entity.User;
import com.example.exam24_10_21.model.service.UserServiceModel;

public interface UserService {

    void initUsers();

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);
}
