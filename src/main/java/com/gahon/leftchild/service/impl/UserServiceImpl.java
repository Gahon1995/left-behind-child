package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.dao.UserMapper;
import com.gahon.leftchild.model.User;
import com.gahon.leftchild.service.UserService;
import com.gahon.leftchild.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author Gahon
 * @date 2018/11/17.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
