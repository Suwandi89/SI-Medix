package tk.propensi.medix.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.repository.UserDB;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDB userDb;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UserModel user = userDb.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Email not found");
        }
        if ((user.getStatus() == 2) || (user.getStatus() == 3) || (!user.isEnabled())){
            throw new UsernameNotFoundException("Access denied");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
