package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.Part;
import com.example.BazyDanych2.Repositories.PartRepository;
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
        Optional<Part> foundPart = partRepository.findById(id);
        return foundPart.orElse(null);
    }

    public Part getPartByPartName(String partName){
        return partRepository.findByPartName(partName)
                .orElseThrow();
    }

    public Part savePart(Part part){
        return partRepository.saveAndFlush(part);
    }

    public String deletePart(Long id){
        Part partToDelete = getPartById(id);
        partRepository.delete(partToDelete);
        return "Part with id: " + id + " was deleted!";
    }
}
