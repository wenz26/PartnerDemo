package com.cwz.springboot.myparnet.service;

import com.cwz.springboot.myparnet.entity.Comment;

import java.util.List;

public interface CommentService {

    int addComment(Comment comment);

    List<Comment> findAllComment();

}
