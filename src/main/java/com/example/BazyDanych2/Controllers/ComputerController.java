package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.User;
import com.example.BazyDanych2.Model.Computer;
import com.example.BazyDanych2.Services.ComputerService;
import com.example.BazyDanych2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computers/")
public class ComputerController {
    private final ComputerService computerService;
    private final UserService userService;
    @Autowired
    public ComputerController(ComputerService computerService, UserService userService) {
        this.computerService = computerService;
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<Computer> getAllComputer(){
        return computerService.getAllComputers();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Computer> getComputerById(@PathVariable Long id){

        return ResponseEntity.ok(computerService.getComputerById(id));
    }

    @PostMapping(path = "/post")
    public ResponseEntity<Computer> addComputer(@RequestBody Computer computer){
         User user = computer.getUser();
         if(userService.getUserById(user.getId()) == null){
             userService.saveUser(user);
         }
        return ResponseEntity.ok(computerService.saveComputer(computer));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteComputer(@PathVariable("id") Long id){

        return ResponseEntity.ok(computerService.deleteComputer(id));

    }
}
