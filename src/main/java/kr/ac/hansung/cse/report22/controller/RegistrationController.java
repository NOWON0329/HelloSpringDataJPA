package kr.ac.hansung.cse.report22.controller;

import kr.ac.hansung.cse.report22.entity.MyRole;
import kr.ac.hansung.cse.report22.entity.MyUser;
import kr.ac.hansung.cse.report22.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {

        MyUser user = new MyUser();
        model.addAttribute("user", user);

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") MyUser user, Model model) {

        if (registrationService.checkEmailExists(user.getEmail())) {
            model.addAttribute("emailExists", true);
            return "signup";
        }
        else {
            List<MyRole> userRoles = new ArrayList<>();

            MyRole role = registrationService.findByRolename("ROLE_USER");
            userRoles.add(role);

            if ("admin@hansung.ac.kr".equals(user.getEmail())) {
                MyRole roleAdmin = registrationService.findByRolename("ROLE_ADMIN");
                userRoles.add(roleAdmin);
            }

            registrationService.createUser(user, userRoles);

            return "redirect:/";
        }
    }
}