# Инструкция по запуску проекта

1. Зайти в корень проекта 
2. Перейти в директорию **/docker** и запустить docker-compose.yaml командой `docker compose up -d`
3. Вернуться в корневую директорию и прописать команду `mvn package` 
4. Перейти в директорию **/target** и запустить jar файл командой `java -jar library-0.0.1-SNAPSHOT.jar`

## Доступ к приложению
Приложение развернуто на порту **8080**

## REST Endpoint
http://localhost:8080/api/v1/reading-clients
