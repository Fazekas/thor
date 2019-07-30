package com.mythology.thor.service;

import com.mythology.thor.entity.PictureEntity;
import com.mythology.thor.model.Picture;
import com.mythology.thor.repository.PictureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PictureRepository pictureRepo;

    public List<Picture> pictureList() {
        List<Picture> pictures = new ArrayList<>();
        List<PictureEntity> pictureEnt = this.pictureRepo.findAll();

        pictureEnt.forEach(pic -> pictures.add(modelMapper.map(pic, Picture.class)));

        return  pictures;
    }

}