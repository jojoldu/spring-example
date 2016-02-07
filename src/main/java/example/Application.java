package example;

import example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import example.service.CustomerService;

/**
 * Created by jojoldu@gmail.com on 2016-02-06.
 */

@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner{

    @Autowired
    CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        customerService.save(new Customer(1, "동욱", "이"));
        customerService.save(new Customer(2, "천용", "배"));
        customerService.save(new Customer(3, "우중", "정"));

        customerService.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
