package ua.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ua.kpi.facade.ApplicationFacade;


@Controller
public class ApplicationController {

    @Autowired
    private ApplicationFacade applicationFacade;

    @GetMapping({"/home", "/"})
    public String home() {
        return "home";
    }


}
