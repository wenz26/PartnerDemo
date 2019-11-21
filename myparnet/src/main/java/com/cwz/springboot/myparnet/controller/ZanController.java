package com.cwz.springboot.myparnet.controller;

import com.cwz.springboot.myparnet.entity.User;
import com.cwz.springboot.myparnet.entity.Zan;
import com.cwz.springboot.myparnet.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ZanController{

    @Autowired
    private ZanService zanService;

    @GetMapping("/findUser")
    public String findUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(zanService.findUser(user.getUsername())){
            return "success";
        } else {
            return "false";
        }
    }

    @GetMapping("/addUser")
    public Integer addUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        Zan zan = new Zan();
        zan.setUsername(user.getUsername());
        return zanService.addUser(zan);
    }

    @GetMapping("/deleteUser")
    public Integer deleteUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        return zanService.deleteUser(user.getUsername());
    }

    @GetMapping("/getCount")
    public Integer getCount(Zan zan){
        return zanService.getCount(zan);
    }

    @GetMapping("/getZan")
    public List<Zan> getZan(){
        return zanService.getZan();
    }
}
