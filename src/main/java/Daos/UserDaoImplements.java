/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import Model.User;
import Utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Alex
 */
public class UserDaoImplements implements AutoCloseable {

    public List<User> getUsers() {
        try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User ", User.class); //  todo:prueba con TypedQuery          
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("error");
            return new ArrayList<>();
        }
    }

    public static User getUserByID(String id)  {
        try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE id = :value", User.class);
            query.setParameter("value", id);
            return query.uniqueResult();
        } catch (Exception e) {
            System.out.println("Error, no encontro el id");
            return null;
        }
    }

    public static List<User> getUserByYearBirth(int yearBirth) {
        try (Session session = (Session) HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE yearBirth = :value", User.class);
            query.setParameter("value", yearBirth);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error, no encontro el año de nacimiento.");
            return null;
        }
    }

    public static boolean insertUser(User user) {
        Transaction tx = null;
        boolean resp = true;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            return resp;
        } catch (Exception e) {
          
            if (tx != null) {
                tx.rollback();
            }
              
            System.err.println(e);
            return false;
        }

    }

    @Override
    public void close() throws Exception {
        System.out.println("ERRORACO");
    }

   

}
