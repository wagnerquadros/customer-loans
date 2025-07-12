package com.wagnerquadros.customerloans.customer_loans.service;

import com.wagnerquadros.customerloans.customer_loans.dto.CustomerLoanRequestDto;
import com.wagnerquadros.customerloans.customer_loans.dto.LoanDto;
import com.wagnerquadros.customerloans.customer_loans.dto.LoansResponseDto;
import com.wagnerquadros.customerloans.customer_loans.strategy.LoanStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerLoansService {

    private final List<LoanStrategy> strategies;

    public LoansResponseDto analyzeCustomerLoans (CustomerLoanRequestDto dto) {
        List<LoanDto> loans = new ArrayList<>();

        loans = strategies.stream()
                .filter(strategies -> strategies.isEligible(dto))
                .map(LoanStrategy::getLoan)
                .distinct()
                .toList();

        return new LoansResponseDto(dto.name(), loans);
    }
}
