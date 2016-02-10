package example;

import example.domain.Customer;
import example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import example.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
/*
        //command line Runner 사용할때 주석 제거
        Customer created = customerRepository.save(new Customer(null, "동욱","이"));
        System.out.println(created + " is created!");

        Pageable pageable = new PageRequest(0, 3);
        Page<Customer> page = customerRepository.findAll(pageable);

        System.out.println("1페이지당 데이터수 : " + page.getSize());
        System.out.println("현재페이지 : " + page.getNumber());
        System.out.println("전체 페이지수 : " + page.getTotalPages());
        System.out.println("전체 데이터수 : " + page.getTotalElements());
        customerRepository.findAll().forEach(System.out::println);*/

        customerRepository.save(new Customer("동욱","이"));
        customerRepository.save(new Customer("천용", "배"));
        customerRepository.save(new Customer("우중", "정"));
        System.out.println("created!");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
