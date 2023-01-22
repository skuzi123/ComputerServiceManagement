package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.Computer;
import com.example.BazyDanych2.service.ComputerService;
import com.example.BazyDanych2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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

        return new ResponseEntity(computerService.createComputer(computer), HttpStatusCode.valueOf(201));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Computer> updateComputer(@RequestBody Computer computer,@PathVariable Long id){
        computer.setId(id);
        return ResponseEntity.ok(computerService.updateComputer(computer));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteComputer(@PathVariable("id") Long id){

        return new ResponseEntity(computerService.deleteComputer(id),HttpStatusCode.valueOf(204));

    }
}
