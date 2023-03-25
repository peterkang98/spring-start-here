package com.example.springch8.controllers;

import com.example.springch8.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.springch8.model.Product;

@Controller
public class MainController {

  private final ProductService productService;

  public MainController(ProductService productService){
    this.productService = productService;
  }

  @GetMapping("/products")
  public String viewProducts(Model model){
    var products = productService.findAll();
    model.addAttribute("products", products);
    return "products.html";
  }

  @PostMapping("/products")
  public String addProduct(Product p, Model model){
    productService.addProduct(p);

    var products = productService.findAll();
    model.addAttribute("products", products);
    return "products.html";
  }
}
