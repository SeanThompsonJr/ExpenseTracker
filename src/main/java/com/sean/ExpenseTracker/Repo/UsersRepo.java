package com.sean.ExpenseTracker.Repo;

import com.sean.ExpenseTracker.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {
    List<Users> findAllByUserNameIsContaining(String userName);
    Optional<Users> findByEmail(String email);
}
