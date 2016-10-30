package com.doug.repositories;

import com.doug.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 12/21/15.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
