package goit.planet;

import goit.ticket.Ticket;
import jakarta.persistence.*;

import java.util.Set;

@Table(name="planet")
@Entity
public class Planet {
    @Id
    private String id;
    @Column
    private String name;

    @OneToMany(mappedBy = "from_Planet")
    private Set<Ticket> from_tickets;

    @OneToMany(mappedBy = "to_Planet")
    private Set<Ticket> to_tickets;

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
