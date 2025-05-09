package com.example.client_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.client_management.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{
}
