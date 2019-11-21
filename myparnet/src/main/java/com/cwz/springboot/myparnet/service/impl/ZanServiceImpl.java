package com.cwz.springboot.myparnet.service.impl;

import com.cwz.springboot.myparnet.entity.Zan;
import com.cwz.springboot.myparnet.mapper.ZanMapper;
import com.cwz.springboot.myparnet.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("zanService")
public class ZanServiceImpl implements ZanService {
    @Autowired
    private ZanMapper zanMapper;

    @Override
    public boolean findUser(String username) {
        Example example = new Example(Zan.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        if (zanMapper.selectOneByExample(example) != null){
            return true;
        }
        return false;
    }
    @Override
    public int addUser(Zan zan) {
        return zanMapper.insert(zan);
    }

    @Override
    public int deleteUser(String username) {
        Example example = new Example(Zan.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        return zanMapper.deleteByExample(example);
    }

    @Override
    public int getCount(Zan zan) {
        return zanMapper.selectCount(zan);
    }

    @Override
    public List<Zan> getZan() {
        return zanMapper.selectAll();
    }
}
