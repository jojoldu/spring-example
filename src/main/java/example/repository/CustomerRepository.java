package example.repository;

import example.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by jojoldu@gmail.com on 2016-02-07.
 */
@Repository
public class CustomerRepository {

    private final ConcurrentMap<Integer, Customer> customerMap = new ConcurrentHashMap<>();

    public List<Customer> findAll(){
        return new ArrayList<>(customerMap.values());
    }

    public Customer findOne(Integer id){
        return customerMap.get(id);
    }

    public Customer save(Customer customer){
        return customerMap.put(customer.getId(), customer);
    }

    public void delete(Integer id){
        customerMap.remove(id);
    }

}
