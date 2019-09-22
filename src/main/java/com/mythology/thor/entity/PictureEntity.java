package com.mythology.thor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "picture")
public class PictureEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String pictureURL;

   // @ElementCollection
//    private List<String> comments;

    private Integer like;

    private Integer dislike;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
//
//    public List<String> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<String> comments) {
//        this.comments = comments;
//    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }
}
