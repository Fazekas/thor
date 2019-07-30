package com.mythology.thor.repository;

import com.mythology.thor.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity, UUID> {
}
