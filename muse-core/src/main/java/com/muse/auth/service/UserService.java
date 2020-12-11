package com.muse.auth.service;

import com.muse.auth.model.User;
import com.muse.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean login(User user) {
        User user1 = userRepository.findByUsername(user.getUsername());
        return user1 != null && user1.getPassword().equals(user.getPassword());
    }
}
