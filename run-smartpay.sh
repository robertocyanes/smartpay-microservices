#!/usr/bin/env bash

set -e

echo "🚀 START SMARTPAY CLEAN RUN"

BASE_URL="http://localhost:8082"

echo "🧪 Teste 1 - Payment válido"

curl -s -X POST "$BASE_URL/payments" \
  -H "Content-Type: application/json" \
  -d '{
    "description": "TESTE CLEAN 1",
    "amount": 100.0,
    "cardNumber": "123456",
    "status": "PENDING"
  }'

echo -e "\n"

echo "🧪 Teste 2 - Payment mínimo válido"

curl -s -X POST "$BASE_URL/payments" \
  -H "Content-Type: application/json" \
  -d '{
    "description": "TESTE CLEAN 2",
    "amount": 10.0,
    "cardNumber": "999999",
    "status": "PENDING"
  }'

echo -e "\n"

echo "🧪 Teste 3 - GET all payments"

curl -s "$BASE_URL/payments"

echo -e "\n"

echo "✅ DONE"
