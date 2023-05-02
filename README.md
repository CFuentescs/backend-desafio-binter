# ☕️ Proyecto Backend SpringBoot - (Word Counter)

> ℹ️ Api que extrae los valores del servicio [https://github.com/bi-lriveros/word-counter-challenge/blob/e050839b2e3148d2dbe097438e5eee7ef9e620ca/README.md](https://github.com/bi-lriveros/word-counter-challenge/tree/e050839b2e3148d2dbe097438e5eee7ef9e620ca) que genera los datos de entrada y que en este servicio se trabaja para su conteo y entregado al Frontend

## ☝️ Dependencias
* Java 18 (JDK-18)
* Gradle (Wrapper incluido)

## 🚀 Instalación y ejecución
```bash
  ./gradlew bootRun
```

> ℹ️ Se debe tener encuenta que esta aplicación se hizo en un entorno de desarrollo IntelliJ IDEA 2023.1 ☝️ por si no se puede ejecutar de manera 'normal' en su terminal

## 🏁  Objetivos Logrados
* Recopila la información en un formato JSON desde la Api entregada, luego junta su cadena.
* Realiza el conteo uno por uno de las palabras mas repetidas y realiza un orden decendiente para ser entregado con su posición.

## Consumo de API

* Formato de salida
```bash
  POST http://localhost:8080/counter
```
> ℹ️  Se debe tener en cuenta que debe coincidir con la URL de la API de consumo, este archivo se encuentra contador\src\main\java\test\binter\contador\infrastructure\service llamado ContadorService de la linae 17 y 32.

```json
{
    "id": "2",
    "title": "Cinco semanas en globo",
    "ranking": [
        {
            "position": 1,
            "word": "de",
            "ocurrences": "40"
        },
        .
        .
        .
    ]
 }
```
