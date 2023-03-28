package com.example.springch11.controllers;

import com.example.springch11.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;
import java.util.logging.Logger;

@Controller
public class PaymentsController {
  private static Logger logger = Logger.getLogger(PaymentsController.class.getName());

  @PostMapping("/payment")
  public ResponseEntity<Payment> createPayment(
          @RequestHeader String requestId, @RequestBody Payment payment
  ){
    logger.info("Received Request with ID " + requestId+" ;Payment Amount: " + payment.getAmount());
    payment.setId(UUID.randomUUID().toString());

    return ResponseEntity.status(HttpStatus.OK).header("requestId", requestId).body(payment);
  }
}
