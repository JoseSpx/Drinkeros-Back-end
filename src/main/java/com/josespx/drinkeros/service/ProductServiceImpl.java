package com.josespx.drinkeros.service;

import com.josespx.drinkeros.dao.ProductDao;
import com.josespx.drinkeros.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void save(Product product) {
        this.productDao.save(product);
    }

    @Override
    public Product findById(Long id) {
        return this.productDao.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return this.productDao.findAll();
    }

    @Override
    public void delete(Long id) {
        this.productDao.deleteById(id);
    }

    @Override
    public List<Product> findAllByEliminatedEquals(String eliminated) {
        return this.productDao.findAllByEliminatedEquals(eliminated);
    }
}
