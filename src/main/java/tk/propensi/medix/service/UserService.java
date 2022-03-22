package tk.propensi.medix.service;

import tk.propensi.medix.models.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    List<UserModel> getUserList();
    UserModel getUserByUsername(String username);
    void processRequest(String username,int status);
    int checkIfUserExist(String username, String email);
}

