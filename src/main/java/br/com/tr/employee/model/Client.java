package br.com.tr.employee.model;

import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    private String name;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}