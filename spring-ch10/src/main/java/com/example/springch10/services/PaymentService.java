package com.example.springch10.services;

import com.example.springch10.exceptions.NotEnoughMoneyException;
import com.example.springch10.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
  public PaymentDetails processPayment(){
    throw new NotEnoughMoneyException();
  }
}
