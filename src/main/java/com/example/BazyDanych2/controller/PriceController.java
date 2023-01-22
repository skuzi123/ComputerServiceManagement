package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.Price;
import com.example.BazyDanych2.service.FaultService;
import com.example.BazyDanych2.service.PriceService;
import com.example.BazyDanych2.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices/")
public class PriceController {
    private final PriceService priceService;
    private final TaxService taxService;
    private final FaultService faultService;
@Autowired
    public PriceController(PriceService priceService, TaxService taxService, FaultService faultService) {
        this.priceService = priceService;
        this.taxService = taxService;
        this.faultService = faultService;
}

    @GetMapping("/getAll")
    public List<Price> getAllPrices(){
        return priceService.getAllPrices();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long id){

        return ResponseEntity.ok(priceService.getPriceById(id));
    }


    @PostMapping(path = "/post")
    public ResponseEntity<Price> addPrice(@RequestBody Price price){
        return new ResponseEntity(priceService.createPrice(price), HttpStatusCode.valueOf(201));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Price> updatePrice(@RequestBody Price price,@PathVariable Long id){
        price.setId(id);
        return ResponseEntity.ok(priceService.updatePrice(price));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletePrice(@PathVariable("id") Long id){

        return new ResponseEntity(priceService.deletePrice(id),HttpStatusCode.valueOf(204));

    }

}
