package com.example.BazyDanych2.Repositories;

import com.example.BazyDanych2.Model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("taxRepository")
public interface TaxRepository extends JpaRepository<Tax,Long> {
    public Optional<Tax> findById(Long id);

}
