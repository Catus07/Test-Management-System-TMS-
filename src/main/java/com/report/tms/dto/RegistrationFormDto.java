package com.report.tms.dto;
import lombok.Data;

@Data
public class RegistrationFormDto {
    public Long id;
    public String firstname;
    public String SecondName;
    public String username;
    public String department;
    public String role;
    public String password;
    public String email;
}