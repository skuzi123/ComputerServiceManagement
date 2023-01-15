package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.PersonalData;
import com.example.BazyDanych2.Repositories.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;

    @Autowired
    public PersonalDataService(@Qualifier("personalDataRepository") PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }
     public List<PersonalData> getAll(){
        List<PersonalData> personalData = personalDataRepository.findAll();
        return personalData;
     }

     public PersonalData getDataById(Long id){
         Optional<PersonalData> foundData = personalDataRepository.findById(id);
         return foundData.orElse(null); //throw -> null
     }

    public PersonalData saveData(PersonalData personalData){
        return personalDataRepository.saveAndFlush(personalData);
    }

    public String deleteData(Long id){
        PersonalData dataToDelete = getDataById(id);
        personalDataRepository.delete(dataToDelete);
        return "Data with id: " + id + " deleted!";
    }

}
