package com.wagnerquadros.customerloans.customer_loans.strategy;

import com.wagnerquadros.customerloans.customer_loans.dto.CustomerLoanRequestDto;
import com.wagnerquadros.customerloans.customer_loans.dto.LoanDto;
import org.springframework.stereotype.Component;

@Component
public class GuaranteedLoanMiddleIncomeYoungLocationSpStrategy implements LoanStrategy{

    //Conceder o empréstimo com garantia se o salário do cliente estiver entre R$ 3000 e R$ 5000,
    //se o cliente tiver menos de 30 anos e residir em São Paulo (SP).

    @Override
    public boolean isEligible(CustomerLoanRequestDto dto) {
        return dto.income() > 3000
                && dto.income() < 5000
                && dto.age() < 30
                && dto.location().equalsIgnoreCase("SP");
    }

    @Override
    public LoanDto getLoan() {
        return new LoanDto("GUARANTEED", 3);
    }
}
