#!/usr/bin/env bash

if [ "$1" = "clean" ]; then
  echo '(-) Stoping and removing all containers (Avoid conflicts)'
  docker-compose down
  docker system prune -f
  docker volume prune -f
  echo '(✔) Stopped and removed all containers'

  echo '(-) Starting dependencies'
  docker-compose up -d --build influxdb grafana
  echo '(✔) Done'
fi

echo '(-) Building application'
cd gatling
mvn clean install
cd ..

docker-compose up -d --build gatling-runner
docker logs -f gatling-runner
