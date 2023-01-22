package com.example.BazyDanych2.service;

import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.Tax;
import com.example.BazyDanych2.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxService {
    private static final String TAX_NOT_FOUND = "Tax with this id doesn't exist!!!";
    private final TaxRepository taxRepository;

    @Autowired
    public TaxService(@Qualifier("taxRepository") TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }
    public List<Tax> getAll(){
        return taxRepository.findAll();
    }

    public Tax getTaxById(Long id){
        try{
            return taxRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(TAX_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public Tax createTax(Tax tax){
        return taxRepository.saveAndFlush(tax);
    }

    public Tax updateTax(Tax tax){
        return taxRepository.save(tax);
    }


    public String deleteTax(Long id){
        Tax taxToDelete = getTaxById(id);
        taxRepository.delete(taxToDelete);
        return "Tax with id: " + id + " was deleted!";
    }
}
