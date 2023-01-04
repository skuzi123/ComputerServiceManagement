package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.Fault;
import com.example.BazyDanych2.Model.Repair;
import com.example.BazyDanych2.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairService {
    private final RepairRepository repairRepository;

    @Autowired
    public RepairService(@Qualifier("repairRepository") RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }
    public List<Repair> getAll(){
        return repairRepository.findAll();
    }

    public Repair getRepairById(Long id){
        Optional<Repair> foundRepair = repairRepository.findById(id);
        return foundRepair.orElseThrow();
    }

    public Repair saveData(Repair repair){
        return repairRepository.saveAndFlush(repair);
    }

    public String deleteRepair(Long id){
        Repair repairToDelete = getRepairById(id);
        repairRepository.delete(repairToDelete);
        return "Repair with id: " + id + " was deleted!";
    }
}
