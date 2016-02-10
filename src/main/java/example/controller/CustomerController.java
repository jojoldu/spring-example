package example.controller;

import example.domain.Customer;
import example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-02-10.
 */

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }
}
