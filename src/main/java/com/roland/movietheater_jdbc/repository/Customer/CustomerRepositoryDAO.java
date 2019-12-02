package com.roland.movietheater_jdbc.repository.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryDAO implements  ICustomerRepositoryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

}
