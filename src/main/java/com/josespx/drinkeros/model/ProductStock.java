package com.josespx.drinkeros.model;

import javax.persistence.*;

@Entity
@Table(name = "product_stock")
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "realp")
    private Double realp;

    @Column(name = "physical")
    private Double physical;

    @Column(name = "minimim")
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

    public Double getRealp() {
        return realp;
    }

    public void setRealp(Double realp) {
        this.realp = realp;
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
