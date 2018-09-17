package com.josespx.drinkeros.dao;

import com.josespx.drinkeros.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerDao extends JpaRepository<Worker, Long> {

    List<Worker> findAllByEliminatedEquals(String eliminated);

}
