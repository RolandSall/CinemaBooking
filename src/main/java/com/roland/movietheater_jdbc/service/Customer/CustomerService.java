package com.roland.movietheater_jdbc.service.Customer;

import com.roland.movietheater_jdbc.repository.Customer.CustomerRepositoryDAO;
import com.roland.movietheater_jdbc.repository.Customer.ICustomerRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements  ICustomerService {

    private ICustomerRepositoryDAO customerRepository;

    @Autowired
    public CustomerService(CustomerRepositoryDAO customerService){
        this.customerRepository = customerService;
    }


}
