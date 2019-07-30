package com.mythology.thor.entity;

import com.mythology.thor.model.Picture;
import com.mythology.thor.model.Role;
import com.mythology.thor.model.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID id;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String userName;

    @NotEmpty
    @Length(min=5)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> role;

//    @OneToMany
//    private List<PictureEntity> pictures;
//
//    @ManyToMany
//    @JoinColumn(name = "user_id")
//    private Set<UserEntity> followers;
//
//    @OneToMany(mappedBy = "")
//    private Set<UserEntity> following;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRole() {
        return role;
    }

    public void setRole(Set<RoleEntity> role) {
        this.role = role;
    }
//
//    public List<Picture> getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(List<Picture> pictures) {
//        this.pictures = pictures;
//    }
//
//    public Set<User> getFollowers() {
//        return followers;
//    }
//
//    public void setFollowers(Set<User> followers) {
//        this.followers = followers;
//    }
//
//    public Set<User> getFollowing() {
//        return following;
//    }
//
//    public void setFollowing(Set<User> following) {
//        this.following = following;
//    }
}
