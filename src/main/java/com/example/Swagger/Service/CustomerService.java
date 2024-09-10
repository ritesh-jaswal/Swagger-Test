package com.example.Swagger.Service;



import com.example.Swagger.ModelDto.CustomerDto;

import java.util.List;

public interface CustomerService
{
    CustomerDto createCustomer(CustomerDto customerDto);
    void updateCustomer(CustomerDto customerDto, int customerId);
    CustomerDto getCustomerById(int customerId);
    List<CustomerDto> getAllCustomers();
    void deleteCustomerById(int customerId);
}
