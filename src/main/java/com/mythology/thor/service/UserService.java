package com.mythology.thor.service;

import com.mythology.thor.entity.RoleEntity;
import com.mythology.thor.entity.UserEntity;
import com.mythology.thor.mappers.UserMapper;
import com.mythology.thor.model.User;
import com.mythology.thor.repository.RoleRepository;
import com.mythology.thor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<UserEntity> allUsers = this.userRepo.findAll();

        allUsers.forEach(userEntity -> users.add(this.userMapper.entityToModel(userEntity)));

        return users;
    }

    public User registerUser(User user) {
        //change from user to user entity
        UserEntity userEntity = this.userMapper.modelToEntity(user);
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setActive(true);

        // need to get the role to set the users role
        RoleEntity adminRole = this.roleRepository.findByRole("ADMIN");

        // set the users role
        userEntity.setRole(new HashSet<>(Arrays.asList(adminRole)));

        // save our new user
        UserEntity savedEntity = this.userRepo.save(userEntity);


        // make response data of the newly saved user
        return this.userMapper.entityToModel(savedEntity);


        /*
         * 1: convert modal to entity
         * 2: save the entity
         * 3: take saved entity and convert back to model
         * 4: return model to the front*/

    }

    public User findByEmail(String email) {
        UserEntity user = this.userRepo.findByEmail(email);

        return this.userMapper.entityToModel(user);
    }



    public User findByUsername(String username){
        UserEntity user = this.userRepo.findByUserName(username);

        return this.userMapper.entityToModel(user);
    }



}
