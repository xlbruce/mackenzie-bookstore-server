# Mackenzie Bookstore Server

## Dependencies
- jdk 1.8 (or higher)
- maven 3.3.9 (or higher)
## How to build and run
Go to project root folder and run `mvn clean install`.
An `.jar` file will be created at `target/` folder.
To run the server, execute the following `java -jar target/mackenzie-bookstore-server-0.0.1-SNAPSHOT.jar`
(make sure java installation is set in your `$PATH` or `%PATH%` (for Unix-like and Windows systems respectively)
## Important notes

- Values between [] are optional
- Values between {} are mandatory
- Param names are case sensitive

## Avaiable Resources

### Announce

#### Register Announce
###### Request: ``` POST /announces?user_code=<code>&isbn=<isbn>[&description=<description>] ```

###### Response example: 
```json
{
  "annoucePK": {
    "code": 31409695,
    "isbn": "9788588134119"
  },
  "sold": false,
  "description": "Livro muito bom",
  "book": {
    "isbn": "9788588134119",
    "name": "Memórias do povo alemão no Rio Grande do Sul",
    "description": "Memórias do povo alemão no Rio Grande do Sul",
    "publisher": {
      "idPublisher": 3,
      "name": "Felipe Kuhn Braun"
    },
    "author": {
      "idAuthor": 3,
      "name": "Desconhecido"
    }
  }
} 
```
(To update an announce, just POST another one with the same ```user_code``` and ```isbn```)

#### Find announces by book name

###### Request: ``` GET /announces?book_name=<book_name>```

###### Response example:
```json
[
  {
    "annoucePK": {
      "code": 31409695,
      "isbn": "9788578932466"
    },
    "sold": false,
    "description": "Teste2",
    "book": {
      "isbn": "9788578932466",
      "name": "MEMORIAS REVELADAS - CENTRO DE INVESTIGACAO DA",
      "description": "Descobrir a Memória é também descobrir a Identidade. Refletir sobre a identificaçãoda memória através da Filosofia, Moral,Ética e Educação, assim como dosrelacionamentos, comportamentos e conflitos do cotidiano, no tocante aos víciose virtudes que cerceiam o homem inserido na sociedade, caracteriza esta obra.Aventuras e desventuras do ser humano estão contidas em sermões e ensaios não moralistas, mas coerentes com a artede apreender o imaginário coletivo e representar com sensibilidade a Identidade do homem moderno.Conceitos como conflito, consciência, bem, mal, maternidade, paternidade, razão, moral, ética, motivação,autoestima, humildade e silêncio indagam como a Memória pode construir o intelecto e a moral através da racionalidade",
      "publisher": {
        "idPublisher": 2,
        "name": "biblioteca24horas"
      },
      "author": {
        "idAuthor": 2,
        "name": "RENATA CARLA DINIZ"
      }
    }
  }
]
```
#### Find announces by primary key

###### Request: ``` GET /announce/{userCode}/{isbn}```
###### Response example:
```json
{
  "annoucePK": {
    "code": 31409695,
    "isbn": "9788578932466"
  },
  "sold": false,
  "description": "Livro em bom estado",
  "book": {
    "isbn": "9788578932466",
    "name": "MEMORIAS REVELADAS - CENTRO DE INVESTIGACAO DA",
    "description": "Descobrir a Memória é também descobrir a Identidade. Refletir sobre a identificaçãoda memória através da Filosofia, Moral,Ética e Educação, assim como dosrelacionamentos, comportamentos e conflitos do cotidiano, no tocante aos víciose virtudes que cerceiam o homem inserido na sociedade, caracteriza esta obra.Aventuras e desventuras do ser humano estão contidas em sermões e ensaios não moralistas, mas coerentes com a artede apreender o imaginário coletivo e representar com sensibilidade a Identidade do homem moderno.Conceitos como conflito, consciência, bem, mal, maternidade, paternidade, razão, moral, ética, motivação,autoestima, humildade e silêncio indagam como a Memória pode construir o intelecto e a moral através da racionalidade",
    "publisher": {
      "idPublisher": 2,
      "name": "biblioteca24horas"
    },
    "author": {
      "idAuthor": 2,
      "name": "RENATA CARLA DINIZ"
    }
  }
}
```
### Book
#### Get all books in database
###### Request: ```GET /books```
###### Response example:
```json
[
{
    "isbn":"9781429978217",
    "name":"Harry Potter, You're the Best!",
    "description":"After St. Martin's published We Love Harry Potter! We'll tell you why we got hundreds of letters from fans around the world who wanted to offer their thoughts about the books they love. Their fertile imaginations have led them to share their creative takes on Harry: their opinions about the plots and characters, their wishes for the next book and the upcoming, highly ancipated movie version, their ideas for playing Harry, Ron, Hermione, and all their other favorite characters, and much more! The collected letters are a delightful testament to how widespread and beloved the Harry Potter phenomenon has become.",
    "publisher":{
        "idPublisher":1,
        "name":"Macmillan"
    },
    "author":{
        "idAuthor":1,"name":"Sharon Moore"
    }
}
]
```

#### Find books by name
###### Request: ```GET /books/name/{bookName}```
###### Request example is same as above

#### Find a book by ISBN
###### Request: ```GET /books/{isbn}```
###### Response: it will be only one book returned

### User
#### Register or update a user
###### Request: ```POST /users?userCode=<usercode>&username=<username>&email=<email>&password=<password>&typeId=<typeId>```
###### Response example: 
#### Find user by id (user code)

###### Request: ``` GET /user/{userCode}```

###### Response example: 
```json
{
  "code": 31409695,
  "username": "gilson",
  "email": "gilson@email.com",
  "userType": {
    "typeId": 1,
    "type": "Regular user"
  }
}
```