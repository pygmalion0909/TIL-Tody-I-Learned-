package com.example.springshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController{

  @RequestMapping("hello")
  public String Hello(Model model){
    model.addAttribute("data", "동적페이지 입니다!");
    return "hello";
  }
  
}