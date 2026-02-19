package com.sean.ExpenseTracker.Models;

import lombok.Data;


//this file is a DTO for Users for authentication

@Data
public class AuthRequest {
    private String userName;
    private String password;
}
