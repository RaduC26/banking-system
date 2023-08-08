package com.radu.bankofradu.Controllers;

import com.radu.bankofradu.Data.Customer;
import com.radu.bankofradu.Repositories.CustomerRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public Iterable<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    @PostMapping("/customers")
    public Customer addOneCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    @DeleteMapping("/customers")
    public String removeOneCustomer(@RequestParam int id) {
        List<Customer> allCustomers = (List<Customer>) this.customerRepository.findAll();
        Customer customer = allCustomers.stream().filter(obj -> obj.getId().equals(id)).toList().get(0);
        this.customerRepository.delete(customer);
        return "Customer deleted successfully";
    }
}
