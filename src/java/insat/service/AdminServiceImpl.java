/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.service;

import insat.dao.AdminDaoImpl;
import insat.model.Admin;
import insat.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Madou
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDaoImpl adminDao;

    @Override
    public Admin validateAdmin(Login login) {
        return adminDao.validateAdmin(login);
    }

}
