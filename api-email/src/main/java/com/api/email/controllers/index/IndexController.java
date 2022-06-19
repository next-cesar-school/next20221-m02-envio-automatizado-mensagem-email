package com.api.email.controllers.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public ModelAndView  index(){
        ModelAndView mv = new ModelAndView(); 
        mv.setViewName("index");
        return mv;    
    }
}