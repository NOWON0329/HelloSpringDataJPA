package kr.ac.hansung.cse.report22.controller;

import kr.ac.hansung.cse.report22.entity.MyUser;
import kr.ac.hansung.cse.report22.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepo;

    public AdminController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public String listAllUsers(Model model) {
        Iterable<MyUser> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user_list";   // templates/admin/user_list.html
    }
}
