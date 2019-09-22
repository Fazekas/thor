package com.mythology.thor.controller;

import com.mythology.thor.model.Picture;
import com.mythology.thor.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @GetMapping(path = "/pictures")
    public List<Picture> findAllByUserId(@RequestBody Integer userId){
        return  pictureService.findAllByUserId(userId);
    }

    @GetMapping(path = "/{pictureId}")
    public Picture findById(@PathVariable Integer pictureId){
        return pictureService.findById(pictureId);
    }

    @PostMapping()
    public Picture postPicture(@RequestBody Picture picture){
        return pictureService.postPicture(picture);
    }

}
