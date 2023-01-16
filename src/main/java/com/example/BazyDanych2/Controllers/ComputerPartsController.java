package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Computer;
import com.example.BazyDanych2.Model.ComputerParts;
import com.example.BazyDanych2.Model.Part;
import com.example.BazyDanych2.Services.ComputerPartsService;
import com.example.BazyDanych2.Services.ComputerService;
import com.example.BazyDanych2.Services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return ResponseEntity.ok(computerPartsService.createComputerParts(computerParts));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ComputerParts> updateComputerParts(@RequestBody ComputerParts computerParts){

        return ResponseEntity.ok(computerPartsService.updateComputerParts(computerParts));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteComputerParts(@PathVariable("id") Long id){

        return ResponseEntity.ok(computerPartsService.deleteComputerParts(id));

    }
}
