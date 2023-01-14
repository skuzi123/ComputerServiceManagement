package com.example.BazyDanych2.Services;


import com.example.BazyDanych2.Model.ComputerParts;
import com.example.BazyDanych2.Repositories.ComputerPartsRepository;
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
        Optional<ComputerParts> foundComputersParts = computerPartsRepository.findById(id);
        return foundComputersParts.orElseThrow();
    }

    public ComputerParts getComputerPartsByClientId(Long id){
        return computerPartsRepository.findByComputerId(id)
                .orElseThrow();
    }

    public ComputerParts saveComputerParts(ComputerParts computerParts){
        return computerPartsRepository.saveAndFlush(computerParts);
    }

    public String deleteComputerParts(Long id){
        ComputerParts computerPartsToDelete = getComputerPartsById(id);
        computerPartsRepository.delete(computerPartsToDelete);
        return "Computer Parts with id: " + id + " was deleted!";
    }
}
