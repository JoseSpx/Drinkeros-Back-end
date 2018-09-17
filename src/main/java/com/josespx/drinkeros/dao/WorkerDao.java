package com.josespx.drinkeros.dao;

import com.josespx.drinkeros.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerDao extends JpaRepository<Worker, Long> {
}
