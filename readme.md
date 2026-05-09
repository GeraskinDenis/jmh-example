# Benchmark
Пример простого приложения с benchmark тестированием.
Приложение состоит из двух модулей:
- `app` - простое Spring Boot приложение.
- `app-benchmark` - JMH тесты

__Ошибка__
Модуль `app-benchmark` зависит от модуля `app`.
При сборке модуля `app-benchmark` возникает ошибка. Этот модуль не видит класс `PasswordHasher` из модуля `app`.


## App

### Building
```shell
mvn clean install -pl :app
```

### Launch
```shell
java -jar app/target/app-1.0-SNAPSHOT.jar
```

## App-benchmark

### Building
```shell
mvn clean package -X -pl :app-benchmark
```

### Launch
```shell
java -jar app-benchmark/target/app-benchmark-1.0-SNAPSHOT.jar
```