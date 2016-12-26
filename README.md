# sql-injection-web
An example of the web app that has a vulnerability to sql injection attack.

![alt tag](http://imgs.xkcd.com/comics/exploits_of_a_mom.png)

#### WEB API
return all products:
```
/
```
add new product with name 'apple':
```
/add?name=apple
```

#### Possible sql injection attack
```
/add?name=apple') drop table products --
```

It will delete the table of products.

#### Mistake
In ProductRepository class the web developer, to compose a query for inserting new product, is using string concatenation of HTTP request parameter value. This solution gives a wide range of actions to attacker, because by changing the value of parameter he could insert any sql command he wants, and the resulting query will be naively executed by application.

#### Structure
- ProductRepository - spring component with @Autowired JdbcTemplate field and SQL logic;
- ProductController - controller with @Autowired ProductRepository and which implements API;
- Product - java class to represent a product with fields 'id' and 'name'.

#### Build
Maven 3.0.5

run from root folder:
```
 mvn package && java -jar target/sqlinjectionweb-0.1.0.jar
```

#### Dependencies
- spring-boot-starter-web; 
- spring-boot-starter-jdbc;
- hsqldb.


