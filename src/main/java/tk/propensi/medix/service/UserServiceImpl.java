package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.repository.UserDB;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDB userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }


    @Override
    public Page<UserModel> findPage(int pageNumber, String keyword) {
        Pageable pageable =  PageRequest.of(pageNumber - 1,5);

        if (keyword != null){
            return userDb.findByTitleContaining(keyword, pageable);
        }
        return userDb.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public UserModel getUserByUsername(String username){
        return userDb.findByUsername(username);
    }

    @Override
    public void processRequest(String username, int status){
        userDb.findByUsername(username).setStatus(status);
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
}
