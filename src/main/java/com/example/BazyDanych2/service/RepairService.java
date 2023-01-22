package com.example.BazyDanych2.service;

import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.Repair;
import com.example.BazyDanych2.model.RepairState;
import com.example.BazyDanych2.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepairService {
    private static final String REPAIR_NOT_FOUND = "Repair with this id doesn't exist!!!";
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
        try{
            return repairRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(REPAIR_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public int countDataAfterRepairStart(LocalDate date){
        return getAll().stream()
                .filter(n -> n.getRepairStart().isAfter(date))
                .collect(Collectors.toList())
                .size();
    }

    public Repair finishRepair(Long id){
        Repair foundRepair = getRepairById(id);
        foundRepair.setRepairState(RepairState.FINISHED);
        foundRepair.setRepairEnd(LocalDate.now());
        repairRepository.save(foundRepair);
        return foundRepair;
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
