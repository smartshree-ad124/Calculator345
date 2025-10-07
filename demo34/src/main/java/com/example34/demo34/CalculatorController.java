package com.example34.demo34;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("result", ""); // initialize result
        model.addAttribute("error", "");  // initialize error
        return "calculator"; // loads calculator.html
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation,
            Model model) {

        double result = 0.0;
        String error = "";

        switch (operation) {
            case "add": 
                result = num1 + num2; 
                break;
            case "sub": 
                result = num1 - num2; 
                break;
            case "mul": 
                result = num1 * num2; 
                break;
            case "div":
                if (num2 != 0) result = num1 / num2;
                else error = "Cannot divide by zero!";
                break;
        }

        model.addAttribute("result", error.isEmpty() ? result : "");
        model.addAttribute("error", error);

        return "calculator"; // render the same page
    }
}
