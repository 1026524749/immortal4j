package com.immortal.immortal4j.controller;

import com.immortal.immortal4j.dao.UserRepository;
import com.immortal.immortal4j.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/4 21:28
 */

@RestController
public class HelloController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String hello(){
        return "hello spring boot";
    }

    @RequestMapping("/getUsers")
    @Cacheable(value="user-key")
    public User getUsers(){
        User user = userRepository.findByUserName("cc");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return  user;
    }
    @RequestMapping("/getSession")
    public String getSession(HttpSession session){
        return session.getAttribute("uid").toString();
    }
}
