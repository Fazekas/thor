package com.mythology.thor.service;

import com.mythology.thor.entity.RoleEntity;
import com.mythology.thor.model.Role;
import com.mythology.thor.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepository roleRepo;

    public List<Role> findAllRoles(){
        List<Role> roles = new ArrayList<>();
        List<RoleEntity> roleEntities = roleRepo.findAll();
        roleEntities.forEach(role -> roles.add(this.modelMapper.map(role, Role.class)));
        return roles;
    }
}
