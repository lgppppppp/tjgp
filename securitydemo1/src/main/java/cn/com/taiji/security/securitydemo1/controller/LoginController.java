package cn.com.taiji.security.securitydemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: securitydemo1
 * @description:
 * @author: lgppppppp
 * @create: 2019-08-01 18:52
 **/
@Controller
public class LoginController {
    @GetMapping("/myLogin")
    public String login(){
        return "myLogin";
    }
}
