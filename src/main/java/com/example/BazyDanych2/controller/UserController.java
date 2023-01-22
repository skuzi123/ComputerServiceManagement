package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.User;
import com.example.BazyDanych2.service.PersonalDataService;
import com.example.BazyDanych2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {


    private final UserService userService;
    private final PersonalDataService personalDataService;
    @Autowired
    public UserController(UserService userService, PersonalDataService personalDataService) {
        this.userService = userService;
        this.personalDataService = personalDataService;
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<User>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(path = "/{id}")
     public ResponseEntity<User> getUserById(@PathVariable Long id){

      return ResponseEntity.ok(userService.getUserById(id));
    }
    @PostMapping(path = "/post")
    public ResponseEntity<User> addUser(@RequestBody User user){

        return new ResponseEntity(userService.createUser(user), HttpStatusCode.valueOf(201));
    }
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id){
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){

        return new ResponseEntity(userService.deleteUser(id),HttpStatusCode.valueOf(204));

    }

}
