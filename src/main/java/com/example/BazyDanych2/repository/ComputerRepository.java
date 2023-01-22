package com.example.BazyDanych2.repository;

import com.example.BazyDanych2.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("computerRepository")
public interface ComputerRepository extends JpaRepository<Computer,Long> {
    public Optional<Computer> findById(Long id);
    public Optional<Computer> findByUserId(Long id);
}
