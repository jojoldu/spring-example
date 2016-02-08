package example;

import example.domain.Customer;
import example.repository.CustomerRepository;
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
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer created = customerRepository.save(new Customer(null, "동욱","이"));
        System.out.println(created + " is created!");
        customerRepository.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
