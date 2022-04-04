package com.example.rest.Service;

import com.example.rest.Models.Role;
import com.example.rest.Models.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);

    User getUser(String username);
    List<User> getUsers();
}
