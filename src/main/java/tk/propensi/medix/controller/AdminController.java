package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tk.propensi.medix.models.RoleModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.UserService;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/pendaftar/{username}/accept")
    public String acceptRequest(
            @PathVariable String username,
            Model model
    ){
        userService.processRequest(username,1);
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "view-pendaftar";
    }

    @GetMapping("/pendaftar/{username}/decline")
    public String declineRequest(
            @PathVariable String username,
            Model model
    ){
        userService.processRequest(username,2);
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "view-pendaftar";
    }
}
