/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Madou
 */
@Entity
@Table(name = "POST")
public class Post {

    @Id
    @Column(name = "POST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long post_ID;

    @Column(name = "POST_TEXT")
    private String post_Text;

    @Column(name = "POST_IMAGE")
    private String post_Image;

    @Column(name = "POST_STATUS")
    private String post_Status;

    @Column(name = "POST_OWNER_ID")
    private long post_Owner_ID;

    @Column(name = "POST_TYPE")
    private String post_Type;

    @Column(name = "POST_LIKES")
    private int post_Likes;

    @Column(name = "POST_DISLIKES")
    private int post_Dislikes;

    @Column(name = "POST_REPORTED")
    private boolean post_Reported;

    public Post(long post_ID, String post_Text, String post_Image, String post_Status, long post_Owner_ID, int post_Likes, int post_Dislikes) {
        this.post_ID = post_ID;
        this.post_Text = post_Text;
        this.post_Image = post_Image;
        this.post_Status = post_Status;
        this.post_Owner_ID = post_Owner_ID;
        this.post_Type = "PENDING";
        this.post_Likes = post_Likes;
        this.post_Dislikes = post_Dislikes;
        this.post_Reported = false;

    }

    public Post() {
    }

    public boolean isPost_Reported() {
        return post_Reported;
    }

    public void setPost_Reported(boolean post_Reported) {
        this.post_Reported = post_Reported;
    }

    public String getPost_Type() {
        return post_Type;
    }

    public void setPost_Type(String post_Type) {
        this.post_Type = post_Type;
    }

    public long getPost_Owner_ID() {
        return post_Owner_ID;
    }

    public void setPost_Owner_ID(long post_Owner_ID) {
        this.post_Owner_ID = post_Owner_ID;
    }

    public long getPost_ID() {
        return post_ID;
    }

    public void setPost_ID(long post_ID) {
        this.post_ID = post_ID;
    }

    public String getPost_Text() {
        return post_Text;
    }

    public void setPost_Text(String post_Text) {
        this.post_Text = post_Text;
    }

    public String getPost_Image() {
        return post_Image;
    }

    public void setPost_Image(String post_Image) {
        this.post_Image = post_Image;
    }

    public String getPost_Status() {
        return post_Status;
    }

    public void setPost_Status(String post_Status) {
        this.post_Status = post_Status;
    }

    public int getPost_Likes() {
        return post_Likes;
    }

    public void setPost_Likes(int post_Likes) {
        this.post_Likes = post_Likes;
    }

    public int getPost_Dislikes() {
        return post_Dislikes;
    }

    public void setPost_Dislikes(int post_Dislikes) {
        this.post_Dislikes = post_Dislikes;
    }
}
