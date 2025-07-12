package com.wagnerquadros.customerloans.customer_loans.dto;

public record CustomerLoanRequestDto(int age, String cpf, String name, double income, String location) {
}
