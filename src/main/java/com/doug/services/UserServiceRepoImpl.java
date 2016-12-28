package com.doug.services;

import com.doug.domain.User;
import com.doug.repositories.UserRepository;
import com.doug.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 12/21/15.
 */
@Service
public class UserServiceRepoImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {

        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
        return userRepository.save(domainObject);
    }

    @Override
    public User saveOrUpdateUser(User user) {
        if(user.getPassword() != null){
            user.setEncryptedPassword(encryptionService.encryptString(user.getPassword()));
        }

        if(user.getId()==null) {
            return userRepository.save(user);
        }

        User updatedEntry = this.getById(user.getId());
        updatedEntry.setId(user.getId());
        updatedEntry.setUsername(user.getUsername());
        updatedEntry.setEncryptedPassword(user.getEncryptedPassword());


        return userRepository.save(updatedEntry);

    }



    @Override
    @Transactional
    public void delete(Integer id) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
