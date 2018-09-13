package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.Dao;
import com.josespx.drinkeros.model.Provider;

import java.util.List;

public interface ProviderService extends Dao<Provider, Long> {

    @Override
    void save(Provider provider);

    @Override
    Provider findById(Long id);

    @Override
    List<Provider> findAll();

    @Override
    void delete(Long id);

    List<Provider> findAllByEliminatedEquals(String eliminated);
}
