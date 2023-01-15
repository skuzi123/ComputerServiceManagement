package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.Fault;
import com.example.BazyDanych2.Repositories.FaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaultService {
    private final FaultRepository faultRepository;

    @Autowired
    public FaultService(@Qualifier("faultRepository") FaultRepository faultRepository) {
        this.faultRepository = faultRepository;
    }
    public List<Fault> getAll(){
        return faultRepository.findAll();
    }

    public Fault getFaultById(Long id){
        Optional<Fault> foundFault = faultRepository.findById(id);
        return foundFault.orElse(null);
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
