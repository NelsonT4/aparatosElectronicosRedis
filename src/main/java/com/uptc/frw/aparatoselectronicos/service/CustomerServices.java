package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Customer;
import com.uptc.frw.aparatoselectronicos.JPA.entity.Types;
import com.uptc.frw.aparatoselectronicos.JPA.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).get();
    }

    public Customer saveCustomer(Customer customer){
        return  customerRepository.save(customer);
    }

    public void deletedCustomer(long id){
        customerRepository.deleteById(id);
    }
    public Customer updatePhone (Long id, Long phone){
        Customer customer = getCustomer(id);
        customer.setPhone(phone);
        return saveCustomer(customer);
    }

}
