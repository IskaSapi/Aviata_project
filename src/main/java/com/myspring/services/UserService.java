package com.myspring.services;

import com.myspring.beans.UserBean;
import com.myspring.models.Roles;
import com.myspring.models.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class UserService implements UserDetailsService {
    private UserBean userBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Users myUser = userBean.getUserByLogin(login);
        Set<Roles> roles = new HashSet<Roles>(myUser.getRoles());
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        for(Roles r: roles){
            authorities.add(new SimpleGrantedAuthority(r.getRole()));
        }
        User securityUser = new User(myUser.getLogin(),myUser.getPassword(),authorities);
        return securityUser;

    }

}
