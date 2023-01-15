package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.Tax;
import com.example.BazyDanych2.Repositories.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxService {
    private final TaxRepository taxRepository;

    @Autowired
    public TaxService(@Qualifier("taxRepository") TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }
    public List<Tax> getAll(){
        return taxRepository.findAll();
    }

    public Tax getTaxById(Long id){
        Optional<Tax> foundTax = taxRepository.findById(id);
        return foundTax.orElse(null);
    }

    public Tax saveTax(Tax tax){
        return taxRepository.saveAndFlush(tax);
    }

    public String deleteTax(Long id){
        Tax taxToDelete = getTaxById(id);
        taxRepository.delete(taxToDelete);
        return "Tax with id: " + id + " was deleted!";
    }
}
