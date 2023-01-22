package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.Part;
import com.example.BazyDanych2.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parts/")
public class PartController {
    private final PartService partService;
@Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/getAll")
    public List<Part> getAllParts(){
        return partService.getAllParts();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Part> getPartById(@PathVariable Long id){

        return ResponseEntity.ok(partService.getPartById(id));
    }

    @PostMapping(path = "/post")
    public ResponseEntity<Part> addPart(@RequestBody Part part){

        return new ResponseEntity(partService.createPart(part),HttpStatusCode.valueOf(201));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Part> updatePart(@RequestBody Part part,@PathVariable Long id){
        part.setId(id);
        return ResponseEntity.ok(partService.updatePart(part));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletePart(@PathVariable("id") Long id){

        return new ResponseEntity(partService.deletePart(id),HttpStatusCode.valueOf(204));

    }
}
