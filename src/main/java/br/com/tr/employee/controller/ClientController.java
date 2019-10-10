package br.com.tr.employee.controller;

import br.com.tr.employee.controller.dto.ClientDto;
import br.com.tr.employee.controller.form.ClientForm;
import br.com.tr.employee.controller.form.ClientFormUpdate;
import br.com.tr.employee.model.Client;
import br.com.tr.employee.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<ClientDto> get() {
        List<Client> clients = clientRepository.findAll();
        return ClientDto.converter(clients);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClientDto> add(@RequestBody @Valid ClientForm form, UriComponentsBuilder uriBuilder) {
        Client client = form.converter();
        clientRepository.save(client);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDto(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable UUID id) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            return ResponseEntity.ok(new ClientDto(client.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClientDto> update(@PathVariable UUID id, @RequestBody @Valid ClientFormUpdate form) {
        Optional<Client> optional = clientRepository.findById(id);

        if (optional.isPresent()) {
            Client client = form.update(id, clientRepository);
            return ResponseEntity.ok(new ClientDto(client));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete (@PathVariable UUID id) {
        Optional<Client> optional = clientRepository.findById(id);

        if (optional.isPresent()) {
            clientRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}