package tk.propensi.medix.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.UserModel;

@Repository
public interface UserDB extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String Username);
    UserModel findByEmail(String Email);

    @Query("SELECT u FROM UserModel u WHERE CONCAT(u.firstname, u.email, u.lastname, u.status) LIKE %?1%")
    public List<UserModel> search(String keyword);

    @Query("SELECT u FROM UserModel u WHERE u.verificationCode = ?1")
    public UserModel findByVerificationCode(String code);
}
