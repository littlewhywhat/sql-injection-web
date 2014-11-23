package sqlinjectionweb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Component
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        clean();
        init();
    }

    private void clean() {
        jdbcTemplate.execute("drop table products if exists");
    }

    private void init() {
        jdbcTemplate.execute("create table products(" +
                "id int, name varchar(255))");
        jdbcTemplate.execute("INSERT INTO products(id, name) " + 
                     "values(0 , 'hello')");  
    }

    public List<Product> findAll() {
        return jdbcTemplate.query("select * from products", new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Product(rs.getLong("id"), rs.getString("name"));
                    }
                });
    }

    public boolean add(long id, String name) {
        jdbcTemplate.execute("INSERT INTO products(id,name) " +
                    "values(" + id + ", '" + name + "')");
        return true;
    }
}