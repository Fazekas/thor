package com.mythology.thor.mappers;

import com.mythology.thor.entity.PictureEntity;
import com.mythology.thor.model.Picture;
import org.springframework.stereotype.Component;


@Component
public class PictureMapper {

    public PictureEntity modelToEntity(Picture picture) {
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setPictureURL(picture.getPictureURL());
        pictureEntity.setLike(picture.getLike());
        pictureEntity.setDislike(picture.getDislike());

//        pictureEntity.setComments(picture.getComments());

        return pictureEntity;
    }

    public Picture entityToModel(PictureEntity pictureEntity){
        Picture picture = new Picture();
        picture.setPictureURL(pictureEntity.getPictureURL());
        picture.setLike(pictureEntity.getLike());
        picture.setDislike(pictureEntity.getDislike());
//        picture.setComments(pictureEntity.getComments());

        return picture;
    }



}
