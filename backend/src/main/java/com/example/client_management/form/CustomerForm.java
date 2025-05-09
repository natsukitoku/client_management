package com.example.client_management.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerForm {
    private String nameKanji;
    private String nameKana;
    private LocalDate dateOfBirth;
    private String address;
    private String tel;
    private String email;
    private String memo;
}
