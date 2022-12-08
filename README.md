# API 

## Descripción
Proyecto API REST con funciones de un supermercado como agregar un producto, recuperar la lista de productos disponibles, eliminar un producto, obtener un producto por categoria, obtener las compras realizadas realizado con **spring boot 2.75** gestor de dependencias **Gradle** y **Java 17.0.5** entorno de desarrollo **IntelliJ IDEA 2022.2.3 (Community Edition)**

[![runApp.jpg](https://i.postimg.cc/pLXXzG9w/runApp.jpg)](https://postimg.cc/qzSTdGxw)

## Autenticación JWT - POSTMAN

Abrir postman ejecutar la generación de un nuevo JsonWebToken a través del metodo POST en la ruta local **http://localhost:9090/market/api/auth/authenticate** adicionalmente, en el body en formato JSON los atributos:

+ username = root
+ password = apiserver99

[![authJWT.jpg](https://i.postimg.cc/c426GqFd/authJWT.jpg)](https://postimg.cc/dLRJGfMf)

## Documentación con openAPI
Para acceder a la documentación generada por openAPI copia el jwt generado anteriormente y con la ayuda de la extension **ModHeader** descargala en https://modheader.com/ para Chrome, agrega dentro del request el header "Authorization" como valores Bearer + token generado.

[![mod-Header-Token.jpg](https://i.postimg.cc/GmTWVVfw/mod-Header-Token.jpg)](https://postimg.cc/Mnx3jPxd)

luego accede a la documentación en http://localhost:9090/market/api/swagger-ui/index.html

[![open-APIDocs.jpg](https://i.postimg.cc/HxdFJxkd/open-APIDocs.jpg)](https://postimg.cc/06XVF9SB)
