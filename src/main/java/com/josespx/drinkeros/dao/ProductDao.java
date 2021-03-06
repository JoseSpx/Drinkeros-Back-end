package com.josespx.drinkeros.dao;

import com.josespx.drinkeros.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findAllByEliminatedEquals(String eliminated);

}
