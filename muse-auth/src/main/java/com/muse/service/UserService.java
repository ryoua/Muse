package com.muse.service;

import com.muse.model.User;
import com.muse.repository.UserRepository;
import com.muse.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String login(User user) {
        User u = userRepository.findUserByUsername(user.getUsername());
        if (u == null) {
            return null;
        }
        String salt = u.getSalt();
        String encodePassword = DigestUtils.md5Hex(salt + user.getPassword() + salt).toUpperCase();
        if (encodePassword.equals(user.getPassword())) {
            return u.getId();
        }
        return null;
    }


    public void register(User user) {
        String salt = StringUtil.randomString();
        String encodePassword = DigestUtils.md5Hex(salt + user.getPassword() + salt).toUpperCase();

        user.setPassword(encodePassword);
        user.setSalt(salt);
        userRepository.save(user);
    }
}
