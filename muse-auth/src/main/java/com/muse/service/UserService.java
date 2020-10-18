package com.muse.service;

import com.muse.exception.MuseException;
import com.muse.model.User;
import com.muse.repository.UserRepository;
import com.muse.util.SnowIdWorker;
import com.muse.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public Long login(User user) throws MuseException {
        User u = userRepository.findUserByUsername(user.getUsername());
        try {
            if (u.getPassword().equals(user.getPassword())) {
                return u.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
            throw new MuseException("账号或密码错误");
        }
        return null;
    }


    public void register(User user) throws MuseException {
        long id = SnowIdWorker.nextId();
        user.setId(id);
        String encodePassword = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(encodePassword);
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new MuseException("用户已存在");
        } else {
            userRepository.save(user);
        }
    }
}
