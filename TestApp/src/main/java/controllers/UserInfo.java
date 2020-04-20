package controllers;

import models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserInfo {

    public void saveUser(Users user) {
        Transaction transaction = null;
        Configuration configuration = new Configuration().configure();
        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Users validate(String login, String password) {

        Transaction transaction = null;
        Users user = null;
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration
                .buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (Users) session.createQuery("FROM Users U WHERE U.login = :login")
                    .setParameter("login", login)
                    .uniqueResult();
            transaction.commit();
            session.close();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
}
