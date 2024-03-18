package org.example.northwind.api.controllers;

import org.example.northwind.business.abstracts.UserService;
import org.example.northwind.core.entities.User;
import org.example.northwind.core.utilities.results.DataResult;
import org.example.northwind.core.utilities.results.Result;
import org.example.northwind.core.utilities.results.SuccessDataResult;
import org.example.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/")
public class UsersController {
    private UserService userService;
    @Autowired
    public UsersController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody User user) {
        return ResponseEntity.ok(userService.add(user));
    }

    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(userService.findByEmail(email),"Result");
    }
}
