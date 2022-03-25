package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.propensi.medix.dto.ChangePasswordDTO;
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

    @GetMapping("/myprofile")
    public String viewProfile(Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        model.addAttribute("error1", false);
        model.addAttribute("error2", false);
        model.addAttribute("success", false);
        model.addAttribute("authuser", authUser);
        return "myprofile";
    }

    @GetMapping("/changepassword")
    public String changePassword(Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        model.addAttribute("fail", false);
        model.addAttribute("success", false);
        model.addAttribute("changePasswordDTO",changePasswordDTO);
        model.addAttribute("authuser", authUser);
        return "change-password";
    }

    @PostMapping("/changepassword")
    public String changePasswordSubmit(@ModelAttribute ChangePasswordDTO form, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        boolean fail = false;
        boolean success = false;
        if (userService.matchPassword(authUser.getPassword(), form.oldPassword)){
            userService.updatePassword(authUser, form.newPassword);
            success = true;
        } else {
            fail = true;
        }
        model.addAttribute("fail", fail);
        model.addAttribute("success", success);
        model.addAttribute("authuser", authUser);
        return "change-password";
    }

    @PostMapping("/updatePassword")
    public String updatePasswordSubmit(@ModelAttribute UserModel userAwal, String username, String password, String password1, String password2, Model model){
        UserModel user = userService.getUserByUsername(username);
        if (userService.matchPassword(user.getPassword(), password)){
            if(password1.equals(password2)){
                userService.updatePassword(user, password1);
            } else {
                model.addAttribute("fail", true);
            }
        } else {
            model.addAttribute("fail", true);
        }
        return "home";
    }

    @GetMapping("/editprofile")
    public String editProfile(Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());

        model.addAttribute("authuser", authUser);
        model.addAttribute("user", authUser);
        return "edit-profile";
    }

    @PostMapping("/editprofile")
    public String editProfileSubmit(@ModelAttribute UserModel user, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        int flag = userService.checkIfUserExistExcept(authUser, user.getUsername(), user.getEmail());
        boolean error1 = false;
        boolean error2 = false;
        boolean success = false;
        if (flag == 0){
            user.setId(authUser.getId());
            userService.updateUser(user);
            success = true;
        } else if (flag == 1){
            error1 = true;
        } else if (flag == 2){
            error2 = true;
        }
        model.addAttribute("error1", error1);
        model.addAttribute("error2", error2);
        model.addAttribute("success", success);
        model.addAttribute("authuser", user);
        model.addAttribute("user", user);
        return "myprofile";
    }

    @GetMapping("/pendaftar/{username}")
    public String viewPendaftar(@PathVariable String username, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("authuser", authUser);
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
        model.addAttribute("authuser", authUser);
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
        model.addAttribute("authuser", authUser);
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
