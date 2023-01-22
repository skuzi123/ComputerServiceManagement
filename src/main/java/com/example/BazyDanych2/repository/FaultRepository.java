package com.example.BazyDanych2.repository;

import com.example.BazyDanych2.model.Fault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("faultRepository")
public interface FaultRepository extends JpaRepository<Fault,Long> {
    public Optional<Fault> findById(Long id);
}
