package goit.client;

import goit.exception.CustomException;
import goit.hibernate.HibernateUtil;
import goit.planet.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
public class ClientCrudService {


    public void create(String name) throws CustomException {
        if (name == null) {
            throw new CustomException("Name can't be null");

        }
        else if (name.length() < 3 | name.length() > 200) {
            throw new CustomException("Name must be more than 2 characters and less than 200 characters");

        }else {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();
            Client newClient = new Client();
            newClient.setName(name);
            session.persist(newClient);
            System.out.println("newClient = " + newClient);
            transaction.commit();
            session.close();


        }
    }

    public void getById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        System.out.println("client = " + client);
        session.close();
    }


    public void setName(long id, String name) throws CustomException {
        if (name == null) {
            throw new CustomException("Name can't be null");
        }
        else if (name.length() < 2 | name.length() > 1000) {
            throw new CustomException("Name must be more than 2 characters and less than 200 characters");
        }else {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client clientExisting = session.get(Client.class, id);
        clientExisting.setName(name);
        session.persist(clientExisting);
        transaction.commit();
        session.close();}
    }


    public void deleteById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client delClient = new Client();
        delClient.setId(id);
        session.delete(delClient);
        transaction.commit();
        session.close();
    }

    public void listAll() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Client> fromClientList = session.createQuery("from Client", Client.class).list();
        System.out.println("fromClientList = " + fromClientList);
        session.close();
    }
    public Client getByIdClient(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        return session.get(Client.class, id);
    }
}


