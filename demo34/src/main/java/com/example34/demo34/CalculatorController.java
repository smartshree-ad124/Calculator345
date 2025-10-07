package com.example34.demo34;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String showForm() {
        return "index"; // Loads index.html from templates
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation,
            @RequestParam(required=false) String email,
            Model model) {

        double result = 0.0;

        switch (operation) {
            case "add": result = num1 + num2; break;
            case "sub": result = num1 - num2; break;
            case "mul": result = num1 * num2; break;
            case "div":
                if (num2 != 0) result = num1 / num2;
                else {
                    model.addAttribute("error", "Cannot divide by zero!");
                    return "result";
                }
                break;
        }

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);

        // Send email if provided
        if (email != null && !email.isEmpty()) {
            String subject = "Your Calculator Result";
            String message = "Result of " + operation + " between " + num1 + " and " + num2 + " is: " + result;
            emailService.sendResultEmail(email, subject, message);
            model.addAttribute("emailMsg", "Result sent to " + email);
        }

        return "result"; // Loads result.html from templates
    }
}
