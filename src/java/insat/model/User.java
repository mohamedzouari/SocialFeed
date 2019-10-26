/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mohamed
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long user_ID;

    @Column(name = "USER_FIRSTNAME")
    private String user_Firstname;

    @Column(name = "USER_LASTNAME")
    private String user_Lastname;

    @Column(name = "USER_EMAIL")
    private String user_Email;

    @Column(name = "USER_BIRTHDATE")
    private String user_Birthdate;

    @Column(name = "USER_PICTURE")
    private String user_Picture;

    @Column(name = "USER_INTRO")
    private String user_Intro;

    @Column(name = "USER_NUMBER")
    private long user_Number;

    @Column(name = "USER_PASSWORD")
    private String user_Password;

    public User() {
    }

    public User(long user_ID, String user_Firstname, String user_Lastname, String user_Email, String user_Birthdate, String user_Picture, String user_Intro, long user_Number, String user_Password) {
        this.user_ID = user_ID;
        this.user_Firstname = user_Firstname;
        this.user_Lastname = user_Lastname;
        this.user_Email = user_Email;
        this.user_Birthdate = user_Birthdate;
        this.user_Picture = user_Picture;
        this.user_Intro = user_Intro;
        this.user_Number = user_Number;
        this.user_Password = user_Password;
    }

    public String getUser_Birthdate() {
        return user_Birthdate;
    }

    public void setUser_Birthdate(String user_Birthdate) {
        this.user_Birthdate = user_Birthdate;
    }

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_Firstname() {
        return user_Firstname;
    }

    public void setUser_Firstname(String user_Firstname) {
        this.user_Firstname = user_Firstname;
    }

    public String getUser_Lastname() {
        return user_Lastname;
    }

    public void setUser_Lastname(String user_Lastname) {
        this.user_Lastname = user_Lastname;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public String getUser_Picture() {
        return user_Picture;
    }

    public void setUser_Picture(String user_Picture) {
        this.user_Picture = user_Picture;
    }

    public String getUser_Intro() {
        return user_Intro;
    }

    public void setUser_Intro(String user_Intro) {
        this.user_Intro = user_Intro;
    }

    public long getUser_Number() {
        return user_Number;
    }

    public void setUser_Number(long user_Number) {
        this.user_Number = user_Number;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

}
