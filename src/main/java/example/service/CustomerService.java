package example.service;

import example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.repository.CustomerRepository;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-02-07.
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

}
