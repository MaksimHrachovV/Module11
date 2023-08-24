package goit.client;

import goit.ticket.Ticket;
import jakarta.persistence.*;

import java.util.Set;

@Table(name="client")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "client")
    private Set <Ticket> tickets;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
