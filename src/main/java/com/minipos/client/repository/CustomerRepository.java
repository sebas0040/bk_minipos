package com.minipos.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minipos.client.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}