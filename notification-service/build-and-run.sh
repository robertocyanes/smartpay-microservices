#!/bin/bash

echo "🔎 Iniciando build dos microserviços..."

SERVICES=("notification-service" "payment-service" "transaction-service" "gateway-service")

for SERVICE in "${SERVICES[@]}"; do
  echo "-----------------------------"
  echo "➡️ Processando $SERVICE"

  cd $SERVICE || { echo "❌ Pasta $SERVICE não encontrada"; exit 1; }

  # Detecta se existe subpasta duplicada
  if [ -d "$SERVICE" ]; then
    echo "⚠️ Estrutura duplicada detectada, entrando em $SERVICE/$SERVICE"
    cd $SERVICE
  fi

  # Verifica se existe mvnw
  if [ -f "mvnw.cmd" ]; then
    echo "🚀 Build com Maven Wrapper..."
    ./mvnw.cmd clean package -DskipTests
  else
    echo "⚠️ mvnw não encontrado, tentando Maven global..."
    mvn clean package -DskipTests
  fi

  if [ $? -ne 0 ]; then
    echo "❌ Erro no build do $SERVICE"
    exit 1
  fi

  echo "✅ Build concluído para $SERVICE"

  cd ../..
done

echo "-----------------------------"
echo "🐳 Subindo containers com Docker..."

docker-compose up --build
