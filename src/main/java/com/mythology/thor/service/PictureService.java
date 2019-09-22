package com.mythology.thor.service;

import com.mythology.thor.entity.PictureEntity;
import com.mythology.thor.mappers.PictureMapper;
import com.mythology.thor.model.Picture;
import com.mythology.thor.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private PictureRepository pictureRepo;

    public List<Picture> pictureList() {
        List<Picture> pictures = new ArrayList<>();
        List<PictureEntity> pictureEnt = this.pictureRepo.findAll();
        pictureEnt.forEach(pic -> pictures.add(pictureMapper.entityToModel(pic)));

        return  pictures;
    }

    public Picture findById(Integer id) {
        // declare
        PictureEntity pictureEntity = this.pictureRepo.getOne(id);
        return pictureMapper.entityToModel(pictureEntity);
    }

    public List<Picture> findAllByUserId(Integer userId) {
        List<PictureEntity> pictureEntities = this.pictureRepo.findAllByUserId(userId);
        List<Picture> pictures = new ArrayList<>();
        pictureEntities.forEach(pictureEntity -> pictures.add(pictureMapper.entityToModel(pictureEntity)));

        return pictures;
    }

    public Picture postPicture(Picture picture) {
        PictureEntity pictureEntity = pictureMapper.modelToEntity(picture);
        this.pictureRepo.save(pictureEntity);
        Picture pictureResponse = pictureMapper.entityToModel(pictureEntity);

        return pictureResponse;
    }
}
