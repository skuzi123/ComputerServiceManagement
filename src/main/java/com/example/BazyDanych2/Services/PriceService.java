package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Repositories.PriceRepository;
import com.example.BazyDanych2.Model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
    private static final String PRICE_NOT_FOUND = "Price doesn't exist!!!";
    private PriceRepository priceRepository;
    @Autowired
    public PriceService(@Qualifier("priceRepository") PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrices(){
        return priceRepository.findAll();
    }

    public Price getPriceById(Long id){
        Optional<Price> foundPrice = priceRepository.findById(id);
        return foundPrice.orElse(null);
    }

    public Price getPriceByFaultId(Long id){
        return priceRepository.findByFaultId(id)
                .orElseThrow();
    }

    public Price createPrice(Price price){
        return priceRepository.saveAndFlush(price);
    }

    public Price updatePrice(Price price){
        return priceRepository.save(price);
    }

    public String deletePrice(Long id){
        Price priceToDelete = getPriceById(id);
        priceRepository.delete(priceToDelete);
        return "Price with id: " + id + " was deleted!";
    }
}
