package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.bean.User;
import com.gahon.leftchild.core.AbstractService;
import com.gahon.leftchild.core.ServiceException;
import com.gahon.leftchild.dao.UserMapper;
import com.gahon.leftchild.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;


/**
 * @author Gahon
 * @date 2018/11/17.
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User findByUserName(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", username);
        return userMapper.selectOneByExample(example);
    }


}
