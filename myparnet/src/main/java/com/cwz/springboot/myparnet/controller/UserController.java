package com.cwz.springboot.myparnet.controller;

import com.alibaba.fastjson.JSONObject;
import com.cwz.springboot.myparnet.entity.User;
import com.cwz.springboot.myparnet.service.UserService;
import com.cwz.springboot.myparnet.util.GetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
//@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/login")
    public String findUser(@RequestBody User user, HttpSession session,
                           HttpServletResponse response){
        logger.info(JSONObject.toJSONString("用户的角色：" + user.getRole()));
        JSONObject data = new JSONObject();
        User findUser = userService.findUser(user.getUsername(), user.getPassword());
        if (findUser != null) {
            session.setAttribute("user", findUser);
            logger.info(JSONObject.toJSONString(session.getAttribute("user")));
            logger.info(JSONObject.toJSONString(session.getId()));
            response.addCookie(new Cookie("JSSESIONID",session.getId()));

            if (!Objects.equals(findUser.getRole(), user.getRole())){
                data.put("result","false");
                return data.toJSONString();
            }
            if (Objects.equals(findUser.getRole(), "1")){
                data.put("result","success");
            }else {
                data.put("result","successToAdmin");
            }

        }else {
            data.put("result","false");
        }
        return data.toJSONString();
    }

    @GetMapping("/getUser")
    public User getUser(HttpSession session){

        logger.info(JSONObject.toJSONString(session.getAttribute("user")));
        logger.info(JSONObject.toJSONString(session.getId()));
        return (User) session.getAttribute("user");
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody User user){
        if(user.getUsername() == null || Objects.equals(user.getUsername(), "") ||
                user.getPassword() == null || Objects.equals(user.getPassword(), "")){
            return 0;
        }
        return userService.addUser(user);
    }

    @GetMapping("/outLogin")
    public void outLogin(HttpSession session){
        logger.info(JSONObject.toJSONString(session.getAttribute("user")));
        session.invalidate();
    }

    @PostMapping("/addimp")
    public int addimp(@RequestBody User user, HttpSession session){
        logger.info("前端传过来的数据：" + JSONObject.toJSONString(user));
        User findUser = (User) session.getAttribute("user");
        logger.info(JSONObject.toJSONString(findUser));
        Integer id = findUser.getId();
        user.setId(id);
        Integer row = userService.addimp(user, id);
        User newUser = userService.findUser(findUser.getUsername(), findUser.getPassword());
        session.setAttribute("user", newUser);
        return row;
    }
}
