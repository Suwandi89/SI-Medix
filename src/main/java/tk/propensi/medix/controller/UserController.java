package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.propensi.medix.dto.ChangePasswordDTO;
import tk.propensi.medix.dto.RumahSakitDataDTO;
import tk.propensi.medix.models.RoleModel;
import tk.propensi.medix.models.RumahSakitModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.RoleService;
import tk.propensi.medix.service.RumahSakitService;
import tk.propensi.medix.service.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    private RumahSakitService rumahSakitService;

    @GetMapping("/signup")
    public String signup(Model model){
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("listRole",listRole);
        model.addAttribute("user",new UserModel());
        return "signup";
    }

    @PostMapping("/signup")
    private String addUserSubmit(@ModelAttribute UserModel user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        int flag = userService.checkIfUserExist(user.getUsername(), user.getEmail());
        if (flag == 0){
            userService.addUser(user, getSiteURL(request));
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
            if (user.getRole().getId() != 1 && user.isEnabled()){
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
            if (user.getRole().getId() != 1 && user.isEnabled()){
                listUserRes.add(user);
            }
        }
        Collections.sort(listUserRes, new StatusComparator());
        model.addAttribute("listUser", listUserRes);
        model.addAttribute("authuser", authUser);
        return "viewall-user";
    }

    @RequestMapping(value = "/viewall-rumahsakit")
    public String viewAllRumahSakit(Authentication auth, Model model, @Param("keyword") String keyword){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<RumahSakitModel> listRumahSakit = rumahSakitService.getRumahSakitList(keyword); 
        model.addAttribute("listRumahSakit", listRumahSakit); 
        model.addAttribute("authuser", authUser);
        return "viewall-rumahsakit"; 
    }


    @GetMapping(value = "/rumahsakit/{namaRumahSakit}")
    public String viewRumahSakit(@PathVariable String namaRumahSakit, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        RumahSakitModel rumahSakit = rumahSakitService.getRumahSakitByNamaRS(namaRumahSakit); 
        String manajerRumahSakit = "-";
        String adminRumahSakit = "-";
        String namaManajer = "-";

        // String manajerRumahSakit = ((rumahSakitService.getUserRumahSakit(namaRumahSakit, 3).getUsername() == null) 
        // ? "-" : rumahSakitService.getUserRumahSakit(namaRumahSakit, 3).getUsername()) ;  
    
        // String adminRumahSakit = ((rumahSakitService.getUserRumahSakit(namaRumahSakit, 2).getUsername() == null) ? "-" :
        // rumahSakitService.getUserRumahSakit(namaRumahSakit, 2).getUsername()); 
        
        // String namaManajer = ((rumahSakitService.getUserRumahSakit(namaRumahSakit, 3).getUsername() == null) ? "-" :
        // rumahSakitService.getUserRumahSakit(namaRumahSakit, 3).getFirstname() + " " + 
        // rumahSakitService.getUserRumahSakit(namaRumahSakit, 3).getLastname() ); 
    
        model.addAttribute("rumahSakit", rumahSakit);
        model.addAttribute("manajerRumahSakit", manajerRumahSakit); 
        model.addAttribute("adminRumahSakit", adminRumahSakit); 
        model.addAttribute("namaManajer", namaManajer); 
        model.addAttribute("authuser", authUser);
        model.addAttribute("firstname", ""); 
        return "view-rumahsakit"; 
    }

    @RequestMapping(value = "/viewall-admin")
    public String viewAllAdmin(Authentication auth, Model model, @Param("keyword") String keyword) {
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<UserModel> listUser = userService.getUserList(keyword);
        List<UserModel> listUserRes = new ArrayList<UserModel>();
        for (UserModel user : listUser){
            if (user.getRole().getId() == 2 && user.isEnabled() && user.getStatus() == 1){
                listUserRes.add(user);
            }
        }
        model.addAttribute("listUser", listUserRes);
        model.addAttribute("authuser", authUser);
        return "viewall-admin";
    }

    @GetMapping("/viewadmin/{username}")
    public String viewAdmin(@PathVariable String username, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        UserModel user = userService.getUserByUsername(username);
        RumahSakitModel rumahsakit = user.getRumahSakit();
        model.addAttribute("rumahsakit", rumahsakit);
        model.addAttribute("user", user);
        model.addAttribute("authuser", authUser);
        return "view-admin";
    }

    @PostMapping("/viewadmin/{username}")
    public String viewAdmin(@ModelAttribute RumahSakitModel rumahsakit, @PathVariable String username, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        UserModel user = userService.getUserByUsername(username);
        rumahSakitService.updateRSData(rumahsakit);
        int flag = userService.checkIfUserExistExcept(authUser, user.getUsername(), user.getEmail());
        boolean error1 = false;
        boolean error2 = false;
        boolean success = true;
        model.addAttribute("error1", error1);
        model.addAttribute("error2", error2);
        model.addAttribute("success", success);
        model.addAttribute("authuser", authUser);
        model.addAttribute("rumahsakit", rumahsakit);
        model.addAttribute("user", user);
        return "view-admin";
    }

    @GetMapping("/update-admin/{username}")
    public String updateAdmin(@PathVariable String username, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        UserModel user = userService.getUserByUsername(username);

        model.addAttribute("authuser", authUser);
        model.addAttribute("user", user);
        return "update-admin";
    }

    @PostMapping("/update-admin")
    public String updateAdminSubmit(@ModelAttribute UserModel user, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        int flag = userService.checkIfUserExistExcept(user, user.getUsername(), user.getEmail());
        boolean error1 = false;
        boolean error2 = false;
        boolean success = false;
        if (flag == 0){
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
        return "view-admin";
    }

    @GetMapping("/add-rsdata")
    public String addRSData(Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        RumahSakitDataDTO rumahsakitData = new RumahSakitDataDTO();
        model.addAttribute("rumahsakit",rumahsakitData);
        model.addAttribute("authuser", authUser);
        model.addAttribute("user", authUser);
        return "add-rsdata";
    }

    @PostMapping("/add-rsdata")
    public String addRSDataSubmit(@ModelAttribute RumahSakitDataDTO form, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        rumahSakitService.addRSData(authUser.getRumahSakit(),form);
        model.addAttribute("authuser", authUser);
        return "myprofile";
    }

    @GetMapping("/infografis")
    public String infografis(Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        model.addAttribute("authuser", authUser);
        return "infografis";
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

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
