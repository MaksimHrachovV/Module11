package goit.ticket;

import goit.client.Client;
import goit.exception.CustomException;
import goit.hibernate.HibernateUtil;
import goit.planet.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {
    public void create(Client client, Planet from_Planet, Planet to_Planet) throws CustomException {
        if (client.equals("") && from_Planet.equals("") && to_Planet.equals("")) {

            throw new CustomException("Name can't be null");
        }
        else if (from_Planet.getId().length() < 1 | from_Planet.getId().length() > 500) {
            throw new CustomException("Name must be more than 1 characters and less than 500 characters");
        }
        else if (to_Planet.getId().length() < 1 | to_Planet.getId().length() > 500) {
            throw new CustomException("Name must be more than 1 characters and less than 500 characters");
        }else {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Ticket newTicket = new Ticket();
            newTicket.setClient(client);
            newTicket.setFrom_Planet(from_Planet);
            newTicket.setTo_Planet(to_Planet);
            session.persist(newTicket);
            System.out.println("newTicket = " + newTicket);
            transaction.commit();
            session.close();}
    }
    public void getById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        System.out.println("Ticket getById = " + ticket);
        session.close();
    }
    public void listAll() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Ticket> fromTicketList = session.createQuery("from Ticket", Ticket.class).list();
        System.out.println("fromClientList = " + fromTicketList);
        session.close();
    }
    public void setFromPlanet(long id, Planet from_Planet) throws CustomException {
        if (from_Planet.equals("")) {
            throw new CustomException("Name can't be null");
        }
        else if (from_Planet.getName().length() < 1 | from_Planet.getName().length()> 500) {
            throw new CustomException("Name must be more than 1 characters and less than 500 characters");
        }else {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Ticket ticketExisting = session.get(Ticket.class, id);
            ticketExisting.setFrom_Planet(from_Planet);
            session.persist(ticketExisting);
            transaction.commit();
            session.close();}
    }
    public void setToPlanet(long id, Planet to_Planet) throws CustomException {
        if (to_Planet.equals("")) {
            throw new CustomException("Name can't be null");
        }
        else if (to_Planet.getName().length() < 1 | to_Planet.getName().length()> 500) {
            throw new CustomException("Name must be more than 1 characters and less than 500 characters");
        }else {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Ticket ticketExisting = session.get(Ticket.class, id);
            ticketExisting.setTo_Planet(to_Planet);
            session.persist(ticketExisting);
            transaction.commit();
            session.close();}
    }
    public void deleteById(long id) {

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket delTicket = new Ticket();
        delTicket.setId(id);
        session.delete(delTicket);
        transaction.commit();
        session.close();
    }
}
