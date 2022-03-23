package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @GetMapping("/pendaftar/{username}")
    public String viewPendaftar(@PathVariable String username, Model model){
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "view-pendaftar";
    }

    @RequestMapping(value = "/pendaftar/viewall/page/{pageNumber}")
    public String getOnePage(Model model, @Param("keyword") String keyword,
                              @PathVariable("pageNumber") int currentPage) {

        Page<UserModel> page = userService.findPage(currentPage, keyword);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<UserModel> listUser = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @RequestMapping("/pendaftar/viewall")
    public String getAllPages(Model model, @Param("keyword") String keyword){
       if (keyword == null){
           return getOnePage(model, null,1);
       }
        return getOnePage(model, keyword,1);
    }

}
