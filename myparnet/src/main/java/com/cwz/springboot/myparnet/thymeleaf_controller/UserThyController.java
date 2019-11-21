package com.cwz.springboot.myparnet.thymeleaf_controller;

import com.alibaba.fastjson.JSONObject;
import com.cwz.springboot.myparnet.entity.User;
import com.cwz.springboot.myparnet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class UserThyController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/thyLogin")
    public String findUser(User user, HttpSession session, Model model,
                           HttpServletResponse response) {
        logger.info(JSONObject.toJSONString("用户的角色：" + user.getRole()));
        User findUser = userService.findUser(user.getUsername(), user.getPassword());
        if (findUser != null) {
            session.setAttribute("user", findUser);
            logger.info(JSONObject.toJSONString(session.getAttribute("user")));
            logger.info(JSONObject.toJSONString(session.getId()));
            response.addCookie(new Cookie("JSSESIONID", session.getId()));

            if (!Objects.equals(findUser.getRole(), user.getRole())) {
                return "redirect:/";
            }
            if (Objects.equals(findUser.getRole(), "1")) {
                return "redirect:/tourist_index";
            } else {
                return "redirect:/admin";
            }
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/thyAddUser")
    public String addUser(User user) {
        if (user.getUsername() == null || Objects.equals(user.getUsername(), "") ||
                user.getPassword() == null || Objects.equals(user.getPassword(), "")) {
            return "register";
        }
        userService.addUser(user);
        return "index";
    }

    @GetMapping("/thyOutLogin")
    public String outLogin(HttpSession session) {
        logger.info(JSONObject.toJSONString(session.getAttribute("user")));
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/thyAddimp")
    public String addimp(User user, HttpSession session) {
        logger.info("前端传过来的数据：" + JSONObject.toJSONString(user));
        User findUser = (User) session.getAttribute("user");
        logger.info(JSONObject.toJSONString(findUser));
        Integer id = findUser.getId();
        user.setId(id);
        if (Objects.equals(user.getBeforeschool(),"")) {
            user.setBeforeschool(null);
        } if (Objects.equals(user.getKindergarten(),"")) {
            user.setKindergarten(null);
        } if (Objects.equals(user.getPrimaryschool(),"")) {
            user.setPrimaryschool(null);
        } if (Objects.equals(user.getMiddleschool(),"")) {
            user.setMiddleschool(null);
        } if (Objects.equals(user.getHighschool(),"")) {
            user.setHighschool(null);
        } if (Objects.equals(user.getUniversity(),"")) {
            user.setUniversity(null);
        }
        userService.addimp(user, id);
        User newUser = userService.findUser(findUser.getUsername(), findUser.getPassword());
        session.setAttribute("user", newUser);
        return "impression";
    }

}
