package com.example.client_management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.client_management.entity.Customer;
import com.example.client_management.form.CustomerForm;
import com.example.client_management.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public void create(CustomerForm form, Integer managerId) {
        Customer customer = new Customer();
        customer.setAccountManagerId(managerId);
        customer.setNameKanji(form.getNameKanji());
        customer.setNameKana(form.getNameKana());
        customer.setDateOfBirth(form.getDateOfBirth());
        customer.setAddress(form.getAddress());
        customer.setTel(form.getTel());
        customer.setEmail(form.getEmail());
        customer.setMemo(form.getMemo());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        repository.save(customer);
    }

    public void update(CustomerForm form, Integer customerId) {
        Customer customer = findById(customerId);
        if (!customer.getNameKanji().equals(form.getNameKanji())) {
            customer.setNameKanji(form.getNameKanji());
        }
        if (!customer.getNameKana().equals(form.getNameKana())) {
            customer.setNameKana(form.getNameKana());
        }
        if (!customer.getDateOfBirth().equals(form.getDateOfBirth())) {
            customer.setDateOfBirth(form.getDateOfBirth());
        }
        if (!customer.getAddress().equals(form.getAddress())) {
            customer.setAddress(form.getAddress());
        }
        if (!customer.getTel().equals(form.getTel())) {
            customer.setTel(form.getTel());
        }
        if (!customer.getEmail().equals(form.getEmail())) {
            customer.setEmail(form.getEmail());
        }
        if (!customer.getMemo().equals(form.getMemo())) {
            customer.setMemo(form.getMemo());
        }
        customer.setUpdatedAt(LocalDateTime.now());
        repository.save(customer);
    }

    public void delete(Integer customerId) {
        Customer customer = findById(customerId);
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setDeletedAt(LocalDateTime.now());
        repository.save(customer);
    }

    public Customer findById(Integer id) {
        Optional<Customer> customer = repository.findById(id);
        Customer cust = customer.get();
        return cust;
    }

    public List<Customer> getAllCustomers(Integer accountManagerId) {
        List<Customer> customers = repository.findAll(accountManagerId);
        return customers;
    }
}
