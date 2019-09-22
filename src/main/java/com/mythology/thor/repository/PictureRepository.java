package com.mythology.thor.repository;

import com.mythology.thor.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity, Integer> {

//    @Query(value =  "SELECT * FROM PictureEntity pic WHERE pic.userId=user_id",
//    nativeQuery = true)
    List<PictureEntity> findAllByUserId(Integer userId);
}
