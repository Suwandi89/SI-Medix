package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.UserService;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/pendaftar/{username}/accept")
    public String acceptRequest(
            @PathVariable String username,
            Model model
    ){
        userService.processRequest(username,1);
        UserModel user = userService.getUserByUsername(username);
        String emailText = "Selamat "+user.getFirstname()+", pembuatan akun Medix anda sudah diterima. Silahkan login menggunakan akun anda.";
        sendEmail(user.getEmail(),"Pembuatan akun Medix diterima",emailText);
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
        String emailText = "Mohon maaf "+user.getFirstname()+", pembuatan akun Medix anda ditolak. Mohon periksa kembali data diri serta bukti keterangan rumah sakit anda.";
        sendEmail(user.getEmail(),"Pembuatan akun Medix ditolak",emailText);
        model.addAttribute("user", user);
        return "view-pendaftar";
    }

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("medixpropensi@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
    }
}
