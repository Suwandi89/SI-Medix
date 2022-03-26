package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.UserService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/pendaftar/{username}/accept")
    public String acceptRequest(
            Authentication auth,
            @PathVariable String username,
            Model model
    ) throws MessagingException, UnsupportedEncodingException{
        userService.processRequest(username,1);
        UserModel user = userService.getUserByUsername(username);
        String emailText = "Selamat "+user.getFirstname()+", pembuatan akun Medix anda sudah diterima. Silahkan login menggunakan akun anda.";
        sendEmail(user.getEmail(),"Pembuatan akun Medix diterima", emailText);
        String keyword = null;
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<UserModel> listUser = userService.getUserList(keyword);
        List<UserModel> listUserRes = new ArrayList<UserModel>();
        for (UserModel user1 : listUser){
            if (user1.getRole().getId() != 1){
                listUserRes.add(user1);
            }
        }
        model.addAttribute("listUser", listUserRes);
        model.addAttribute("authuser", authUser);
        return "viewall-user";
    }

    @GetMapping("/pendaftar/{username}/decline")
    public String declineRequest(
            Authentication auth,
            @PathVariable String username,
            Model model
    ) throws MessagingException, UnsupportedEncodingException{
        userService.processRequest(username,2);
        UserModel user = userService.getUserByUsername(username);
        String emailText = "Mohon maaf "+user.getFirstname()+", pembuatan akun Medix anda ditolak. Mohon periksa kembali data diri serta bukti keterangan rumah sakit anda.";
        sendEmail(user.getEmail(),"Pembuatan akun Medix ditolak",emailText);
        userService.deleteUser(username);
        String keyword = null;
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<UserModel> listUser = userService.getUserList(keyword);
        List<UserModel> listUserRes = new ArrayList<UserModel>();
        for (UserModel user1 : listUser){
            if (user1.getRole().getId() != 1){
                listUserRes.add(user1);
            }
        }
        model.addAttribute("listUser", listUserRes);
        model.addAttribute("authuser", authUser);
        return "viewall-user";
    }

    public void sendEmail(String toEmail, String subject, String body) throws MessagingException, UnsupportedEncodingException {
        String fromAddress = "medixpropensi@gmail.com";
        String senderName = "MEDIX";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        String content = body + "<br>"
                + "Salam,<br>"
                + "Medix.";

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toEmail);
        helper.setSubject(subject);

        helper.setText(body, true);

        mailSender.send(message);

    }
}
