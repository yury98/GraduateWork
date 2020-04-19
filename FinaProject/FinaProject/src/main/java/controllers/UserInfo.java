package controllers;

import models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserInfo {

    public void saveUser(Users user) {
        Transaction transaction = null;
//        try (Session session = new AnnotationConfiguration().configure()
//                .buildSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // save the student object
//            session.save(user);
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
    }

    public boolean validate(String login, String password) {

        Transaction transaction = null;
        Users user = null;
        Configuration config = new Configuration();
        SessionFactory sessionFactory = config.configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            List<Users> users = (List<Users>) session.createQuery("from Users")
                    .list();

            user = users.get(0);

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}
