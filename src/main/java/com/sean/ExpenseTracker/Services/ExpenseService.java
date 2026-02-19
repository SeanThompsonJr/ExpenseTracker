package com.sean.ExpenseTracker.Services;

import com.sean.ExpenseTracker.Models.Expenses;
import com.sean.ExpenseTracker.Models.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;



@Service
public class ExpenseService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createUserWithExpenses() {
        Users users = new Users();
        users.setUserName("briggin");
        users.setEmail("briggin@gmail.com");
        users.setPassword("loki");

        Expenses ex1 = new Expenses();
        ex1.setName("your tax");
        ex1.setAmount(19.99);
        ex1.setCategory("finances");
        ex1.setDate("1/10/2026");

        Expenses ex2 = new Expenses();
        ex2.setName("new dog");
        ex2.setAmount(170.00);
        ex2.setDate("1/1/2026");
        ex2.setCategory("fun");

        ex1.setUsers(users);
        ex2.setUsers(users);

        users.getExpenses().add(ex1);
        users.getExpenses().add(ex2);

        em.persist(users);
        em.persist(ex1);
        em.persist(ex2);
    }
}
