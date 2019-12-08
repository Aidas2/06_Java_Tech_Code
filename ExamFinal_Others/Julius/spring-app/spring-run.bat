@echo off

Rem Running Springboot application.....

call mvn clean install spring-boot:run -Dspring.devtools.restart.enabled=false -Dmaven.test.skip=true -Dspring-boot.run.arguments=--server.port=8081