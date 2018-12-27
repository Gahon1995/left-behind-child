package com.gahon.leftchild.service.impl;

import com.gahon.leftchild.model.User;
import com.gahon.leftchild.core.AbstractService;
import com.gahon.leftchild.core.ServiceException;
import com.gahon.leftchild.dao.UserMapper;
import com.gahon.leftchild.service.UserService;
import com.gahon.leftchild.utils.Constants;
import com.gahon.leftchild.utils.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        example.createCriteria().andCondition("lower(username)=", username.toLowerCase());
        List<User> list = userMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public String login(String username, String password) {
        String token = "";
        User user = findByUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            token = JwtUtils.createJWT(user.getUid().toString(), user.getUsername(), Constants.JWT_TTL);
        }
        return token;
    }
}
