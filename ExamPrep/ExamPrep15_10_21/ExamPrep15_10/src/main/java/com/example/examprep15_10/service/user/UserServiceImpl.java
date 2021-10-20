package com.example.examprep15_10.service.user;

import com.example.examprep15_10.model.entity.user.User;
import com.example.examprep15_10.model.service.UserServiceModel;
import com.example.examprep15_10.model.view.UserViewModel;
import com.example.examprep15_10.repository.user.UserRepository;
import com.example.examprep15_10.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserViewModel> findAllUsersAndOrderCountDesc() {
        return userRepository.findAllByOrderByOrdersDescending()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setOrderCount(user.getOrders().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
