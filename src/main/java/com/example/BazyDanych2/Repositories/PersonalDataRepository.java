package com.example.BazyDanych2.Repositories;

import com.example.BazyDanych2.Model.PersonalData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("personalDataRepository")
public interface PersonalDataRepository extends JpaRepository<PersonalData,Long> {
       public Optional<PersonalData> findById(Long id);


}
