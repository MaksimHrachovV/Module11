package goit.hibernate;

import goit.client.Client;
import goit.planet.Planet;
import goit.ticket.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    static {
        INSTANCE = new HibernateUtil();
    }
    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

    }
    public static HibernateUtil getInstance() {
        return INSTANCE;
    }
    public void close() {
        sessionFactory.close();
    }

}
