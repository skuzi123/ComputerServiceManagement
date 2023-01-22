package com.example.BazyDanych2.repository;

import com.example.BazyDanych2.model.ComputerParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("computerPartsRepository")
public interface ComputerPartsRepository extends JpaRepository<ComputerParts,Long> {
    public Optional<ComputerParts> findById(Long id);
    public Optional<ComputerParts> findByComputerId(Long id);

}
