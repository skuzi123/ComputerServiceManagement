package com.example.BazyDanych2.service;

import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.RepairLocation;
import com.example.BazyDanych2.repository.RepairLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairLocationService {
    private static final String REPAIR_LOCATION_NOT_FOUND = "Location with this id doesn't exist!!!";
    private RepairLocationRepository repairLocationRepository;

    @Autowired
    public RepairLocationService(@Qualifier("repairLocationRepository") RepairLocationRepository repairLocationRepository) {
        this.repairLocationRepository = repairLocationRepository;
    }

    public List<RepairLocation> getAllRepairLocations(){
        return repairLocationRepository.findAll();
    }

    public RepairLocation getRepairLocationById(Long id){
        try{
            return repairLocationRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(REPAIR_LOCATION_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public RepairLocation getRepairLocationByLocationName(String locationName){
        try{
            return repairLocationRepository.findByLocationName(locationName).orElseThrow(() -> new RecordNotFoundException(REPAIR_LOCATION_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public RepairLocation createRepairLocation(RepairLocation repairLocation){
        return repairLocationRepository.saveAndFlush(repairLocation);
    }

    public RepairLocation updateRepairLocation(RepairLocation repairLocation){
        return repairLocationRepository.save(repairLocation);
    }

    public String deleteRepairLocation(Long id){
        RepairLocation repairLocationToDelete = getRepairLocationById(id);
        repairLocationRepository.delete(repairLocationToDelete);
        return "Repair location with id: " + id + " was deleted!";
    }
}
