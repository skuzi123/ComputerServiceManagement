package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.User;
import com.example.BazyDanych2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {


    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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

        return ResponseEntity.ok(userService.saveUser(user));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){

        return ResponseEntity.ok(userService.deleteUser(id));

    }

}
