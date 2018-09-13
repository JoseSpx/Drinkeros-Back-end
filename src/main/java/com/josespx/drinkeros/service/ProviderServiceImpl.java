package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.ProviderDao;
import com.josespx.drinkeros.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "providerService")
public class ProviderServiceImpl implements ProviderService {

    private ProviderDao providerDao;

    @Autowired
    public ProviderServiceImpl(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    @Override
    public void save(Provider provider) {
        this.providerDao.save(provider);
    }

    @Override
    public Provider findById(Long id) {
        return this.providerDao.findById(id).orElse(null);
    }

    @Override
    public List<Provider> findAll() {
        return this.providerDao.findAll();
    }

    @Override
    public void delete(Long id) {
        this.providerDao.deleteById(id);
    }

    @Override
    public List<Provider> findAllByEliminatedEquals(String eliminated) {
        return this.providerDao.findAllByEliminatedEquals(eliminated);
    }
}
