package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.Repair;
import com.example.BazyDanych2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/repairs/")
public class RepairController {
    private final RepairService repairService;
    private final RepairLocationService repairLocationService;
    private final FaultService faultService;
    private final UserService userService;
    private final ComputerService computerService;
@Autowired
    public RepairController(RepairService repairService, RepairLocationService repairLocationService, FaultService faultService, UserService userService, ComputerService computerService) {
        this.repairService = repairService;
    this.repairLocationService = repairLocationService;
    this.faultService = faultService;
    this.userService = userService;
    this.computerService = computerService;
}

    @GetMapping("/getAll")
    public List<Repair> getAllRepairs(){
        return repairService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Repair> getRepairById(@PathVariable Long id){

        return ResponseEntity.ok(repairService.getRepairById(id));
    }
    @GetMapping(path = "/getAllEnded")
    public ResponseEntity<List<Repair>> getAllEndedRepairs(){
           return ResponseEntity.ok(repairService.getAllEndedRepairs());
    }
    @GetMapping(path = "/getAllNotEnded")
    public ResponseEntity<List<Repair>> getAllNotEndedRepairs(){
        return ResponseEntity.ok(repairService.getAllNotEndedRepairs());
    }
    @GetMapping(path = "/getBackups")
    public ResponseEntity<List<Repair>> getBackups(){
        return ResponseEntity.ok(repairService.getBackups());
    }
    @GetMapping(path = "/getNoBackups")
    public ResponseEntity<List<Repair>> getNoBackups(){
        return ResponseEntity.ok(repairService.getNoBackups());
    }
    @GetMapping(path = "/funkcja")
    public ResponseEntity<Integer> getCountDataAfterRepairStart(@RequestBody LocalDate localDate){
        return ResponseEntity.ok(repairService.countDataAfterRepairStart(localDate));
    }
    @PostMapping(path = "/post")
    public ResponseEntity<Repair> addRepair(@RequestBody Repair repair){
        return new ResponseEntity(repairService.createData(repair), HttpStatusCode.valueOf(201));
    }

    @PutMapping(path = "/finish/{id}")
    public ResponseEntity<Repair> finishRepair(@PathVariable("id") Long id){
        return ResponseEntity.ok(repairService.finishRepair(id));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Repair> updateRepair(@RequestBody Repair repair, @PathVariable("id") Long id){
        repair.setId(id);
        return ResponseEntity.ok(repairService.updateData(repair));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteRepair(@PathVariable("id") Long id){

        return new ResponseEntity(repairService.deleteRepair(id),HttpStatusCode.valueOf(204));

    }
}
