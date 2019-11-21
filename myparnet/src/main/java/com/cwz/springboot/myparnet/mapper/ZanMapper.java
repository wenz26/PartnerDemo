package com.cwz.springboot.myparnet.mapper;

import com.cwz.springboot.myparnet.entity.Zan;
import com.cwz.springboot.myparnet.mapper.bean.BeanMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ZanMapper extends BeanMapper<Zan> {
}
