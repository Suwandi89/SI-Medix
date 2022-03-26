package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    private String home(HttpServletRequest request, Model model) {
        UserModel user = userService.getUserByUsername(request.getRemoteUser());
        model.addAttribute("authuser",user);
        return "home";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
}
