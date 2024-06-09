package com.mycompany.dvdstore.dvdstore_web.controller;

import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class AboutController {

    @Autowired
    private MovieServiceInterface movieService;

    @RequestMapping("/about-us")
    public String displayHome (){
        return "about-us";
    }
}
