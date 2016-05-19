# mackenzie-bookstore-server

Important points:
 - Values between <> are mandatory
 - Values between [] are optional
 - Param names are case sensitive
# Announces

Create a new announce

Request:
```POST /announces?userCode=<xxxxxxxx>&isbn=<xxxxxxxx>[&description=<xxxxxxxx>]```

Response:
```The announce created, or a 400 code error

# Books

Get all books

Request:
```GET /books```

Response:
```A json list with all books saved on database```

Find a book by ISBN

Request:
```GET /books/<isbn>```

Response:
```The book searched```

Find books by name

Request:
```GET /books/name/<name>```

Response:
```A json list with all book that corresponds the criteria```

# Users

Register new user

Request:
```POST /users?userCode=<xxxxxxxx>&userName=<xxxxxxx>&email=<xxxx@xxxxx.xx>&password=<xxxxxxx>&typeId=<0>```
 
 *typeId must be 1 for regurlar user, or 2 for admin user

Response:
```The user created, or a 404 code error if:
 - The user code is not valid
 - The user already exists
 - The user name already taken```

Login user

Request:
```GET /users/login?code=<xxxxxxxx>&password=<xxxxxxx>```

Response:
```The requested user, or a 404 code error if:
 - The user is not found
 - The password is not valid```


