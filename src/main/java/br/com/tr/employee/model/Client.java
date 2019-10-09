package br.com.tr.employee.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    private UUID client_id; 
    private String name;

    public UUID getClient_id() {
        return client_id;
    }

    public void setClient_id(UUID client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}