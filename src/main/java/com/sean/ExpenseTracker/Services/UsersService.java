package com.sean.ExpenseTracker.Services;

import com.sean.ExpenseTracker.Repo.UsersRepo;
import com.sean.ExpenseTracker.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//all we care about here is logic

@Service
public class UsersService {
    private final UsersRepo usersRepo;

    private PasswordService passwordService;
    @Autowired
    public UsersService(UsersRepo usersRepo, PasswordService passwordService){
        this.usersRepo = usersRepo;
        this.passwordService = passwordService;
    }

    /// create
    public Users saveUser(Users users){
        users.setPassword(passwordService.hashPassword(users.getPassword()));
        return usersRepo.save(users);
    }

    /// delete
    public void deleteUser(Long id){
        if(usersRepo.existsById(id)){
            usersRepo.deleteById(id);
        }else{
            throw new RuntimeException("user with id " + id + " not found.");
        }
    }

    /// find/read
    public Optional<Users> findUserById(Long id){
        return usersRepo.findById(id);
    }

    public List<Users> findUserByName(String name){
      return usersRepo.findAllByUserNameIsContaining(name);
    }

    public List<Users> getAllUsers(){
        return  usersRepo.findAll();
    }

}
