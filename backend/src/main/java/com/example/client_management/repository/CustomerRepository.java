package com.example.client_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.client_management.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
    @Query("SELECT c FROM Customer c WHERE c.accountManagerId = :id AND c.deletedAt IS NULL")
    public List<Customer> findAll(Integer id);
}
