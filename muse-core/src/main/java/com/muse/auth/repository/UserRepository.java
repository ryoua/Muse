package com.muse.auth.repository;

import com.muse.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/25
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
