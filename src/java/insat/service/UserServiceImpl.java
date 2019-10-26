/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.service;

import insat.dao.UserDaoImpl;
import insat.model.Login;
import insat.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohamed
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDao;

    public void register(User user) {
        userDao.register(user);
    }

    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }

    public List<User> userSearch(String name) {
        return userDao.userSearch(name);
    }

    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

}
