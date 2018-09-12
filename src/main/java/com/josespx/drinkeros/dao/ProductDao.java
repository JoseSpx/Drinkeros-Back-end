package com.josespx.drinkeros.dao;

import com.josespx.drinkeros.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
