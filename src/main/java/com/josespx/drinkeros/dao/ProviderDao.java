package com.josespx.drinkeros.dao;

import com.josespx.drinkeros.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderDao extends JpaRepository<Provider, Long> {
}
