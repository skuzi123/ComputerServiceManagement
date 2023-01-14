package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Price;
import com.example.BazyDanych2.Model.Repair;
import com.example.BazyDanych2.Services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repairs/")
public class RepairController {
    private final RepairService repairService;
@Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping("/getAll")
    public List<Repair> getAllRepairs(){
        return repairService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Repair> getRepairById(@PathVariable Long id){

        return ResponseEntity.ok(repairService.getRepairById(id));
    }

    @PostMapping(path = "/post")
    public ResponseEntity<Repair> addRepair(@RequestBody Repair repair){

        return ResponseEntity.ok(repairService.saveData(repair));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteRepair(@PathVariable("id") Long id){

        return ResponseEntity.ok(repairService.deleteRepair(id));

    }
}
