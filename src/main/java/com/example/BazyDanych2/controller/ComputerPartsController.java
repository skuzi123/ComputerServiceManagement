package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.ComputerParts;
import com.example.BazyDanych2.service.ComputerPartsService;
import com.example.BazyDanych2.service.ComputerService;
import com.example.BazyDanych2.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computerParts/")
public class ComputerPartsController {
    private final ComputerPartsService computerPartsService;
    private final PartService partService;

    private final ComputerService computerService;

    @Autowired
    public ComputerPartsController(ComputerPartsService computerPartsService, PartService partService, ComputerService computerService) {
        this.computerPartsService = computerPartsService;
        this.partService = partService;
        this.computerService = computerService;
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

        return new ResponseEntity(computerPartsService.createComputerParts(computerParts),HttpStatusCode.valueOf(201));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ComputerParts> updateComputerParts(@RequestBody ComputerParts computerParts,@PathVariable Long id){
        computerParts.setId(id);
        return ResponseEntity.ok(computerPartsService.updateComputerParts(computerParts));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteComputerParts(@PathVariable("id") Long id){

        return new ResponseEntity(computerPartsService.deleteComputerParts(id),HttpStatusCode.valueOf(204));

    }
}
