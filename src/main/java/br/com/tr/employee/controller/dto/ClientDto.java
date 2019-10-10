package br.com.tr.employee.controller.dto;

import br.com.tr.employee.model.Client;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClientDto {

    private UUID client_id;
    private String name;

    public ClientDto(Client client) {
        this.client_id = client.getId();
        this.name = client.getName();
    }

    public static List<ClientDto> converter(List<Client> clients) {
        return  clients.stream().map(ClientDto::new).collect(Collectors.toList());
    }

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