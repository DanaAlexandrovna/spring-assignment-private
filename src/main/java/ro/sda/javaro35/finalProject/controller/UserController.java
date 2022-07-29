package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sda.javaro35.finalProject.dto.user.UserDto;
import ro.sda.javaro35.finalProject.entities.user.User;
import ro.sda.javaro35.finalProject.service.user.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


   // http://localhost:8080/users

    // map url to controller method

    @GetMapping
    public String page(final ModelMap modelMap){
        modelMap.addAttribute("test","test2");
            return "welcome";
        }

    @GetMapping("/admin/users")
    public String showUsersPage(Model model) {
        // return a html page with users
        // add list of users
        List<UserDto> users = userService.findAll();
        model.addAttribute("usersInView", users);

        // resolved by the view resolver
        return "users-list";
    }

    @GetMapping("/admin/users/add")
    public String showAddFrom(Model model) {
        User newUser = new User();
        model.addAttribute("user", newUser);
        return "user-add";
    }

    @PostMapping("/admin/users/add")
    public String add(@ModelAttribute UserDto user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("user", userService.findById(id));
        return "user-edit";
    }

    public ModelAndView showEditForm2(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("user-edit");
        modelAndView.addObject("user", userService.findById(id));
        return modelAndView;
    }

    @PostMapping("/admin/users/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute UserDto userData) {

        userService.update(id, userData);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/{id}/delete")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
