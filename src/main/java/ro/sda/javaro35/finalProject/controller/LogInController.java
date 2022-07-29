package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

  private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        User newUser = new User();
        model.addAttribute("user", newUser);
        return "register";
    }

    @PostMapping("/register")
    public String add(@ModelAttribute UserDto dto) {
        userService.save(dto);
        return "redirect:/";
    }
}
