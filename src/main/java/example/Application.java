package example;

import example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import example.service.CustomerService;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Created by jojoldu@gmail.com on 2016-02-06.
 */

@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner{

    @Autowired
    CustomerService customerService;

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM customers WHEE id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", 1);

        Integer result = jdbcTemplate.queryForObject(sql, param,
                (rs, rowNum) ->
                    new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"))
        );
        System.out.println("result : " + result);

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
