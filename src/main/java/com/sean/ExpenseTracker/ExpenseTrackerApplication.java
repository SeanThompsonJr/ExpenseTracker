package com.sean.ExpenseTracker;

import com.sean.ExpenseTracker.Services.ExpenseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

    @Bean
    public CommandLineRunner run(ExpenseService expenseService) {
        return args -> {
            expenseService.createUserWithExpenses();
        };
    }

}

//public class ExpenseTrackerApplication {
//
//    public static void main(String[] args) {
//
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        // Creating Department
//        Users users = new Users();
//        users.setUserName("briggin");
//        users.setEmail("briggin@gmail.com");
//        users.setPassword("loki");
//
//        // Creating Employees
//        Expenses ex1 = new Expenses();
//        ex1.setName("your taxd");
//        ex1.setAmount(19.99);
//        ex1.setCategory("finances");
//        ex1.setDate("1/10/2026");
//
//        Expenses ex2 = new Expenses();
//        ex2.setName("new dog");
//        ex2.setAmount(170.00);
//        ex2.setDate("1/1/2026");
//        ex2.setCategory("fun");
//
//        ex1.setUsers(users);
//        ex2.setUsers(users);
//
//        users.getExpenses().add(ex1);
//        users.getExpenses().add(ex2);
//
//        em.persist(users);
//        em.persist(ex1);
//        em.persist(ex2);
//
//        em.getTransaction().commit();
//
//        em.close();
//        emf.close();
//    }
//
//}