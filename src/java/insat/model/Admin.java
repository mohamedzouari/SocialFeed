/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Madou
 */
@Entity
@Table(name = "ADMIN")
public class Admin implements Serializable {

    @Id
    @Column(name = "ADMIN_ID")
    private long admin_ID;

    @Column(name = "ADMIN_NAME")
    private String admin_Name;

    @Column(name = "ADMIN_EMAIL")
    private String admin_Email;

    @Column(name = "ADMIN_PASSWORD")
    private String admin_Password;

    public Admin() {
    }

    public Admin(long admin_ID, String admin_Name, String admin_Email, String admin_Password) {
        this.admin_ID = admin_ID;
        this.admin_Name = admin_Name;
        this.admin_Email = admin_Email;
        this.admin_Password = admin_Password;
    }

    public long getAdmin_ID() {
        return admin_ID;
    }

    public void setAdmin_ID(long admin_ID) {
        this.admin_ID = admin_ID;
    }

    public String getAdmin_Name() {
        return admin_Name;
    }

    public void setAdmin_Name(String admin_Name) {
        this.admin_Name = admin_Name;
    }

    public String getAdmin_Email() {
        return admin_Email;
    }

    public void setAdmin_Email(String admin_Email) {
        this.admin_Email = admin_Email;
    }

    public String getAdmin_Password() {
        return admin_Password;
    }

    public void setAdmin_Password(String admin_Password) {
        this.admin_Password = admin_Password;
    }

}
