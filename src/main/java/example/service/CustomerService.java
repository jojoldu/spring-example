package example.service;

import example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-02-07.
 */
@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer findOne(Integer id){
        return customerRepository.findOne(id);
    }

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer){ return customerRepository.save(customer);}

    public void delete(Integer id){ customerRepository.delete(id);}
}
