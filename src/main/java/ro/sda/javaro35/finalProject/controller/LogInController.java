package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.service.user.UserService;

@Controller
@NoArgsConstructor
@AllArgsConstructor
public class LogInController {
    @Autowired
    private UserService userService;

    @GetMapping ("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "register";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDto user){
        System.out.println("register request" + user);
        UserDto register = userService.save(user);
        return register == null ? "error_page" : "redirect:/login";
    }
}
