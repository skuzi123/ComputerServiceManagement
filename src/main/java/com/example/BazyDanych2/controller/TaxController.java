package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.Tax;
import com.example.BazyDanych2.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxes/")
public class TaxController {

    private final TaxService taxService;
   @Autowired
    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping("/getAll")
    public List<Tax> getAllTaxes(){
        return taxService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Tax> getTaxById(@PathVariable Long id){

        return ResponseEntity.ok(taxService.getTaxById(id));
    }

    @PostMapping(path = "/post")
    public ResponseEntity<Tax> addTax(@RequestBody Tax tax){

        return new ResponseEntity(taxService.createTax(tax),HttpStatusCode.valueOf(201));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Tax> updateTax(@RequestBody Tax tax,@PathVariable Long id){
        tax.setId(id);
        return ResponseEntity.ok(taxService.updateTax(tax));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteFault(@PathVariable("id") Long id){

        return new ResponseEntity(taxService.deleteTax(id),HttpStatusCode.valueOf(204));

    }
}
