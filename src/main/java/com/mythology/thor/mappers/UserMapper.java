package com.mythology.thor.mappers;

import com.mythology.thor.entity.UserEntity;
import com.mythology.thor.model.Picture;
import com.mythology.thor.model.Role;
import com.mythology.thor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserMapper {
    // map model to entity

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PictureMapper pictureMapper;


    public UserEntity modelToEntity (User user) {
        UserEntity entity = new UserEntity();
        entity.setUserName(user.getUserName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setActive(user.getActive());

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

        List<Picture> pictures = new ArrayList();
        userEntity.getPictureEntities().forEach(pictureEntity -> {
            Picture pictureModel = pictureMapper.entityToModel(pictureEntity);
            pictures.add(pictureModel);
        });

        userModel.setRole(roles);
        userModel.setPictures(pictures);

        return userModel;
    }
}
