#!/bin/sh
echo Building Docker Images

docker container rm -f $(docker ps -aq --filter="name=microservice-ecosystem*")
docker rmi -f $(docker images --format '{{.Repository}}:{{.Tag}}' | grep 'microservice-ecosystem')

docker build -t microservice-ecosystem-node-discovery:1.0 ../node-discovery
docker build -t microservice-ecosystem-node-configserver:1.0 ../node-configserver
docker build -t microservice-ecosystem-node-apigateway:1.0 ../node-apigateway
docker build -t microservice-ecosystem-ms-order:1.0 ../ms-order
docker build -t microservice-ecosystem-ms-accounting:1.0 ../ms-accounting
docker build -t microservice-ecosystem-ms-notification:1.0 ../ms-notification

echo Docker Images Built
