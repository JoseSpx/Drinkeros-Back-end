package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.Dao;
import com.josespx.drinkeros.model.Worker;

import java.util.List;

public interface WorkerService extends Dao<Worker, Long> {

    @Override
    void save(Worker worker);

    @Override
    Worker findById(Long id);

    @Override
    List<Worker> findAll();

    @Override
    void delete(Long id);
}
