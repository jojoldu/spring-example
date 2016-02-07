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
        customerService.save(new Customer(1, "동욱", "이"));
        customerService.save(new Customer(2, "천용", "배"));
        customerService.save(new Customer(3, "우중", "정"));

        customerService.findAll().forEach(System.out::println);
        System.out.println("Map에 담았다!");

        String sql = "SELECT :a+:b";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("a", 100)
                .addValue("b", 200);

        Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);
        System.out.println("result : " + result);

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
