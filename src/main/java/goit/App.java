package goit;


import goit.client.Client;
import goit.client.ClientCrudService;
import goit.configFlyway.FlywayConfiguration;
import goit.planet.Planet;
import goit.planet.PlanetCrudService;
import goit.ticket.TicketCrudService;

public class App {
    public static void main(String[] args) throws Exception {


        new FlywayConfiguration().dbStart();

        ClientCrudService clientCrudService=new ClientCrudService();
//        clientCrudService.create("Neerr");
//        clientCrudService.getById(1);
//        clientCrudService.setName(1L,"Mody");
//        clientCrudService.deleteById(11L);
//        clientCrudService.listAll();

        PlanetCrudService planetCrudService=new PlanetCrudService();
//        planetCrudService.listAll();
//        planetCrudService.create("MOON","λύχνος");
//        planetCrudService.getById("MOON");
//        planetCrudService.setIdName("MOON","QQQQ");
//        planetCrudService.deleteById("MOON");

        TicketCrudService ticketCrudService=new TicketCrudService();
        //Create Ticket
        Client clientId=clientCrudService.getByIdClient(1L);
        Planet fromPlanet= planetCrudService.getByIdPlanet("MERCURY1");
        Planet toPlanet= planetCrudService.getByIdPlanet("EARTH3");
        ticketCrudService.create(clientId,fromPlanet,toPlanet);
        //all List
        ticketCrudService.listAll();
        //get Id
        ticketCrudService.getById(1L);
        //Update Ticket toPlanet toPlanet
        ticketCrudService.setFromPlanet(2L,fromPlanet);
        ticketCrudService.setToPlanet(2L,toPlanet);
        //Delete Ticket
        ticketCrudService.deleteById(1L);



    }
}
