
package ro.sda.javaro35.finalProject.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import ro.sda.javaro35.finalProject.dto.user.UserDto;

public class SignUpController {
    @GetMapping("/user/sign-up")
    public String showSignUpDoc(WebRequest request, Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        return "sign-up";
    }
}
