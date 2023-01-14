package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Computer;
import com.example.BazyDanych2.Model.ComputerParts;
import com.example.BazyDanych2.Services.ComputerPartsService;
import com.example.BazyDanych2.Services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computerParts/")
public class ComputerPartsController {
    private final ComputerPartsService computerPartsService;

    @Autowired
    public ComputerPartsController(ComputerPartsService computerPartsService) {
        this.computerPartsService = computerPartsService;
    }

    @GetMapping("/getAll")
    public List<ComputerParts> getAllComputerParts(){
        return computerPartsService.getAllComputerParts();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ComputerParts> getComputerPartsById(@PathVariable Long id){

        return ResponseEntity.ok(computerPartsService.getComputerPartsById(id));
    }

    @PostMapping(path = "/post")
    public ResponseEntity<ComputerParts> addComputerParts(@RequestBody ComputerParts computerParts){

        return ResponseEntity.ok(computerPartsService.saveComputerParts(computerParts));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteComputerParts(@PathVariable("id") Long id){

        return ResponseEntity.ok(computerPartsService.deleteComputerParts(id));

    }
}
