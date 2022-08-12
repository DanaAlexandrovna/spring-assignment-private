package ro.sda.javaro35.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.service.user.UserService;

import javax.validation.Valid;

//@Controller
//@RequestMapping("/registration")
//public class UserRegistrationController {

//    @Autowired
//    private UserService userService;
//
//    @ModelAttribute("user")
//    public UserDto userRegistrationDto() {
//        return new UserDto();
//    }
//
//    @GetMapping
//    public String showRegistrationForm(Model model) {
//        return "registration";
//    }
//
//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
//                                    BindingResult result) {
//
 //       User existing = userService.save(UserDto);
 //       if (existing != null) {
  //          result.rejectValue("email", null, "There is already an account registered with that email");
  //      }
///
  //      if (result.hasErrors()) {
   //         return "registration";
    //    }

    //    userService.save(userDto);
  //      return "redirect:/registration?success";
 //   }
//}
