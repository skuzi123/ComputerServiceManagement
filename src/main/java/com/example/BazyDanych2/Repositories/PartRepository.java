package com.example.BazyDanych2.Repositories;

import com.example.BazyDanych2.Model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("partRepository")
public interface PartRepository extends JpaRepository<Part,Long> {
    public Optional<Part> findById(Long id);
    public Optional<Part> findByPartName(String partName);

}
