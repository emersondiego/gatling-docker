# gatling-moip

This project runs with docker-compose, the compose  runs apps Gatling, InfluxDB, and Grafana. The first one Gatling build with maven inside and takes a few seconds to run for the first time.

### pre-reqs
To run this demo you need:
- docker
- docker-compose
- maven
- jdk 1.8

### How to run
From root directory:
. If you want to remove all Gatling containers(Gatling, Grafana, InfluxDB and Redis) pass parameter "clean" to the following shell script:
```
. run.sh clean
```

. If you do not want to remove all Gatling containers(Gatling, Grafana, InfluxDB and Redis) do not pass parameter "clean" to the following shell script (Using this option you are not deleting data used before in Redis and Grafana will still show data used bedore):
```
. run.sh
or
bash run.sh
```

After a few seconds access Grafana site at http://localhost:3000/dashboard/db/sample-service
or replace the ip with the correct one.

Default user and password are: `admin/admin`

To see graphics and documents about load tests [target/gatling/basicsimulation-xxxxxxxxx]

### Setup Information
Inside the class ```basicsimulation``` there are two kinds of simulations:
- The first one is to execute ```constants user per second```
- The second one is to execute ```ramp up users per second```
