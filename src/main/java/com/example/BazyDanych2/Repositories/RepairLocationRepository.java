package com.example.BazyDanych2.Repositories;

import com.example.BazyDanych2.Model.RepairLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("repairLocationRepository")
public interface RepairLocationRepository extends JpaRepository<RepairLocation,Long> {
    public Optional<RepairLocation> findById(Long id);
    public Optional<RepairLocation> findByLocationName(String locationName);
}
