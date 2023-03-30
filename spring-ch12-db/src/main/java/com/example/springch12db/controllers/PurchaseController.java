package com.example.springch12db.controllers;

import com.example.springch12db.model.Purchase;
import com.example.springch12db.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
  private final PurchaseRepository purchaseRepository;

  public PurchaseController(PurchaseRepository purchaseRepository){
    this.purchaseRepository = purchaseRepository;
  }

  @PostMapping
  public void storePurchase(@RequestBody Purchase purchase){
    purchaseRepository.storePurchase(purchase);
  }

  @GetMapping
  public List<Purchase> findPurchases(){
    return purchaseRepository.findAllPurchases();
  }
}
