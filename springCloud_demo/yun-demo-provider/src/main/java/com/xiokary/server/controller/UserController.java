package com.xiokary.server.controller;

import com.xiokary.server.domain.User;
import com.xiokary.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("{id}")
    public User findUserById(@PathVariable("id") Integer id){
        /*try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userService.findUserById(id);
    }

}
