package br.com.tr.employee.controller.form;

import br.com.tr.employee.model.Client;
import br.com.tr.employee.repository.ClientRepository;

import org.hibernate.validator.constraints.Length;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientFormUpdate {
    @NotNull @NotEmpty @Length(min = 5)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client update(UUID id, ClientRepository clientRepository) {
        Client client = clientRepository.getOne(id);

        client.setName(this.name);

        return client;
    }
}
