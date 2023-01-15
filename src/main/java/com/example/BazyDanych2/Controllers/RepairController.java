package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Computer;
import com.example.BazyDanych2.Model.User;
import com.example.BazyDanych2.Model.Fault;
import com.example.BazyDanych2.Model.Repair;
import com.example.BazyDanych2.Model.RepairLocation;
import com.example.BazyDanych2.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping(path = "/post")
//    public ResponseEntity<Repair> addRepair(@RequestBody Repair repair){
//        RepairLocation repairLocation = repair.getRepairLocation();
//        Fault fault = repair.getFault();
//        User user = repair.getUser();
//        Computer computer = repair.getComputer();
//        if(repairLocationService.getRepairLocationById(repairLocation.getId()) == null){
//            repairLocationService.saveRepairLocation(repairLocation);
//        }
//        if(faultService.getFaultById(fault.getId()) == null){
//            faultService.saveData(fault);
//        }
//        if(userService.getUserById(user.getId()) == null){
//            userService.saveUser(user);
//        }
//        if(computerService.getComputerById(computer.getId()) == null){
//            computerService.saveComputer(computer);
//        }
//        return ResponseEntity.ok(repairService.saveData(repair));
//    }

    @PostMapping(path = "/post")
    public ResponseEntity<Repair> addRepair(@RequestBody Repair repair){
        return ResponseEntity.ok(repairService.createData(repair));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Repair> updateRepair(@RequestBody Repair repair){
        return ResponseEntity.ok(repairService.updateData(repair));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteRepair(@PathVariable("id") Long id){

        return ResponseEntity.ok(repairService.deleteRepair(id));

    }
}
