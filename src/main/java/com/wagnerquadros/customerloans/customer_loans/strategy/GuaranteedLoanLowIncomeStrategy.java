package com.wagnerquadros.customerloans.customer_loans.strategy;

import com.wagnerquadros.customerloans.customer_loans.dto.CustomerLoanRequestDto;
import com.wagnerquadros.customerloans.customer_loans.dto.LoanDto;
import org.springframework.stereotype.Component;

@Component
public class GuaranteedLoanLowIncomeStrategy implements LoanStrategy{

    //Conceder o empréstimo com garantia se o salário do cliente for igual ou inferior a R$ 3000.

    @Override
    public boolean isEligible(CustomerLoanRequestDto dto) {
        return dto.income() <= 3000;
    }

    @Override
    public LoanDto getLoan() {
        return new LoanDto("GUARANTEED", 3);
    }
}
