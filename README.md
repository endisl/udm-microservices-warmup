## REST API Calculator with Spring Boot

Sum
```
http://localhost:8080/sum/1/9
```
```
10.0
```

Subtraction
```
http://localhost:8080/subtraction/10/a
```
```
{
    "timestamp": "2022-02-10T20:51:30.925+00:00",
    "message": "Please set a numeric value!",
    "details": "uri=/subtraction/10/a"
}
```

Multiplication
```
http://localhost:8080/multiplication/11.1/9,9/
```
```
109.89
```

Division
```
http://localhost:8080/division/321/0
```
```
{
    "timestamp": "2022-02-10T20:55:14.560+00:00",
    "message": "The second number must not be equal to zero!",
    "details": "uri=/division/321/0"
}
```

Mean
```
http://localhost:8080/mean/68/70
```
```
69.0
```

SquareRoot
```
http://localhost:8080/squareroot/-9
```
```
{
    "timestamp": "2022-02-10T21:05:37.806+00:00",
    "message": "The number must be greater or equal to zero",
    "details": "uri=/squareroot/-9"
}
```