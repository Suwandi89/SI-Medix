package tk.propensi.medix.controller;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.propensi.medix.dto.EmailDTO;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

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

    @GetMapping("/resendcode")
    public String resendCodeUser(Model model) {
        EmailDTO emailDTO = new EmailDTO();
        model.addAttribute("emailDTO",emailDTO);
        return "resend-code";
    }

    @PostMapping("/resendcode")
    public String resendCodeUserSubmit(@ModelAttribute EmailDTO form, HttpServletRequest request, Model model)
            throws UnsupportedEncodingException, MessagingException {
        UserModel user = userService.getUserByEmail(form.email);
        boolean success = false;
        boolean error1 = false;
        boolean error2 = false;
        if (user != null){
            if (!user.isEnabled()){
                String randomCode = RandomString.make(64);
                user.setVerificationCode(randomCode);
                userService.sendVerificationEmail(user, getSiteURL(request));
                success = true;
            } else {
                error2 = true;
            }
        } else{
            error1 = true;
        }
        model.addAttribute("success",success);
        model.addAttribute("error1",error1);
        model.addAttribute("error2",error2);
        return "resend-code";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
