package com.minipos.client.service.impl;

import com.minipos.client.dto.*;
import com.minipos.client.entity.Customer;
import com.minipos.client.repository.CustomerRepository;
import com.minipos.client.service.CustomerService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public CustomerResponse create(CreateCustomerDto dto) {
        Customer c = new Customer();
        c.setFullName(dto.getFullName());
        c.setEmail(dto.getEmail());
        c.setPhone(dto.getPhone());

        return toResponse(repository.save(c));
    }

    @Override
    public CustomerResponse update(Long id, UpdateCustomerDto dto) {
        Customer c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (dto.getFullName() != null) c.setFullName(dto.getFullName());
        if (dto.getEmail() != null) c.setEmail(dto.getEmail());
        if (dto.getPhone() != null) c.setPhone(dto.getPhone());

        return toResponse(repository.save(c));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        repository.deleteById(id);
    }

    private CustomerResponse toResponse(Customer c) {
        CustomerResponse r = new CustomerResponse();
        r.setId(c.getId());
        r.setFullName(c.getFullName());
        r.setEmail(c.getEmail());
        r.setPhone(c.getPhone());
        r.setCreatedAt(c.getCreatedAt());
        return r;
    }
}