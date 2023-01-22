package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.RepairLocation;
import com.example.BazyDanych2.service.RepairLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repairLocations/")
public class RepairLocationController {
    private final RepairLocationService repairLocationService;
@Autowired
    public RepairLocationController(RepairLocationService repairLocationService) {
        this.repairLocationService = repairLocationService;
    }

    @GetMapping("/getAll")
    public List<RepairLocation> getAllRepairLocations(){
        return repairLocationService.getAllRepairLocations();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RepairLocation> getRepairLocationById(@PathVariable Long id){

        return ResponseEntity.ok(repairLocationService.getRepairLocationById(id));
    }

    @PostMapping(path = "/post")
    public ResponseEntity<RepairLocation> addRepairLocation(@RequestBody RepairLocation repairLocation){

        return new ResponseEntity(repairLocationService.createRepairLocation(repairLocation), HttpStatusCode.valueOf(201));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<RepairLocation> updateRepairLocation(@RequestBody RepairLocation repairLocation,@PathVariable Long id){
        repairLocation.setId(id);
        return ResponseEntity.ok(repairLocationService.updateRepairLocation(repairLocation));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteRepairLocation(@PathVariable("id") Long id){

        return new ResponseEntity(repairLocationService.deleteRepairLocation(id),HttpStatusCode.valueOf(204));

    }
}
