package com.example.BazyDanych2.service;

import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.Part;
import com.example.BazyDanych2.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {
    private static final String PART_NOT_FOUND = "Part with this id doesn't exist!!!";
    private PartRepository partRepository;


    @Autowired
    public PartService(@Qualifier("partRepository") PartRepository partRepository) {
        this.partRepository = partRepository;

    }

    public List<Part> getAllParts(){
        return partRepository.findAll();
    }

    public Part getPartById(Long id){
        try{
            return partRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(PART_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }

    }

    public Part getPartByPartName(String partName){
        try{
            return partRepository.findByPartName(partName).orElseThrow(() -> new RecordNotFoundException(PART_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public Part createPart(Part part) {
        return this.partRepository.saveAndFlush(part);
    }

    public Part updatePart(Part part) {
        return this.partRepository.save(part);
    }


    public String deletePart(Long id){
        Part partToDelete = getPartById(id);
        partRepository.delete(partToDelete);
        return "Part with id: " + id + " was deleted!";
    }
}
