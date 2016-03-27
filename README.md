# API

## Add new superhero

```
POST http://ec2-52-10-176-210.us-west-2.compute.amazonaws.com:8080/superhero/superhero HTTP/1.1
Content-Type: application/json
Accept: application/json

{  
    "name": "Bruce Wayne",
    "pseudonym": "Batman",
    "publisher": "Marvel",
    "skills": [
        "Criminal fight",
        "Flying"
    ],
    "allies": [
        "Catwoman",
        "Robin",
        "Alfred"
    ],
    "firstAppearance": "1939-05-01"
}
```

Response:

```
{
    "id": 1,
    "name": "Bruce Wayne",
    "pseudonym": "Batman",
    "publisher": "Marvel",
    "skills": [
        "Flying",
        "Criminal fight"
    ],
    "allies": [
        "Catwoman",
        "Alfred",
        "Robin"
    ],
    "firstAppearance": "1939-05-01"
}
```

## Get all superheroes

```
GET http://ec2-52-10-176-210.us-west-2.compute.amazonaws.com:8080/superhero/superhero
Accept: application/json
```

Response:

```
[
    {
        "id": 1,
        "name": "Bruce Wayne",
        "pseudonym": "Batman",
        "publisher": "Marvel",
        "skills": [
            "Flying",
            "Criminal fight"
        ],
        "allies": [
            "Catwoman",
            "Alfred",
            "Robin"
        ],
        "firstAppearance": "1939-05-01"
    }
]
```

## Get specific superhero (by ID)

```
GET http://ec2-52-10-176-210.us-west-2.compute.amazonaws.com:8080/superhero/superhero/1
Accept: application/json
```

Response:

```
{
    "id": 1,
    "name": "Bruce Wayne",
    "pseudonym": "Batman",
    "publisher": "Marvel",
    "skills": [
        "Flying",
        "Criminal fight"
    ],
    "allies": [
        "Catwoman",
        "Alfred",
        "Robin"
    ],
    "firstAppearance": "1939-05-01"
}
```

# Frameworks

- As build tool used Maven, as it is, with Gradle, de-facto standard for building Java apps, but I am more familiar with Maven.
- For dependency injection, IoC, MVC used Spring as it is most powerful tool I have used, it offers rich API, that is easy to use,
  almost everything can be configured via annotations, it has integrations with most of the popular Java tools today.
  Almost everything I needed could be done using Spring, and it is very easily configurable.
- For persistence and DB access, used Hibernate, as that is framework I am most familiar with, and it also has rich enough API
  that is relatively easy to configure and use. Also has Spring integrations (Spring can help with building SessionFactory,
  for transaction management, etc.).
- Used MySQL for DB storage, as it is one of the best open-source RDBMS systems available.
- Logback for logging, it has easy to configure appenders and is powerful to use (has MDC, etc.).