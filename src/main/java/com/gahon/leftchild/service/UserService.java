package com.gahon.leftchild.service;

import com.gahon.leftchild.core.Service;
import com.gahon.leftchild.model.User;

import java.util.Map;


/**
 * @author Gahon
 * @date 2018/11/17.
 */
public interface UserService extends Service<User> {
    User findByUserName(String username);
    String login(String username, String password);
}
