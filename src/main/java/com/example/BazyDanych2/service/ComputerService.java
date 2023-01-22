package com.example.BazyDanych2.service;

import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.Computer;
import com.example.BazyDanych2.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    private static final String COMPUTER_NOT_FOUND = "Computer with this id doesn't exist!!!";
    private ComputerRepository computerRepository;

    @Autowired
    public ComputerService(@Qualifier("computerRepository") ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public List<Computer> getAllComputers(){
        return computerRepository.findAll();
    }

    public Computer getComputerById(Long id){
        try{
            return computerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(COMPUTER_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public Computer getComputerByUserId(Long id){
        try{
            return computerRepository.findByUserId(id).orElseThrow(() -> new RecordNotFoundException(COMPUTER_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public Computer createComputer(Computer computer){
        return computerRepository.saveAndFlush(computer);
    }
    public Computer updateComputer(Computer computer){
        return computerRepository.save(computer);
    }

    public String deleteComputer(Long id){
        Computer computerToDelete = getComputerById(id);
        computerRepository.delete(computerToDelete);
        return "Computer with id: " + id + " was deleted!";
    }

}
