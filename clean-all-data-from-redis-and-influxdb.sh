#!/usr/bin/env bash

docker-compose down
docker system prune -f
docker volume prune -f
rm -rf influxdb/lib/{data,meta,wal}
rm -rf redis/data/appendonly.aof
