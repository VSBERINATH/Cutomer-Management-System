package com.CustomerManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerManagementSystem.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
