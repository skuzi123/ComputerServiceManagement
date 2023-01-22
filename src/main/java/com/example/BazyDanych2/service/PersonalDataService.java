package com.example.BazyDanych2.service;

import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.PersonalData;
import com.example.BazyDanych2.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonalDataService {
    private static final String PERSONAL_DATA_NOT_FOUND = "Personal Data with this id doesn't exist!!!";
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
         try{
             return personalDataRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(PERSONAL_DATA_NOT_FOUND));
         }catch(RecordNotFoundException e){
             throw new RuntimeException(e);
         }

     }

    public PersonalData createData(PersonalData personalData){
        return personalDataRepository.saveAndFlush(personalData);
    }

    public PersonalData updateData(PersonalData personalData){
        return personalDataRepository.save(personalData);
    }

    public String deleteData(Long id){
        PersonalData dataToDelete = getDataById(id);
        personalDataRepository.delete(dataToDelete);
        return "Data with id: " + id + " deleted!";
    }

}
