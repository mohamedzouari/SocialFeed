/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.service;

import insat.model.Admin;
import insat.model.Login;

/**
 *
 * @author Madou
 */
public interface AdminService {

    public Admin validateAdmin(Login login);

}
