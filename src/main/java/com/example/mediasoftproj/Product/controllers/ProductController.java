package com.example.mediasoftproj.Product.controllers;

import com.example.mediasoftproj.Product.Product;
import com.example.mediasoftproj.Product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
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
        ModelAndView mav = getAllProducts();
        return mav;
    }

    @RequestMapping(value = "/{id}", method= {RequestMethod.DELETE,RequestMethod.GET})
    public ModelAndView deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        ModelAndView mav = getAllProducts();
        return mav;
    }

}
