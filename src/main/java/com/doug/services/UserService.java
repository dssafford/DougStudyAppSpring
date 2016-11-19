package com.doug.services;

import com.doug.domain.User;

/**
 * Created by jt on 12/14/15.
 */
public interface UserService extends CRUDService<User> {

    User findByUserName(String userName);

<<<<<<< HEAD
    Iterable<User> listAllUsers();

=======
    User getById(Integer id);

    void delete(Integer id);

    Iterable<User> listAllUsers();

    User saveOrUpdateUser(User user);

>>>>>>> users
}
