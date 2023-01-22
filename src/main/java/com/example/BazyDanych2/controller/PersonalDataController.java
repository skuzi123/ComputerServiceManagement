package com.example.BazyDanych2.controller;

import com.example.BazyDanych2.model.PersonalData;
import com.example.BazyDanych2.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personalData/")
public class PersonalDataController {
    private final PersonalDataService personalDataService;
    @Autowired
    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @GetMapping("/getAll")
    public List<PersonalData> getAllPersonalData(){
        return personalDataService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonalData> getPersonalDataById(@PathVariable Long id){

        return ResponseEntity.ok(personalDataService.getDataById(id));
    }

    @PostMapping(path = "/post")
    public ResponseEntity<PersonalData> addPersonalData(@RequestBody PersonalData personalData){

        return new ResponseEntity(personalDataService.createData(personalData), HttpStatusCode.valueOf(201));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<PersonalData> updatePersonalData(@RequestBody PersonalData personalData,@PathVariable Long id){
        personalData.setId(id);
        return ResponseEntity.ok(personalDataService.updateData(personalData));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletePersonalData(@PathVariable("id") Long id){

        return new ResponseEntity(personalDataService.deleteData(id),HttpStatusCode.valueOf(204));

    }
}
