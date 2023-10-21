package com.uptc.frw.aparatoselectronicos.controller;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Customer;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Types;
import com.uptc.frw.aparatoselectronicos.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping
    public List<Customer> getAllCUstomers(){
        return customerServices.getAllCustomers();
    }

    @PostMapping
    public Customer saveCUstomer(Customer customer){
        return customerServices.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@RequestParam Long id){
        return customerServices.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerServices.deletedCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestParam Long phone){
        return customerServices.updatePhone(id,phone);
    }
}
