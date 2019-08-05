package cn.com.taiji.security.securitydemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: securitydemo1
 * @description:
 * @author: lgppppppp
 * @create: 2019-08-01 23:21
 **/
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @ResponseBody
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
}
