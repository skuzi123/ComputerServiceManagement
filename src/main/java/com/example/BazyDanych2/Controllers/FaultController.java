package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Fault;
import com.example.BazyDanych2.Services.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/faults/")
public class FaultController {
    private final FaultService faultService;
    @Autowired
    public FaultController(FaultService faultService) {
        this.faultService = faultService;
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Fault>> getAllFaults(){

        return ResponseEntity.ok(faultService.getAll());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Fault> getFaultById(@PathVariable Long id){

        return ResponseEntity.ok(faultService.getFaultById(id));
    }

    @PostMapping(path = "/post")
    public ResponseEntity<Fault> addFault(@RequestBody Fault fault){

        return ResponseEntity.ok(faultService.saveData(fault));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteFault(@PathVariable("id") Long id){

        return ResponseEntity.ok(faultService.deleteFault(id));

    }


}
