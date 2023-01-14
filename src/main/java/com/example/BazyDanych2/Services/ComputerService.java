package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.Computer;
import com.example.BazyDanych2.Repositories.ComputerRepository;
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
        Optional<Computer> foundComputer = computerRepository.findById(id);
        return foundComputer.orElseThrow();
    }

    public Computer getComputerByUserId(Long id){
        return computerRepository.findByUserId(id)
                .orElseThrow();
    }

    public Computer saveComputer(Computer computer){
        return computerRepository.saveAndFlush(computer);
    }

    public String deleteComputer(Long id){
        Computer computerToDelete = getComputerById(id);
        computerRepository.delete(computerToDelete);
        return "Computer with id: " + id + " was deleted!";
    }

}
