package example.controller;

import example.domain.Customer;
import example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-02-08.
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method= RequestMethod.GET)
    Page<Customer> getAll(@PageableDefault Pageable pageable){
        return customerService.findAll(pageable);
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    Customer get(@PathVariable Integer id){
        return customerService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    Customer update(@PathVariable Integer id, @RequestBody Customer customer){
        customer.setId(id);
        return customerService.update(customer);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
    }
}
