/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.dao;

import insat.model.Post;
import insat.model.Rate;
import insat.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Madou
 */
public class PostDaoImpl {

    public void add(Post post) {

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

        //creating session
        Session session = factory.openSession();

        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            session.save(post);
            //commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public List<Post> getPublishedPosts(long userId) {

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

        //creating session
        Session session = factory.openSession();
        List<Post> posts = null;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from Post as p where p.post_Owner_ID=" + userId + " and p.post_Type='PUBLISHED'";
            System.out.println("query is : " + query);
            posts = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }
        return posts;
    }

    public List<Post> getPosts() {

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

        //creating session
        Session session = factory.openSession();
        List<Post> posts = null;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from Post";
            System.out.println("query is : " + query);
            posts = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }
        return posts;
    }

    public List<Post> getPendingPosts(long userId) {
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

        //creating session
        Session session = factory.openSession();
        List<Post> posts = null;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from Post as p where p.post_Owner_ID=" + userId + " and p.post_Type='PENDING'";
            System.out.println("query is : " + query);
            posts = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }
        return posts;
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

    public List<Rate> getRatesForPost(long id) {

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

        String query = "from Rate as r where r.rate_post_ID=" + id;
        System.out.println("query is : " + query);
        rates = session.createQuery(query).list();
        return rates;
    }

    public void deletePost(long id) {

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

        //creating session
        Session session = factory.openSession();
        Post post = null;
        try {

            //start the transaction
            session.beginTransaction();
            //get the user object
            post = (Post) session.get(Post.class, id);
            //get all the rates related to this user and delete them
            List<Rate> rates = null;
            rates = this.getRates(id);

            if (rates != null) {
                for (Rate tmprate : rates) {
                    session.delete(tmprate);
                }
            }

            //delete the post
            session.delete(post);

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }

    public List<Post> getReportedPosts() {

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

        //creating session
        Session session = factory.openSession();
        List<Post> posts = null;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from Post as p where p.post_Reported=true";
            System.out.println("query is : " + query);
            posts = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }
        return posts;
    }
}
