package com.test.springbootfirstweb.controller;

import com.test.springbootfirstweb.model.User;
import com.test.springbootfirstweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userInsert")
    public String userInsert(User user){
        try{
            if(userService.insertUser(user)!=0){
                return "redirect:/ok";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "error";
    }


    @GetMapping("/findUserAll")
    public String findUserAll(Model model){
        try{
            List<User> list = userService.findUserAll();
            model.addAttribute("list",list);
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "findUserAll";
    }

    @RequestMapping("/preUser")
    public String preDealData(String id,Model model){
        try{
            System.out.println("1231321");
            User user = userService.findUser(id);
            model.addAttribute("user",user);
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "preDealData";
    }


    @RequestMapping("/updateUser")
    public String updateUser(User user){
        try{
            if(userService.updateUser(user)!=0){
                return "redirect:/ok";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "error";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(String id){
        try{
            if(userService.deleteUser(id)!=0){
                return "redirect:/ok";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "error";
    }
}
