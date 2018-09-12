package com.josespx.drinkeros.model;

import javax.persistence.*;

@Entity
@Table(name = "product_price")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "purchase")
    private Double purchase;

    @Column(name = "sale")
    private Double sale;

    @Column(name = "wholesale")
    private Double wholesale;

    @OneToOne(mappedBy = "productPrice")
    private Product product;

    public ProductPrice() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPurchase() {
        return purchase;
    }

    public void setPurchase(Double purchase) {
        this.purchase = purchase;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Double getWholesale() {
        return wholesale;
    }

    public void setWholesale(Double wholesale) {
        this.wholesale = wholesale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
