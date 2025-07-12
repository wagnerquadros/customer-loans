package com.wagnerquadros.customerloans.customer_loans.strategy;

import com.wagnerquadros.customerloans.customer_loans.dto.CustomerLoanRequestDto;
import com.wagnerquadros.customerloans.customer_loans.dto.LoanDto;

public interface LoanStrategy {
    boolean isEligible(CustomerLoanRequestDto dto);
    LoanDto getLoan();
}
