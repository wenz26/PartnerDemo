package com.cwz.springboot.myparnet.mapper;

import com.cwz.springboot.myparnet.entity.Comment;
import com.cwz.springboot.myparnet.mapper.bean.BeanMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper extends BeanMapper<Comment> {

    List<Comment> findAllComment();

}
