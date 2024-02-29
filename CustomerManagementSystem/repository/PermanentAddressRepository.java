package com.CustomerManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerManagementSystem.entities.PermanentAddress;

public interface PermanentAddressRepository extends JpaRepository<PermanentAddress, Integer> {

}
