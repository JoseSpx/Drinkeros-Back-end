package com.josespx.drinkeros.dao;

import com.josespx.drinkeros.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderDao extends JpaRepository<Provider, Long> {

    List<Provider> findAllByEliminatedEquals(String eliminated);

}
