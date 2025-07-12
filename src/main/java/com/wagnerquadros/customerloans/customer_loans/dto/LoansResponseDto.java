package com.wagnerquadros.customerloans.customer_loans.dto;

import java.util.List;

public record LoansResponseDto(String customer, List<LoanDto> loans) {
}
