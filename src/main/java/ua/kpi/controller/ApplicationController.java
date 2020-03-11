package ua.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import ua.kpi.domain.CalculationResult;
import ua.kpi.dto.TwoOperandsDto;
import ua.kpi.facade.ApplicationFacade;


@Controller
public class ApplicationController {

    private static final String REDIRECT_RESULTS = "redirect:/results";

    @Autowired
    private ApplicationFacade applicationFacade;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @PutMapping("/results/{id}")
    @SuppressWarnings("squid:S4684")
    public String updateNote(@ModelAttribute CalculationResult calculationResult,
                             @PathVariable Long id) {
        CalculationResult entity = applicationFacade.populateResultById(id);
        entity.setComment(calculationResult.getComment());
        applicationFacade.updateResult(entity);
        return REDIRECT_RESULTS;
    }

    @DeleteMapping("/results/{id}")
    public String deleteResult(@PathVariable Long id) {
        applicationFacade.deleteResultById(id);
        return REDIRECT_RESULTS;
    }

    @GetMapping("/results")
    public String list(Model model) {
        model.addAttribute("results", applicationFacade.populateAllResults());
        return "results";
    }

    @GetMapping("/calc")
    public String form(Model model) {
        model.addAttribute("form", new TwoOperandsDto());
        return "calc";
    }

    @PostMapping("/results")
    public String calcResult(@ModelAttribute("form") TwoOperandsDto form) {
        applicationFacade.calculateResult(form);
        return REDIRECT_RESULTS;
    }

}


//    @GetMapping("/abs")
//    public String absForm(Model model) {
//        return "abs";
//    }
//
//    @GetMapping("/add")
//    public String addForm(Model model) {
//        return "add";
//    }
//
//    @GetMapping("/mul")
//    public String mulForm(Model model) {
//        return "mul";
//    }
//    @GetMapping("/edit/{id}")
//    public String editResult(@PathVariable Long id, Model model) {
//        CalculationResult calculationResult = applicationFacade.populateResultById(id);
//        model.addAttribute("calculationResult", calculationResult);
//        return "update";
//    }
