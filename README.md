# sql-injection-web
An example of the web app that has a vulnerability to sql injection attack.
#### WEB API
- '/' - return all products;
- '/add?name=apple' - add new product with name 'apple'.

#### Possible sql injection attack
'/add?name=apple') delete from products where id > -1 insert into products (id,name) values (0, 'sqlinjection attack'

It will delete all products and insert the one with id = 0 and name = 'sqlinjectionattack'.

#### Mistake
In ProductRepository class the web developer, to compose a query for inserting new product, is using string concatenation of HTTP request parameter value. This solution gives a wide range of actions to attacker, because by changing the value of parameter he could insert any sql command he wants, and the resulting query will be naively executed by application.

#### Structure
- ProductRepository - spring component with @Autowired JdbcTemplate field and SQL logic;
- ProductController - controller with @Autowired ProductRepository and which implements API;
- Product - java class to represent a product with fields 'id' and 'name'.

#### Build
Maven

#### Dependencies
- spring-boot-starter-web; 
- spring-boot-starter-jdbc;
- hsqldb.


