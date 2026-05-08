#!/bin/bash

echo "🚀 Iniciando SmartPay Full Stack..."

# =========================
# 1. Subir infraestrutura
# =========================
echo "🐳 Subindo Docker containers..."

docker start smartpay-postgres
docker start smartpay-rabbitmq

echo "⏳ Aguardando infraestrutura..."
sleep 5

# =========================
# 2. Ir para o serviço
# =========================
echo "📦 Indo para o Payment Service..."

cd payment-service/payment-service || {
  echo "❌ Pasta payment-service não encontrada"
  exit 1
}

# =========================
# 3. Subir Spring Boot
# =========================
echo "☕ Subindo Spring Boot..."

nohup mvn spring-boot:run > app.log 2>&1 &

echo "⏳ Aguardando API subir na porta 8082..."
sleep 20

# =========================
# 4. Teste da API
# =========================
echo "🧪 Testando endpoint /payments..."

curl -X POST http://localhost:8082/payments \
  -H "Content-Type: application/json" \
  -d '{
    "description": "TESTE AUTOMÁTICO",
    "amount": 100.0,
    "cardNumber": "123",
    "status": "PENDING"
  }'

echo ""
echo "✅ Finalizado!"
