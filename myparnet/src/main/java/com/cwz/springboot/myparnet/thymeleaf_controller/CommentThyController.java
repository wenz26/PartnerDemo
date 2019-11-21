package com.cwz.springboot.myparnet.thymeleaf_controller;

import com.cwz.springboot.myparnet.entity.Comment;
import com.cwz.springboot.myparnet.entity.User;
import com.cwz.springboot.myparnet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class CommentThyController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/thyComment")
    public String findAllComment(Model model){
        List<Comment> allComment = commentService.findAllComment();
        model.addAttribute("comments", allComment);
        return "growup";
    }

    @GetMapping("/thyCommentToAdmin")
    public String findAllCommentToAdmin(Model model){
        List<Comment> allComment = commentService.findAllComment();
        model.addAttribute("comments", allComment);
        return "admin";
    }

    @PostMapping("/thyAdd")
    public String addComment(Comment comment, HttpSession session){
        User sessionUser = (User) session.getAttribute("user");
        if (Objects.equals(comment.getComment(), "") || comment.getComment() == null){
            return "redirect:/thyComment";
        }
        comment.setUserid(sessionUser.getId());
        commentService.addComment(comment);
        return "redirect:/thyComment";
    }
}
