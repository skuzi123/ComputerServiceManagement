package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.PersonalData;
import com.example.BazyDanych2.Model.User;
import com.example.BazyDanych2.Services.PersonalDataService;
import com.example.BazyDanych2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return ResponseEntity.ok(userService.createUser(user));
    }
    @PutMapping(path = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){

        return ResponseEntity.ok(userService.updateUser(user));
    }

//    @PostMapping(path = "/post")
//    public ResponseEntity<User> addUser(@RequestBody User user){
//
//        PersonalData personalData = user.getPersonalData();
//        if (personalDataService.getDataById(personalData.getId()) == null) {
//            personalDataService.saveData(personalData);
//        }
//        return ResponseEntity.ok(userService.saveUser(user));
//    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){

        return ResponseEntity.ok(userService.deleteUser(id));

    }

}
