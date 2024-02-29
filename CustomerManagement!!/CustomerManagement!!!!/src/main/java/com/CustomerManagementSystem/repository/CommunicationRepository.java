package com.CustomerManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerManagementSystem.entities.CommunicationAddress;

public interface CommunicationRepository extends JpaRepository<CommunicationAddress, Integer>{

}
