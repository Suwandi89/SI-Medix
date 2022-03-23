package tk.propensi.medix.service;




import org.springframework.data.domain.Page;
import tk.propensi.medix.models.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    Page<UserModel> findPage(int pageAble, String keyword);
    UserModel getUserByUsername(String username);
    void processRequest(String username,int status);
    int checkIfUserExist(String username, String email);
    
}

