# Mackenzie Bookstore Server

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
