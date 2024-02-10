package com.example.mediasoftproj.Product.controllers;

import com.example.mediasoftproj.Product.Product;
import com.example.mediasoftproj.Product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class ProductApiController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public Iterable<Product> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping("/create")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveOrUpdateProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductToChange(@PathVariable("id") UUID id) {
        return productService.getProductById(id);
    }

    @PutMapping(value = "/change")
    public Product changeProduct(@RequestBody Product updateProduct) {
        return productService.saveOrUpdateProduct(updateProduct);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteProduct(@PathVariable("id") UUID id) {
        productService.deleteProduct(id);
    }

}
