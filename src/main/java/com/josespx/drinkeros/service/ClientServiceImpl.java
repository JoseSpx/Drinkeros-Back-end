package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.ClientDao;
import com.josespx.drinkeros.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "clientService")
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    @Override
    public void save(Client client) {
        this.clientDao.save(client);
    }

    @Override
    public Client findById(Long id) {
        return this.clientDao.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return this.clientDao.findAll();
    }

    @Override
    public void delete(Long id) {
        this.clientDao.deleteById(id);
    }
}
