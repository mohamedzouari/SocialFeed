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
 * @author Madou
 */
@Entity
@Table(name = "RATE")
public class Rate implements Serializable {

    @Id
    @Column(name = "RATE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long rate_ID;

    @Column(name = "USER_ID")
    private long rate_user_ID;

    @Column(name = "POST_ID")
    private long rate_post_ID;

    @Column(name = "RATE_VALUE")
    private int rate_Value;

    public Rate(long rate_ID, long rate_user_ID, long rate_post_ID, int rate_Value) {
        this.rate_ID = rate_ID;
        this.rate_user_ID = rate_user_ID;
        this.rate_post_ID = rate_post_ID;
        this.rate_Value = rate_Value;
    }

    public Rate() {
    }

    public long getRate_ID() {
        return rate_ID;
    }

    public void setRate_ID(long rate_ID) {
        this.rate_ID = rate_ID;
    }

    public long getRate_user_ID() {
        return rate_user_ID;
    }

    public void setRate_user_ID(long rate_user_ID) {
        this.rate_user_ID = rate_user_ID;
    }

    public long getRate_post_ID() {
        return rate_post_ID;
    }

    public void setRate_post_ID(long rate_post_ID) {
        this.rate_post_ID = rate_post_ID;
    }

    public int getRate_Value() {
        return rate_Value;
    }

    public void setRate_Value(int rate_Value) {
        this.rate_Value = rate_Value;
    }

    @Override
    public String toString() {
        return "Rate{" + "rate_ID=" + rate_ID + ", rate_user_ID=" + rate_user_ID + ", rate_post_ID=" + rate_post_ID + ", rate_Value=" + rate_Value + '}';
    }

}
