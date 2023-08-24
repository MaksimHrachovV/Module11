package goit.planet;

import goit.exception.CustomException;
import goit.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
        public void create(String id, String name) throws CustomException {
        if (id.equals("")) {

            throw new CustomException("Name can't be null");
        }
        else if (name.length() < 1 | name.length() > 500) {
            throw new CustomException("Name must be more than 1 characters and less than 500 characters");
        }else {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet newPlanet = new Planet();
        newPlanet.setId(id);
        newPlanet.setName(name);
        session.persist(newPlanet);
        System.out.println("newClient = " + newPlanet);
        transaction.commit();
        session.close();}
    }

    public void getById(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        System.out.println("planet = " + planet);
        session.close();
    }


    public void setIdName(String id, String name) throws CustomException {
        if (id.equals("")) {
            throw new CustomException("Name can't be null");

        }
        else if (name.length() < 1 | name.length() > 500) {
            throw new CustomException("Name must be more than 1 characters and less than 500 characters");

        }

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        Planet PlanetExisting = session.get(Planet.class, id);
        PlanetExisting.setId(id);
        PlanetExisting.setName(name);
        session.persist(PlanetExisting);
        transaction.commit();
        session.close();

    }


    public void deleteById(String id) {

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet delPlanet = new Planet();
        delPlanet.setId(id);
        session.delete(delPlanet);
        transaction.commit();
        session.close();
    }

    public void listAll() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Planet> fromClientList = session.createQuery("from Planet", Planet.class).list();
        System.out.println("fromClientList = " + fromClientList.toString());
        session.close();
    }
    public Planet getByIdPlanet(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        return session.get(Planet.class, id);
    }
}
