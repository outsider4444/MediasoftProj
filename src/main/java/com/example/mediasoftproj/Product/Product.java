package com.example.mediasoftproj.Product;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String article;

    @NotBlank
    @Column(nullable = false)
    private String name;

    private String description;

    @NotBlank
    @Column(nullable = false)
    private String category;

    @NotNull
    @Positive
    @Column(nullable = false)
    private double price;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private int quantity;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_quantity_change")
    private Date lastQuantityChange;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    // Геттеры и сеттеры
    public Product() {

    }
    public Product(UUID id, String sku, String name, String description, String category, double price, int quantity, Date lastQuantityChange, Date createdAt) {
        this.id = id;
        this.article = sku;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.lastQuantityChange = lastQuantityChange;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
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
