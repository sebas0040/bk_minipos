package com.minipos.client.service;

import com.minipos.client.dto.*;
import java.util.List;

public interface CustomerService {

    List<CustomerResponse> list();

    CustomerResponse create(CreateCustomerDto dto);

    CustomerResponse update(Long id, UpdateCustomerDto dto);

    void delete(Long id);
}