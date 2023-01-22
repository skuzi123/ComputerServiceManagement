package com.example.BazyDanych2.service;

import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.Fault;
import com.example.BazyDanych2.repository.FaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaultService {
    private static final String FAULT_NOT_FOUND = "Fault with this id doesn't exist!!!";
    private final FaultRepository faultRepository;

    @Autowired
    public FaultService(@Qualifier("faultRepository") FaultRepository faultRepository) {
        this.faultRepository = faultRepository;
    }
    public List<Fault> getAll(){
        return faultRepository.findAll();
    }

    public Fault getFaultById(Long id){
        try{
            return faultRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(FAULT_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public Fault createData(Fault fault){
        return faultRepository.saveAndFlush(fault);
    }

    public Fault updateData(Fault fault){
        return faultRepository.save(fault);
    }

    public String deleteFault(Long id){
        Fault faultToDelete = getFaultById(id);
        faultRepository.delete(faultToDelete);
        return "Fault with id: " + id + " was deleted!";
    }
}
