package tk.propensi.medix.service;

import tk.propensi.medix.models.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    void updateUser(UserModel user);
    boolean matchPassword(String newPassword, String oldPassword);
    void updatePassword(UserModel user, String newPassword);
    public String encrypt(String password);
    List<UserModel> getUserList(String keyword);
    UserModel getUserByUsername(String username);
    void processRequest(String username,int status);
    void deleteUser(String username);
    int checkIfUserExist(String username, String email);
    int checkIfUserExistExcept(UserModel user, String username, String email);
    
}

