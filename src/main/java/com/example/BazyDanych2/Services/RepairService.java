package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.Fault;
import com.example.BazyDanych2.Model.Repair;
import com.example.BazyDanych2.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Repair> getAllEndedRepairs(){
        return repairRepository.findAll().stream()
                .filter(n -> n.getRepairEnd() != null)
                .collect(Collectors.toList());
    }

    public List<Repair> getAllNotEndedRepairs(){
        return repairRepository.findAll().stream()
                .filter(n -> n.getRepairEnd() == null)
                .collect(Collectors.toList());
    }

    public List<Repair> getBackups(){
        return repairRepository.findAll().stream()
                .filter(n -> n.getBackup().equals("yes"))
                .collect(Collectors.toList());
    }

    public List<Repair> getNoBackups(){
        return repairRepository.findAll().stream()
                .filter(n -> n.getBackup().equals("no"))
                .collect(Collectors.toList());
    }

    public Repair getRepairById(Long id){
        Optional<Repair> foundRepair = repairRepository.findById(id);
        return foundRepair.orElse(null);
    }

    public Repair createData(Repair repair){
        return repairRepository.saveAndFlush(repair);
    }

    public Repair updateData(Repair repair){
        return repairRepository.save(repair);
    }

    public String deleteRepair(Long id){
        Repair repairToDelete = getRepairById(id);
        repairRepository.delete(repairToDelete);
        return "Repair with id: " + id + " was deleted!";
    }
}
