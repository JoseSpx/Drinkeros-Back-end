package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.Dao;
import com.josespx.drinkeros.model.Product;

import java.util.List;

public interface ProductService extends Dao<Product, Long> {

    @Override
    void save(Product product);

    @Override
    Product findById(Long id);

    @Override
    List<Product> findAll();

    @Override
    void delete(Long id);

    List<Product> findAllByEliminatedEquals(String eliminated);
}
