/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.service;

import insat.dao.RateDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Madou
 */
public class RateServiceImpl implements RateService {

    @Autowired
    RateDaoImpl rateDao;

    @Override
    public void addLike(long Post_Id, long user_ID) {
        rateDao.addLike(Post_Id, user_ID);
    }

    @Override
    public void addDislike(long Post_Id, long user_ID) {
        rateDao.addDislike(Post_Id, user_ID);
    }

}
