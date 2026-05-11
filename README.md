# 🟢 SmartPay — Microservices Payment Platform

Plataforma distribuída de pagamentos baseada em arquitetura de microserviços utilizando:

- Java 21
- Spring Boot 3
- Spring Cloud
- RabbitMQ
- Docker
- GitHub Actions
- Cypress
- JWT Authentication

Projeto desenvolvido para fins de estudo, portfólio e demonstração prática de arquitetura moderna backend com microsserviços.

---

# 📌 Repositório Oficial

https://github.com/robertocyanes/smartpay-microservices.git

---

# 🚀 Visão Geral

O SmartPay simula um ecossistema real de pagamentos distribuídos.

O sistema possui:

- API Gateway
- Service Discovery (Eureka)
- Comunicação assíncrona com RabbitMQ
- Microsserviços independentes
- Dockerização completa
- Pipeline CI/CD
- Testes automatizados
- Autenticação JWT
- Arquitetura escalável

---

# 🟢 Arquitetura do Sistema

```text
                ┌──────────────────────┐
                │    API Gateway       │
                │ Spring Cloud Gateway │
                └─────────┬────────────┘
                          │
    ┌─────────────────────┼─────────────────────┐
    │                     │                     │

┌───────────────┐ ┌──────────────────┐ ┌──────────────────┐
│ Payment       │ │ Transaction      │ │ Notification     │
│ Service       │ │ Service          │ │ Service          │
└──────┬────────┘ └──────┬───────────┘ └──────┬───────────┘
       │                  │                    │
       └──────────┬───────┴──────────┬─────────┘
                  │                  │
             ┌──────────────┐
             │   RabbitMQ   │
             └──────────────┘
                     │
             ┌──────────────────┐
             │ Eureka Discovery │
             │      Server      │
             └──────────────────┘
```

---

# 🟢 Microsserviços

## 🌐 Gateway Service

- Porta: `8080`

Responsável por:

- Centralizar requisições
- Validar JWT
- Fazer roteamento entre serviços
- Controlar autenticação

### Rotas

- `/payments/**` → Payment Service
- `/transactions/**` → Transaction Service

---

## 📡 Discovery Server (Eureka)

- Porta: `8761`

Responsável por:

- Registro automático de serviços
- Descoberta dinâmica
- Balanceamento lógico

Dashboard:

```bash
http://localhost:8761
```

---

## 💰 Payment Service

- Porta: `8081`

Responsável por:

- Criar pagamentos
- Persistir dados
- Publicar eventos no RabbitMQ

---

## 💳 Transaction Service

- Porta: `8083`

Responsável por:

- Consumir eventos
- Processar transações
- Persistir histórico

---

## 🔔 Notification Service

- Porta: `8084`

Responsável por:

- Consumir eventos
- Simular notificações
- Logs assíncronos

---

## 🐇 RabbitMQ

- AMQP: `5672`
- Dashboard: `15672`

Painel:

```bash
http://localhost:15672
```

Usuário padrão:

```text
guest
guest
```

---

# 🟢 Fluxo Completo do Sistema

```text
Client Request
       ↓
API Gateway
       ↓
Payment Service
       ↓
RabbitMQ
       ↓
Transaction Service
       ↓
Notification Service
```

---

# 🔐 Segurança com JWT

O projeto utiliza autenticação baseada em JWT no Gateway Service.

## Funcionalidades

- Validação de token
- Filtro JWT customizado
- Rotas protegidas
- Gateway centralizado

## Exemplo Header

```http
Authorization: Bearer TOKEN_AQUI
```

## Variáveis de Ambiente

Exemplo:

```properties
jwt.secret=smartpay-secret-key
jwt.expiration=86400000
```

⚠ Nunca versionar secrets diretamente no repositório.

---

# 🟢 Configuração Base

## application.properties

```properties
spring.application.name=payment-service

eureka.client.service-url.defaultZone=http://discovery-server:8761/eureka/

spring.rabbitmq.host=rabbitmq
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

---

# 🐳 Docker

## Subir Ambiente Completo

```bash
docker compose down -v

docker compose up --build
```

---

# 📦 Containers Esperados

- Eureka Server
- Gateway Service
- Payment Service
- Transaction Service
- Notification Service
- RabbitMQ

---

# 🟢 Testes

## ✅ Testes Automatizados

### JUnit 5

- Testes de contexto
- Testes de integração
- Spring Boot Test

### Cypress

- Fluxo de pagamentos
- Gateway
- APIs REST

---

## ✅ Testes Manuais

Ferramentas:

- Postman
- Insomnia

---

# 📡 Endpoints

## Payments

```http
POST /payments
GET /payments
```

---

## Transactions

```http
GET /transactions
```

---

# ⚡ CI/CD — GitHub Actions

O projeto possui pipeline automatizada utilizando GitHub Actions.

## Pipeline Executa

- Build Maven
- Execução de testes
- Validação de projeto
- Docker Build
- Workflow automatizado

---

# 🔒 Boas Práticas de Segurança

## ❌ Não utilizado

- Senhas hardcoded
- Tokens expostos
- Credenciais no Git

---

## ✅ Utilizado

- GitHub Secrets
- Variáveis de ambiente
- Docker environment variables
- JWT Authentication

---

# 🟢 Tecnologias Utilizadas

## Backend

- Java 21
- Spring Boot 3.3+
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka
- Spring Security
- Spring AMQP
- Spring Data JPA
- H2 Database
- JWT (jjwt)

---

## Infraestrutura

- Docker
- Docker Compose
- RabbitMQ
- Eureka Server

---

## Testes

- JUnit 5
- Spring Boot Test
- Cypress

---

## DevOps

- GitHub Actions
- Maven
- Docker Pipeline

---

# 📁 Estrutura do Projeto

```text
smartpay/
│
├── discovery-server/
├── gateway-service/
├── payment-service/
├── transaction-service/
├── notification-service/
├── cypress-tests/
│
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

# ▶ Como Rodar Localmente

## 1️⃣ Clonar repositório

```bash
git clone https://github.com/robertocyanes/smartpay-microservices.git
```

---

## 2️⃣ Entrar na pasta

```bash
cd smartpay-microservices
```

---

## 3️⃣ Subir containers

```bash
docker compose up --build
```

---

# 📌 Status do Projeto

- Microserviços funcionando
- Eureka Server ativo
- API Gateway funcionando
- RabbitMQ integrado
- Docker funcionando
- JWT implementado
- Cypress configurado
- GitHub Actions ativo
- CI/CD configurado
- Mensageria assíncrona funcionando

---

# 🟢 Conceitos Aplicados

- Arquitetura de Microserviços
- Comunicação Assíncrona
- Mensageria Distribuída
- API Gateway
- Service Discovery
- JWT Authentication
- Dockerização
- CI/CD
- Testes Automatizados
- Event Driven Architecture

---

 Autor: Roberto César Yanes

GitHub:
https://github.com/robertocyanes
