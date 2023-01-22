package com.example.BazyDanych2.repository;

import com.example.BazyDanych2.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("repairRepository")
public interface RepairRepository extends JpaRepository<Repair,Long> {
        public Optional<Repair> findById(Long id);
}
