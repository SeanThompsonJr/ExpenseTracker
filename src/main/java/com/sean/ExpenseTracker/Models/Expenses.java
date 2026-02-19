package com.sean.ExpenseTracker.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String category;
    private String date;
    private String name;
    @ManyToOne
    @JoinColumn(name="users_id")
    private Users users;
}
