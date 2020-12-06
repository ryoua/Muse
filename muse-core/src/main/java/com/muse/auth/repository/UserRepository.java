package com.muse.auth.repository;

import com.muse.auth.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * * @Author: RyouA
 * * @Date: 2020/12/6
 **/
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
