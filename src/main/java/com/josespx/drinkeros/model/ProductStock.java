package com.josespx.drinkeros.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "product_stock")
public class ProductStock {

    public interface Basic {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(Basic.class)
    private Long id;

    @Column(name = "realp")
    @JsonView(Basic.class)
    private Double real;

    @Column(name = "physical")
    @JsonView(Basic.class)
    private Double physical;

    @Column(name = "minimim")
    @JsonView(Basic.class)
    private Double minimun;

    @OneToOne(mappedBy = "productStock")
    private Product product;

    public ProductStock() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getReal() {
        return real;
    }

    public void setReal(Double real) {
        this.real = real;
    }

    public Double getPhysical() {
        return physical;
    }

    public void setPhysical(Double physical) {
        this.physical = physical;
    }

    public Double getMinimun() {
        return minimun;
    }

    public void setMinimun(Double minimun) {
        this.minimun = minimun;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
