package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Fault;
import com.example.BazyDanych2.Model.Tax;
import com.example.BazyDanych2.Model.Price;
import com.example.BazyDanych2.Services.FaultService;
import com.example.BazyDanych2.Services.PriceService;
import com.example.BazyDanych2.Services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(priceService.createPrice(price));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Price> updatePrice(@RequestBody Price price){
        return ResponseEntity.ok(priceService.updatePrice(price));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletePrice(@PathVariable("id") Long id){

        return ResponseEntity.ok(priceService.deletePrice(id));

    }

}
