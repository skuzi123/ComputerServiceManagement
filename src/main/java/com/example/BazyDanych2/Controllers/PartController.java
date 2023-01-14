package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Part;
import com.example.BazyDanych2.Model.Tax;
import com.example.BazyDanych2.Services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return ResponseEntity.ok(partService.savePart(part));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletePart(@PathVariable("id") Long id){

        return ResponseEntity.ok(partService.deletePart(id));

    }
}
