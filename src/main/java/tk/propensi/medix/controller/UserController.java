package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tk.propensi.medix.models.RoleModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.RoleService;
import tk.propensi.medix.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value="/signup")
    public String signup(Model model){
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("listRole",listRole);
        model.addAttribute("user",new UserModel());
        return "signup";
    }

    @PostMapping(value = "/signup")
    private String addUserSubmit(@ModelAttribute UserModel user){
        int flag = userService.checkIfUserExist(user.getUsername(), user.getEmail());
        if (flag == 0){
            userService.addUser(user);
        } else if (flag == 1){
            return "redirect:/signup?error1";
        } else if (flag == 2){
            return "redirect:/signup?error2";
        }
        return "redirect:/signup?success";
    }

    @GetMapping(value = "/viewall")
    public String viewAllUser(Authentication auth, Model model) {
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        model.addAttribute("user", authUser);
        return "viewall-user";
    }

}
