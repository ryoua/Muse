package com.muse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户mapper类
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根绝用户名获取用户
     * @param username 用户名
     * @return 用户实体类
     */
    User findUserByUsername(String username);
}
