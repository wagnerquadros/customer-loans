# 📊 Customer Loans API

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Status](https://img.shields.io/badge/status-em%20desenvolvimento-lightgrey)]()

Este projeto é uma **API REST para análise de elegibilidade de empréstimos**, desenvolvida com **Spring Boot** para fins de estudo.

A aplicação determina quais tipos de empréstimo um cliente pode acessar com base em sua **renda**, **idade** e **localização**.

---

## ⚙️ Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.3
- Lombok
- JUnit 5
- MockMvc (testes)
- Maven

---

## 💡 Padrões e práticas aplicadas

- Utilização do padrão de projeto **Strategy** para encapsular as regras de negócio.
- Estrutura modular com **DTOs**, **Service** e **Controller** bem separados.
- Testes automatizados com **MockMvc** cobrindo os principais cenários.

---

## ✅ Funcionalidade principal

### Endpoint

```http
POST /customer-loans
```

### Exemplo de requisição

```json
{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 7000.00,
  "location": "SP"
}
```

### Exemplo de resposta

```json
{
  "customer": "Vuxaywua Zukiagou",
  "loans": [
    {
      "type": "CONSIGNMENT",
      "interest_rate": 2
    }
  ]
}
```

---

## 🧪 Testes automatizados

- Testes criados com `MockMvc` para simular requisições REST.
- Validação completa das regras de concessão de empréstimos:
  - Renda até R$ 3.000
  - Jovem em SP com renda média
  - Renda acima de R$ 5.000
  - Casos limite e sem elegibilidade

---

## 📚 Objetivo

Este projeto foi criado com o propósito de **estudo e prática de boas práticas em APIs Java**, como:
- Organização de camadas
- Testes automatizados
- Uso de padrões de projeto

> **Não há persistência de dados**, autenticação ou integração externa — foco exclusivo na lógica de negócio.

---

## 👨‍💻 Autor

Desenvolvido por [Wagner Quadros](https://github.com/wagnerquadros)