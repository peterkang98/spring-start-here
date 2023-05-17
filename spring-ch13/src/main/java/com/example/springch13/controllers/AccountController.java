package com.example.springch13.controllers;

import com.example.springch13.dto.TransferRequest;
import com.example.springch13.model.Account;
import com.example.springch13.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
  private final TransferService transferService;

  public AccountController(TransferService transferService){
    this.transferService = transferService;
  }

  @PostMapping("/transfer")
  public void transferMoney(@RequestBody TransferRequest request){
    transferService.transferMoney(
            request.getSenderAccountId(),
            request.getReceiverAccountId(),
            request.getAmount());
  }

  @GetMapping("/accounts")
  public List<Account> getAllAccounts(){
    return transferService.getAllAccounts();
  }
}
