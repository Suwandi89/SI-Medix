package tk.propensi.medix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {
    @RequestMapping("/")
    private String home(HttpServletRequest request) {
        return "home";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }
}
