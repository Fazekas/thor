package com.mythology.thor.service;

import com.mythology.thor.entity.UserEntity;
import com.mythology.thor.model.User;
import com.mythology.thor.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepo;

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<UserEntity> allUsers = this.userRepo.findAll();

        allUsers.forEach(userEntity -> users.add(this.modelMapper.map(userEntity, User.class)));

        return users;
    }




}
