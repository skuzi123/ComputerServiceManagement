package com.example.BazyDanych2.Controllers;

import com.example.BazyDanych2.Model.PersonalData;
import com.example.BazyDanych2.Model.Tax;
import com.example.BazyDanych2.Services.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return ResponseEntity.ok(personalDataService.saveData(personalData));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletePersonalData(@PathVariable("id") Long id){

        return ResponseEntity.ok(personalDataService.deleteData(id));

    }
}
