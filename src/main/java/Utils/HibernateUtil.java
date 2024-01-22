/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
        //Asi va a pillar el xml por defecto
        //si quiero uno diferente lo tengo que especificar
        // en el configure
    }

    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}
