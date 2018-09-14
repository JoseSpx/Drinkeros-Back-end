package com.josespx.drinkeros.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.josespx.drinkeros.model.Product;
import com.josespx.drinkeros.model.ProductPrice;
import com.josespx.drinkeros.model.ProductStock;
import com.josespx.drinkeros.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ProductController {

    private ProductService productService;

    interface ProductDetail extends Product.Basic, ProductPrice.Basic, ProductStock.Basic {}

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @JsonView(ProductDetail.class)
    @RequestMapping(value = "/products", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Product> save(@Valid @RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @JsonView(ProductDetail.class)
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Product product = this.productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @JsonView(ProductDetail.class)
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {
        List<Product> productList = this.productService.findAllByEliminatedEquals("0");
        if (productList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @JsonView(ProductDetail.class)
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Product> update(@PathVariable("id") Long id,@Valid @RequestBody Product product,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Product productToUpdate = this.productService.findById(id);
        if (productToUpdate == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        productToUpdate.setBrand(product.getBrand());
        productToUpdate.setCodebar(product.getCodebar());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setName(product.getName());
        productToUpdate.getProductPrice().setPurchase(product.getProductPrice().getPurchase());
        productToUpdate.getProductPrice().setSale(product.getProductPrice().getSale());
        productToUpdate.getProductPrice().setWholesale(product.getProductPrice().getWholesale());
        productToUpdate.getProductStock().setMinimun(product.getProductStock().getMinimun());
        productToUpdate.getProductStock().setPhysical(product.getProductStock().getPhysical());
        productToUpdate.getProductStock().setRealp(product.getProductStock().getRealp());

        this.productService.save(productToUpdate);
        return new ResponseEntity<>(productToUpdate, HttpStatus.OK);
    }


    @JsonView(ProductDetail.class)
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
        Product product = this.productService.findById(id);
        if (product == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        product.setEliminated("1");
        this.productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
