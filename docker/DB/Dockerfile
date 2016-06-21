FROM mysql/mysql-server:latest

COPY sql_scripts/SCHEMA.sql /docker-entrypoint-initdb.d/

ENV MYSQL_ROOT_PASSWORD "root"
