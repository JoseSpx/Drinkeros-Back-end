package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.Dao;
import com.josespx.drinkeros.model.Client;

import java.util.List;

public interface ClientService extends Dao<Client, Long> {

    @Override
    void save(Client client);

    @Override
    Client findById(Long id);

    @Override
    List<Client> findAll();

    @Override
    void delete(Long id);
}
