package com.josespx.drinkeros.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.josespx.drinkeros.model.Provider;
import com.josespx.drinkeros.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ProviderController {

    private ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @RequestMapping(value = "/providers", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Provider> save(@Valid @RequestBody Provider provider, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        this.providerService.save(provider);
        return new ResponseEntity<>(provider ,HttpStatus.OK);
    }


    @JsonView(Provider.Basic.class)
    @RequestMapping(value = "/providers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Provider> findById(@PathVariable("id") Long id) {
        Provider provider = this.providerService.findById(id);
        if (provider == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(provider, HttpStatus.OK);
    }

    @JsonView(Provider.Basic.class)
    @RequestMapping(value = "/providers", method = RequestMethod.GET)
    public ResponseEntity<List<Provider>> findAll() {
        List<Provider> providerList = this.providerService.findAllByEliminatedEquals("0");
        if (providerList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(providerList, HttpStatus.OK);
    }

    @JsonView(Provider.Basic.class)
    @RequestMapping(value = "/providers/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Provider> update(@PathVariable("id") Long id,@Valid @RequestBody Provider provider, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Provider providerToUpdate = this.providerService.findById(id);
        if (providerToUpdate == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        providerToUpdate.setName(provider.getName());
        providerToUpdate.setRuc(provider.getRuc());
        providerToUpdate.setAddress(provider.getAddress());
        providerToUpdate.setPhone(provider.getPhone());
        providerToUpdate.setEmail(provider.getEmail());

        this.providerService.save(providerToUpdate);
        return new ResponseEntity<>(providerToUpdate, HttpStatus.OK);
    }

    @JsonView(Provider.Basic.class)
    @RequestMapping(value = "/providers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Provider> delete(@PathVariable("id") Long id) {
        Provider provider = this.providerService.findById(id);
        if (provider == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        provider.setEliminated("1");
        this.providerService.save(provider);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
