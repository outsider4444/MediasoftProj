package com.example.mediasoftproj.Product.repository;


import com.example.mediasoftproj.Product.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}
