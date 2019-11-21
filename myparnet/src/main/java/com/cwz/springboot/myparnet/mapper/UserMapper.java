package com.cwz.springboot.myparnet.mapper;

import com.cwz.springboot.myparnet.entity.User;
import com.cwz.springboot.myparnet.mapper.bean.BeanMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BeanMapper<User> {

}
