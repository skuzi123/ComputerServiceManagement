package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.Tax;
import com.example.BazyDanych2.Services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return ResponseEntity.ok(taxService.saveTax(tax));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteFault(@PathVariable("id") Long id){

        return ResponseEntity.ok(taxService.deleteTax(id));

    }
}
