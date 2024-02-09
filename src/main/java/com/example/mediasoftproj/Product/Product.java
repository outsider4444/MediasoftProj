package com.example.mediasoftproj.Product;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sku;

    private String name;
    private String description;
    private String category;
    private double price;
    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_quantity_change")
    private Date lastQuantityChange;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    // Геттеры и сеттеры
    public Product() {

    }
    public Product(Long id, String sku, String name, String description, String category, double price, int quantity, Date lastQuantityChange, Date createdAt) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.lastQuantityChange = lastQuantityChange;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getLastQuantityChange() {
        return lastQuantityChange;
    }

    public void setLastQuantityChange(Date lastQuantityChange) {
        this.lastQuantityChange = lastQuantityChange;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
