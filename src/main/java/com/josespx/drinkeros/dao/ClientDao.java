package com.josespx.drinkeros.dao;

import com.josespx.drinkeros.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {

}
