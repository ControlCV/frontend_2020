package com.zjw.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/admin"})
@ResponseBody
public class LoginController {

    @RequestMapping(value = {"login"})
    public String view(){
        return "11111";
    }
}
