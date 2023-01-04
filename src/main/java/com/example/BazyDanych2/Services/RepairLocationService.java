package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.RepairLocation;
import com.example.BazyDanych2.Repositories.RepairLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        Optional<RepairLocation> foundRepairLocation = repairLocationRepository.findById(id);
        return foundRepairLocation.orElseThrow();
    }

    public RepairLocation getRepairLocationByLocationName(String locationName){
        return repairLocationRepository.findByLocationName(locationName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(REPAIR_LOCATION_NOT_FOUND)));
    }

    public RepairLocation saveRepairLocation(RepairLocation repairLocation){
        return repairLocationRepository.saveAndFlush(repairLocation);
    }

    public String deleteRepairLocation(Long id){
        RepairLocation repairLocationToDelete = getRepairLocationById(id);
        repairLocationRepository.delete(repairLocationToDelete);
        return "Repair location with id: " + id + " was deleted!";
    }
}
