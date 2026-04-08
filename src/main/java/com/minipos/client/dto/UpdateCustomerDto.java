package com.minipos.client.dto;

import jakarta.validation.constraints.Email;

public class UpdateCustomerDto {

    private String fullName;

    @Email(message = "invalid email")
    private String email;

    private String phone;

    // getters & setters

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}