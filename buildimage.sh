#!/bin/sh
docker-compose build

docker login
docker tag medshare-microservice_glassfish yylonly/medshare_glassfish
docker tag medshare-microservice_mysql yylonly/medshare_mysql

docker push yylonly/medshare_glassfish
docker push yylonly/medshare_mysql