package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.WorkerDao;
import com.josespx.drinkeros.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class WorkerServiceImpl implements WorkerService {

    private WorkerDao workerDao;

    @Autowired
    public WorkerServiceImpl(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Override
    public void save(Worker worker) {
        this.workerDao.save(worker);
    }

    @Override
    public Worker findById(Long id) {
        return this.workerDao.findById(id).orElse(null);
    }

    @Override
    public List<Worker> findAll() {
        return this.workerDao.findAll();
    }

    @Override
    public void delete(Long id) {
        this.workerDao.deleteById(id);
    }

    @Override
    public List<Worker> findAllByEliminatedEquals(String eliminated) {
        return this.workerDao.findAllByEliminatedEquals(eliminated);
    }
}
