package com.enzamul.ngoProjects.config;


import com.enzamul.ngoProjects.entity.User;
import com.enzamul.ngoProjects.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
/**
 *
 * @author MD ENZAMUL HOQ
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // Let Visitor login with either username or email
        Optional<User> optionalUser = userRepo.findByusernameOrEmail(usernameOrEmail, usernameOrEmail);
        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
