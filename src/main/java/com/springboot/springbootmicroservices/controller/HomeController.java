package com.springboot.springbootmicroservices.controller;
import com.springboot.springbootmicroservices.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Hello world!";
    }
    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setId("001");
        user.setName("chandan");
        user.setEmailId("chandankeshri74@gmail.com");
        return user;
    }
    @GetMapping("/{id}")
    public String pathVariable(@PathVariable String id){
        return "The path variable is : "+id;
    }
}
