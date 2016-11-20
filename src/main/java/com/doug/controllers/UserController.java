package com.doug.controllers;

import com.doug.commands.UserCommand;
import com.doug.domain.User;
import com.doug.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", userService.listAllUsers());
        return "user/users";
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model){
        model.addAttribute("User", userService.getById(id));
        return "usershow";
    }

    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("User", userService.getById(id));
        model.addAttribute("UserCommand", new UserCommand());

        return "useredit";
    }

    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Integer id){
        userService.delete(id);

        return "redirect:/user/list";
    }

    @RequestMapping(value = "user/new", method = RequestMethod.GET)
    public String newUser(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("userCommand", new UserCommand());


        return "user/userformnew";
    }

    @RequestMapping(value = "/doUser", method = RequestMethod.POST)
    public String doUser(@Valid UserCommand UserCommand, BindingResult bindingResult,
                         User user){

        if (bindingResult.hasErrors()) {
            return "userformnew";
        }

        User UserSql = userService.saveOrUpdateUser(user);

        return "redirect:/user/" + user.getId();

    }

}
