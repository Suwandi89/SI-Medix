package tk.propensi.medix.service;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.RumahSakitModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.repository.RumahSakitDB;
import tk.propensi.medix.repository.UserDB;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Component
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDB userDb;

    @Autowired
    private RumahSakitDB rumahsakitDb;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public UserModel addUser(UserModel user, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);

        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);

        sendVerificationEmail(user, siteURL);

        return userDb.save(user);
    }

    @Override
    public void updateUser(UserModel user) {
        userDb.save(user);
    }

    @Override
    public void updatePassword(UserModel user, String newPassword){
        String pass = encrypt(newPassword);
        user.setPassword(pass);
        userDb.save(user);
    }

    @Override
    public boolean matchPassword(String newPassword, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(oldPassword, newPassword);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getUserList(String keyword){ 
        if (keyword != null){
            return userDb.search(keyword);
        }
        return userDb.findAll();
    }

    @Override
    public UserModel getUserByUsername(String username){
        return userDb.findByUsername(username);
    }

    @Override
    public UserModel getUserByEmail(String email){
        return userDb.findByEmail(email);
    }

    @Override
    public int getJumlahAdminKhanza() {
        int jumlahAdminKhanza = 0;
        Iterable<UserModel> userListAll = userDb.findAll();

        List<UserModel> userList = new ArrayList<>();
        userListAll.forEach(userList::add);

        for(UserModel user : userList){
            if(user.getRole().getId() == 2 && user.getStatus() == 1){
                jumlahAdminKhanza++;
            }
        }

        return jumlahAdminKhanza;
    }

    @Override
    public boolean processRequest(String username, int status, String namaRumahSakit){
        if (userDb.findByUsername(username).getStatus() == 3){
            userDb.findByUsername(username).setStatus(status);
            if (status == 1){
                if (rumahsakitDb.findByNamaRumahSakit(namaRumahSakit) == null){
                    RumahSakitModel rs = new RumahSakitModel();
                    rs.setNamaRumahSakit(namaRumahSakit);
                    rumahsakitDb.save(rs);
                }
                RumahSakitModel rumahsakit = rumahsakitDb.findByNamaRumahSakit(namaRumahSakit);
                userDb.findByUsername(username).setRumahSakit(rumahsakit);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteUser(String username){
        userDb.delete(userDb.findByUsername(username));
    }

    @Override
    public int checkIfUserExist(String username, String email) {
        int res = 0;
        if (userDb.findByUsername(username) != null){
            res = 1;
        }
        if (userDb.findByEmail(email) != null){
            res = 2;
        }
        return res;
    }

    @Override
    public int checkIfUserExistExcept(UserModel user, String username, String email) {
        int res = 0;
        if (userDb.findByUsername(username) != null) {
            if (userDb.findByUsername(username).getId() != user.getId()){
                res = 1;
            }
        }
        if (userDb.findByEmail(email) != null) {
            if (userDb.findByEmail(email).getId() != user.getId()) {
                res = 2;
            }
        }
        return res;
    }

    @Override
    public void sendVerificationEmail(UserModel user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "medixpropensi@gmail.com";
        String senderName = "MEDIX";
        String subject = "Please verify your email";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your email:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Medix.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getFirstname()+' '+user.getLastname());
        String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }

    public boolean verify(String verificationCode) {
        UserModel user = userDb.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userDb.save(user);

            return true;
        }

    }
}
