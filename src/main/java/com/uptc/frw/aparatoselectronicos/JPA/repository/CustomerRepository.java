package com.uptc.frw.aparatoselectronicos.JPA.repository;

import com.uptc.frw.aparatoselectronicos.JPA.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
