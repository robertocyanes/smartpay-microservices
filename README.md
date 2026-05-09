# 🟢 SmartPay - Microservices Platform

Plataforma de pagamentos distribuída baseada em arquitetura de microserviços com Spring Boot, Spring Cloud, RabbitMQ e Docker.

O projeto simula um ecossistema real de pagamentos com comunicação síncrona e assíncrona, service discovery, API Gateway e mensageria.

---

## 📌 Visão Geral

O SmartPay é um sistema de microserviços que simula um fluxo completo de pagamentos:

- Criação de pagamentos
- Processamento de transações
- Notificações assíncronas
- Comunicação via mensageria (RabbitMQ)
- Roteamento centralizado via API Gateway
- Registro e descoberta de serviços via Eureka

---

## 🧱 Arquitetura

                ┌──────────────────────┐
                │    API Gateway       │
                │  Spring Cloud Gate.  │
                └─────────┬────────────┘
                          │
    ┌─────────────────────┼─────────────────────┐
    │                     │                     │

┌───────────────┐ ┌──────────────────┐ ┌──────────────────┐
│ Payment │ │ Transaction │ │ Notification │
│ Service │ │ Service │ │ Service │
└──────┬────────┘ └──────┬───────────┘ └──────┬───────────┘
│ │ │
└──────────┬────────┴──────────┬──────────┘
│ │
┌──────────────┐
│ RabbitMQ │
└──────────────┘
│
┌──────────────────┐
│ Eureka Server │
└──────────────────┘


---

## 🚀 Tecnologias Utilizadas

### Backend
- Java 21
- Spring Boot 3.3+
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka
- Spring Data JPA
- Spring AMQP (RabbitMQ)
- H2 Database

### Infraestrutura
- Docker & Docker Compose
- RabbitMQ (Management Plugin)
- Eureka Server

### Testes
- JUnit 5
- Spring Boot Test
- Testes manuais com Postman

### DevOps / CI-CD
- GitHub Actions
- Maven
- Docker Build Pipeline

---

## 🧩 Microserviços

### 📡 Discovery Server (Eureka)
- Porta: `8761`
- Responsável por registrar e descobrir serviços

---

### 🌐 Gateway Service
- Porta: `8080`
- Centraliza todas as requisições

Rotas:
- `/payments/**` → Payment Service
- `/transactions/**` → Transaction Service

---

### 💰 Payment Service
- Porta: `8081`

Responsável por:
- Criar pagamentos
- Publicar eventos no RabbitMQ
- Persistência em banco H2

---

### 🟢 Transaction Service
- Porta: `8083`

Responsável por:
- Consumir mensagens do RabbitMQ
- Processar transações
- Persistir histórico

---

### 🟢 Notification Service
- Porta: `8084`

Responsável por:
- Consumir eventos do RabbitMQ
- Simular envio de notificações

---

### 🟢 RabbitMQ
- AMQP: `5672`
- Dashboard: `15672`

Responsável por:
- Mensageria assíncrona
- Comunicação entre serviços

---

## 🔄 Fluxo do Sistema


Payment Service
↓
RabbitMQ
↓
Transaction Service
↓
Notification Service


---

## ⚙️ Configuração dos Serviços

Exemplo padrão de configuração:

```properties
spring.application.name=payment-service

eureka.client.service-url.defaultZone=http://discovery-server:8761/eureka/

spring.rabbitmq.host=rabbitmq
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
🟢 Docker
Subir todo o ambiente:
docker compose down -v
docker compose up --build

Inclui:

Eureka Server
Gateway
Payment Service
Transaction Service
Notification Service
RabbitMQ
🔐 Segurança e CI/CD

Este projeto segue boas práticas de segurança em pipelines:

❌ O que NÃO é feito
Nenhuma senha ou token é versionado
Nenhuma credencial exposta no código
Nenhum usuário Docker fixo no repositório
✅ O que é usado
GitHub Secrets
Variáveis de ambiente (.env)
Tokens temporários de CI/CD
🔑 Autenticação em CI/CD

Em pipelines automatizados:

GitHub Actions usa secrets.GITHUB_TOKEN
Docker Hub usa:
DOCKER_USERNAME
DOCKER_PASSWORD

Exemplo:

echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin
🟢 Testes
Testes Manuais
Teste Automatizados (Cypress)
Postman
Endpoints REST:
/payments
/transactions
Testes Automatizados
JUnit 5
Spring Boot Test
Testes de contexto

🟢 Fluxo Completo
Usuário cria pagamento
Payment Service processa
Evento enviado ao RabbitMQ
Transaction Service consome evento
Notification Service reage
Eureka mantém descoberta de serviços
Gateway centraliza requisições

🟢 Conceitos Aplicados
Arquitetura de microserviços
Comunicação assíncrona (RabbitMQ)
API Gateway
Service Discovery (Eureka)
Dockerização completa
CI/CD básico
Testes automatizados
Mensageria distribuída

🟢Como rodar localmente
git clone <repo>
cd smartpay
docker compose up --build

📌 Status do Projeto
✔ Microserviços funcionando
✔ RabbitMQ integrado
✔ Eureka Server ativo
✔ Gateway configurado
✔ Docker funcionando
✔ Mensageria implementada
✔ Testes estruturados
✔ CI/CD base pronto

 Autor Roberto César Yanes
  
