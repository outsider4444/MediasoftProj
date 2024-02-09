package com.example.mediasoftproj.Product.repository;


import com.example.mediasoftproj.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
