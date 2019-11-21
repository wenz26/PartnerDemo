package com.cwz.springboot.myparnet.controller;

import com.cwz.springboot.myparnet.entity.Comment;
import com.cwz.springboot.myparnet.entity.User;
import com.cwz.springboot.myparnet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public int addComment(@RequestBody Comment comment, HttpSession session){
        User sessionUser = (User) session.getAttribute("user");
        if (Objects.equals(comment.getComment(), "") || comment.getComment() == null){
            return 0;
        }
        comment.setUserid(sessionUser.getId());
        return commentService.addComment(comment);
    }

    @GetMapping("/comment")
    public List<Comment> findAllComment(){
        return commentService.findAllComment();
    }

}
