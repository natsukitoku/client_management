package com.example.client_management.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.client_management.entity.Manager;
import com.example.client_management.form.ManagerForm;
import com.example.client_management.repository.ManagerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository repository;

    public void create(ManagerForm form) {
        Manager manager = new Manager();
        manager.setName(form.getName());
        manager.setEmail(form.getEmail());
        manager.setPassword(form.getPassword());
        manager.setCreatedAt(LocalDateTime.now());
        manager.setUpdatedAt(LocalDateTime.now());
        repository.save(manager);
    }

    public void update(ManagerForm form, Integer accountManagerId) {
        Manager manager = findById(accountManagerId);
        if (!manager.getName().equals(form.getName())) {
            manager.setName(form.getName());
        }
        if (!manager.getEmail().equals(form.getEmail())) {
            manager.setEmail(form.getEmail());
        }
        if (!manager.getPassword().equals(form.getPassword())) {
            manager.setPassword(form.getPassword());
        }
        manager.setUpdatedAt(LocalDateTime.now());
        repository.save(manager);
    }

    public void delete(Integer accountManagerId) {
        Manager manager = findById(accountManagerId);
        manager.setUpdatedAt(LocalDateTime.now());
        manager.setDeletedAt(LocalDateTime.now());
        repository.save(manager);
    }

    public Manager findById(Integer accountManagerId) {
        Optional<Manager> manager = repository.findById(accountManagerId);
        Manager man = manager.get();
        return man;
    }
}
