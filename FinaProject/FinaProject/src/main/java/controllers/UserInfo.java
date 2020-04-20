package controllers;

import models.Users;
import org.hibernate.Transaction;

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
//        try (Session session = new AnnotationConfiguration().configure()
//                .buildSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // get an user object
//            user = (Users) session.createQuery("FROM Users U WHERE U.login = :login")
//                    .setParameter("login", login)
//                    .uniqueResult();
//
//            if (user != null && user.getPassword().equals(password)) {
//                return true;
//            }
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
        return false;
    }
}
