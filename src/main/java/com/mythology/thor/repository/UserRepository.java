package com.mythology.thor.repository;

import com.mythology.thor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByEmail(String email);

    UserEntity findByUserName(String username);
}
