package com.sean.ExpenseTracker.Controller;

import com.sean.ExpenseTracker.Services.UsersService;
import com.sean.ExpenseTracker.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UsersService usersService;
    ///use this to encrypt password


    @Autowired
    public UserController(UsersService usersService){
        this.usersService = usersService;
    }
    @GetMapping()
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping
    public Users createUser(@RequestBody Users users){
        return usersService.saveUser(users);
    }

}
