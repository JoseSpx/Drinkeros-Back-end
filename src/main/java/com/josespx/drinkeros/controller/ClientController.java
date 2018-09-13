package com.josespx.drinkeros.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.josespx.drinkeros.model.Client;
import com.josespx.drinkeros.model.TypeDocument;
import com.josespx.drinkeros.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ClientController {

    private ClientService clientService;

    interface ClientDetail extends Client.Basic, TypeDocument.Basic {}

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Client> save(@Valid @RequestBody Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        client.setEliminated("0");
        this.clientService.save(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @JsonView(ClientDetail.class)
    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {
        Client client = this.clientService.findById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @JsonView(ClientDetail.class)
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clientList = this.clientService.findAllByEliminatedEquals("0");
        System.out.println("-------------------------------------------------");
        System.out.println(clientList);
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @JsonView(ClientDetail.class)
    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<Client> update(@PathVariable("id") Long id,@RequestBody Client client) {
        Client clientToUpdate = this.clientService.findById(id);
        if (clientToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        clientToUpdate.setDocument(client.getDocument());
        clientToUpdate.setName(client.getName());
        clientToUpdate.setLastName(client.getLastName());
        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setAddress(client.getAddress());
        clientToUpdate.setPhone(client.getPhone());
        clientToUpdate.setTypeDocument(client.getTypeDocument());

        this.clientService.save(clientToUpdate);
        return new ResponseEntity<>(clientToUpdate, HttpStatus.OK);
    }

    @JsonView(ClientDetail.class)
    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> delete(@PathVariable("id") Long id) {
        Client client = this.clientService.findById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        client.setEliminated("1");
        this.clientService.save(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
