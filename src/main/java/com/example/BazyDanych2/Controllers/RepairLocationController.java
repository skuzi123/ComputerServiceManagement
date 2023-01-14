package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Repair;
import com.example.BazyDanych2.Model.RepairLocation;
import com.example.BazyDanych2.Services.RepairLocationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<RepairLocation> addRepair(@RequestBody RepairLocation repairLocation){

        return ResponseEntity.ok(repairLocationService.saveRepairLocation(repairLocation));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteRepairLocation(@PathVariable("id") Long id){

        return ResponseEntity.ok(repairLocationService.deleteRepairLocation(id));

    }
}
