package com.wagnerquadros.customerloans.customer_loans;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CustomerLoansControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void LowIncomeCustomerEligibleForPersonalAndGuaranteed() throws Exception {
        String jsonRequest = """
            {
                "age": 40,
                "cpf": "111.111.111-11",
                "name": "Low income customer",
                "income": 2500.00,
                "location": "RJ"
            }
        """;

        mockMvc.perform(post("/customer-loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loans.length()").value(2))
                .andExpect(jsonPath("$.loans[?(@.type == 'PERSONAL')]").exists())
                .andExpect(jsonPath("$.loans[?(@.type == 'GUARANTEED')]").exists());
    }

    @Test
    void MiddleIncomeCustomerFromSpEligibleForPersonalAndGuaranteed() throws Exception {
        String jsonRequest = """
            {
                "age": 25,
                "cpf": "222.222.222-22",
                "name": "Middle income customer from SP",
                "income": 4000.00,
                "location": "SP"
            }
        """;

        mockMvc.perform(post("/customer-loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loans.length()").value(2))
                .andExpect(jsonPath("$.loans[?(@.type == 'PERSONAL')]").exists())
                .andExpect(jsonPath("$.loans[?(@.type == 'GUARANTEED')]").exists());
    }

    @Test
    void HighIncomeCustomerEligibleForConsignment() throws Exception {
        String jsonRequest = """
            {
                "age": 35,
                "cpf": "333.333.333-33",
                "name": "Alta Renda",
                "income": 8000.00,
                "location": "MG"
            }
        """;

        mockMvc.perform(post("/customer-loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loans.length()").value(1))
                .andExpect(jsonPath("$.loans[0].type").value("CONSIGNMENT"))
                .andExpect(jsonPath("$.loans[0].interest_rate").value(2));
    }

    @Test
    void MiddleIncomeYongCustomerNotEligibleForLoans() throws Exception {
        String jsonRequest = """
            {
                "age": 28,
                "cpf": "444.444.444-44",
                "name": "Yong Customer middle income from MG",
                "income": 4000.00,
                "location": "MG"
            }
        """;

        mockMvc.perform(post("/customer-loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loans.length()").value(0));
    }

    @Test
    void HighIncomeYongCustomerFromSpEligibleForConsignment() throws Exception {
        String jsonRequest = """
            {
                "age": 29,
                "cpf": "666.666.666-66",
                "name": "Renda Limite 5000",
                "income": 5000.00,
                "location": "SP"
            }
        """;

        mockMvc.perform(post("/customer-loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loans.length()").value(1))
                .andExpect(jsonPath("$.loans[0].type").value("CONSIGNMENT"));
    }
}
