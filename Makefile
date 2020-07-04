run: build
	docker-compose up

run-d: build
	docker-compose up -d

build:
	mvn clean install