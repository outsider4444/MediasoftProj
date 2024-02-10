package com.example.mediasoftproj.Product.controllers;

import com.example.mediasoftproj.Product.Product;
import com.example.mediasoftproj.Product.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ModelAndView getAllProducts() {
        Iterable<Product> productList = productService.getAllProducts();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("productList", productList);
        Product product = new Product();
        mav.addObject("product", product);
        return mav;
    }

    @PostMapping("/")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) {
        productService.saveOrUpdateProduct(product);
        return getAllProducts();
    }

    @GetMapping("/{id}/change")
    public ModelAndView getProductToChange(@PathVariable( value = "id") UUID id) {
        Optional<Product> product = productService.getProductById(id);
        ModelAndView mav = new ModelAndView("change");
        mav.addObject("product", product);
        UUID product_id = product.get().getId();
        mav.addObject("product_id", product_id);
        return mav;
    }

    @RequestMapping(value = "/{id}/change", method = {RequestMethod.PUT, RequestMethod.POST})
    public ModelAndView changeProduct(@PathVariable UUID id, @Valid Product product) {
        productService.saveOrUpdateProduct(product);
        return getAllProducts();
    }

    @RequestMapping(value = "/{id}/delete", method= {RequestMethod.DELETE,RequestMethod.GET})
    public ModelAndView deleteProduct(@PathVariable UUID id){
        productService.deleteProduct(id);
        return getAllProducts();
    }

}
