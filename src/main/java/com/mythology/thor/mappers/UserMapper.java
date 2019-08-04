package com.mythology.thor.mappers;

import com.mythology.thor.entity.UserEntity;
import com.mythology.thor.model.Role;
import com.mythology.thor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapper {
    // map model to entity

    @Autowired
    private RoleMapper roleMapper;


    public UserEntity modelToEntity (User user) {
        UserEntity entity = new UserEntity();
        entity.setUserName(user.getUserName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setActive(user.getActive());
        entity.setId(user.getId());

        return entity;
    }



    // map entity to model

    public User entityToModel(UserEntity userEntity){
        User userModel = new User();
        userModel.setUserName(userEntity.getUserName());
        userModel.setEmail(userEntity.getEmail());
//        userModel.setPassword(userEntity.getPassword());
        userModel.setActive(userEntity.getActive());
        userModel.setId(userEntity.getId());

        Set<Role> roles = new HashSet<>();
        userEntity.getRole().forEach(r -> {
            Role roleModel = roleMapper.entityToModel(r);
            roles.add(roleModel);
        });

        userModel.setRole(roles);
        return userModel;

    }
}
