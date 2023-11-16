# Sensor monitor application

CRUD приложение для ведения учёта датчиков, с возможностью аутентификации и авторизации пользователя, выполнения полнотекстового поиска данных. Состоит из серверной и клиентской частей. 

Серверная часть реализована с использованием следующего стека технологий:
* Java 17
* Spring Boot
* Spring Data Jpa
* Spring Security
* Postgres
* Hibernate Search

Скрипты инициализации схемы БД расположены в ресурсах и выполняются автоматически при запуске приложения.
В БД предустановлено два пользователя:

| Username | Password |     Role      |
|:--------:|:--------:|:-------------:|
|  admin   | password | ADMINISTRATOR |
|   user   | password |    VIEWER     |

База данных и приложение упаковываются в Docker контейнеры, что позволяет развернуть серверную часть парой команд. Соответственно для развертывания приложения на машине должен быть установлен Docker & Docker Compose


### Запуск серверной части приложения

1. Клонировать репозиторий git clone https://github.com/antonfreedom5/sensor-monitor-backend.git
2. Выполнить команду docker-compose -f sensor-monitor-backend/docker-compose/docker-compose.yml build && docker-compose -f sensor-monitor-backend/docker-compose/docker-compose.yml up


---
Клиентская часть приложения https://github.com/antonfreedom5/sensor-monitor-frontend.git