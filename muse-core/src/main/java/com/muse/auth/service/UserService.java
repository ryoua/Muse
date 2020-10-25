package com.muse.auth.service;

import com.muse.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/25
 **/
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
