package com.mythology.thor.mappers;

import com.mythology.thor.entity.RoleEntity;
import com.mythology.thor.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleEntity modelToEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole(role.getRole());
        return roleEntity;
    }

    public Role entityToModel(RoleEntity roleEntity){
        Role role = new Role();
        role.setRole(roleEntity.getRole());
        return role;
    }
}
