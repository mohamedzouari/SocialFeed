/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.dao;

/**
 *
 * @author Mohamed
 */
import insat.model.Login;
import insat.model.User;
import java.util.List;

public interface UserDao {

    public void register(User user);

    public User validateUser(Login login);

    public List<User> userSearch(String name);

    public User getUser(long id);

    public List<User> getUsers();

    public void deleteUser(long id);
}
