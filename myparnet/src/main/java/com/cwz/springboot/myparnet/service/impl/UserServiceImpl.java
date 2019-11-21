package com.cwz.springboot.myparnet.service.impl;

import com.cwz.springboot.myparnet.entity.User;
import com.cwz.springboot.myparnet.mapper.UserMapper;
import com.cwz.springboot.myparnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(String username, String password) {
        Example userExample = new Example(User.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", password);
        return userMapper.selectOneByExample(userExample);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int addimp(User user, Integer id) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return userMapper.updateByExampleSelective(user, example);
    }
}
