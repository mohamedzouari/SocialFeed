/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.dao;

/**
 *
 * @author Madou
 */
public interface RateDao {

    public void addLike(long Post_Id, long user_ID);

    public void addDislike(long Post_Id, long user_ID);

}
