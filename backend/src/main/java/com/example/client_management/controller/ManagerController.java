package com.example.client_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.client_management.entity.Manager;
import com.example.client_management.form.ManagerForm;
import com.example.client_management.service.ManagerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService service;
    
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ManagerForm form) {
        service.create(form);
        return ResponseEntity.ok()
                    .body("登録完了");
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(
        @RequestBody ManagerForm form,
        @RequestParam("managerId") Integer accountManagerId 
    ) {
        service.update(form, accountManagerId);
        return ResponseEntity.ok()
            .body("編集完了");
    }

    @GetMapping("/edit")
    public ResponseEntity<Manager> edit(@RequestParam("managerId") Integer accountManagerId) {
        Manager manager = service.findById(accountManagerId);
        return ResponseEntity.ok()
                    .body(manager);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("managerId") Integer accountManagerId) {
        service.delete(accountManagerId);
        return ResponseEntity.ok()
                    .body("削除完了");
    }
}
