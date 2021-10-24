package com.example.exam24_10_21.service.user;

import com.example.exam24_10_21.model.entity.User;
import com.example.exam24_10_21.model.service.UserServiceModel;
import com.example.exam24_10_21.repository.UserRepository;
import com.example.exam24_10_21.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void initUsers() {
        if(userRepository.count() != 0) {
            return;
        }

        User admin = new User();
        admin.setUsername("admin");
        admin.setFullName("Admin Admins");
        admin.setPassword("1234");
        admin.setEmail("admin@email.com");

        userRepository.save(admin);
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

}
