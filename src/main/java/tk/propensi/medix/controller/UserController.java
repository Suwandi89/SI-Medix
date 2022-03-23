package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tk.propensi.medix.models.RoleModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.RoleService;
import tk.propensi.medix.service.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/signup")
    public String signup(Model model){
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("listRole",listRole);
        model.addAttribute("user",new UserModel());
        return "signup";
    }

    @PostMapping("/signup")
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

    @GetMapping("/pendaftar/{username}")
    public String viewPendaftar(@PathVariable String username, Model model){
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "view-pendaftar";
    }

    @RequestMapping(value = "/viewall")
    public String viewAllUser(Authentication auth, Model model, @Param("keyword") String keyword) {
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<UserModel> listUser = userService.getUserList(keyword);
        List<UserModel> listUserRes = new ArrayList<UserModel>();
        for (UserModel user : listUser){
            if (user.getRole().getId() != 1){
                listUserRes.add(user);
            }
        }
        model.addAttribute("listUser", listUserRes);
        model.addAttribute("user", authUser);
        return "viewall-user";
    }

    @RequestMapping(value = "/viewall/sorted")
    public String viewAllUserSorted(Authentication auth, Model model, @Param("keyword") String keyword) {
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<UserModel> listUser = userService.getUserList(keyword);
        List<UserModel> listUserRes = new ArrayList<UserModel>();
        for (UserModel user : listUser){
            if (user.getRole().getId() != 1){
                listUserRes.add(user);
            }
        }
        Collections.sort(listUserRes, new StatusComparator());
        model.addAttribute("listUser", listUserRes);
        model.addAttribute("user", authUser);
        return "viewall-user";
    }


    public class StatusComparator implements Comparator<UserModel> {
        public int compare(UserModel user1, UserModel user2) {
            if (user1.getStatus() == user2.getStatus()) {
                return 0;
            }
            else if (user1.getStatus() < user2.getStatus()) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }


}
