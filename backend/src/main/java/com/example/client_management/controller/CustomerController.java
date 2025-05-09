package com.example.client_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.client_management.form.CustomerForm;
import com.example.client_management.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;
    
    @GetMapping("/index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok()
                    .body("Hello!");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(
        @RequestBody CustomerForm form,
        @RequestParam("managerId") Integer accountManagerId
        ) {
            service.create(form, accountManagerId);
            return ResponseEntity.ok()
                        .body("登録完了");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateCustomer(
            @RequestBody CustomerForm form,
            @RequestParam Integer customerId
            ) {
                service.update(form, customerId);
                return ResponseEntity.ok()
                            .body("編集完了");
    }
    
    
    
}
