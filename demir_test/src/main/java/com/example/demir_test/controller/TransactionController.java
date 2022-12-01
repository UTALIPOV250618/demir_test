package com.example.demir_test.controller;



import com.example.demir_test.payload.balance.TransactionResponse;
import com.example.demir_test.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/{id}")
    public TransactionResponse subtractPayment(@PathVariable Long id){
        return transactionService.createTransactions(id);
    }
}
