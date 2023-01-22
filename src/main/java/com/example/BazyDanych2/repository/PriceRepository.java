package com.example.BazyDanych2.repository;

import com.example.BazyDanych2.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("priceRepository")
public interface PriceRepository extends JpaRepository<Price,Long> {
    public Optional<Price> findById(Long id);
    public Optional<Price> findByFaultId(Long id);

}
