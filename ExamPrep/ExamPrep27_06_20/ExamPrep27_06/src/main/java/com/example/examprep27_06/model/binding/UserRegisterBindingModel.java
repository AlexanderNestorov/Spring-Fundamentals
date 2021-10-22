package com.example.examprep27_06.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String email;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @NotNull(message = "Username cannot be null!")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "Password cannot be null!")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "Email cannot be empty!")
    @Email(message = "Must be a valid email!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Confirm Password cannot be null!")
    @Size(min = 3, max = 20, message = "Confirm Password must be between 3 and 20 characters!")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
