package com.cwz.springboot.myparnet.service;

import com.cwz.springboot.myparnet.entity.User;

public interface UserService {

    User findUser(String username, String password);

    int addUser(User user);

    int addimp(User user, Integer id);
}
