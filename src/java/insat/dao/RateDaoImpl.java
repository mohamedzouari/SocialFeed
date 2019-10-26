/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.dao;

import insat.model.Post;
import insat.model.Rate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Madou
 */
public class RateDaoImpl implements RateDao {

    public void addLike(long Post_Id, long user_ID) {

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

        //creating session
        Session session = factory.openSession();

        Rate rate = new Rate();
        rate.setRate_post_ID(Post_Id);
        rate.setRate_user_ID(user_ID);
        rate.setRate_Value(1);

        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            session.save(rate);
            //commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

    public void addDislike(long Post_Id, long user_ID) {

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

        //creating session
        Session session = factory.openSession();

        Rate rate = new Rate();
        rate.setRate_Value(0);
        rate.setRate_post_ID(Post_Id);
        rate.setRate_user_ID(user_ID);

        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            session.save(rate);
            //commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

}
