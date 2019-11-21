package com.cwz.springboot.myparnet.service.impl;

import com.cwz.springboot.myparnet.entity.Comment;
import com.cwz.springboot.myparnet.mapper.CommentMapper;
import com.cwz.springboot.myparnet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int addComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public List<Comment> findAllComment() {
        return commentMapper.findAllComment();
    }
}
