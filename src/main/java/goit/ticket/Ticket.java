package goit.ticket;

import goit.client.Client;
import goit.planet.Planet;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name="from_planet_id")
    private Planet from_Planet;
    @ManyToOne
    @JoinColumn(name="to_planet_id")
    private Planet to_Planet;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Planet getFrom_Planet() {
        return from_Planet;
    }

    public void setFrom_Planet(Planet from_Planet) {
        this.from_Planet = from_Planet;
    }

    public Planet getTo_Planet() {
        return to_Planet;
    }

    public void setTo_Planet(Planet to_Planet) {
        this.to_Planet = to_Planet;
    }




    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", client=" + client +
                ", from_Planet=" + from_Planet +
                ", to_Planet=" + to_Planet +
                '}';
    }
}
