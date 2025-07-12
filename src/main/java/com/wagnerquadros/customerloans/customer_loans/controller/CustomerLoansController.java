package com.wagnerquadros.customerloans.customer_loans.controller;

import com.wagnerquadros.customerloans.customer_loans.dto.CustomerLoanRequestDto;
import com.wagnerquadros.customerloans.customer_loans.dto.LoansResponseDto;
import com.wagnerquadros.customerloans.customer_loans.service.CustomerLoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
@RequiredArgsConstructor
public class CustomerLoansController {

    private final CustomerLoansService service;



    @PostMapping
    public ResponseEntity<?> getCustomerLoans(@RequestBody CustomerLoanRequestDto requestDto){

        LoansResponseDto response = service.analyzeCustomerLoans(requestDto);
        return ResponseEntity.ok(response);
    }
}
