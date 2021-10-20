package com.example.examprep21_02.service;

import com.example.examprep21_02.model.entity.Artist;
import com.example.examprep21_02.model.entity.ArtistNameEnum;
import com.example.examprep21_02.model.entity.User;
import com.example.examprep21_02.model.service.UserServiceModel;
import com.example.examprep21_02.repository.UserRepository;
import com.example.examprep21_02.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void initAdmin() {
        if (userRepository.count() != 0) {
            return;
        }
        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setUsername("Admin");
        user.setEmail("admin@email.com");
        user.setFullName("Admin Admins");
        user.setPassword("12345");

        userRepository.save(user);
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
