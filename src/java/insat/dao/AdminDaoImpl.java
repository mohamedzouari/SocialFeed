/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insat.dao;

import insat.model.Admin;
import insat.model.Login;
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
public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin validateAdmin(Login login) {

        // creating session factory
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .buildSessionFactory(serviceRegistry);

        //creating session
        Session session = factory.openSession();
        List<Admin> admin;
        try {

            //start the transaction
            session.beginTransaction();
            //save the user object
            String query = "from Admin as A where A.admin_Email='" + login.getEmail() + "' and A.admin_Password='" + login.getPassword() + "'";
            System.out.println("query is : " + query);
            admin = session.createQuery(query).list();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            session.close();
        }

        if (!admin.isEmpty()) {
            return admin.get(0);
        }
        return null;
    }

}
