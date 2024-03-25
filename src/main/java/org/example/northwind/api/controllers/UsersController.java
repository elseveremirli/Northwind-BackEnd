package org.example.northwind.api.controllers;

import jakarta.validation.Valid;
import org.example.northwind.business.abstracts.UserService;
import org.example.northwind.core.entities.User;
import org.example.northwind.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users/")
@CrossOrigin
public class UsersController {
    private UserService userService;
    @Autowired
    public UsersController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.add(user));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValditionException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Dogrulama Hatalari");
        return errors;
    }

    @GetMapping("findByEmail")
    public DataResult<User> findByEmail(@RequestParam String email) {
        return new SuccessDataResult<User>(userService.findByEmail(email),"Result");
    }
}
