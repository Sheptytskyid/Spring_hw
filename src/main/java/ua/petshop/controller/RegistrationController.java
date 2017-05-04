package ua.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.petshop.dto.UserDto;
import ua.petshop.service.SecurityService;
import ua.petshop.service.UserService;
import ua.petshop.validator.UserValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;
    private SecurityService securityService;

    @Autowired
    public RegistrationController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping
    public ModelAndView register() {
        ModelAndView model = new ModelAndView("registration");
        model.addObject("userForm", new UserDto());
        return model;
    }

    @PostMapping
    public ModelAndView processRegistration(@Valid @ModelAttribute("userForm") UserDto user, Errors errors) {
        System.out.println("inside reg controller");
        UserValidator.validate(user, errors, userService);
        if (errors.hasErrors()) {
            return new ModelAndView("registration");
        }
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        userService.save(user.getName(), user.getPassword());
        securityService.autoLogin(user.getName(), user.getPassword());
        return new ModelAndView("redirect:/products");
    }
}
