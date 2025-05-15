build-image:
	@echo "🛠️  Construyendo imagen de Docker..."
	@docker build -f Dockerfile -t bookstore:1 .

deploy:
	@echo "🚀 Desplegando stack..."
	@docker network create --driver overlay --scope swarm bookstore_net || true
	@docker stack deploy --with-registry-auth -c stack.yml bookstore

rm:
	@echo "🧹 Eliminando stack..."
	@docker stack rm bookstore || true
	@echo "⌛ Esperando que se liberen servicios..."
	@sleep 5
	@echo "🧼 Eliminando red y volumen..."
	@docker network rm bookstore_net || true
	@docker volume rm db_data || true
