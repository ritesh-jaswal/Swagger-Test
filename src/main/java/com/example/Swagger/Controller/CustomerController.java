package com.example.Swagger.Controller;

import com.example.Swagger.ModelDto.CustomerDto;
import com.example.Swagger.Service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @PostMapping("customer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto)
    {
        return new ResponseEntity<>(this.customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @PutMapping("customer/{customerId}")
    public void updateCustomer(@RequestBody CustomerDto customerDto,@PathVariable int customerId)
    {
       this.customerService.updateCustomer(customerDto,customerId);
    }

    @DeleteMapping("customer/{customerId}")
    public void deleteCustomer(@PathVariable int customerId)
    {
        this.customerService.deleteCustomerById(customerId);
    }

    @GetMapping("customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers()
    {
        return new ResponseEntity<>(this.customerService.getAllCustomers(), HttpStatus.OK);
    }

    @Operation(summary = "Get a customer by ID", description = "Provide an ID to lookup specific customer")
//    @ApiResponse(responseCode = "200", description = "Successful retrieval of customer")
    @GetMapping("customer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable int customerId)
    {
        return new ResponseEntity<>( this.customerService.getCustomerById(customerId),HttpStatus.OK);
    }
}
