package com.muse.service;

import com.muse.common.exception.MuseException;
import com.muse.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户service类
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void login(User user) throws MuseException {

    }


    public void register(User user) throws MuseException {

    }
}
