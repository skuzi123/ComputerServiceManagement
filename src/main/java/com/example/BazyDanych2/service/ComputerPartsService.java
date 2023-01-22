package com.example.BazyDanych2.service;


import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.ComputerParts;
import com.example.BazyDanych2.repository.ComputerPartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerPartsService {
    private static final String COMPUTER_PART_NOT_FOUND = "Computer part with this id doesn't exist!!!";
    private ComputerPartsRepository computerPartsRepository;

    @Autowired
    public ComputerPartsService(@Qualifier("computerPartsRepository") ComputerPartsRepository computerPartsRepository) {
        this.computerPartsRepository = computerPartsRepository;
    }

    public List<ComputerParts> getAllComputerParts(){
        return computerPartsRepository.findAll();
    }

    public ComputerParts getComputerPartsById(Long id){
        try{
            return computerPartsRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(COMPUTER_PART_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }

    }

    public ComputerParts getComputerPartsByComputerId(Long id){
        try{
            return computerPartsRepository.findByComputerId(id).orElseThrow(() -> new RecordNotFoundException(COMPUTER_PART_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
           }
    }

    public ComputerParts createComputerParts(ComputerParts computerParts){
        return computerPartsRepository.saveAndFlush(computerParts);
    }

    public ComputerParts updateComputerParts(ComputerParts computerParts){
        return computerPartsRepository.save(computerParts);
    }
    public String deleteComputerParts(Long id){
        ComputerParts computerPartsToDelete = getComputerPartsById(id);
        computerPartsRepository.delete(computerPartsToDelete);
        return "Computer Parts with id: " + id + " was deleted!";
    }
}
