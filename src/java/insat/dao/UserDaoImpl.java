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
import insat.model.Post;
import insat.model.Rate;
import insat.model.User;
import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;

public class UserDaoImpl implements UserDao {

    public void register(User user) {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory(serviceRegistry);

        //creating session
        Session session = factory.openSession();

        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            session.save(user);
            //commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        System.out.println("Registering user with name : " + user.getUser_Firstname());
    }

    public User validateUser(Login login) {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory(serviceRegistry);

        //creating session
        Session session = factory.openSession();
        List<User> user;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from User as u where u.user_Email='" + login.getEmail() + "' and u.user_Password='" + login.getPassword() + "'";
            System.out.println("query is : " + query);
            user = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }

        if (!user.isEmpty()) {
            return user.get(0);
        }
        return null;

    }

    public List<User> userSearch(String name) {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory(serviceRegistry);

        //creating session
        Session session = factory.openSession();
        List<User> user;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from User as u where lower(u.user_Firstname) like lower('%" + name + "%') or lower(u.user_Lastname) like lower('%" + name + "%') or u.user_Email='" + name + "' or str(u.user_Number)='" + name + "' or concat(u.user_Firstname, ' ', u.user_Lastname)='" + name + "' or concat(u.user_Lastname, ' ', u.user_Firstname)='" + name + "'";
            System.out.println("query is : " + query);
            user = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }

        return user;
    }

    public User getUser(long id) {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory(serviceRegistry);

        //creating session
        Session session = factory.openSession();
        List<User> user;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from User as u where u.user_ID=" + id;
            System.out.println("query is : " + query);
            user = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }

        if (!user.isEmpty()) {
            return user.get(0);
        }
        return null;

    }

    @Override
    public List<User> getUsers() {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory(serviceRegistry);

        //creating session
        Session session = factory.openSession();
        List<User> users = null;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from User";
            System.out.println("query is : " + query);
            users = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }
        return users;
    }

    public List<Rate> getRates(long id) {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Rate.class)
                .buildSessionFactory(serviceRegistry);

        List<Rate> rates = null;
        //creating session
        Session session = factory.openSession();

        String query = "from Rate as r where r.rate_user_ID=" + id;
        System.out.println("query is : " + query);
        rates = session.createQuery(query).list();
        return rates;
    }

    public List<Post> getPosts(long id) {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Post.class)
                .buildSessionFactory(serviceRegistry);

        List<Post> posts = null;
        //creating session
        Session session = factory.openSession();

        String query = "from Post as p where p.post_Owner_ID=" + id;
        System.out.println("query is : " + query);
        posts = session.createQuery(query).list();
        return posts;
    }

    @Override
    public void deleteUser(long id) {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory(serviceRegistry);

        //creating session
        Session session = factory.openSession();
        User user = null;
        try {

            //start the transaction
            session.beginTransaction();
            //get the user object
            user = (User) session.get(User.class, id);
            //get all the rates related to this user and delete them
            List<Rate> rates = null;
            rates = this.getRates(id);

            if (rates != null) {
                for (Rate tmprate : rates) {
                    session.delete(tmprate);
                }
            }
            //get all the posts realted to this user and delete them
            List<Post> posts = null;
            posts = this.getPosts(id);
            if (posts != null) {
                for (Post tmpPost : posts) {
                    session.delete(tmpPost);
                }
            }
            //delete the user
            session.delete(user);

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }
}
