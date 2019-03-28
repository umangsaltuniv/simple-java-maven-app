package com.expense.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expense.entity.MyUserPrincipal;
import com.expense.entity.User;
import com.expense.entity.repository.UserRepository;
/*MyUserDetailService uses loadUserByUserName() method
 * by which we can retrieve user object using DAO
 * It will check first, if the user object is present, then it will wrap it into a MyUserPrincipal class object
 * which implement user detail and return it
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}