package com.josespx.drinkeros.dao;

import com.josespx.drinkeros.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDao extends JpaRepository<Client, Long> {

    List<Client> findAllByEliminatedEquals(String eliminated);

}
