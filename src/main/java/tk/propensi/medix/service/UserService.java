package tk.propensi.medix.service;

import tk.propensi.medix.models.UserModel;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user, String siteURL) throws MessagingException, UnsupportedEncodingException;
    void updateUser(UserModel user);
    boolean matchPassword(String newPassword, String oldPassword);
    void updatePassword(UserModel user, String newPassword);
    String encrypt(String password);
    List<UserModel> getUserList(String keyword);

    UserModel getUserByUsername(String username);
    UserModel getUserByEmail(String email);
    int getJumlahAdminKhanza();
    int getJumlahFlaggedRekamMedis();
    int getJumlahPendaftarPending();
    boolean processRequest(String username,int status, String namaRumahSakit);
    void deleteUser(String username);
    int checkIfUserExist(String username, String email);
    int checkIfUserExistExcept(UserModel user, String username, String email);
    void sendVerificationEmail(UserModel user, String siteURL) throws MessagingException, UnsupportedEncodingException;
    boolean verify(String verificationCode);
    
}

